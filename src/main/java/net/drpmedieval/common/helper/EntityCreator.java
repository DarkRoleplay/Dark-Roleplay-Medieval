package net.drpmedieval.common.helper;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityCreator {

	public static final void createEntity(Class entityClass, String entityName,EnumCreatureType type, int propability, int minSpawn, int maxSpawn, BiomeGenBase[] biomes, int solidColor, int spotColor, boolean hasSpawnEgg){
		int id = 0;
		EntityRegistry.registerModEntity(entityClass, entityName, id , DarkRoleplayMedieval.instance, 64, 1, true);
		//EntityRegistry.addSpawn(entityName, propability, minSpawn, maxSpawn, type, biomes);
	
		if(hasSpawnEgg){
			EntityList.entityEggs.put(Integer.valueOf(id), new EntityList.EntityEggInfo(id, solidColor, spotColor));
		}
	
	}
	
	
}
