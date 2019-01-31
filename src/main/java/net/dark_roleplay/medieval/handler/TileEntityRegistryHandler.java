package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.objects.blocks.building.roofs.TileEntityRoof;
import net.dark_roleplay.medieval.objects.blocks.decoration.barrels.TileEntityFluidBarrel;
import net.dark_roleplay.medieval.objects.blocks.decoration.flower_container.TileEntityFlowerContainer;
import net.dark_roleplay.medieval.objects.blocks.decoration.shop_signs.TileEntityShopSign;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityAnvil;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityBookOne;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityCauldron;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityChain;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityCrate;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityFirepit;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityGrindstone;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityHangingCauldron;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityHook;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityKeyHanging;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityMortar;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityRopeAnchor;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityShipsWheel;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityTarget;
import net.dark_roleplay.medieval.objects.blocks.utility.crafting.chopping_block.TileEntityChoppingBlock;
import net.dark_roleplay.medieval.objects.blocks.utility.other.clock_core.TileEntityClockCore;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.chests.simple_chest.TileEntitySimpleChest;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.shelfs.TileEntityShelf;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.shelfs.TileEnittyUniversalShelf;
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
		GameRegistry.registerTileEntity(TileEntityFluidBarrel.class, new ResourceLocation(References.MODID, "tile_entity_fluid_barrel"));
		GameRegistry.registerTileEntity(TileEntityShelf.class, new ResourceLocation(References.MODID, "te_shelf"));
		GameRegistry.registerTileEntity(TileEnittyUniversalShelf.class, new ResourceLocation(References.MODID, "te_universal_shelf"));
		GameRegistry.registerTileEntity(TileEntityChoppingBlock.class, new ResourceLocation(References.MODID, "te_chopping_block"));

		GameRegistry.registerTileEntity(TileEntityClockCore.class, new ResourceLocation(References.MODID, "te_clock_core"));
		GameRegistry.registerTileEntity(TileEntityShopSign.class, new ResourceLocation(References.MODID,"te_shop_sign"));

		//Old Storage
		GameRegistry.registerTileEntity(TileEntityCrate.class, new ResourceLocation(References.MODID, "TilEntityCrate"));
		GameRegistry.registerTileEntity(TileEntitySimpleChest.class, new ResourceLocation(References.MODID, "TileEntityDungeonChest"));

		//New Test Things
		GameRegistry.registerTileEntity(TileEntityFlowerContainer.class, new ResourceLocation(References.MODID, "flower_container"));
	}

}