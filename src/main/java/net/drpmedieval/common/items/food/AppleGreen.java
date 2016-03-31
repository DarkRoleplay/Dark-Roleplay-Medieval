package net.drpmedieval.common.items.food;

import java.util.List;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AppleGreen extends ItemFood{

	public AppleGreen(){
		super(4, 0.3F, false);
		setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
		setUnlocalizedName("itemAppleGreen");
		setMaxStackSize(64);
	}
}
