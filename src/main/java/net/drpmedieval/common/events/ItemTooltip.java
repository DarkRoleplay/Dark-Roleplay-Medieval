package net.drpmedieval.common.events;

import net.drpmedieval.common.util.LoreHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemTooltip {
	
	@SubscribeEvent
	public void onItemTooltipEvent(ItemTooltipEvent event) {
	    ItemStack itemStack = event.getItemStack();

	    if(LoreHelper.hasItemLore(event.getItemStack().getItem())){
    		if(GuiScreen.isCtrlKeyDown()){
    	    	event.getToolTip().addAll(LoreHelper.getItemLore(event.getItemStack().getItem()));
    	    }else{
    	    	event.getToolTip().add("Press CTRL for Lore");
    	    }
    	} 
	    
    	if(LoreHelper.hasItemDesc(event.getItemStack().getItem())){
    		if(GuiScreen.isAltKeyDown()){
    			event.getToolTip().addAll(LoreHelper.getItemDesc(event.getItemStack().getItem()));
    	    }else{
    	    	event.getToolTip().add("Press ALT for Description");
    	    }
    	}

	}
}
