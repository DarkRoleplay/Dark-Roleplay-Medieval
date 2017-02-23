package net.drpmedieval.common.blocks.decorative.lecterns;

import java.util.List;

import javax.annotation.Nullable;

import net.drpmedieval.common.blocks.helper.EnumAxis;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LargeLectern extends Block{
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	
	public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, 2);

	public LargeLectern(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
		state = state.getActualState(worldIn, pos);
		addCollisionBoxToList(pos, entityBox, collidingBoxes, getBoundingBox(state,worldIn,pos));
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = this.getActualState(state, source, pos);
		if(state.getValue(TYPE) > 0)
			return new AxisAlignedBB(0f,0f,0f,1f,0.5f,1f);
		return new AxisAlignedBB(0.4f, 0f, 0.4f, 0.6f, 1f, 0.6f);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {

		int type = meta / 4;
		meta %= 4;
		
		switch (meta) {
			case 0:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(TYPE, type);
			case 1:
				return this.getDefaultState().withProperty(FACING, EnumFacing.EAST).withProperty(TYPE, type);
			case 2:
				return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(TYPE, type);
			case 3:
				return this.getDefaultState().withProperty(FACING, EnumFacing.WEST).withProperty(TYPE, type);
			default:
				return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH).withProperty(TYPE, type);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		int meta = state.getValue(TYPE) * 4;
		
		
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if(facing.equals(EnumFacing.NORTH)) return meta;
		if(facing.equals(EnumFacing.EAST)) return meta + 1;
		if(facing.equals(EnumFacing.SOUTH)) return meta + 2;
		if(facing.equals(EnumFacing.WEST)) return meta + 3;
		return 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING,TYPE});
	}
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		worldIn.setBlockState(pos.add(0,1,0), state.withProperty(TYPE, 1));
    }
	
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state){
		if(worldIn.getBlockState(pos.add(0,1,0)).getBlock() == this){
			worldIn.setBlockToAir(pos.add(0,1,0));
		}else if(worldIn.getBlockState(pos.add(0,-1,0)).getBlock() == this){
			worldIn.setBlockToAir(pos.add(0,-1,0));
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
}
