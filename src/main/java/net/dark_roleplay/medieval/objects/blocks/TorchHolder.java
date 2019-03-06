package net.dark_roleplay.medieval.objects.blocks;

import net.dark_roleplay.medieval.objects.enums.TorchHolderEnums;
import net.dark_roleplay.medieval.objects.enums.TorchHolderEnums.Torch;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class TorchHolder extends Block {

	private static VoxelShape EMPTY_NORTH = Block.makeCuboidShape(5.75, 1.5, 10.75, 10.25, 9.5, 16);
	private static VoxelShape EMPTY_EAST = Block.makeCuboidShape(0, 1.5, 5.75, 5.25, 9.5, 10.25);
	private static VoxelShape EMPTY_SOUTH = Block.makeCuboidShape(5.75, 1.5, 0, 10.25, 9.5, 5.25);
	private static VoxelShape EMPTY_WEST = Block.makeCuboidShape(10.75, 1.5, 5.75, 16, 9.5, 10.25);

	protected static final EnumProperty<TorchHolderEnums.Addons> ADDONS = EnumProperty.create("addons",
			TorchHolderEnums.Addons.class);
	protected static final EnumProperty<TorchHolderEnums.Torch> TORCH = EnumProperty.create("torch",
			TorchHolderEnums.Torch.class);
	public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

	public TorchHolder(Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		switch ((EnumFacing) state.get(HORIZONTAL_FACING)) {
		case NORTH:
			default:
				return EMPTY_NORTH;
			case SOUTH:
				return EMPTY_SOUTH;
			case WEST:
				return EMPTY_WEST;
			case EAST:
				return EMPTY_EAST;
		}
	}

	@Override
	public int getLightValue(IBlockState state) {
		return state.get(TORCH) == Torch.LIT ? 15 : 0;
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		builder.add(HORIZONTAL_FACING, ADDONS, TORCH);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
