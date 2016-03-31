package net.drpmedieval.common.blocks.plants;

import net.drpmedieval.common.items.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class Barley extends BlockCrops{

	public Barley(){
		this.setUnlocalizedName("blockBarley");
	}
	
	protected boolean canPlaceBlockOn(Block ground)
	{
	        return ground == Blocks.farmland;
	}
	
	protected Item getSeed()
    {
        return DRPMedievalItems.itemSeedBarley;
    }

    protected Item getCrop()
    {
        return DRPMedievalItems.itemBarley;
    }
	
}
