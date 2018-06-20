package net.dark_roleplay.medieval.common.objects.blocks.helper;

import net.minecraft.util.IStringSerializable;

public enum EnumMattressType implements IStringSerializable
{
	NONE("none"),
    STRAW("straw"),
    WOOL("wool");

    private final String name;

    private EnumMattressType(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return this.name;
    }

    public String getName()
    {
        return this.name;
    }
    
    public static EnumMattressType getType(String string){
    	switch(string){
    		case "none":
    			return NONE;
    		case "straw":
    			return STRAW;
    		case "wool":
    			return WOOL;
    		default:
    			return NONE;
    	}
    }
}
