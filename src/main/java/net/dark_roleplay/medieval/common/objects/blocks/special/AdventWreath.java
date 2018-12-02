package net.dark_roleplay.medieval.common.objects.blocks.special;

import static net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.BURNING_CANDLES;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AdventWreath extends DRPBlock{

	public AdventWreath(String name, BlockSettings settings) {
		super(name, settings);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(BURNING_CANDLES, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BURNING_CANDLES);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {BURNING_CANDLES});
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer){
        return this.getDefaultState().withProperty(BURNING_CANDLES, 0);
    }
}
