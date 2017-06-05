package net.dark_roleplay.medieval.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dark_roleplay.medieval.common.events.AttachCapabilityTileEntity;
import net.dark_roleplay.medieval.common.events.EventHelper;
import net.dark_roleplay.medieval.common.events.MissingMappings;
import net.dark_roleplay.medieval.common.gui.GuiHandler;
import net.dark_roleplay.medieval.common.handler.DRPMedievalAchievements;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.handler.DRPMedievalConfig;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCrafting;
import net.dark_roleplay.medieval.common.handler.DRPMedievalEntities;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.common.handler.DRPMedievalLores;
import net.dark_roleplay.medieval.common.handler.DRPMedievalSkills;
import net.dark_roleplay.medieval.common.handler.DRPMedievalTileEntities;
import net.dark_roleplay.medieval.common.handler.DRPMedievalVillagers;
import net.dark_roleplay.medieval.common.proxy.CommonProxy;
import net.dark_roleplay.medieval.common.worldgen.GenerateStructure;
import net.dark_roleplay.medieval.common.worldgen.WorldLoot;
import net.dark_roleplay.medieval.common.worldgen.feature.OreGen;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = DRPMedievalInfo.MODID, version = DRPMedievalInfo.VERSION, name = DRPMedievalInfo.NAME, acceptedMinecraftVersions = DRPMedievalInfo.ACCEPTEDVERSIONS, dependencies = DRPMedievalInfo.DEPENDECIES, updateJSON = DRPMedievalInfo.UPDATECHECK)
public class DarkRoleplayMedieval {

    public static final Logger LOGGER = LogManager.getLogger(DRPMedievalInfo.MODID);
	
	public static boolean isOnServer = false;
	
	@SidedProxy(serverSide = "net.dark_roleplay.medieval.common.proxy.CommonProxy", clientSide = "net.dark_roleplay.medieval.client.ClientProxy")
	public static CommonProxy proxy;

	@net.minecraftforge.fml.common.Mod.Instance(DRPMedievalInfo.MODID)
	public static DarkRoleplayMedieval instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		if(event.getSide() == Side.SERVER) {
			DarkRoleplayMedieval.isOnServer = true;
		}

		DRPMedievalBlocks.init(event);
		DRPMedievalItems.init(event);
		DRPMedievalEntities.init(event);
		DRPMedievalVillagers.init(event);
		DRPMedievalTileEntities.init(event);
		DRPMedievalConfig.init(event);
		DRPMedievalSkills.init(event);
		DRPMedievalAchievements.init(event);
		DRPMedievalCrafting.init(event);
		DRPMedievalLores.init(event);
		DarkRoleplayMedieval.proxy.init(event);
		
		GameRegistry.registerFuelHandler(new DarkRoleplayFuelHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(DarkRoleplayMedieval.instance, new GuiHandler());
	}
	


	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		DRPMedievalBlocks.init(event);
		DRPMedievalItems.init(event);
		DRPMedievalEntities.init(event);
		DRPMedievalVillagers.init(event);
		DRPMedievalTileEntities.init(event);
		DRPMedievalConfig.init(event);
		DRPMedievalSkills.init(event);
		DRPMedievalAchievements.init(event);
		DRPMedievalCrafting.init(event);
		DRPMedievalLores.init(event);
		DarkRoleplayMedieval.proxy.init(event);
		
		WorldLoot.registerChestLoot();
		WorldLoot.registerFishingLoot();
		WorldLoot.registerGrassLoot();

		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		GameRegistry.registerWorldGenerator(new GenerateStructure(), 0);
		EventHelper.registerEvents();
		
		this.registerFurnaceRecipes();

		MinecraftForge.EVENT_BUS.register(new AttachCapabilityTileEntity());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		DRPMedievalBlocks.init(event);
		DRPMedievalItems.init(event);
		DRPMedievalEntities.init(event);
		DRPMedievalVillagers.init(event);
		DRPMedievalTileEntities.init(event);
		DRPMedievalConfig.init(event);
		DRPMedievalAchievements.init(event);
		DRPMedievalSkills.init(event);
		DRPMedievalCrafting.init(event);
		DRPMedievalLores.init(event);
		DarkRoleplayMedieval.proxy.init(event);
				
		MissingMappings.registerToRemap(DRPMedievalBlocks.HANGING_BRIDGE_BOTTOM, DRPMedievalInfo.MODID + ":" + "hanging_bridge");
	}

	public void registerTileEntitys() {

	}

	public void registerFurnaceRecipes() {

		GameRegistry.addSmelting(DRPMedievalItems.DoughWheat, new ItemStack(Items.BREAD), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.DoughBarley, new ItemStack(Items.BREAD), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.WolfMeatRaw, new ItemStack(DRPMedievalItems.WolfMeatCooked), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.DoughPumpkin, new ItemStack(DRPMedievalItems.PumpkinBread), 0.1f);
	}
	
	@EventHandler
	public void MissingMappingsEvent(FMLMissingMappingsEvent event){
		MissingMappings.MissingMappingsEvent(event);
	}
}

class DarkRoleplayFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {

		Item item = fuel.getItem();

		if(item.equals(DRPMedievalItems.Firewood))
			return 800;

		return 0;
	}
}
