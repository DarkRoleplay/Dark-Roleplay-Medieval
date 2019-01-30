package net.dark_roleplay.medieval.objects.blocks.decoration.barrels;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;

public class TileEntityFluidBarrel extends TileEntity{

	private FluidTank fluidHandler = new FluidTank(16000){
		@Override
		protected void onContentsChanged(){
			TileEntityFluidBarrel.this.markDirty();
	        IBlockState state = TileEntityFluidBarrel.this.world.getBlockState(TileEntityFluidBarrel.this.getPos());
			TileEntityFluidBarrel.this.world.notifyBlockUpdate(TileEntityFluidBarrel.this.getPos(), state, state, 3);
	    }
	};

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		if (compound.hasKey("fluids")) {
			this.fluidHandler.readFromNBT(compound.getCompoundTag("fluids"));
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("fluids", this.fluidHandler.writeToNBT(new NBTTagCompound()));
		return compound;
	}

	public boolean canInteractWith(EntityPlayer playerIn) {
		return !this.isInvalid() && playerIn.getDistanceSq(this.pos.add(0.5D, 0.5D, 0.5D)) <= 8D;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY) {
			return CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY.cast(this.fluidHandler);
		}
		return super.getCapability(capability, facing);
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
}
