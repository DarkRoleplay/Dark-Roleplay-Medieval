package net.dark_roleplay.medieval.objects.blocks.utility.crafting.firepit;

import java.util.Random;

import net.dark_roleplay.library.experimental.blocks.behaviors.IRandomDisplayTickBehavior;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FirepitParticles implements IRandomDisplayTickBehavior{

	@Override
	public void execute(IBlockState state, World world, BlockPos pos, Random rand) {
		for(int count = 0; count < 6; count++) {
			world.spawnParticle(EnumParticleTypes.FLAME, true, pos.getX() + 0.25F + (rand.nextFloat() / 2F), pos.getY() + 0.25F + (rand.nextFloat() / 3F), pos.getZ() + 0.25F + (rand.nextFloat() / 2F), 0F, 0F, 0F);
		}
		for(int count = 0; count < 2; count++) {
			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, true, pos.getX() + 0.25F + (rand.nextFloat() / 2F), pos.getY() + 0.75F + (rand.nextFloat() / 2F), pos.getZ() + 0.25F + (rand.nextFloat() / 2F), 0F, 0F, 0F);
		}
	}
}
