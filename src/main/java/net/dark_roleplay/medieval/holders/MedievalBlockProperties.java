package net.dark_roleplay.medieval.holders;

import net.minecraft.util.IStringSerializable;

public class MedievalBlockProperties {

//	public static final PropertyEnum<EnumFacing.Axis> AXIS_HORIZONTAL = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class, EnumFacing.Axis.X, EnumFacing.Axis.Z);
//	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.<EnumFacing.Axis>create("axis", EnumFacing.Axis.class);
//	public static final PropertyDirection FACING_HORIZONTAL = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
//
//
//	public static final PropertyBool ADDON_LIGHTER = PropertyBool.create("addon_lighter");
//	public static final PropertyBool ADDON_TRAP = PropertyBool.create("addon_trap");
//	public static final PropertyBool POWERED = PropertyBool.create("powered");
//
//	//Wood Bench
//	public static final PropertyBool SINGLE = PropertyBool.create("single"); //TODO change to SD_CONNECTION
//
//	//Dirt Stairs
//	public static final PropertyEnum<StairType> STAIR_TYPE = PropertyEnum.<StairType>create("type", StairType.class);
//	public static final PropertyEnum<WindowPlacement> WINDOW_PLACEMENT = PropertyEnum.<WindowPlacement>create("placement", WindowPlacement.class);
//
//	//Wooden Stairs
//
//	//Target
//	public static final PropertyBool IS_TOP = PropertyBool.create("top");
//
//	//Dungeon Chest
//	public static final PropertyBool LIT = PropertyBool.create("lit");
//	public static final PropertyBool IS_OPEN = PropertyBool.create("open");
//
//	public static final PropertyInteger BURNING_CANDLES = PropertyInteger.create("burning_candles", 0, 4);
//
//	/**
//	 * Default Implementation should set this to double, if there are 2+ equal blocks next to each other, otherwise it should be single
//	 */
//	public static final PropertyEnum<ConnectionSD> SD_CONNECTION = PropertyEnum.<ConnectionSD>create("connection", ConnectionSD.class);
//	public static final PropertyBool GROUNDED = PropertyBool.create("grounded");
//
//	public static final PropertyEnum<Part> PART = PropertyEnum.<Part>create("part", Part.class);
//
//
//	public static final PropertyBool HAS_TE = PropertyBool.create("has_te");
//	public static final PropertyBool SNOWED = PropertyBool.create("snowed"); //TODO change to SD_CONNECTION
//
//	public static final PropertyInteger ORE_COUNT = PropertyInteger.create("ore_count", 0, 3);
//	public static final PropertyInteger ORE_LIMIT = PropertyInteger.create("ore_limit", 1, 3);




	public static enum StairType implements IStringSerializable{
		STRAIGHT,
		INNER_LEFT,
		INNER_RIGHT,
		OUTER_LEFT,
		OUTER_RIGHT;

		@Override
		public String getName() { return this.name().toLowerCase(); }
	}

	public static enum WindowPlacement implements IStringSerializable{
		OFFSET,
		CENTERED;

		@Override
		public String getName() { return this.name().toLowerCase(); }
	}

	public static enum Part implements IStringSerializable{
		TOP,
		BOTTOM;

		@Override
		public String getName() { return this.name().toLowerCase(); }
	}

	public static enum ConnectionSD implements IStringSerializable{
		SINGLE,
		DOUBLE;

		@Override
		public String getName() { return this.name().toLowerCase(); }

		public ConnectionSD get(int meta) {
			for(ConnectionSD value : ConnectionSD.values()) {
				if(meta == value.ordinal())
					return value;
			}
			return null;
		}
	}

	public static class Settings {

//		public static final BlockSettings WOOD_SOLID = new BlockSettings(Material.WOOD, SoundType.WOOD, 2.0F, 5.0F);
//		public static final BlockSettings WOOD_DECO = new BlockSettings(Material.WOOD, SoundType.WOOD, 2.0F, 5.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false);
//		public static final BlockSettings WOOD_DECO_TESR =new BlockSettings(Material.WOOD, SoundType.WOOD, 2.0F, 5.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false).setBlockRenderType(EnumBlockRenderType.INVISIBLE);
//		public static final BlockSettings WOOD_ROOF = new BlockSettings(Material.WOOD, SoundType.WOOD, 2.0F, 5.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false).setLightOpacity(255).setBlockFaceShape(BlockFaceShape.UNDEFINED);
//
//		public static final BlockSettings PAPER_DECO = new BlockSettings(Material.WOOD, SoundType.CLOTH, 1.0F, 2.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false);
//		public static final BlockSettings PLANT_DECO = new BlockSettings(Material.PLANTS, SoundType.PLANT, 0.0F, 0.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false).setBlockRenderLayer(BlockRenderLayer.CUTOUT_MIPPED);
//
//		public static final BlockSettings UNFIRED_POTTERY = new BlockSettings(Material.CLAY, SoundType.GROUND, 1.0F, 2.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false);
//		public static final BlockSettings FIRED_POTTERY = new BlockSettings(Material.GLASS, SoundType.GLASS, 1.0F, 2.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false);
//
//
//		public static final BlockSettings METAL_SOLID = new BlockSettings(Material.IRON, SoundType.METAL, 5.0F, 15.0F);
//		public static final BlockSettings METAL_DECO = new BlockSettings(Material.IRON, SoundType.METAL, 5.0F, 15.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false);
//		public static final BlockSettings METAL_DECO_TESR = new BlockSettings(Material.IRON, SoundType.METAL, 5.0F, 15.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false).setBlockRenderType(EnumBlockRenderType.INVISIBLE);
//
//		public static final BlockSettings STONE_SOLID = new BlockSettings(Material.ROCK, SoundType.STONE, 1.5F, 10.0F);
//		public static final BlockSettings STONE_DECO = new BlockSettings(Material.ROCK, SoundType.STONE, 1.5F, 10.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false);
//		public static final BlockSettings STONE_DECO_TESR = new BlockSettings(Material.ROCK, SoundType.STONE, 1.5F, 10.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false).setBlockRenderType(EnumBlockRenderType.INVISIBLE);
//
//		public static final BlockSettings SNOW_SOLID = new BlockSettings(Material.CRAFTED_SNOW, SoundType.SNOW, 0.2F, 0.0F);
//		//		Block
//		public static final BlockSettings PACKED_ICE = new BlockSettings(Material.PACKED_ICE, SoundType.GLASS, 0.5F, 0.0F).setSlipperiness(0.98F);
//
//		public static final BlockSettings OBSIDIAN_GLASS = new BlockSettings(Material.GLASS, SoundType.STONE, 4F, 4000.0F).setBlockFaceShape(BlockFaceShape.UNDEFINED).setFullAndOpaque(false, false).setLightOpacity(6);


	}
}
