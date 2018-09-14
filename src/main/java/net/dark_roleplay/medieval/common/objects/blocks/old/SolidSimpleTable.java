package net.dark_roleplay.medieval.common.objects.blocks.old;

import static net.dark_roleplay.library.experimental.connected_model.ConnectedModelBlockStates.*;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class SolidSimpleTable extends Block{
	
	public SolidSimpleTable(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setHardness(2F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
		this.setDefaultState(
				this.getDefaultState()
				.withProperty(NORTH_LEFT, false)
				.withProperty(NORTH_CENTER, false)
				.withProperty(NORTH_RIGHT, false)
				.withProperty(SOUTH_LEFT, false)
				.withProperty(SOUTH_CENTER, false)
				.withProperty(SOUTH_RIGHT, false)
				.withProperty(CENTER_LEFT, false)
				.withProperty(CENTER_RIGHT, false)
			);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this,  HORIZONTAL);
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
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		IBlockState stateCopy = state;
		
		stateCopy = stateCopy.withProperty(NORTH_LEFT, world.getBlockState(pos.north().west()).getBlock() == this);
		stateCopy = stateCopy.withProperty(NORTH_CENTER, world.getBlockState(pos.north()).getBlock() == this);
		stateCopy = stateCopy.withProperty(NORTH_RIGHT, world.getBlockState(pos.north().east()).getBlock() == this);
		stateCopy = stateCopy.withProperty(SOUTH_LEFT, world.getBlockState(pos.south().west()).getBlock() == this);
		stateCopy = stateCopy.withProperty(SOUTH_CENTER, world.getBlockState(pos.south()).getBlock() == this);
		stateCopy = stateCopy.withProperty(SOUTH_RIGHT, world.getBlockState(pos.south().east()).getBlock() == this);
		stateCopy = stateCopy.withProperty(CENTER_LEFT, world.getBlockState(pos.west()).getBlock() == this);
		stateCopy = stateCopy.withProperty(CENTER_RIGHT, world.getBlockState(pos.east()).getBlock() == this);
		
		return stateCopy;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
    @Deprecated
    public IBlockState getStateFromMeta(int meta){
        return this.getDefaultState();
    }

    public int getMetaFromState(IBlockState state){
    	return 0;
    }
    
    @Override
	public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side){
    	if(side == EnumFacing.UP)
    		return true;
    				return false;
    }
}
