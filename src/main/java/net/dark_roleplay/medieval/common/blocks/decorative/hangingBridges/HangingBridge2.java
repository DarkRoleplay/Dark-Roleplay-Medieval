package net.dark_roleplay.medieval.common.blocks.decorative.hangingBridges;

import java.util.List;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.blocks.helper.EnumAxis;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class HangingBridge2 extends Block {

	public static final PropertyEnum<EnumAxis> AXIS = PropertyEnum.<EnumAxis>create("axis", EnumAxis.class);
	public static final PropertyInteger HEIGHT = PropertyInteger.create("height", 0, 7);
	
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyBool EAST = PropertyBool.create("east");
	
	public static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0F, 0F, 0F, 1F, 0.125F, 1F);

	private float initialOffset = 0F;
	
	public HangingBridge2(String registryName, float initialOffset) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setSoundType(SoundType.WOOD);
		this.initialOffset = initialOffset;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_){
        state = state.getActualState(worldIn, pos);
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, HangingBridge2.BOTTOM_AABB.move(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge2.HEIGHT)) + this.initialOffset, 0F)));

        if((state.getValue(HangingBridge2.AXIS) == EnumAxis.X) && state.getValue(HangingBridge2.WEST).booleanValue()){
        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0f,0.0625f,1f,1f).move(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge2.HEIGHT)) + this.initialOffset, 0F)));
        }
        
        if((state.getValue(HangingBridge2.AXIS) == EnumAxis.X) && state.getValue(HangingBridge2.EAST).booleanValue()){
        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.9375f,0.875f,0f,1f,1f,1f).move(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge2.HEIGHT)) + this.initialOffset, 0F)));
        }
        
        if((state.getValue(HangingBridge2.AXIS) == EnumAxis.Z) && state.getValue(HangingBridge2.EAST).booleanValue()){
        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0.9375f,1f,1f,1f).move(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge2.HEIGHT)) + this.initialOffset, 0F)));
        }
        
        if((state.getValue(HangingBridge2.AXIS) == EnumAxis.Z) && state.getValue(HangingBridge2.WEST).booleanValue()){
        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0f,1f,1f,0.0625f).move(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge2.HEIGHT)) + this.initialOffset, 0F)));
        }
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return  HangingBridge2.BOTTOM_AABB.move(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge2.HEIGHT)) + this.initialOffset, 0F));
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(Math.floor(meta / 8) == 0)
			return this.getDefaultState().withProperty(HangingBridge2.AXIS, EnumAxis.X).withProperty(HangingBridge2.HEIGHT, meta);
		else
			return this.getDefaultState().withProperty(HangingBridge2.AXIS, EnumAxis.Z).withProperty(HangingBridge2.HEIGHT, meta % 8);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = 0;
		if(state.getValue(HangingBridge2.AXIS) == EnumAxis.Z) {
			meta += 8;
		}
		meta += state.getValue(HangingBridge2.HEIGHT);
		return meta;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {HangingBridge2.AXIS, HangingBridge2.HEIGHT, HangingBridge2.NORTH, HangingBridge2.SOUTH, HangingBridge2.EAST, HangingBridge2.WEST});
	}
	
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
		switch(placer.getHorizontalFacing().getOpposite()){
		case EAST:
		case WEST:
			return this.getDefaultState().withProperty(HangingBridge2.AXIS, EnumAxis.Z);
		case NORTH:
		case SOUTH:
	        return this.getDefaultState().withProperty(HangingBridge2.AXIS, EnumAxis.X);
	    default:
	        return this.getDefaultState().withProperty(HangingBridge2.AXIS, EnumAxis.X);
		}
    }
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		boolean north = true;
		boolean east = true;
		boolean south = true;
		boolean west = true;
		if(state.getValue(HangingBridge2.AXIS).equals(EnumAxis.X)){
			if(this.doesBlockAlign(worldIn, pos.north())){
				north = false;
			}
			if(this.doesBlockAlign(worldIn, pos.east())){
				east = false;
			}
			if(this.doesBlockAlign(worldIn, pos.south())){
				south = false;
			}
			if(this.doesBlockAlign(worldIn, pos.west())){
				west = false;
			}
		}else if(state.getValue(HangingBridge2.AXIS).equals(EnumAxis.Z)){
			if(this.doesBlockAlign(worldIn, pos.east())){
				north = false;
			}
			if(this.doesBlockAlign(worldIn, pos.south())){
				east = false;
			}
			if(this.doesBlockAlign(worldIn, pos.west())){
				south = false;
			}
			if(this.doesBlockAlign(worldIn, pos.north())){
				west = false;
			}
		}
		return state.withProperty(HangingBridge2.NORTH, north).withProperty(HangingBridge2.EAST, east).withProperty(HangingBridge2.SOUTH, south).withProperty(HangingBridge2.WEST, west);
	}
	
	private boolean doesBlockAlign(IBlockAccess world, BlockPos pos){
		
		return world.getBlockState(pos).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM) || world.getBlockState(pos).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_TOP) ||
				world.getBlockState(pos.up()).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM) || world.getBlockState(pos.up()).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_TOP) ||
				world.getBlockState(pos.down()).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM) || world.getBlockState(pos.down()).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_TOP);
	}
}
