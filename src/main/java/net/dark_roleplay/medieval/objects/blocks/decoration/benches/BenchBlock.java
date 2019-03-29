package net.dark_roleplay.medieval.objects.blocks.decoration.benches;

import java.util.stream.Stream;

import net.dark_roleplay.medieval.objects.blocks.templates.AxisBlock;
import net.dark_roleplay.medieval.objects.enums.BenchSection;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IWorld;

public class BenchBlock extends AxisBlock{

	  public static final EnumProperty<BenchSection> BENCH_SECTION = EnumProperty.create("section", BenchSection.class);
	
	public BenchBlock(Properties properties) {
		super(properties);
		setShapes(
			Stream.of(
				Block.makeCuboidShape(0, 7, 2, 16, 8.5, 14),
				Block.makeCuboidShape(0, 3, 7, 16, 4, 9),
				Block.makeCuboidShape(0.5, 0, 3, 2, 7, 13),
				Block.makeCuboidShape(14, 0, 3, 15.5, 7, 13)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
			Stream.of(
				Block.makeCuboidShape(2, 7, 0, 14, 8.5, 16),
				Block.makeCuboidShape(7, 3, 0, 9, 4, 16),
				Block.makeCuboidShape(3, 0, 0.5, 13, 7, 2),
				Block.makeCuboidShape(3, 0, 14, 13, 7, 15.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get()
		);
		
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(BENCH_SECTION);
	}
	
	@Override
	public IBlockState updatePostPlacement(IBlockState state, EnumFacing facing, IBlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
		if (facing != EnumFacing.DOWN)
			return state;
		if (facingState.getBlockFaceShape(world, facingPos, EnumFacing.UP) != BlockFaceShape.SOLID)
			return Blocks.AIR.getDefaultState();
		return state;
	}
}
