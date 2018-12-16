package net.dark_roleplay.medieval.common.objects.blocks.special;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.FACING_HORIZONTAL;
import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.PART;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.Part;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DoubleArch extends FacedBlock{

	public DoubleArch(String name, BlockSettings settings) {
		super(name, settings);
		this.setDefaultState(this.getDefaultState().withProperty(PART, Part.BOTTOM));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING_HORIZONTAL, EnumFacing.byHorizontalIndex(meta % 4)).withProperty(PART, (meta & 4) == 4 ? Part.BOTTOM : Part.TOP);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING_HORIZONTAL).getHorizontalIndex() | (state.getValue(PART) == Part.BOTTOM ? 4 : 0);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING_HORIZONTAL, PART});
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(FACING_HORIZONTAL, facing);
    }
}
