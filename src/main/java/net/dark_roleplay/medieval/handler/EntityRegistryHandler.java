package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.util.sitting.EntitySittable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = DarkRoleplayMedieval.MODID, bus = Bus.MOD)
public class EntityRegistryHandler {
private static int entityID = 0;

	private static IForgeRegistry<EntityType<?>> registry = null;


	@SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
		registry = event.getRegistry();

		reg(EntityType.Builder.create(EntitySittable.class, EntitySittable::new).disableSummoning().tracker(32, 1, false), "sittable");
//		EntityType.Builder.create(
//        final IForgeRegistry<EntityEntry> reg = event.getRegistry();
//
////        reg.register(createBuilder("wheelbarrel").entity(Wheelbarrel.class).tracker(32, 3, true).build());
////        reg.register(createBuilder("fox").entity(Entity_Fox.class).tracker(32, 3, true).egg(new Color(255, 100, 0).getRGB(), new Color(200, 200, 200).getRGB()).build());
////        reg.register(createBuilder("rope_slider").entity(RopeSlider.class).tracker(32, 10, true).build());
//
    }
//
//
	protected static void reg(EntityType.Builder<?> entity, String registryName) {
		EntityType<?> type = entity.build(registryName);
		type.setRegistryName(new ResourceLocation(DarkRoleplayMedieval.MODID, registryName));
		registry.register(type);
	}
}
