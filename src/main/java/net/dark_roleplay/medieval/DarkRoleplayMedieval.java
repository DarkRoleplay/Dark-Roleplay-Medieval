package net.dark_roleplay.medieval;

import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

import net.dark_roleplay.library.sides.IProxy;
import net.dark_roleplay.medieval.handler.MissingMappingRegistryHandler;
import net.dark_roleplay.medieval.handler.PacketRegistryHandler;
import net.dark_roleplay.medieval.handler.VillagerRegistryHandler;
import net.dark_roleplay.medieval.handler.WorldGenRegistryHandler;
import net.dark_roleplay.medieval.holders.MedievalBlocks;
import net.dark_roleplay.medieval.holders.MedievalGuis;
import net.dark_roleplay.medieval.holders.MedievalItems;
import net.dark_roleplay.medieval.objects.blocks.building.advanced_ore.AdvancedOre;
import net.dark_roleplay.medieval.objects.blocks.building.dry_clay.ColorHandlerDryClayGrass;
import net.dark_roleplay.medieval.objects.blocks.building.dry_clay.ModelLoaderHangingBridge;
import net.dark_roleplay.medieval.objects.blocks.building.roofs.ColorHandlerRoofs;
import net.dark_roleplay.medieval.objects.blocks.building.roofs.SpecialRendererRoof;
import net.dark_roleplay.medieval.objects.blocks.building.roofs.TileEntityRoof;
import net.dark_roleplay.medieval.objects.blocks.building.timbered_clay.ModelLoaderTimberedClay;
import net.dark_roleplay.medieval.objects.blocks.decoration.barrels.SpecialRendererFluidBarrel;
import net.dark_roleplay.medieval.objects.blocks.decoration.barrels.TileEntityFluidBarrel;
import net.dark_roleplay.medieval.objects.blocks.decoration.flower_container.SpecialRendererFlowerContainer;
import net.dark_roleplay.medieval.objects.blocks.decoration.flower_container.TileEntityFlowerContainer;
import net.dark_roleplay.medieval.objects.blocks.decoration.rope_fence.ModelLoaderRopeFence;
import net.dark_roleplay.medieval.objects.blocks.decoration.shop_signs.SpecialRendererShopSign;
import net.dark_roleplay.medieval.objects.blocks.decoration.shop_signs.TileEntityShopSign;
import net.dark_roleplay.medieval.objects.blocks.decoration.wall_mounted.EmptyWallMount;
import net.dark_roleplay.medieval.objects.blocks.decoration.wall_mounted.LitWallMount;
import net.dark_roleplay.medieval.objects.blocks.decoration.wall_mounted.UnlitWallMount;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderAnvil;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderCauldron;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderChain;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderFirepit;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderGrindstone;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderHangingCauldron;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderHook;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderKeyHanging;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderMortar;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderRopeAnchor;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderShipsWheel;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.SpecialRenderTarget;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityAnvil;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityCauldron;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityChain;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityFirepit;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityGrindstone;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityHangingCauldron;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityHook;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityKeyHanging;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityMortar;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityRopeAnchor;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityShipsWheel;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityTarget;
import net.dark_roleplay.medieval.objects.blocks.utility.crafting.chopping_block.behaviors.ChoppingBlockActivation;
import net.dark_roleplay.medieval.objects.blocks.utility.crafting.honey_centrifuge.TileEntityHoneyCentrifuge;
import net.dark_roleplay.medieval.objects.blocks.utility.other.clock_core.SpecialRendererClockCore;
import net.dark_roleplay.medieval.objects.blocks.utility.other.clock_core.TileEntityClockCore;
import net.dark_roleplay.medieval.objects.blocks.utility.other.regenerating_ore.RegeneratingOre;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.chests.simple_chest.SpecialRendererHoneyCentrifuge;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.chests.simple_chest.TileEntitySimpleChest;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.shelfs.SpecialRendererShelf;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.shelfs.SpecialRendererWallShelf;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.shelfs.TileEnittyUniversalShelf;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.shelfs.TileEntityShelf;
import net.dark_roleplay.medieval.objects.items.blocks.roofs.ColorHandlerRoofItems;
import net.dark_roleplay.medieval.objects.items.consumables.tools.paint_brush.ColorHandlerPaintBrush;
import net.dark_roleplay.medieval.testing.Keybinds;
import net.dark_roleplay.medieval.testing.blocks.TESR_Banner;
import net.dark_roleplay.medieval.testing.blocks.TE_Banner;
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
		WorldGenRegistryHandler.init(event);
		NetworkRegistry.INSTANCE.registerGuiHandler(DarkRoleplayMedieval.INSTANCE, new MedievalGuis());
		proxy.preInit(event);
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		//TODO Port to data driven crafting system
		ChoppingBlockActivation.firewoodRecipes = new HashMap<ItemStack, ItemStack>();


		VillagerRegistryHandler.init(event);
		MissingMappingRegistryHandler.init(event);
		PacketRegistryHandler.init();
		proxy.init(event);

		((UnlitWallMount)MedievalBlocks.CANDLE_HOLDER_UNLIT).init(MedievalBlocks.CANDLE_HOLDER_LIT, Item.getItemFromBlock(MedievalBlocks.BEESWAX_CANDLE));;
		((LitWallMount)MedievalBlocks.CANDLE_HOLDER_LIT).init(MedievalBlocks.CANDLE_HOLDER_UNLIT, Item.getItemFromBlock(MedievalBlocks.BEESWAX_CANDLE));
		((UnlitWallMount)MedievalBlocks.TORCH_HOLDER_UNLIT).init(MedievalBlocks.TORCH_HOLDER_LIT, Item.getItemFromBlock(Blocks.TORCH));
		((LitWallMount)MedievalBlocks.TORCH_HOLDER_LIT).init(MedievalBlocks.TORCH_HOLDER_UNLIT, Item.getItemFromBlock(Blocks.TORCH));
		((EmptyWallMount)MedievalBlocks.CANDLE_HOLDER_EMPTY).init(MedievalBlocks.CANDLE_HOLDER_UNLIT, Item.getItemFromBlock(MedievalBlocks.BEESWAX_CANDLE));
		((EmptyWallMount)MedievalBlocks.TORCH_HOLDER_EMPTY).init(MedievalBlocks.TORCH_HOLDER_UNLIT, Item.getItemFromBlock(Blocks.TORCH));

		((AdvancedOre)MedievalBlocks.SALPETER_ORE).init(MedievalItems.SALPETER_ORE_CHUNK);
		((AdvancedOre)MedievalBlocks.SILVER_ORE).init(MedievalItems.SILVER_ORE_CHUNK);
		((AdvancedOre)MedievalBlocks.TIN_ORE).init(MedievalItems.TIN_ORE_CHUNK);
		((AdvancedOre)MedievalBlocks.COPPER_ORE).init(MedievalItems.COPPER_ORE_CHUNK);
		((AdvancedOre)MedievalBlocks.SULFUR_ORE).init(MedievalItems.SULFUR_ORE_CHUNK);

		((RegeneratingOre)MedievalBlocks.REGENERATING_EMERALD_ORE).setOre(Blocks.EMERALD_ORE);
		((RegeneratingOre)MedievalBlocks.REGENERATING_DIAMOND_ORE).setOre(Blocks.DIAMOND_ORE);
		((RegeneratingOre)MedievalBlocks.REGENERATING_LAPIS_ORE).setOre(Blocks.LAPIS_ORE);
		((RegeneratingOre)MedievalBlocks.REGENERATING_REDSTONE_ORE).setOre(Blocks.REDSTONE_ORE);
		((RegeneratingOre)MedievalBlocks.REGENERATING_GOLD_ORE).setOre(Blocks.GOLD_ORE);
		((RegeneratingOre)MedievalBlocks.REGENERATING_IRON_ORE).setOre(Blocks.IRON_ORE);
		((RegeneratingOre)MedievalBlocks.REGENERATING_COAL_ORE).setOre(Blocks.COAL_ORE);
		((RegeneratingOre)MedievalBlocks.REGENERATING_QUARTZ_ORE).setOre(Blocks.QUARTZ_ORE);

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
			ModelLoaderRegistry.registerLoader(new ModelLoaderHangingBridge());
			ModelLoaderRegistry.registerLoader(new ModelLoaderRopeFence());
			ModelLoaderRegistry.registerLoader(new CustomBlockstateLoader());
			ModelLoaderRegistry.registerLoader(new ModelLoaderTimberedClay());

//			RenderingRegistry.<Entity_Fox>registerEntityRenderingHandler(Entity_Fox.class, Render_Fox.FACTORY);
//			RenderingRegistry.<Wheelbarrel>registerEntityRenderingHandler(Wheelbarrel.class, WheelbarrelRenderer.FACTORY);
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, new SpecialRendererRoof());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityClockCore.class, new SpecialRendererClockCore());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShopSign.class, new SpecialRendererShopSign());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShelf.class, new SpecialRendererShelf(Minecraft.getMinecraft().getRenderItem()));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEnittyUniversalShelf.class, new SpecialRendererWallShelf(Minecraft.getMinecraft().getRenderItem()));
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluidBarrel.class, new SpecialRendererFluidBarrel());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlowerContainer.class, new SpecialRendererFlowerContainer());
			ClientRegistry.bindTileEntitySpecialRenderer(TE_Banner.class, new TESR_Banner());

			ClientRegistry.bindTileEntitySpecialRenderer(TE_BuildingScanner.class, new TESR_BuildingScanner());


			ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySimpleChest.class, new AnimationTESR<TileEntitySimpleChest>(){
				@Override
			    public void renderTileEntityFast(TileEntitySimpleChest te, double x, double y, double z, float partialTick, int breakStage, float partial, BufferBuilder renderer) {
					super.renderTileEntityFast(te, x, y, z, partialTick, breakStage, partial, renderer);
				}

				@Override
				public void handleEvents(TileEntitySimpleChest chest, float time, Iterable<Event> pastEvents){
					chest.handleEvents(time, pastEvents);
				}
			});
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHoneyCentrifuge.class, new SpecialRendererHoneyCentrifuge());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindstone.class, new SpecialRenderGrindstone());


			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, new SpecialRenderAnvil());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMortar.class, new SpecialRenderMortar());
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
			ColorHandlerDryClayGrass color = new ColorHandlerDryClayGrass();
			Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(color, MedievalBlocks.DRY_CLAY_GRASS);
			Minecraft.getMinecraft().getItemColors().registerItemColorHandler((IItemColor) (stack, tintIndex) -> {
			    IBlockState iblockstate = ((ItemBlock)stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
			    return color.colorMultiplier(iblockstate, (IBlockAccess)null, (BlockPos)null, tintIndex);
			}, MedievalBlocks.DRY_CLAY_GRASS);
			Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ColorHandlerPaintBrush(), MedievalItems.DIRTY_PAINTBRUSH);

			Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new ColorHandlerRoofs(),
//				MedievalBlocks.WHITE_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.ORANGE_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.MAGENTA_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.LIGHT_BLUE_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.YELLOW_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.LIGHT_GREEN_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.PINK_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.GRAY_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.LIGHT_GRAY_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.CYAN_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.PURPLE_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.BLUE_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.BROWN_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.GREEN_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.RED_CLAY_SHINGLE_ROOF,
				MedievalBlocks.Roofs.BLACK_CLAY_SHINGLE_ROOF
			);

			Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ColorHandlerRoofItems(),
//					MedievalBlocks.WHITE_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.ORANGE_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.MAGENTA_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.LIGHT_BLUE_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.YELLOW_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.LIGHT_GREEN_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.PINK_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.GRAY_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.LIGHT_GRAY_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.CYAN_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.PURPLE_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.BLUE_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.BROWN_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.GREEN_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.RED_CLAY_SHINGLE_ROOF,
					MedievalBlocks.Roofs.BLACK_CLAY_SHINGLE_ROOF
				);
		}

		@Override
		public IAnimationStateMachine load(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters){
	        return ModelLoaderRegistry.loadASM(location, parameters);
	    }
	}

	public static class ServerProxy implements IBaseProxy{}
}
