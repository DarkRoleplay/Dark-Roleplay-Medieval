package net.dark_roleplay.medieval.common.objects.blocks.decorative.rope_fence;

import java.util.List;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.api.blocks.properties.UnlistedPropertyInteger;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RopeFence extends Block{
	
	public static final UnlistedPropertyInteger NORTH = UnlistedPropertyInteger.create("north", 0, 3);
	public static final UnlistedPropertyInteger EAST = UnlistedPropertyInteger.create("east", 0, 3);
	public static final UnlistedPropertyInteger SOUTH = UnlistedPropertyInteger.create("south", 0, 3);
	public static final UnlistedPropertyInteger WEST = UnlistedPropertyInteger.create("west", 0, 3);
	
	public static final PropertyBool NORTH_EAST = PropertyBool.create("north_east");
	public static final PropertyBool SOUTH_EAST = PropertyBool.create("south_east");
	public static final PropertyBool SOUTH_WEST = PropertyBool.create("south_west");
	public static final PropertyBool NORTH_WEST = PropertyBool.create("north_west");
	
    protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] {new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D), new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D), new AxisAlignedBB(0.0D, 0.0D, 0.375D, 0.625D, 1.0D, 1.0D), new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.0D, 0.625D), new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.625D, 1.0D, 0.625D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D), new AxisAlignedBB(0.375D, 0.0D, 0.375D, 1.0D, 1.0D, 0.625D), new AxisAlignedBB(0.375D, 0.0D, 0.375D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 0.625D), new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.375D, 0.0D, 0.0D, 1.0D, 1.0D, 0.625D), new AxisAlignedBB(0.375D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.625D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
	public static final AxisAlignedBB PILLAR_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.5D, 0.625D);
    public static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.625D, 0.625D, 1.5D, 1.0D);
    public static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 0.375D, 1.5D, 0.625D);
    public static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.5D, 0.375D);
    public static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.625D, 0.0D, 0.375D, 1.0D, 1.5D, 0.625D);
	
    //E = X S = Z
    public static final AxisAlignedBB SE_AABB = new AxisAlignedBB(0.625D, 0.0D, 0.625D, 1.0D, 1.5D, 1.0D);
    public static final AxisAlignedBB SW_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.625D, 0.375D, 1.5D, 1.0D);
    public static final AxisAlignedBB NE_AABB = new AxisAlignedBB(0.625D, 0.0D, 0.0D, 1.0D, 1.5D, 0.375D);
    public static final AxisAlignedBB NW_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.375D, 1.5D, 0.375D);
    
	public RopeFence(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setSoundType(SoundType.WOOD);
		this.setDefaultState(this.getDefaultState().withProperty(NORTH_EAST, false).withProperty(NORTH_WEST, false).withProperty(SOUTH_EAST, false).withProperty(SOUTH_WEST, false));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState();
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }

	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new ExtendedBlockState(this, new IProperty[] {RopeFence.NORTH_EAST,RopeFence.SOUTH_EAST,RopeFence.SOUTH_WEST,RopeFence.NORTH_WEST}, new IUnlistedProperty[]{RopeFence.NORTH, RopeFence.EAST, RopeFence.WEST, RopeFence.SOUTH});
	}
	
		 /**
	  * Can return IExtendedBlockState
	  */
	@Override
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos){
		state = super.getExtendedState(state, world, pos);
		
		if (state instanceof IExtendedBlockState){
			
			int n = 3;
			int e = 3;
			int s = 3;
			int w = 3;

			boolean ne = false;
			boolean se = false;
			boolean sw = false;
			boolean nw = false;

			if((world.getBlockState(pos.north()).getBlock() == this)){
				n = 1;
			} else if((world.getBlockState(pos.north().up()).getBlock() == this) && world.isAirBlock(pos.up())){
				n = 2;
			} else if((world.getBlockState(pos.north().down()).getBlock() == this) && (world.getBlockState(pos.down()).getBlock() != this)){
				n = 0;
			}else if(world.isSideSolid(pos.north(), EnumFacing.SOUTH, false)){
				n = 1;
			}
			
			if((world.getBlockState(pos.east()).getBlock() == this)) {
				e = 1;
			} else if((world.getBlockState(pos.east().up()).getBlock() == this) && world.isAirBlock(pos.up())){
				e = 2;
			} else if((world.getBlockState(pos.east().down()).getBlock() == this) && (world.getBlockState(pos.down()).getBlock() != this)){
				e = 0;
			}else if(world.isSideSolid(pos.east(), EnumFacing.WEST, false)){
				e = 1;
			}
			
			if((world.getBlockState(pos.south()).getBlock() == this)) {
				s = 1;
			} else if((world.getBlockState(pos.south().up()).getBlock() == this) && world.isAirBlock(pos.up())){
				s = 2;
			} else if((world.getBlockState(pos.south().down()).getBlock() == this) && (world.getBlockState(pos.down()).getBlock() != this)){
				s = 0;
			}else if(world.isSideSolid(pos.south(), EnumFacing.NORTH, false)){
				s = 1;
			}
			
			if((world.getBlockState(pos.west()).getBlock() == this)) {
				w = 1;
			} else if((world.getBlockState(pos.west().up()).getBlock() == this) && world.isAirBlock(pos.up())){
				w = 2;
			} else if((world.getBlockState(pos.west().down()).getBlock() == this) && (world.getBlockState(pos.down()).getBlock() != this)){
				w = 0;
			}else if(world.isSideSolid(pos.west(), EnumFacing.EAST, false)){
				w = 1;
			}
			
			if(((n == 3) && (e == 3)) && (world.getBlockState(pos.north().east()).getBlock() == this)) {
				ne = true;
			}
			
			if(((s == 3) && (e ==3)) && (world.getBlockState(pos.south().east()).getBlock() == this)) {
				se = true;
			}
			
			if(((s == 3) && (w == 3)) && (world.getBlockState(pos.south().west()).getBlock() == this)) {
				sw = true;
			}
			
			if(((n == 3) && (w == 3)) && (world.getBlockState(pos.north().west()).getBlock() == this)) {
				nw = true;
			}
			
			IExtendedBlockState ext = (IExtendedBlockState) state;
				ext = (IExtendedBlockState) ext.withProperty(RopeFence.NORTH, n).withProperty(RopeFence.EAST, e).withProperty(RopeFence.SOUTH, s).withProperty(RopeFence.WEST, w).withProperty(RopeFence.NORTH_EAST, ne).withProperty(RopeFence.SOUTH_WEST, sw).withProperty(RopeFence.SOUTH_EAST, se).withProperty(RopeFence.NORTH_WEST, nw);;
				state = ext;
		}

		return state;
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
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos){
        return false;
    }
	
	
	@Override
	public void addCollisionBoxToList(IBlockState unextended, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState){
		unextended = getExtendedState(unextended, worldIn, pos);
		
		IExtendedBlockState state;
		if(unextended instanceof IExtendedBlockState){
			state = (IExtendedBlockState) unextended;
		}else{
			return;
		}
		
		int north = 3;
		int east = 3;
		int south = 3;
		int west = 3;

		if (state.getUnlistedNames().contains(RopeFence.NORTH))
			north = state.getValue(RopeFence.NORTH);
		if (state.getUnlistedNames().contains(RopeFence.EAST))
			east = state.getValue(RopeFence.EAST);
		if (state.getUnlistedNames().contains(RopeFence.SOUTH))
			south = state.getValue(RopeFence.SOUTH);
		if (state.getUnlistedNames().contains(RopeFence.WEST))
			west = state.getValue(RopeFence.WEST);
		
		if(entity instanceof EntityPlayer){
	        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.PILLAR_AABB.contract(0D, 0.5D, 0D));
	        
	        if (north != 3){
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.NORTH_AABB.contract(0D, 0.5D, 0D));
	        }
	        
	        if (east != 3){
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.EAST_AABB.contract(0D, 0.5D, 0D));
	        }
	        
	        if (south != 3){
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.SOUTH_AABB.contract(0D, 0.5D, 0D));
	        }
	        
	        if (west != 3){
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.WEST_AABB.contract(0D, 0.5D, 0D));
	        }
	        
	        if (state.getValue(RopeFence.NORTH_EAST).booleanValue()) {
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.NE_AABB.contract(0D, 0.5D, 0D));
			}

	        if (state.getValue(RopeFence.NORTH_WEST).booleanValue()) {
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.NW_AABB.contract(0D, 0.5D, 0D));
			}

	        if (state.getValue(RopeFence.SOUTH_EAST).booleanValue()) {
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.SE_AABB.contract(0D, 0.5D, 0D));
			}

	        if (state.getValue(RopeFence.SOUTH_WEST).booleanValue()) {
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.SW_AABB.contract(0D, 0.5D, 0D));
			}
		}else{
	        Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.PILLAR_AABB);
			
			if (north != 3){
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.NORTH_AABB);
	        }
	        
	        if (east != 3){
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.EAST_AABB);
	        }
	        
	        if (south != 3){
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.SOUTH_AABB);
	        }
	        
	        if (west != 3){
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.WEST_AABB);
	        }
	        
	        if (state.getValue(RopeFence.NORTH_EAST).booleanValue()) {
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.NE_AABB);
			}

	        if (state.getValue(RopeFence.NORTH_WEST).booleanValue()) {
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.NW_AABB);
			}

	        if (state.getValue(RopeFence.SOUTH_EAST).booleanValue()) {
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.SE_AABB);
			}

	        if (state.getValue(RopeFence.SOUTH_WEST).booleanValue()) {
				Block.addCollisionBoxToList(pos, entityBox, collidingBoxes, RopeFence.SW_AABB);
			}
		}
    }

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        state = this.getActualState(state, source, pos);
        return RopeFence.BOUNDING_BOXES[0];
    }
}
