package net.dark_roleplay.medieval.common.items.food;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.ItemFood;

public class WolfMeatRaw extends ItemFood {

	public WolfMeatRaw() {
		super(2, 0.15F, false);
		setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		this.setRegistryName("WolfMeatRaw");
		setUnlocalizedName("WolfMeatRaw");
		setMaxStackSize(64);
	}

}
