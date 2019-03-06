package net.dark_roleplay.medieval.one_twelve.objects.configs;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

public class ConfigWorldGen {

	public final BooleanValue GENERATE_COPPER;
	public final BooleanValue GENERATE_TIN;
	public final BooleanValue GENERATE_SILVER;
	public final BooleanValue GENERATE_SULFUR;
	public final BooleanValue GENERATE_SALPETER;
	
	public final BooleanValue DRY_CLAY;
	public final BooleanValue GENERATE_VILLAGE_BUILDINGS;
	
	private static String ORE_GEN_LANG = "drpmedieval.config.world_gen.ores.";	
	private static String OTHER_GEN_LANG = "drpmedieval.config.world_gen.resources.";
	private static String BUILDING_GEN_LANG = "drpmedieval.config.world_gen.buildings.";
	
	public ConfigWorldGen(ForgeConfigSpec.Builder builder) {
		builder.comment("This section allows you to enable/disable ore generation for seperate ores.");
		builder.push("Ore Generation");
			GENERATE_COPPER = builder
					.translation(ORE_GEN_LANG + "copper")
					.worldRestart()
					.define("Copper", false);
			GENERATE_TIN = builder
					.translation(ORE_GEN_LANG + "tin")
					.worldRestart()
					.define("Tin", false);
			GENERATE_SILVER = builder
					.translation(ORE_GEN_LANG + "silver")
					.worldRestart()
					.define("Silver", false);
			GENERATE_SULFUR = builder
					.translation(ORE_GEN_LANG + "sulfur")
					.worldRestart()
					.define("Sulfur", false);
			GENERATE_SALPETER = builder
					.translation(ORE_GEN_LANG + "salpeter")
					.worldRestart()
					.define("Salpeter", false);
		builder.pop();
		
		builder.comment("This section allows you to enable/disable world generation for other resources");
		builder.push("Resource Generation");
			DRY_CLAY = builder
					.translation(OTHER_GEN_LANG + "dry_clay")
					.worldRestart()
					.define("Dry Clay", false);
		builder.pop();
		
		builder.comment("This section allows you to enable/disable world generation for buildings");
		builder.push("Building Generation");
			GENERATE_VILLAGE_BUILDINGS = builder
					.translation(BUILDING_GEN_LANG + "carpenter")
					.worldRestart()
					.define("Carpenter House", true);
		builder.pop();
	}
}
