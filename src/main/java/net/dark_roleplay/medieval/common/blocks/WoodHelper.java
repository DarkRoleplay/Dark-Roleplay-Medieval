package net.dark_roleplay.medieval.common.blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.blocks.templates.WoodenBlock2;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.IStringSerializable;

public class WoodHelper {

	private static HashMap<Block, PropertyEnum> properties = new HashMap<Block, PropertyEnum>();
	
	private static List<WoodType> types = new ArrayList<WoodType>();
	
	private static List<WoodenBlock2> blocks = new ArrayList<WoodenBlock2>();
	
	public static void registerType(WoodType type){
		WoodHelper.types.add(type);
	}
	
	public static void registerBlock(WoodenBlock2 block){
		WoodHelper.blocks.add(block);
	}
	
	public static void init(){
		
	}
	
	public static WoodType[] woodTypesForCurrentBlock;
	
	public static enum WoodType implements IStringSerializable {
		//Vanila
		OAK("minecraft", "oak", MapColor.WOOD),
        SPRUCE("minecraft", "spruce", MapColor.OBSIDIAN),
        BIRCH("minecraft", "birch", MapColor.SAND),
        JUNGLE("minecraft", "jungle", MapColor.DIRT),
        ACACIA("minecraft", "acacia", MapColor.ADOBE),
        DARK_OAK("minecraft", "dark_oak", "big_oak", MapColor.BROWN),
		
        //Dark Roleplay Medieval
		APPLE(DRPMedievalInfo.MODID, "apple", MapColor.WOOD);
		
		private final String modid;
		private final String name;
		private final String unlocalizedName;
		private final MapColor mapColor;
		
		private WoodType(String modid, String nameIn, MapColor mapColorIn) {
			this(modid, nameIn, nameIn, mapColorIn);
		}

		private WoodType(String modid, String nameIn, String unlocalizedNameIn, MapColor mapColorIn) {
			this.name = nameIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
			this.modid = modid;
		}
		
		public MapColor getMapColor() {
			return this.mapColor;
		}

		@Override
		public String toString() {
			return this.name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}
		
		public String getModID(){
			return this.modid;
		}
	}

}
