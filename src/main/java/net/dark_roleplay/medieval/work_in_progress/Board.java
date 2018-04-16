package net.dark_roleplay.medieval.work_in_progress;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Board extends IForgeRegistryEntry<Board>{
	
	public boolean canJoin();
	
	public void join(EntityPlayer player);
	
	public void leave(EntityPlayer player);
	
	public byte getMaxParticipants();
	
	public NBTTagCompound writeBoard(NBTTagCompound tag);
	
	public void readBoard(NBTTagCompound tag);
	
	public int getID();
	
	public void setID(int id);
	
	public int checkWin();
	
	public void onMove(Action action);
}
