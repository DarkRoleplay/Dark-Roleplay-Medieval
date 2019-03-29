package net.dark_roleplay.medieval.objects.enums;

import net.minecraft.util.IStringSerializable;

public enum BenchSection implements IStringSerializable{

	SINGLE("single"),
	LEFT("left"),
	RIGHT("right"),
	CENTER("center"),
	CENTER_SUPPORT("center_support");

    private final String name;
    
    private BenchSection(String name) {
    	this.name = name;
    }
    
	@Override
	public String getName() {
		return name;
	}
	
}
