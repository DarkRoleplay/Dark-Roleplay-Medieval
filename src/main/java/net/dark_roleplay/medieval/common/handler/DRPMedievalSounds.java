package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.music.InstrumentSounds;
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

	public static InstrumentSounds GUITAR;
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<SoundEvent> event){
		ResourceLocation loc;
		DRPMedievalSounds.SHIPS_BELL = new SoundEvent(loc = new ResourceLocation(DRPMedievalInfo.MODID, "block_ships_bell")).setRegistryName(loc);
		DRPMedievalSounds.GUITAR = new InstrumentSounds(DRPMedievalInfo.MODID, "guitar");

		event.getRegistry().register(DRPMedievalSounds.SHIPS_BELL);
		DRPMedievalSounds.GUITAR.register(event.getRegistry());
	}
}
