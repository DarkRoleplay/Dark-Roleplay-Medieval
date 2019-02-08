package net.dark_roleplay.medieval.objects.blocks.utility.storage.chests.simple_chest;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.IS_OPEN;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.holders.MedievalASMHolder;
import net.dark_roleplay.medieval.holders.MedievalBlockProperties;
import net.dark_roleplay.medieval.holders.MedievalGuis;
import net.dark_roleplay.medieval.objects.blocks.general.FacedBlock;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class SimpleChest extends FacedBlock {

	public SimpleChest (String name, BlockSettings settings) {
		super(name, settings);
		this.setDefaultState(this.getDefaultState().withProperty(MedievalBlockProperties.IS_OPEN, false));
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (state.getValue(FACING_HORIZONTAL) == EnumFacing.NORTH)
			return new AxisAlignedBB(0F, 0F, 0.09375F, 1F, 0.875F, 0.90625F);
		else if (state.getValue(FACING_HORIZONTAL) == EnumFacing.EAST)
			return new AxisAlignedBB(0.09375F, 0F, 0F, 0.90625F, 0.875F, 1F);
		else if (state.getValue(FACING_HORIZONTAL) == EnumFacing.SOUTH)
			return new AxisAlignedBB(0F, 0F, 0.09375F, 1F, 0.875F, 0.90625F);
		else if (state.getValue(FACING_HORIZONTAL) == EnumFacing.WEST)
			return new AxisAlignedBB(0.09375F, 0F, 0F, 0.90625F, 0.875F, 1F);
		return null;
	}


	@Override
	protected ExtendedBlockState createBlockState() {
		return new ExtendedBlockState(this, new IProperty[] { FACING_HORIZONTAL, IS_OPEN, Properties.StaticProperty },
				new IUnlistedProperty[] { Properties.AnimationProperty });
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		return state.withProperty(Properties.StaticProperty, true);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.byHorizontalIndex(meta % 4)).withProperty(IS_OPEN, meta / 4 > 0);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex() + (state.getValue(IS_OPEN) ? 4 : 0);
	}


	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//		this.setDefaultState(this.getDefaultState().withProperty(BlockProperties.IS_OPEN, false));

		TileEntity tileentity = world.getTileEntity(pos);
		if (tileentity instanceof TileEntitySimpleChest) {
			TileEntitySimpleChest chest = (TileEntitySimpleChest) tileentity;
			if(state.getValue(IS_OPEN) && !player.isSneaking()) {
				if (!world.isRemote)
					player.openGui(DarkRoleplayMedieval.INSTANCE, MedievalGuis.GUI_GENERAL_STORAGE, world, pos.getX(), pos.getY(), pos.getZ());
			}else {
				if(world.isRemote) {
					if(state.getValue(IS_OPEN)) {
						chest.goToAnimation(MedievalASMHolder.SimpleChest.CLOSING);
						Minecraft.getMinecraft().world.playSound(pos, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.6F, 1F, true);
					}else {
						chest.goToAnimation(MedievalASMHolder.SimpleChest.OPENING);
						Minecraft.getMinecraft().world.playSound(pos, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.6F, 1F, true);
					}
				}
				world.setBlockState(pos, state.withProperty(IS_OPEN, !state.getValue(IS_OPEN)));
			}
		}
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

		TileEntity tileEntity = worldIn.getTileEntity(pos);

		if (tileEntity instanceof TileEntitySimpleChest) {
			TileEntitySimpleChest tileentityChest = (TileEntitySimpleChest) tileEntity;
			ItemStackHandler handler = (ItemStackHandler) tileentityChest.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

			EntityItem entityItem;
			for(int i = 0; i < handler.getSlots(); i++) {
				ItemStack stack = handler.getStackInSlot(i);

				if(!stack.isEmpty()) {
					entityItem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
					entityItem.setDefaultPickupDelay();
					worldIn.spawnEntity(entityItem);
				}
			}
		}

		super.breakBlock(worldIn, pos, state);
	}
}
