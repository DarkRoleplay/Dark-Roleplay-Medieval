package net.dark_roleplay.medieval.common.handler;

import java.awt.Color;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.entities.entity.item.EntitySledge;
import net.dark_roleplay.medieval.common.entities.entity.projectile.EntityRopedArrow;
import net.dark_roleplay.medieval.common.entities.fox.Entity_Fox;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class DRPMedievalEntities {
	
	public static final void init(FMLPreInitializationEvent event) {
		
		EntityRegistry.registerModEntity(new ResourceLocation(DRPMedievalInfo.MODID,"sledge"), EntitySledge.class, "Sledge", DRPMedievalEntities.id++, DarkRoleplayMedieval.instance, 32, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DRPMedievalInfo.MODID,"roped_arrow"), EntityRopedArrow.class, "RopedArrow", DRPMedievalEntities.id++, DarkRoleplayMedieval.instance, 0, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DRPMedievalInfo.MODID, "fox"), Entity_Fox.class, "fox", DRPMedievalEntities.id++, DarkRoleplayMedieval.instance, 32, 3, true, new Color(255, 100, 0).getRGB(), new Color(200, 200, 200).getRGB());
		
	}
	
	private static int id = 0;
	
	public static final void init(FMLInitializationEvent event) {

	}
	
	public static final void init(FMLPostInitializationEvent event) {}
}
