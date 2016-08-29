package net.drpmedieval.common.items.crops;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.item.ItemFood;

public class Turnip extends ItemFood {

	public Turnip() {
		super(4, 0.2F, false);
		setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		this.setRegistryName("Turnip");
		setUnlocalizedName("Turnip");
		setMaxStackSize(64);
	}
}
