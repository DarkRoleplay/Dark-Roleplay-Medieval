package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.core.modules.hud.Hud;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.client.objects.huds.TimberedClayHud;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class MedievalHuds {


	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Hud> registryEvent) {
		registryEvent.getRegistry().register(new TimberedClayHud(new ResourceLocation(References.MODID, "timbered_clay_view")));
	}

}
