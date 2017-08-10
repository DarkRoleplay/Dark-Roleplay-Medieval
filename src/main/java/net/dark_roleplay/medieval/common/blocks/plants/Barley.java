package net.dark_roleplay.medieval.common.blocks.plants;

import net.dark_roleplay.medieval.api.blocks.plants.Block_AdvancedCrop;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.Item;

public class Barley extends Block_AdvancedCrop{

	private static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	
	public Barley(String registryName) {
		super(registryName, Barley.AGE, 30);
	}

	@Override
	protected Item getSeed() {
		return DRPMedievalItems.BAT_EAR;
	}

	@Override
	protected Item getCrop() {
		return DRPMedievalItems.BARLEY;
	}

	@Override
	protected PropertyInteger getAgeProperty() {
		return Barley.AGE;
	}

//	protected boolean canPlaceBlockOn(Block ground) {
//
//		return ground == Blocks.FARMLAND;
//	}

//	// -------------------------------------------------- Block Data --------------------------------------------------
//
//	@Override
//	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
//    {
//        return new AxisAlignedBB(0F,0F,0F,1F,0.25F,1F);
//    }
}
