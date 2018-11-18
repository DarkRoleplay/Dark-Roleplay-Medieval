package net.dark_roleplay.medieval;

import com.google.common.collect.ImmutableMap;

import net.dark_roleplay.library.sides.IProxy;
import net.dark_roleplay.medieval.client.objects.blocks.color_handlers.DryClayGrassColor;
import net.dark_roleplay.medieval.client.objects.blocks.color_handlers.SolidColor;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.TESR_Banner;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.TESR_ClockCore;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.TESR_Flowers;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.TESR_FluidBarrel;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.TESR_Roof;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.TESR_Shelf;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.TESR_ShopSign;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderAnvil;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderCauldron;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderChain;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderFirepit;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderGrindstone;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderHangingCauldron;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderHook;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderKeyHanging;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderMortar;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderRopeAnchor;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderShipsWheel;
import net.dark_roleplay.medieval.client.objects.blocks.tesrs.old.SpecialRenderTarget;
import net.dark_roleplay.medieval.client.objects.items.color_handlers.PaintBrushColors;
import net.dark_roleplay.medieval.client.objects.items.color_handlers.RoofItemColor;
import net.dark_roleplay.medieval.client.objects.model_loaders.DelayedBaker_HangingBridge;
import net.dark_roleplay.medieval.client.objects.model_loaders.DelayedBaker_RopeFence;
import net.dark_roleplay.medieval.client.objects.model_loaders.DelayedBaker_Timbering;
import net.dark_roleplay.medieval.client.objects.model_loaders.MultiLayerModelLoader;
import net.dark_roleplay.medieval.common.handler.MedievalBlocks;
import net.dark_roleplay.medieval.common.handler.MedievalGuis;
import net.dark_roleplay.medieval.common.handler.MedievalMappings;
import net.dark_roleplay.medieval.common.handler.MedievalPackets;
import net.dark_roleplay.medieval.common.handler.MedievalVillagers;
import net.dark_roleplay.medieval.common.handler.MedievalWorldGen;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Banner;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ClockCore;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_DungeonChest;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FlowerContainer;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FluidBarrel;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Roof;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Shelf;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ShopSign;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityAnvil;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityCauldron;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityChain;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityFirepit;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityGrindstone;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityHangingCauldron;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityHook;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityKeyHanging;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityMortar;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityRopeAnchor;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityShipsWheel;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityTarget;
import net.dark_roleplay.medieval.holders.MedievalItems;
import net.dark_roleplay.medieval.testing.Keybinds;
import net.dark_roleplay.medieval.testing.blockstate_loading.CustomBlockstateLoader;
import net.dark_roleplay.medieval.testing.building_scanner.TESR_BuildingScanner;
import net.dark_roleplay.medieval.testing.building_scanner.TE_BuildingScanner;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.animation.AnimationTESR;
import net.minecraftforge.common.animation.Event;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = References.MODID, version = References.VERSION, name = References.NAME, acceptedMinecraftVersions = References.ACCEPTEDVERSIONS, dependencies = References.DEPENDECIES, updateJSON = References.UPDATECHECK)
public class DarkRoleplayMedieval {

	@Mod.Instance(References.MODID)
	public static DarkRoleplayMedieval INSTANCE;

	@SidedProxy
	public static IBaseProxy proxy;

	public static Side SIDE;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		SIDE = event.getSide();
		MedievalWorldGen.init(event);
		NetworkRegistry.INSTANCE.registerGuiHandler(DarkRoleplayMedieval.INSTANCE, new MedievalGuis());
		proxy.preInit(event);
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		MedievalVillagers.init(event);
		MedievalMappings.init(event);
		MedievalPackets.init();
		proxy.init(event);
		MedievalMappings.init(event);

		MedievalBlocks.CANDLE_HOLDER_UNLIT.init(MedievalBlocks.CANDLE_HOLDER_LIT, Item.getItemFromBlock(MedievalBlocks.BEESWAX_CANDLE));;
		MedievalBlocks.CANDLE_HOLDER_LIT.init(MedievalBlocks.CANDLE_HOLDER_UNLIT, Item.getItemFromBlock(MedievalBlocks.BEESWAX_CANDLE));
		MedievalBlocks.TORCH_HOLDER_UNLIT.init(MedievalBlocks.TORCH_HOLDER_LIT, Item.getItemFromBlock(Blocks.TORCH));
		MedievalBlocks.TORCH_HOLDER_LIT.init(MedievalBlocks.TORCH_HOLDER_UNLIT, Item.getItemFromBlock(Blocks.TORCH));
		MedievalBlocks.CANDLE_HOLDER_EMPTY.init(MedievalBlocks.CANDLE_HOLDER_UNLIT, Item.getItemFromBlock(MedievalBlocks.BEESWAX_CANDLE));
		MedievalBlocks.TORCH_HOLDER_EMPTY.init(MedievalBlocks.TORCH_HOLDER_UNLIT, Item.getItemFromBlock(Blocks.TORCH));

		MedievalBlocks.SALPETER_ORE.init(MedievalItems.SALPETER_ORE_CHUNK);
		MedievalBlocks.SILVER_ORE.init(MedievalItems.SILVER_ORE_CHUNK);
		MedievalBlocks.TIN_ORE.init(MedievalItems.TIN_ORE_CHUNK);
		MedievalBlocks.COPPER_ORE.init(MedievalItems.COPPER_ORE_CHUNK);
		MedievalBlocks.SULFUR_ORE.init(MedievalItems.SULFUR_ORE_CHUNK);

		GameRegistry.addSmelting(MedievalItems.WHEAT_DOUGH, new ItemStack(Items.BREAD), 0.1f);
		GameRegistry.addSmelting(MedievalItems.BARLEY_DOUGH, new ItemStack(Items.BREAD), 0.1f);
		GameRegistry.addSmelting(MedievalItems.RAW_WOLF, new ItemStack(MedievalItems.COOKED_WOLF), 0.1f);
		GameRegistry.addSmelting(MedievalItems.RAW_CATFISH, new ItemStack(MedievalItems.COOKED_CATFISH), 0.1f);
		GameRegistry.addSmelting(MedievalItems.WHEAT_PUMPKIN_DOUGH, new ItemStack(MedievalItems.PUMPKIN_BREAD), 0.1f);
		GameRegistry.addSmelting(MedievalItems.BARLEY_PUMPKIN_DOUGH, new ItemStack(MedievalItems.PUMPKIN_BREAD), 0.1f);
		GameRegistry.addSmelting(Item.getItemFromBlock(Blocks.OBSIDIAN), new ItemStack(MedievalBlocks.OBSIDIAN_GLASS), 0.1f);
		GameRegistry.addSmelting(Item.getItemFromBlock(MedievalBlocks.UNFIRED_VASE), new ItemStack(MedievalBlocks.FIRED_VASE), 0.1f);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	public static interface IBaseProxy extends IProxy{
		public default IAnimationStateMachine load(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters) {return null;}
	}

	public static class ClientProxy implements IBaseProxy{

		public static int TELESCOPE_LEVEL = 0;

		//Searching for a fast way to fix the multiple mods bug
		//Comming close!

		@Override
		public void preInit(FMLPreInitializationEvent event) {
			ModelLoaderRegistry.registerLoader(new DelayedBaker_HangingBridge());
			ModelLoaderRegistry.registerLoader(new DelayedBaker_RopeFence());
			ModelLoaderRegistry.registerLoader(new CustomBlockstateLoader());
			ModelLoaderRegistry.registerLoader(new DelayedBaker_Timbering());
			ModelLoaderRegistry.registerLoader(new MultiLayerModelLoader());

//			RenderingRegistry.<Entity_Fox>registerEntityRenderingHandler(Entity_Fox.class, Render_Fox.FACTORY);
//			RenderingRegistry.<Wheelbarrel>registerEntityRenderingHandler(Wheelbarrel.class, WheelbarrelRenderer.FACTORY);
			ClientRegistry.bindTileEntitySpecialRenderer(TE_Roof.class, new TESR_Roof());
			ClientRegistry.bindTileEntitySpecialRenderer(TE_ClockCore.class, new TESR_ClockCore());
			ClientRegistry.bindTileEntitySpecialRenderer(TE_ShopSign.class, new TESR_ShopSign());
			ClientRegistry.bindTileEntitySpecialRenderer(TE_Shelf.class, new TESR_Shelf(Minecraft.getMinecraft().getRenderItem()));
			ClientRegistry.bindTileEntitySpecialRenderer(TE_FluidBarrel.class, new TESR_FluidBarrel());
			ClientRegistry.bindTileEntitySpecialRenderer(TE_FlowerContainer.class, new TESR_Flowers());
			ClientRegistry.bindTileEntitySpecialRenderer(TE_Banner.class, new TESR_Banner());

			ClientRegistry.bindTileEntitySpecialRenderer(TE_BuildingScanner.class, new TESR_BuildingScanner());


			ClientRegistry.bindTileEntitySpecialRenderer(TE_DungeonChest.class, new AnimationTESR<TE_DungeonChest>(){
				@Override
			    public void renderTileEntityFast(TE_DungeonChest te, double x, double y, double z, float partialTick, int breakStage, float partial, BufferBuilder renderer) {
					super.renderTileEntityFast(te, x, y, z, partialTick, breakStage, partial, renderer);
				}

				@Override
				public void handleEvents(TE_DungeonChest chest, float time, Iterable<Event> pastEvents){
					chest.handleEvents(time, pastEvents);
				}
			});

			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, new SpecialRenderAnvil());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMortar.class, new SpecialRenderMortar());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindstone.class, new SpecialRenderGrindstone());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHangingCauldron.class, new SpecialRenderHangingCauldron());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCauldron.class, new SpecialRenderCauldron());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChain.class, new SpecialRenderChain());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHook.class, new SpecialRenderHook());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKeyHanging.class, new SpecialRenderKeyHanging());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShipsWheel.class, new SpecialRenderShipsWheel());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTarget.class, new SpecialRenderTarget());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRopeAnchor.class, new SpecialRenderRopeAnchor());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirepit.class, new SpecialRenderFirepit());

			ClientRegistry.registerKeyBinding(Keybinds.debugging);
		}

		@Override
		public void init(FMLInitializationEvent event) {
			Minecraft.getMinecraft().getResourceManager();
			DryClayGrassColor color = new DryClayGrassColor();
			Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(color, MedievalBlocks.DRY_CLAY_GRASS);
			Minecraft.getMinecraft().getItemColors().registerItemColorHandler((IItemColor) (stack, tintIndex) -> {
			    IBlockState iblockstate = ((ItemBlock)stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
			    return color.colorMultiplier(iblockstate, (IBlockAccess)null, (BlockPos)null, tintIndex);
			}, MedievalBlocks.DRY_CLAY_GRASS);
			Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new PaintBrushColors(), MedievalItems.DIRTY_PAINTBRUSH);

			Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new SolidColor(),
//				MedievalBlocks.WHITE_CLAY_SHINGLE_ROOF,
				MedievalBlocks.ORANGE_CLAY_SHINGLE_ROOF,
				MedievalBlocks.MAGENTA_CLAY_SHINGLE_ROOF,
				MedievalBlocks.LIGHT_BLUE_CLAY_SHINGLE_ROOF,
				MedievalBlocks.YELLOW_CLAY_SHINGLE_ROOF,
				MedievalBlocks.LIGHT_GREEN_CLAY_SHINGLE_ROOF,
				MedievalBlocks.PINK_CLAY_SHINGLE_ROOF,
				MedievalBlocks.GRAY_CLAY_SHINGLE_ROOF,
				MedievalBlocks.LIGHT_GRAY_CLAY_SHINGLE_ROOF,
				MedievalBlocks.CYAN_CLAY_SHINGLE_ROOF,
				MedievalBlocks.PURPLE_CLAY_SHINGLE_ROOF,
				MedievalBlocks.BLUE_CLAY_SHINGLE_ROOF,
				MedievalBlocks.BROWN_CLAY_SHINGLE_ROOF,
				MedievalBlocks.GREEN_CLAY_SHINGLE_ROOF,
				MedievalBlocks.RED_CLAY_SHINGLE_ROOF,
				MedievalBlocks.BLACK_CLAY_SHINGLE_ROOF
			);

			Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new RoofItemColor(),
//					MedievalBlocks.WHITE_CLAY_SHINGLE_ROOF,
					MedievalBlocks.ORANGE_CLAY_SHINGLE_ROOF,
					MedievalBlocks.MAGENTA_CLAY_SHINGLE_ROOF,
					MedievalBlocks.LIGHT_BLUE_CLAY_SHINGLE_ROOF,
					MedievalBlocks.YELLOW_CLAY_SHINGLE_ROOF,
					MedievalBlocks.LIGHT_GREEN_CLAY_SHINGLE_ROOF,
					MedievalBlocks.PINK_CLAY_SHINGLE_ROOF,
					MedievalBlocks.GRAY_CLAY_SHINGLE_ROOF,
					MedievalBlocks.LIGHT_GRAY_CLAY_SHINGLE_ROOF,
					MedievalBlocks.CYAN_CLAY_SHINGLE_ROOF,
					MedievalBlocks.PURPLE_CLAY_SHINGLE_ROOF,
					MedievalBlocks.BLUE_CLAY_SHINGLE_ROOF,
					MedievalBlocks.BROWN_CLAY_SHINGLE_ROOF,
					MedievalBlocks.GREEN_CLAY_SHINGLE_ROOF,
					MedievalBlocks.RED_CLAY_SHINGLE_ROOF,
					MedievalBlocks.BLACK_CLAY_SHINGLE_ROOF
				);
		}

		@Override
		public IAnimationStateMachine load(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters){
	        return ModelLoaderRegistry.loadASM(location, parameters);
	    }
	}

	public static class ServerProxy implements IBaseProxy{}
}
