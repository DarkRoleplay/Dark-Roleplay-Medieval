package net.dark_roleplay.medieval;

import net.dark_roleplay.medieval.holders.MedievalConfigs;
import net.dark_roleplay.medieval.holders.MedievalGuis;
import net.dark_roleplay.medieval.minigame.MinigameHandler;
import net.dark_roleplay.medieval.temporary.model_quality.ModelQualityModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DarkRoleplayMedieval.MODID)
public class DarkRoleplayMedieval {

	public static final String MODID = "drpmedieval";

	public DarkRoleplayMedieval() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MedievalConfigs.WORLD_GENS_SPEC, "World Generation.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MedievalConfigs.Misc.REGENERATING_ORES_SPEC, "Regenerating Ores.toml");
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommonStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupServerStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClientStuff);
        
        FMLJavaModLoadingContext.get().getModEventBus().addListener(MinigameHandler::setupCommonStuff);
        
//        MaterialType woodType = new MaterialType("wood");
//		String[] woods = {"acacia", "birch", "dark_oak", "jungle", "oak", "spruce"};
//		
//		for(String wood : woods) {
//			Material mat = new Material(woodType, wood, String.format("drpmaarg.material.%s", wood));
//			mat.setTexture("log_side", new ResourceLocation("minecraft", String.format("textures/block/%s_log.png", wood)));
//			mat.setTexture("log_top", new ResourceLocation("minecraft", String.format("textures/block/%s_log_top.png", wood)));
//			mat.setTexture("stripped_log_side", new ResourceLocation("minecraft", String.format("textures/block/stripped_%s_log.png", wood)));
//			mat.setTexture("stripped_log_top", new ResourceLocation("minecraft", String.format("textures/block/stripped_%s_log_top.png", wood)));
//			mat.setTexture("planks", new ResourceLocation("minecraft", String.format("textures/block/%s_planks.png", wood)));
//			
//			MaterialRegistry.register(mat);
//		}
        
	}
	
	
	public void setupCommonStuff(FMLCommonSetupEvent event) {
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> MedievalGuis::openGui);
	}
	
	public void setupServerStuff(FMLDedicatedServerSetupEvent event) {
		
	}
	
	public void setupClientStuff(FMLClientSetupEvent event) {
		ModelLoaderRegistry.registerLoader(ModelQualityModelLoader.INSTANCE);
	}

//	@EventHandler
//	public static void init(FMLInitializationEvent event) {
//		//TODO Port to data driven crafting system
//		ChoppingBlockActivation.firewoodRecipes = new HashMap<ItemStack, ItemStack>();
//
//		VillagerRegistryHandler.init(event);
//		MissingMappingRegistryHandler.init(event);
//		PacketRegistryHandler.init();
//		proxy.init(event);
//
//		((UnlitWallMount)MedievalBlocks.CANDLE_HOLDER_UNLIT).init(MedievalBlocks.CANDLE_HOLDER_LIT, Item.getItemFromBlock(MedievalBlocks.BEESWAX_CANDLE));;
//		((LitWallMount)MedievalBlocks.CANDLE_HOLDER_LIT).init(MedievalBlocks.CANDLE_HOLDER_UNLIT, Item.getItemFromBlock(MedievalBlocks.BEESWAX_CANDLE));
//		((UnlitWallMount)MedievalBlocks.TORCH_HOLDER_UNLIT).init(MedievalBlocks.TORCH_HOLDER_LIT, Item.getItemFromBlock(Blocks.TORCH));
//		((LitWallMount)MedievalBlocks.TORCH_HOLDER_LIT).init(MedievalBlocks.TORCH_HOLDER_UNLIT, Item.getItemFromBlock(Blocks.TORCH));
//		((EmptyWallMount)MedievalBlocks.CANDLE_HOLDER_EMPTY).init(MedievalBlocks.CANDLE_HOLDER_UNLIT, Item.getItemFromBlock(MedievalBlocks.BEESWAX_CANDLE));
//		((EmptyWallMount)MedievalBlocks.TORCH_HOLDER_EMPTY).init(MedievalBlocks.TORCH_HOLDER_UNLIT, Item.getItemFromBlock(Blocks.TORCH));
//
//		((AdvancedOre)MedievalBlocks.SALPETER_ORE).init(MedievalItems.SALPETER_ORE_CHUNK);
//		((AdvancedOre)MedievalBlocks.SILVER_ORE).init(MedievalItems.SILVER_ORE_CHUNK);
//		((AdvancedOre)MedievalBlocks.TIN_ORE).init(MedievalItems.TIN_ORE_CHUNK);
//		((AdvancedOre)MedievalBlocks.COPPER_ORE).init(MedievalItems.COPPER_ORE_CHUNK);
//		((AdvancedOre)MedievalBlocks.SULFUR_ORE).init(MedievalItems.SULFUR_ORE_CHUNK);
//
//		((RegeneratingOre)MedievalBlocks.REGENERATING_EMERALD_ORE).setOre(Blocks.EMERALD_ORE);
//		((RegeneratingOre)MedievalBlocks.REGENERATING_DIAMOND_ORE).setOre(Blocks.DIAMOND_ORE);
//		((RegeneratingOre)MedievalBlocks.REGENERATING_LAPIS_ORE).setOre(Blocks.LAPIS_ORE);
//		((RegeneratingOre)MedievalBlocks.REGENERATING_REDSTONE_ORE).setOre(Blocks.REDSTONE_ORE);
//		((RegeneratingOre)MedievalBlocks.REGENERATING_GOLD_ORE).setOre(Blocks.GOLD_ORE);
//		((RegeneratingOre)MedievalBlocks.REGENERATING_IRON_ORE).setOre(Blocks.IRON_ORE);
//		((RegeneratingOre)MedievalBlocks.REGENERATING_COAL_ORE).setOre(Blocks.COAL_ORE);
//		((RegeneratingOre)MedievalBlocks.REGENERATING_QUARTZ_ORE).setOre(Blocks.QUARTZ_ORE);
//
//		GameRegistry.addSmelting(MedievalItems.WHEAT_DOUGH, new ItemStack(Items.BREAD), 0.1f);
//		GameRegistry.addSmelting(MedievalItems.BARLEY_DOUGH, new ItemStack(Items.BREAD), 0.1f);
//		GameRegistry.addSmelting(MedievalItems.RAW_WOLF, new ItemStack(MedievalItems.COOKED_WOLF), 0.1f);
//		GameRegistry.addSmelting(MedievalItems.RAW_CATFISH, new ItemStack(MedievalItems.COOKED_CATFISH), 0.1f);
//		GameRegistry.addSmelting(MedievalItems.WHEAT_PUMPKIN_DOUGH, new ItemStack(MedievalItems.PUMPKIN_BREAD), 0.1f);
//		GameRegistry.addSmelting(MedievalItems.BARLEY_PUMPKIN_DOUGH, new ItemStack(MedievalItems.PUMPKIN_BREAD), 0.1f);
//		GameRegistry.addSmelting(Item.getItemFromBlock(Blocks.OBSIDIAN), new ItemStack(MedievalBlocks.OBSIDIAN_GLASS), 0.1f);
//		GameRegistry.addSmelting(Item.getItemFromBlock(MedievalBlocks.UNFIRED_VASE), new ItemStack(MedievalBlocks.FIRED_VASE), 0.1f);
//	}

//	public static class ClientProxy{
//
//		public static int TELESCOPE_LEVEL = 0;
//
//		//Searching for a fast way to fix the multiple mods bug
//		//Comming close!
//
//		@Override
//		public void preInit(FMLPreInitializationEvent event) {
//			ModelLoaderRegistry.registerLoader(new ModelLoaderHangingBridge());
//			ModelLoaderRegistry.registerLoader(new ModelLoaderRopeFence());
//			ModelLoaderRegistry.registerLoader(new CustomBlockstateLoader());
//			ModelLoaderRegistry.registerLoader(new ModelLoaderTimberedClay());
//
////			RenderingRegistry.<Entity_Fox>registerEntityRenderingHandler(Entity_Fox.class, Render_Fox.FACTORY);
////			RenderingRegistry.<Wheelbarrel>registerEntityRenderingHandler(Wheelbarrel.class, WheelbarrelRenderer.FACTORY);
//			ClientRegistry.bindTileEntityRenderer(TileEntityRoof.class, new SpecialRendererRoof());
//			ClientRegistry.bindTileEntityRenderer(TileEntityClockCore.class, new SpecialRendererClockCore());
//			ClientRegistry.bindTileEntityRenderer(TileEntityShopSign.class, new SpecialRendererShopSign());
//			ClientRegistry.bindTileEntityRenderer(TileEntityShelf.class, new SpecialRendererShelf(Minecraft.getInstance().getRenderItem()));
//			ClientRegistry.bindTileEntityRenderer(TileEnittyUniversalShelf.class, new SpecialRendererWallShelf(Minecraft.getInstance().getRenderItem()));
//			ClientRegistry.bindTileEntityRenderer(TileEntityFluidBarrel.class, new SpecialRendererFluidBarrel());
//			ClientRegistry.bindTileEntityRenderer(TileEntityFlowerContainer.class, new SpecialRendererFlowerContainer());
//			ClientRegistry.bindTileEntityRenderer(TE_Banner.class, new TESR_Banner());
//
//			ClientRegistry.bindTileEntityRenderer(TE_BuildingScanner.class, new TESR_BuildingScanner());
//
//
//			ClientRegistry.bindTileEntityRenderer(TileEntitySimpleChest.class, new AnimationTESR<TileEntitySimpleChest>(){
//				@Override
//			    public void renderTileEntityFast(TileEntitySimpleChest te, double x, double y, double z, float partialTick, int breakStage, float partial, BufferBuilder renderer) {
//					super.renderTileEntityFast(te, x, y, z, partialTick, breakStage, partial, renderer);
//				}
//
//				@Override
//				public void handleEvents(TileEntitySimpleChest chest, float time, Iterable<Event> pastEvents){
//					chest.handleEvents(time, pastEvents);
//				}
//			});
//			ClientRegistry.bindTileEntityRenderer(TileEntityHoneyCentrifuge.class, new SpecialRendererHoneyCentrifuge());
//			ClientRegistry.bindTileEntityRenderer(TileEntityGrindstone.class, new SpecialRenderGrindstone());
//
//
//			ClientRegistry.bindTileEntityRenderer(TileEntityAnvil.class, new SpecialRenderAnvil());
//			ClientRegistry.bindTileEntityRenderer(TileEntityHangingCauldron.class, new SpecialRenderHangingCauldron());
//			ClientRegistry.bindTileEntityRenderer(TileEntityCauldron.class, new SpecialRenderCauldron());
//			ClientRegistry.bindTileEntityRenderer(TileEntityChain.class, new SpecialRenderChain());
//			ClientRegistry.bindTileEntityRenderer(TileEntityHook.class, new SpecialRenderHook());
//			ClientRegistry.bindTileEntityRenderer(TileEntityKeyHanging.class, new SpecialRenderKeyHanging());
//			ClientRegistry.bindTileEntityRenderer(TileEntityTarget.class, new SpecialRenderTarget());
//			ClientRegistry.bindTileEntityRenderer(TileEntityRopeAnchor.class, new SpecialRenderRopeAnchor());
//			ClientRegistry.bindTileEntityRenderer(TileEntityFirepit.class, new SpecialRenderFirepit());
//
//			ClientRegistry.registerKeyBinding(Keybinds.debugging);
//		}
//
//		@Override
//		public void init(FMLInitializationEvent event) {
//			Minecraft.getInstance().getResourceManager();
//			ColorHandlerDryClayGrass color = new ColorHandlerDryClayGrass();
//			Minecraft.getInstance().getBlockColors().register(color, MedievalBlocks.DRY_CLAY_GRASS);
//			Minecraft.getInstance().getItemColors().register((IItemColor) (stack, tintIndex) -> {
//			    IBlockState iblockstate = ((ItemBlock)stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
//			    return color.colorMultiplier(iblockstate, (IBlockAccess)null, (BlockPos)null, tintIndex);
//			}, MedievalBlocks.DRY_CLAY_GRASS);
//			Minecraft.getInstance().getItemColors().register(new ColorHandlerPaintBrush(), MedievalItems.DIRTY_PAINTBRUSH);
//
//			Minecraft.getInstance().getBlockColors().register(new ColorHandlerRoofs(),
////				MedievalBlocks.WHITE_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.ORANGE_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.MAGENTA_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.LIGHT_BLUE_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.YELLOW_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.LIGHT_GREEN_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.PINK_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.GRAY_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.LIGHT_GRAY_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.CYAN_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.PURPLE_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.BLUE_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.BROWN_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.GREEN_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.RED_CLAY_SHINGLE_ROOF,
//				MedievalBlocks.Roofs.BLACK_CLAY_SHINGLE_ROOF
//			);
//
//			Minecraft.getInstance().getItemColors().register(new ColorHandlerRoofItems(),
////					MedievalBlocks.WHITE_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.ORANGE_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.MAGENTA_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.LIGHT_BLUE_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.YELLOW_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.LIGHT_GREEN_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.PINK_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.GRAY_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.LIGHT_GRAY_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.CYAN_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.PURPLE_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.BLUE_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.BROWN_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.GREEN_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.RED_CLAY_SHINGLE_ROOF,
//					MedievalBlocks.Roofs.BLACK_CLAY_SHINGLE_ROOF
//				);
//		}
//
//		@Override
//		public IAnimationStateMachine load(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters){
//	        return ModelLoaderRegistry.loadASM(location, parameters);
//	    }
//	}
}
