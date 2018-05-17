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

	@Nullable
	public final IAnimationStateMachine asm;
	public final VariableValue clickTime = new VariableValue(Float.NEGATIVE_INFINITY);

	int InvSize = 27;

	public TE_DungeonChest() {
		inventory = new InventoryBasic("DungeonChestInventory", false, InvSize);
		asm = DarkRoleplayMedieval.proxy.load(new ResourceLocation(References.MODID, "asms/block/simple_chest.json"), ImmutableMap.<String, ITimeValue>of(
				"click_time", clickTime
		));
	}

	public void handleEvents(float time, Iterable<Event> pastEvents) {
		for (Event event : pastEvents) {
			System.out.println("Event: " + event.event() + " " + event.offset() + " " + getPos() + " " + time);
		}
	}

	@Override
	public boolean hasFastRenderer() {
		return true;
	}

	public void click(boolean sneaking) {
		if(sneaking) {
			System.out.println(asm.currentState());
			System.out.println(Animation.getWorldTime(getWorld()));
			clickTime.setValue(Animation.getWorldTime(getWorld()));
		}else if(asm.currentState().equals("closed")){
            clickTime.setValue(Animation.getWorldTime(getWorld()));
            asm.transition("opening");
        }else if(asm.currentState().equals("open")){
            clickTime.setValue(Animation.getWorldTime(getWorld()));
            asm.transition("closing");
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

		NBTTagList list = new NBTTagList();

		for (int i = 0; i < InvSize; i++) {
			if (inventory.getStackInSlot(i) != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				inventory.getStackInSlot(i).writeToNBT(tag);
				list.appendTag(tag);
			}
		}

		nbt.setTag("ItemStacks", list);

		return nbt;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {

		super.readFromNBT(compound);

		NBTTagList list = compound.getTagList("ItemStacks", 10);
		this.inventory = new InventoryBasic("DungeonChestInventory", false, InvSize);
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound tag = list.getCompoundTagAt(i);
			byte b = tag.getByte("Slot");

			if (b >= 0 && b < inventory.getSizeInventory()) {
				inventory.setInventorySlotContents(b, new ItemStack(tag));
			}
		}
	}
}
