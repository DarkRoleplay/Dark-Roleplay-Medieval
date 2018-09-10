package net.dark_roleplay.medieval.common;

import net.dark_roleplay.medieval.common.handler.MedievalMappings;
import net.dark_roleplay.medieval.common.handler.MedievalVillagers;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, version = References.VERSION, name = References.NAME, acceptedMinecraftVersions = References.ACCEPTEDVERSIONS, dependencies = References.DEPENDECIES, updateJSON = References.UPDATECHECK)
public class DarkRoleplayMedieval {

	@Mod.Instance(References.MODID)
	public static DarkRoleplayMedieval instance;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		MedievalVillagers.init(event);
		MedievalMappings.init(event);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
}
