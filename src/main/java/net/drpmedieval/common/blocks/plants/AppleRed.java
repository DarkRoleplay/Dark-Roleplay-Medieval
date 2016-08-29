package net.drpmedieval.common.blocks.plants;

import net.drpmedieval.common.blocks.helper.TreePlant;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AppleRed extends TreePlant {

	public AppleRed() {
		super(4, 25F, true, new ItemStack(Items.APPLE, 1));
		this.setRegistryName("AppleRed");
		this.setUnlocalizedName("AppleRed");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
		this.setHardness(0.5F);
		this.setSoundType(SoundType.PLANT);
		this.setTickRandomly(true);
	}

	static { 
		AGE = PropertyInteger.create("age", 0, 5);
	}
}
