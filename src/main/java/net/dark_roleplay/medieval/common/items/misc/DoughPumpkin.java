package net.dark_roleplay.medieval.common.items.misc;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
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

	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items){
		for(int i = 0; i < 2; i++){
			items.add(new ItemStack(this, 1, i));
		}
	}
}
