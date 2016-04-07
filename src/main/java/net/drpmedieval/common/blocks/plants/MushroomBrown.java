package net.drpmedieval.common.blocks.plants;

import java.util.Random;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MushroomBrown extends Block {

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public MushroomBrown() {
		super(Material.plants);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
		this.setUnlocalizedName("blockMushroomBrown");
		this.setStepSound(Block.soundTypeGrass);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}

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
			return Blocks.air.getDefaultState();
	}

	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {

		return null;
	}

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

	protected BlockState createBlockState() {

		return new BlockState(this, new IProperty[] {AGE, FACING});
	}

	@Override
	public boolean isFullCube() {

		return false;
	}

	public boolean isSolidFullCube() {

		return false;
	}

	public boolean isOpaqueCube() {

		return false;
	}

	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {

		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}

	public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side) {

		return false;
	}
}
