package net.dark_roleplay.medieval.common.villager;

import java.util.Random;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class EmeraldsForStacks implements EntityVillager.ITradeList
{
    public ItemStack stack1;
    public ItemStack stack2;
    public EntityVillager.PriceInfo price;

    public EmeraldsForStacks(ItemStack stack1, EntityVillager.PriceInfo price){
        this.stack1 = stack1;
        this.price = price;
    }
    
    public EmeraldsForStacks(ItemStack stack1, ItemStack stack2, EntityVillager.PriceInfo price){
        this.stack1 = stack1;
        this.stack2 = stack2;
        this.price = price;
    }

    @Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random){
        int i = 1;
        
        if (this.price != null){
            i = this.price.getPrice(random);
        }

        if(this.stack2 != null) {
			recipeList.add(new MerchantRecipe(this.stack1, this.stack2, new ItemStack(Items.EMERALD, i, 0)));
		} else {
			recipeList.add(new MerchantRecipe(this.stack1, new ItemStack(Items.EMERALD, i, 0)));
		}
    }
}
