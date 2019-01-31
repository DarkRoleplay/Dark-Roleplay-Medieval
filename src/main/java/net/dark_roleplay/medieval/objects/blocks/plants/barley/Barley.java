package net.dark_roleplay.medieval.objects.blocks.plants.barley;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Barley extends Block{

	public Barley(String registryName) {
		super(Material.AIR);
//		super(30, Season.LATE_SPRING, Season.EARLY_SUMMER, Season.MIDDLE_SUMMER, Season.LATE_SUMMER, Season.EARLY_AUTUMN);
		this.setRegistryName(registryName);
	}

//	@Override
//	public Item getCrop() {
//		return MedievalItems.BARLEY;
//	}
//
//	@Override
//	public Item getSeed() {
//		return MedievalItems.BARLEY;
//	}
//
//	@Override
//	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
////        return new AxisAlignedBB(0F, 0F, 0F, 1F, 0.0625F * (state.getValue(this.getAgeProperty()) + 1) , 1F);
//    }

}
