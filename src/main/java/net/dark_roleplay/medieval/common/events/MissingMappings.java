package net.dark_roleplay.medieval.common.events;

import java.util.ArrayList;

import com.google.common.collect.ImmutableList;

import net.dark_roleplay.drpcore.modules.work_in_progress.skill.Skill;
import net.dark_roleplay.medieval.common.References;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber
public class MissingMappings {
	
	public static ArrayList<Block> remapBlocks = new ArrayList<Block>();
	public static ArrayList<String> blockNames = new ArrayList<String>();
	public static ArrayList<Item> remapItems = new ArrayList<Item>();
	public static ArrayList<String> itemNames = new ArrayList<String>();
	
	public static void registerToRemapB(String block, String oldName2){
		if(Block.REGISTRY.containsKey(new ResourceLocation(References.MODID, block))){
			remapBlocks.add(Block.REGISTRY.getObject(new ResourceLocation(References.MODID, block)));
			blockNames.add(oldName2.toUpperCase());
		}
	}
	
	public static void registerToRemapI(String item, String oldName2){
		if(Item.REGISTRY.containsKey(new ResourceLocation(References.MODID, item))){
			remapItems.add(Item.REGISTRY.getObject(new ResourceLocation(References.MODID, item)));
			itemNames.add(oldName2.toUpperCase());
		}
	}
	
	@SubscribeEvent
	public static void MissingMappingsBlock(RegistryEvent.MissingMappings<Block> event){
		ImmutableList<Mapping<Block>> mappings = event.getAllMappings();
		for(RegistryEvent.MissingMappings.Mapping mapping : mappings){
			String name = mapping.key.toString().toUpperCase();
			if(MissingMappings.blockNames.contains(name)){
				for(int i = 0; i < MissingMappings.blockNames.size(); i++){
					if(MissingMappings.blockNames.get(i).equals(name)){
						mapping.remap(remapBlocks.get(i));
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public static void MissingMappingsItem(RegistryEvent.MissingMappings<Item> event){
		ImmutableList<Mapping<Item>> mappings = event.getAllMappings();
		for(RegistryEvent.MissingMappings.Mapping mapping : mappings){
			String name = mapping.key.toString().toUpperCase();
			if(MissingMappings.itemNames.contains(name)){
				for(int i = 0; i < MissingMappings.itemNames.size(); i++){
					if(MissingMappings.itemNames.get(i).equals(name)){
						mapping.remap(remapItems.get(i));
					}
				}
			}else if(name.equals("DRPMEDIEVAL:SLEDGE") ||
					name.equals("DRPMEDIEVAL:ROPEDARROW") ||
					name.equals("DRPMEDIEVAL:GUNPOWDER_TRAIL")){
				mapping.ignore();
			}
		}
	}
	
	@SubscribeEvent
	public static void MissingMappingsEntities(RegistryEvent.MissingMappings<Skill> event){
		ImmutableList<Mapping<Skill>> mappings = event.getAllMappings();
		for(RegistryEvent.MissingMappings.Mapping mapping : mappings){
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
