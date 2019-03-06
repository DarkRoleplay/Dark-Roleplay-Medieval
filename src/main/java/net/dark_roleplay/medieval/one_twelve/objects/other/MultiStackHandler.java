package net.dark_roleplay.medieval.one_twelve.objects.other;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
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

    public MultiStackHandler(int size, int slotMultiplier){
    	this(size);
    	this.slotMultiplier = slotMultiplier;
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
        this.validateSlotIndex(slot);
        if (ItemStack.areItemStacksEqual(this.stacks.get(slot), stack))
            return;

        this.stackSizes[slot] = stack.getCount();
        stack.setCount(1);
        this.stacks.set(slot, stack);
        this.onContentsChanged(slot);
    }

    @Override
    public int getSlots(){
        return this.stacks.size();
    }

    @Override
    @Nonnull
    public ItemStack getStackInSlot(int slot){
//    	System.out.println(this.stacks.toString());
//    	System.out.println(slot + " -> " + this.stacks.get(slot));
        this.validateSlotIndex(slot);
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

        this.validateSlotIndex(slot);

        ItemStack existing = this.stacks.get(slot);
        int amount = this.stackSizes[slot];

        int limit = this.getStackLimit(slot, stack) * this.slotMultiplier;

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
        		        this.onContentsChanged(slot);
        			}
        			return ItemStack.EMPTY;
        		}else if(stack.getCount() > remaining){
        			if(!simulate){
        				this.stackSizes[slot] = amount + remaining;
        				if(existing.isEmpty())
        					this.stacks.set(slot, ItemHandlerHelper.copyStackWithSize(stack, 1));
        		        this.onContentsChanged(slot);
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

        this.validateSlotIndex(slot);

        ItemStack existing = this.stacks.get(slot);

        if (existing.isEmpty())
            return ItemStack.EMPTY;

        int toExtract = Math.min(Math.min(amount, existing.getMaxStackSize()), this.stackSizes[slot]);

        if(!simulate){
        	if(toExtract == this.stackSizes[slot])
        		this.stacks.set(slot, ItemStack.EMPTY);
        	this.stackSizes[slot] -= toExtract;
            this.onContentsChanged(slot);
        }
        return ItemHandlerHelper.copyStackWithSize(existing, toExtract);
    }

    @Override
    public int getSlotLimit(int slot){
        return 64;
    }

    @Override
    protected int getStackLimit(int slot, @Nonnull ItemStack stack){
        return Math.min(this.getSlotLimit(slot), stack.getMaxStackSize());
    }

    @Override
    public NBTTagCompound serializeNBT(){
        NBTTagList nbtTagList = new NBTTagList();
        for (int i = 0; i < this.stacks.size(); i++){
            if (!this.stacks.get(i).isEmpty()){
                NBTTagCompound itemTag = new NBTTagCompound();
                itemTag.setInt("amount", this.stackSizes[i]);
                itemTag.setInt("slot", i);
                this.stacks.get(i).write(itemTag);
                nbtTagList.add(itemTag);
            }
        }
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setTag("items", nbtTagList);
        nbt.setInt("size", this.stacks.size());
        return nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt){
        this.setSize(nbt.hasKey("size") ? nbt.getInt("size") : 1);
        NBTTagList tagList = (NBTTagList) nbt.getTag("items");
        for (int i = 0; i < tagList.size(); i++){
            NBTTagCompound itemTags = tagList.getCompound(i);
            int amount = itemTags.getInt("amount");

            this.stacks.set(itemTags.getInt("slot"), ItemStack.read(itemTags));
            this.stackSizes[itemTags.getInt("slot")] = amount;
        }
        this.onLoad();
    }

    @Override
    protected void validateSlotIndex(int slot) {
        if (slot < 0 || slot >= this.stacks.size())
            throw new RuntimeException("Slot " + slot + " not in valid range - [0," + this.stacks.size() + ")");
    }
}
