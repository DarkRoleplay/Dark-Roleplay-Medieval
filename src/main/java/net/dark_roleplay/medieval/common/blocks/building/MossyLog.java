package net.dark_roleplay.medieval.common.blocks.building;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class MossyLog extends BlockLog {

	public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis",
			BlockLog.EnumAxis.class);

	public MossyLog(String registryName) {
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
        this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
		this.setHardness(2.0F);
        this.setSoundType(SoundType.WOOD);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { LOG_AXIS });
	}

	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState();

		switch (meta) {
			case 0:
				iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
				break;
			case 1:
				iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
				break;
			case 2:
				iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
				break;
			default:
				iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
		}

		return iblockstate;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@SuppressWarnings("incomplete-switch")
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		switch ((BlockLog.EnumAxis) state.getValue(LOG_AXIS)) {
			case X:
				i |= 1;
				break;
			case Z:
				i |= 2;
				break;
			case NONE:
				i |= 3;
		}

		return i;
	}
}
