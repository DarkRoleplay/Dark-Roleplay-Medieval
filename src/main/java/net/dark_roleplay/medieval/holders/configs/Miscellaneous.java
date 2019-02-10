package net.dark_roleplay.medieval.holders.configs;

import net.dark_roleplay.medieval.References;
import net.minecraftforge.common.config.Config;

@Config(modid = References.MODID, name = "Dark Roleplay Medieval/Dark Roleplay Medieval", category = "miscellaneous")
public class Miscellaneous {

	@Config.Name("Regeneration Time Emerald Ore")
	@Config.Comment("The time regenerating Emerald Ore takes to regenerate (20tick = 1sec")
	@Config.RangeInt(min = 100, max = 18000 * 20)
	@Config.RequiresMcRestart
	public static int REGEN_TIME_EMERALD = 300 * 20;

	@Config.Name("Regeneration Time Diamond Ore")
	@Config.Comment("The time regenerating Diamond Ore takes to regenerate (20tick = 1sec")
	@Config.RangeInt(min = 100, max = 18000 * 20)
	@Config.RequiresMcRestart
	public static int REGEN_TIME_DIAMOND = 300 * 20;

	@Config.Name("Regeneration Time Lapis Ore")
	@Config.Comment("The time regenerating Lapis Ore takes to regenerate (20tick = 1sec")
	@Config.RangeInt(min = 100, max = 18000 * 20)
	@Config.RequiresMcRestart
	public static int REGEN_TIME_LAPIS = 300 * 20;

	@Config.Name("Regeneration Time Redstone Ore")
	@Config.Comment("The time regenerating Redstone Ore takes to regenerate (20tick = 1sec")
	@Config.RangeInt(min = 100, max = 18000 * 20)
	@Config.RequiresMcRestart
	public static int REGEN_TIME_REDSTONE = 300 * 20;

	@Config.Name("Regeneration Time Gold Ore")
	@Config.Comment("The time regenerating Gold Ore takes to regenerate (20tick = 1sec")
	@Config.RangeInt(min = 100, max = 18000 * 20)
	@Config.RequiresMcRestart
	public static int REGEN_TIME_GOLD = 300 * 20;

	@Config.Name("Regeneration Time Iron Ore")
	@Config.Comment("The time regenerating Iron Ore takes to regenerate (20tick = 1sec")
	@Config.RangeInt(min = 100, max = 18000 * 20)
	@Config.RequiresMcRestart
	public static int REGEN_TIME_IRON = 300 * 20;

	@Config.Name("Regeneration Time Coal Ore")
	@Config.Comment("The time regenerating Coal Ore takes to regenerate (20tick = 1sec")
	@Config.RangeInt(min = 100, max = 18000 * 20)
	@Config.RequiresMcRestart
	public static int REGEN_TIME_COAL = 300 * 20;

	@Config.Name("Regeneration Time Quartz Ore")
	@Config.Comment("The time regenerating Quartz Ore takes to regenerate (20tick = 1sec")
	@Config.RangeInt(min = 100, max = 18000 * 20)
	@Config.RequiresMcRestart
	public static int REGEN_TIME_QUARTZ = 300 * 20;
}
