package net.dark_roleplay.medieval.common.objects.events;

import java.util.ArrayList;

import com.google.common.collect.ImmutableList;

import net.dark_roleplay.core.testing.skills.Skill;
import net.dark_roleplay.medieval.References;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = References.MODID)
public class MissingMappings {

	public static ArrayList<Block> remapBlocks = new ArrayList<Block>();
	public static ArrayList<String> blockNames = new ArrayList<String>();
	public static ArrayList<String> blockNamesIgnore = new ArrayList<String>();
	public static ArrayList<Item> remapItems = new ArrayList<Item>();
	public static ArrayList<String> itemNames = new ArrayList<String>();
	public static ArrayList<String> itemNamesIgnore = new ArrayList<String>();

	public static void registerToRemapB(String block, String oldName2){
		if(Block.REGISTRY.containsKey(new ResourceLocation(block))){
			remapBlocks.add(Block.REGISTRY.getObject(new ResourceLocation(block)));
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
		ImmutableList<Mapping<Block>> mappings = event.getMappings();
		for(RegistryEvent.MissingMappings.Mapping<Block> mapping : mappings){
			String name = mapping.key.toString().toLowerCase();
			if(MissingMappings.blockNames.contains(name)){
				for(int i = 0; i < MissingMappings.blockNames.size(); i++){
					if(MissingMappings.blockNames.get(i).equals(name)){
						mapping.remap(remapBlocks.get(i));
					}
				}
			}else if(MissingMappings.blockNamesIgnore.contains(name)){
				mapping.ignore();
			}
		}
	}

	@SubscribeEvent
	public static void MissingMappingsItem(RegistryEvent.MissingMappings<Item> event){
		ImmutableList<Mapping<Item>> mappings = event.getMappings();
		for(RegistryEvent.MissingMappings.Mapping<Item> mapping : mappings){
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
			if(!mapping.key.getNamespace().equals(References.MODID)) continue;
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
