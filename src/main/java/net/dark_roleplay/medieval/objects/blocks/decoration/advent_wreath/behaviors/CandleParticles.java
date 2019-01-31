package net.dark_roleplay.medieval.objects.blocks.decoration.advent_wreath.behaviors;

import java.util.Random;

import net.dark_roleplay.library.experimental.blocks.behaviors.IRandomDisplayTickBehavior;
import net.dark_roleplay.medieval.holders.MedievalBlockProperties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CandleParticles implements IRandomDisplayTickBehavior{

	private static float[][] candles = new float[][]{
		{0.5F, 0.6875F, 0.9F},
		{0.9F, 0.5F, 0.5F},
		{0.5F, 0.5F, 0.5F},
		{0.5F, 0.5F, 0.5F}
	};

	@Override
	public void execute(IBlockState state, World world, BlockPos pos, Random rand) {
		int currentLit = state.getValue(MedievalBlockProperties.BURNING_CANDLES);

		for(int i = 0 ; i < currentLit; i++) {

			double d0 = pos.getX() + candles[i][0];
			double d1 = pos.getY() + candles[i][1];
			double d2 = pos.getZ() + candles[i][2];

			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.FLAME, 		d0, d1, d2, 0.0D, 0.0D, 0.0D);

			candles = new float[][]{
				{0.5F, 0.75F, 0.1F},
				{0.9F, 0.75F, 0.5F},
				{0.5F, 0.75F, 0.9F},
				{0.1F, 0.75F, 0.5F}
			};
		}
	}
}
