package net.drpmedieval.common.blocks.decorative;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.helper.RopeFixPoint;
import net.drpmedieval.common.blocks.tileentitys.TileEntityRopeAnchor;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RopeAnchor extends BlockContainer implements RopeFixPoint {

	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");

	public RopeAnchor() {
		super(Material.wood);
		this.setUnlocalizedName("blockRopeAnchor");
		this.setBlockBounds(0.375F, 0F, 0.375F, 0.625F, 0.3125F, 0.625F);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
	}

	public IBlockState getStateFromMeta(int meta) {

		return this.getDefaultState();
	}

	public int getMetaFromState(IBlockState state) {

		return 0;
	}

	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		Boolean North = worldIn.getBlockState(pos.add(0, -1, -1)).getBlock().equals(DRPMedievalBlocks.rope);
		Boolean East = worldIn.getBlockState(pos.add(1, -1, 0)).getBlock().equals(DRPMedievalBlocks.rope);
		Boolean South = worldIn.getBlockState(pos.add(0, -1, 1)).getBlock().equals(DRPMedievalBlocks.rope);
		Boolean West = worldIn.getBlockState(pos.add(-1, -1, 0)).getBlock().equals(DRPMedievalBlocks.rope);

		return state.withProperty(NORTH, North).withProperty(EAST, East).withProperty(SOUTH, South).withProperty(WEST, West);
	}

	protected BlockState createBlockState() {

		return new BlockState(this, new IProperty[] {NORTH, EAST, SOUTH, WEST});
	}

	@Override
	public boolean isFullCube() {

		return false;
	}

	@Override
	public boolean isOpaqueCube() {

		return false;
	}

	public int getRenderType() {

		return -1;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {

		return new TileEntityRopeAnchor();
	}

	@Override
	public boolean isRopeFixable(World worldIn, BlockPos pos, EnumFacing side) {

		if(side == EnumFacing.NORTH || side == EnumFacing.EAST || side == EnumFacing.SOUTH || side == EnumFacing.WEST)
			return true;
		else
			return false;
	}

	@Override
	public BlockPos getPlacementOffset(World world, BlockPos ropeFixPoint, BlockPos rope) {

		if(ropeFixPoint.getY() > rope.getY())
			return rope;
		else
			return rope.add(0, -1, 0);
	}

}
