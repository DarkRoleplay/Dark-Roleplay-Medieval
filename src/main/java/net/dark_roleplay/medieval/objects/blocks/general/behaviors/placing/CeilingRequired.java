package net.dark_roleplay.medieval.objects.blocks.general.behaviors.placing;

import net.dark_roleplay.library.experimental.blocks.behaviors.INeighborChangedBehavior;
import net.dark_roleplay.library.experimental.blocks.behaviors.IPlacementBehavior;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CeilingRequired implements INeighborChangedBehavior, IPlacementBehavior{

	public static final CeilingRequired INSTANCE = new CeilingRequired();

	private CeilingRequired() {}

	@Override
	public boolean execute(World world, BlockPos pos, EnumFacing side) {
		return world.isSideSolid(pos.up(), EnumFacing.DOWN);
	}

	@Override
	public void execute(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		if(pos.getY() + 1 == fromPos.getY() && !world.isSideSolid(fromPos, EnumFacing.DOWN)) {
			world.destroyBlock(pos, true);
		}
	}

}
