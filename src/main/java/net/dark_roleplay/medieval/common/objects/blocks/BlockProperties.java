package net.dark_roleplay.medieval.common.objects.blocks;

import net.dark_roleplay.medieval.common.objects.blocks.building.roof.NormalRoof;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

public class BlockProperties {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public static final PropertyBool SINGLE = PropertyBool.create("single");

	
	public static final PropertyBool LIT = PropertyBool.create("lit");

	
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
