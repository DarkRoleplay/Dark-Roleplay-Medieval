package net.dark_roleplay.medieval.common.handler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DRPMedievalCreativeTabs {

	public static CreativeTabs DECORATION = new CreativeTabs("DRPMDecoration") {
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
	}.setBackgroundImageName("drpmedieval.png");
	
	public static CreativeTabs BUILDING_MATS = new CreativeTabs("DRPMBuildingMats") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(DRPMedievalBlocks.MOSSY_LOG_SPRUCE));
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
	
	public static CreativeTabs UTILITY = new CreativeTabs("DRPMUtility") {

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

	public static CreativeTabs drpmedievalFoodTab = new CreativeTabs("DRPMFood") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(DRPMedievalItems.CatfishCooked);
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

	public static CreativeTabs drpmedievalEquipTab = new CreativeTabs("DRPEquip") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack((DRPMedievalItems.LeatherPurse));
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

	public static CreativeTabs drpmedievalMiscTab = new CreativeTabs("DRPMMisc") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(DRPMedievalItems.Firewood,1,2);
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
