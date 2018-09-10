package net.dark_roleplay.medieval.common.objects.items;

import net.dark_roleplay.core.api.old.items.DRPFood;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class DRPMStew extends DRPFood {
	
	public DRPMStew(int food, float saturation, String name) {
		super(food, saturation, name, 1);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving){
        if (entityLiving instanceof EntityPlayer){
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(8, 0.5F);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
        }

        stack.shrink(1);
		return new ItemStack(Items.BOWL);
    }
}
