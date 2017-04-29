package net.dark_roleplay.medieval.common.items.consumable;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.BlockLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BarkAndGlue extends Item{

	public BarkAndGlue() {
		this.setRegistryName("BarkAndGlue");
		this.setUnlocalizedName("BarkAndGlue");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
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
