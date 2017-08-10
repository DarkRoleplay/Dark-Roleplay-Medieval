package net.dark_roleplay.medieval.common.events;

import net.dark_roleplay.medieval.common.events.crafting.Event_PlayerCraftDRP;
import net.dark_roleplay.medieval.common.protection.Event_WorldChange;
import net.minecraftforge.common.MinecraftForge;

public class EventHelper {

	public static void registerEvents() {

		MinecraftForge.EVENT_BUS.register(new Event_PlayerCraftDRP());
		MinecraftForge.EVENT_BUS.register(new LivingDrop());
		MinecraftForge.EVENT_BUS.register(new Event_WorldChange());
	}

}
