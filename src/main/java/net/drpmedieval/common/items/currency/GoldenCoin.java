package net.drpmedieval.common.items.currency;

import net.drpcore.api.items.CurrencyBase;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;

public class GoldenCoin extends CurrencyBase {

	public GoldenCoin() {
		super(10000, null);
		this.setRegistryName("GoldenCoin");
		this.setUnlocalizedName("GoldenCoin");
		this.setMaxStackSize(100);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
		this.setValue(10000);
	}
}
