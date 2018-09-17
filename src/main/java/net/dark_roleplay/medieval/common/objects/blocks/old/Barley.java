package net.dark_roleplay.medieval.common.objects.blocks.old;

import net.dark_roleplay.core_modules.crops.api.blocks.Crop;
import net.dark_roleplay.core_modules.dates.objects.other.Season;
import net.dark_roleplay.medieval.common.handler.MedievalItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Barley extends Crop{

	public Barley(String registryName) {
		super(30, Season.LATE_SPRING, Season.EARLY_SUMMER, Season.MIDDLE_SUMMER, Season.LATE_SUMMER, Season.EARLY_AUTUMN);
		this.setRegistryName(registryName);
	}

	@Override
	public Item getCrop() {
		return MedievalItems.BARLEY;
	}

	@Override
	public Item getSeed() {
		return MedievalItems.BARLEY;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0F, 0F, 0F, 1F, 0.0625F * (state.getValue(this.getAgeProperty()) + 1) , 1F);
    }

}
