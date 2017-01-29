package net.drpmedieval.common.blocks.decorative.buckets;

import net.drpmedieval.common.blocks.templates.DRPMedievalRotatedBlock;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Bucket extends DRPMedievalRotatedBlock {

	public Bucket(String registreName) {
		super(Material.WOOD);
		this.setRegistryName(registreName);
		this.setUnlocalizedName(registreName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(1F);
		this.setSoundType(SoundType.WOOD);
		this.AABB_NORTH = new AxisAlignedBB(0.1875F, 0F, 0.1875F, 0.8125F, 0.625F, 0.8125F);
		this.AABB_EAST = new AxisAlignedBB(0.1875F, 0F, 0.1875F, 0.8125F, 0.625F, 0.8125F);
		this.AABB_SOUTH = new AxisAlignedBB(0.1875F, 0F, 0.1875F, 0.8125F, 0.625F, 0.8125F);
		this.AABB_WEST = new AxisAlignedBB(0.1875F, 0F, 0.1875F, 0.8125F, 0.625F, 0.8125F);

	}
	
	// -------------------------------------------------- Block Data --------------------------------------------------
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	// -------------------------------------------------- Rendering --------------------------------------------------

		 @SideOnly(Side.CLIENT)
		 public BlockRenderLayer getBlockLayer()
		 {
			 return BlockRenderLayer.TRANSLUCENT;
		 }
	
	//-------------------------------------------------- Block Placement --------------------------------------------------
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos){

		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
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
		if(!worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true)) return Blocks.AIR.getDefaultState();
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
	}
}
