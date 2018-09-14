package net.dark_roleplay.medieval.common.objects.blocks.old;

import static net.dark_roleplay.library.experimental.connected_model.ConnectedModelBlockStates.*;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class SimpleTable extends Block{

	//TODO ROTATION
		
	public SimpleTable(String registryName) {
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
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.X);
			case 1:
				return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.Z);
			default:
				return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.X);
		}
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
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
	public int getMetaFromState(IBlockState state) {

		EnumFacing.Axis facing = (EnumFacing.Axis) state.getValue(AXIS_HORIZONTAL);
		if(facing.equals(EnumFacing.Axis.X)) return 0;
		if(facing.equals(EnumFacing.Axis.Z)) return 1;

		return 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, NORTH_LEFT, NORTH_CENTER, NORTH_RIGHT, SOUTH_LEFT, SOUTH_CENTER, SOUTH_RIGHT, CENTER_LEFT, CENTER_RIGHT, AXIS_HORIZONTAL);
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
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
		switch(placer.getHorizontalFacing().getOpposite()){
		case EAST:
		case WEST:
			return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.Z);
		case NORTH:
		case SOUTH:
	        return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.X);
	    default:
	        return this.getDefaultState().withProperty(AXIS_HORIZONTAL, EnumFacing.Axis.X);
		}
    }
	
    @Override
	public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side){
    	if(side == EnumFacing.UP)
    		return true;
    				return false;
    }
}
