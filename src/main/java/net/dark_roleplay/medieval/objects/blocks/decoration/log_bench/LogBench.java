package net.dark_roleplay.medieval.objects.blocks.decoration.log_bench;


import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.*;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.objects.blocks.general.FacedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LogBench extends FacedBlock {

	public LogBench(String name, BlockSettings settings) {
		super(name, settings);
		this.setHardness(2F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		boolean isSingle = meta >= 4;
		switch (meta % 4) {
			case 0:
				return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.NORTH).withProperty(SINGLE, isSingle);
			case 1:
				return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.EAST).withProperty(SINGLE, isSingle);
			case 2:
				return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.SOUTH).withProperty(SINGLE, isSingle);
			case 3:
				return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.WEST).withProperty(SINGLE, isSingle);
			default:
				return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.NORTH).withProperty(SINGLE, isSingle);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		EnumFacing facing = (EnumFacing) state.getValue(FACING_HORIZONTAL);
		if(facing.equals(EnumFacing.NORTH)) return state.getValue(SINGLE) ? 4 : 0;
		if(facing.equals(EnumFacing.EAST)) return state.getValue(SINGLE) ? 5 : 1;
		if(facing.equals(EnumFacing.SOUTH)) return state.getValue(SINGLE) ? 6 : 2;
		if(facing.equals(EnumFacing.WEST)) return state.getValue(SINGLE) ? 7 : 3;
		return 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL, SINGLE});
	}

	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
		EnumFacing blockFacing = placer.getHorizontalFacing().getOpposite();
		Boolean isSingle = blockFacing.getAxis() == EnumFacing.Axis.Z ? 
				world.getBlockState(pos.east()).getBlock() == this || world.getBlockState(pos.west()).getBlock() == this :
				world.getBlockState(pos.north()).getBlock() == this || world.getBlockState(pos.south()).getBlock() == this;
		
        return this.getDefaultState().withProperty(FACING_HORIZONTAL, blockFacing).withProperty(SINGLE, !isSingle);
    }
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos){
		EnumFacing blockFacing = state.getValue(FACING_HORIZONTAL);
		boolean isSingle = state.getValue(SINGLE);
		if(blockFacing.getAxis() == EnumFacing.Axis.X) {
			if((world.getBlockState(pos.north()).getBlock() == this || world.getBlockState(pos.south()).getBlock() == this)) {
				if(isSingle)
					world.setBlockState(pos, state.withProperty(SINGLE, !isSingle));
			}else{
				if(!isSingle)
					world.setBlockState(pos, state.withProperty(SINGLE, !isSingle));
			}
		}else if(blockFacing.getAxis() == EnumFacing.Axis.Z) {
			if((world.getBlockState(pos.east()).getBlock() == this || world.getBlockState(pos.west()).getBlock() == this)) {
				if(isSingle)
					world.setBlockState(pos, state.withProperty(SINGLE, !isSingle));
			}else{
				if(!isSingle)
					world.setBlockState(pos, state.withProperty(SINGLE, !isSingle));
			}
		}
	}

}
