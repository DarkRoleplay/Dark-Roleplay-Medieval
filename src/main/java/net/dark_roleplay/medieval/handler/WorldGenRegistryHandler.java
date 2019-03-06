package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(modid = DarkRoleplayMedieval.MODID, bus = Bus.MOD)
public class WorldGenRegistryHandler {

	public static void init(FMLCommonSetupEvent event) {
		MinableConfig minableConfig = new MinableConfig(MinableConfig.IS_ROCK, Blocks.DIAMOND_BLOCK.getDefaultState(), 20);
		CountRangeConfig placementConfig = new CountRangeConfig(1, 0, 0, 16);
		
		ForgeRegistries.BIOMES.forEach((biome) ->
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createCompositeFeature(Feature.MINABLE, minableConfig, Biome.COUNT_RANGE, placementConfig))
		);
	}
}
