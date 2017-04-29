package net.dark_roleplay.medieval.common.items.food;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.item.ItemFood;

public class CatfishCooked extends ItemFood {

	public CatfishCooked() {
		super(6, 0.6F, false);
		setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		this.setRegistryName("CatfishCooked");
		setUnlocalizedName("CatfishCooked");
		setMaxStackSize(64);
	}
}
