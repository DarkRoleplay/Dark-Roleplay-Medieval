package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.medieval.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.GameRegistry.ItemStackHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MedievalCreativeTabs {

	@ItemStackHolder(value = References.MODID + ":hay")
	public static final ItemStack MISCELLANEOUS_ICON = null;

	@ItemStackHolder(value = References.MODID + ":bone_war_horn")
	public static final ItemStack EQUIPMENT_ICON = null;

	@ItemStackHolder(value = References.MODID + ":cooked_catfish")
	public static final ItemStack FOOD_ICON = null;

	@ItemStackHolder(value = References.MODID + ":oak_chopping_block")
	public static final ItemStack UTILITY_ICON = null;

	@ItemStackHolder(value = References.MODID + ":mossy_spruce_log")
	public static final ItemStack BUILDING_ICON = null;

	@ItemStackHolder(value = References.MODID + ":flower_pot")
	public static final ItemStack DECORATION_ICON = null;

	public static final DRPCreativeTab DECORATION = new DRPCreativeTab("drpm_deco") {
		@Override public ItemStack createIcon() {return DECORATION_ICON;}
	};

	public static final DRPCreativeTab BUILDING_MATS = new DRPCreativeTab("drpm_build_mats") {
		@Override public ItemStack createIcon() {	return BUILDING_ICON;}
	};

	public static final DRPCreativeTab UTILITY = new DRPCreativeTab("drpm_utility") {
		@Override public ItemStack createIcon() {return UTILITY_ICON;}
	};

	public static final DRPCreativeTab FOOD = new DRPCreativeTab("drpm_food") {
		@Override public ItemStack createIcon() {return FOOD_ICON;}
	};

	public static final DRPCreativeTab EQUIPMENT = new DRPCreativeTab("drpm_equip") {
		@Override public ItemStack createIcon() {return EQUIPMENT_ICON;}
	};

	public static final DRPCreativeTab MISCELLANEOUS = new DRPCreativeTab("drpm_misc") {
		@Override public ItemStack createIcon() {return MISCELLANEOUS_ICON;}
	};

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
		public ItemStack createIcon() {
			return ItemStack.EMPTY;
		}

		@Override
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
	        		if(stack.getItem().getRegistryName().getPath().contains(name)){
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
		        if(item.getRegistryName().getPath().contains(name)){
	    			return true;
	    		}
			 }
			return false;
		}
	}
}
