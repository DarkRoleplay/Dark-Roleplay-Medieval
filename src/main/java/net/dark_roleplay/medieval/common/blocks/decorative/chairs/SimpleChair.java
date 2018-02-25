package net.dark_roleplay.medieval.common.blocks.decorative.chairs;

import java.util.List;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.blocks.templates.Chair;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SimpleChair extends Chair{

	AxisAlignedBB base = new AxisAlignedBB(0.0625F, 0F, 0.0625F, 0.9375F, 0.5F, 0.9375F);
	AxisAlignedBB north = new AxisAlignedBB(0F, 0.5F, 0.815F, 1F, 1.125F, 1F);
	AxisAlignedBB east;
	AxisAlignedBB south;
	AxisAlignedBB west;
	public SimpleChair(String registryName){
		super(Material.WOOD,registryName,registryName , 4 * 0.0625F);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
		this.east = rotateAABB(north, 3);
		this.south = rotateAABB(north, 2);
		this.west = rotateAABB(north, 1);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 1F);
    }

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
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
	public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collisionBoxes, @Nullable Entity entity, boolean p_185477_7_){
		Block.addCollisionBoxToList(pos, entityBox, collisionBoxes, this.base);;
		switch(state.getValue(BlockProperties.FACING)){
			case EAST:
				Block.addCollisionBoxToList(pos, entityBox, collisionBoxes, this.east);;
				break;
			case NORTH:
				Block.addCollisionBoxToList(pos, entityBox, collisionBoxes, this.north);;
				break;
			case SOUTH:
				Block.addCollisionBoxToList(pos, entityBox, collisionBoxes, this.south);;
				break;
			case WEST:		
				Block.addCollisionBoxToList(pos, entityBox, collisionBoxes, this.west);;
				break;
			default:
				break;
		}
	}
}
