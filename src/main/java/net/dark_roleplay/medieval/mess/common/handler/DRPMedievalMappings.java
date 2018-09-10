package net.dark_roleplay.medieval.mess.common.handler;

import static net.dark_roleplay.medieval.mess.common.handler.DRPMedievalBlocks.*;

import net.dark_roleplay.medieval.mess.common.References;
import net.dark_roleplay.medieval.mess.common.objects.events.MissingMappings;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DRPMedievalMappings {

	public static final void init(FMLInitializationEvent event) {
		//0.3.5
		registerMapping(DRPMedievalItems.CHARCOAL_POWDER, "powder_charcoal");
		registerMapping(DRPMedievalBlocks.OAK_FIREWOOD_PILE, "firewood_pile");
		registerMappingB("acacia_barrel_chair", "barrel_chair_acacia");
		registerMappingB("birch_barrel_chair", "barrel_chair_birch");
		registerMappingB("dark_oak_barrel_chair", "barrel_chair_dark_oak");
		registerMappingB("jungle_barrel_chair", "barrel_chair_jungle");
		registerMappingB("oak_barrel_chair", "barrel_chair_oak");
		registerMappingB("spruce_barrel_chair", "barrel_chair_spruce");
		registerMappingB("acacia_closed_barrel", "barrel_closed_acacia");
		registerMappingB("birch_closed_barrel", "barrel_closed_birch");
		registerMappingB("dark_oak_closed_barrel", "barrel_closed_dark_oak");
		registerMappingB("jungle_closed_barrel", "barrel_closed_jungle");
		registerMappingB("oak_closed_barrel", "barrel_closed_oak");
		registerMappingB("spruce_closed_barrel", "barrel_closed_spruce");
		registerMappingB("acacia_empty_barrel", "barrel_empty_acacia");
		registerMappingB("birch_empty_barrel", "barrel_empty_birch");
		registerMappingB("dark_oak_empty_barrel", "barrel_empty_dark_oak");
		registerMappingB("jungle_empty_barrel", "barrel_empty_jungle");
		registerMappingB("oak_empty_barrel", "barrel_empty_oak");
		registerMappingB("spruce_empty_barrel", "barrel_empty_spruce");
		registerMappingB("acacia_gunpowder_barrel", "barrel_gunpowder_acacia");
		registerMappingB("birch_gunpowder_barrel", "barrel_gunpowder_birch");
		registerMappingB("dark_oak_gunpowder_barrel", "barrel_gunpowder_dark_oak");
		registerMappingB("jungle_gunpowder_barrel", "barrel_gunpowder_jungle");
		registerMappingB("oak_gunpowder_barrel", "barrel_gunpowder_oak");
		registerMappingB("spruce_gunpowder_barrel", "barrel_gunpowder_spruce");
		registerMappingB("acacia_barrel_table", "barrel_table_acacia");
		registerMappingB("birch_barrel_table", "barrel_table_birch");
		registerMappingB("dark_oak_barrel_table", "barrel_table_dark_oak");
		registerMappingB("jungle_barrel_table", "barrel_table_jungle");
		registerMappingB("oak_barrel_table", "barrel_table_oak");
		registerMappingB("spruce_barrel_table", "barrel_table_spruce");
		registerMappingB("acacia_water_barrel", "barrel_water_acacia");
		registerMappingB("birch_water_barrel", "barrel_water_birch");
		registerMappingB("dark_oak_water_barrel", "barrel_water_dark_oak");
		registerMappingB("jungle_water_barrel", "barrel_water_jungle");
		registerMappingB("oak_water_barrel", "barrel_water_oak");
		registerMappingB("spruce_water_barrel", "barrel_water_spruce");
		registerMappingB("spruce_dirt_bucket", "bucket_dirt");
		registerMappingB("spruce_empty_bucket", "bucket_empty");
		registerMappingB("spruce_water_bucket", "bucket_water");
		registerMappingB("oak_chopping_block", "chopping_block");
		registerMappingB("oak_clean_plank", "clean_planks");
		registerMappingB("spruce_crate", "crate");
		registerMappingB("simple_spruce_chest", "dungeon_chest");
		registerMappingB("large_spruce_lectern", "large_lectern_spruce");
		registerMappingB("acacia_log_chair", "log_chair_acacia");
		registerMappingB("birch_log_chair", "log_chair_birch");
		registerMappingB("dark_oak_log_chair", "log_chair_dark_oak");
		registerMappingB("jungle_log_chair", "log_chair_jungle");
		registerMappingB("oak_log_chair", "log_chair_oak");
		registerMappingB("spruce_log_chair", "log_chair_spruce");
		registerMappingB("mossy_acacia_log", "mossy_log_acacia");
		registerMappingB("mossy_birch_log", "mossy_log_birch");
		registerMappingB("mossy_dark_oak_log", "mossy_log_dark_oak");
		registerMappingB("mossy_jungle_log", "mossy_log_jungle");
		registerMappingB("mossy_oak_log", "mossy_log_oak");
		registerMappingB("mossy_spruce_log", "mossy_log_spruce");
		registerMappingB("laying_acacia_barrel", "sideway_barrel_acacia");
		registerMappingB("laying_birch_barrel", "sideway_barrel_birch");
		registerMappingB("laying_dark_oak_barrel", "sideway_barrel_dark_oak");
		registerMappingB("laying_jungle_barrel", "sideway_barrel_jungle");
		registerMappingB("laying_oak_barrel", "sideway_barrel_oak");
		registerMappingB("laying_spruce_barrel", "sideway_barrel_spruce");
		registerMappingB("simple_acacia_chair", "simple_chair_acacia");
		registerMappingB("simple_birch_chair", "simple_chair_birch");
		registerMappingB("simple_dark_oak_chair", "simple_chair_dark_oak");
		registerMappingB("simple_jungle_chair", "simple_chair_jungle");
		registerMappingB("simple_oak_chair", "simple_chair_oak");
		registerMappingB("simple_spruce_chair", "simple_chair_spruce");
		registerMappingB("simple_spruce_chest", "simple_chest");
		registerMappingB("simple_acacia_table", "simple_table_acacia");
		registerMappingB("simple_birch_table", "simple_table_birch");
		registerMappingB("simple_dark_oak_table", "simple_table_dark_oak");
		registerMappingB("simple_jungle_table", "simple_table_jungle");
		registerMappingB("simple_oak_table", "simple_table_oak");
		registerMappingB("simple_spruce_table", "simple_table_spruce");
		
		registerMappingB("simple_plank_acacia_table", "simple_acacia_table");
		registerMappingB("simple_plank_birch_table", "simple_birch_table");
		registerMappingB("simple_plank_dark_oak_table", "simple_dark_oak_table");
		registerMappingB("simple_plank_jungle_table", "simple_jungle_table");
		registerMappingB("simple_plank_oak_table", "simple_oak_table");
		registerMappingB("simple_plank_spruce_table", "simple_spruce_table");
		
		registerMappingB("simple_plank_acacia_chair", "simple_acacia_chair");
		registerMappingB("simple_plank_birch_chair", "simple_birch_chair");
		registerMappingB("simple_plank_dark_oak_chair", "simple_dark_oak_chair");
		registerMappingB("simple_plank_jungle_chair", "simple_jungle_chair");
		registerMappingB("simple_plank_oak_chair", "simple_oak_chair");
		registerMappingB("simple_plank_spruce_chair", "simple_spruce_chair");
		
		registerMappingI("barley", "barley_item");
		registerMappingI("acacia_barrel_chair", "barrel_chair_acacia");
		registerMappingI("birch_barrel_chair", "barrel_chair_birch");
		registerMappingI("dark_oak_barrel_chair", "barrel_chair_dark_oak");
		registerMappingI("jungle_barrel_chair", "barrel_chair_jungle");
		registerMappingI("oak_barrel_chair", "barrel_chair_oak");
		registerMappingI("spruce_barrel_chair", "barrel_chair_spruce");
		registerMappingI("acacia_closed_barrel", "barrel_closed_acacia");
		registerMappingI("birch_closed_barrel", "barrel_closed_birch");
		registerMappingI("dark_oak_closed_barrel", "barrel_closed_dark_oak");
		registerMappingI("jungle_closed_barrel", "barrel_closed_jungle");
		registerMappingI("oak_closed_barrel", "barrel_closed_oak");
		registerMappingI("spruce_closed_barrel", "barrel_closed_spruce");
		registerMappingI("acacia_empty_barrel", "barrel_empty_acacia");
		registerMappingI("birch_empty_barrel", "barrel_empty_birch");
		registerMappingI("dark_oak_empty_barrel", "barrel_empty_dark_oak");
		registerMappingI("jungle_empty_barrel", "barrel_empty_jungle");
		registerMappingI("oak_empty_barrel", "barrel_empty_oak");
		registerMappingI("spruce_empty_barrel", "barrel_empty_spruce");
		registerMappingI("acacia_gunpowder_barrel", "barrel_gunpowder_acacia");
		registerMappingI("birch_gunpowder_barrel", "barrel_gunpowder_birch");
		registerMappingI("dark_oak_gunpowder_barrel", "barrel_gunpowder_dark_oak");
		registerMappingI("jungle_gunpowder_barrel", "barrel_gunpowder_jungle");
		registerMappingI("oak_gunpowder_barrel", "barrel_gunpowder_oak");
		registerMappingI("spruce_gunpowder_barrel", "barrel_gunpowder_spruce");
		registerMappingI("acacia_barrel_table", "barrel_table_acacia");
		registerMappingI("birch_barrel_table", "barrel_table_birch");
		registerMappingI("dark_oak_barrel_table", "barrel_table_dark_oak");
		registerMappingI("jungle_barrel_table", "barrel_table_jungle");
		registerMappingI("oak_barrel_table", "barrel_table_oak");
		registerMappingI("spruce_barrel_table", "barrel_table_spruce");
		registerMappingI("acacia_water_barrel", "barrel_water_acacia");
		registerMappingI("birch_water_barrel", "barrel_water_birch");
		registerMappingI("dark_oak_water_barrel", "barrel_water_dark_oak");
		registerMappingI("jungle_water_barrel", "barrel_water_jungle");
		registerMappingI("oak_water_barrel", "barrel_water_oak");
		registerMappingI("spruce_water_barrel", "barrel_water_spruce");
		registerMappingI("blue_berries", "blue_berrys");
		registerMappingI("spruce_dirt_bucket", "bucket_dirt");
		registerMappingI("spruce_empty_bucket", "bucket_empty");
		registerMappingI("spruce_water_bucket", "bucket_water");
		registerMappingI("oak_chopping_block", "chopping_block");
		registerMappingI("oak_clean_plank", "cleanplank");
		registerMappingI("spruce_crate", "crate");
		registerMappingI("simple_spruce_chest", "dungeon_chest");
		registerMappingI("cooked_catfish", "fish_cooked_catfish");
		registerMappingI("raw_catfish", "fish_raw_catfish");
		registerMappingI("large_spruce_lectern", "large_lectern_spruce");
		registerMappingI("acacia_log_chair", "log_chair_acacia");
		registerMappingI("birch_log_chair", "log_chair_birch");
		registerMappingI("dark_oak_log_chair", "log_chair_dark_oak");
		registerMappingI("jungle_log_chair", "log_chair_jungle");
		registerMappingI("oak_log_chair", "log_chair_oak");
		registerMappingI("spruce_log_chair", "log_chair_spruce");
		registerMappingI("cooked_wolf", "meat_cooked_wolf");
		registerMappingI("raw_wolf", "meat_raw_wolf");
		registerMappingI("mossy_acacia_log", "mossy_log_acacia");
		registerMappingI("mossy_birch_log", "mossy_log_birch");
		registerMappingI("mossy_dark_oak_log", "mossy_log_dark_oak");
		registerMappingI("mossy_jungle_log", "mossy_log_jungle");
		registerMappingI("mossy_oak_log", "mossy_log_oak");
		registerMappingI("mossy_spruce_log", "mossy_log_spruce");
		registerMappingI("laying_acacia_barrel", "sideway_barrel_acacia");
		registerMappingI("laying_birch_barrel", "sideway_barrel_birch");
		registerMappingI("laying_dark_oak_barrel", "sideway_barrel_dark_oak");
		registerMappingI("laying_jungle_barrel", "sideway_barrel_jungle");
		registerMappingI("laying_oak_barrel", "sideway_barrel_oak");
		registerMappingI("laying_spruce_barrel", "sideway_barrel_spruce");
		registerMappingI("simple_acacia_chair", "simple_chair_acacia");
		registerMappingI("simple_birch_chair", "simple_chair_birch");
		registerMappingI("simple_dark_oak_chair", "simple_chair_dark_oak");
		registerMappingI("simple_jungle_chair", "simple_chair_jungle");
		registerMappingI("simple_oak_chair", "simple_chair_oak");
		registerMappingI("simple_spruce_chair", "simple_chair_spruce");
		registerMappingI("simple_spruce_chest", "simple_chest");
		registerMappingI("simple_acacia_table", "simple_table_acacia");
		registerMappingI("simple_birch_table", "simple_table_birch");
		registerMappingI("simple_dark_oak_table", "simple_table_dark_oak");
		registerMappingI("simple_jungle_table", "simple_table_jungle");
		registerMappingI("simple_oak_table", "simple_table_oak");
		registerMappingI("simple_spruce_table", "simple_table_spruce");
		registerMappingI("oak_firewood", "firewood");
		registerIgnoreMappingI("drpmedieval:sledge");
		registerIgnoreMappingI("drpmedieval:ropedarrow");
		registerIgnoreMappingI("drpmedieval:gunpowder_trail");
		
		registerIgnoreMappingB("drpmedieval:pear_yellow");
		registerIgnoreMappingB("drpmedieval:shingles_slab");
		registerIgnoreMappingB("drpmedieval:apple_red");
		registerIgnoreMappingB("drpmedieval:flower_test");
		registerIgnoreMappingB("drpmedieval:apple_yellow");
		registerIgnoreMappingB("drpmedieval:apple_green");
		registerIgnoreMappingB("drpmedieval:pear_green");
		registerIgnoreMappingB("drpmedieval:dirt_stairs");
		registerIgnoreMappingB("drpmedieval:book_one");
		registerIgnoreMappingB("drpmedieval:normal_clay_roof");
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
