package net.drpmedieval.common.blocks.decorative;

import net.drpmedieval.common.blocks.templates.DRPMedievalMaterials;
import net.drpmedieval.common.blocks.tileentitys.TileEntityKeyHanging;
import net.drpmedieval.common.blocks.tileentitys.TileEntityShipsWheel;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ShipsWheel extends BlockContainer {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public ShipsWheel() {
		super(DRPMedievalMaterials.wood);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		this.setUnlocalizedName("blockShipsWheel");
		this.setStepSound(Block.soundTypeWood);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}

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

	public int getMetaFromState(IBlockState state) {

		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if(facing.equals(EnumFacing.NORTH)) return 0;
		if(facing.equals(EnumFacing.EAST)) return 1;
		if(facing.equals(EnumFacing.SOUTH)) return 2;
		if(facing.equals(EnumFacing.WEST)) return 3;
		return 0;
	}

	protected BlockState createBlockState() {

		return new BlockState(this, new IProperty[] {FACING});
	}

	@Override
	public boolean isFullCube() {

		return false;
	}

	@Override
	public boolean isOpaqueCube() {

		return false;
	}

	public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side) {

		return false;
	}

	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if(facing.equals(facing.SOUTH))
			return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
		else if(facing.equals(facing.WEST))
			return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
		else if(facing.equals(facing.NORTH))
			return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		else if(facing.equals(facing.EAST))
			return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
		else
			return Blocks.air.getDefaultState();

	}

	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) {

		if(!worldIn.getBlockState(pos).getBlock().equals(this)) return;
		EnumFacing facing = (EnumFacing) worldIn.getBlockState(pos).getValue(FACING);
		if(facing.equals(EnumFacing.NORTH))
			this.setBlockBounds(0F, 0F, 0.625F, 1F, 1F, 1F);
		else if(facing.equals(EnumFacing.EAST))
			this.setBlockBounds(0F, 0F, 0F, 0.375F, 1F, 1F);
		else if(facing.equals(EnumFacing.SOUTH))
			this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 0.375F);
		else if(facing.equals(EnumFacing.WEST)) this.setBlockBounds(0.625F, 0F, 0F, 1F, 1F, 1F);

	}

	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {

		EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);

		if(!this.canBlockStay(worldIn, pos, enumfacing)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}

		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}

	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {

		this.setBlockBoundsBasedOnState(worldIn, pos);
		return super.getCollisionBoundingBox(worldIn, pos, state);
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos) {

		this.setBlockBoundsBasedOnState(worldIn, pos);
		return super.getSelectedBoundingBox(worldIn, pos);
	}

	// TODO
	public int getRenderType() {

		return -1;
	}

	public TileEntity createNewTileEntity(World world, int meta) {

		return new TileEntityShipsWheel();
	}
}
