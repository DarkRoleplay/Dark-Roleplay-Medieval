package net.dark_roleplay.medieval.common.handler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DRPMedievalCreativeTabs {

	public static CreativeTabs DECORATION = (new CreativeTabs("drpm_deco") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(DRPMedievalBlocks.FLOWER_POT);
		}
		
		@Override
		public boolean hasSearchBar(){
	        return true;
	    }
		
		@Override
		public int getSearchbarWidth(){
		    return 75;
		}
	}.setBackgroundImageName("drpmedieval.png"));
	
	public static CreativeTabs BUILDING_MATS = (new CreativeTabs("drpm_build_mats") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(DRPMedievalBlocks.MOSSY_SPRUCE_LOG));
		}
		
		@Override
		public boolean hasSearchBar(){
	        return true;
	    }
		
		@Override
		public int getSearchbarWidth(){
		    return 75;
		}
	}.setBackgroundImageName("drpmedieval.png"));
	
	public static CreativeTabs UTILITY = new CreativeTabs("drpm_utility") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(Item.getItemFromBlock(DRPMedievalBlocks.CHOPPING_BLOCK));
		}
		
		@Override
		public boolean hasSearchBar(){
	        return true;
	    }
		
		@Override
		public int getSearchbarWidth(){
		    return 75;
		}
	}.setBackgroundImageName("drpmedieval.png");

	public static CreativeTabs FOOD = new CreativeTabs("drpm_food") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(DRPMedievalItems.FISH_COOKED_CATFISH);
		}
		
		@Override
		public boolean hasSearchBar(){
	        return true;
	    }
		
		@Override
		public int getSearchbarWidth(){
		    return 75;
		}
	}.setBackgroundImageName("drpmedieval.png");

	public static CreativeTabs EQUIPMENT = new CreativeTabs("drpm_equip") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack((DRPMedievalItems.LEATHER_PURSE));
		}
		
		@Override
		public boolean hasSearchBar(){
	        return true;
	    }
		
		@Override
		public int getSearchbarWidth(){
		    return 75;
		}
	}.setBackgroundImageName("drpmedieval.png");

	public static CreativeTabs MISCELLANEOUS = new CreativeTabs("drpm_misc") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(DRPMedievalItems.FIREWOOD, 1, 2);
		}
		
		@Override
		public boolean hasSearchBar(){
	        return true;
	    }
		
		@Override
		public int getSearchbarWidth(){
		    return 75;
		}
	}.setBackgroundImageName("drpmedieval.png");

}
