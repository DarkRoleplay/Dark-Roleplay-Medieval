package net.drpmedieval.common.blocks.plants;

import net.drpmedieval.common.blocks.helper.TreePlant;
import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.drpmedieval.common.handler.DRPMedievalItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.ItemStack;

public class PearYellow extends TreePlant {

	public PearYellow() {
		super(4, 25F, true, new ItemStack(DRPMedievalItems.PearYellow, 1));
		this.setRegistryName("PearYellow");
		this.setUnlocalizedName("PearYellow");
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
	}

	static { 
		AGE = PropertyInteger.create("age", 0, 5);
	}
}
