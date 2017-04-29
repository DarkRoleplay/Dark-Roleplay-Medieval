package net.drpmedieval.common.blocks.decorative.simpleChairs;

import net.drpmedieval.common.blocks.decorative.Chair;
import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class SimpleChair extends Chair{

	public SimpleChair(String registryName){
		super(Material.WOOD,registryName,registryName , 4 * 0.0625F);
		this.setCreativeTab(DRPMedievalCreativeTabs.DECORATION);
		this.setHardness(2F);
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0F, 0F, 0F, 1F, 0.5F, 1F);
    }
}
