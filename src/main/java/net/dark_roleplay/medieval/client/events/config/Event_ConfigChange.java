package net.dark_roleplay.medieval.client.events.config;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_ConfigChange {
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if(event.getModID().equals(DRPMedievalInfo.MODID)){
			ConfigManager.sync(DRPMedievalInfo.MODID, Config.Type.INSTANCE);
		}
	}
}