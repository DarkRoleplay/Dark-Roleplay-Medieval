package net.drpmedieval.common.blocks.decorative;

import net.drpmedieval.common.blocks.helper.AdvancedBed;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BedFrameSpruce extends AdvancedBed{

	public BedFrameSpruce() {
		super(Material.WOOD,"bedFrameSpruce","bedFrameSpruce");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalBlocksTab);
	}
	
	@Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state){
        return new ItemStack(DRPMedievalItems.bedFrameSpruce);
    }
}
