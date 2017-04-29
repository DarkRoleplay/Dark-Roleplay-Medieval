package net.dark_roleplay.medieval.common.blocks.plants;

import net.dark_roleplay.medieval.common.blocks.helper.TreePlant;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.ItemStack;

public class AppleGreen extends TreePlant {

	public AppleGreen() {
		super(4, 25F, true, new ItemStack(DRPMedievalItems.AppleGreen, 1));
		this.setRegistryName("AppleGreen");
		this.setUnlocalizedName("AppleGreen");
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
	}

	static { 
		AGE = PropertyInteger.create("age", 0, 5);
	}
}
