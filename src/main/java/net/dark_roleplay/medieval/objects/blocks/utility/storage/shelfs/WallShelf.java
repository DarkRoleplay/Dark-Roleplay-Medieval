package net.dark_roleplay.medieval.objects.blocks.utility.storage.shelfs;

import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.holders.MedievalBlockProperties.SD_CONNECTION;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.holders.MedievalBlockProperties.ConnectionSD;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WallShelf extends Shelf{

	public WallShelf(String name, BlockSettings settings) {
		super(name, settings);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.byHorizontalIndex(meta % 4)).withProperty(SD_CONNECTION, (meta / 4) > 0 ? ConnectionSD.DOUBLE : ConnectionSD.SINGLE);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex() + (state.getValue(SD_CONNECTION) == ConnectionSD.DOUBLE ? 4 : 0);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL, SD_CONNECTION});
	}

	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
		EnumFacing blockFacing = placer.getHorizontalFacing().getOpposite();
		Boolean isSingle = blockFacing.getAxis() == EnumFacing.Axis.Z ?
				world.getBlockState(pos.east()).getBlock() == this || world.getBlockState(pos.west()).getBlock() == this :
				world.getBlockState(pos.north()).getBlock() == this || world.getBlockState(pos.south()).getBlock() == this;

        return this.getDefaultState().withProperty(FACING_HORIZONTAL, blockFacing).withProperty(SD_CONNECTION, isSingle ? ConnectionSD.DOUBLE : ConnectionSD.SINGLE);
    }

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos){
		EnumFacing blockFacing = state.getValue(FACING_HORIZONTAL);
		Boolean isSingle = blockFacing.getAxis() == EnumFacing.Axis.Z ?
				world.getBlockState(pos.east()).getBlock() == this || world.getBlockState(pos.west()).getBlock() == this :
				world.getBlockState(pos.north()).getBlock() == this || world.getBlockState(pos.south()).getBlock() == this;

		world.setBlockState(pos, state.withProperty(SD_CONNECTION, isSingle ? ConnectionSD.DOUBLE : ConnectionSD.SINGLE));
	}
}
