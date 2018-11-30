package net.dark_roleplay.medieval.common.objects.blocks.behaviors.chopping_block;

import net.dark_roleplay.library.experimental.blocks.behaviors.IActivatedBehavior;
import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.handler.MedievalGuis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChoppingBlockActivation implements IActivatedBehavior{

	@Override
	public boolean execute(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//		if(world.isRemote){
			player.openGui(DarkRoleplayMedieval.INSTANCE, MedievalGuis.GUI_CHOPPING_BLOCK, world, pos.getX(), pos.getY(), pos.getZ());
//		}
		return true;
	}
}
