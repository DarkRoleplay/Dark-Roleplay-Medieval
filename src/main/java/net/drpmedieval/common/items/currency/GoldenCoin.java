package net.drpmedieval.common.items.currency;

import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.Item;

public class GoldenCoin extends Item {

	public GoldenCoin() {
		//super(10000, null);
		this.setRegistryName("GoldenCoin");
		this.setUnlocalizedName("GoldenCoin");
		this.setMaxStackSize(50);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
		//this.setValue(10000);
	}
}
