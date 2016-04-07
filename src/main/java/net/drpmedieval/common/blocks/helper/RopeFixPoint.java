package net.drpmedieval.common.blocks.helper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public interface RopeFixPoint {

	boolean isRopeFixable(World worldIn, BlockPos pos, EnumFacing side);

	BlockPos getPlacementOffset(World world, BlockPos fixPoint, BlockPos rope);

}
