package net.dark_roleplay.medieval.common.util;

import java.util.HashMap;
import java.util.List;

import net.minecraft.item.Item;

public class LoreHelper {
	
	public static HashMap<Item, List<String>> CTRL_DESC = new HashMap<Item, List<String>>();
	public static HashMap<Item, List<String>> ALT_DESC = new HashMap<Item, List<String>>();
	public static HashMap<Item, List<String>> SHIFT_DESC = new HashMap<Item, List<String>>();
	public static HashMap<Item, List<String>> PERM_DESC = new HashMap<Item, List<String>>();
	
	public static void registerCTRL_DESC(Item item, List<String> lore){
		LoreHelper.CTRL_DESC.put(item, lore);
	}
	
	public static void registerALT_DESC(Item item, List<String> lore){
		LoreHelper.ALT_DESC.put(item, lore);
	}
	
	public static void registerSHIFT_DESC(Item item, List<String> lore){
		LoreHelper.SHIFT_DESC.put(item, lore);
	}
	
	public static void registerPERM_DESC(Item item, List<String> lore){
		LoreHelper.PERM_DESC.put(item, lore);
	}
	
	
	public static boolean hasCTRL_DESC(Item item){
		return LoreHelper.CTRL_DESC.containsKey(item);
	}
	
	public static boolean hasALT_DESC(Item item){
		return LoreHelper.ALT_DESC.containsKey(item);
	}
	
	public static boolean hasSHIFT_DESC(Item item){
		return LoreHelper.SHIFT_DESC.containsKey(item);
	}
	
	public static boolean hasPERM_DESC(Item item){
		return LoreHelper.PERM_DESC.containsKey(item);
	}
	
	public static List<String> getCTRL_DESC(Item item){
		return LoreHelper.CTRL_DESC.get(item);
	}

	public static List<String> getALT_DESC(Item item){
		return LoreHelper.ALT_DESC.get(item);
	}
	
	public static List<String> getSHIFT_DESC(Item item){
		return LoreHelper.SHIFT_DESC.get(item);
	}
	
	public static List<String> getPERM_DESC(Item item){
		return LoreHelper.PERM_DESC.get(item);
	}
}
