package net.drpmedieval.common.items.equipment.other;

import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSaddle;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class SaddleHorse extends ItemSaddle{

	public SaddleHorse() {
		this.setRegistryName("SaddleHorse");
		this.setUnlocalizedName("SaddleHorse");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand){
		return false;
    }

}
