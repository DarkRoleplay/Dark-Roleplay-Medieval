package net.dark_roleplay.medieval.common.util;

import java.util.HashMap;
import java.util.List;

import net.minecraft.item.Item;

public class LoreHelper {
	
	public static HashMap<Item, List<String>> Lores = new HashMap<Item, List<String>>();
	public static HashMap<Item, List<String>> Descriptions = new HashMap<Item, List<String>>();

	
	public static void registerItemLore(Item item, List<String> lore){
		Lores.put(item, lore);
	}
	
	public static boolean hasItemLore(Item item){
		return Lores.containsKey(item);
	}
	
	public static List<String> getItemLore(Item item){
		return Lores.get(item);
	}

	public static void registerItemDesc(Item item, List<String> desc){
		Descriptions.put(item, desc);
	}
	
	public static boolean hasItemDesc(Item item){
		return Descriptions.containsKey(item);
	}
	
	public static List<String> getItemDesc(Item item){
		return Descriptions.get(item);
	}
}
