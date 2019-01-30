package net.dark_roleplay.medieval.common.objects.barrel;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.IS_CLOSED;

import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.objects.barrel.TileEntityBarrel.StorageType;
import net.dark_roleplay.medieval.holders.MedievalGuis;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidActionResult;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class Barrel extends DRPBlock {

	Material material;

	public Barrel(String name, BlockSettings settings, Material material) {
		super(name, settings);
		this.material = material;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(IS_CLOSED, meta == 1);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(IS_CLOSED) ? 1 : 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, IS_CLOSED);
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(IS_CLOSED, meta == 1);
    }

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		boolean isClosed = state.getValue(IS_CLOSED);
//		 return true;


		if(isClosed) {
			if(player.isSneaking()) {
				for(int i = 0; i < 15; i++)
					world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, pos.getX() + 0.5F, pos.getY() + 1, pos.getZ() + 0.5F, Math.random() - 0.5F, Math.random(), Math.random() - 0.5F, Block.getStateId(state));

				if(world.isRemote) return true;

				world.setBlockState(pos, state.withProperty(IS_CLOSED, false));

				world.playSound(null, pos, this.getSoundType(state, world, pos, null).getBreakSound(), SoundCategory.BLOCKS, 2f, 1F);

			}
		}else {
			if(world.isRemote) return true;

			ItemStack heldItem = player.getHeldItem(hand);
			if(heldItem.getItem().getRegistryName().toString().equals(this.material.getNamed("drpmedieval:%wood%_barrel_lit"))) {
				heldItem.shrink(1);
				if(!world.isRemote) world.setBlockState(pos, state.withProperty(IS_CLOSED, true));
				world.playSound(null, pos, this.getSoundType(state, world, pos, null).getPlaceSound(), SoundCategory.BLOCKS, 2f, 1F);
				return true;
			}

			TileEntity tileEntity = world.getTileEntity(pos);
			if(!(tileEntity instanceof TileEntityBarrel)) return true;
			TileEntityBarrel tileEntityBarrel = (TileEntityBarrel) tileEntity;
			StorageType type = tileEntityBarrel.getStorageType();

			if(type == StorageType.FLUID || type == StorageType.NONE) {
				FluidTank fluid = (FluidTank) tileEntityBarrel.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
				if(player.getHeldItem(hand).hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)) {

					FluidActionResult result = FluidUtil.tryEmptyContainer(player.getHeldItem(hand), fluid, 16000, player, true);
					if(result.isSuccess()) {
						if(!player.capabilities.isCreativeMode)
							player.setHeldItem(hand, result.getResult());
						return true;
					}else {
						result = FluidUtil.tryFillContainer(player.getHeldItem(hand), fluid, 16000, player, true);
						if(result.isSuccess()) {
							if(!player.capabilities.isCreativeMode)
								player.setHeldItem(hand, result.getResult());
							return true;
						}
					}
				}
			}
			if(type == StorageType.ITEMS || type == StorageType.NONE) {
				System.out.println(tileEntity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null));
				player.openGui(DarkRoleplayMedieval.INSTANCE, MedievalGuis.GUI_GENERAL_STORAGE, world, pos.getX(), pos.getY(), pos.getZ());
			}
		}

		return this.enableStats;
	}

    @Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {}

    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune){
    	if(!state.getValue(IS_CLOSED)) super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){}

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        TileEntity tileentity = world.getTileEntity(pos);

        if (tileentity instanceof TileEntityBarrel){
        	TileEntityBarrel tileEntityBarrel = (TileEntityBarrel)tileentity;

        	if(state.getValue(IS_CLOSED)) {
                ItemStack itemstack = new ItemStack(Item.getItemFromBlock(this));
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setTag("BlockEntityTag", tileEntityBarrel.saveToNbt(new NBTTagCompound()));
                nbttagcompound.setBoolean("is_closed", true);
                itemstack.setTagCompound(nbttagcompound);

                spawnAsEntity(world, pos, itemstack);
            }else {
				StorageType storageType = tileEntityBarrel.getStorageType();
				if(storageType == StorageType.ITEMS) {
					IItemHandler inventory = tileEntityBarrel.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
					for(int currentSlot = 0; currentSlot < inventory.getSlots(); currentSlot ++) {
						if(!inventory.getStackInSlot(currentSlot).isEmpty())
							spawnAsEntity(world, pos, inventory.getStackInSlot(currentSlot));
					}
				}
			}

            world.updateComparatorOutputLevel(pos, state.getBlock());
        }

        super.breakBlock(world, pos, state);
    }
}
