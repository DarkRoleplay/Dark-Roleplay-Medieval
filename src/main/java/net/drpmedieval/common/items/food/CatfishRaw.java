package net.drpmedieval.common.items.food;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class CatfishRaw extends ItemFood {

	public CatfishRaw() {
		super(2, 0.3F, false);
		setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		setUnlocalizedName("itemCatfishRaw");
		setMaxStackSize(64);
	}
}
