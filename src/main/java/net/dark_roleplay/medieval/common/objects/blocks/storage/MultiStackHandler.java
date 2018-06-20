package net.dark_roleplay.medieval.common.objects.blocks.storage;

import java.util.Arrays;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

public class MultiStackHandler extends ItemStackHandler{
	
    protected int[] stackSizes;

    protected int slotMultiplier = 4;
    
    public MultiStackHandler(){
        this(1);
    }

    public MultiStackHandler(int size){
    	this.stacks = NonNullList.withSize(size, ItemStack.EMPTY);
    	this.stackSizes = new int[size];
    }

    public MultiStackHandler(NonNullList<ItemStack> stacks){
        this.stacks = stacks;
        this.stackSizes = new int[stacks.size()];
        for(int i = 0; i < this.stacks.size(); i++){
        	this.stackSizes[i] = this.stacks.get(i).getCount();
        	this.stacks.get(i).setCount(1);
        }
    }

    @Override
    public void setSize(int size){
    	this.stacks = NonNullList.withSize(size, ItemStack.EMPTY);
    	this.stackSizes = new int[size];
    }
    
    @Override
    public void setStackInSlot(int slot, @Nonnull ItemStack stack) {
        validateSlotIndex(slot);
        if (ItemStack.areItemStacksEqual(this.stacks.get(slot), stack))
            return;

        this.stackSizes[slot] = stack.getCount();
        stack.setCount(1);
        this.stacks.set(slot, stack);
        onContentsChanged(slot);
    }
	
    @Override
    public int getSlots(){
        return stacks.size();
    }

    @Override
    @Nonnull
    public ItemStack getStackInSlot(int slot){
//    	System.out.println(this.stacks.toString());
//    	System.out.println(slot + " -> " + this.stacks.get(slot));
        validateSlotIndex(slot);
        ItemStack out = this.stacks.get(slot);

        if(out.isEmpty())
        	return out;
        if(this.stackSizes[slot] >= out.getMaxStackSize()){
        	out = ItemHandlerHelper.copyStackWithSize(out, out.getMaxStackSize());
        }else{
        	out = ItemHandlerHelper.copyStackWithSize(out, this.stackSizes[slot]);
        }
        return out;
    }
    
    @Override
    @Nonnull
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate){
        if (stack.isEmpty())
            return ItemStack.EMPTY;

        validateSlotIndex(slot);

        ItemStack existing = this.stacks.get(slot);
        int amount = this.stackSizes[slot];

        int limit = getStackLimit(slot, stack) * this.slotMultiplier;

        int remaining = limit - amount;

        if(remaining <= 0){
            //Not enough space!

        	return stack;
        }else{
        	//Enough Space
        	if(existing.isEmpty() || stack.isItemEqual(existing) && ItemStack.areItemStackTagsEqual(existing, stack)){
        		if(stack.getCount() <= remaining){
        			if(!simulate){
        				this.stackSizes[slot] = amount + stack.getCount();
        				if(existing.isEmpty())
        					this.stacks.set(slot, ItemHandlerHelper.copyStackWithSize(stack, 1));
        		        onContentsChanged(slot);
        			} 
        			return ItemStack.EMPTY;
        		}else if(stack.getCount() > remaining){
        			if(!simulate){
        				this.stackSizes[slot] = amount + remaining;
        				if(existing.isEmpty())
        					this.stacks.set(slot, ItemHandlerHelper.copyStackWithSize(stack, 1));
        		        onContentsChanged(slot);
        			}
            		return ItemHandlerHelper.copyStackWithSize(stack, stack.getCount() - remaining);
        		}
        	}
    		return stack;
        }
    }
    
    @Override
    @Nonnull
    public ItemStack extractItem(int slot, int amount, boolean simulate){
        if (amount == 0)
            return ItemStack.EMPTY;

        validateSlotIndex(slot);

        ItemStack existing = this.stacks.get(slot);

        if (existing.isEmpty())
            return ItemStack.EMPTY;

        int toExtract = Math.min(Math.min(amount, existing.getMaxStackSize()), this.stackSizes[slot]);

        if(!simulate){
        	if(toExtract == this.stackSizes[slot])
        		this.stacks.set(slot, ItemStack.EMPTY);
        	this.stackSizes[slot] -= toExtract;
            onContentsChanged(slot);
        }
        return ItemHandlerHelper.copyStackWithSize(existing, toExtract);
    }
    
    @Override
    public int getSlotLimit(int slot){
        return 64;
    }

    @Override
    protected int getStackLimit(int slot, @Nonnull ItemStack stack){
        return Math.min(getSlotLimit(slot), stack.getMaxStackSize());
    }
    
    @Override
    public NBTTagCompound serializeNBT(){
        NBTTagList nbtTagList = new NBTTagList();
        for (int i = 0; i < this.stacks.size(); i++){
            if (!this.stacks.get(i).isEmpty()){
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setInteger("amount", this.stackSizes[i]);
                itemTag.setInteger("slot", i);
                this.stacks.get(i).writeToNBT(itemTag);
                nbtTagList.appendTag(itemTag);
            }
        }
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("items", nbtTagList);
        nbt.setInteger("size", this.stacks.size());
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt){
        setSize(nbt.hasKey("size") ? nbt.getInteger("size") : 1);
        NBTTagList tagList = (NBTTagList) nbt.getTag("items");
        for (int i = 0; i < tagList.tagCount(); i++){
            NBTTagCompound itemTags = tagList.getCompoundTagAt(i);
            int amount = itemTags.getInteger("amount");

            this.stacks.set(itemTags.getInteger("slot"), new ItemStack(itemTags));
            this.stackSizes[itemTags.getInteger("slot")] = amount;
        }
        onLoad();
    }

    @Override
    protected void validateSlotIndex(int slot) {
        if (slot < 0 || slot >= this.stacks.size())
            throw new RuntimeException("Slot " + slot + " not in valid range - [0," + stacks.size() + ")");
    }
}
