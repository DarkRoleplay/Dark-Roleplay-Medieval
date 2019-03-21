package net.dark_roleplay.medieval.objects.blocks.decoration.chairs;

import java.util.stream.Stream;

import net.dark_roleplay.medieval.objects.blocks.decoration.chairs.template.ChairBlock;
import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;

public class PlankChairBlock extends ChairBlock{

	public PlankChairBlock(Properties properties) {
		super(properties);

		setShapes(
				Stream.of(
				Block.makeCuboidShape(1.5, 0, 3, 3.5, 7, 5),
				Block.makeCuboidShape(12.5, 0, 3, 14.5, 7, 5),
				Block.makeCuboidShape(12.5, 0, 13, 14.5, 18, 15),
				Block.makeCuboidShape(1.5, 0, 13, 3.5, 18, 15),
				VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2, 5.5, 3.5, 14, 7, 14.5), Block.makeCuboidShape(3, 5.5, 4.5, 13, 7, 13.5), IBooleanFunction.ONLY_FIRST),
				Block.makeCuboidShape(1, 7, 2.5, 15, 8, 15),
				Block.makeCuboidShape(3.5, 11, 13.5, 12.5, 17, 14.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(), 
			Stream.of(
				Block.makeCuboidShape(11, 0, 1.5, 13, 7, 3.5),
				Block.makeCuboidShape(11, 0, 12.5, 13, 7, 14.5),
				Block.makeCuboidShape(1, 0, 12.5, 3, 18, 14.5),
				Block.makeCuboidShape(1, 0, 1.5, 3, 18, 3.5),
				VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1.5, 5.5, 2, 12.5, 7, 14), Block.makeCuboidShape(2.5, 5.5, 3, 11.5, 7, 13), IBooleanFunction.ONLY_FIRST),
				Block.makeCuboidShape(1, 7, 1, 13.5, 8, 15),
				Block.makeCuboidShape(1.5, 11, 3.5, 2.5, 17, 12.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(), 
			Stream.of(
				Block.makeCuboidShape(12.5, 0, 11, 14.5, 7, 13),
				Block.makeCuboidShape(1.5, 0, 11, 3.5, 7, 13),
				Block.makeCuboidShape(1.5, 0, 1, 3.5, 18, 3),
				Block.makeCuboidShape(12.5, 0, 1, 14.5, 18, 3),
				VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2, 5.5, 1.5, 14, 7, 12.5), Block.makeCuboidShape(3, 5.5, 2.5, 13, 7, 11.5), IBooleanFunction.ONLY_FIRST),
				Block.makeCuboidShape(1, 7, 1, 15, 8, 13.5),
				Block.makeCuboidShape(3.5, 11, 1.5, 12.5, 17, 2.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
			Stream.of(
				Block.makeCuboidShape(3, 0, 12.5, 5, 7, 14.5),
				Block.makeCuboidShape(3, 0, 1.5, 5, 7, 3.5),
				Block.makeCuboidShape(13, 0, 1.5, 15, 18, 3.5),
				Block.makeCuboidShape(13, 0, 12.5, 15, 18, 14.5),
				VoxelShapes.combineAndSimplify(Block.makeCuboidShape(3.5, 5.5, 2, 14.5, 7, 14), Block.makeCuboidShape(4.5, 5.5, 3, 13.5, 7, 13), IBooleanFunction.ONLY_FIRST),
				Block.makeCuboidShape(2.5, 7, 1, 15, 8, 15),
				Block.makeCuboidShape(13.5, 11, 3.5, 14.5, 17, 12.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get()
		);
	}

}
