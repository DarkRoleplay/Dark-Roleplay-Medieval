package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.chairs;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.mess.common.objects.blocks.templates.Chair;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LogBench extends Chair {

	public LogBench(String registryName) {
		super(Material.WOOD, registryName, registryName, 0.1875F);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		boolean isSingle = meta >= 4;
		switch (meta % 4) {
			case 0:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.NORTH).withProperty(BlockProperties.SINGLE, isSingle);
			case 1:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.EAST).withProperty(BlockProperties.SINGLE, isSingle);
			case 2:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.SOUTH).withProperty(BlockProperties.SINGLE, isSingle);
			case 3:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.WEST).withProperty(BlockProperties.SINGLE, isSingle);
			default:
				return this.getDefaultState().withProperty(BlockProperties.FACING, EnumFacing.NORTH).withProperty(BlockProperties.SINGLE, isSingle);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		EnumFacing facing = (EnumFacing) state.getValue(BlockProperties.FACING);
		if(facing.equals(EnumFacing.NORTH)) return state.getValue(BlockProperties.SINGLE) ? 4 : 0;
		if(facing.equals(EnumFacing.EAST)) return state.getValue(BlockProperties.SINGLE) ? 5 : 1;
		if(facing.equals(EnumFacing.SOUTH)) return state.getValue(BlockProperties.SINGLE) ? 6 : 2;
		if(facing.equals(EnumFacing.WEST)) return state.getValue(BlockProperties.SINGLE) ? 7 : 3;
		return 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BlockProperties.FACING, BlockProperties.SINGLE});
	}

	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
		EnumFacing blockFacing = placer.getHorizontalFacing().getOpposite();
		Boolean isSingle = blockFacing.getAxis() == EnumFacing.Axis.Z ? 
				world.getBlockState(pos.east()).getBlock() == this || world.getBlockState(pos.west()).getBlock() == this :
				world.getBlockState(pos.north()).getBlock() == this || world.getBlockState(pos.south()).getBlock() == this;
		
        return this.getDefaultState().withProperty(BlockProperties.FACING, blockFacing).withProperty(BlockProperties.SINGLE, !isSingle);
    }
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos){
		EnumFacing blockFacing = state.getValue(BlockProperties.FACING);
		boolean isSingle = state.getValue(BlockProperties.SINGLE);
		if(blockFacing.getAxis() == EnumFacing.Axis.X) {
			if((world.getBlockState(pos.north()).getBlock() == this || world.getBlockState(pos.south()).getBlock() == this)) {
				if(isSingle)
					world.setBlockState(pos, state.withProperty(BlockProperties.SINGLE, !isSingle));
			}else{
				if(!isSingle)
					world.setBlockState(pos, state.withProperty(BlockProperties.SINGLE, !isSingle));
			}
		}else if(blockFacing.getAxis() == EnumFacing.Axis.Z) {
			if((world.getBlockState(pos.east()).getBlock() == this || world.getBlockState(pos.west()).getBlock() == this)) {
				if(isSingle)
					world.setBlockState(pos, state.withProperty(BlockProperties.SINGLE, !isSingle));
			}else{
				if(!isSingle)
					world.setBlockState(pos, state.withProperty(BlockProperties.SINGLE, !isSingle));
			}
		}
	}

}
