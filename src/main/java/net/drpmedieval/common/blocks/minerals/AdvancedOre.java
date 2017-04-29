package net.drpmedieval.common.blocks.minerals;

import java.util.Random;

import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class AdvancedOre extends Block{
	
	private Item ore;
	
    public AdvancedOre(String registryName){
        super(Material.ROCK);
        this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
        this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
        this.setSoundType(SoundType.STONE);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
    	return ore;
    }

    public int quantityDropped(Random random){
        return 2 + random.nextInt(3);
    }

    public int quantityDroppedWithBonus(int fortune, Random random){
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune)){
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0){
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }else {
            return this.quantityDropped(random);
        }
    }
 
    public void setOre(Item ore){
    	this.ore = ore;
    }
    
}