package net.dark_roleplay.medieval.common.objects.blocks.decorative.wall_mounted;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING;

import net.dark_roleplay.medieval.common.objects.blocks.templates.FacedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WallMounted extends FacedBlock{
	
	private AxisAlignedBB northBB;
	private AxisAlignedBB eastBB;
	private AxisAlignedBB southBB;
	private AxisAlignedBB westBB;

	public WallMounted(String registryName, Material materialIn, AxisAlignedBB northBB) {
		super(materialIn);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.northBB = northBB;
		this.westBB = this.rotateAABB(this.northBB, 1);
		this.southBB = this.rotateAABB(this.northBB, 2);
		this.eastBB = this.rotateAABB(this.northBB, 3);

	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		switch(state.getValue(FACING)){
			case NORTH:
				return this.northBB;
			case EAST:
				return this.eastBB;
			case SOUTH:
				return this.southBB;
			case WEST:
				return this.westBB;
			default:
				return this.northBB;
		}
    }
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos){
//		EnumFacing enumfacing = state.getValue(FACING);
//		if(!this.canBlockStay(world, pos, enumfacing)){
//			world.setBlockToAir(pos);
//		}
		super.neighborChanged(state, world, pos, block, fromPos);
	}

	protected boolean canBlockStay(World world, BlockPos pos, EnumFacing facing) {
		return world.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}
	
	@Override
	public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side){
		if(side == EnumFacing.DOWN || side == EnumFacing.UP)
			return false;
		else
			return  world.getBlockState(pos).getBlock().isReplaceable(world, pos) && world.isSideSolid(pos.offset(side.getOpposite()), side, true);
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
	
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
    public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
}
