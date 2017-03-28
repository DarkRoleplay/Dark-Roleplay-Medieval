package net.drpmedieval.common.items.misc;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.item.Item;

public class Tap extends Item {

	public Tap(String registryName) {
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}
}
