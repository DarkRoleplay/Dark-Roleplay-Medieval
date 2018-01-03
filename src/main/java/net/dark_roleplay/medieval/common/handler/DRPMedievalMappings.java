package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.events.MissingMappings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DRPMedievalMappings {

	public static final void init(FMLInitializationEvent event) {
		//0.3.5
		registerMapping(DRPMedievalItems.CHARCOAL_POWDER, "powder_charcoal");
		registerMapping(DRPMedievalBlocks.OAK_FIREWOOD_PILE, "firewood_pile");
	}

	private static void registerMapping(Item item, String oldName) {
		MissingMappings.registerToRemap(item, DRPMedievalInfo.MODID + ":" + oldName);
	}

	private static void registerMapping(Block block, String oldName) {
		MissingMappings.registerToRemap(block, DRPMedievalInfo.MODID + ":" + oldName);
	}
}
