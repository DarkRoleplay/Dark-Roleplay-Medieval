package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative;

import static net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.FACING;
import static net.dark_roleplay.medieval.mess.common.objects.blocks.BlockProperties.IS_TOP;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.mess.common.objects.blocks.templates.FacedBlock;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityTarget;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Target extends FacedBlock {

	public Target(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0F, 0F, 0F, 1F, 1F, 1F);
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {FACING, IS_TOP });
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
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && worldIn.isAirBlock(pos.up())
				&& worldIn.isSideSolid(pos.down(), EnumFacing.UP);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

		if (!this.canBlockStay(worldIn, pos, EnumFacing.UP)) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true)
				|| worldIn.getBlockState(pos.down()).getBlock() == this;
	}

	// -------------------------------------------------- Block Events --------------------------------------------------

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		worldIn.setBlockState(pos.add(0, 1, 0), state.withProperty(IS_TOP, true));
	}

	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.getBlockState(pos.add(0, 1, 0)).getBlock() == this) {
			worldIn.setBlockToAir(pos.add(0, 1, 0));
		} else if (worldIn.getBlockState(pos.add(0, -1, 0)).getBlock() == this) {
			worldIn.setBlockToAir(pos.add(0, -1, 0));
		}
	}

	// -------------------------------------------------- Old Rendering System --------------------------------------------------
	// TODO Old Rendering System


	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityTarget();
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return !state.getValue(IS_TOP);
	}

}
