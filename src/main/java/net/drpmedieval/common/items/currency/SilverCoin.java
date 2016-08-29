package net.drpmedieval.common.items.currency;

import net.drpcore.api.items.CurrencyBase;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
public class SilverCoin extends CurrencyBase {

	public SilverCoin() {
		super(100, null);
		this.setRegistryName("SilverCoin");
		this.setUnlocalizedName("SilverCoin");
		this.setMaxStackSize(100);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
		this.setValue(100);
	}
}