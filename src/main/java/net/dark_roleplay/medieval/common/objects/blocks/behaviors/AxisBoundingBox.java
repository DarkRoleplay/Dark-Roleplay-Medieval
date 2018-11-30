package net.dark_roleplay.medieval.common.objects.blocks.behaviors;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.AXIS_HORIZONTAL;

import net.dark_roleplay.library.experimental.blocks.behaviors.IBoundingBoxBehavior;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class AxisBoundingBox implements IBoundingBoxBehavior{

	private AxisAlignedBB zBB;
	private AxisAlignedBB xBB;

	public AxisBoundingBox(AxisAlignedBB northBB) {

		this.zBB = northBB;
		this.xBB = this.rotateAABB(this.zBB, 1);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch(state.getValue(AXIS_HORIZONTAL)){
		case X:
			return this.xBB;
		case Z:
			return this.zBB;
		default:
			return this.zBB;
		}
	}

	private AxisAlignedBB rotateAABB(AxisAlignedBB bb, int amount){
		switch(amount){
			case 0://NORTH
				return bb;
			case 1://WEST
				return new AxisAlignedBB(bb.maxZ, bb.minY, bb.minX, bb.minZ, bb.maxY, bb.maxX);
			case 2://SOUTH
				return new AxisAlignedBB(1 - bb.maxX, bb.minY, 1 - bb.maxZ, 1 - bb.minX, bb.maxY, 1 - bb.minZ);
			case 3://EAST
				return new AxisAlignedBB(1 - bb.minZ, bb.minY, 1 - bb.maxX, 1 - bb.maxZ, bb.maxY, 1 - bb.minX);
			default:
				return bb;
		}
	}
}
