package net.drpmedieval.common.items.food;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class CodStew  extends ItemFood{

	public CodStew(){
		super(7, 0.5F, false);
		this.setUnlocalizedName("itemCodStew");
		setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
	}	
	
	 public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
	 {
		 --stack.stackSize;
	     playerIn.getFoodStats().addStats(this, stack);
	     worldIn.playSoundAtEntity(playerIn, "random.burp", 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
	     this.onFoodEaten(stack, worldIn, playerIn);
	     playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
		 
	    return new ItemStack(Items.bowl);
	 }
}