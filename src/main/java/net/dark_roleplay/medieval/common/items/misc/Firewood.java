package net.dark_roleplay.medieval.common.items.misc;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Firewood extends Item {

	private static String unlocalizedName = "Firewood";

	public Firewood() {
		this.setHasSubtypes(true);
		this.setRegistryName("Firewood");
		this.setUnlocalizedName("Firewood");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems){
		for(int i = 0; i < 6; i++){
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}
}
