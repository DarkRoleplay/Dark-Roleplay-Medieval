package net.dark_roleplay.medieval.common.blocks.building;

import java.util.Random;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SnowBricks extends Block{

	public SnowBricks(String registryName) {
	    super(Material.CRAFTED_SNOW);
	    this.setRegistryName(registryName);
	    this.setUnlocalizedName(registryName);
	    this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
	    this.setHardness(0.1F);
	    this.setSoundType(SoundType.SNOW);
    }	
}
