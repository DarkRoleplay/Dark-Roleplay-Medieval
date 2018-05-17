package net.dark_roleplay.medieval.client;

import java.io.File;

import com.google.common.collect.ImmutableMap;

import net.dark_roleplay.medieval.client.blocks.colors.DryClayGrassColor;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderAnvil;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderCauldron;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderChain;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderFirepit;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderGrindstone;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderHangingCauldron;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderHook;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderKeyHanging;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderMortar;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderRopeAnchor;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderShipsWheel;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderTarget;
import net.dark_roleplay.medieval.client.blocks.tesrs.clock.TESR_ClockCore;
import net.dark_roleplay.medieval.client.blocks.tesrs.roof.TESR_Roof;
import net.dark_roleplay.medieval.client.blocks.tesrs.shelf.TESR_Shelf;
import net.dark_roleplay.medieval.client.blocks.tesrs.shop_sign.TESR_ShopSign;
import net.dark_roleplay.medieval.client.entities.fox.Render_Fox;
import net.dark_roleplay.medieval.client.events.Event_CameraUpdate;
import net.dark_roleplay.medieval.client.model_baking.DelayedBaker_DirtBucket;
import net.dark_roleplay.medieval.client.model_baking.DelayedBaker_HangingBridge;
import net.dark_roleplay.medieval.client.model_baking.DelayedBaker_RopeFence;
import net.dark_roleplay.medieval.client.model_baking.DelayedBaker_Timbering;
import net.dark_roleplay.medieval.client.model_baking.MultiLayerModelLoader;
import net.dark_roleplay.medieval.client.model_baking.advanced.CustomBlockstateLoader;
import net.dark_roleplay.medieval.common.CommonProxy;
import net.dark_roleplay.medieval.common.blocks.decorative.clocks.TE_ClockCore;
import net.dark_roleplay.medieval.common.blocks.storage.DungeonChest;
import net.dark_roleplay.medieval.common.blocks.storage.barrels.TESR_FluidBarrel;
import net.dark_roleplay.medieval.common.blocks.storage.barrels.TE_FluidBarrel;
import net.dark_roleplay.medieval.common.blocks.storage.shelf.TE_Shelf;
import net.dark_roleplay.medieval.common.blocks.tileentities.roof.TE_Roof;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TE_DungeonChest;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityAnvil;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityCauldron;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityChain;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityFirepit;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityGrindstone;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityHangingCauldron;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityHook;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityKeyHanging;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityMortar;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityRopeAnchor;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityShipsWheel;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityTarget;
import net.dark_roleplay.medieval.common.blocks.util.shop_sign.TE_ShopSign;
import net.dark_roleplay.medieval.common.entities.Wheelbarrel;
import net.dark_roleplay.medieval.common.entities.WheelbarrelRenderer;
import net.dark_roleplay.medieval.common.entities.fox.Entity_Fox;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.client.model.animation.AnimationTESR;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.animation.Event;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	
	public static int telescopeLevel = 0;
	
	public ClientProxy(){
		File resourcesFolder = new File(Minecraft.getMinecraft().mcDataDir.getPath() + "/dark roleplay/argh/assets/drpmedieval");
		resourcesFolder.mkdirs();
	}
	
	@Override
	public void init(FMLPreInitializationEvent event) {
		//ModelLoaderRegistry.registerLoader(new DelayedBakedModel());
		ModelLoaderRegistry.registerLoader(new DelayedBaker_HangingBridge());
		ModelLoaderRegistry.registerLoader(new DelayedBaker_RopeFence());
//		ModelLoaderRegistry.registerLoader(new DelayedBaker_FlowerPot());
		ModelLoaderRegistry.registerLoader(new CustomBlockstateLoader());
		ModelLoaderRegistry.registerLoader(new DelayedBaker_DirtBucket());		
		ModelLoaderRegistry.registerLoader(new DelayedBaker_Timbering());
		ModelLoaderRegistry.registerLoader(new MultiLayerModelLoader());
		
		RenderingRegistry.<Entity_Fox>registerEntityRenderingHandler(Entity_Fox.class, Render_Fox.FACTORY);
		RenderingRegistry.<Wheelbarrel>registerEntityRenderingHandler(Wheelbarrel.class, WheelbarrelRenderer.FACTORY);

		this.registerRenders();	
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		IResourceManager manager = Minecraft.getMinecraft().getResourceManager();
		if(manager instanceof IReloadableResourceManager) {
//		    ((IReloadableResourceManager)manager).registerReloadListener(new RecipeFromJSON());
		}
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new DryClayGrassColor(), DRPMedievalBlocks.DRY_CLAY_GRASS);

		
		MinecraftForge.EVENT_BUS.register(new Event_CameraUpdate());
	}

	@Override
	public void init(FMLPostInitializationEvent event) {}


	public void registerRenders() {				
		ClientRegistry.bindTileEntitySpecialRenderer(TE_Roof.class, new TESR_Roof());
		ClientRegistry.bindTileEntitySpecialRenderer(TE_ClockCore.class, new TESR_ClockCore());
		ClientRegistry.bindTileEntitySpecialRenderer(TE_ShopSign.class, new TESR_ShopSign());
		ClientRegistry.bindTileEntitySpecialRenderer(TE_Shelf.class, new TESR_Shelf(Minecraft.getMinecraft().getRenderItem()));
		ClientRegistry.bindTileEntitySpecialRenderer(TE_FluidBarrel.class, new TESR_FluidBarrel());

		ClientRegistry.bindTileEntitySpecialRenderer(TE_DungeonChest.class, new AnimationTESR<TE_DungeonChest>(){
			@Override
		    public void renderTileEntityFast(TE_DungeonChest te, double x, double y, double z, float partialTick, int breakStage, float partial, BufferBuilder renderer){
//				
//				if(te.asm.currentState().equals("closed") || te.asm.currentState().equals("open")) {
					te.clickTime.setValue(Animation.getWorldTime(te.getWorld()));
//				}
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
	}
	
	public IAnimationStateMachine load(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters){
        return ModelLoaderRegistry.loadASM(location, parameters);
    }
}
