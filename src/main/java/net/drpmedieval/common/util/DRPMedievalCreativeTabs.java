package net.drpmedieval.common.util;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DRPMedievalCreativeTabs {

	public static CreativeTabs drpmedievalBlocksTab = new CreativeTabs("DRPMedievalBlocksTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {

			return Item.getItemFromBlock(DRPMedievalBlocks.choppingBlock);
		}
	};

	public static CreativeTabs drpmedievalFoodTab = new CreativeTabs("DRPMedievalFoodTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {

			return DRPMedievalItems.CatfishCooked;
		}
	};

	public static CreativeTabs drpmedievalEquipTab = new CreativeTabs("DRPMedievalEquipTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {

			return DRPMedievalItems.LeatherPurse;
		}
	};

	public static CreativeTabs drpmedievalMiscTab = new CreativeTabs("DRPMedievalMiscTab") {

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {

			return DRPMedievalItems.Firewood;
		}

		@Override
		@SideOnly(Side.CLIENT)
	    public int getIconItemDamage()
	    {
	        return 2;
	    }
	};

}
