package net.dark_roleplay.medieval.common.blocks;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.objectweb.asm.Type;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.blocks.decorative.apiaries.Apiary;
import net.dark_roleplay.medieval.common.blocks.templates.WoodenBlock;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.items.blocks.WoodTypeItemBlock;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.IStringSerializable;

public class WoodHelper {
	
	private static HashMap<WoodType, String> ApiaryKeys = new HashMap<WoodType, String>();
	private static HashMap<String, Apiary> Apiaries = new HashMap<String, Apiary>();
	public static WoodType[] apiaryTypes;
	
	
	
	public static void init(){
		
		//Apiarys
		int apiaryAmount = 0;
		ArrayList<WoodType> types = new ArrayList<WoodType>(Arrays.asList(WoodType.values()));
		while(types.size() >= 1){
			apiaryTypes = new WoodType[types.size() > 4 ? 4 : types.size()];
			for(int i = 0; i < 4; i++){
				if(types.size() >= 1){
					apiaryTypes[i] = types.get(0);
					ApiaryKeys.put(types.get(0), "apiary" + String.valueOf(apiaryAmount));
					types.remove(0);
				}else{
					break;
				}
			}
			Apiaries.put("apiary" + String.valueOf(apiaryAmount), new Apiary("apiary" + String.valueOf(apiaryAmount) ,apiaryTypes));
			DRPMedievalBlocks.registerBlock(Apiaries.get("apiary" + String.valueOf(apiaryAmount)), new WoodTypeItemBlock(Apiaries.get("apiary" + String.valueOf(apiaryAmount))).setHasSubtypes(true));
			apiaryAmount++;
		}
	}
	
	public static WoodType[] woodTypesForCurrentBlock;
	
	public static void initBlocks(Class<WoodenBlock> blockClass, String registryName){
		
		Method m;
		try {
			m = blockClass.getMethod("getTypeAmount", Double.class, String.class);
			int maxTypes = (int) m.invoke(null, "");
			
			int amount = 0;
			ArrayList<WoodType> types = new ArrayList<WoodType>(Arrays.asList(WoodType.values()));
			while(types.size() >= 1){
				woodTypesForCurrentBlock = new WoodType[types.size() > maxTypes ? maxTypes : types.size()];
				for(int i = 0; i < maxTypes; i++){
					if(types.size() >= 1){
						woodTypesForCurrentBlock[i] = types.get(0);
						//ApiaryKeys.put(types.get(0), "apiary" + String.valueOf(apiaryAmount));TODO FIX THE WOOD TYPE THINGI
						types.remove(0);
					}else{
						break;
					}
				}
				Constructor<WoodenBlock> ctor = blockClass.getConstructor(String.class);
				WoodenBlock block = ctor.newInstance(new Object[] { registryName, apiaryTypes});
				
				Apiaries.put(registryName + String.valueOf(amount), new Apiary(registryName + String.valueOf(amount) ,apiaryTypes));
				DRPMedievalBlocks.registerBlock(Apiaries.get(registryName + String.valueOf(amount)), new WoodTypeItemBlock(Apiaries.get(registryName + String.valueOf(amount))).setHasSubtypes(true));
				amount++;
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
	public static enum WoodType implements IStringSerializable {
		//Vanila
		OAK("oak", MapColor.WOOD, true),
        SPRUCE("spruce", MapColor.OBSIDIAN, true),
        BIRCH("birch", MapColor.SAND, true),
        JUNGLE("jungle", MapColor.DIRT, true),
        ACACIA("acacia", MapColor.ADOBE, true),
        DARK_OAK("dark_oak", "big_oak", MapColor.BROWN, true),
		
        //Dark Roleplay Medieval
		APPLE("apple", MapColor.WOOD, false);
		
		private final String name;
		private final String unlocalizedName;
		private final MapColor mapColor;
		private final boolean isVanilla;

		private WoodType(String nameIn, MapColor mapColorIn, boolean isVanilla) {
			this(nameIn, nameIn, mapColorIn, isVanilla);
		}

		private WoodType(String nameIn, String unlocalizedNameIn, MapColor mapColorIn, boolean isVanilla) {
			this.name = nameIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
			this.isVanilla = isVanilla;
		}
		
		public MapColor getMapColor() {
			return this.mapColor;
		}

		public String toString() {
			return this.name;
		}

		public String getName() {
			return this.name;
		}

		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}
	}

}
