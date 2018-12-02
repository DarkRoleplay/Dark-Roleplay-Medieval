package net.dark_roleplay.medieval.common.objects.blocks.behaviors.advent_wreath;

import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CandleLighting implements IActivatedBehavior{

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(player.isSneaking()) {
			int currentLit = state.getValue(BlockProperties.BURNING_CANDLES);
			if(currentLit > 0) {
				world.setBlockState(pos, state.withProperty(BlockProperties.BURNING_CANDLES, currentLit--));
				return true;
			}
		}

		if(player.getHeldItem(hand).getItem() != Items.FLINT_AND_STEEL) return false;

		int currentLit = state.getValue(BlockProperties.BURNING_CANDLES);
		if(currentLit < 4) {
			world.setBlockState(pos, state.withProperty(BlockProperties.BURNING_CANDLES, currentLit++));
			return true;
		}

		return false;
	}

}
