package net.dark_roleplay.medieval.testing.blocks.storage_controller;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class ControllerStackHandler implements IItemHandler, IItemHandlerModifiable, INBTSerializable<NBTTagCompound>{

	private Map<ItemStack, StackHolder> inventory = new HashMap<ItemStack, StackHolder>();
	
	public static class StackHolder{
		
		int occupiedSlots = 0;
		
		ItemStack baseStack = ItemStack.EMPTY;
		
		int amount = 0;
		
		public StackHolder(ItemStack stack) {
			if(!stack.isEmpty()) {
				amount = stack.getCount();
				stack.setCount(1);
				this.baseStack = stack;
				this.occupiedSlots = 1;
			}
		}
		 
		public ItemStack addStack(ItemStack stack, int freeSlots) {
			if(ItemStack.areItemStacksEqualUsingNBTShareTag(stack, this.baseStack)) {
				
			}
			
			return stack;
		}
		
//		public ItemStack takeStack(ItemStack stack, int amount) {
////			if(ItemStack.areItemStacksEqualUsingNBTShareTag(stack,  ))
//		}
		
	}

	@Override
	public NBTTagCompound serializeNBT() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStackInSlot(int slot, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSlots() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}
	
}
