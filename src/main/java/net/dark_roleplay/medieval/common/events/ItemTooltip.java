package net.dark_roleplay.medieval.common.events;

import net.dark_roleplay.medieval.common.util.LoreHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemTooltip {
	
	@SubscribeEvent
	public void onItemTooltipEvent(ItemTooltipEvent event) {
	    ItemStack itemStack = event.getItemStack();
	    
	    if(LoreHelper.hasPERM_DESC(event.getItemStack().getItem())){
	    	event.getToolTip().addAll(LoreHelper.getPERM_DESC(event.getItemStack().getItem()));
	    }
	    
	    if(LoreHelper.hasCTRL_DESC(event.getItemStack().getItem())){
    		if(GuiScreen.isCtrlKeyDown()){
    	    	event.getToolTip().addAll(LoreHelper.getCTRL_DESC(event.getItemStack().getItem()));
    	    }else{
    	    	event.getToolTip().add("Press CTRL for Lore");
    	    }
    	} 
	    
    	if(LoreHelper.hasALT_DESC(event.getItemStack().getItem())){
    		if(GuiScreen.isAltKeyDown()){
    			event.getToolTip().addAll(LoreHelper.getALT_DESC(event.getItemStack().getItem()));
    	    }else{
    	    	event.getToolTip().add("Press ALT for Description");
    	    }
    	}
    	
    	if(LoreHelper.hasSHIFT_DESC(event.getItemStack().getItem())){
    		if(GuiScreen.isShiftKeyDown()){
    			event.getToolTip().addAll(LoreHelper.getSHIFT_DESC(event.getItemStack().getItem()));
    	    }else{
    	    	event.getToolTip().add("Press SHIFT for Description");
    	    }
    	}

	}
}
