package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Config(modid = DRPMedievalInfo.MODID, name = "Dark Roleplay Medieval/Dark Roleplay Medieval", category = "drpmedieval")
public class DRPMedievalConfig {
	
	@Config.Comment("This category contains all ot")
	public static WorldGen WORLD_GEN = new WorldGen();

	public static class WorldGen{
		@Config.Name("Generate Copper Ore")
		@Config.Comment("Disabled/Enables ore generation for copper \nAllowed values: true, false")
		public boolean GENERATE_COPPER = true;
		
		@Config.Name("Generate Tin Ore")
		@Config.Comment("Disabled/Enables ore generation for tin \nAllowed values: true, false")
		public boolean GENERATE_TIN = true;
		
		@Config.Name("Generate Silver Ore")
		@Config.Comment("Disabled/Enables ore generation for silver \nAllowed values: true, false")
		public boolean GENERATE_SILVER = true;
		
		@Config.Name("Generate Sulfur Ore")
		@Config.Comment("Disabled/Enables ore generation for sulfur \nAllowed values: true, false")
		public boolean GENERATE_SULFUR = true;
		
		@Config.Name("Generate Salpeter Ore")
		@Config.Comment("Disabled/Enables ore generation for salpeter \nAllowed values: true, false")
		public boolean GENERATE_SALPETER = true;
	}
	
}
