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

@Mod(modid = DRPInfo.MODID, version = DRPInfo.VERSION, name = DRPInfo.NAME, acceptedMinecraftVersions = DRPInfo.ACCEPTEDVERSIONS, dependencies = DRPInfo.DEPENDECIES, updateJSON = DRPInfo.UPDATECHECK)
public class DarkRoleplayMedieval {

    public static final Logger LOGGER = LogManager.getLogger(DRPInfo.MODID);
	
	public static boolean isOnServer = false;
	
	@SidedProxy(serverSide = "net.dark_roleplay.medieval.common.proxy.CommonProxy", clientSide = "net.dark_roleplay.medieval.client.ClientProxy")
	public static CommonProxy proxy;

	@net.minecraftforge.fml.common.Mod.Instance(DRPInfo.MODID)
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
		
		MissingMappings.registerToRemap(DRPMedievalBlocks.ANVIL, DRPInfo.MODID + ":" + "blockAnvil");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CAULDRON, DRPInfo.MODID + ":" + "blockCauldron");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CHOPPING_BLOCK, DRPInfo.MODID + ":" + "blockChoppingBlock");
		MissingMappings.registerToRemap(DRPMedievalBlocks.FIREPIT, DRPInfo.MODID + ":" + "blockFirepit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.GRINDSTONE, DRPInfo.MODID + ":" + "blockGrindstone");
		MissingMappings.registerToRemap(DRPMedievalBlocks.HANGING_CAULDRON, DRPInfo.MODID + ":" + "blockHangingCauldron");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MORTAR, DRPInfo.MODID + ":" + "blockMortar");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_CLOSED_SPRUCE, DRPInfo.MODID + ":" + "blockBarrelClosed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_CLOSED_SPRUCE, DRPInfo.MODID + ":" + "BarrelClosed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE, DRPInfo.MODID + ":" + "blockBarrelEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE, DRPInfo.MODID + ":" + "BarrelEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_GUNPOWDER_SPRUCE, DRPInfo.MODID + ":" + "blockBarrelGunpowder");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_GUNPOWDER_SPRUCE, DRPInfo.MODID + ":" + "BarrelGunpowder");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_OAK, DRPInfo.MODID + ":" + "bedFrameOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_SPRUCE, DRPInfo.MODID + ":" + "bedFrameSpruce");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_BIRCH, DRPInfo.MODID + ":" + "bedFrameBirch");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_JUNGLE, DRPInfo.MODID + ":" + "bedFrameJungle");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_ACACIA, DRPInfo.MODID + ":" + "bedFrameAcacia");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_DARK_OAK, DRPInfo.MODID + ":" + "bedFrameDarkOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bookOne, DRPInfo.MODID + ":" + "blockBookOne");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BUCKET_EMPTY, DRPInfo.MODID + ":" + "blockBucketEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BUCKET_WATER, DRPInfo.MODID + ":" + "blockBucketWater");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BUCKET_DIRT, DRPInfo.MODID + ":" + "blockBucketDirt");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CHAIN, DRPInfo.MODID + ":" + "blockChain");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CLEAN_PLANKS, DRPInfo.MODID + ":" + "cleanPlanks");
		MissingMappings.registerToRemap(DRPMedievalBlocks.HANGING_BRIDGE, DRPInfo.MODID + ":" + "blockHangingBridge");
		MissingMappings.registerToRemap(DRPMedievalBlocks.IRON_HOOK, DRPInfo.MODID + ":" + "blockHook");
		MissingMappings.registerToRemap(DRPMedievalBlocks.KEY_HANGING, DRPInfo.MODID + ":" + "blockKeyHanging");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUG_BEER, DRPInfo.MODID + ":" + "blockMugBeer");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUG_EMPTY, DRPInfo.MODID + ":" + "blockMugEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.ROPE, DRPInfo.MODID + ":" + "blockRope");
		MissingMappings.registerToRemap(DRPMedievalBlocks.ROPE_ANCHOR, DRPInfo.MODID + ":" + "blockRopeAnchor");
		MissingMappings.registerToRemap(DRPMedievalBlocks.SHIPS_HELM, DRPInfo.MODID + ":" + "blockShipsWheel");
		MissingMappings.registerToRemap(DRPMedievalBlocks.SHIPS_HELM, DRPInfo.MODID + ":" + "ShipsWheel");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TARGET, DRPInfo.MODID + ":" + "blockTarget");
//		MissingMappings.registerToRemap(DRPMBlocks.APIARY_OAK, DRPInfo.MODID + ":" + "Apiary");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TORCH_HOLDER_EMPTY, DRPInfo.MODID + ":" + "blockTorchHolderEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TORCH_HOLDER_LIT, DRPInfo.MODID + ":" + "blockTorchHolderLit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TORCH_HOLDER_UNLIT, DRPInfo.MODID + ":" + "blockTorchHolderUnlit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.APPLE_GREEN, DRPInfo.MODID + ":" + "blockAppleGreen");
		MissingMappings.registerToRemap(DRPMedievalBlocks.APPLE_RED, DRPInfo.MODID + ":" + "blockAppleRed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.APPLE_YELLOW, DRPInfo.MODID + ":" + "blockAppleYellow");
		//MissingMappings.registerToRemap(DRPMedievalBlocks.BARLEY, DRPInfo.MODID + ":" + "blockBarley");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUSHROOM_BROWN, DRPInfo.MODID + ":" + "blockMushroomBrown");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUSHROOM_RED, DRPInfo.MODID + ":" + "blockMushroomRed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.PEAR_GREEN, DRPInfo.MODID + ":" + "blockPearGreen");
		MissingMappings.registerToRemap(DRPMedievalBlocks.PEAR_YELLOW, DRPInfo.MODID + ":" + "blockPearYellow");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CRATE, DRPInfo.MODID + ":" + "blockCrate");
		MissingMappings.registerToRemap(DRPMedievalBlocks.DUNGEON_CHEST, DRPInfo.MODID + ":" + "blockDungeonChest");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_OAK, DRPInfo.MODID + ":" + "logChairOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_SPRUCE, DRPInfo.MODID + ":" + "logChairSpruce");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_BIRCH, DRPInfo.MODID + ":" + "logChairBirch");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_JUNGLE, DRPInfo.MODID + ":" + "logChairJungle");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_ACACIA, DRPInfo.MODID + ":" + "logChairAcacia");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_DARK_OAK, DRPInfo.MODID + ":" + "logChairDarkOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_CHAIR_SPRUCE, DRPInfo.MODID + ":" + "BarrelChair");
		
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameOak, DRPInfo.MODID + ":" + "bedFrameOak");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameSpruce, DRPInfo.MODID + ":" + "bedFrameSpruce");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameBirch, DRPInfo.MODID + ":" + "bedFrameBirch");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameJungle, DRPInfo.MODID + ":" + "bedFrameJungle");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameAcacia, DRPInfo.MODID + ":" + "bedFrameAcacia");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameDarkOak, DRPInfo.MODID + ":" + "bedFrameDarkOak");
		MissingMappings.registerToRemap(DRPMedievalItems.Barley, DRPInfo.MODID + ":" + "itemBarley");
		MissingMappings.registerToRemap(DRPMedievalItems.Turnip, DRPInfo.MODID + ":" + "itemTurnip");
		MissingMappings.registerToRemap(DRPMedievalItems.BronzeCoin, DRPInfo.MODID + ":" + "itemBronzeCoin");
		MissingMappings.registerToRemap(DRPMedievalItems.GoldenCoin, DRPInfo.MODID + ":" + "itemGoldenCoin");
		MissingMappings.registerToRemap(DRPMedievalItems.SilverCoin, DRPInfo.MODID + ":" + "itemSilverCoin");
//		MissingMappings.registerToRemap(DRPMedievalItems.Quiver, DRPInfo.MODID + ":" + "itemQuiver");
//		MissingMappings.registerToRemap(DRPMedievalItems.LeatherPurse, DRPInfo.MODID + ":" + "itemLeatherPurse");
//		MissingMappings.registerToRemap(DRPMedievalItems.BronzeRing, DRPInfo.MODID + ":" + "itemBronzeRing");
//		MissingMappings.registerToRemap(DRPMedievalItems.GoldenRing, DRPInfo.MODID + ":" + "itemGoldenRing");
//		MissingMappings.registerToRemap(DRPMedievalItems.SilverRing, DRPInfo.MODID + ":" + "itemSilverRing");
		MissingMappings.registerToRemap(DRPMedievalItems.AppleGreen, DRPInfo.MODID + ":" + "itemAppleGreen");
		MissingMappings.registerToRemap(DRPMedievalItems.AppleYellow, DRPInfo.MODID + ":" + "itemAppleYellow");
		MissingMappings.registerToRemap(DRPMedievalItems.CatfishCooked, DRPInfo.MODID + ":" + "itemCatfishCooked");
		MissingMappings.registerToRemap(DRPMedievalItems.CatfishRaw, DRPInfo.MODID + ":" + "itemCatfishRaw");
		MissingMappings.registerToRemap(DRPMedievalItems.ChickenStew, DRPInfo.MODID + ":" + "itemChickenStew");
		MissingMappings.registerToRemap(DRPMedievalItems.CodStew, DRPInfo.MODID + ":" + "itemCodStew");
		MissingMappings.registerToRemap(DRPMedievalItems.PearGreen, DRPInfo.MODID + ":" + "itemPearGreen");
		MissingMappings.registerToRemap(DRPMedievalItems.PearYellow, DRPInfo.MODID + ":" + "itemPearYellow");
		MissingMappings.registerToRemap(DRPMedievalItems.PumpkinBread, DRPInfo.MODID + ":" + "itemPumpkinBread");
		MissingMappings.registerToRemap(DRPMedievalItems.PumpkinStew, DRPInfo.MODID + ":" + "itemPumpkinStew");
		MissingMappings.registerToRemap(DRPMedievalItems.VegieStew, DRPInfo.MODID + ":" + "itemVegieStew");
		MissingMappings.registerToRemap(DRPMedievalItems.WolfMeatCooked, DRPInfo.MODID + ":" + "itemWolfMeatCooked");
		MissingMappings.registerToRemap(DRPMedievalItems.WolfMeatRaw, DRPInfo.MODID + ":" + "itemWolfMeatRaw");
		MissingMappings.registerToRemap(DRPMedievalItems.BatEar, DRPInfo.MODID + ":" + "itemBatEar");
		MissingMappings.registerToRemap(DRPMedievalItems.DoughBarley, DRPInfo.MODID + ":" + "itemDoughBarley");
		MissingMappings.registerToRemap(DRPMedievalItems.DoughPumpkin, DRPInfo.MODID + ":" + "itemDoughPumpkin");
		MissingMappings.registerToRemap(DRPMedievalItems.DoughWheat, DRPInfo.MODID + ":" + "itemDoughWheat");
		MissingMappings.registerToRemap(DRPMedievalItems.Firewood, DRPInfo.MODID + ":" + "itemFirewood");
		MissingMappings.registerToRemap(DRPMedievalItems.FlourBarley, DRPInfo.MODID + ":" + "itemFlourBarley");
		MissingMappings.registerToRemap(DRPMedievalItems.FlourWheat, DRPInfo.MODID + ":" + "itemFlourWheat");
		MissingMappings.registerToRemap(DRPMedievalItems.FurWolf, DRPInfo.MODID + ":" + "itemFurWolf");
		MissingMappings.registerToRemap(DRPMedievalItems.TriggerTrap, DRPInfo.MODID + ":" + "itemTriggerTrap");
		//MissingMappings.registerToRemap(DRPMedievalItems.SeedBarley, DRPInfo.MODID + ":" + "itemSeedBarley");
	}

	public void registerTileEntitys() {

		GameRegistry.registerTileEntity(TileEntityAnvil.class, DRPInfo.MODID + ":" + "TileEntityAnvil");
		GameRegistry.registerTileEntity(TileEntityMortar.class, DRPInfo.MODID + ":" + "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, DRPInfo.MODID + ":" + "TileEntityGrindstone");
		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, DRPInfo.MODID + ":" + "TileEntityHangingCauldron");
		GameRegistry.registerTileEntity(TileEntityBookOne.class, DRPInfo.MODID + ":" + "TileEntityBookOne");
		GameRegistry.registerTileEntity(TileEntityCauldron.class, DRPInfo.MODID + ":" + "TileEntityCauldron");
		GameRegistry.registerTileEntity(TileEntityChain.class, DRPInfo.MODID + ":" + "TileEntityChain");
		GameRegistry.registerTileEntity(TileEntityHook.class, DRPInfo.MODID + ":" + "TileEntityHook");
		GameRegistry.registerTileEntity(TileEntityKeyHanging.class, DRPInfo.MODID + ":" + "TileEntityKeyHanging");
		GameRegistry.registerTileEntity(TileEntityShipsWheel.class, DRPInfo.MODID + ":" + "TileEntityShipsWheel");
		GameRegistry.registerTileEntity(TileEntityTarget.class, DRPInfo.MODID + ":" + "TileEntityTarget");
		GameRegistry.registerTileEntity(TileEntityRopeAnchor.class, DRPInfo.MODID + ":" + "TileEntityRopeAnchor");
		GameRegistry.registerTileEntity(TileEntityFirepit.class, DRPInfo.MODID + ":" + "TileEntityFirepit");
        GameRegistry.registerTileEntity(TileEntity_FlowerStorage.class, DRPInfo.MODID + "BucketTileEntity");
        GameRegistry.registerTileEntity(RopeCoilTileEntity.class, DRPInfo.MODID + "rope_coil_tilenentity");

		
		
		// Storage Blocks
		GameRegistry.registerTileEntity(TileEntityCrate.class, DRPInfo.MODID + ":" + "TilEntityCrate");
		GameRegistry.registerTileEntity(TileEntityDungeonChest.class, DRPInfo.MODID + ":" + "TileEntityDungeonChest");
		GameRegistry.registerTileEntity(BedFrameTileEntity.class, "BedFrameTileEntity");
		GameRegistry.registerTileEntity(TileEntity_AdvancedCrop.class, DRPInfo.MODID + ":" + "tile_entity_advanced_crop");
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
