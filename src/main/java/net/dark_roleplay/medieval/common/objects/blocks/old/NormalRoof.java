package net.dark_roleplay.medieval.common.objects.blocks.old;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.HAS_TE;
import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.SNOWED;
import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.STAIR_TYPE;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.StairType;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Roof;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class NormalRoof extends FacedBlock {

	protected static final AxisAlignedBB AABB_QTR_TOP_WEST = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_TOP_EAST = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_TOP_NORTH = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_QTR_TOP_SOUTH = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_TOP_NW = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_TOP_NE = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_TOP_SW = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 0.5D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_TOP_SE = new AxisAlignedBB(0.5D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_SLAB_BOTTOM = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_EAST = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 0.5D);
	protected static final AxisAlignedBB AABB_QTR_BOT_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_BOT_NW = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_BOT_NE = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 0.5D, 0.5D);
	protected static final AxisAlignedBB AABB_OCT_BOT_SW = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 0.5D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_OCT_BOT_SE = new AxisAlignedBB(0.5D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);

	public NormalRoof(String name, BlockSettings settings) {
		super(name, settings);
		this.setDefaultState(this.getDefaultState().withProperty(STAIR_TYPE, StairType.STRAIGHT).withProperty(SNOWED, false).withProperty(HAS_TE, false));
		this.setTickRandomly(true);
		this.useNeighborBrightness = true;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING_HORIZONTAL, STAIR_TYPE, HAS_TE, SNOWED});
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.byHorizontalIndex(meta & 0x3))
				.withProperty(HAS_TE, (meta & 0x8) == 0x8).withProperty(SNOWED, (meta & 0x4) == 0x4);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex() | (state.getValue(SNOWED) ? 0x4 : 0) | (state.getValue(HAS_TE) ? 0x8 : 0);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		EnumFacing facing = state.getValue(FACING_HORIZONTAL);
		IBlockState otherBlock = world.getBlockState(pos.offset(facing));
		IBlockState otherBlock2 = world.getBlockState(pos.offset(facing.getOpposite()));
		IBlockState otherBlock3 = world.getBlockState(pos.offset(facing.rotateY()));
		IBlockState otherBlock4 = world.getBlockState(pos.offset(facing.rotateYCCW()));
		if (otherBlock.getBlock() instanceof NormalRoof && otherBlock.getValue(FACING_HORIZONTAL) == facing.rotateY()) {
			return state.withProperty(STAIR_TYPE, StairType.INNER_LEFT);
		} else if (otherBlock.getBlock() instanceof NormalRoof
				&& otherBlock.getValue(FACING_HORIZONTAL) == facing.rotateYCCW()) {
			return state.withProperty(STAIR_TYPE, StairType.INNER_RIGHT);
		} else if (otherBlock2.getBlock() instanceof NormalRoof
				&& otherBlock2.getValue(FACING_HORIZONTAL) == facing.rotateY() && !(otherBlock3.getBlock() instanceof NormalRoof && otherBlock3.getValue(FACING_HORIZONTAL) == facing)) {
			return state.withProperty(STAIR_TYPE, StairType.OUTER_LEFT);
		} else if (otherBlock2.getBlock() instanceof NormalRoof
				&& otherBlock2.getValue(FACING_HORIZONTAL) == facing.rotateYCCW() && !(otherBlock4.getBlock() instanceof NormalRoof && otherBlock4.getValue(FACING_HORIZONTAL) == facing)) {
			return state.withProperty(STAIR_TYPE, StairType.OUTER_RIGHT);
		}

		return state;
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, placer.getHorizontalFacing().getOpposite())
				.withProperty(HAS_TE, worldIn.getBlockState(pos.down()).isFullCube());
	}

	@Override
	@Deprecated
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		world.setBlockState(pos, state.withProperty(HAS_TE, world.getBlockState(pos.down()).isFullCube()));
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return state.getValue(HAS_TE);
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TE_Roof();
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
		if (!isActualState) {
			state = this.getActualState(state, worldIn, pos);
		}

		for (AxisAlignedBB axisalignedbb : getCollisionBoxList(state.withProperty(FACING_HORIZONTAL, state.getValue(FACING_HORIZONTAL).getOpposite()))) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, axisalignedbb);
		}
	}

	@Override
	public void randomTick(World world, BlockPos pos, IBlockState state, Random random){
//		if(random.nextInt(20) != 1) return;

		if (state.getValue(SNOWED)) return;

		if(!world.isRaining()) return;

		if (!world.canSeeSky(pos.up())) return;

		Biome biome = world.getBiome(pos);

		if (!biome.getEnableSnow() && biome.getTemperature(pos) >= 15) return;

		world.setBlockState(pos, state.withProperty(SNOWED, true), 2);
	}

	@Override
    public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        return false;
    }

//    /**
//     * @deprecated call via {@link IBlockState#getPackedLightmapCoords(IBlockAccess,BlockPos)} whenever possible.
//     * Implementing/overriding is fine.
//     */
//    @Override
//	@Deprecated
//    @SideOnly(Side.CLIENT)
//    public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos){
////    	return super.getPackedLightmapCoords(state, source, pos);
//        int i = source.getCombinedLight(pos, state.getLightValue(source, pos));
//        World w;
//        if (i == 0 && state.getBlock() instanceof NormalRoof){
//            pos = pos.up();
//            state = source.getBlockState(pos);
//            return source.getCombinedLight(pos, state.getLightValue(source, pos));
//        }else{
//            return i;
//        }
//    }

	private static List<AxisAlignedBB> getCollisionBoxList(IBlockState bstate) {
		List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
		list.add(AABB_SLAB_BOTTOM);
		BlockProperties.StairType stairType = bstate.getValue(STAIR_TYPE);

		if (stairType == BlockProperties.StairType.STRAIGHT
				|| stairType == BlockProperties.StairType.INNER_LEFT
				|| stairType == BlockProperties.StairType.INNER_RIGHT) {
			list.add(getCollQuarterBlock(bstate));
		}

		if (stairType != BlockProperties.StairType.STRAIGHT) {
			list.add(getCollEighthBlock(bstate));
		}

		return list;
	}

	/**
	 * Returns a bounding box representing a quarter of a block (two eight-size
	 * cubes back to back). Used in all stair shapes except OUTER.
	 */
	private static AxisAlignedBB getCollQuarterBlock(IBlockState bstate) {
		switch (bstate.getValue(FACING_HORIZONTAL)) {
		case NORTH:
		default:
			return AABB_QTR_TOP_NORTH;
		case SOUTH:
			return AABB_QTR_TOP_SOUTH;
		case WEST:
			return AABB_QTR_TOP_WEST;
		case EAST:
			return AABB_QTR_TOP_EAST;
		}
	}

	/**
     * Returns a bounding box representing an eighth of a block (a block whose three dimensions are halved).
     * Used in all stair shapes except STRAIGHT (gets added alone in the case of OUTER; alone with a quarter block in
     * case of INSIDE).
     */
    private static AxisAlignedBB getCollEighthBlock(IBlockState bstate){
        EnumFacing enumfacing = bstate.getValue(FACING_HORIZONTAL);
        EnumFacing enumfacing1;

        switch (bstate.getValue(STAIR_TYPE)) {
            case OUTER_LEFT:
            default:
                enumfacing1 = enumfacing.rotateY();
                break;
            case OUTER_RIGHT:
                enumfacing1 = enumfacing;
                break;
            case INNER_RIGHT:
                enumfacing1 = enumfacing;
                break;
            case INNER_LEFT:
                enumfacing1 = enumfacing.rotateY();
        }

        switch (enumfacing1) {
            case NORTH:
            default:
                return AABB_OCT_TOP_NW;
            case SOUTH:
                return AABB_OCT_TOP_SE;
            case WEST:
                return AABB_OCT_TOP_SW;
            case EAST:
                return AABB_OCT_TOP_NE;
        }
    }
}
