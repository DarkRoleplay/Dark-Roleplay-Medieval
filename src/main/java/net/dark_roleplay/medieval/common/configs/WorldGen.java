package net.dark_roleplay.medieval.common.configs;

import net.dark_roleplay.medieval.References;
import net.minecraftforge.common.config.Config;

@Config(modid = References.MODID, name = "Dark Roleplay Medieval/Dark Roleplay Medieval", category = "world_gen")
public class WorldGen {

	@Config.Name("Generate Copper Ore")
	@Config.Comment("Disabled/Enables ore generation for copper \nAllowed values: true, false")
	public static boolean GENERATE_COPPER = true;

	@Config.Name("Generate Tin Ore")
	@Config.Comment("Disabled/Enables ore generation for tin \nAllowed values: true, false")
	public static boolean GENERATE_TIN = true;

	@Config.Name("Generate Silver Ore")
	@Config.Comment("Disabled/Enables ore generation for silver \nAllowed values: true, false")
	public static boolean GENERATE_SILVER = true;

	@Config.Name("Generate Sulfur Ore")
	@Config.Comment("Disabled/Enables ore generation for sulfur \nAllowed values: true, false")
	public static boolean GENERATE_SULFUR = true;

	@Config.Name("Generate Salpeter Ore")
	@Config.Comment("Disabled/Enables ore generation for salpeter \nAllowed values: true, false")
	public static boolean GENERATE_SALPETER = true;

	@Config.Name("Generate Dry Clay Patches")
	@Config.Comment("Disabled/Enables ore generation for dry clay \nAllowed values: true, false")
	public static boolean GENERATE_DRY_CLAY = true;

	@Config.RequiresMcRestart
	@Config.Name("Generate Village Buildings")
	@Config.Comment("Disabled/Enables village house generation added by DRP \nAllowed values: true, false")
	public static boolean GENERATE_VILLAGE_BUILDINGS = false;
}
