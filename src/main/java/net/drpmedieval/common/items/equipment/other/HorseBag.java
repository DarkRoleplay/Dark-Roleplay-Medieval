package net.drpmedieval.common.items.equipment.other;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.entity.passive.HorseType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;

public class HorseBag extends Item{

	public HorseBag() {
		this.setRegistryName("HorseBag");
		this.setUnlocalizedName("HorseBag");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand){
		if (target instanceof EntityHorse)
        {
			EntityHorse horse = (EntityHorse)target;

            if (!horse.isChested() && !horse.isChild() && (horse.getType() == HorseType.DONKEY || horse.getType() == HorseType.DONKEY) )
            {
            	horse.setType(HorseType.MULE);
            	horse.setChested(true);
            	horse.worldObj.playSound(playerIn, horse.posX, horse.posY, horse.posZ, SoundEvents.ENTITY_HORSE_SADDLE, SoundCategory.NEUTRAL, 0.5F, 1.0F);
                --stack.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}
