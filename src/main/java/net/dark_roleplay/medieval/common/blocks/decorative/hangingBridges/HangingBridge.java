package net.dark_roleplay.medieval.common.blocks.decorative.hangingBridges;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.blocks.helper.EnumAxis;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class HangingBridge extends Block {

	public static final PropertyEnum<EnumAxis> AXIS = PropertyEnum.<EnumAxis>create("axis", EnumAxis.class);
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0F, 0F, 0F, 1F, 0.0625F, 1F);
	protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] { HangingBridge.BOTTOM_AABB };

	public HangingBridge(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(1F);
		this.setSoundType(SoundType.WOOD);
	}

	// -------------------------------------------------- Block Data
	// --------------------------------------------------
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return DRPMedievalItems.HANGING_BRIDGE;
    }
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
		state = state.getActualState(worldIn, pos);
		Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, HangingBridge.BOTTOM_AABB);

		if ((state.getValue(HangingBridge.AXIS) == EnumAxis.X) && state.getValue(HangingBridge.WEST).booleanValue()) {
			Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f, 0.875f, 0f, 0.0625f, 1f, 1f));
		}

		if ((state.getValue(HangingBridge.AXIS) == EnumAxis.X) && state.getValue(HangingBridge.EAST).booleanValue()) {
			Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.9375f, 0.875f, 0f, 1f, 1f, 1f));
		}

		if ((state.getValue(HangingBridge.AXIS) == EnumAxis.Z) && state.getValue(HangingBridge.EAST).booleanValue()) {
			Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f, 0.875f, 0.9375f, 1f, 1f, 1f));
		}

		if ((state.getValue(HangingBridge.AXIS) == EnumAxis.Z) && state.getValue(HangingBridge.WEST).booleanValue()) {
			Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f, 0.875f, 0f, 1f, 1f, 0.0625f));
		}
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = this.getActualState(state, source, pos);
		return new AxisAlignedBB(0f, 0f, 0f, 1f, 0.125f, 1f);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		switch (meta) {
		case 0:
			return this.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.X);
		case 1:
			return this.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.Z);
		default:
			return this.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.X);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		if (state.getValue(HangingBridge.AXIS).equals(EnumAxis.X))
			return 0;
		if (state.getValue(HangingBridge.AXIS).equals(EnumAxis.Z))
			return 1;
		return 0;
	}

//	@Override
//	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
//
//		boolean north = true;
//		boolean east = true;
//		boolean south = true;
//		boolean west = true;
//		if (state.getValue(HangingBridge.AXIS).equals(EnumAxis.X)) {
//			if (this.doesBlockAlign(worldIn, pos.north())) {
//				north = false;
//			}
//			if (this.doesBlockAlign(worldIn, pos.east())) {
//				east = false;
//			}
//			if (this.doesBlockAlign(worldIn, pos.south())) {
//				south = false;
//			}
//			if (this.doesBlockAlign(worldIn, pos.west())) {
//				west = false;
//			}
//		} else if (state.getValue(HangingBridge.AXIS).equals(EnumAxis.Z)) {
//			if (this.doesBlockAlign(worldIn, pos.east())) {
//				north = false;
//			}
//			if (this.doesBlockAlign(worldIn, pos.south())) {
//				east = false;
//			}
//			if (this.doesBlockAlign(worldIn, pos.west())) {
//				south = false;
//			}
//			if (this.doesBlockAlign(worldIn, pos.north())) {
//				west = false;
//			}
//		}
//		return state.withProperty(HangingBridge.NORTH, north).withProperty(HangingBridge.EAST, east).withProperty(HangingBridge.SOUTH, south).withProperty(HangingBridge.WEST,
//				west);
//	}

//	private boolean doesBlockAlign(IBlockAccess world, BlockPos pos) {
//		return world.getBlockState(pos).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE)
//				|| world.getBlockState(pos.up()).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE)
//				|| world.getBlockState(pos.down()).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE);
//	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { HangingBridge.AXIS, HangingBridge.NORTH, HangingBridge.SOUTH, HangingBridge.EAST, HangingBridge.WEST });
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	// -------------------------------------------------- Block Placement
	// --------------------------------------------------

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

		if (!this.canBlockStay(worldIn, pos, EnumFacing.UP)) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return true;
	}
	// -------------------------------------------------- Block Events
	// --------------------------------------------------

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		switch (placer.getHorizontalFacing().getOpposite()) {
		case EAST:
		case WEST:
			return this.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.Z);
		case NORTH:
		case SOUTH:
			return this.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.X);
		default:
			return this.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.X);
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//		if(!world.isRemote){
//			boolean axis = state.getValue(AXIS) == EnumAxis.Z;
//			
//			int length = 1;
//			int offsetThis;
//			BlockPos centerPos = pos;
//			if(axis){
//				BlockPos pos2 = pos;
//				while(world.getBlockState(pos2 = pos2.east()).getBlock() == this){
//					length ++;
//				}
//				offsetThis = length -1;
//				pos2 = pos;
//				while(world.getBlockState(pos2 = pos2.west()).getBlock() == this){
//					length ++;
//				}
//				centerPos = new BlockPos(pos.add(length/2 <= offsetThis ? offsetThis - (length/2) : offsetThis - (length/2), 0, 0));
//			}else{
//				BlockPos pos2 = pos;
//				while(world.getBlockState(pos2 = pos2.north()).getBlock() == this){
//					length ++;
//				}
//				offsetThis = length -1;
//				pos2 = pos;
//				while(world.getBlockState(pos2 = pos2.south()).getBlock() == this){
//					length ++;
//				}
//				centerPos = new BlockPos(pos.add(0, 0, length/2 <= offsetThis ? offsetThis - (length/2) : offsetThis - (length/2)));
//			}
//			 int halfLength = length/2;
//			 
//			for(int i = - halfLength; i <= halfLength; i++){
//				
//				boolean dir = i < 0;
//				int hang;
//				int j = dir ? - i :  i;
//				
//				hang = j;
//				
//				if(axis){
//					world.setBlockState(centerPos.add(i, -Math.ceil((float) hang/16), 0), DRPMedievalBlocks.HANGING_BRIDGE_TOP.getDefaultState().withProperty(HangingBridge2.AXIS, state.getValue(AXIS)).withProperty(HangingBridge2.HEIGHT,(hang % 8)));
//				}
//			}
//			
//		}
//		//x²*0.01 - x²*0.09
//		
		return false;
	}
}
