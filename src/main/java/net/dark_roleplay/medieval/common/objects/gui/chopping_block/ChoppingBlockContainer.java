package net.dark_roleplay.medieval.common.objects.gui.chopping_block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ChoppingBlockContainer extends Container{

	protected TileEntity te;

	public ChoppingBlockContainer(TileEntity te, InventoryPlayer playerInventory) {
		this.te = te;

		if(this.te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
			IItemHandler handler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

			int size = handler.getSlots();

			this.addSlotToContainer(new SlotItemHandler(handler, 0, 8, 8) {

			});
		}

        this.bindPlayerInventory(playerInventory);
	}

    protected void bindPlayerInventory(InventoryPlayer playerInventory){
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 9; x++){
                this.addSlotToContainer(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++){
            this.addSlotToContainer(new Slot(playerInventory, x, 8 + x * 18, 142));
        }
    }

	@Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index){
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < 1) {
                if (!this.mergeItemStack(itemstack1, 0, this.inventorySlots.size(), true)){
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 1, false)){
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()){
                slot.putStack(ItemStack.EMPTY);
            }else{
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
