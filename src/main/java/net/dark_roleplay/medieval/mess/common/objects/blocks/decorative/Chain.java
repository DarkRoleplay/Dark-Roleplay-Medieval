package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.objects.blocks.templates.FacedBlock;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityChain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Chain extends Block {

	public Chain(String registryName) {
		super(Material.IRON);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setHardness(3F);
		this.setSoundType(SoundType.METAL);
	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0.375F, 0F, 0.375F, 0.625F, 1F, 0.625F);
    }

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	@Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
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
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos){

		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
				super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		if(worldIn.isSideSolid(pos.offset(EnumFacing.UP), EnumFacing.DOWN))
			return true;
		else if(worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(DRPMedievalBlocks.CHAIN))
			return true;
		else
			return false;
	}
	
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override	
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		EntityPlayer entity = (EntityPlayer) placer;
		if(!worldIn.isSideSolid(pos.offset(EnumFacing.UP), EnumFacing.DOWN) && !worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(DRPMedievalBlocks.CHAIN)) return Blocks.AIR.getDefaultState();
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
	}
	
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
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityChain();
	}
}
