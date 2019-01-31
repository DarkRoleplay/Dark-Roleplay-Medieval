package net.dark_roleplay.medieval.objects.blocks.general.behaviors;

import net.dark_roleplay.core.api.old.crafting.Crafting_Util;
import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behavior_CraftingStation implements IActivatedBehavior{

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(world.isRemote){
			Crafting_Util.openRecipeSelection(state.getBlock());
		}
		return true;
	}
}
