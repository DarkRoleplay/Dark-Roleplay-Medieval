package net.dark_roleplay.medieval.common.objects.blocks.plants;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.objects.blocks.helper.TreePlant;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AppleRed extends TreePlant {

	public AppleRed() {
		super(4, 25F, true, new ItemStack(Items.APPLE, 1));
		this.setRegistryName("AppleRed");
		this.setUnlocalizedName("AppleRed");
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
	}

	static { 
		AGE = PropertyInteger.create("age", 0, 5);
	}
}
