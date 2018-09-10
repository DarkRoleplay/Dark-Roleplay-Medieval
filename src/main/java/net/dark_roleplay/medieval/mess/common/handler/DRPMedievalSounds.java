package net.dark_roleplay.medieval.mess.common.handler;

import net.dark_roleplay.medieval.mess.common.References;
import net.dark_roleplay.medieval.mess.common.testing.music.InstrumentSounds;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber

public class DRPMedievalSounds {

	public static SoundEvent SHIPS_BELL;
	public static SoundEvent WAR_HORN;

	public static InstrumentSounds GUITAR;
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<SoundEvent> event){
		ResourceLocation loc;
		DRPMedievalSounds.SHIPS_BELL = new SoundEvent(loc = new ResourceLocation(References.MODID, "block_ships_bell")).setRegistryName(loc);		
		DRPMedievalSounds.WAR_HORN = new SoundEvent(loc = new ResourceLocation(References.MODID, "war_horn_0")).setRegistryName(loc);

		DRPMedievalSounds.GUITAR = new InstrumentSounds(References.MODID, "guitar");

		event.getRegistry().register(DRPMedievalSounds.SHIPS_BELL);
		DRPMedievalSounds.GUITAR.register(event.getRegistry());
	}
}
