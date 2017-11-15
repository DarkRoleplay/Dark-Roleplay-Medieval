package net.dark_roleplay.medieval.common.blocks.tileentities.storage;

import net.dark_roleplay.medieval.api.storage.LockStackHandler;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCapabilities;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntity_SimpleStorage  extends TileEntity {

	private int size;

    private ItemStackHandler itemStackHandler;
    private LockStackHandler lockHandler;
	
    public TileEntity_SimpleStorage(){
    	this(32);
    }
    
	public TileEntity_SimpleStorage(int size){
		this.size = size;
		this.itemStackHandler =  new ItemStackHandler(this.size) {
	        @Override
	        protected void onContentsChanged(int slot) {
	        	TileEntity_SimpleStorage.this.markDirty();
	        }
		};
		this.lockHandler = new LockStackHandler();
	}

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.size = compound.getInteger("size");
        System.err.println(this.size);
        this.itemStackHandler =  new ItemStackHandler(this.size) {
	        @Override
	        protected void onContentsChanged(int slot) {
	        	TileEntity_SimpleStorage.this.markDirty();
	        }
		};
        this.lockHandler = new LockStackHandler();
		
        if (compound.hasKey("items")) {
            this.itemStackHandler.deserializeNBT((NBTTagCompound) compound.getTag("items"));
        }
        if(compound.hasKey("lock")){
        	this.lockHandler.deserializeNBT((NBTTagCompound) compound.getTag("lock"));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("size", this.size);
        compound.setTag("items", this.itemStackHandler.serializeNBT());
        compound.setTag("lock", this.lockHandler.serializeNBT());
        return compound;
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return !this.isInvalid() && (playerIn.getDistanceSq(this.pos.add(0.5D, 0.5D, 0.5D)) <= 7D);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || capability == DRPMedievalCapabilities.LOCK_HANDLER_CAPABILITY)
			return true;
        return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) this.itemStackHandler;
        if(capability == DRPMedievalCapabilities.LOCK_HANDLER_CAPABILITY)
        	return (T) this.lockHandler;
        return super.getCapability(capability, facing);
    }

	public int getSize() {
		return this.size;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag){
        this.size = tag.getInteger("size");
    }
	
	@Override
	public NBTTagCompound getUpdateTag(){
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("size", this.getSize());
        return tag;
    }
}
