package net.dark_roleplay.medieval.api.storage;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;

public class LockStackHandler implements IItemHandler, INBTSerializable<NBTTagCompound> {

	protected ItemStack stack;

	public LockStackHandler(){
		this.stack = ItemStack.EMPTY;
	}
	
	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.stack.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		this.stack = new ItemStack(nbt);
	}

	@Override
	public int getSlots() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return stack;
	}

	@Override
	@Nonnull
	public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
		if (stack.isEmpty())
			return ItemStack.EMPTY;

		ItemStack existing = this.stack;
		int limit = 1;

		if (!existing.isEmpty()) {
			if (!ItemHandlerHelper.canItemStacksStack(stack, existing))
				return stack;
			limit -= existing.getCount();
		}

		if (limit <= 0)
			return stack;

		boolean reachedLimit = stack.getCount() > limit;

		if (!simulate) {
			if (existing.isEmpty()) {
				this.stack = reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, limit) : stack;
			} else {
				existing.grow(reachedLimit ? limit : stack.getCount());
			}
		}

		return reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, stack.getCount() - limit) : ItemStack.EMPTY;
	}

	@Override
	@Nonnull
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		if (amount == 0)
			return ItemStack.EMPTY;

		ItemStack existing = this.stack;

		if (existing.isEmpty())
			return ItemStack.EMPTY;

		int toExtract = Math.min(amount, existing.getMaxStackSize());
		if (existing.getCount() <= toExtract) {
			if (!simulate) {
				this.stack = ItemStack.EMPTY;
			}
			return existing;
		} else {
			if (!simulate) {
				this.stack = ItemHandlerHelper.copyStackWithSize(existing, existing.getCount() - toExtract);
			}
			return ItemHandlerHelper.copyStackWithSize(existing, toExtract);
		}
	}

	@Override
	public int getSlotLimit(int slot) {
		return 1;
	}
}
