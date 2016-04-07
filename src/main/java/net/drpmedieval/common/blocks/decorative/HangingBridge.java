package net.drpmedieval.common.blocks.decorative;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class HangingBridge extends Block {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyBool EAST = PropertyBool.create("east");

	public HangingBridge() {
		super(Material.wood);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.125F, 1F);
		this.setUnlocalizedName("blockHangingBridge");
		this.setStepSound(Block.soundTypeWood);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}

	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		EntityPlayer entity = (EntityPlayer) placer;
		if(entity != null){
			int dir = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			switch (dir) {
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
		return Blocks.air.getDefaultState();
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

	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		boolean north = false;
		boolean east = false;
		boolean south = false;
		boolean west = false;
		if(state.getValue(FACING).equals(EnumFacing.NORTH)){
			if(worldIn.getBlockState(pos.north()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				north = true;
			}
			if(worldIn.getBlockState(pos.east()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				east = true;
			}
			if(worldIn.getBlockState(pos.south()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				south = true;
			}
			if(worldIn.getBlockState(pos.west()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				west = true;
			}
		}
		else if(state.getValue(FACING).equals(EnumFacing.EAST)){
			if(worldIn.getBlockState(pos.east()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				north = true;
			}
			if(worldIn.getBlockState(pos.south()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				east = true;
			}
			if(worldIn.getBlockState(pos.west()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				south = true;
			}
			if(worldIn.getBlockState(pos.north()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				west = true;
			}
		}
		else if(state.getValue(FACING).equals(EnumFacing.SOUTH)){
			if(worldIn.getBlockState(pos.south()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				north = true;
			}
			if(worldIn.getBlockState(pos.west()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				east = true;
			}
			if(worldIn.getBlockState(pos.north()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				south = true;
			}
			if(worldIn.getBlockState(pos.east()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				west = true;
			}
		}
		else if(state.getValue(FACING).equals(EnumFacing.WEST)){
			if(worldIn.getBlockState(pos.west()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				north = true;
			}
			if(worldIn.getBlockState(pos.north()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				east = true;
			}
			if(worldIn.getBlockState(pos.east()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				south = true;
			}
			if(worldIn.getBlockState(pos.south()).getBlock().equals(DRPMedievalBlocks.hangingBridge)){
				west = true;
			}
		}
		return state.withProperty(NORTH, north).withProperty(EAST, east).withProperty(SOUTH, south).withProperty(WEST, west);
	}

	protected BlockState createBlockState() {

		return new BlockState(this, new IProperty[] {FACING, NORTH, SOUTH, EAST, WEST});
	}

	@Override
	public boolean isFullCube() {

		return false;
	}

	@Override
	public boolean isOpaqueCube() {

		return false;
	}

	// Ground Blocks
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {

		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return true;
	}

	public boolean isSideSolid(IBlockAccess world, BlockPos pos, EnumFacing side) {

		return false;
	}
}
