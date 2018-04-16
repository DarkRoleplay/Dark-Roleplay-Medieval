package net.dark_roleplay.medieval.work_in_progress;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Action{

	public void onActionReceived(Action a);
	
	public NBTTagCompound writeAction(NBTTagCompound tag);
	
	public void readAction(NBTTagCompound tag);
	
	public int getBoardID();
}
