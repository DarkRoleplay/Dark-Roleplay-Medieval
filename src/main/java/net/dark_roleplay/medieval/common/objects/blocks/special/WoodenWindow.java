package net.dark_roleplay.medieval.common.objects.blocks.special;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.WINDOW_PLACEMENT;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.WindowPlacement;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WoodenWindow extends FacedBlock{

	public WoodenWindow(String name, BlockSettings settings) {
		super(name, settings);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		int p = meta / 4;
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.byHorizontalIndex(meta % 4)).withProperty(WINDOW_PLACEMENT, p == 0 ? WindowPlacement.CENTERED : WindowPlacement.OFFSET);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex() + (state.getValue(WINDOW_PLACEMENT) == WindowPlacement.OFFSET ? 4 : 0);
	}


	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL, WINDOW_PLACEMENT});
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING_HORIZONTAL, placer.getHorizontalFacing().getOpposite()).withProperty(WINDOW_PLACEMENT, WindowPlacement.OFFSET);
    }
}
