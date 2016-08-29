package net.drpmedieval.common.blocks.plants;

import net.drpmedieval.common.items.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Barley extends BlockCrops {

	public Barley() {
		this.setRegistryName("Barley");
		this.setUnlocalizedName("Barley");
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.AGE, Integer.valueOf(0)));
	}

	protected boolean canPlaceBlockOn(Block ground) {

		return ground == Blocks.FARMLAND;
	}

	protected Item getSeed() {

		return DRPMedievalItems.itemSeedBarley;
	}

	protected Item getCrop() {
		return DRPMedievalItems.itemBarley;
	}

	// -------------------------------------------------- Block Data --------------------------------------------------

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0F,0F,0F,1F,0.25F,1F);
    }
}
