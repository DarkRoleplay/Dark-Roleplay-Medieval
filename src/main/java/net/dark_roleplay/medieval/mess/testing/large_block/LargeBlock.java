package net.dark_roleplay.medieval.mess.testing.large_block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public interface LargeBlock{

	public AxisAlignedBB[] getSelectionBoxes(IBlockState state);
	
}
