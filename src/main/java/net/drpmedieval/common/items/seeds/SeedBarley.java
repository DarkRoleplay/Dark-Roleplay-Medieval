package net.drpmedieval.common.items.seeds;

import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class SeedBarley extends ItemSeeds {

	public SeedBarley() {
		super(DRPMedievalBlocks.barley, Blocks.farmland);
		this.setUnlocalizedName("itemSeedBarley");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}

}
