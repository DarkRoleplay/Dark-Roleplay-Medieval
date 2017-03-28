package net.drpmedieval.common.items.blocks;

import java.util.List;

import net.drpmedieval.common.blocks.building.CleanPlanks;
import net.drpmedieval.common.blocks.templates.WoodenBlock;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WoodTypeItemBlock extends ItemBlock {

	public WoodTypeItemBlock(WoodenBlock block) {
		super(block);

		this.setRegistryName(block.getRegistryName());
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
		int size = ((WoodenBlock) this.getBlock()).VARIANT.getAllowedValues().size();
		for(int i = 0; i < size; i++)
			subItems.add(new ItemStack(itemIn, 1, i));
	}

	public int getMetadata(int damage) {
		return damage;
	}

}
