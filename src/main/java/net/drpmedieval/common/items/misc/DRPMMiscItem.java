package net.drpmedieval.common.items.misc;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.item.Item;

public class DRPMMiscItem extends Item {

	public DRPMMiscItem(String registryName) {
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}
}
