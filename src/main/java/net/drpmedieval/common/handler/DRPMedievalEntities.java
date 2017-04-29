package net.drpmedieval.common.handler;

import java.awt.Color;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.entities.fox.Entity_Fox;
import net.drpmedieval.common.entity.entitySittable.EntitySittable;
import net.drpmedieval.common.entity.item.EntitySledge;
import net.drpmedieval.common.entity.projectile.EntityRopedArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class DRPMedievalEntities {
	
	public static final void preInit(FMLPreInitializationEvent event) {
		
		EntityRegistry.registerModEntity(new ResourceLocation(DarkRoleplayMedieval.MODID,"mountable"), EntitySittable.class, "Mountable", id++, DarkRoleplayMedieval.instance, 10, 1, false);
		EntityRegistry.registerModEntity(new ResourceLocation(DarkRoleplayMedieval.MODID,"sledge"), EntitySledge.class, "Sledge", id++, DarkRoleplayMedieval.instance, 32, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DarkRoleplayMedieval.MODID,"roped_arrow"), EntityRopedArrow.class, "RopedArrow", id++, DarkRoleplayMedieval.instance, 0, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DarkRoleplayMedieval.MODID, "fox"), Entity_Fox.class, "fox", id++, DarkRoleplayMedieval.instance, 32, 3, true, new Color(255, 100, 0).getRGB(), new Color(200, 200, 200).getRGB());
		
	}
	
	private static int id = 0;
	
	public static final void init(FMLInitializationEvent event) {

	}
	
	public static final void postInit(FMLPostInitializationEvent event) {}
}
