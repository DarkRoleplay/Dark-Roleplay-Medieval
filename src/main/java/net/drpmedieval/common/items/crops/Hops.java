package net.drpmedieval.common.items.crops;

import net.drpmedieval.common.blocks.DRPMBlocks;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Hops extends Item {

	public Hops(String registryName) {
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}
	
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if((world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == Blocks.GRASS) && world.getBlockState(pos.up()).getBlock() == DRPMBlocks.ROPE){
			world.setBlockState(pos.up(), DRPMBlocks.HOPS.getDefaultState());
			player.getHeldItem(hand).shrink(1);
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.FAIL;
    }
}

