package net.dark_roleplay.medieval.common.blocks.building.shingles;

import net.dark_roleplay.library.blocks.BlockSettings;
import net.dark_roleplay.library.blocks.DRPBlock;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;

public class Slab extends DRPBlock{

	public static final PropertyEnum<SlabType> TYPE = PropertyEnum.<SlabType>create("type", SlabType.class);
	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class);

	public Slab(String name, BlockSettings settings) {
		super(name, settings);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, TYPE, AXIS);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();
		
		int axis = meta % 3;
		if(axis == 0) state = state.withProperty(AXIS, EnumFacing.Axis.Y);
		else if(axis == 1) state = state.withProperty(AXIS, EnumFacing.Axis.X);
		else if(axis == 2) state = state.withProperty(AXIS, EnumFacing.Axis.Z);
		
		int type = meta / 3;
		if(type == 0) state = state.withProperty(TYPE, SlabType.BOTTOM);
		else if(type == 1) state = state.withProperty(TYPE, SlabType.TOP);
		else if(type == 2) state = state.withProperty(TYPE, SlabType.FULL_BLOCK);
		
		return state;
	}


	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		
		EnumFacing.Axis axis = state.getValue(AXIS);
		
		if(axis == EnumFacing.Axis.Y) i += 0;
		else if(axis == EnumFacing.Axis.X) i += 1;
		else if(axis == EnumFacing.Axis.Z) i += 2;
		
		SlabType type = state.getValue(TYPE);
		
		if(type == SlabType.TOP) i += 3;
		else if(type == SlabType.FULL_BLOCK) i += 6;
		
		return i;
	}
	
	public static enum SlabType implements IStringSerializable{
		BOTTOM,
		TOP,
		FULL_BLOCK;
		
		@Override
		public String getName() {
			return this.name().toLowerCase();
		}
	}
}
