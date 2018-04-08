package net.dark_roleplay.medieval.common.blocks.building.roof;

import net.dark_roleplay.medieval.common.blocks.templates.FacedBlock;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import static net.dark_roleplay.medieval.common.blocks.BlockProperties.*;

public class NormalRoof extends FacedBlock{

	
	public NormalRoof(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
		this.setDefaultState(this.getDefaultState().withProperty(TYPE, StairType.STRAIGHT));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING, TYPE});
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
		EnumFacing facing = state.getValue(FACING);
		IBlockState otherBlock = world.getBlockState(pos.offset(facing));
		IBlockState otherBlock2 = world.getBlockState(pos.offset(facing.getOpposite()));
		if(otherBlock.getBlock() == this && otherBlock.getValue(FACING) == facing.rotateY()) {
	        return state.withProperty(TYPE, StairType.INNER_LEFT);
		}else if(otherBlock.getBlock() == this && otherBlock.getValue(FACING) == facing.rotateYCCW()) {
	        return state.withProperty(TYPE, StairType.INNER_RIGHT);
		}else if(otherBlock2.getBlock() == this && otherBlock2.getValue(FACING) == facing.rotateY()) {
	        return state.withProperty(TYPE, StairType.OUTER_LEFT);
		}else if(otherBlock2.getBlock() == this && otherBlock2.getValue(FACING) == facing.rotateYCCW()) {
	        return state.withProperty(TYPE, StairType.OUTER_RIGHT);
		}
		
        return state;
    }
}
