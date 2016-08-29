package net.drpmedieval.common.items.misc;

import java.util.List;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DoughPumpkin extends Item {

	private static String unlocalizedName = "DoughPumpkin";

	public DoughPumpkin() {
		this.setHasSubtypes(true);
		this.setRegistryName("DoughPumpkin");
		this.setUnlocalizedName("DoughPumpkin");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {

		List<ItemStack> subItems2 = (List<ItemStack>) subItems;

		for(int i = 0; i < 2; i++){
			subItems2.add(new ItemStack(itemIn, 1, i));
		}

		subItems = subItems2;
	}

}
