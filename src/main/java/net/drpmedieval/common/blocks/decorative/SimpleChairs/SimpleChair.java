package net.drpmedieval.common.blocks.decorative.SimpleChairs;

import net.drpmedieval.common.blocks.decorative.Chair;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SimpleChair extends Chair{

	public SimpleChair(String registryName){
		super(Material.WOOD,registryName,registryName , 4 * 0.0625F);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
	}
	
}
