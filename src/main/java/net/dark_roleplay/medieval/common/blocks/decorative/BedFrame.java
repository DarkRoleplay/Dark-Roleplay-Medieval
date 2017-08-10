package net.dark_roleplay.medieval.common.blocks.decorative;

import net.dark_roleplay.medieval.common.blocks.helper.AdvancedBed;
import net.dark_roleplay.medieval.common.items.blocks.AdvancedBedItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BedFrame extends AdvancedBed {
	
	AdvancedBedItem bed = null;
	
	public BedFrame(String registryName,AdvancedBedItem bed) {
		super(Material.WOOD,registryName,registryName);
		this.bed = bed;
	}
	
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state){
        return new ItemStack(bed);
    }

}
