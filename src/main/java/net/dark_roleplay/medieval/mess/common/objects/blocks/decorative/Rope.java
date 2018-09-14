package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalSounds;
import net.dark_roleplay.medieval.mess.common.objects.blocks.helper.RopeFixPoint;
import net.dark_roleplay.medieval.mess.common.util.InventoryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class Rope extends Block {

	public static PropertyInteger POSITION = PropertyInteger.create("position", 0, 4);

	public Rope(String registryName) {
		super(Material.CLOTH);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.CLOTH);
	}

	// -------------------------------------------------- Block Data
	// --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (state.getValue(POSITION).intValue() == 0) {
			return new AxisAlignedBB(0.4375F, 0F, 0.4375F, 0.5625F, 1F, 0.5625F);
		} else if (state.getValue(POSITION).intValue() == 1) {
			return new AxisAlignedBB(0.4375F, 0F, 0F, 0.5625F, 1F, 0.125F);
		} else if (state.getValue(POSITION).intValue() == 2) {
			return new AxisAlignedBB(0.875F, 0F, 0.4375F, 1F, 1F, 0.5625F);
		} else if (state.getValue(POSITION).intValue() == 3) {
			return new AxisAlignedBB(0.4375F, 0F, 0.875F, 0.5625F, 1F, 1F);
		} else if (state.getValue(POSITION).intValue() == 4) {
			return new AxisAlignedBB(0F, 0F, 0.4375F, 0.125F, 1F, 0.5625F);
		}
		return null;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }

	@Override
	public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
		return true;
	}

	@Override
	public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing facing) {

		if (world.getBlockState(pos.offset(facing.getOpposite())).getBlock() instanceof RopeFixPoint) {
			RopeFixPoint fixPoint = (RopeFixPoint) world.getBlockState(pos.offset(facing.getOpposite())).getBlock();
			if (fixPoint.isRopeFixable(world, pos.offset(facing), facing)) {
				return true;
			}
		}
		if( facing == EnumFacing.DOWN && world.isSideSolid(pos.up(), facing)){
			return true;
		}
		
		return false;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		return this.getDefaultState().withProperty(POSITION, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		return ((Integer) state.getValue(POSITION)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { POSITION });
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	// -------------------------------------------------- Block Placement
	// --------------------------------------------------

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

		if (!this.canBlockStay(worldIn, pos, EnumFacing.UP)) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return true;
	}
	// -------------------------------------------------- Block Events
	// --------------------------------------------------

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		
		if(worldIn.isRemote){
			return Blocks.AIR.getDefaultState();
		}

		int dir = 0;
		if (facing.equals(facing.UP))
			dir = 0;
		if (facing.equals(facing.SOUTH))
			dir = 1;
		if (facing.equals(facing.WEST))
			dir = 2;
		if (facing.equals(facing.NORTH))
			dir = 3;
		if (facing.equals(facing.EAST))
			dir = 4;

		if (worldIn.getBlockState(pos.offset(facing.getOpposite())).getBlock() instanceof RopeFixPoint) {
			RopeFixPoint fixPoint = (RopeFixPoint) worldIn.getBlockState(pos.offset(facing.getOpposite())).getBlock();
			pos = fixPoint.getPlacementOffset(worldIn, pos.offset(facing.getOpposite()), pos);
			if (placer instanceof EntityPlayer && worldIn.getBlockState(pos).getBlock() == Blocks.AIR){
				if (!((EntityPlayer) placer).capabilities.isCreativeMode){
					((EntityPlayer) placer).inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(Item.getItemFromBlock(DRPMedievalBlocks.ROPE),((EntityPlayer) placer).inventory.mainInventory.toArray(new ItemStack[] {})), 1);
				}

				worldIn.setBlockState(pos, this.getDefaultState().withProperty(POSITION, dir), 3);
			}
			worldIn.playSound(pos.getX() + 0.5F, pos.getY() + 0.5, pos.getZ() + 0.5, this.getSoundType().getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F, true);
			return Blocks.AIR.getDefaultState();
		}
		return this.getDefaultState().withProperty(POSITION, dir);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (player.getHeldItem(hand) != null) {
			if (player.getHeldItem(EnumHand.MAIN_HAND).getItem().equals(Item.getItemFromBlock(DRPMedievalBlocks.ROPE))) {
				for (int i = pos.getY() - 1; i > 0; i--) {
					BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() - (pos.getY() - i), pos.getZ());
					if (world.getBlockState(pos2).getBlock().equals(DRPMedievalBlocks.ROPE)) {
						continue;
					} else if (world.getBlockState(pos2).getBlock().equals(Blocks.AIR)) {
						if (!world.isRemote) {
							world.setBlockState(pos2, state);
							if (!player.capabilities.isCreativeMode)
								player.inventory.decrStackSize(InventoryHelper.getInventorySlotContainItem(
										Item.getItemFromBlock(DRPMedievalBlocks.ROPE),
										player.inventory.mainInventory.toArray(new ItemStack[] {})), 1);
						}
						world.playSound(pos2.getX(), pos2.getY(), pos2.getZ(), this.getSoundType().getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F, true);
						return true;
					} else {
						return true;
					}
				}
			} else {
				if (player.isSneaking()) {
					for (int i = pos.getY() - 1; i > 0; i--) {
						BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() - (pos.getY() - i), pos.getZ());
						if (world.getBlockState(pos2).getBlock().equals(DRPMedievalBlocks.ROPE)) {
							continue;
						} else {
							if (!world.isRemote) {
								BlockPos pos3 = new BlockPos(pos2.getX(), pos2.getY() + 1, pos2.getZ());
								world.setBlockState(pos3, Blocks.AIR.getDefaultState());
								if (!world.isRemote)
									world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ,
											new ItemStack(DRPMedievalBlocks.ROPE, 1)));
							}
							return true;
						}
					}
				}
			}
		}
		return true;
	}
}
