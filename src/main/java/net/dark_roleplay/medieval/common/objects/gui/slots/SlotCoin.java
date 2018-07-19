package net.dark_roleplay.medieval.common.objects.gui.slots;

import net.dark_roleplay.core.api.old.items.DRPEquip;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotCoin extends Slot {

	public SlotCoin(IInventory inv, int index, int xPos, int yPos) {
		super(inv, index, xPos, yPos);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {

		// Everything returns true except an instance of our Item
		return !(itemstack.getItem() instanceof DRPEquip); // && itemstack.getItem() instanceof CurrencyBase;
	}
}
