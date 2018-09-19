package net.dark_roleplay.medieval.common.objects.blocks.old;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.IS_OPEN;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.handler.MedievalGuis;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_DungeonChest;
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

public class DungeonChest extends FacedBlock {

	public DungeonChest (String name, BlockSettings settings) {
		super(name, settings);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (state.getValue(FACING_HORIZONTAL) == EnumFacing.NORTH)
			return new AxisAlignedBB(0.0625F, 0F, 0.125F, 0.9375F, 0.75F, 0.875F);
		else if (state.getValue(FACING_HORIZONTAL) == EnumFacing.EAST)
			return new AxisAlignedBB(0.125F, 0F, 0.0625F, 0.875F, 0.75F, 0.9375F);
		else if (state.getValue(FACING_HORIZONTAL) == EnumFacing.SOUTH)
			return new AxisAlignedBB(0.0625F, 0F, 0.125F, 0.9375F, 0.75F, 0.875F);
		else if (state.getValue(FACING_HORIZONTAL) == EnumFacing.WEST)
			return new AxisAlignedBB(0.125F, 0F, 0.0625F, 0.875F, 0.75F, 0.9375F);
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
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.getHorizontal(meta % 4)).withProperty(IS_OPEN, meta / 4 > 0);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex() + (state.getValue(IS_OPEN) ? 4 : 0);
	}


	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		TileEntity tileentity = world.getTileEntity(pos);
		if (tileentity instanceof TE_DungeonChest) {
			TE_DungeonChest chest = (TE_DungeonChest) tileentity;
			if(state.getValue(IS_OPEN) && !player.isSneaking()) {
				if (!world.isRemote)
					player.openGui(DarkRoleplayMedieval.INSTANCE, MedievalGuis.GUI_GENERAL_STORAGE, world, pos.getX(), pos.getY(), pos.getZ());
			}else {
				if(world.isRemote) {
					if(state.getValue(IS_OPEN)) {
						chest.goToAnimation("closing");
						Minecraft.getMinecraft().world.playSound(pos, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.6F, 1F, true);
					}else {
						chest.goToAnimation("opening");
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

		if (tileEntity instanceof TE_DungeonChest) {
			TE_DungeonChest tileentityChest = (TE_DungeonChest) tileEntity;
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
