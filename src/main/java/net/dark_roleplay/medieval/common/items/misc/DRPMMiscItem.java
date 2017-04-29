package net.dark_roleplay.medieval.common.items.misc;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.Item;

public class DRPMMiscItem extends Item {

	public DRPMMiscItem(String registryName) {
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}
}
