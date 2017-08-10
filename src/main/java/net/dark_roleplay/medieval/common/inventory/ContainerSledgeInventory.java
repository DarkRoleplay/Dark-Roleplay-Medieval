package net.dark_roleplay.medieval.common.inventory;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.entity.item.EntitySledge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSledgeInventory  extends Container{

    public final IInventory sledgeInventory;
    public final IInventory playerInventory;
    public final EntitySledge theSledge;

    public ContainerSledgeInventory(IInventory playerInventory, final IInventory sledgeInventoryIn, final EntitySledge sledge, EntityPlayer player){
        this.sledgeInventory = sledgeInventoryIn;
        this.playerInventory = playerInventory;
        this.theSledge = sledge;
        this.sledgeInventory.openInventory(player);

        if (sledge.isChested()){
            for (int k = 0; k < 3; ++k){
                for (int l = 0; l < 9; ++l){
                    this.addSlotToContainer(new Slot(this.sledgeInventory, l + k * 9, 80 + l * 18, 18 + k * 18));
                }
            }
        }
    }

    public boolean canInteractWith(EntityPlayer playerIn){
        return this.sledgeInventory.isUsableByPlayer(playerIn) && this.theSledge.isEntityAlive() && this.theSledge.getDistanceToEntity(playerIn) < 8.0F;
    }

    /**
     * Take a stack from the specified inventory slot.
     */
    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < this.sledgeInventory.getSizeInventory())
            {
                if (!this.mergeItemStack(itemstack1, this.sledgeInventory.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (this.getSlot(1).isItemValid(itemstack1) && !this.getSlot(1).getHasStack())
            {
                if (!this.mergeItemStack(itemstack1, 1, 2, false))
                {
                    return null;
                }
            }
            else if (this.getSlot(0).isItemValid(itemstack1))
            {
                if (!this.mergeItemStack(itemstack1, 0, 1, false))
                {
                    return null;
                }
            }
            else if (this.sledgeInventory.getSizeInventory() <= 2 || !this.mergeItemStack(itemstack1, 2, this.sledgeInventory.getSizeInventory(), false))
            {
                return null;
            }

            if (itemstack1.getCount() == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        this.sledgeInventory.closeInventory(playerIn);
    }
}

