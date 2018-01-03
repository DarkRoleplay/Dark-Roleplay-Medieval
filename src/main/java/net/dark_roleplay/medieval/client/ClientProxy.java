package net.dark_roleplay.medieval.client;

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
import net.dark_roleplay.medieval.client.blocks.tesrs.shop_sign.TESR_ShopSign;
import net.dark_roleplay.medieval.client.entities.fox.Render_Fox;
import net.dark_roleplay.medieval.client.events.Event_CameraUpdate;
import net.dark_roleplay.medieval.client.model_baking.DelayedBaker_FlowerPot;
import net.dark_roleplay.medieval.client.model_baking.DelayedBaker_HangingBridge;
import net.dark_roleplay.medieval.client.model_baking.DelayedBaker_RopeFence;
import net.dark_roleplay.medieval.client.model_baking.MultiLayerModelLoader;
import net.dark_roleplay.medieval.client.model_baking.advanced.CustomBlockstateLoader;
import net.dark_roleplay.medieval.common.CommonProxy;
import net.dark_roleplay.medieval.common.blocks.decorative.clocks.TE_ClockCore;
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
import net.dark_roleplay.medieval.common.entities.fox.Entity_Fox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	
	public static int telescopeLevel = 0;
	
	@Override
	public void init(FMLPreInitializationEvent event) {
		//ModelLoaderRegistry.registerLoader(new DelayedBakedModel());
		ModelLoaderRegistry.registerLoader(new DelayedBaker_HangingBridge());
		ModelLoaderRegistry.registerLoader(new DelayedBaker_RopeFence());
		ModelLoaderRegistry.registerLoader(new DelayedBaker_FlowerPot());
		ModelLoaderRegistry.registerLoader(new CustomBlockstateLoader());
		ModelLoaderRegistry.registerLoader(new MultiLayerModelLoader());

		RenderingRegistry.registerEntityRenderingHandler(Entity_Fox.class, Render_Fox.FACTORY);
        		
		this.registerRenders();	
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		IResourceManager manager = Minecraft.getMinecraft().getResourceManager();
		if(manager instanceof IReloadableResourceManager) {
//		    ((IReloadableResourceManager)manager).registerReloadListener(new RecipeFromJSON());
		}
		MinecraftForge.EVENT_BUS.register(new Event_CameraUpdate());
	}

	@Override
	public void init(FMLPostInitializationEvent event) {}


	public void registerRenders() {				
		ClientRegistry.bindTileEntitySpecialRenderer(TE_ClockCore.class, new TESR_ClockCore());
		ClientRegistry.bindTileEntitySpecialRenderer(TE_ShopSign.class, new TESR_ShopSign());
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
}
