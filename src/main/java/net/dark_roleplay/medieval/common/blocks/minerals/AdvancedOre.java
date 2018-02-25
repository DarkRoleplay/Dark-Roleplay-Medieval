package net.dark_roleplay.medieval.common.blocks.minerals;

import java.util.Random;

import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class AdvancedOre extends Block{
	
	private Item ore = null;
	
    public AdvancedOre(String registryName, int harvestLevel){
        super(Material.ROCK);
        this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
        this.setCreativeTab(DRPMedievalCreativeTabs.BUILDING_MATS);
        this.setSoundType(SoundType.STONE);
        this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", harvestLevel);
        this.setResistance(5.0F);
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
    	return ore;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random){
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune)){
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0){
                i = 0;
            }
            return (2 + random.nextInt(3)) * (i + 1);
        }else {
            return 2 + random.nextInt(3);
        }
    }
    
    public void init(Item ore){
    	this.ore = ore;
    }
}