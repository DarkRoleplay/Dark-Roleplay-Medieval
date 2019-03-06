package net.dark_roleplay.medieval.one_twelve.objects.configs.blocks;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class ConfigRegeneratingOres {
	
	public final IntValue REGEN_TIME_EMERALD;
	public final IntValue REGEN_TIME_DIAMOND;
	public final IntValue REGEN_TIME_LAPIS;
	public final IntValue REGEN_TIME_REDSTONE;
	public final IntValue REGEN_TIME_GOLD;
	public final IntValue REGEN_TIME_IRON;
	public final IntValue REGEN_TIME_COAL;
	public final IntValue REGEN_TIME_QUARTZ;
	
	private static String REGENERATING_ORES = "drpmedieval.config.misc.regenerating_ores.";	
	
	public ConfigRegeneratingOres(ForgeConfigSpec.Builder builder) {
		builder.comment("The time (in ticks, 20 ticks = 1 second) it takes for a specific ore to regenerate one ore");
		builder.push("Regenerating Ores");
		
			REGEN_TIME_EMERALD = setupOre(builder, "emeralds", "Emeralds");
			REGEN_TIME_DIAMOND = setupOre(builder, "diamonds", "Diamonds");
			REGEN_TIME_LAPIS = setupOre(builder, "lapis", "Lapis");
			REGEN_TIME_REDSTONE = setupOre(builder, "redstpne", "Redstone");
			REGEN_TIME_GOLD = setupOre(builder, "gold", "Gold");
			REGEN_TIME_IRON = setupOre(builder, "iron", "Iron");
			REGEN_TIME_COAL = setupOre(builder, "coal", "Coal");
			REGEN_TIME_QUARTZ = setupOre(builder, "quartz", "Quartz");
	
		builder.pop();
	}
	
	private IntValue setupOre(ForgeConfigSpec.Builder builder, String langKey, String key) {
		return builder
			.translation(REGENERATING_ORES + langKey)
			.worldRestart()
			.defineInRange(key, 6000, 1, Integer.MAX_VALUE);
	}
}
