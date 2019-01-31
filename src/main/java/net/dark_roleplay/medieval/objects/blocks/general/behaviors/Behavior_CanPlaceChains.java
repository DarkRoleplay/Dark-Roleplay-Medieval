package net.dark_roleplay.medieval.objects.blocks.general.behaviors;

import net.dark_roleplay.library.experimental.blocks.behaviors.IPlacementBehavior;
import net.dark_roleplay.medieval.holders.MedievalBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behavior_CanPlaceChains implements IPlacementBehavior{

	@Override
	public boolean execute(World world, BlockPos pos, EnumFacing side) {
		IBlockState state = world.getBlockState(pos.up());
		return state.isSideSolid(world, pos.up(), EnumFacing.DOWN) || state.getBlock() == MedievalBlocks.CHAIN;
	}

}
