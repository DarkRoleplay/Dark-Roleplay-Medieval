package net.dark_roleplay.medieval.common.items.food;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.ItemFood;

public class PumpkinBread extends ItemFood {

	public PumpkinBread() {
		super(6, 0.5F, false);
		setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		this.setRegistryName("PumpkinBread");
		setUnlocalizedName("PumpkinBread");
		setMaxStackSize(64);
	}

}
