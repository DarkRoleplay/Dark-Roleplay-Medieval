package net.dark_roleplay.medieval.api.items;

import net.dark_roleplay.drpcore.api.items.DRPItem;

public class DRPLock extends DRPItem{

	private lockLevel level;
	
	public DRPLock(lockLevel level, String name, int stackSize, String... subNames){
		super(name, null, stackSize, subNames);
		this.level = level;
	}
	
	public DRPLock(lockLevel level, String name, String itemFolder, int stackSize, String... subNames){
		super(name, itemFolder,stackSize, subNames);
		this.level = level;
	}
	
	public static enum lockLevel{
		
		WEAK,
		NORMAL,
		STRONG,
		UNBREAKABLE;
		
	}
	
}
