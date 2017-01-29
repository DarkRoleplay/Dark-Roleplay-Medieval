package net.drpmedieval.common.util;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DRPMedievalCreativeTabs {

	public static CreativeTabs DECORATION = new CreativeTabs("DRPMedievalDecorationTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(DRPMedievalItems.AppleGreen);
			//return Item.getItemFromBlock(DRPMedievalBlocks.SIMPLE_CHAIR_OAK);
		}
	};
	
	public static CreativeTabs BUILDING_MATS = new CreativeTabs("DRPMedievalBuildingMaterialsTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(DRPMedievalBlocks.CLEAN_PLANKS));
		}
	};
	
	public static CreativeTabs drpmedievalBlocksTab = new CreativeTabs("DRPMedievalBlocksTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(Item.getItemFromBlock(DRPMedievalBlocks.CHOPPING_BLOCK));
		}
	};

	public static CreativeTabs drpmedievalFoodTab = new CreativeTabs("DRPMedievalFoodTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(DRPMedievalItems.CatfishCooked);
		}
	};

	public static CreativeTabs drpmedievalEquipTab = new CreativeTabs("DRPMedievalEquipTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack((Item) DRPMedievalItems.LeatherPurse);
		}
	};

	public static CreativeTabs drpmedievalMiscTab = new CreativeTabs("DRPMedievalMiscTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(DRPMedievalItems.Firewood,1,2);
		}
	};

}
