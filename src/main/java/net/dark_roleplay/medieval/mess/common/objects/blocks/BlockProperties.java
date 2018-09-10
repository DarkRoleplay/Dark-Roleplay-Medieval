package net.dark_roleplay.medieval.mess.common.objects.blocks;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

public class BlockProperties {

	//TODO ROTATION
	
	//General
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	//Wall Mounted (Wall Mounts for Torch and Candles)
	public static final PropertyBool ADDON_LIGHTER = PropertyBool.create("addon_lighter");
	public static final PropertyBool ADDON_TRAP = PropertyBool.create("addon_trap");
	public static final PropertyBool POWERED = PropertyBool.create("powered");

	//Wood Bench
	public static final PropertyBool SINGLE = PropertyBool.create("single");
	
	//Dungeon Chest
	public static final PropertyBool LIT = PropertyBool.create("lit");

	//Target
	public static final PropertyBool IS_TOP = PropertyBool.create("top");
	
	//Dirt Stairs
	public static final PropertyEnum<StairType> STAIR_TYPE = PropertyEnum.<StairType>create("type", StairType.class);
	
	public static enum StairType implements IStringSerializable{
		STRAIGHT,
		INNER_LEFT,
		INNER_RIGHT,
		OUTER_LEFT,
		OUTER_RIGHT;
		
		@Override
		public String getName() {
			return this.name().toLowerCase();
		}
	}
}
