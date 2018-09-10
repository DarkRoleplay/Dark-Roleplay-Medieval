package net.dark_roleplay.medieval.mess.common.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InventoryHelper {

	public static int getInventorySlotContainItem(Item itemIn, ItemStack[] inventory) {

		for(int i = 0; i < inventory.length; ++i){
			if(inventory[i] != null && inventory[i].getItem() == itemIn){ return i; }
		}

		return -1;
	}
	
}
