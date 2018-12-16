package net.dark_roleplay.medieval.common.objects.blocks.tile_entities;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.client.objects.blocks.tesrs.helper.ShelfRenderInformation;
import net.dark_roleplay.medieval.common.objects.other.MultiStackHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;

public class TE_UniversalShelf extends TileEntity {

	private ShelfRenderInformation renderInformation;

	private MultiStackHandler itemStackHandler;

	private Vec3d[] offsets;

	//TODO save offsets in te data, create constructor without params
	public TE_UniversalShelf(int size, Vec3d... offsets) {
		this.offsets = offsets;
		this.itemStackHandler = new MultiStackHandler(size, 2) {
			@Override
			protected void onContentsChanged(int slot) {
				TE_UniversalShelf.this.markDirty();
		        IBlockState state = TE_UniversalShelf.this.world.getBlockState(TE_UniversalShelf.this.getPos());
				TE_UniversalShelf.this.world.notifyBlockUpdate(TE_UniversalShelf.this.getPos(), state, state, 2);
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
		return !this.isInvalid() && playerIn.getDistanceSq(this.pos.add(0.5D, 0.5D, 0.5D)) <= 8D;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(this.itemStackHandler);
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

	@SideOnly(Side.CLIENT)
	public ShelfRenderInformation getRenderInformation(RenderItem itemRenderer) {
		if(this.renderInformation == null) {
			this.renderInformation = new ShelfRenderInformation(this, itemRenderer, this.offsets);
		}

		return this.renderInformation;
	}
}
