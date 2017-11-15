package net.dark_roleplay.medieval.common.util;

import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.item.ItemStack;

public class ToolHelper {

	public static boolean isAcceptedTool(String toolType, int level, ItemStack stack){
		if(toolType.equals("wrench") && level <= 1){
			if(stack.getItem().equals(DRPMedievalItems.WOODEN_WRENCH)){
				return true;
			}
		}
		return false;
	}
	
}
