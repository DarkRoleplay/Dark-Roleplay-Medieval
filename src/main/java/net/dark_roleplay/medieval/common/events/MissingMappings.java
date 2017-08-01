package net.dark_roleplay.medieval.common.events;

import java.util.ArrayList;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber
public class MissingMappings {
	
	public static ArrayList<IForgeRegistryEntry.Impl> toRemap = new ArrayList<IForgeRegistryEntry.Impl>();
	public static ArrayList<String> oldName = new ArrayList<String>();
	
	public static void registerToRemap(IForgeRegistryEntry.Impl obj, String oldName2){
		toRemap.add(obj);
		oldName.add(oldName2.toUpperCase());
	}
	
	@SubscribeEvent
	public static void MissingMappingsBlock(RegistryEvent.MissingMappings<Block> event){
		ImmutableList<Mapping<Block>> mappings = event.getAllMappings();
		for(RegistryEvent.MissingMappings.Mapping mapping : mappings){
			String name = mapping.key.toString().toUpperCase();
			if(MissingMappings.oldName.contains(name)){
				for(int i = 0; i < MissingMappings.oldName.size(); i++){
					if(MissingMappings.oldName.get(i).equals(name) && toRemap.get(i) instanceof Block){
						mapping.remap(toRemap.get(i));
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
			if(MissingMappings.oldName.contains(name)){
				for(int i = 0; i < MissingMappings.oldName.size(); i++){
					if(MissingMappings.oldName.get(i).equals(name)){
						if(toRemap.get(i) instanceof Item){
							mapping.remap(toRemap.get(i));
						}else if(toRemap.get(i) instanceof Block){
							if(Item.getItemFromBlock((Block) toRemap.get(i)) != null){
								mapping.remap(Item.getItemFromBlock((Block) toRemap.get(i)));
							}
						}
					}
				}
			}
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
