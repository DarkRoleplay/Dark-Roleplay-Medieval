package net.drpmedieval.common.items.misc;

import java.util.List;

import net.drpmedieval.common.blocks.building.CleanPlanks;
import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
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
	
    @SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
    	for(int i = 0; i < 6; i++){
    		subItems.add(new ItemStack(itemIn, 1, i));
		}
    }
}
