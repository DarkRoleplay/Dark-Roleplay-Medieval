package net.dark_roleplay.medieval.common.objects.blocks.old;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WorkTable extends Block{

	//TODO ROTATION

    public static final PropertyEnum<EnumAxis> TABLE_AXIS = PropertyEnum.<EnumAxis>create("axis", EnumAxis.class, EnumAxis.X, EnumAxis.Z);
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool EAST = PropertyBool.create("east");


	public WorkTable(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setTranslationKey(registryName);
		this.setHardness(2F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(TABLE_AXIS, EnumAxis.X);
			case 1:
				return this.getDefaultState().withProperty(TABLE_AXIS, EnumAxis.Z);
			default:
				return this.getDefaultState().withProperty(TABLE_AXIS, EnumAxis.X);
		}
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }

	@Override
	public int getMetaFromState(IBlockState state) {

		EnumAxis facing = state.getValue(TABLE_AXIS);
		if(facing.equals(EnumAxis.X)) return 0;
		if(facing.equals(EnumAxis.Z)) return 1;

		return 0;
	}

	@Override
	@Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos){
		boolean west = false, east = false;
		if(state.getValue(TABLE_AXIS) == EnumAxis.X){
			if(world.getBlockState(pos.west()).getBlock() == this)
				west = true;
			if(world.getBlockState(pos.east()).getBlock() == this)
				east = true;
		}else if(state.getValue(TABLE_AXIS) == EnumAxis.Z){
			if(world.getBlockState(pos.north()).getBlock() == this)
				west = true;
			if(world.getBlockState(pos.south()).getBlock() == this)
				east = true;
		}
        return state.withProperty(WEST, west).withProperty(EAST, east);
    }

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {TABLE_AXIS, EAST, WEST});
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
			return this.getDefaultState().withProperty(TABLE_AXIS, EnumAxis.Z);
		case NORTH:
		case SOUTH:
	        return this.getDefaultState().withProperty(TABLE_AXIS, EnumAxis.X);
	    default:
	        return this.getDefaultState().withProperty(TABLE_AXIS, EnumAxis.X);
		}
    }

    @Override
	public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side){
    	if(side == EnumFacing.UP)
    		return true;
    				return false;
    }

	@Override
    public IBlockState withRotation(IBlockState state, Rotation rot){
		EnumAxis axis = state.getValue(TABLE_AXIS);
		switch(rot) {
			case CLOCKWISE_90:
			case COUNTERCLOCKWISE_90:
				axis = axis == EnumAxis.X ? EnumAxis.Z : EnumAxis.X;
				break;
			case CLOCKWISE_180:
			case NONE:
			default:
				break;
		}
        return state.withProperty(TABLE_AXIS, axis);
    }

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) {
        return state;
    }
}
