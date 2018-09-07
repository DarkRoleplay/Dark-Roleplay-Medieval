package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DRPMedievalCreativeTabs {

	public static DRPCreativeTab DECORATION = new DRPCreativeTab("drpm_deco");
	
	public static DRPCreativeTab BUILDING_MATS = new DRPCreativeTab("drpm_build_mats");
	
	public static DRPCreativeTab UTILITY = new DRPCreativeTab("drpm_utility");

	public static DRPCreativeTab FOOD = new DRPCreativeTab("drpm_food");

	public static DRPCreativeTab EQUIPMENT = new DRPCreativeTab("drpm_equip");

	public static DRPCreativeTab MISCELLANEOUS = new DRPCreativeTab("drpm_misc");

	private static class DRPCreativeTab extends CreativeTabs{
		
		protected ItemStack previewStack;
		
		public DRPCreativeTab(String label) {
			super(label);
			this.setBackgroundImageName("drpmedieval.png");
		}
		
		@Override
		public int getSearchbarWidth(){
		    return 75;
		}
		
		@Override
		public boolean hasSearchBar(){
	        return true;
	    }

		@Override
		public ItemStack getTabIconItem() {
			return previewStack;
		}
		
		public CreativeTabs setPreviewStack(ItemStack stack){
			this.previewStack = stack;
			return this;
		}
		
		@SideOnly(Side.CLIENT)
	    public void displayAllRelevantItems(NonNullList<ItemStack> items){
			NonNullList<ItemStack> cache = NonNullList.<ItemStack>create();
	        for (Item item : Item.REGISTRY){
	        	if(isWooden(item)){
		            item.getSubItems(this, cache);
	        	}else{
		            item.getSubItems(this, items);
	        	}
	        }
	        for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
	        	String name = mat.getName();
	        	for(ItemStack stack : cache){
	        		if(stack.getItem().getRegistryName().getResourcePath().contains(name)){
	        			if(items.contains(stack)){
	        				items.remove(stack);
	        			}
	        			items.add(stack);
	        		}
	        	}
	        }
	    }
		
		private static boolean isWooden(Item item){
	        for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
	        	String name = mat.getName();
		        if(item.getRegistryName().getResourcePath().contains(name)){
	    			return true;
	    		}
			 }
			return false;
		}
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		MISCELLANEOUS.setPreviewStack(new ItemStack(DRPMedievalItems.HAY));
		EQUIPMENT.setPreviewStack(new ItemStack(DRPMedievalItems.LEATHER_PURSE));
		FOOD.setPreviewStack(new ItemStack(DRPMedievalItems.COOKED_CATFISH));
		UTILITY.setPreviewStack(new ItemStack(Item.getItemFromBlock(DRPMedievalBlocks.OAK_CHOPPING_BLOCK)));
		BUILDING_MATS.setPreviewStack(new ItemStack(Item.getItemFromBlock(DRPMedievalBlocks.MOSSY_SPRUCE_LOG)));
		DECORATION.setPreviewStack(new ItemStack(DRPMedievalBlocks.FLOWER_POT));
	}
}
