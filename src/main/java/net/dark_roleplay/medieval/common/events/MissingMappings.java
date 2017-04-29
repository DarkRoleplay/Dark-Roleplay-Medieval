package net.dark_roleplay.medieval.common.events;

import java.util.ArrayList;

import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MissingMappings {
	
	public static ArrayList<net.minecraftforge.fml.common.registry.IForgeRegistryEntry.Impl> toRemap = new ArrayList<net.minecraftforge.fml.common.registry.IForgeRegistryEntry.Impl>();
	public static ArrayList<String> oldName = new ArrayList<String>();
	
	public static void registerToRemap(net.minecraftforge.fml.common.registry.IForgeRegistryEntry.Impl obj, String oldName2){
		toRemap.add(obj);
		oldName.add(oldName2.toUpperCase());
	}
	
	public static void MissingMappingsEvent(FMLMissingMappingsEvent event){
		for (FMLMissingMappingsEvent.MissingMapping mapping : event.getAll()) {
			if (MissingMappings.oldName.contains(mapping.name.toUpperCase())) {
				System.out.println(mapping.name);
				for(int i = 0; i < MissingMappings.oldName.size(); i++){
					if(MissingMappings.oldName.get(i).equals(mapping.name.toUpperCase())){
						if (mapping.type == GameRegistry.Type.BLOCK) {
							mapping.remap((Block) MissingMappings.toRemap.get(i));
						} else {
							if(MissingMappings.toRemap.get(i) instanceof Block){
								if(Item.getItemFromBlock((Block)MissingMappings.toRemap.get(i)) != null)
								mapping.remap(Item.getItemFromBlock((Block)MissingMappings.toRemap.get(i)));
							}else {
								mapping.remap((Item) MissingMappings.toRemap.get(i));
							}
						}
						break;
					}
				}
				continue;
			}
		}
	}
}
