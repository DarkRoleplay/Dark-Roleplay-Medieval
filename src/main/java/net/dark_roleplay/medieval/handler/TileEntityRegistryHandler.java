package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ChoppingBlock;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ClockCore;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_DungeonChest;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FlowerContainer;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FluidBarrel;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Shelf;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ShopSign;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_UniversalShelf;
import net.dark_roleplay.medieval.common.objects.blocks_cleanup.building.roof.TileEntityRoof;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityAnvil;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityBookOne;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityCauldron;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityChain;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityCrate;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityFirepit;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityGrindstone;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityHangingCauldron;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityHook;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityKeyHanging;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityMortar;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityRopeAnchor;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityShipsWheel;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityTarget;
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


		//TODO Look trough this
		//TODO Finally make new models!
		GameRegistry.registerTileEntity(TileEntityAnvil.class, new ResourceLocation(References.MODID, "TileEntityAnvil"));
		GameRegistry.registerTileEntity(TileEntityMortar.class, new ResourceLocation(References.MODID, "TileEntityMortar"));
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, new ResourceLocation(References.MODID, "TileEntityGrindstone"));
		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, new ResourceLocation(References.MODID, "TileEntityHangingCauldron"));
		GameRegistry.registerTileEntity(TileEntityBookOne.class, new ResourceLocation(References.MODID, "TileEntityBookOne"));
		GameRegistry.registerTileEntity(TileEntityCauldron.class, new ResourceLocation(References.MODID, "TileEntityCauldron"));
		GameRegistry.registerTileEntity(TileEntityChain.class, new ResourceLocation(References.MODID, "TileEntityChain"));
		GameRegistry.registerTileEntity(TileEntityHook.class, new ResourceLocation(References.MODID, "TileEntityHook"));
		GameRegistry.registerTileEntity(TileEntityKeyHanging.class, new ResourceLocation(References.MODID, "TileEntityKeyHanging"));
		GameRegistry.registerTileEntity(TileEntityShipsWheel.class, new ResourceLocation(References.MODID, "TileEntityShipsWheel"));
		GameRegistry.registerTileEntity(TileEntityTarget.class, new ResourceLocation(References.MODID, "TileEntityTarget"));
		GameRegistry.registerTileEntity(TileEntityRopeAnchor.class, new ResourceLocation(References.MODID, "TileEntityRopeAnchor"));
		GameRegistry.registerTileEntity(TileEntityFirepit.class, new ResourceLocation(References.MODID, "TileEntityFirepit"));

		//New Storage
		GameRegistry.registerTileEntity(TE_FluidBarrel.class, new ResourceLocation(References.MODID, "tile_entity_fluid_barrel"));
		GameRegistry.registerTileEntity(TE_Shelf.class, new ResourceLocation(References.MODID, "te_shelf"));
		GameRegistry.registerTileEntity(TE_UniversalShelf.class, new ResourceLocation(References.MODID, "te_universal_shelf"));
		GameRegistry.registerTileEntity(TE_ChoppingBlock.class, new ResourceLocation(References.MODID, "te_chopping_block"));

		GameRegistry.registerTileEntity(TE_ClockCore.class, new ResourceLocation(References.MODID, "te_clock_core"));
		GameRegistry.registerTileEntity(TE_ShopSign.class, new ResourceLocation(References.MODID,"te_shop_sign"));

		//Old Storage
		GameRegistry.registerTileEntity(TileEntityCrate.class, new ResourceLocation(References.MODID, "TilEntityCrate"));
		GameRegistry.registerTileEntity(TE_DungeonChest.class, new ResourceLocation(References.MODID, "TileEntityDungeonChest"));

		//New Test Things
		GameRegistry.registerTileEntity(TE_FlowerContainer.class, new ResourceLocation(References.MODID, "flower_container"));
	}

}