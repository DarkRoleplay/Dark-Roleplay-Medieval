package net.dark_roleplay.medieval.common.objects.blocks.old;

import static net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.FACING;
import static net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.STAIR_TYPE;

import java.util.List;

import javax.annotation.Nullable;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.StairType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DirtStairs extends FacedBlock {

	protected static final AxisAlignedBB AABB_SLAB_TOP = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_SLAB_BOTTOM = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);

	protected static final AxisAlignedBB AABB_QUAD_TOP_NORTH = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_QUAD_TOP_EAST = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_QUAD_TOP_SOUTH = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_QUAD_TOP_WEST = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 1.0D);

	protected static final AxisAlignedBB AABB_TOP_NORTH_EAST = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_TOP_SOUTH_EAST = new AxisAlignedBB(0.5D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_TOP_SOUTH_WEST = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 0.5D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_TOP_NORTH_WEST = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 0.5D);

	public DirtStairs(String name, BlockSettings settings) {
		super(name, settings);
		this.setDefaultState(this.getDefaultState().withProperty(STAIR_TYPE, StairType.STRAIGHT));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, STAIR_TYPE });
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		EnumFacing facing = state.getValue(FACING);
		IBlockState otherBlock = world.getBlockState(pos.offset(facing));
		IBlockState otherBlock2 = world.getBlockState(pos.offset(facing.getOpposite()));
		if (otherBlock.getBlock() == this && otherBlock.getValue(FACING) == facing.rotateY()) {
			return state.withProperty(STAIR_TYPE, StairType.INNER_LEFT);
		} else if (otherBlock.getBlock() == this && otherBlock.getValue(FACING) == facing.rotateYCCW()) {
			return state.withProperty(STAIR_TYPE, StairType.INNER_RIGHT);
		} else if (otherBlock2.getBlock() == this && otherBlock2.getValue(FACING) == facing.rotateY()) {
			return state.withProperty(STAIR_TYPE, StairType.OUTER_LEFT);
		} else if (otherBlock2.getBlock() == this && otherBlock2.getValue(FACING) == facing.rotateYCCW()) {
			return state.withProperty(STAIR_TYPE, StairType.OUTER_RIGHT);
		}

		return state;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState) {
		if (!isActualState) {
			state = this.getActualState(state, world, pos);
		}

		addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_SLAB_BOTTOM);

		EnumFacing facing = state.getValue(FACING).getOpposite();
		
		StairType type = state.getValue(STAIR_TYPE);
		
		if(type == StairType.STRAIGHT|| type == StairType.INNER_LEFT || type == StairType.INNER_RIGHT)
			addCollisionBoxToList(pos, entityBox, collidingBoxes, facing == EnumFacing.NORTH ? AABB_QUAD_TOP_NORTH : facing == EnumFacing.EAST ? AABB_QUAD_TOP_EAST :facing == EnumFacing.SOUTH ? AABB_QUAD_TOP_SOUTH : AABB_QUAD_TOP_WEST);

		if(type == StairType.INNER_LEFT) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, facing == EnumFacing.NORTH ? AABB_TOP_SOUTH_EAST : facing == EnumFacing.EAST ? AABB_TOP_SOUTH_WEST :facing == EnumFacing.SOUTH ? AABB_TOP_NORTH_WEST : AABB_TOP_NORTH_EAST);
		}else if(type == StairType.INNER_RIGHT) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, facing == EnumFacing.NORTH ? AABB_TOP_SOUTH_WEST : facing == EnumFacing.EAST ? AABB_TOP_NORTH_WEST :facing == EnumFacing.SOUTH ? AABB_TOP_NORTH_EAST : AABB_TOP_SOUTH_EAST);
		}else if(type == StairType.OUTER_LEFT) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, facing == EnumFacing.NORTH ? AABB_TOP_NORTH_EAST : facing == EnumFacing.EAST ? AABB_TOP_SOUTH_EAST :facing == EnumFacing.SOUTH ? AABB_TOP_SOUTH_WEST : AABB_TOP_NORTH_WEST);
		}else if(type == StairType.OUTER_RIGHT) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, facing == EnumFacing.NORTH ? AABB_TOP_NORTH_WEST : facing == EnumFacing.EAST ? AABB_TOP_NORTH_EAST :facing == EnumFacing.SOUTH ? AABB_TOP_SOUTH_EAST : AABB_TOP_SOUTH_WEST);
		}
	}

	protected static void addCollisionBoxToList(BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable AxisAlignedBB blockBox) {
		if (blockBox != NULL_AABB) {
			AxisAlignedBB axisalignedbb = blockBox.offset(pos);

			if (entityBox.intersects(axisalignedbb)) {
				collidingBoxes.add(axisalignedbb);
			}
		}
	}
}