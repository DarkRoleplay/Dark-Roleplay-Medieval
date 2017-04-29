package net.dark_roleplay.medieval.common.events;

import net.minecraftforge.common.MinecraftForge;

public class EventHelper {

	public static void registerEvents() {

		MinecraftForge.EVENT_BUS.register(new LivingDrop());
		MinecraftForge.EVENT_BUS.register(new ItemTooltip());
		//MinecraftForge.EVENT_BUS.register(new MissingMappings());
	}

}
