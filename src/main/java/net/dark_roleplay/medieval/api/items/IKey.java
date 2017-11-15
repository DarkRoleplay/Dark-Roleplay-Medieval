package net.dark_roleplay.medieval.api.items;

import java.util.UUID;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public interface IKey {
	
	public default boolean doesFit(ItemStack key, ItemStack lock){
		if(lock.getItem() instanceof ILock && key.getItem() instanceof IKey && lock.hasTagCompound() && key.hasTagCompound()){
			NBTTagCompound tagLock = lock.getTagCompound();
			NBTTagCompound tagKey = key.getTagCompound();
			if(tagLock.hasKey("lock_uuid") && tagKey.hasKey("key_uuid")){
				return tagLock.getString("lock_uuid").equals(tagKey.getString("key_uuid"));
			}
		}
		return false;
	}
	
	public default UUID getUUID(ItemStack key){
		if(key.getItem() instanceof IKey){
			if(key.hasTagCompound()){
				NBTTagCompound tag = key.getTagCompound();
				if(tag.hasKey("key_uuid")){
					return UUID.fromString(tag.getString("key_uuid"));
				}
			}
		}
		return null;
	}
	
	public default void setUUID(ItemStack key, UUID keyUUID){
		if(key.getItem() instanceof IKey){
			if(key.hasTagCompound()){
				NBTTagCompound tag = key.getTagCompound();
				tag.setString("key_uuid", keyUUID.toString());
				key.setTagCompound(tag);
			}else{
				NBTTagCompound tag = new NBTTagCompound();
				tag.setString("key_uuid", keyUUID.toString());
				key.setTagCompound(tag);
			}
		}
	}
	
	public int getTier();
	
}
