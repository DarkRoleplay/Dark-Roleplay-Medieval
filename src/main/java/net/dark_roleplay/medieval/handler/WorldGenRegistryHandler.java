package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.holders.configs.WorldGen;
import net.dark_roleplay.medieval.objects.world_gen.materials.DryClayGenerator;
import net.dark_roleplay.medieval.objects.world_gen.materials.OreGen;
import net.dark_roleplay.medieval.objects.world_gen.village.carpenter.CarpenterHouse;
import net.dark_roleplay.medieval.objects.world_gen.village.carpenter.VillageHandlerCarpenter;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class WorldGenRegistryHandler {

	public static void init(FMLPreInitializationEvent event) {
		if(WorldGen.GENERATE_VILLAGE_BUILDINGS) {
			VillageHandlerCarpenter villageHandler = new VillageHandlerCarpenter();
			VillagerRegistry.instance().registerVillageCreationHandler(villageHandler);
			MapGenStructureIO.registerStructureComponent(CarpenterHouse.class, new ResourceLocation(References.MODID, "carpenter_house_small").toString());
		}

		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		GameRegistry.registerWorldGenerator(new DryClayGenerator(), 500);
	}
}
