package net.drpmedieval.common.blocks.decorative.ropeFence;

import java.util.List;

import javax.annotation.Nullable;

import net.drpmedieval.common.blocks.DRPMBlocks;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RopeFence extends Block{
	
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool NORTH_EAST = PropertyBool.create("north_east");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH_EAST = PropertyBool.create("south_east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool SOUTH_WEST = PropertyBool.create("south_west");
	public static final PropertyBool WEST = PropertyBool.create("west");
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
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {NORTH,NORTH_EAST,EAST,SOUTH_EAST,SOUTH,SOUTH_WEST,WEST,NORTH_WEST});
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		
		boolean n = false;
		boolean ne = false;
		boolean e = false;
		boolean se = false;
		boolean s = false;
		boolean sw = false;
		boolean w = false;
		boolean nw = false;
		
		if(world.getBlockState(pos.north()).getBlock() == this || world.isSideSolid(pos.north(), EnumFacing.SOUTH, false))
			n = true;

		if(world.getBlockState(pos.east()).getBlock() == this || world.isSideSolid(pos.east(), EnumFacing.WEST, false))
			e = true;

		if(world.getBlockState(pos.south()).getBlock() == this || world.isSideSolid(pos.south(), EnumFacing.NORTH, false))
			s = true;
		
		if(world.getBlockState(pos.west()).getBlock() == this || world.isSideSolid(pos.west(), EnumFacing.EAST, false))
			w = true;
		
		
		if((!n && !e) && world.getBlockState(pos.north().east()).getBlock() == this)
			ne = true;
		
		if((!s && !e) && world.getBlockState(pos.south().east()).getBlock() == this)
			se = true;
		
		if((!s && !w) && world.getBlockState(pos.south().west()).getBlock() == this)
			sw = true;
		
		if((!n && !w) && world.getBlockState(pos.north().west()).getBlock() == this)
			nw = true;

		return state.withProperty(NORTH, n).withProperty(NORTH_EAST, ne).withProperty(EAST, e).withProperty(SOUTH_EAST, se).withProperty(SOUTH, s).withProperty(SOUTH_WEST, sw).withProperty(WEST, w).withProperty(NORTH_WEST, nw);
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
	
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_){
		state = state.getActualState(worldIn, pos);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, PILLAR_AABB);

        if (((Boolean)state.getValue(NORTH)).booleanValue())
            addCollisionBoxToList(pos, entityBox, collidingBoxes, NORTH_AABB);

        if (((Boolean)state.getValue(EAST)).booleanValue())
            addCollisionBoxToList(pos, entityBox, collidingBoxes, EAST_AABB);

        if (((Boolean)state.getValue(SOUTH)).booleanValue())
            addCollisionBoxToList(pos, entityBox, collidingBoxes, SOUTH_AABB);

        if (((Boolean)state.getValue(WEST)).booleanValue())
            addCollisionBoxToList(pos, entityBox, collidingBoxes, WEST_AABB);
        
        if (((Boolean)state.getValue(NORTH_EAST)).booleanValue())
            addCollisionBoxToList(pos, entityBox, collidingBoxes, NE_AABB);

        if (((Boolean)state.getValue(NORTH_WEST)).booleanValue())
            addCollisionBoxToList(pos, entityBox, collidingBoxes, NW_AABB);

        if (((Boolean)state.getValue(SOUTH_EAST)).booleanValue())
            addCollisionBoxToList(pos, entityBox, collidingBoxes, SE_AABB);

        if (((Boolean)state.getValue(SOUTH_WEST)).booleanValue())
            addCollisionBoxToList(pos, entityBox, collidingBoxes, SW_AABB);
        
    }

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = this.getActualState(state, source, pos);
        return BOUNDING_BOXES[getBoundingBoxIdx(state)];
    }

    /**
     * Returns the correct index into boundingBoxes, based on what the fence is connected to.
     */
    private static int getBoundingBoxIdx(IBlockState state){
        int i = 0;

        if (((Boolean)state.getValue(NORTH)).booleanValue())
        {
            i |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }

        if (((Boolean)state.getValue(EAST)).booleanValue())
        {
            i |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }

        if (((Boolean)state.getValue(SOUTH)).booleanValue())
        {
            i |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }

        if (((Boolean)state.getValue(WEST)).booleanValue())
        {
            i |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }

        return i;
    }
}
