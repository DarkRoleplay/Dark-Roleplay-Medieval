package net.dark_roleplay.medieval.common;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dark_roleplay.medieval.common.blocks.tileentitys.BedFrameTileEntity;
import net.dark_roleplay.medieval.common.blocks.tileentitys.RopeCoilTileEntity;
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
import net.dark_roleplay.medieval.common.handler.DRPMedievalVillagers;
import net.dark_roleplay.medieval.common.proxy.CommonProxy;
import net.dark_roleplay.medieval.common.tileentities.TileEntity_AdvancedCrop;
import net.dark_roleplay.medieval.common.tileentities.TileEntity_FlowerStorage;
import net.dark_roleplay.medieval.common.util.LoreHelper;
import net.dark_roleplay.medieval.common.worldgen.GenerateStructure;
import net.dark_roleplay.medieval.common.worldgen.WorldLoot;
import net.dark_roleplay.medieval.common.worldgen.feature.OreGen;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
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

		DRPMedievalBlocks.preInit(event);
		DRPMedievalItems.preInit(event);
		DRPMedievalEntities.preInit(event);
		DRPMedievalConfig.preInit(event);
		DRPMedievalAchievements.preInit(event);
		DRPMedievalVillagers.preInit(event);
		//TODO DRPMedievalCrafting.preInit(event);
		
		DarkRoleplayMedieval.proxy.preInit(event);

		this.registerTileEntitys();
		
		GameRegistry.registerFuelHandler(new DarkRoleplayFuelHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(DarkRoleplayMedieval.instance, new GuiHandler());
	}
	


	@EventHandler
	public void init(FMLInitializationEvent event) {

//		VillagerRegistry.instance().register
//		VillagerRegistry.instance().registerVillagerType(0, "/mods/MyMod/textures/villager/myvillager.png"); //adding the villager
//		VillagerRegistry.instance().registerVillageTradeHandler(1, null);  //adding his trades
//		VillagerRegistry.instance().registerVillageCreationHandler(new VillageCreationHandler()); //BUildings
		
		DRPMedievalBlocks.init(event);
		DRPMedievalItems.init(event);
		DRPMedievalEntities.init(event);
		DRPMedievalConfig.init(event);
		DRPMedievalAchievements.init(event);
		DRPMedievalVillagers.init(event);
		//TODO DRPMedievalCrafting.init(event);
		
		WorldLoot.registerChestLoot();
		WorldLoot.registerFishingLoot();
		WorldLoot.registerGrassLoot();

		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		GameRegistry.registerWorldGenerator(new GenerateStructure(), 0);
		EventHelper.registerEvents();
		
		this.registerFurnaceRecipes();
		
		DarkRoleplayMedieval.proxy.init(event);

		MinecraftForge.EVENT_BUS.register(new AttachCapabilityTileEntity());
		
		//GameRegistry.registerWorldGenerator(new GenerateStructure(), -5);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		DRPMedievalBlocks.postInit(event);
		DRPMedievalItems.postInit(event);
		DRPMedievalEntities.postInit(event);
		DRPMedievalConfig.postInit(event);
		DRPMedievalAchievements.postInit(event);
		DRPMedievalCrafting.postInit(event);
		DarkRoleplayMedieval.proxy.postInit(event);
		DRPMedievalVillagers.postInit(event);
		
		LoreHelper.registerItemDesc(DRPMedievalItems.TriggerTrap, new ArrayList<String>(){{this.add(TextFormatting.WHITE + "Usage:");this.add(TextFormatting.GRAY + "Apply it to a Torch Holder");this.add(TextFormatting.GRAY + "and use the Torch Holder as a Lever.");}});
		
		MissingMappings.registerToRemap(DRPMedievalBlocks.ANVIL, DRPMedievalInfo.MODID + ":" + "blockAnvil");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CAULDRON, DRPMedievalInfo.MODID + ":" + "blockCauldron");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CHOPPING_BLOCK, DRPMedievalInfo.MODID + ":" + "blockChoppingBlock");
		MissingMappings.registerToRemap(DRPMedievalBlocks.FIREPIT, DRPMedievalInfo.MODID + ":" + "blockFirepit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.GRINDSTONE, DRPMedievalInfo.MODID + ":" + "blockGrindstone");
		MissingMappings.registerToRemap(DRPMedievalBlocks.HANGING_CAULDRON, DRPMedievalInfo.MODID + ":" + "blockHangingCauldron");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MORTAR, DRPMedievalInfo.MODID + ":" + "blockMortar");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_CLOSED_SPRUCE, DRPMedievalInfo.MODID + ":" + "blockBarrelClosed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_CLOSED_SPRUCE, DRPMedievalInfo.MODID + ":" + "BarrelClosed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE, DRPMedievalInfo.MODID + ":" + "blockBarrelEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE, DRPMedievalInfo.MODID + ":" + "BarrelEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_GUNPOWDER_SPRUCE, DRPMedievalInfo.MODID + ":" + "blockBarrelGunpowder");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_GUNPOWDER_SPRUCE, DRPMedievalInfo.MODID + ":" + "BarrelGunpowder");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_OAK, DRPMedievalInfo.MODID + ":" + "bedFrameOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_SPRUCE, DRPMedievalInfo.MODID + ":" + "bedFrameSpruce");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_BIRCH, DRPMedievalInfo.MODID + ":" + "bedFrameBirch");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_JUNGLE, DRPMedievalInfo.MODID + ":" + "bedFrameJungle");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_ACACIA, DRPMedievalInfo.MODID + ":" + "bedFrameAcacia");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_DARK_OAK, DRPMedievalInfo.MODID + ":" + "bedFrameDarkOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bookOne, DRPMedievalInfo.MODID + ":" + "blockBookOne");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BUCKET_EMPTY, DRPMedievalInfo.MODID + ":" + "blockBucketEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BUCKET_WATER, DRPMedievalInfo.MODID + ":" + "blockBucketWater");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BUCKET_DIRT, DRPMedievalInfo.MODID + ":" + "blockBucketDirt");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CHAIN, DRPMedievalInfo.MODID + ":" + "blockChain");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CLEAN_PLANKS, DRPMedievalInfo.MODID + ":" + "cleanPlanks");
		MissingMappings.registerToRemap(DRPMedievalBlocks.HANGING_BRIDGE, DRPMedievalInfo.MODID + ":" + "blockHangingBridge");
		MissingMappings.registerToRemap(DRPMedievalBlocks.IRON_HOOK, DRPMedievalInfo.MODID + ":" + "blockHook");
		MissingMappings.registerToRemap(DRPMedievalBlocks.KEY_HANGING, DRPMedievalInfo.MODID + ":" + "blockKeyHanging");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUG_BEER, DRPMedievalInfo.MODID + ":" + "blockMugBeer");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUG_EMPTY, DRPMedievalInfo.MODID + ":" + "blockMugEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.ROPE, DRPMedievalInfo.MODID + ":" + "blockRope");
		MissingMappings.registerToRemap(DRPMedievalBlocks.ROPE_ANCHOR, DRPMedievalInfo.MODID + ":" + "blockRopeAnchor");
		MissingMappings.registerToRemap(DRPMedievalBlocks.SHIPS_HELM, DRPMedievalInfo.MODID + ":" + "blockShipsWheel");
		MissingMappings.registerToRemap(DRPMedievalBlocks.SHIPS_HELM, DRPMedievalInfo.MODID + ":" + "ShipsWheel");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TARGET, DRPMedievalInfo.MODID + ":" + "blockTarget");
//		MissingMappings.registerToRemap(DRPMBlocks.APIARY_OAK, DRPInfo.MODID + ":" + "Apiary");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TORCH_HOLDER_EMPTY, DRPMedievalInfo.MODID + ":" + "blockTorchHolderEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TORCH_HOLDER_LIT, DRPMedievalInfo.MODID + ":" + "blockTorchHolderLit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TORCH_HOLDER_UNLIT, DRPMedievalInfo.MODID + ":" + "blockTorchHolderUnlit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.APPLE_GREEN, DRPMedievalInfo.MODID + ":" + "blockAppleGreen");
		MissingMappings.registerToRemap(DRPMedievalBlocks.APPLE_RED, DRPMedievalInfo.MODID + ":" + "blockAppleRed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.APPLE_YELLOW, DRPMedievalInfo.MODID + ":" + "blockAppleYellow");
		//MissingMappings.registerToRemap(DRPMedievalBlocks.BARLEY, DRPInfo.MODID + ":" + "blockBarley");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUSHROOM_BROWN, DRPMedievalInfo.MODID + ":" + "blockMushroomBrown");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUSHROOM_RED, DRPMedievalInfo.MODID + ":" + "blockMushroomRed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.PEAR_GREEN, DRPMedievalInfo.MODID + ":" + "blockPearGreen");
		MissingMappings.registerToRemap(DRPMedievalBlocks.PEAR_YELLOW, DRPMedievalInfo.MODID + ":" + "blockPearYellow");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CRATE, DRPMedievalInfo.MODID + ":" + "blockCrate");
		MissingMappings.registerToRemap(DRPMedievalBlocks.DUNGEON_CHEST, DRPMedievalInfo.MODID + ":" + "blockDungeonChest");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_OAK, DRPMedievalInfo.MODID + ":" + "logChairOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_SPRUCE, DRPMedievalInfo.MODID + ":" + "logChairSpruce");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_BIRCH, DRPMedievalInfo.MODID + ":" + "logChairBirch");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_JUNGLE, DRPMedievalInfo.MODID + ":" + "logChairJungle");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_ACACIA, DRPMedievalInfo.MODID + ":" + "logChairAcacia");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_DARK_OAK, DRPMedievalInfo.MODID + ":" + "logChairDarkOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_CHAIR_SPRUCE, DRPMedievalInfo.MODID + ":" + "BarrelChair");
		
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameOak, DRPMedievalInfo.MODID + ":" + "bedFrameOak");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameSpruce, DRPMedievalInfo.MODID + ":" + "bedFrameSpruce");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameBirch, DRPMedievalInfo.MODID + ":" + "bedFrameBirch");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameJungle, DRPMedievalInfo.MODID + ":" + "bedFrameJungle");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameAcacia, DRPMedievalInfo.MODID + ":" + "bedFrameAcacia");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameDarkOak, DRPMedievalInfo.MODID + ":" + "bedFrameDarkOak");
		MissingMappings.registerToRemap(DRPMedievalItems.Barley, DRPMedievalInfo.MODID + ":" + "itemBarley");
		MissingMappings.registerToRemap(DRPMedievalItems.Turnip, DRPMedievalInfo.MODID + ":" + "itemTurnip");
		MissingMappings.registerToRemap(DRPMedievalItems.BronzeCoin, DRPMedievalInfo.MODID + ":" + "itemBronzeCoin");
		MissingMappings.registerToRemap(DRPMedievalItems.GoldenCoin, DRPMedievalInfo.MODID + ":" + "itemGoldenCoin");
		MissingMappings.registerToRemap(DRPMedievalItems.SilverCoin, DRPMedievalInfo.MODID + ":" + "itemSilverCoin");
//		MissingMappings.registerToRemap(DRPMedievalItems.Quiver, DRPInfo.MODID + ":" + "itemQuiver");
//		MissingMappings.registerToRemap(DRPMedievalItems.LeatherPurse, DRPInfo.MODID + ":" + "itemLeatherPurse");
//		MissingMappings.registerToRemap(DRPMedievalItems.BronzeRing, DRPInfo.MODID + ":" + "itemBronzeRing");
//		MissingMappings.registerToRemap(DRPMedievalItems.GoldenRing, DRPInfo.MODID + ":" + "itemGoldenRing");
//		MissingMappings.registerToRemap(DRPMedievalItems.SilverRing, DRPInfo.MODID + ":" + "itemSilverRing");
		MissingMappings.registerToRemap(DRPMedievalItems.AppleGreen, DRPMedievalInfo.MODID + ":" + "itemAppleGreen");
		MissingMappings.registerToRemap(DRPMedievalItems.AppleYellow, DRPMedievalInfo.MODID + ":" + "itemAppleYellow");
		MissingMappings.registerToRemap(DRPMedievalItems.CatfishCooked, DRPMedievalInfo.MODID + ":" + "itemCatfishCooked");
		MissingMappings.registerToRemap(DRPMedievalItems.CatfishRaw, DRPMedievalInfo.MODID + ":" + "itemCatfishRaw");
		MissingMappings.registerToRemap(DRPMedievalItems.ChickenStew, DRPMedievalInfo.MODID + ":" + "itemChickenStew");
		MissingMappings.registerToRemap(DRPMedievalItems.CodStew, DRPMedievalInfo.MODID + ":" + "itemCodStew");
		MissingMappings.registerToRemap(DRPMedievalItems.PearGreen, DRPMedievalInfo.MODID + ":" + "itemPearGreen");
		MissingMappings.registerToRemap(DRPMedievalItems.PearYellow, DRPMedievalInfo.MODID + ":" + "itemPearYellow");
		MissingMappings.registerToRemap(DRPMedievalItems.PumpkinBread, DRPMedievalInfo.MODID + ":" + "itemPumpkinBread");
		MissingMappings.registerToRemap(DRPMedievalItems.PumpkinStew, DRPMedievalInfo.MODID + ":" + "itemPumpkinStew");
		MissingMappings.registerToRemap(DRPMedievalItems.VegieStew, DRPMedievalInfo.MODID + ":" + "itemVegieStew");
		MissingMappings.registerToRemap(DRPMedievalItems.WolfMeatCooked, DRPMedievalInfo.MODID + ":" + "itemWolfMeatCooked");
		MissingMappings.registerToRemap(DRPMedievalItems.WolfMeatRaw, DRPMedievalInfo.MODID + ":" + "itemWolfMeatRaw");
		MissingMappings.registerToRemap(DRPMedievalItems.BatEar, DRPMedievalInfo.MODID + ":" + "itemBatEar");
		MissingMappings.registerToRemap(DRPMedievalItems.DoughBarley, DRPMedievalInfo.MODID + ":" + "itemDoughBarley");
		MissingMappings.registerToRemap(DRPMedievalItems.DoughPumpkin, DRPMedievalInfo.MODID + ":" + "itemDoughPumpkin");
		MissingMappings.registerToRemap(DRPMedievalItems.DoughWheat, DRPMedievalInfo.MODID + ":" + "itemDoughWheat");
		MissingMappings.registerToRemap(DRPMedievalItems.Firewood, DRPMedievalInfo.MODID + ":" + "itemFirewood");
		MissingMappings.registerToRemap(DRPMedievalItems.FlourBarley, DRPMedievalInfo.MODID + ":" + "itemFlourBarley");
		MissingMappings.registerToRemap(DRPMedievalItems.FlourWheat, DRPMedievalInfo.MODID + ":" + "itemFlourWheat");
		MissingMappings.registerToRemap(DRPMedievalItems.FurWolf, DRPMedievalInfo.MODID + ":" + "itemFurWolf");
		MissingMappings.registerToRemap(DRPMedievalItems.TriggerTrap, DRPMedievalInfo.MODID + ":" + "itemTriggerTrap");
		//MissingMappings.registerToRemap(DRPMedievalItems.SeedBarley, DRPInfo.MODID + ":" + "itemSeedBarley");
	}

	public void registerTileEntitys() {

		GameRegistry.registerTileEntity(TileEntityAnvil.class, DRPMedievalInfo.MODID + ":" + "TileEntityAnvil");
		GameRegistry.registerTileEntity(TileEntityMortar.class, DRPMedievalInfo.MODID + ":" + "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, DRPMedievalInfo.MODID + ":" + "TileEntityGrindstone");
		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, DRPMedievalInfo.MODID + ":" + "TileEntityHangingCauldron");
		GameRegistry.registerTileEntity(TileEntityBookOne.class, DRPMedievalInfo.MODID + ":" + "TileEntityBookOne");
		GameRegistry.registerTileEntity(TileEntityCauldron.class, DRPMedievalInfo.MODID + ":" + "TileEntityCauldron");
		GameRegistry.registerTileEntity(TileEntityChain.class, DRPMedievalInfo.MODID + ":" + "TileEntityChain");
		GameRegistry.registerTileEntity(TileEntityHook.class, DRPMedievalInfo.MODID + ":" + "TileEntityHook");
		GameRegistry.registerTileEntity(TileEntityKeyHanging.class, DRPMedievalInfo.MODID + ":" + "TileEntityKeyHanging");
		GameRegistry.registerTileEntity(TileEntityShipsWheel.class, DRPMedievalInfo.MODID + ":" + "TileEntityShipsWheel");
		GameRegistry.registerTileEntity(TileEntityTarget.class, DRPMedievalInfo.MODID + ":" + "TileEntityTarget");
		GameRegistry.registerTileEntity(TileEntityRopeAnchor.class, DRPMedievalInfo.MODID + ":" + "TileEntityRopeAnchor");
		GameRegistry.registerTileEntity(TileEntityFirepit.class, DRPMedievalInfo.MODID + ":" + "TileEntityFirepit");
        GameRegistry.registerTileEntity(TileEntity_FlowerStorage.class, DRPMedievalInfo.MODID + "BucketTileEntity");
        GameRegistry.registerTileEntity(RopeCoilTileEntity.class, DRPMedievalInfo.MODID + "rope_coil_tilenentity");

		
		
		// Storage Blocks
		GameRegistry.registerTileEntity(TileEntityCrate.class, DRPMedievalInfo.MODID + ":" + "TilEntityCrate");
		GameRegistry.registerTileEntity(TileEntityDungeonChest.class, DRPMedievalInfo.MODID + ":" + "TileEntityDungeonChest");
		GameRegistry.registerTileEntity(BedFrameTileEntity.class, "BedFrameTileEntity");
		GameRegistry.registerTileEntity(TileEntity_AdvancedCrop.class, DRPMedievalInfo.MODID + ":" + "tile_entity_advanced_crop");
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
