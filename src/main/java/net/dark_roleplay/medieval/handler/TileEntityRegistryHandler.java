package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.objects.blocks.decoration.chairs.SolidChairTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = DarkRoleplayMedieval.MODID, bus = Bus.MOD)
public class TileEntityRegistryHandler {
	
	private static IForgeRegistry<TileEntityType<?>> registry = null;
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<TileEntityType<?> > registryEvent) {
		registry = registryEvent.getRegistry();
		
		reg(TileEntityType.Builder.create(SolidChairTileEntity::new).build(null), "solid_chair_armrest");
	}
	
	protected static void reg(TileEntityType<? extends TileEntity> tileEntity, String registryName) {
		tileEntity.setRegistryName(new ResourceLocation(DarkRoleplayMedieval.MODID, registryName));
		registry.register(tileEntity);
	}
//		GameRegistry.registerTileEntity(TileEntityRoof.class, new ResourceLocation(References.MODID, "roof"));
//		GameRegistry.registerTileEntity(DynamicStorageTileEntity.class, new ResourceLocation(References.MODID, "te_dynamic_storage"));
//		GameRegistry.registerTileEntity(TileEntityHoneyCentrifuge.class, new ResourceLocation(References.MODID, "honey_centrifuge"));
//
//
//		//TODO Look trough this
//		//TODO Finally make new models!
//		GameRegistry.registerTileEntity(TileEntityAnvil.class, new ResourceLocation(References.MODID, "TileEntityAnvil"));
//		GameRegistry.registerTileEntity(TileEntityGrindstone.class, new ResourceLocation(References.MODID, "TileEntityGrindstone"));
//		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, new ResourceLocation(References.MODID, "TileEntityHangingCauldron"));
//		GameRegistry.registerTileEntity(TileEntityBookOne.class, new ResourceLocation(References.MODID, "TileEntityBookOne"));
//		GameRegistry.registerTileEntity(TileEntityCauldron.class, new ResourceLocation(References.MODID, "TileEntityCauldron"));
//		GameRegistry.registerTileEntity(TileEntityChain.class, new ResourceLocation(References.MODID, "TileEntityChain"));
//		GameRegistry.registerTileEntity(TileEntityHook.class, new ResourceLocation(References.MODID, "TileEntityHook"));
//		GameRegistry.registerTileEntity(TileEntityKeyHanging.class, new ResourceLocation(References.MODID, "TileEntityKeyHanging"));
//		GameRegistry.registerTileEntity(TileEntityTarget.class, new ResourceLocation(References.MODID, "TileEntityTarget"));
//		GameRegistry.registerTileEntity(TileEntityRopeAnchor.class, new ResourceLocation(References.MODID, "TileEntityRopeAnchor"));
//		GameRegistry.registerTileEntity(TileEntityFirepit.class, new ResourceLocation(References.MODID, "TileEntityFirepit"));
//
//		//New Storage
//		GameRegistry.registerTileEntity(TileEntityFluidBarrel.class, new ResourceLocation(References.MODID, "tile_entity_fluid_barrel"));
//		GameRegistry.registerTileEntity(TileEntityShelf.class, new ResourceLocation(References.MODID, "te_shelf"));
//		GameRegistry.registerTileEntity(TileEnittyUniversalShelf.class, new ResourceLocation(References.MODID, "te_universal_shelf"));
//		GameRegistry.registerTileEntity(TileEntityChoppingBlock.class, new ResourceLocation(References.MODID, "te_chopping_block"));
//
//		GameRegistry.registerTileEntity(TileEntityClockCore.class, new ResourceLocation(References.MODID, "te_clock_core"));
//		GameRegistry.registerTileEntity(TileEntityShopSign.class, new ResourceLocation(References.MODID,"te_shop_sign"));
//
//		//Old Storage
//		GameRegistry.registerTileEntity(TileEntityCrate.class, new ResourceLocation(References.MODID, "TilEntityCrate"));
//		GameRegistry.registerTileEntity(TileEntitySimpleChest.class, new ResourceLocation(References.MODID, "TileEntityDungeonChest"));
//
//		//New Test Things
//		GameRegistry.registerTileEntity(TileEntityFlowerContainer.class, new ResourceLocation(References.MODID, "flower_container"));
}