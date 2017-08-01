package net.dark_roleplay.medieval.common.events.crafting;

import net.dark_roleplay.drpcore.api.events.player.Event_PlayerCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_PlayerCraftDRP {
	
	@SubscribeEvent
	public void playerCraft(Event_PlayerCraft event){
		EntityPlayer player = event.getPlayer();
		player.sendMessage(new TextComponentString("You crafted following recipe: " + event.getRecipe().getRegistryName()));
	}

}
