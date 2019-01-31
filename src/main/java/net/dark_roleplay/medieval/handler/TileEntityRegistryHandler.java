package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.objects.blocks_cleanup.building.roof.TileEntityRoof;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber(modid = References.MODID)
public class TileEntityRegistryHandler {

	//Abusing this till we get a Registry Event for TileEntities
	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Block> registryEvent) {
		GameRegistry.registerTileEntity(TileEntityRoof.class, new ResourceLocation(References.MODID, "roof"));
		GameRegistry.registerTileEntity(DynamicStorageTileEntity.class, new ResourceLocation(References.MODID, "te_dynamic_storage"));
	}

}