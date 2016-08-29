package net.drpmedieval.common.blocks.plants;

import net.drpmedieval.common.blocks.helper.TreePlant;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.ItemStack;

public class AppleYellow extends TreePlant {

	public AppleYellow() {
		super(4, 25F, true, new ItemStack(DRPMedievalItems.AppleYellow, 1));
		this.setRegistryName("AppleYellow");
		this.setUnlocalizedName("AppleYellow");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
	}

	static { 
		AGE = PropertyInteger.create("age", 0, 5);
	}
}
