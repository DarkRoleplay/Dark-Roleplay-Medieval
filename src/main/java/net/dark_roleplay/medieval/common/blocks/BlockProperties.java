package net.dark_roleplay.medieval.common.blocks;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

public class BlockProperties {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public static final PropertyBool LIT = PropertyBool.create("lit");

}
