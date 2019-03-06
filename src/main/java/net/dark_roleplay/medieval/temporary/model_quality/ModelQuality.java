package net.dark_roleplay.medieval.temporary.model_quality;

import net.minecraft.util.IStringSerializable;

public enum ModelQuality implements IStringSerializable{
	LOW("low", 0),
	NORMAL("normal", 1),
	HIGH("high", 2),
	EPIC("epic", 3);

	private String name;
	private int qualityLevel = 0;
	
	private ModelQuality(String name, int qualityLevel) {
		this.name = name;
		this.qualityLevel = qualityLevel;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public boolean accepts(ModelQuality quality) {
		return quality.qualityLevel <= this.qualityLevel;
	}
}
