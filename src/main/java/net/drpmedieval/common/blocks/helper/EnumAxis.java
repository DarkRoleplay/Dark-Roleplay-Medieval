package net.drpmedieval.common.blocks.helper;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

public enum EnumAxis implements IStringSerializable{
	
    X("x"),
    Z("z");

    private final String name;

    private EnumAxis(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }

    public static EnumAxis fromFacingAxis(EnumFacing.Axis axis){
        switch (axis){
            case X:
                return X;
            case Z:
                return Z;
            default:
            	return X;
        }
    }

    public String getName(){
        return this.name;
    }
}
