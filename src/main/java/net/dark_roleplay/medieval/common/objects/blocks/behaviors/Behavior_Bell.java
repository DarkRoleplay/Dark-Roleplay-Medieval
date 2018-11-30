package net.dark_roleplay.medieval.common.objects.blocks.behaviors;

import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.dark_roleplay.library.experimental.blocks.behaviors.ICollidedWithBehavior;
import net.dark_roleplay.medieval.holders.MedievalSounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behavior_Bell implements IActivatedBehavior, ICollidedWithBehavior{

	@Override
	public void execute(World world, BlockPos pos, IBlockState state, Entity entity) {
		world.playSound(null, pos, MedievalSounds.SHIPS_BELL, SoundCategory.BLOCKS, 1F, 1.1F);
	}

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		world.playSound(player, pos, MedievalSounds.SHIPS_BELL, SoundCategory.BLOCKS, 1F, 1.1F);
		return true;
	}

}
