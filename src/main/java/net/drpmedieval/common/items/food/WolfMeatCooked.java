package net.drpmedieval.common.items.food;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.item.ItemFood;

public class WolfMeatCooked extends ItemFood{
	
	public WolfMeatCooked(){
		super(6, 0.4F, false);
		setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		setUnlocalizedName("itemWolfMeatCooked");
		setMaxStackSize(64);
	}
}
