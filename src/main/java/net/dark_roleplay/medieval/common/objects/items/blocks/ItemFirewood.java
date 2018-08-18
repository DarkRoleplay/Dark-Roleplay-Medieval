package net.dark_roleplay.medieval.common.objects.items.blocks;

import net.dark_roleplay.library_old.items.DRPItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemFirewood extends DRPItem{


	public ItemFirewood(String name, String itemFolder, int stackSize, String... subNames){
		super(name, itemFolder, stackSize, subNames);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		ItemStack held = player.getHeldItem(hand);
		if(held.getItem() == this && held.getCount() >= 16) {
			
			
//			IBlockState block
			switch(held.getMetadata()) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				default:
			}
			
			
			return EnumActionResult.SUCCESS;
		}
		
        return EnumActionResult.PASS;
    }
}
