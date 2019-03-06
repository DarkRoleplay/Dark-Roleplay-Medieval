package net.dark_roleplay.medieval.testing.purse;

public class ItemInventoryContainer{}/*  extends Container{

	private ItemStack itemProtector;
	protected int slotCount;

	public ItemInventoryContainer(ItemStack stack, InventoryPlayer playerInventory) {

		this.itemProtector = stack;

		if(stack.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
			IItemHandler handler = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

			this.slotCount = handler.getSlots();

			int size = handler.getSlots();

			for(int y = 0; y < Math.ceil(size / 9F); y++) {
				for(int x = 0; x < Math.min(9, size - (y * 9)); x++) {

						this.addSlotToContainer(new SlotItemHandler(handler, x + (y * 9), 8 + (x * 18), 8 + (y * 18)));
				}
			}
		}

        this.bindPlayerInventory(playerInventory);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

    protected void bindPlayerInventory(InventoryPlayer playerInventory){
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 9; x++){
                this.addSlotToContainer(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++){
        	if(playerInventory.getStackInSlot(x) == this.itemProtector)
                this.addSlotToContainer(new Slot(playerInventory, x, 8 + -500, -500));
        	else
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

            if (index < this.slotCount) {
                if (!this.mergeItemStack(itemstack1, this.slotCount, this.inventorySlots.size(), true)){
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.slotCount, false)){
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
}*/
