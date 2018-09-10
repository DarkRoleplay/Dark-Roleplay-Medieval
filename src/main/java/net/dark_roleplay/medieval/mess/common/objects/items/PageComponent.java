package net.dark_roleplay.medieval.mess.common.objects.items;

import org.lwjgl.util.Point;

import net.minecraft.nbt.NBTTagCompound;

public abstract class PageComponent {

	private Point pos;
	
	public PageComponent(Point pos){
		this.pos = pos;
	}
	
	public Point getPos(){
		return this.pos;
	}
	
	public abstract NBTTagCompound parseToCompound();
	
	public abstract boolean parseFromCompound(NBTTagCompound tag);
}
