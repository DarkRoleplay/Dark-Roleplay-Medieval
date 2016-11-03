package net.drpmedieval.common.entity;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.entity.entitySittable.EntitySittable;
import net.drpmedieval.common.entity.item.EntitySledge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class DRPMedievalEntities {
	
	public static final void preInit(FMLPreInitializationEvent event) {}
	
	private static int id = 0;
	
	public static final void init(FMLInitializationEvent event) {
		
		EntityRegistry.registerModEntity(EntitySittable.class, "Mountable", id++, DarkRoleplayMedieval.instance, 80, 1, false);
		EntityRegistry.registerModEntity(EntitySledge.class, "Sledge", id++, DarkRoleplayMedieval.instance, 63, 3, true , 0xFF00FF, 0x00FF00);
		
	}

	public static final void postInit(FMLPostInitializationEvent event) {}
}
