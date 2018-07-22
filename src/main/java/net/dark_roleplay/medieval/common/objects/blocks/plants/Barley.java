package net.dark_roleplay.medieval.common.objects.blocks.plants;

import net.dark_roleplay.core_modules.crops.api.blocks.Crop;
import net.dark_roleplay.core_modules.dates.objects.other.Season;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Barley extends Crop{
	
	private float sizePerAge;
	
	public Barley(String registryName) {
		super(30, null, null , Season.LATE_SPRING, Season.EARLY_SUMMER, Season.MIDDLE_SUMMER, Season.LATE_SUMMER, Season.EARLY_AUTUMN);
		this.setRegistryName(registryName);
		this.sizePerAge = (1F/16F);
	}
	
	public Item getCrop() {
		return DRPMedievalItems.BARLEY;
	}

	public Item getSeed() {
		return DRPMedievalItems.BARLEY_SEED;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing facing){
        return BlockFaceShape.UNDEFINED;
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return new AxisAlignedBB(0F, 0F, 0F, 1F, 0.0625F * (state.getValue(this.getAgeProperty()) + 1) , 1F);
    }
}
