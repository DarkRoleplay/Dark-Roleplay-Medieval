package net.dark_roleplay.medieval.common.tileentities.lectern;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntity_Lectern  extends TileEntity {

    private ItemStackHandler itemStackHandler;
	
	public TileEntity_Lectern(){
		this.itemStackHandler =  new ItemStackHandler(1) {
	        @Override
	        protected void onContentsChanged(int slot) {
	        	TileEntity_Lectern.this.markDirty();
	        }
		};
	}

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("items")) {
            this.itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setTag("items", this.itemStackHandler.serializeNBT());
        return compound;
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return !this.isInvalid() && (playerIn.getDistanceSq(this.pos.add(0.5D, 0.5D, 0.5D)) <= 3D);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return true;
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) this.itemStackHandler;
        return super.getCapability(capability, facing);
    }
    
    @Override
	public void handleUpdateTag(NBTTagCompound tag){
        this.readFromNBT(tag);
    }
	
	@Override
	public NBTTagCompound getUpdateTag(){
		NBTTagCompound tag = new NBTTagCompound();
		tag = this.writeToNBT(tag);
        return tag;
    }
	
	public boolean renderBook(){
		return !this.itemStackHandler.getStackInSlot(0).isEmpty();
	}
	
	public ItemStack getStack(){
		return this.itemStackHandler.getStackInSlot(0);

	}
}

