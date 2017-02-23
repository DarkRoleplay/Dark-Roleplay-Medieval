package net.drpmedieval.common.items.currency;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
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
