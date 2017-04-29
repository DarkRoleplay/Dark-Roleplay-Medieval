package net.dark_roleplay.medieval.common.items.misc;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.Item;

public class Tap extends Item {

	public Tap(String registryName) {
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}
}
