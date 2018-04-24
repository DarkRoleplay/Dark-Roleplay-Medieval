package net.dark_roleplay.medieval.common.items.misc;

import net.dark_roleplay.library.items.DRPItem;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.item.ItemStack;

public class HorseArmor extends DRPItem{

	public HorseArmor(String name, int stackSize, String[] subNames) {
		super(name, stackSize, subNames);
	}
	
	public net.minecraft.entity.passive.HorseArmorType getHorseArmorType(ItemStack stack){
        return HorseArmorType.DIAMOND;
    }
    
    public String getHorseArmorTexture(net.minecraft.entity.EntityLiving wearer, ItemStack stack){
        return getHorseArmorType(stack).getTextureName();
    }
}
