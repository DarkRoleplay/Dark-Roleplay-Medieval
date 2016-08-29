package net.drpmedieval.common.items.currency;

import net.drpcore.api.items.CurrencyBase;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;


public class BronzeCoin extends CurrencyBase {

	public BronzeCoin() {
		super(1, null);
		this.setRegistryName("BronzeCoin");
		this.setUnlocalizedName("BronzeCoin");
		this.setMaxStackSize(100);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
		this.setValue(1);
	}
}
