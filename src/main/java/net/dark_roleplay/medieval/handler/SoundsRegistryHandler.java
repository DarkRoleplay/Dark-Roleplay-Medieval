package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.medieval.References;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = References.MODID)
public class SoundsRegistryHandler {

	@SubscribeEvent
	public static void register(RegistryEvent.Register<SoundEvent> event){
		event.getRegistry().register(new SoundEvent(new ResourceLocation(References.MODID, "block_ships_bell")).setRegistryName(new ResourceLocation(References.MODID, "ships_bell")));
		event.getRegistry().register(new SoundEvent(new ResourceLocation(References.MODID, "war_horn_0")).setRegistryName(new ResourceLocation(References.MODID, "war_horn")));
	}
}
