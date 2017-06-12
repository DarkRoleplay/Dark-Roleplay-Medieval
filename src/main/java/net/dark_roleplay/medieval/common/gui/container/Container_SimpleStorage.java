package net.dark_roleplay.medieval.common.gui.container;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.tileentities.storage.TileEntity_SimpleStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class Container_SimpleStorage extends Container {

    private TileEntity_SimpleStorage te;
	
	public Container_SimpleStorage(IInventory playerInventory, TileEntity_SimpleStorage te){
		this.te = te;
		

		int teSize = this.addStorageSlots();
		this.addPlayerSlots(playerInventory, teSize);
	}
	
	private void addPlayerSlots(IInventory inventory, int offset){
		int yPos = (int) (30 + (Math.ceil((offset / 9D)) * 18));
		int xPos = 9;
		// Slots for the main inventor
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(inventory, x + (y * 9) + 9, xPos, yPos));
                xPos += 18;
            }
            yPos += 18;
            xPos = 9;
        }

        // Slots for the hotbar

        yPos += 4;
        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(inventory, x, xPos, yPos));
            xPos += 18;
        }
	}
	
	private int addStorageSlots(){
		IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int xPos = 9;
        int yPos = 17;

        // Add our own slots
        int size = itemHandler.getSlots();
        for (int y = 0; y < Math.ceil(size / 9D) ; y++) {
	        for (int x = 0; (x < 9) && ((x + (y * 9)) < size); x++) {
	            this.addSlotToContainer(new SlotItemHandler(itemHandler, x + (y * 9), xPos, yPos));
	            xPos += 18;
	        }
	        yPos += 18;
	        xPos = 9;
        }

        
        return itemHandler.getSlots();
	}
	
	@Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = this.inventorySlots.get(index);

        if (slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.te.getSize()) {
                if (!this.mergeItemStack(itemstack1, this.te.getSize(), this.inventorySlots.size(), true))
					return ItemStack.EMPTY;
            } else if (!this.mergeItemStack(itemstack1, 0, this.te.getSize(), false))
				return ItemStack.EMPTY;

            if (itemstack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.te.canInteractWith(player);
	}
	

}
