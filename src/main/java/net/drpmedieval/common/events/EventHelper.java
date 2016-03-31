package net.drpmedieval.common.events;

import net.minecraftforge.common.MinecraftForge;

public class EventHelper {

	public static void registerEvents(){
		MinecraftForge.EVENT_BUS.register(new LivingDrop());
	}
	
}
