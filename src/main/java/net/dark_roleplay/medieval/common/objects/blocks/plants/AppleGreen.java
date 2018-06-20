package net.dark_roleplay.medieval.common.objects.blocks.plants;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.common.objects.blocks.helper.TreePlant;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.ItemStack;

public class AppleGreen extends TreePlant {

	public AppleGreen() {
		super(4, 25F, true, new ItemStack(DRPMedievalItems.APPLE_GREEN, 1));
		this.setRegistryName("AppleGreen");
		this.setUnlocalizedName("AppleGreen");
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
	}

	static { 
		TreePlant.AGE = PropertyInteger.create("age", 0, 5);
	}
}
