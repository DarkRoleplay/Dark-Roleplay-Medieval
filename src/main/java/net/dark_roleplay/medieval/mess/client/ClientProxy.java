package net.dark_roleplay.medieval.mess.client;

import java.io.File;

import com.google.common.collect.ImmutableMap;

import net.dark_roleplay.medieval.client.objects.blocks.tesrs.TESR_ClockCore;
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
import net.dark_roleplay.medieval.client.objects.entities.renderer.Render_Fox;
import net.dark_roleplay.medieval.client.objects.events.OnCameraUpdate;
import net.dark_roleplay.medieval.common.objects.entities.Entity_Fox;
import net.dark_roleplay.medieval.mess.client.blocks.colors.DryClayGrassColor;
import net.dark_roleplay.medieval.mess.client.blocks.tesrs.roof.TESR_Roof;
import net.dark_roleplay.medieval.mess.client.model_baking.DelayedBaker_HangingBridge;
import net.dark_roleplay.medieval.mess.client.model_baking.DelayedBaker_RopeFence;
import net.dark_roleplay.medieval.mess.client.model_baking.DelayedBaker_Timbering;
import net.dark_roleplay.medieval.mess.client.model_baking.MultiLayerModelLoader;
import net.dark_roleplay.medieval.mess.client.model_baking.advanced.CustomBlockstateLoader;
import net.dark_roleplay.medieval.mess.common.CommonProxy;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.clocks.TE_ClockCore;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.flowers.FlowersTileEntity;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.flowers.TESR_Flowers;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.DungeonChest;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.barrels.TESR_FluidBarrel;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.barrels.TE_FluidBarrel;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.shelf.TE_Shelf;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TE_DungeonChest;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityAnvil;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityCauldron;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityChain;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityFirepit;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityGrindstone;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityHangingCauldron;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityHook;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityKeyHanging;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityMortar;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityRopeAnchor;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityShipsWheel;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityTarget;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.roof.TE_Roof;
import net.dark_roleplay.medieval.mess.common.objects.blocks.util.shop_sign.TE_ShopSign;
import net.dark_roleplay.medieval.mess.common.objects.entities.Wheelbarrel;
import net.dark_roleplay.medieval.mess.common.objects.entities.WheelbarrelRenderer;
import net.dark_roleplay.medieval.mess.work_in_progress_2.gui.brewing.Keybinds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.client.model.animation.AnimationTESR;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.animation.Event;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
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
		ModelLoaderRegistry.registerLoader(new DelayedBaker_HangingBridge());
		ModelLoaderRegistry.registerLoader(new DelayedBaker_RopeFence());
		ModelLoaderRegistry.registerLoader(new CustomBlockstateLoader());	
		ModelLoaderRegistry.registerLoader(new DelayedBaker_Timbering());
		ModelLoaderRegistry.registerLoader(new MultiLayerModelLoader());
		
		RenderingRegistry.<Entity_Fox>registerEntityRenderingHandler(Entity_Fox.class, Render_Fox.FACTORY);
		RenderingRegistry.<Wheelbarrel>registerEntityRenderingHandler(Wheelbarrel.class, WheelbarrelRenderer.FACTORY);

		this.registerRenders();	
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		//TODO REMOVE THIS
		ClientRegistry.registerKeyBinding(Keybinds.debugging);
		
		IResourceManager manager = Minecraft.getMinecraft().getResourceManager();
		DryClayGrassColor color = new DryClayGrassColor();
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(color, DRPMedievalBlocks.DRY_CLAY_GRASS);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new IItemColor(){
			@Override
            public int colorMultiplier(ItemStack stack, int tintIndex){
                IBlockState iblockstate = ((ItemBlock)stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
                return color.colorMultiplier(iblockstate, (IBlockAccess)null, (BlockPos)null, tintIndex);
            }
        }, DRPMedievalBlocks.DRY_CLAY_GRASS);

		
		MinecraftForge.EVENT_BUS.register(new OnCameraUpdate());
	}

	@Override
	public void init(FMLPostInitializationEvent event) {}


	public void registerRenders() {				
		ClientRegistry.bindTileEntitySpecialRenderer(TE_Roof.class, new TESR_Roof());
		ClientRegistry.bindTileEntitySpecialRenderer(TE_ClockCore.class, new TESR_ClockCore());
		ClientRegistry.bindTileEntitySpecialRenderer(TE_ShopSign.class, new TESR_ShopSign());
		ClientRegistry.bindTileEntitySpecialRenderer(TE_Shelf.class, new TESR_Shelf(Minecraft.getMinecraft().getRenderItem()));
		ClientRegistry.bindTileEntitySpecialRenderer(TE_FluidBarrel.class, new TESR_FluidBarrel());
		ClientRegistry.bindTileEntitySpecialRenderer(FlowersTileEntity.class, new TESR_Flowers());

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
	}
	
	public IAnimationStateMachine load(ResourceLocation location, ImmutableMap<String, ITimeValue> parameters){
        return ModelLoaderRegistry.loadASM(location, parameters);
    }
}
