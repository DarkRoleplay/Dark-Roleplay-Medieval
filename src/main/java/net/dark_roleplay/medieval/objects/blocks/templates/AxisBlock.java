package net.dark_roleplay.medieval.objects.blocks.templates;

import java.util.EnumMap;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class AxisBlock extends BaseBlock {

	protected static final EnumProperty<Axis> HORIZONTAL_AXIS = BlockStateProperties.HORIZONTAL_AXIS;

	protected final EnumMap<Axis, VoxelShape> shapes = new EnumMap<Axis, VoxelShape>(Axis.class);

	public AxisBlock(Properties properties) {
		super(properties);
	}

	protected void setShapes(VoxelShape x, VoxelShape y) {
		this.shapes.put(Axis.X, x);
		this.shapes.put(Axis.Y, y);
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		Axis axis = state.get(HORIZONTAL_AXIS);
		return shapes.get(state.get(HORIZONTAL_AXIS));
	}

	@Override
	public IBlockState rotate(IBlockState state, Rotation rot) {
		//TODO IMPLEMENT LATER
//		return state.with(HORIZONTAL_AXIS, rot =));
		return state;
	}

	@Override
	public IBlockState mirror(IBlockState state, Mirror mirrorIn) {
		//TODO IMPLEMENT LATER
//		return state.rotate(mirrorIn.toRotation(state.get(HORIZONTAL_FACING)));
		return state;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		builder.add(HORIZONTAL_AXIS);
	}
	
	@Nullable
	@Override
	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		BlockFaceShape shape = context.getWorld().getBlockState(context.getPos().down())
				.getBlockFaceShape(context.getWorld(), context.getPos().down(), EnumFacing.UP);
		if (shape != BlockFaceShape.SOLID)
			return null;

		return this.getDefaultState().with(HORIZONTAL_AXIS, context.getPlacementHorizontalFacing().rotateY().getAxis());
	}
}
