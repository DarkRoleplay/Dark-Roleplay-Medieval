package net.drpmedieval.client;

import java.util.ArrayList;

import net.drpmedieval.client.events.ItemColorHandler;
import net.drpmedieval.client.sound.SoundEvents;
import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.specialrenderer.*;
import net.drpmedieval.common.blocks.tileentitys.*;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.drpmedieval.common.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	ArrayList<Item> toRegisterMeshes = new ArrayList<Item>();
	
	public void preInit(FMLPreInitializationEvent event) {}
	
	public void init(FMLInitializationEvent event) {
		registerRenders();
		SoundEvents.registerSounds();
	}

	public void postInit(FMLPostInitializationEvent event) {}


	public void registerRenders() {
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemColorHandler(), DRPMedievalItems.StringCoil);
		
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
		// registerItemMesh(DRPMedievalItems);

		for(Item item : toRegisterMeshes){
			registerItemMesh(item);
		}
		
		toRegisterMeshes = null;
		
		// Old Blocks
		registerItemMesh(DRPMedievalBlocks.bookOne);
		registerItemMesh(DRPMedievalBlocks.anvil);
		registerItemMesh(DRPMedievalBlocks.grindstone);
		registerItemMesh(DRPMedievalBlocks.hangingCauldron);
		registerItemMesh(DRPMedievalBlocks.mortar);
		registerItemMesh(DRPMedievalBlocks.cauldron);
		registerItemMesh(DRPMedievalBlocks.ropeAnchor);
		registerItemMesh(DRPMedievalBlocks.firepit);

		//SPECIAL
		forceAdditionalModels();
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodOak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 1, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodSpruce", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 2, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodBirch", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 3, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodJungle", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 4, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodDarkOak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Firewood, 5, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodAcacia", "inventory"));

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankOak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 1, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankSpruce", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 2, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankBirch", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 3, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankJungle", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 4, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankDarkOak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.Plank, 5, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankAcacia", "inventory"));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.DoughPumpkin, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "DoughPumpkinWheat", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.DoughPumpkin, 1, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "DoughPumpkinBarley", "inventory"));
	}

	public void forceAdditionalModels() {

		ModelBakery.registerItemVariants(DRPMedievalItems.Firewood, new ResourceLocation[] {new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodOak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodSpruce"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodBirch"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodJungle"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodDarkOak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Firewood/FirewoodAcacia")});
		ModelBakery.registerItemVariants(DRPMedievalItems.Plank, new ResourceLocation[] {new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankOak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankSpruce"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankBirch"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankJungle"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankDarkOak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "Planks/plankAcacia")});
		ModelBakery.registerItemVariants(DRPMedievalItems.DoughPumpkin, new ResourceLocation[] {new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "DoughPumpkinWheat"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "DoughPumpkinBarley")});
	}

	public void registerItemMesh(Block block) {

		String Name = block.getUnlocalizedName().toString().substring(block.getUnlocalizedName().toString().indexOf(".") + 1, block.getUnlocalizedName().toString().length());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + Name, "inventory"));
	}

	public void addItemToRegisterMesh(Item item) {
		toRegisterMeshes.add(item);
	}
	
	public void registerItemMesh(Item item){
		String Name = item.getUnlocalizedName().toString().substring(item.getUnlocalizedName().toString().indexOf(".") + 1, item.getUnlocalizedName().toString().length());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + Name, "inventory"));
	}
}
