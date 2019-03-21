package net.dark_roleplay.medieval.objects.blocks.decoration.chairs;

import net.dark_roleplay.medieval.holders.MedievalTileEntities;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class SolidChairTileEntity extends TileEntity {

	protected ItemStackHandler hidden_inventory = null;

	public SolidChairTileEntity() {
		super(MedievalTileEntities.SOLID_CHAIR_ARMREST);
		this.hidden_inventory = new ItemStackHandler(1) {
			@Override
			protected void onContentsChanged(int slot) {
				SolidChairTileEntity.this.markDirty();
			}
		};
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, EnumFacing side) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return LazyOptional.of(() -> {
				return (T) hidden_inventory;
			});
		}

		return super.getCapability(capability, side);
	}

	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);

		if (compound.hasKey("hidden_inventory"))
			this.hidden_inventory.deserializeNBT((NBTTagCompound) compound.getTag("hidden_inventory"));
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound) {
		compound = super.write(compound);
		NBTTagCompound inventory = this.hidden_inventory.serializeNBT();
		compound.setTag("hidden_inventory", inventory);
		return compound;
	}
}
