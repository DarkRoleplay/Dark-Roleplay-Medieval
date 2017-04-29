package net.dark_roleplay.medieval.common.items.food;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.ItemFood;

public class AppleYellow extends ItemFood {

	public AppleYellow() {
		super(4, 0.3F, false);
		setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		this.setRegistryName("AppleYellow");
		setUnlocalizedName("AppleYellow");
		setMaxStackSize(64);
	}

}
