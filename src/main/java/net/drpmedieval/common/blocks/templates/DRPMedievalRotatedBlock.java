package net.drpmedieval.common.blocks.templates;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DRPMedievalRotatedBlock extends DRPMedievalBlock{

	protected AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0F,0F,0F,1F,1F,1F) ;
	protected AxisAlignedBB AABB_EAST = new AxisAlignedBB(0F,0F,0F,1F,1F,1F) ;
	protected AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0F,0F,0F,1F,1F,1F) ;
	protected AxisAlignedBB AABB_WEST = new AxisAlignedBB(0F,0F,0F,1F,1F,1F) ;
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public DRPMedievalRotatedBlock(Material materialIn) {
		super(materialIn);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		switch(state.getValue(FACING)){
			case NORTH:
				return AABB_NORTH;
			case EAST:
				return AABB_EAST;
			case SOUTH:
				return AABB_SOUTH;
			case WEST:
				return AABB_WEST;
			default:
				return NULL_AABB;
		}
    }
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
		case 0:
			return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		case 1:
			return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
		case 2:
			return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
		case 3:
			return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
		default:
			return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		}
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if (facing.equals(EnumFacing.NORTH))
			return 0;
		if (facing.equals(EnumFacing.EAST))
			return 1;
		if (facing.equals(EnumFacing.SOUTH))
			return 2;
		if (facing.equals(EnumFacing.WEST))
			return 3;
		return 0;
	}
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		EntityPlayer entity = (EntityPlayer) placer;
		if (entity != null) {
			int dir = MathHelper.floor((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			switch (dir) {
			case 0:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
			case 1:
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
			case 2:
				return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
			case 3:
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
			default:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
			}
		}

		return Blocks.AIR.getDefaultState();
	}

}
