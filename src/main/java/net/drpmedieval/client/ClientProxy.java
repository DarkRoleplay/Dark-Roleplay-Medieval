package net.drpmedieval.client;

import java.awt.Label;

import net.drpmedieval.client.events.OnPlayerTick;
import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.specialrenderer.*;
import net.drpmedieval.common.blocks.tileentitys.*;
import net.drpmedieval.common.entity.TrainingDummy;
import net.drpmedieval.common.entity.renders.RenderTrainingDummy;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.drpmedieval.common.proxy.CommonProxy;
import net.drpmedieval.common.util.UpdateCheck;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {

	public void checkForUpdates() {

		UpdateCheck.checkForUpdate();
		FMLCommonHandler.instance().bus().register(new OnPlayerTick());
	}

	public void registerEntityRenders() {

	}

	public void registerRenders() {

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

		/** Blocks **/
		// A
		registerItemMesh(DRPMedievalBlocks.appleGreen);
		registerItemMesh(DRPMedievalBlocks.appleRed);
		registerItemMesh(DRPMedievalBlocks.appleYellow);
		// B
		registerItemMesh(DRPMedievalBlocks.barrelClosed);
		registerItemMesh(DRPMedievalBlocks.barrelEmpty);
		registerItemMesh(DRPMedievalBlocks.barrelGunpowder);
		registerItemMesh(DRPMedievalBlocks.bucketDirt);
		registerItemMesh(DRPMedievalBlocks.bucketEmpty);
		registerItemMesh(DRPMedievalBlocks.bucketWater);
		// C
		registerItemMesh(DRPMedievalBlocks.chain);
		registerItemMesh(DRPMedievalBlocks.choppingBlock);
		registerItemMesh(DRPMedievalBlocks.crate);
		// D
		registerItemMesh(DRPMedievalBlocks.dungeonChest);
		// E
		// F
		// G
		// H
		registerItemMesh(DRPMedievalBlocks.hangingBridge);
		registerItemMesh(DRPMedievalBlocks.hook);
		// I
		// J
		// K
		registerItemMesh(DRPMedievalBlocks.keyHanging);
		// L
		// M
		registerItemMesh(DRPMedievalBlocks.mugEmpty);
		registerItemMesh(DRPMedievalBlocks.mugBeer);
		registerItemMesh(DRPMedievalBlocks.mushroomBrown);
		registerItemMesh(DRPMedievalBlocks.mushroomRed);
		// N
		// O
		// P
		registerItemMesh(DRPMedievalBlocks.pearGreen);
		registerItemMesh(DRPMedievalBlocks.pearYellow);
		// Q
		// R
		registerItemMesh(DRPMedievalBlocks.rope);
		// S
		registerItemMesh(DRPMedievalBlocks.shipsWheel);
		// T
		registerItemMesh(DRPMedievalBlocks.target);
		registerItemMesh(DRPMedievalBlocks.torchHolderEmpty);
		registerItemMesh(DRPMedievalBlocks.torchHolderLit);
		registerItemMesh(DRPMedievalBlocks.torchHolderUnlit);
		// U
		// V
		// W
		// X
		// Y
		// Z

		/** Items **/

		// A
		registerItemMesh(DRPMedievalItems.itemAppleGreen);
		registerItemMesh(DRPMedievalItems.itemAppleYellow);
		// B
		registerItemMesh(DRPMedievalItems.itemBarley);
		registerItemMesh(DRPMedievalItems.itemBatEar);
		registerItemMesh(DRPMedievalItems.itemBronzeCoin);
		registerItemMesh(DRPMedievalItems.itemBronzeRing);
		// C
		registerItemMesh(DRPMedievalItems.itemCatfishCooked);
		registerItemMesh(DRPMedievalItems.itemCatfishRaw);
		registerItemMesh(DRPMedievalItems.itemChickenStew);
		registerItemMesh(DRPMedievalItems.itemCodStew);
		// D
		registerItemMesh(DRPMedievalItems.itemDoughBarley);
		registerItemMesh(DRPMedievalItems.itemDoughWheat);
		// E
		// F
		registerItemMesh(DRPMedievalItems.itemFirewood);
		registerItemMesh(DRPMedievalItems.itemFlourBarley);
		registerItemMesh(DRPMedievalItems.itemFlourWheat);
		registerItemMesh(DRPMedievalItems.itemFurWolf);
		// G
		registerItemMesh(DRPMedievalItems.itemGoldenCoin);
		registerItemMesh(DRPMedievalItems.itemGoldenRing);
		// H
		// I
		// J
		// K
		// L
		registerItemMesh(DRPMedievalItems.itemLeatherPurse);
		// M
		// N
		// O
		// P
		registerItemMesh(DRPMedievalItems.itemPearGreen);
		registerItemMesh(DRPMedievalItems.itemPearYellow);
		registerItemMesh(DRPMedievalItems.itemPumpkinBread);
		registerItemMesh(DRPMedievalItems.itemPumpkinStew);
		// Q
		registerItemMesh(DRPMedievalItems.itemQuiver);
		// R
		// S
		registerItemMesh(DRPMedievalItems.itemSeedBarley);
		registerItemMesh(DRPMedievalItems.itemSilverCoin);
		registerItemMesh(DRPMedievalItems.itemSilverRing);
		// T
		registerItemMesh(DRPMedievalItems.itemTriggerTrap);
		registerItemMesh(DRPMedievalItems.itemTurnip);
		// U
		// V
		registerItemMesh(DRPMedievalItems.itemVegieStew);
		// W
		registerItemMesh(DRPMedievalItems.itemWolfMeatCooked);
		registerItemMesh(DRPMedievalItems.itemWolfMeatRaw);
		// X
		// Y
		// Z

		// Old Blocks
		registerItemMesh(DRPMedievalBlocks.bookOne);
		registerItemMesh(DRPMedievalBlocks.anvil);
		registerItemMesh(DRPMedievalBlocks.grindstone);
		registerItemMesh(DRPMedievalBlocks.hangingCauldron);
		registerItemMesh(DRPMedievalBlocks.mortar);
		registerItemMesh(DRPMedievalBlocks.cauldron);
		registerItemMesh(DRPMedievalBlocks.ropeAnchor);
		registerItemMesh(DRPMedievalBlocks.firepit);

		// Special
		forceAdditionalModels();
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.itemFirewood, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodOak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.itemFirewood, 1, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodSpruce", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.itemFirewood, 2, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodBirch", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.itemFirewood, 3, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodJungle", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.itemFirewood, 4, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodDarkOak", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.itemFirewood, 5, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodAcacia", "inventory"));

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.itemDoughPumpkin, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemDoughPumpkinWheat", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(DRPMedievalItems.itemDoughPumpkin, 1, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemDoughPumpkinBarley", "inventory"));
	}

	public void forceAdditionalModels() {

		ModelBakery.registerItemVariants(DRPMedievalItems.itemFirewood, new ResourceLocation[] {new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodOak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodSpruce"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodBirch"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodJungle"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodDarkOak"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemFirewoodAcacia")});
		ModelBakery.registerItemVariants(DRPMedievalItems.itemDoughPumpkin, new ResourceLocation[] {new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemDoughPumpkinWheat"), new ResourceLocation(DarkRoleplayMedieval.MODID + ":" + "itemDoughPumpkinBarley")});
	}

	public void registerItemMesh(Block block) {

		String Name = block.getUnlocalizedName().toString().substring(block.getUnlocalizedName().toString().indexOf(".") + 1, block.getUnlocalizedName().toString().length());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + Name, "inventory"));
	}

	public void registerItemMesh(Item item) {

		String Name = item.getUnlocalizedName().toString().substring(item.getUnlocalizedName().toString().indexOf(".") + 1, item.getUnlocalizedName().toString().length());
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(DarkRoleplayMedieval.MODID + ":" + Name, "inventory"));
	}
}
