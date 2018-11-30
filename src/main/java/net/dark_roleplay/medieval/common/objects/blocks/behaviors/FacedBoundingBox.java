package net.dark_roleplay.medieval.common.objects.blocks.behaviors;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING_HORIZONTAL;

import net.dark_roleplay.library.experimental.blocks.behaviors.IBoundingBoxBehavior;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class FacedBoundingBox implements IBoundingBoxBehavior{

	private AxisAlignedBB northBB;
	private AxisAlignedBB eastBB;
	private AxisAlignedBB southBB;
	private AxisAlignedBB westBB;

	public FacedBoundingBox(AxisAlignedBB northBB) {

		this.northBB = northBB;
		this.westBB = this.rotateAABB(this.northBB, 1);
		this.southBB = this.rotateAABB(this.northBB, 2);
		this.eastBB = this.rotateAABB(this.northBB, 3);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		switch(state.getValue(FACING_HORIZONTAL)){
		case EAST:
			return this.eastBB;
		case NORTH:
			return this.northBB;
		case SOUTH:
			return this.southBB;
		case WEST:
			return this.westBB;
		default:
			return this.northBB;
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
