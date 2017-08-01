package net.dark_roleplay.medieval.common.blocks.decorative.hangingBridges;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.api.blocks.properties.UnlistedPropertyBool;
import net.dark_roleplay.medieval.common.blocks.helper.EnumAxis;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
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
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

public class HangingBridge extends Block {

	public static final PropertyEnum<EnumAxis> AXIS = PropertyEnum.<EnumAxis>create("axis", EnumAxis.class);
	public static final PropertyInteger HEIGHT = PropertyInteger.create("height", 0, 7);
	
	public static final UnlistedPropertyBool NORTH = UnlistedPropertyBool.create("north");
	public static final UnlistedPropertyBool SOUTH = UnlistedPropertyBool.create("south");
	public static final UnlistedPropertyBool WEST = UnlistedPropertyBool.create("west");
	public static final UnlistedPropertyBool EAST = UnlistedPropertyBool.create("east");
	
	public static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0F, 0F, 0F, 1F, 0.125F, 1F);

	private float initialOffset = 0F;
	
	public HangingBridge(String registryName, float initialOffset) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setSoundType(SoundType.WOOD);
		this.initialOffset = initialOffset;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return DRPMedievalItems.HANGING_BRIDGE;
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
        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, HangingBridge.BOTTOM_AABB.offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F)));

//        if((state.getValue(HangingBridge.AXIS) == EnumAxis.X) && state.getValue(HangingBridge.WEST).booleanValue()){
//        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0f,0.0625f,1f,1f).offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F)));
//        }
//        
//        if((state.getValue(HangingBridge.AXIS) == EnumAxis.X) && state.getValue(HangingBridge.EAST).booleanValue()){
//        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.9375f,0.875f,0f,1f,1f,1f).offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F)));
//        }
//        
//        if((state.getValue(HangingBridge.AXIS) == EnumAxis.Z) && state.getValue(HangingBridge.EAST).booleanValue()){
//        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0.9375f,1f,1f,1f).offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F)));
//        }
//        
//        if((state.getValue(HangingBridge.AXIS) == EnumAxis.Z) && state.getValue(HangingBridge.WEST).booleanValue()){
//        	Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0f,1f,1f,0.0625f).offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F)));
//        }
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return  HangingBridge.BOTTOM_AABB.offset(new Vec3d(0F, (0.0625F * state.getValue(HangingBridge.HEIGHT)) + this.initialOffset, 0F));
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(Math.floor(meta / 8) == 0)
			return this.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.X).withProperty(HangingBridge.HEIGHT, meta);
		else
			return this.getDefaultState().withProperty(HangingBridge.AXIS, EnumAxis.Z).withProperty(HangingBridge.HEIGHT, meta % 8);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = 0;
		if(state.getValue(HangingBridge.AXIS) == EnumAxis.Z) {
			meta += 8;
		}
		meta += state.getValue(HangingBridge.HEIGHT);
		return meta;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new ExtendedBlockState(this, new IProperty[] {HangingBridge.AXIS, HangingBridge.HEIGHT}, new IUnlistedProperty[]{HangingBridge.NORTH, HangingBridge.SOUTH, HangingBridge.EAST, HangingBridge.WEST});
	}
	
	
	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){	
		switch(placer.getHorizontalFacing().getOpposite()){
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
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
		
		state = super.getExtendedState(state, world, pos);
		
		if (state instanceof IExtendedBlockState){
	
			IExtendedBlockState ext = (IExtendedBlockState) state;
			
			boolean north = true;
			boolean east = true;
			boolean south = true;
			boolean west = true;
			if(state.getValue(HangingBridge.AXIS).equals(EnumAxis.X)){
				if(this.doesBlockAlign(world, pos.north())){
					north = false;
				}
				if(this.doesBlockAlign(world, pos.east())){
					east = false;
				}
				if(this.doesBlockAlign(world, pos.south())){
					south = false;
				}
				if(this.doesBlockAlign(world, pos.west())){
					west = false;
				}
			}else if(state.getValue(HangingBridge.AXIS).equals(EnumAxis.Z)){
				if(this.doesBlockAlign(world, pos.east())){
					north = false;
				}
				if(this.doesBlockAlign(world, pos.south())){
					east = false;
				}
				if(this.doesBlockAlign(world, pos.west())){
					south = false;
				}
				if(this.doesBlockAlign(world, pos.north())){
					west = false;
				}
			}
			ext = ext.withProperty(HangingBridge.NORTH, north).withProperty(HangingBridge.EAST, east).withProperty(HangingBridge.SOUTH, south).withProperty(HangingBridge.WEST, west);
			state = ext;
		}
		return state;
	}
	
	private boolean doesBlockAlign(IBlockAccess world, BlockPos pos){
		
		return world.getBlockState(pos).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM) || world.getBlockState(pos).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_TOP) ||
				world.getBlockState(pos.up()).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM) || world.getBlockState(pos.up()).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_TOP) ||
				world.getBlockState(pos.down()).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM) || world.getBlockState(pos.down()).getBlock().equals(DRPMedievalBlocks.HANGING_BRIDGE_TOP);
	}
}
