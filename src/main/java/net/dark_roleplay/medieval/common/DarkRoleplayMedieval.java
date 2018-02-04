package net.dark_roleplay.medieval.common;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dark_roleplay.drpcore.api.Modules;
import net.dark_roleplay.medieval.client.events.Event_GuiOpen;
import net.dark_roleplay.medieval.client.events.config.Event_ConfigChange;
import net.dark_roleplay.medieval.client.premium.RenderLayerPremium;
import net.dark_roleplay.medieval.client.premium.RenderLayer_Guild;
import net.dark_roleplay.medieval.common.events.MissingMappings;
import net.dark_roleplay.medieval.common.events.blocks.Event_BlockBreak;
import net.dark_roleplay.medieval.common.events.capabilities.Event_CapabilityTileEntity;
import net.dark_roleplay.medieval.common.gui.GuiHandler;
import net.dark_roleplay.medieval.common.handler.DRPMedievalAchievements;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCapabilities;
import net.dark_roleplay.medieval.common.handler.DRPMedievalConfig;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCrafting;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.DRPMedievalEntities;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.common.handler.DRPMedievalLores;
import net.dark_roleplay.medieval.common.handler.DRPMedievalMappings;
import net.dark_roleplay.medieval.common.handler.DRPMedievalPackets;
import net.dark_roleplay.medieval.common.handler.DRPMedievalSkills;
import net.dark_roleplay.medieval.common.handler.DRPMedievalSounds;
import net.dark_roleplay.medieval.common.handler.DRPMedievalTileEntities;
import net.dark_roleplay.medieval.common.handler.DRPMedievalVillagers;
import net.dark_roleplay.medieval.common.world_generation.GenHandler_Trees;
import net.dark_roleplay.medieval.common.world_generation.GenerateStructure;
import net.dark_roleplay.medieval.common.world_generation.WorldLoot;
import net.dark_roleplay.medieval.common.world_generation.feature.OreGen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = DRPMedievalInfo.MODID, version = DRPMedievalInfo.VERSION, name = DRPMedievalInfo.NAME, acceptedMinecraftVersions = DRPMedievalInfo.ACCEPTEDVERSIONS, dependencies = DRPMedievalInfo.DEPENDECIES, updateJSON = DRPMedievalInfo.UPDATECHECK)
public class DarkRoleplayMedieval {

	
	public static boolean isOnServer = false;
	
	@SidedProxy(serverSide = "net.dark_roleplay.medieval.common.CommonProxy", clientSide = "net.dark_roleplay.medieval.client.ClientProxy")
	public static CommonProxy proxy;

	@net.minecraftforge.fml.common.Mod.Instance(DRPMedievalInfo.MODID)
	public static DarkRoleplayMedieval instance;

	public DarkRoleplayMedieval(){
		File resourcesFolder = new File(Minecraft.getMinecraft().mcDataDir.getPath() + "/dark roleplay/argh/assets/drpmedieval");
		resourcesFolder.mkdirs();
	}
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		if(event.getSide() == Side.SERVER) {
			DarkRoleplayMedieval.isOnServer = true;
		}

		DRPMedievalCapabilities.register();
		DRPMedievalEntities.init(event);
		DRPMedievalVillagers.init(event);
		DRPMedievalTileEntities.init(event);
		DRPMedievalSkills.init(event);
		DRPMedievalAchievements.init(event);
		DRPMedievalLores.init(event);
		DarkRoleplayMedieval.proxy.init(event);

		Modules.CRAFTING2.addMod("drpmedieval");
		GameRegistry.registerFuelHandler(new DarkRoleplayFuelHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(DarkRoleplayMedieval.instance, new GuiHandler());
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
		DRPMedievalEntities.init(event);
		DRPMedievalVillagers.init(event);
		DRPMedievalTileEntities.init(event);
		DRPMedievalSkills.init(event);
		DRPMedievalAchievements.init(event);
		DRPMedievalLores.init(event);
		DarkRoleplayMedieval.proxy.init(event);
		DRPMedievalCreativeTabs.init(event);
		WorldLoot.registerChestLoot();
		WorldLoot.registerFishingLoot();
		WorldLoot.registerGrassLoot();


			GameRegistry.registerWorldGenerator(new OreGen(), 0);
//			GameRegistry.registerWorldGenerator(new GenerateStructure(), 0);

		DRPMedievalPackets.init();
		
		if(event.getSide() == Side.CLIENT){
			MinecraftForge.EVENT_BUS.register(new Event_GuiOpen());
			MinecraftForge.EVENT_BUS.register(new Event_ConfigChange());
//			RenderPlayer steve = ((RenderPlayer)Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default"));
//			RenderPlayer alex = ((RenderPlayer)Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim"));
//			steve.addLayer(new RenderLayerPremium());
//			alex.addLayer(new RenderLayerPremium());
//			steve.addLayer(new RenderLayer_Guild());
//			alex.addLayer(new RenderLayer_Guild());
		}

		DRPMedievalMappings.init(event);

		MinecraftForge.EVENT_BUS.register(new Event_BlockBreak());
		
		registerFurnaceRecipes();

//		GameRegistry.registerWorldGenerator(new GenHandler_Trees(), 0);
		
		MinecraftForge.EVENT_BUS.register(new Event_CapabilityTileEntity());
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		DRPMedievalEntities.init(event);
		DRPMedievalVillagers.init(event);
		DRPMedievalTileEntities.init(event);
		DRPMedievalAchievements.init(event);
		DRPMedievalSkills.init(event);
		DRPMedievalCrafting.init(event);
		DRPMedievalLores.init(event);
		DarkRoleplayMedieval.proxy.init(event);
		
		ModContainer mod = Loader.instance().activeModContainer();
		if(mod.getModId().equals(DRPMedievalInfo.MODID)){
			DRPMedievalInfo.VERSION_STATUS = ForgeVersion.getResult(mod);
		}
	}

	public static void registerFurnaceRecipes() {

		GameRegistry.addSmelting(DRPMedievalItems.DOUGH, new ItemStack(Items.BREAD), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.MEAT_RAW_WOLF, new ItemStack(DRPMedievalItems.MEAT_COOKED_WOLF), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.DOUGH_PUMPKIN, new ItemStack(DRPMedievalItems.PUMPKIN_BREAD), 0.1f);
		GameRegistry.addSmelting(Item.getItemFromBlock(Blocks.OBSIDIAN), new ItemStack(DRPMedievalBlocks.OBSIDIAN_GLASS), 0.1f);
	}
}

class DarkRoleplayFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {

		Item item = fuel.getItem();

		if(item.equals(DRPMedievalItems.FIREWOOD))
			return 800;

		return 0;
	}
}
