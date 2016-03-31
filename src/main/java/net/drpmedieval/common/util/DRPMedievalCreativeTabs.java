package net.drpmedieval.common.util;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DRPMedievalCreativeTabs {

	public static CreativeTabs drpmedievalBlocksTab = new CreativeTabs("DRPMedievalBlocksTab"){
		@SideOnly(Side.CLIENT)
        public Item getTabIconItem(){
                return Item.getItemFromBlock(DRPMedievalBlocks.barrelEmpty);
        }
	};
	
	public static CreativeTabs drpmedievalFoodTab = new CreativeTabs("DRPMedievalFoodTab"){
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return DRPMedievalItems.itemPumpkinStew;
		}
	};
	
	public static CreativeTabs drpmedievalEquipTab = new CreativeTabs("DRPMedievalEquipTab"){
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return DRPMedievalItems.itemQuiver;
		}
	};
	
	public static CreativeTabs drpmedievalMiscTab = new CreativeTabs("DRPMedievalMiscTab"){
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return DRPMedievalItems.itemFurWolf;
		}
	};
	
}
