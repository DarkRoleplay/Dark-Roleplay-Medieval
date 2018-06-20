package net.dark_roleplay.medieval.common.objects.blocks.plants;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.common.objects.blocks.helper.TreePlant;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.ItemStack;

public class AppleYellow extends TreePlant {

	public AppleYellow() {
		super(4, 25F, true, new ItemStack(DRPMedievalItems.APPLE_YELLOW, 1));
		this.setRegistryName("AppleYellow");
		this.setUnlocalizedName("AppleYellow");
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
	}

	static { 
		TreePlant.AGE = PropertyInteger.create("age", 0, 5);
	}
}
