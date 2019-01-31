package net.dark_roleplay.medieval.objects.blocks.building.double_arch.behaviors;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.PART;

import net.dark_roleplay.library.experimental.blocks.behaviors.IDestroyedBehavior;
import net.dark_roleplay.library.experimental.blocks.behaviors.INeighborChangedBehavior;
import net.dark_roleplay.library.experimental.blocks.behaviors.IPlacedBehavior;
import net.dark_roleplay.library.experimental.blocks.behaviors.IPlacementBehavior;
import net.dark_roleplay.medieval.holders.MedievalBlockProperties.Part;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StoneArchPlacement implements INeighborChangedBehavior, IPlacementBehavior, IPlacedBehavior, IDestroyedBehavior{

	public static final StoneArchPlacement INSTANCE = new StoneArchPlacement();

	private StoneArchPlacement() {}

	@Override
	public boolean execute(World world, BlockPos pos, EnumFacing side) {
		return side != EnumFacing.DOWN && side != EnumFacing.UP && world.isSideSolid(pos.up(), EnumFacing.DOWN) && world.isSideSolid(pos.up(), side) && world.getBlockState(pos.up().offset(side)).getBlock().isReplaceable(world, pos.up().offset(side));
	}

	@Override
	public void execute(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		world.setBlockState(pos.up().offset(state.getValue(FACING_HORIZONTAL)), state.withProperty(PART, Part.TOP));
	}

	@Override
	public void execute(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		Part part = state.getValue(PART);
		if(part == Part.TOP && fromPos.equals(pos.offset(state.getValue(FACING_HORIZONTAL).getOpposite()))) {
			if(!world.isSideSolid(fromPos, state.getValue(FACING_HORIZONTAL)))
				world.destroyBlock(pos, false);
		}else if(part == Part.BOTTOM && fromPos.equals(pos.up())) {
			if(!world.isSideSolid(fromPos, EnumFacing.DOWN))
				world.destroyBlock(pos, true);
		}
	}

	@Override
	public void execute(World world, BlockPos pos, IBlockState state) {
		Part part = state.getValue(PART);
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		if(part == Part.TOP) {
			world.destroyBlock(pos.down().offset(facing.getOpposite()), false);
		}else if(part == Part.BOTTOM) {
			world.destroyBlock(pos.up().offset(facing), false);
		}
	}

}
