package net.dark_roleplay.medieval.minigame;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public interface IMinigame{
	
	public void handlePacket(NBTTagCompound tag, EntityPlayer player);
	
	public boolean addPlayer(EntityPlayer player);
	public boolean removePlayer(EntityPlayer player);
	public boolean addSpectator(EntityPlayer player);
	public boolean removeSpectator(EntityPlayer player);
}
