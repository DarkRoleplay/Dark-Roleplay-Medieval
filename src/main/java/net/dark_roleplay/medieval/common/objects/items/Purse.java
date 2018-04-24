package net.dark_roleplay.medieval.common.objects.items;

import javax.annotation.Nullable;

import net.dark_roleplay.library.items.DRPItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class Purse extends DRPItem{

	public Purse(String name, int stackSize, String... subNames){
		super(name, null, stackSize, subNames);
	}
	
	public Purse(String name, String itemFolder, int stackSize, String... subNames){
		super(name, itemFolder, stackSize, subNames);
	}
	
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt){
        return null;
    }
	
}
