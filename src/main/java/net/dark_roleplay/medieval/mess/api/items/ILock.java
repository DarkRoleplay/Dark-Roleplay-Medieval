package net.dark_roleplay.medieval.mess.api.items;

import java.util.UUID;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface ILock {
	
	public default boolean doesFit(ItemStack lock, ItemStack key){
		if(lock.getItem() instanceof ILock && key.getItem() instanceof IKey && lock.hasTagCompound() && key.hasTagCompound()){
			NBTTagCompound tagLock = lock.getTagCompound();
			NBTTagCompound tagKey = key.getTagCompound();
			if(tagLock.hasKey("lock_uuid") && tagKey.hasKey("key_uuid")){
				return tagLock.getString("lock_uuid").equals(tagKey.getString("key_uuid"));
			}
		}
		return false;
	}
	
	public default UUID getUUID(ItemStack lock){
		if(lock.getItem() instanceof ILock){
			if(lock.hasTagCompound()){
				NBTTagCompound tag = lock.getTagCompound();
				if(tag.hasKey("lock_uuid")){
					return UUID.fromString(tag.getString("lock_uuid"));
				}
			}
		}
		return null;
	}
	
	public default void setUUID(ItemStack lock, UUID lockUUID){
		if(lock.getItem() instanceof ILock){
			if(lock.hasTagCompound()){
				NBTTagCompound tag = lock.getTagCompound();
				tag.setString("lock_uuid", lockUUID.toString());
				lock.setTagCompound(tag);
			}else{
				NBTTagCompound tag = new NBTTagCompound();
				tag.setString("lock_uuid", lockUUID.toString());
				lock.setTagCompound(tag);
			}
		}
	}
	
	public int getTier();
	
}
