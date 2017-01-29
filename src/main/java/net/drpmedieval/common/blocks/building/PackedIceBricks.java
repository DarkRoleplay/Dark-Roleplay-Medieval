package net.drpmedieval.common.blocks.building;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class PackedIceBricks extends Block{

	public PackedIceBricks(String registryName) {
	    super(Material.ICE);
	    this.setRegistryName(registryName);
	    this.setUnlocalizedName(registryName);
	    this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
	}

	
	
}
