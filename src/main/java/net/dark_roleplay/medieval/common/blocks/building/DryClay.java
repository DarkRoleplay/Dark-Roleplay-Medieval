package net.dark_roleplay.medieval.common.blocks.building;

import java.util.Random;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class DryClay extends Block{

	public DryClay(String registryName) {
	    super(Material.CLAY);
	    this.setRegistryName(registryName);
	    this.setUnlocalizedName(registryName);
	    this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
	    this.setHardness(0.6F);
	    this.setSoundType(SoundType.GROUND);
    }	

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
    	return DRPMedievalItems.DRY_CLAY_CHUNK;
    }

    @Override
	public int quantityDropped(Random random){
        return 3 + random.nextInt(2);
    }
}
