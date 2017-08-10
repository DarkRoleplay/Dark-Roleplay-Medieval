package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.events.MissingMappings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DRPMedievalMappings {

	public static final void init(FMLPreInitializationEvent event) {
	}

	public static final void init(FMLInitializationEvent event) {
	}

	public static final void init(FMLPostInitializationEvent event) {

		DRPMedievalMappings.registerMapping(DRPMedievalItems.BRONZE_RING, "bronzering");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.SILVER_RING, "silverring");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.GOLDEN_RING, "goldenring");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.LEATHER_PURSE, "leatherpurse");
		DRPMedievalMappings.registerMapping(DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM, "hanging_bridge");
		// 0.2.0
		DRPMedievalMappings.registerMapping(DRPMedievalItems.APPLE_GREEN, "applegreen");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.APPLE_YELLOW, "appleyellow");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.BAT_EAR, "batear");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.FISH_COOKED_CATFISH, "catfishcooked");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.FISH_RAW_CATFISH, "catfishraw");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.ORE_CHUNK_SULFUR, "sulfur_ore_chunk");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.ORE_CHUNK_SILVER, "silver_ore_chunk");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.POWDER_CHARCOAL, "charcoal_powder");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.TRIGGER_TRAP, "triggertrap");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.LEATHER_STRING_TANNED, "tannedleatherstring");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.LEATHER_TANNED, "tannedleather");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.ORE_CHUNK_SALPETER, "salpeter_ore_chunk");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.FISH_COOKED_CATFISH, "catfish_cooked");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.FUR_WOLF, "furwolf");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.LEATHER_STRING, "leatherstring");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.MEAT_COOKED_WOLF, "wolfmeatcooked");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.MEAT_RAW_WOLF, "wolfmeatraw");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.ORE_CHUNK_TIN, "tin_ore_chunk");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.PEAR_YELLOW, "pearyellow");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.ORE_CHUNK_COPPER, "copper_ore_chunk");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.PEAR_GREEN, "peargreen");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.FISH_RAW_CATFISH, "catfish_raw");

		DRPMedievalMappings.registerMapping(DRPMedievalItems.DOUGH_PUMPKIN, "doughpumpkin");
		DRPMedievalMappings.registerMapping(DRPMedievalItems.PUMPKIN_BREAD, "pumpkinbread");

		// 0.3.1
		registerMapping(DRPMedievalItems.BRONZE_COIN, "bronzecoin");
		registerMapping(DRPMedievalItems.SILVER_COIN, "silvercoin");
		registerMapping(DRPMedievalItems.GOLDEN_COIN, "goldencoin");
		registerMapping(DRPMedievalItems.BARK_AND_GLUE, "barkandglue");
		registerMapping(DRPMedievalItems.BRONZE_RING, "bronze_ring");
		registerMapping(DRPMedievalItems.PLANKS, "plank");
		registerMapping(DRPMedievalItems.SILVER_RING, "silver_ring");
		registerMapping(DRPMedievalItems.GOLDEN_RING, "golden_ring");
		registerMapping(DRPMedievalItems.CHICKEN_STEW, "chickenstew");
		registerMapping(DRPMedievalItems.VEGIE_STEW, "vegiestew");
		registerMapping(DRPMedievalItems.COD_STEW, "codstew");
		registerMapping(DRPMedievalItems.PUMPKIN_STEW, "pumpkinstew");
		registerMapping(DRPMedievalItems.FLOUR, "flourbarley");
		registerMapping(DRPMedievalItems.FLOUR, "flourwheat");
		registerMapping(DRPMedievalItems.DOUGH, "doughbarley");
		registerMapping(DRPMedievalItems.DOUGH, "doughwheat");
		registerMapping(DRPMedievalItems.LEATHER_BOOK_COVER, "leatherbookcover");
		registerMapping(DRPMedievalItems.LEATHER_BOOK_COVER_THIK, "leatherbookcoverthik");
		registerMapping(DRPMedievalItems.LEATHER_BOOK_COVER_THIN, "leatherbookcoverthin");
	}

	private static void registerMapping(Item item, String oldName) {
		MissingMappings.registerToRemap(item, DRPMedievalInfo.MODID + ":" + oldName);
	}

	private static void registerMapping(Block block, String oldName) {
		MissingMappings.registerToRemap(block, DRPMedievalInfo.MODID + ":" + oldName);
	}
}
