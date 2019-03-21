package net.dark_roleplay.medieval.objects.blocks.templates;

import java.util.EnumMap;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public abstract class HorizontalBlock extends BaseBlock {

	protected static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

	protected final EnumMap<EnumFacing, VoxelShape> shapes = new EnumMap<EnumFacing, VoxelShape>(EnumFacing.class);

	public HorizontalBlock(Properties properties) {
		super(properties);
	}

	protected void setShapes(VoxelShape north, VoxelShape east, VoxelShape south, VoxelShape west) {
		this.shapes.put(EnumFacing.NORTH, north);
		this.shapes.put(EnumFacing.EAST, east);
		this.shapes.put(EnumFacing.SOUTH, south);
		this.shapes.put(EnumFacing.WEST, west);
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		EnumFacing facing = state.get(HORIZONTAL_FACING);
		return shapes.get(state.get(HORIZONTAL_FACING));
	}

	@Override
	public IBlockState rotate(IBlockState state, Rotation rot) {
		return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
	}

	@Override
	public IBlockState mirror(IBlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(HORIZONTAL_FACING)));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		builder.add(HORIZONTAL_FACING);
	}
	
	@Nullable
	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		BlockFaceShape shape = context.getWorld().getBlockState(context.getPos().down())
				.getBlockFaceShape(context.getWorld(), context.getPos().down(), EnumFacing.UP);
		if (shape != BlockFaceShape.SOLID)
			return null;

		return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
}
