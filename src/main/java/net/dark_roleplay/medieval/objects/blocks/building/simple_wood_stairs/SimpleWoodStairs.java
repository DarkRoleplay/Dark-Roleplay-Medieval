package net.dark_roleplay.medieval.objects.blocks.building.simple_wood_stairs;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.GROUNDED;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.SD_CONNECTION;

import java.util.List;

import javax.annotation.Nullable;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.holders.MedievalBlockProperties.ConnectionSD;
import net.dark_roleplay.medieval.objects.blocks.general.FacedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SimpleWoodStairs extends FacedBlock{

    protected static final AxisAlignedBB AABB_QTR_TOP_WEST = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_TOP_EAST = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
    protected static final AxisAlignedBB AABB_QTR_TOP_NORTH = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
    protected static final AxisAlignedBB AABB_QTR_TOP_SOUTH = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_EAST = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB AABB_QTR_BOT_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 0.5D);
	protected static final AxisAlignedBB AABB_QTR_BOT_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);

	public SimpleWoodStairs(String name, BlockSettings settings) {
		super(name, settings);
	}


	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.byHorizontalIndex(meta)).withProperty(GROUNDED, (meta & 0x4) == 0x4).withProperty(SD_CONNECTION, (meta & 0x8) == 0x8 ? ConnectionSD.SINGLE : ConnectionSD.DOUBLE);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex()  + (state.getValue(GROUNDED) ? 0x4 : 0x0) + (state.getValue(SD_CONNECTION) == ConnectionSD.SINGLE ? 0x8 : 0x0);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL, GROUNDED, SD_CONNECTION});
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
		switch(state.getValue(FACING_HORIZONTAL)) {
			case EAST:
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_TOP_WEST);
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_BOT_EAST);
				break;
			case NORTH:
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_TOP_SOUTH);
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_BOT_NORTH);
				break;
			case SOUTH:
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_TOP_NORTH);
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_BOT_SOUTH);
				break;
			case WEST:
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_TOP_EAST);
				addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_QTR_BOT_WEST);
				break;
			default:
				break;
		}
	}

	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		boolean isSingle = world.getBlockState(pos.offset(placer.getHorizontalFacing().rotateY())).getBlock() == this || world.getBlockState(pos.offset(placer.getHorizontalFacing().rotateYCCW())).getBlock() == this;
		ConnectionSD con = isSingle ? ConnectionSD.DOUBLE : ConnectionSD.SINGLE;
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(GROUNDED, world.isSideSolid(pos.down(), EnumFacing.UP)).withProperty(SD_CONNECTION, con);
    }

	@Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos){
		boolean isSingle = world.getBlockState(pos.offset(state.getValue(FACING_HORIZONTAL).rotateY())).getBlock() == this || world.getBlockState(pos.offset(state.getValue(FACING_HORIZONTAL).rotateYCCW())).getBlock() == this;
		ConnectionSD con = isSingle ? ConnectionSD.DOUBLE : ConnectionSD.SINGLE;
        world.setBlockState(pos, state.withProperty(GROUNDED, world.isSideSolid(pos.down(), EnumFacing.UP)).withProperty(SD_CONNECTION, con));
    }
}
