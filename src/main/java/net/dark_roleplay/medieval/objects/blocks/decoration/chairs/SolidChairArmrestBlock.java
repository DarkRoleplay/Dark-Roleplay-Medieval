package net.dark_roleplay.medieval.objects.blocks.decoration.chairs;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;

public class SolidChairArmrestBlock extends SolidChairBlock {
	
	public SolidChairArmrestBlock(Properties properties) {
		super(properties);
		this.shapes.clear();
		
		setShapes(
				Stream.of(
					Block.makeCuboidShape(1.5, 0, 3, 3.5, 7, 5),
					Block.makeCuboidShape(12.5, 0, 3, 14.5, 7, 5),
					Block.makeCuboidShape(12.5, 0, 13, 14.5, 18, 15),
					Block.makeCuboidShape(1.5, 0, 13, 3.5, 18, 15),
					Block.makeCuboidShape(1, 7, 2.5, 15, 8, 15),
					Block.makeCuboidShape(3.5, 11, 13.5, 12.5, 17, 14.5),
					Block.makeCuboidShape(1.4982501130105916, 7.997374374737585, 3.0043709336656583, 3.4982501130105916, 11.997374374737586, 5.004370933665658),
					Block.makeCuboidShape(12.498250113010592, 7.997374374737585, 3.0043709336656583, 14.498250113010592, 11.997374374737586, 5.004370933665658),
					Block.makeCuboidShape(12.248250113010592, 11.997374374737586, 2.5043709336656583, 14.748250113010592, 12.997374374737586, 13.004370933665658),
					Block.makeCuboidShape(1.2482501130105916, 11.997374374737586, 2.5043709336656583, 3.7482501130105916, 12.997374374737586, 13.004370933665658),
					VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2, 5.5, 3.5, 14, 7, 14.5), Block.makeCuboidShape(3, 5.5, 4.5, 13, 7, 13.5), IBooleanFunction.ONLY_FIRST)
				).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
				Stream.of(
					Block.makeCuboidShape(11, 0, 1.5, 13, 7, 3.5),
					Block.makeCuboidShape(11, 0, 12.5, 13, 7, 14.5),
					Block.makeCuboidShape(1, 0, 12.5, 3, 18, 14.5),
					Block.makeCuboidShape(1, 0, 1.5, 3, 18, 3.5),
					Block.makeCuboidShape(1, 7, 1, 13.5, 8, 15),
					Block.makeCuboidShape(1.5, 11, 3.5, 2.5, 17, 12.5),
					Block.makeCuboidShape(10.995629066334342, 7.997374374737585, 1.4982501130105916, 12.995629066334342, 11.997374374737586, 3.4982501130105916),
					Block.makeCuboidShape(10.995629066334342, 7.997374374737585, 12.498250113010592, 12.995629066334342, 11.997374374737586, 14.498250113010592),
					Block.makeCuboidShape(2.9956290663343417, 11.997374374737586, 12.248250113010592, 13.495629066334342, 12.997374374737586, 14.748250113010592),
					Block.makeCuboidShape(2.9956290663343417, 11.997374374737586, 1.2482501130105916, 13.495629066334342, 12.997374374737586, 3.7482501130105916),
					VoxelShapes.combineAndSimplify(Block.makeCuboidShape(1.5, 5.5, 2, 12.5, 7, 14), Block.makeCuboidShape(2.5, 5.5, 3, 11.5, 7, 13), IBooleanFunction.ONLY_FIRST)
				).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
				Stream.of(
					Block.makeCuboidShape(12.5, 0, 11, 14.5, 7, 13),
					Block.makeCuboidShape(1.5, 0, 11, 3.5, 7, 13),
					Block.makeCuboidShape(1.5, 0, 1, 3.5, 18, 3),
					Block.makeCuboidShape(12.5, 0, 1, 14.5, 18, 3),
					Block.makeCuboidShape(1, 7, 1, 15, 8, 13.5),
					Block.makeCuboidShape(3.5, 11, 1.5, 12.5, 17, 2.5),
					Block.makeCuboidShape(12.501749886989408, 7.997374374737585, 10.995629066334342, 14.501749886989408, 11.997374374737586, 12.995629066334342),
					Block.makeCuboidShape(1.5017498869894084, 7.997374374737585, 10.995629066334342, 3.5017498869894084, 11.997374374737586, 12.995629066334342),
					Block.makeCuboidShape(1.2517498869894084, 11.997374374737586, 2.9956290663343417, 3.7517498869894084, 12.997374374737586, 13.495629066334342),
					Block.makeCuboidShape(12.251749886989408, 11.997374374737586, 2.9956290663343417, 14.751749886989408, 12.997374374737586, 13.495629066334342),
					VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2, 5.5, 1.5, 14, 7, 12.5), Block.makeCuboidShape(3, 5.5, 2.5, 13, 7, 11.5), IBooleanFunction.ONLY_FIRST)
				).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
				Stream.of(
					Block.makeCuboidShape(3, 0, 12.5, 5, 7, 14.5),
					Block.makeCuboidShape(3, 0, 1.5, 5, 7, 3.5),
					Block.makeCuboidShape(13, 0, 1.5, 15, 18, 3.5),
					Block.makeCuboidShape(13, 0, 12.5, 15, 18, 14.5),
					Block.makeCuboidShape(2.5, 7, 1, 15, 8, 15),
					Block.makeCuboidShape(13.5, 11, 3.5, 14.5, 17, 12.5),
					Block.makeCuboidShape(3.0043709336656583, 7.997374374737585, 12.501749886989408, 5.004370933665658, 11.997374374737586, 14.501749886989408),
					Block.makeCuboidShape(3.0043709336656583, 7.997374374737585, 1.5017498869894084, 5.004370933665658, 11.997374374737586, 3.5017498869894084),
					Block.makeCuboidShape(2.5043709336656583, 11.997374374737586, 1.2517498869894084, 13.004370933665658, 12.997374374737586, 3.7517498869894084),
					Block.makeCuboidShape(2.5043709336656583, 11.997374374737586, 12.251749886989408, 13.004370933665658, 12.997374374737586, 14.751749886989408),
					VoxelShapes.combineAndSimplify(Block.makeCuboidShape(3.5, 5.5, 2, 14.5, 7, 14), Block.makeCuboidShape(4.5, 5.5, 3, 13.5, 7, 13), IBooleanFunction.ONLY_FIRST)
				).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get()
			);
		
		setShapesCompartment(
			Stream.of(
				Block.makeCuboidShape(1.5, 0, 3, 3.5, 7, 5),
				Block.makeCuboidShape(12.5, 0, 3, 14.5, 7, 5),
				Block.makeCuboidShape(12.5, 0, 13, 14.5, 18, 15),
				Block.makeCuboidShape(1.5, 0, 13, 3.5, 18, 15),
				Block.makeCuboidShape(1, 7, 2.5, 15, 8, 15),
				Block.makeCuboidShape(3.5, 11, 13.5, 12.5, 17, 14.5),
				Block.makeCuboidShape(1.4982501130105916, 7.997374374737585, 3.0043709336656583, 3.4982501130105916, 11.997374374737586, 5.004370933665658),
				Block.makeCuboidShape(12.498250113010592, 7.997374374737585, 3.0043709336656583, 14.498250113010592, 11.997374374737586, 5.004370933665658),
				Block.makeCuboidShape(12.248250113010592, 11.997374374737586, 2.5043709336656583, 14.748250113010592, 12.997374374737586, 13.004370933665658),
				Block.makeCuboidShape(1.2482501130105916, 11.997374374737586, 2.5043709336656583, 3.7482501130105916, 12.997374374737586, 13.004370933665658),
				Block.makeCuboidShape(6.5, 6.5, 14.5, 9.5, 7, 14.75),
				Block.makeCuboidShape(2, 5.5, 3.5, 14, 7, 14.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
			Stream.of(
				Block.makeCuboidShape(11, 0, 1.5, 13, 7, 3.5),
				Block.makeCuboidShape(11, 0, 12.5, 13, 7, 14.5),
				Block.makeCuboidShape(1, 0, 12.5, 3, 18, 14.5),
				Block.makeCuboidShape(1, 0, 1.5, 3, 18, 3.5),
				Block.makeCuboidShape(1, 7, 1, 13.5, 8, 15),
				Block.makeCuboidShape(1.5, 11, 3.5, 2.5, 17, 12.5),
				Block.makeCuboidShape(10.995629066334342, 7.997374374737585, 1.4982501130105916, 12.995629066334342, 11.997374374737586, 3.4982501130105916),
				Block.makeCuboidShape(10.995629066334342, 7.997374374737585, 12.498250113010592, 12.995629066334342, 11.997374374737586, 14.498250113010592),
				Block.makeCuboidShape(2.9956290663343417, 11.997374374737586, 12.248250113010592, 13.495629066334342, 12.997374374737586, 14.748250113010592),
				Block.makeCuboidShape(2.9956290663343417, 11.997374374737586, 1.2482501130105916, 13.495629066334342, 12.997374374737586, 3.7482501130105916),
				Block.makeCuboidShape(1.25, 6.5, 6.5, 1.5, 7, 9.5),
				Block.makeCuboidShape(1.5, 5.5, 2, 12.5, 7, 14)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
			Stream.of(
				Block.makeCuboidShape(12.5, 0, 11, 14.5, 7, 13),
				Block.makeCuboidShape(1.5, 0, 11, 3.5, 7, 13),
				Block.makeCuboidShape(1.5, 0, 1, 3.5, 18, 3),
				Block.makeCuboidShape(12.5, 0, 1, 14.5, 18, 3),
				Block.makeCuboidShape(1, 7, 1, 15, 8, 13.5),
				Block.makeCuboidShape(3.5, 11, 1.5, 12.5, 17, 2.5),
				Block.makeCuboidShape(12.501749886989408, 7.997374374737585, 10.995629066334342, 14.501749886989408, 11.997374374737586, 12.995629066334342),
				Block.makeCuboidShape(1.5017498869894084, 7.997374374737585, 10.995629066334342, 3.5017498869894084, 11.997374374737586, 12.995629066334342),
				Block.makeCuboidShape(1.2517498869894084, 11.997374374737586, 2.9956290663343417, 3.7517498869894084, 12.997374374737586, 13.495629066334342),
				Block.makeCuboidShape(12.251749886989408, 11.997374374737586, 2.9956290663343417, 14.751749886989408, 12.997374374737586, 13.495629066334342),
				Block.makeCuboidShape(6.5, 6.5, 1.25, 9.5, 7, 1.5),
				Block.makeCuboidShape(2, 5.5, 1.5, 14, 7, 12.5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get(),
			Stream.of(
				Block.makeCuboidShape(3, 0, 12.5, 5, 7, 14.5),
				Block.makeCuboidShape(3, 0, 1.5, 5, 7, 3.5),
				Block.makeCuboidShape(13, 0, 1.5, 15, 18, 3.5),
				Block.makeCuboidShape(13, 0, 12.5, 15, 18, 14.5),
				Block.makeCuboidShape(2.5, 7, 1, 15, 8, 15),
				Block.makeCuboidShape(13.5, 11, 3.5, 14.5, 17, 12.5),
				Block.makeCuboidShape(3.0043709336656583, 7.997374374737585, 12.501749886989408, 5.004370933665658, 11.997374374737586, 14.501749886989408),
				Block.makeCuboidShape(3.0043709336656583, 7.997374374737585, 1.5017498869894084, 5.004370933665658, 11.997374374737586, 3.5017498869894084),
				Block.makeCuboidShape(2.5043709336656583, 11.997374374737586, 1.2517498869894084, 13.004370933665658, 12.997374374737586, 3.7517498869894084),
				Block.makeCuboidShape(2.5043709336656583, 11.997374374737586, 12.251749886989408, 13.004370933665658, 12.997374374737586, 14.751749886989408),
				Block.makeCuboidShape(14.5, 6.5, 6.5, 14.75, 7, 9.5),
				Block.makeCuboidShape(3.5, 5.5, 2, 14.5, 7, 14)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get()
		);
		
		setButtons(
			Block.makeCuboidShape(6.5, 6.5, 14.5, 9.5, 7, 14.75),
			Block.makeCuboidShape(1.25, 6.5, 6.5, 1.5, 7, 9.5),
			Block.makeCuboidShape(6.5, 6.5, 1.25, 9.5, 7, 1.5), 
			Block.makeCuboidShape(14.5, 6.5, 6.5, 14.75, 7, 9.5)
		);
	}
}
