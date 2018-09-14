package net.dark_roleplay.medieval.common.objects.blocks;

import net.dark_roleplay.library.experimental.blocks.BlockSettings;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;

public class BlockProperties {
	
    public static final PropertyEnum<EnumFacing.Axis> AXIS_HORIZONTAL = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);
    public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class);
	public static final PropertyDirection FACING_HORIZONTAL = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public static class Settings {
		
		public static final BlockSettings WOOD_SOLID = new BlockSettings(Material.WOOD, SoundType.WOOD, 2.0F, 5.0F);
		public static final BlockSettings WOOD_DECO = new BlockSettings(Material.WOOD, SoundType.WOOD, 2.0F, 5.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false);
		
		public static final BlockSettings STONE_SOLID = new BlockSettings(Material.ROCK, SoundType.STONE, 1.5F, 10.0F);
		public static final BlockSettings SNOW_SOLID = new BlockSettings(Material.CRAFTED_SNOW, SoundType.SNOW, 0.2F, 0.0F);
//		Block
		public static final BlockSettings PACKED_ICE = new BlockSettings(Material.PACKED_ICE, SoundType.GLASS, 0.5F, 0.0F);


	}
}
