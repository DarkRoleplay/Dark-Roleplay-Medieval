package net.drpmedieval.common.entity;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.entity.entitySittable.EntitySittable;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class DRPMedievalEntities {
	
	public static final void preInit(FMLPreInitializationEvent event) {}
	
	public static final void init(FMLInitializationEvent event) {
		
		EntityRegistry.registerModEntity(EntitySittable.class, "Mountable", 0, DarkRoleplayMedieval.instance, 80, 1, false);
		
	}

	public static final void postInit(FMLPostInitializationEvent event) {}
}
