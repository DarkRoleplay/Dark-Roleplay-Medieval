package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.References;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = References.MODID)
public class MedievalSounds {
	
	public static SoundEvent SHIPS_BELL = null;
	public static SoundEvent WAR_HORN = null;
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<SoundEvent> event){
		ResourceLocation loc;
		event.getRegistry().register(SHIPS_BELL = new SoundEvent(loc = new ResourceLocation(References.MODID, "block_ships_bell")).setRegistryName(loc));
		event.getRegistry().register(WAR_HORN = new SoundEvent(loc = new ResourceLocation(References.MODID, "war_horn_0")).setRegistryName(loc));
	}	
}
