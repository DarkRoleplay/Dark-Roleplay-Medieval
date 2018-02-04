package net.dark_roleplay.medieval.common.blocks.plants;

import net.dark_roleplay.drpcore.api.blocks.Crop;
import net.dark_roleplay.drpcore.modules.time.Season;
import net.dark_roleplay.medieval.api.blocks.plants.Block_AdvancedCrop;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class Barley extends Crop{

	private static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	
	public Barley(String registryName) {
		super(30, Season.LATE_SPRING, Season.EARLY_SUMMER, Season.MIDDLE_SUMMER, Season.LATE_SUMMER, Season.EARLY_AUTUMN);
		this.setRegistryName(registryName);
	}
}
