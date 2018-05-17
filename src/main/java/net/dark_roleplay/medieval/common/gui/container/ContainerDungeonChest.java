package net.dark_roleplay.medieval.common.gui.container;

import net.dark_roleplay.medieval.common.blocks.tileentitys.TE_DungeonChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDungeonChest extends Container {

	private TE_DungeonChest chest = new TE_DungeonChest();

	public ContainerDungeonChest(IInventory playerInv, TE_DungeonChest DungeonChest) {
		int i = -18;
		int j;
		int k;

		int index = 0;
		for(j = 0; j < 3; ++j){
			for(k = 0; k < 9; ++k){
				this.addSlotToContainer(new Slot(DungeonChest.inventory, index++, 8 + k * 18, 17 + j * 18));
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

	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {

		ItemStack itemstack = new ItemStack(Blocks.AIR, 1, 0);
		Slot slot = (Slot) this.inventorySlots.get(index);

		if(slot != null && !slot.getStack().isEmpty()){
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if(index < 15){
				if(!this.mergeItemStack(itemstack1, 27, this.inventorySlots.size(), true)){ return new ItemStack(Blocks.AIR, 1, 0); }
			}
			else if(!this.mergeItemStack(itemstack1, 0, 26, false)){ return new ItemStack(Blocks.AIR, 1, 0); }

			if(itemstack1.getCount() == 0){
				slot.putStack(new ItemStack(Blocks.AIR, 1, 0));
			}
			else{
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {

		return true;
	}
}
