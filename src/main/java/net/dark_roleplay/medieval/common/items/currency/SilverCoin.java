package net.dark_roleplay.medieval.common.items.currency;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.Item;

public class SilverCoin extends Item {

	public SilverCoin() {
		//super(100, null);
		this.setRegistryName("SilverCoin");
		this.setUnlocalizedName("SilverCoin");
		this.setMaxStackSize(50);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}
}