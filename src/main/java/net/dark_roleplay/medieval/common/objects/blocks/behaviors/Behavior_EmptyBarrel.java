package net.dark_roleplay.medieval.common.objects.blocks.behaviors;

import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Behavior_EmptyBarrel implements IActivatedBehavior {

	private String key = "";

	public Behavior_EmptyBarrel(String key, Material mat) {
		this.key = mat.getNamed(key);
	}

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(player.getHeldItem(hand).getItem() != Items.CLAY_BALL) return false;

		world.setBlockState(pos, Block.getBlockFromName(this.key).getDefaultState());
		return true;
	}

}
