package net.dark_roleplay.medieval.client.objects.events;

import net.dark_roleplay.medieval.common.References;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OnConfigChange {
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if(event.getModID().equals(References.MODID)){
			ConfigManager.sync(References.MODID, Config.Type.INSTANCE);
		}
	}
}