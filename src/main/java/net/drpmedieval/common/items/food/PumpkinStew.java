package net.drpmedieval.common.items.food;

import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class PumpkinStew extends ItemFood {

	public PumpkinStew() {
		super(6, 0.3F, false);
		this.setRegistryName("PumpkinStew");
		this.setUnlocalizedName("PumpkinStew");
		setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving){
        if (entityLiving instanceof EntityPlayer){
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));
        }

        stack.shrink(1);
		return new ItemStack(Items.BOWL);
    }
}