package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.objects.events.MissingMappings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class MedievalMappings {

	public static final void init(FMLInitializationEvent event) {

	}

	private static void registerIgnoreMappingI(String oldName) {
		MissingMappings.ignoreItem(oldName);
	}
	
	private static void registerIgnoreMappingB(String oldName) {
		MissingMappings.ignoreBlock(oldName);
	}
	
	private static void registerMapping(Item item, String oldName) {
		MissingMappings.registerToRemapI(item.getRegistryName().getResourcePath(), References.MODID + ":" + oldName);
	}

	private static void registerMapping(Block block, String oldName) {
		MissingMappings.registerToRemapB(block.getRegistryName().getResourcePath(), References.MODID + ":" + oldName);
	}
	
	private static void registerMappingB(String block, String oldName) {
		MissingMappings.registerToRemapB(block, References.MODID + ":" + oldName);
	}
	
	private static void registerMappingI(String item, String oldName) {
		MissingMappings.registerToRemapI(item, References.MODID + ":" + oldName);
	}
}
