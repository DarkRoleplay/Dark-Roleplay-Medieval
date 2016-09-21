package net.drpmedieval.common.blocks.decorative;

import java.util.List;

import javax.annotation.Nullable;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class HangingBridge extends Block {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyBool EAST = PropertyBool.create("east");
	 public static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0F, 0F, 0F, 1F, 0.0625F, 1F);
	protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] {BOTTOM_AABB};
	
	public HangingBridge() {
		super(Material.WOOD);
		this.setRegistryName("HangingBridge");
		this.setUnlocalizedName("HangingBridge");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
		this.setHardness(1F);
		this.setSoundType(SoundType.WOOD);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------
	
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn)
    {
        state = state.getActualState(worldIn, pos);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, BOTTOM_AABB);

        if((EnumFacing) state.getValue(FACING) == EnumFacing.NORTH && !((Boolean)state.getValue(WEST)).booleanValue() || (EnumFacing) state.getValue(FACING) == EnumFacing.SOUTH && !((Boolean)state.getValue(EAST)).booleanValue()){
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0f,0.0625f,1f,1f));
        }
        
        if((EnumFacing) state.getValue(FACING) == EnumFacing.NORTH && !((Boolean)state.getValue(EAST)).booleanValue() || (EnumFacing) state.getValue(FACING) == EnumFacing.SOUTH && !((Boolean)state.getValue(WEST)).booleanValue()){
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.9375f,0.875f,0f,1f,1f,1f));
        }
        
        if((EnumFacing) state.getValue(FACING) == EnumFacing.EAST && !((Boolean)state.getValue(EAST)).booleanValue() || (EnumFacing) state.getValue(FACING) == EnumFacing.WEST && !((Boolean)state.getValue(WEST)).booleanValue()){
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0.9375f,1f,1f,1f));
        }
        
        if((EnumFacing) state.getValue(FACING) == EnumFacing.EAST && !((Boolean)state.getValue(WEST)).booleanValue() || (EnumFacing) state.getValue(FACING) == EnumFacing.WEST && !((Boolean)state.getValue(EAST)).booleanValue()){
        	addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0f,0.875f,0f,1f,1f,0.0625f));
        }

    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = this.getActualState(state, source, pos);
        return new AxisAlignedBB(0f,0f,0f,1f,0.125f,1f);
    }

    /**
     * Returns the correct index into boundingBoxes, based on what the fence is connected to.
     */
   /* private static int getBoundingBoxIdx(IBlockState state)
    {
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
    }*/

	
	
	@Override
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

	@Override
	public int getMetaFromState(IBlockState state) {

		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if(facing.equals(EnumFacing.NORTH)) return 0;
		if(facing.equals(EnumFacing.EAST)) return 1;
		if(facing.equals(EnumFacing.SOUTH)) return 2;
		if(facing.equals(EnumFacing.WEST)) return 3;
		return 0;
	}

	@Override
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

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] {FACING, NORTH, SOUTH, EAST, WEST});
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
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock){

		if(!this.canBlockStay(worldIn, pos, EnumFacing.UP)){
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
		super.neighborChanged(state, worldIn, pos, neighborBlock);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing) {

		return true;
	}
	// -------------------------------------------------- Block Events --------------------------------------------------
	
	@Override
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
		return Blocks.AIR.getDefaultState();
	}

}
