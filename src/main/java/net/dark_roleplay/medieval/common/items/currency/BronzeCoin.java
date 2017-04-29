package net.dark_roleplay.medieval.common.items.currency;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.Item;


public class BronzeCoin extends Item {

	public BronzeCoin() {
		//super(1, null);
		this.setRegistryName("BronzeCoin");
		this.setUnlocalizedName("BronzeCoin");
		this.setMaxStackSize(50);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
		//this.setValue(1);
	}
}
