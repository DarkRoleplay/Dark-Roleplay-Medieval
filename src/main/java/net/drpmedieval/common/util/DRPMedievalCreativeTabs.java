package net.drpmedieval.common.util;

import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.dark_roleplay.drpcore.api.items.DRPItem;
import net.drpmedieval.common.blocks.DRPMBlocks;
import net.drpmedieval.common.items.DRPMItems;
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
			return new ItemStack(DRPMBlocks.FLOWER_POT);
			//return Item.getItemFromBlock(DRPMedievalBlocks.SIMPLE_CHAIR_OAK);
		}
	};
	
	public static CreativeTabs BUILDING_MATS = new CreativeTabs("DRPMBuildingMats") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(DRPMBlocks.MOSSY_LOG_SPRUCE));
		}
	};
	
	public static CreativeTabs UTILITY = new CreativeTabs("DRPMUtility") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(Item.getItemFromBlock(DRPMBlocks.CHOPPING_BLOCK));
		}
	};

	public static CreativeTabs drpmedievalFoodTab = new CreativeTabs("DRPMFood") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(DRPMItems.CatfishCooked);
		}
	};

	public static CreativeTabs drpmedievalEquipTab = new CreativeTabs("DRPEquip") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack((Item)((DRPEquip)((DRPItem) DRPMItems.LeatherPurse)));
		}
	};

	public static CreativeTabs drpmedievalMiscTab = new CreativeTabs("DRPMMisc") {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {

			return new ItemStack(DRPMItems.Firewood,1,2);
		}
	};

}
