package net.dark_roleplay.medieval.common.objects.blocks.old;

import java.util.Random;

import net.dark_roleplay.medieval.common.handler.MedievalCreativeTabs;
import net.dark_roleplay.medieval.holders.MedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class DryClay extends Block{

	public DryClay(String registryName) {
	    super(Material.CLAY);
	    this.setRegistryName(registryName);
	    this.setTranslationKey(registryName);
	    this.setCreativeTab(MedievalCreativeTabs.BUILDING_MATS);
	    this.setHardness(0.6F);
	    this.setSoundType(SoundType.GROUND);
	    this.setHarvestLevel("shovel", -1);
    }

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
    	return MedievalItems.DRY_CLAY_CHUNK;
    }

    @Override
	public int quantityDropped(Random random){
        return 3 + random.nextInt(2);
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable){
    	return plantable instanceof BlockBush;
    }
}
