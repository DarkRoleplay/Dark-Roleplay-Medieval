package net.dark_roleplay.medieval.common.objects.items.consumables.drinks;

import net.dark_roleplay.core.api.old.items.DRPFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SpruceTea extends DRPFood {

	public SpruceTea(int food, float saturation, String name, String itemFolder) {
		super(food, saturation, name, itemFolder, 1);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
		if (!worldIn.isRemote){
			player.addPotionEffect(new PotionEffect(Potion.REGISTRY.getObject(new ResourceLocation("minecraft", "regeneration")), 400, 1));
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack){
        return 32;
    }

	@Override
    public EnumAction getItemUseAction(ItemStack stack){
        return EnumAction.DRINK;
    }

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (playerIn.canEat(true)){
            playerIn.setActiveHand(handIn);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
        else
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
        }
    }

}
