package net.dark_roleplay.medieval.common.gui.container;

import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrate extends Container {

	public ContainerCrate(IInventory playerInv, TileEntityCrate Crate) {
		int i = -18;
		int j;
		int k;

		int index = 0;
		for(j = 0; j < 3; ++j){
			for(k = 0; k < 5; ++k){
				this.addSlotToContainer(new Slot(Crate.inventory, index++, 44 + k * 18, 17 + j * 18));
			}
		}

		for(j = 0; j < 3; ++j){
			for(k = 0; k < 9; ++k){
				this.addSlotToContainer(new Slot(playerInv, k + j * 9 + 9, 8 + k * 18, 102 + j * 18 + i));
			}
		}

		for(j = 0; j < 9; ++j){
			this.addSlotToContainer(new Slot(playerInv, j, 8 + j * 18, 160 + i));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {

		ItemStack itemstack = new ItemStack(Blocks.AIR, 1, 0);
		Slot slot = (Slot) this.inventorySlots.get(index);

		if(slot != null && !slot.getStack().isEmpty()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if(index < 15){
				if(!this.mergeItemStack(itemstack1, 15, this.inventorySlots.size(), true)){ return new ItemStack(Blocks.AIR, 1, 0); }
			}
			else if(!this.mergeItemStack(itemstack1, 0, 14, false)){ return new ItemStack(Blocks.AIR, 1, 0); }

			if(itemstack1.getCount() == 0){
				slot.putStack(new ItemStack(Blocks.AIR, 1, 0));
			}
			else{
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}
}
