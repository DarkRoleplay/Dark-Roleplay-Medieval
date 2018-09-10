package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative;

import static net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.FACING;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.objects.blocks.templates.FacedBlock;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityShipsWheel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ShipsHelm extends FacedBlock {

	public ShipsHelm(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		if(state.getValue(FACING) == EnumFacing.NORTH)
			return new AxisAlignedBB(0F, 0F, 0.625F, 1F, 1F, 1F);
		else if( state.getValue(FACING) == EnumFacing.EAST )
			return new AxisAlignedBB(0F, 0F, 0F, 0.375F, 1F, 1F);
		else if( state.getValue(FACING) == EnumFacing.SOUTH )
			return new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 0.375F);
		else if( state.getValue(FACING) == EnumFacing.WEST )
			return new AxisAlignedBB(0.625F, 0F, 0F, 1F, 1F, 1F);
		return null;
    }

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
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
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos){

		EnumFacing enumfacing = state.getValue(FACING);

		if(!this.canBlockStay(worldIn, pos, enumfacing)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}

				super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {
		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){

		if(facing.equals(EnumFacing.SOUTH))
			return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
		else if(facing.equals(EnumFacing.WEST))
			return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
		else if(facing.equals(EnumFacing.NORTH))
			return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		else if(facing.equals(EnumFacing.EAST))
			return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
		else
			return Blocks.AIR.getDefaultState();

	}
	
	// -------------------------------------------------- Old Rendering System --------------------------------------------------
	// TODO Old Rendering System
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityShipsWheel();
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
		return EnumBlockRenderType.INVISIBLE;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
}
