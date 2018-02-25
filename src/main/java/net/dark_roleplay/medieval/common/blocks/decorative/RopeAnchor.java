package net.dark_roleplay.medieval.common.blocks.decorative;

import net.dark_roleplay.medieval.common.blocks.helper.RopeFixPoint;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityRopeAnchor;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RopeAnchor extends BlockContainer implements RopeFixPoint {

	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");

	public RopeAnchor(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
		this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
	}
	
	// -------------------------------------------------- Other --------------------------------------------------
	
	@Override
	public boolean isRopeFixable(World worldIn, BlockPos pos, EnumFacing side) {

		if(side == EnumFacing.NORTH || side == EnumFacing.EAST || side == EnumFacing.SOUTH || side == EnumFacing.WEST)
			return true;
		else
			return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	@Override
	public BlockPos getPlacementOffset(World world, BlockPos ropeFixPoint, BlockPos rope) {

		if(ropeFixPoint.getY() > rope.getY())
			return rope;
		else
			return rope.add(0, -1, 0);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.375F, 0F, 0.375F, 0.625F, 0.3125F, 0.625F);
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {

		return this.getDefaultState();
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		return 0;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		Boolean North = worldIn.getBlockState(pos.add(0, -1, -1)).getBlock().equals(DRPMedievalBlocks.ROPE);
		Boolean East = worldIn.getBlockState(pos.add(1, -1, 0)).getBlock().equals(DRPMedievalBlocks.ROPE);
		Boolean South = worldIn.getBlockState(pos.add(0, -1, 1)).getBlock().equals(DRPMedievalBlocks.ROPE);
		Boolean West = worldIn.getBlockState(pos.add(-1, -1, 0)).getBlock().equals(DRPMedievalBlocks.ROPE);

		return state.withProperty(NORTH, North).withProperty(EAST, East).withProperty(SOUTH, South).withProperty(WEST, West);
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {NORTH, EAST, SOUTH, WEST});
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
	// -------------------------------------------------- Block Events --------------------------------------------------
	// -------------------------------------------------- Old Rendering System --------------------------------------------------
	// TODO Old Rendering System
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
		return EnumBlockRenderType.INVISIBLE;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {

		return new TileEntityRopeAnchor();
	}

}
