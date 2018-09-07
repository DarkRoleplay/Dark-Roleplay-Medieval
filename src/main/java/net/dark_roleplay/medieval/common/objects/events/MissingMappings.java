package net.dark_roleplay.medieval.common.objects.events;

import java.util.ArrayList;

import com.google.common.collect.ImmutableList;

import net.dark_roleplay.core.testing.skills.Skill;
import net.dark_roleplay.library.experimental.connected_model.ConnectedModelLoader;
import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.barrels.BarrelClosed;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.barrels.BarrelEmpty;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.barrels.BarrelFilled;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.barrels.SidewayBarrel;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.buckets.Bucket;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.buckets.BucketDirt;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.chairs.BarrelChair;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.chairs.SimpleChair;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.support.WoodSupport;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.tables.BarrelTable;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.tables.SimpleTable;
import net.dark_roleplay.medieval.common.objects.blocks.decorative.tables.SolidSimpleTable;
import net.dark_roleplay.medieval.common.objects.blocks.storage.Crate;
import net.dark_roleplay.medieval.common.objects.blocks.storage.DungeonChest;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class MissingMappings {
	
	public static ArrayList<Block> remapBlocks = new ArrayList<Block>();
	public static ArrayList<String> blockNames = new ArrayList<String>();
	public static ArrayList<String> blockNamesIgnore = new ArrayList<String>();
	public static ArrayList<Item> remapItems = new ArrayList<Item>();
	public static ArrayList<String> itemNames = new ArrayList<String>();
	public static ArrayList<String> itemNamesIgnore = new ArrayList<String>();
	
	public static void registerToRemapB(String block, String oldName2){
		if(Block.REGISTRY.containsKey(new ResourceLocation(References.MODID, block))){
			remapBlocks.add(Block.REGISTRY.getObject(new ResourceLocation(References.MODID, block)));
			blockNames.add(oldName2.toLowerCase());
		}
	}
	
	public static void registerToRemapI(String item, String oldName2){
		if(Item.REGISTRY.containsKey(new ResourceLocation(References.MODID, item))){
			remapItems.add(Item.REGISTRY.getObject(new ResourceLocation(References.MODID, item)));
			itemNames.add(oldName2.toLowerCase());
		}
	}
	
	public static void ignoreBlock(String block) {
		blockNamesIgnore.add(block);
	}
	
	
	public static void ignoreItem(String item) {
		itemNamesIgnore.add(item);
	}
	
	@SubscribeEvent
	public static void MissingMappingsBlock(RegistryEvent.MissingMappings<Block> event){
		ImmutableList<Mapping<Block>> mappings = event.getAllMappings();
		for(RegistryEvent.MissingMappings.Mapping<Block> mapping : mappings){
			if(!mapping.key.getResourceDomain().equals(References.MODID)) continue;
			String name = mapping.key.toString().toLowerCase();
			if(MissingMappings.blockNames.contains(name)){
				for(int i = 0; i < MissingMappings.blockNames.size(); i++){
					if(MissingMappings.blockNames.get(i).equals(name)){
						mapping.remap(remapBlocks.get(i));
					}
				}
			}else if(MissingMappings.blockNamesIgnore.contains(name)){
				mapping.ignore();
			}else {
				
				if(name.contains("barrel")) {
					if(name.contains("_barrel_chair"))
						mapping.remap(Block.getBlockFromName(References.MODID + ":oak_barrel_chair"));
					else if(name.contains("_empty_barrel"))
						mapping.remap(Block.getBlockFromName(References.MODID + ":oak_empty_barrel"));
					else if(name.contains("_closed_barrel"))
						mapping.remap(Block.getBlockFromName(References.MODID + ":oak_closed_barrel"));
					else if(name.contains("_gunpowder_barrel"))
						mapping.remap(Block.getBlockFromName(References.MODID + ":oak_gunpowder_barrel"));
					else if(name.contains("_barrel_table"))
						mapping.remap(Block.getBlockFromName(References.MODID + ":oak_barrel_table"));
					else if(name.contains("_fluid_barrel"))
						mapping.remap(Block.getBlockFromName(References.MODID + ":oak_fluid_barrel"));
					else if(name.contains("laying_") && name.contains("_barrel"))
						mapping.remap(Block.getBlockFromName(References.MODID + ":laying_oak_barrel"));
				}else if(name.contains("_firewood_pile"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":oak_firewood_pile"));
				else if(name.contains("_chopping_block"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":oak_chopping_block"));
				else if(name.contains("_log_chair"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":oak_log_chair"));
				else if(name.contains("_log_bench"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":oak_log_bench"));
				else if(name.contains("_crate"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":oak_crate"));
				else if(name.contains("_dirt_bucket"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":oak_dirt_bucket"));
				else if(name.contains("_empty_bucket"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":oak_empty_bucket"));
				else if(name.contains("_water_bucket"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":oak_water_bucket"));
				else if(name.contains("_wood_support"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":oak_wood_support"));
				else if(name.contains("mossy_") && name.contains("_log"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":mossy_oak_log"));
				else if(name.contains("simple_") && name.contains("_chest"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":simple_oak_chest"));
				else if(name.contains("simple_solid_") && name.contains("_table"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":simple_solid_oak_table"));
				else if(name.contains("simple_plank_") && name.contains("_table"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":simple_plank_oak_table"));
				else if(name.contains("simple_plank_") && name.contains("_chair"))
					mapping.remap(Block.getBlockFromName(References.MODID + ":simple_plank_oak_chair"));
				
			}
		}
	}
	
	@SubscribeEvent
	public static void MissingMappingsItem(RegistryEvent.MissingMappings<Item> event){
		ImmutableList<Mapping<Item>> mappings = event.getAllMappings();
		for(RegistryEvent.MissingMappings.Mapping<Item> mapping : mappings){
			if(!mapping.key.getResourceDomain().equals(References.MODID)) continue;
			String name = mapping.key.toString().toLowerCase();
			if(MissingMappings.itemNames.contains(name)){
				for(int i = 0; i < MissingMappings.itemNames.size(); i++){
					if(MissingMappings.itemNames.get(i).equals(name)){
						mapping.remap(remapItems.get(i));
					}
				}
			}else if(MissingMappings.itemNamesIgnore.contains(name)){
				mapping.ignore();
			}
		}
	}
	
	@SubscribeEvent
	public static void MissingMappingsEntities(RegistryEvent.MissingMappings<Skill> event){
		ImmutableList<Mapping<Skill>> mappings = event.getAllMappings();
		for(RegistryEvent.MissingMappings.Mapping<Skill> mapping : mappings){
			if(!mapping.key.getResourceDomain().equals(References.MODID)) continue;
			mapping.ignore();
		}
	}
	
//	for (RegistryEvent.MissingMappings.Mapping mapping : event.getAllMappings()) {
//	if (MissingMappings.oldName.contains(mapping..toUpperCase())) {
//		System.out.println(mapping.name);
//		for(int i = 0; i < MissingMappings.oldName.size(); i++){
//			if(MissingMappings.oldName.get(i).equals(mapping.name.toUpperCase())){
//				if (mapping.type == GameRegistry.Type.BLOCK) {
//					mapping.remap((Block) MissingMappings.toRemap.get(i));
//				} else {
//					if(MissingMappings.toRemap.get(i) instanceof Block){
//						if(Item.getItemFromBlock((Block)MissingMappings.toRemap.get(i)) != null)
//						mapping.remap(Item.getItemFromBlock((Block)MissingMappings.toRemap.get(i)));
//					}else {
//						mapping.remap((Item) MissingMappings.toRemap.get(i));
//					}
//				}
//				break;
//			}
//		}
//		continue;
//	}
//}
}
