package net.dark_roleplay.medieval.common.objects.blocks.old;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING_HORIZONTAL;

import net.dark_roleplay.medieval.common.handler.MedievalBlocks;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityHangingCauldron;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
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

public class HangingCauldron extends BlockContainer {

	//TODO ROTATION
	public HangingCauldron(String registryName) {
		super(Material.IRON);
		this.setResistance(2000.0F);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return new AxisAlignedBB(0.0625F, 0F, 0.0625F, 0.9375F, 0.75F, 0.9375F);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		switch (meta) {
		case 0:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.NORTH);
		case 1:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.EAST);
		case 2:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.SOUTH);
		case 3:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.WEST);
		default:
			return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.NORTH);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		if(facing.equals(EnumFacing.NORTH)) return 0;
		if(facing.equals(EnumFacing.EAST)) return 1;
		if(facing.equals(EnumFacing.SOUTH)) return 2;
		if(facing.equals(EnumFacing.WEST)) return 3;
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL});
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
		return worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true) || worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(MedievalBlocks.IRON_HOOK);
	}

	// -------------------------------------------------- Block Events --------------------------------------------------
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){

		if(!worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true) && !worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock().equals(MedievalBlocks.IRON_HOOK)) return Blocks.AIR.getDefaultState();
		EntityPlayer entity = (EntityPlayer) placer;
		if(entity != null){
			int dir = MathHelper.floor(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
			switch (dir) {
			case 0:
				return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.NORTH);
			case 1:
				return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.EAST);
			case 2:
				return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.SOUTH);
			case 3:
				return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.WEST);
			default:
				return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.NORTH);
			}
		}
		return Blocks.AIR.getDefaultState();
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
	public TileEntity createNewTileEntity(World world, int meta) {

		return new TileEntityHangingCauldron();
	}
}
