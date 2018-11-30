package net.dark_roleplay.medieval.old;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface RopeFixPoint {

	public boolean isRopeFixable(World worldIn, BlockPos pos, EnumFacing side);

	public BlockPos getPlacementOffset(World world, BlockPos ropeFixPoint, BlockPos rope);
}
