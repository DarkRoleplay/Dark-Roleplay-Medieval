package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.objects.events.MissingMappings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class MedievalMappings {

	public static final void init(FMLInitializationEvent event) {
//		registerMapping(Blocks.STONE, "minecart_stopper");
		registerIgnoreMappingB("drpmedieval:work_table");
		registerIgnoreMappingB("drpmedieval:spinning_wheel2");
		registerIgnoreMappingB("drpmedieval:flower_pot");
		registerIgnoreMappingB("drpcmblueprints:blueprint_controller");
		registerIgnoreMappingB("drpmedieval:oak_roof");
		registerIgnoreMappingB("drpmedieval:axle");
		registerIgnoreMappingB("drpmedieval:gunpowder_trail");
		registerIgnoreMappingB("drpmedieval:barley");
		registerIgnoreMappingB("drpmedieval:minecart_stopper");
	}

	private static void registerIgnoreMappingI(String oldName) {
		MissingMappings.ignoreItem(oldName);
	}

	private static void registerIgnoreMappingB(String oldName) {
		MissingMappings.ignoreBlock(oldName);
	}

	private static void registerMapping(Item item, String oldName) {
		MissingMappings.registerToRemapI(item.getRegistryName().toString(), References.MODID + ":" + oldName);
	}

	private static void registerMapping(Block block, String oldName) {
		MissingMappings.registerToRemapB(block.getRegistryName().toString(), References.MODID + ":" + oldName);
	}

	private static void registerMappingB(String block, String oldName) {
		MissingMappings.registerToRemapB(block, References.MODID + ":" + oldName);
	}

	private static void registerMappingI(String item, String oldName) {
		MissingMappings.registerToRemapI(item, References.MODID + ":" + oldName);
	}
}
