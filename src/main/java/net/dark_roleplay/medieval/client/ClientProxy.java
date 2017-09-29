package net.dark_roleplay.medieval.client;

import java.rmi.registry.Registry;
import java.util.ArrayList;

import net.dark_roleplay.drpcore.api.items.DRPItem;
import net.dark_roleplay.drpcore.api.items.ItemApi;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderAnvil;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderBookOne;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderCauldron;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderChain;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderCrate;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderDungeonChest;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderFirepit;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderGrindstone;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderHangingCauldron;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderHook;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderKeyHanging;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderMortar;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderRopeAnchor;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderShipsWheel;
import net.dark_roleplay.medieval.client.blocks.tesrs.SpecialRenderTarget;
import net.dark_roleplay.medieval.client.blocks.tesrs.shop_sign.TESR_ShopSign;
import net.dark_roleplay.medieval.client.entities.RenderEntityRopedArrow;
import net.dark_roleplay.medieval.client.entities.RenderEntitySledge;
import net.dark_roleplay.medieval.client.entities.fox.Render_Fox;
import net.dark_roleplay.medieval.client.events.Event_CameraUpdate;
import net.dark_roleplay.medieval.client.model_baking.DelayedBaker_FlowerPot;
import net.dark_roleplay.medieval.client.model_baking.DelayedBaker_HangingBridge;
import net.dark_roleplay.medieval.client.model_baking.DelayedBaker_RopeFence;
import net.dark_roleplay.medieval.client.model_baking.advanced.CustomBlockstateLoader;
import net.dark_roleplay.medieval.common.CommonProxy;
import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityAnvil;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityBookOne;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityCauldron;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityChain;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityCrate;
import net.dark_roleplay.medieval.common.blocks.tileentitys.TileEntityDungeonChest;
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
import net.dark_roleplay.medieval.common.entities.entity.item.EntitySledge;
import net.dark_roleplay.medieval.common.entities.entity.projectile.EntityRopedArrow;
import net.dark_roleplay.medieval.common.entities.fox.Entity_Fox;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {
	
	
	public static int telescopeLevel = 0;
	
	@Override
	public void init(FMLPreInitializationEvent event) {
		
		//ModelLoaderRegistry.registerLoader(new DelayedBakedModel());
		ModelLoaderRegistry.registerLoader(new DelayedBaker_HangingBridge());
		ModelLoaderRegistry.registerLoader(new DelayedBaker_RopeFence());
		ModelLoaderRegistry.registerLoader(new DelayedBaker_FlowerPot());
		ModelLoaderRegistry.registerLoader(new CustomBlockstateLoader());
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySledge.class, RenderEntitySledge.FACTORY);
        RenderingRegistry.registerEntityRenderingHandler(EntityRopedArrow.class, RenderEntityRopedArrow.FACTORY);

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
		ClientRegistry.bindTileEntitySpecialRenderer(TE_ShopSign.class, new TESR_ShopSign());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, new SpecialRenderAnvil());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMortar.class, new SpecialRenderMortar());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrindstone.class, new SpecialRenderGrindstone());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHangingCauldron.class, new SpecialRenderHangingCauldron());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBookOne.class, new SpecialRenderBookOne());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCauldron.class, new SpecialRenderCauldron());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChain.class, new SpecialRenderChain());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrate.class, new SpecialRenderCrate());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDungeonChest.class, new SpecialRenderDungeonChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHook.class, new SpecialRenderHook());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKeyHanging.class, new SpecialRenderKeyHanging());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityShipsWheel.class, new SpecialRenderShipsWheel());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTarget.class, new SpecialRenderTarget());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRopeAnchor.class, new SpecialRenderRopeAnchor());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFirepit.class, new SpecialRenderFirepit());	
	}
}
