package net.dark_roleplay.medieval.common.objects.blocks.tile_entities;

import javax.annotation.Nonnull;

import net.dark_roleplay.medieval.holders.MedievalItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TE_ChoppingBlock extends TileEntity {

	private int progress = 0;

	ItemStackHandler inventory = new ItemStackHandler(1) {
		@Override
	    public boolean isItemValid(int slot, @Nonnull ItemStack stack)	    {
	        return stack.getItem().getRegistryType().toString().contains("log");
	    }

		@Override
	    protected void onContentsChanged(int slot){
			TE_ChoppingBlock.this.markDirty();
	    }
	};

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		if (compound.hasKey("items")) {
			this.inventory.deserializeNBT((NBTTagCompound) compound.getTag("items"));
		}
		if(compound.hasKey("progress")) {
			this.progress = compound.getInteger("progress");
		}
	}

	public void progress(int progress) {
		this.progress += progress;
		if(this.progress >= 100) {
			this.progress = 0;
			this.world.spawnEntity(new EntityItem(this.getWorld(), this.getPos().getX(), this.getPos().getY() + 1, this.getPos().getZ(), new ItemStack(MedievalItems.OAK_FIREWOOD, 4)));
			this.inventory.getStackInSlot(0).shrink(1);
		}
		this.markDirty();
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("items", this.inventory.serializeNBT());
		if(this.progress != 0)
			compound.setInteger("progress", this.progress);
		return compound;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(this.inventory);
		return super.getCapability(capability, facing);
	}

}
