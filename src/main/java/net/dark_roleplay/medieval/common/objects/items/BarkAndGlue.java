package net.dark_roleplay.medieval.common.objects.items;

import net.dark_roleplay.library_old.items.DRPItem;
import net.minecraft.block.BlockLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BarkAndGlue extends DRPItem{

	public BarkAndGlue(String registryName, String folder, int stackSize) {
		super(registryName, folder, stackSize);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.getBlockState(pos).getBlock() instanceof BlockLog){
			if(world.getBlockState(pos).getValue(BlockLog.LOG_AXIS) != BlockLog.EnumAxis.NONE){
				world.setBlockState(pos, world.getBlockState(pos).withProperty(BlockLog.LOG_AXIS,BlockLog.EnumAxis.NONE));
				player.getHeldItem(hand).shrink(1);
				return EnumActionResult.SUCCESS;
			}
		}
		return EnumActionResult.FAIL;
    }
}
