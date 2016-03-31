package net.drpmedieval.common.items.food;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.item.ItemFood;

public class PumpkinBread extends ItemFood{

	public PumpkinBread(){
		super(6, 0.5F, false);
		setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		setUnlocalizedName("itemPumpkinBread");
		setMaxStackSize(64);
	}
	
}
