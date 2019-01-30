package net.dark_roleplay.medieval.common.objects.barrel;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityBarrel extends TileEntity{

	private StorageType storageType = StorageType.NONE;

	private ItemStackHandler itemHandler = new ItemStackHandler(18) {
		@Override
	    protected void onContentsChanged(int slot){
			for(int currentSlot = 0; currentSlot < TileEntityBarrel.this.itemHandler.getSlots(); currentSlot++) {
				if(!TileEntityBarrel.this.itemHandler.getStackInSlot(currentSlot).isEmpty()) {
					if(TileEntityBarrel.this.storageType != StorageType.ITEMS)
						TileEntityBarrel.this.storageType = StorageType.ITEMS;
					break;
				}
				TileEntityBarrel.this.storageType = StorageType.NONE;
			}
			TileEntityBarrel.this.markDirty();
	    }
	};

	private FluidTank fluidHandler = new FluidTank(16000){
		@Override
		protected void onContentsChanged(){
			if(this.getFluidAmount() == 0)
				TileEntityBarrel.this.storageType = StorageType.NONE;
			else if(TileEntityBarrel.this.storageType != StorageType.FLUID){
					TileEntityBarrel.this.storageType = StorageType.FLUID;
			}
			TileEntityBarrel.this.markDirty();
	        IBlockState state = TileEntityBarrel.this.world.getBlockState(TileEntityBarrel.this.getPos());
	        TileEntityBarrel.this.world.notifyBlockUpdate(TileEntityBarrel.this.getPos(), state, state, 3);
	    }
	};

	public TileEntityBarrel() {

	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		if (compound.hasKey("fluids")) {
			this.storageType = StorageType.FLUID;
			this.fluidHandler.readFromNBT(compound.getCompoundTag("fluids"));
		}else if (compound.hasKey("items")) {
			this.storageType = StorageType.ITEMS;
			this.itemHandler.deserializeNBT(compound.getCompoundTag("items"));
		}else {
			this.storageType = StorageType.NONE;
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		switch(this.storageType) {
			case FLUID:
				compound.setTag("fluids", this.fluidHandler.writeToNBT(new NBTTagCompound()));
				break;
			case ITEMS:
				compound.setTag("items", this.itemHandler.serializeNBT());
				break;
			default:
				break;
		}
		return compound;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if ((this.storageType == StorageType.NONE || this.storageType == StorageType.ITEMS) && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			IBlockState state = this.getWorld().getBlockState(this.pos);
			if(!(state.getBlock() instanceof Barrel)) return false;
			return !state.getValue(BlockProperties.IS_CLOSED);
		}
		if ((this.storageType == StorageType.NONE || this.storageType == StorageType.FLUID) && capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) return true;
		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if ((this.storageType == StorageType.NONE || this.storageType == StorageType.ITEMS) && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(this.itemHandler);
		if ((this.storageType == StorageType.NONE || this.storageType == StorageType.FLUID) && capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(this.fluidHandler);
		return super.getCapability(capability, facing);
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}

	public NBTTagCompound saveToNbt(NBTTagCompound compound){
		switch(this.storageType) {
			case FLUID:
				compound.setTag("fluids", this.fluidHandler.writeToNBT(new NBTTagCompound()));
				break;
			case ITEMS:
				compound.setTag("items", this.itemHandler.serializeNBT());
				break;
			default:
				break;
		}

        return compound;
    }

	@Override
	@Nullable
    public SPacketUpdateTileEntity getUpdatePacket(){
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(this.getPos(), 1, nbtTag);
    }

	@Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }

	@Override
	public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt){
		this.readFromNBT(pkt.getNbtCompound());
    }

	@Override
    public void handleUpdateTag(NBTTagCompound tag){
        this.readFromNBT(tag);
    }

	public StorageType getStorageType() {
		return this.storageType;
	}

	public static enum StorageType {
		FLUID,
		ITEMS,
		DRINK,
		NONE
	}
}
