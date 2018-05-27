package net.dark_roleplay.medieval.common.blocks.tileentitys;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableMap;

import jline.internal.Nullable;
import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.References;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.common.animation.Event;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.animation.TimeValues.VariableValue;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.model.animation.CapabilityAnimation;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;

public class TE_DungeonChest extends TileEntity {

	public InventoryBasic inventory;

	private boolean isOpen = false;

	@Nullable
	public final IAnimationStateMachine asm;
	public final VariableValue clickTime = new VariableValue(Float.NEGATIVE_INFINITY);

	int InvSize = 27;

	public TE_DungeonChest() {
		inventory = new InventoryBasic("DungeonChestInventory", false, InvSize);
		asm = DarkRoleplayMedieval.proxy.load(
				new ResourceLocation(References.MODID, "asms/block/simple_chest_top.json"),
				ImmutableMap.<String, ITimeValue>of("click_time", clickTime));
	}

	public void handleEvents(float time, Iterable<Event> pastEvents) {
	}

	@Override
	public boolean hasFastRenderer() {
		return true;
	}

	public boolean isOpen() {
		return this.isOpen;
	}

	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() {
		return null;
	}

	public NBTTagCompound getUpdateTag() {
		return this.writeToNBT(new NBTTagCompound());
	}

	public void click() {
		this.isOpen = !this.isOpen;
		if (world.isRemote) {
			if (asm.currentState().equals("closed")) {
				clickTime.setValue(Animation.getWorldTime(getWorld()));
				asm.transition("opening");
			} else if (asm.currentState().equals("open")) {
				clickTime.setValue(Animation.getWorldTime(getWorld()));
				asm.transition("closing");
			}
		}
	}

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing side) {
		if (capability == CapabilityAnimation.ANIMATION_CAPABILITY) {
			return true;
		}
		return super.hasCapability(capability, side);
	}

	@Override
	@Nullable
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing side) {
		if (capability == CapabilityAnimation.ANIMATION_CAPABILITY) {
			return CapabilityAnimation.ANIMATION_CAPABILITY.cast(asm);
		}
		return super.getCapability(capability, side);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		nbt.setBoolean("is_open", this.isOpen);
		
		NBTTagList list = new NBTTagList();

		for (int i = 0; i < InvSize; i++) {
			if (inventory.getStackInSlot(i) != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("slot", (byte) i);
				inventory.getStackInSlot(i).writeToNBT(tag);
				list.appendTag(tag);
			}
		}

		nbt.setTag("inventory", list);

		return nbt;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		this.isOpen = compound.hasKey("is_open") ? compound.getBoolean("is_open") : false;
		if (!DarkRoleplayMedieval.isOnServer && this.isOpen) {
			System.out.println(this.asm + " SEARCH ME!");
			this.asm.transition("open");
		}
		
		NBTTagList list = compound.getTagList("inventory", 10);
		this.inventory = new InventoryBasic("DungeonChestInventory", false, InvSize);
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound tag = list.getCompoundTagAt(i);
			byte b = tag.getByte("slot");

			if (b >= 0 && b < inventory.getSizeInventory()) {
				inventory.setInventorySlotContents(b, new ItemStack(tag));
			}
		}
	}
}
