package net.dark_roleplay.medieval.testing.blocks.spinning_wheel;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.FACING_HORIZONTAL;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.objects.blocks.general.FacedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SpinningWheel extends FacedBlock {

	public SpinningWheel (String name, BlockSettings settings) {
		super(name, settings);
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		switch(state.getValue(FACING_HORIZONTAL)){
		case NORTH:
			return new AxisAlignedBB(0.3125F, 0F, 0F, 1F, 0.6875F, 1F);
		case EAST:
			return new AxisAlignedBB(0F, 0F, 0.3125F, 1F, 0.6875F, 1F);
		case SOUTH:
			return new AxisAlignedBB(0F, 0F, 0F, 0.6875F, 0.6875F, 1F);
		case WEST:
			return new AxisAlignedBB(0F, 0F, 0F, 1F, 0.6875F, 0.6875F);
		default:
			return new AxisAlignedBB(0F, 0F, 0F, 1F, 0.6875F, 1F);
		}
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
		return worldIn.isSideSolid(pos.offset(facing.getOpposite()), facing, true);
	}

	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side){
		return worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true);
	}
}