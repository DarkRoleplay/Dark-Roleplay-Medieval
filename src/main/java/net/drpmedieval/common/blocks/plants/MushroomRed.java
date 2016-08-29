package net.drpmedieval.common.blocks.plants;

import java.util.Random;

import javax.annotation.Nullable;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MushroomRed extends Block {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public MushroomRed() {
		super(Material.PLANTS);
		this.setRegistryName("MushroomRed");
		this.setUnlocalizedName("MushroomRed");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(false);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0F,0F,0F,1F,0.5F,1F);
    }

	@Override
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	
	@Override	
	public IBlockState getStateFromMeta(int meta) {

		EnumFacing face = EnumFacing.NORTH;

		int age = 0;

		if(meta < 4){
			age = meta;
		}
		else if(meta >= 4 && meta < 8){
			age = meta - 4;
			face = EnumFacing.EAST;
		}
		else if(meta >= 8 && meta < 12){
			age = meta - 8;
			face = EnumFacing.SOUTH;
		}
		else if(meta >= 12 && meta < 16){
			age = meta - 12;
			face = EnumFacing.WEST;
		}

		return this.getDefaultState().withProperty(AGE, age).withProperty(FACING, face);
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		int meta = (Integer) state.getValue(AGE);

		if(state.getValue(FACING).equals(EnumFacing.EAST)){
			meta += 4;
		}
		else if(state.getValue(FACING).equals(EnumFacing.SOUTH)){
			meta += 8;
		}
		else if(state.getValue(FACING).equals(EnumFacing.WEST)){
			meta += 12;
		}

		return meta;
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {AGE, FACING});
	}
	
	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos){
		return true;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
			
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
					
	// -------------------------------------------------- Block Placement --------------------------------------------------
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock){

		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.neighborChanged(state, worldIn, pos, neighborBlock);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
		
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		EnumFacing face = EnumFacing.NORTH;
		Random rnd = new Random();
		int dir = rnd.nextInt(4);

		switch (dir) {
			case 1:
				face = EnumFacing.EAST;
				break;
			case 2:
				face = EnumFacing.SOUTH;
				break;
			case 3:
				face = EnumFacing.WEST;
			default:
				break;
		}

		if(facing.equals(facing.UP) && worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true))
			return this.getDefaultState().withProperty(AGE, 3).withProperty(FACING, face);
		else
			return Blocks.AIR.getDefaultState();
	}
}