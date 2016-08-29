package net.drpmedieval.common.items.food;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
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
