package net.drpmedieval.common.items.food;

import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.ItemFood;

public class PearGreen extends ItemFood {

	public PearGreen() {
		super(4, 0.3F, false);
		setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		this.setRegistryName("PearGreen");
		setUnlocalizedName("PearGreen");
		setMaxStackSize(64);
	}

}
