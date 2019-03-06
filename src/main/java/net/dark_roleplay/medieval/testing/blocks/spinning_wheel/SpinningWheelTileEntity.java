package net.dark_roleplay.medieval.testing.blocks.spinning_wheel;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class SpinningWheelTileEntity{}/*  extends TileEntity{

	protected ItemStackHandler inventory = new ItemStackHandler(4) {
	    @Override
	    public int getSlotLimit(int slot){
	        return 1;
	    }
		
		@Override
	    protected void onContentsChanged(int slot){
			SpinningWheelTileEntity.this.markDirty();
	    }
	};; 
	
	public SpinningWheelTileEntity() {
	}
	
	@Override
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("inventory"))
        	inventory.deserializeNBT((NBTTagCompound) compound.getTag("inventory"));   
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagCompound comp = super.writeToNBT(compound);
        
        NBTTagCompound inventory = this.inventory.serializeNBT();
        comp.setTag("inventory", inventory);
        
        return comp;
    }
	
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return true;
    	return super.hasCapability(capability, facing);
	}

	@Override
	@Nullable
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing){
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) this.inventory;
    	return super.getCapability(capability, facing);
	}
}*/
