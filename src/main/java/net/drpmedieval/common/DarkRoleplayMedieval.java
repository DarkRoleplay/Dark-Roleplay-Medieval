package net.drpmedieval.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.drpmedieval.common.blocks.tileentitys.*;
import net.drpmedieval.common.entity.entitySittable.EntitySittable;
import net.drpmedieval.common.events.AttachCapabilityTileEntity;
import net.drpmedieval.common.events.EventHelper;
import net.drpmedieval.common.events.MissingMappings;
import net.drpmedieval.common.gui.GuiHandler;
import net.drpmedieval.common.handler.DRPMedievalItems;
import net.drpmedieval.common.handler.DRPMedievalAchievements;
import net.drpmedieval.common.handler.DRPMedievalBlocks;
import net.drpmedieval.common.handler.DRPMedievalConfig;
import net.drpmedieval.common.handler.DRPMedievalCrafting;
import net.drpmedieval.common.handler.DRPMedievalEntities;
import net.drpmedieval.common.proxy.CommonProxy;
import net.drpmedieval.common.tileentities.TileEntity_AdvancedCrop;
import net.drpmedieval.common.tileentities.TileEntity_FlowerStorage;
import net.drpmedieval.common.util.LoreHelper;
import net.drpmedieval.common.worldgen.GenerateStructure;
import net.drpmedieval.common.worldgen.WorldLoot;
import net.drpmedieval.common.worldgen.feature.OreGen;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = DarkRoleplayMedieval.MODID, version = DarkRoleplayMedieval.VERSION, name = DarkRoleplayMedieval.NAME, acceptedMinecraftVersions = DarkRoleplayMedieval.ACCEPTEDVERSIONS, dependencies = DarkRoleplayMedieval.DEPENDECIES, updateJSON = DarkRoleplayMedieval.UPDATECHECK)
public class DarkRoleplayMedieval {

	public static final String NAME = "Dark Roleplay Medieval";
	public static final String VERSION = "0.1.8";
	public static final String MODID = "drpmedieval";
	public static final String ACCEPTEDVERSIONS = "[1.11.2,)";
	public static final String DEPENDECIES = "required-after:drpcore@0.1.8,)";
	public static final String UPDATECHECK = "https://raw.githubusercontent.com/DarkRoleplay/Dark-Roleplay-Medieval/master/DarkRoleplayMedieval.json";

    public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public static boolean isOnServer = false;
	
	@SidedProxy(serverSide = "net.drpmedieval.common.proxy.CommonProxy", clientSide = "net.drpmedieval.client.ClientProxy")
	public static CommonProxy proxy;

	@net.minecraftforge.fml.common.Mod.Instance(MODID)
	public static DarkRoleplayMedieval instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		if(event.getSide() == Side.SERVER) this.isOnServer = true;

		DRPMedievalBlocks.preInit(event);
		DRPMedievalItems.preInit(event);
		DRPMedievalEntities.preInit(event);
		DRPMedievalConfig.preInit(event);
		DRPMedievalAchievements.preInit(event);
		//TODO DRPMedievalCrafting.preInit(event);
		
		proxy.preInit(event);

		registerTileEntitys();
		
		GameRegistry.registerFuelHandler(new DarkRoleplayFuelHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		DRPMedievalBlocks.init(event);
		DRPMedievalItems.init(event);
		DRPMedievalEntities.init(event);
		DRPMedievalConfig.init(event);
		DRPMedievalAchievements.init(event);
		//TODO DRPMedievalCrafting.init(event);
		
		WorldLoot.registerChestLoot();
		WorldLoot.registerFishingLoot();
		WorldLoot.registerGrassLoot();

		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		GameRegistry.registerWorldGenerator(new GenerateStructure(), 0);
		EventHelper.registerEvents();
		
		registerFurnaceRecipes();
		
		proxy.init(event);

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
		proxy.postInit(event);
		
		LoreHelper.registerItemDesc(DRPMedievalItems.TriggerTrap, new ArrayList<String>(){{add(TextFormatting.WHITE + "Usage:");add(TextFormatting.GRAY + "Apply it to a Torch Holder");add(TextFormatting.GRAY + "and use the Torch Holder as a Lever.");}});
		
		MissingMappings.registerToRemap(DRPMedievalBlocks.ANVIL, DarkRoleplayMedieval.MODID + ":" + "blockAnvil");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CAULDRON, DarkRoleplayMedieval.MODID + ":" + "blockCauldron");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CHOPPING_BLOCK, DarkRoleplayMedieval.MODID + ":" + "blockChoppingBlock");
		MissingMappings.registerToRemap(DRPMedievalBlocks.FIREPIT, DarkRoleplayMedieval.MODID + ":" + "blockFirepit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.GRINDSTONE, DarkRoleplayMedieval.MODID + ":" + "blockGrindstone");
		MissingMappings.registerToRemap(DRPMedievalBlocks.HANGING_CAULDRON, DarkRoleplayMedieval.MODID + ":" + "blockHangingCauldron");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MORTAR, DarkRoleplayMedieval.MODID + ":" + "blockMortar");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_CLOSED_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "blockBarrelClosed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_CLOSED_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "BarrelClosed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "blockBarrelEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "BarrelEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_GUNPOWDER_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "blockBarrelGunpowder");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_GUNPOWDER_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "BarrelGunpowder");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_OAK, DarkRoleplayMedieval.MODID + ":" + "bedFrameOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "bedFrameSpruce");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_BIRCH, DarkRoleplayMedieval.MODID + ":" + "bedFrameBirch");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_JUNGLE, DarkRoleplayMedieval.MODID + ":" + "bedFrameJungle");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_ACACIA, DarkRoleplayMedieval.MODID + ":" + "bedFrameAcacia");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BED_FRAME_DARK_OAK, DarkRoleplayMedieval.MODID + ":" + "bedFrameDarkOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bookOne, DarkRoleplayMedieval.MODID + ":" + "blockBookOne");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BUCKET_EMPTY, DarkRoleplayMedieval.MODID + ":" + "blockBucketEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BUCKET_WATER, DarkRoleplayMedieval.MODID + ":" + "blockBucketWater");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BUCKET_DIRT, DarkRoleplayMedieval.MODID + ":" + "blockBucketDirt");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CHAIN, DarkRoleplayMedieval.MODID + ":" + "blockChain");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CLEAN_PLANKS, DarkRoleplayMedieval.MODID + ":" + "cleanPlanks");
		MissingMappings.registerToRemap(DRPMedievalBlocks.HANGING_BRIDGE, DarkRoleplayMedieval.MODID + ":" + "blockHangingBridge");
		MissingMappings.registerToRemap(DRPMedievalBlocks.IRON_HOOK, DarkRoleplayMedieval.MODID + ":" + "blockHook");
		MissingMappings.registerToRemap(DRPMedievalBlocks.KEY_HANGING, DarkRoleplayMedieval.MODID + ":" + "blockKeyHanging");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUG_BEER, DarkRoleplayMedieval.MODID + ":" + "blockMugBeer");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUG_EMPTY, DarkRoleplayMedieval.MODID + ":" + "blockMugEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.ROPE, DarkRoleplayMedieval.MODID + ":" + "blockRope");
		MissingMappings.registerToRemap(DRPMedievalBlocks.ROPE_ANCHOR, DarkRoleplayMedieval.MODID + ":" + "blockRopeAnchor");
		MissingMappings.registerToRemap(DRPMedievalBlocks.SHIPS_HELM, DarkRoleplayMedieval.MODID + ":" + "blockShipsWheel");
		MissingMappings.registerToRemap(DRPMedievalBlocks.SHIPS_HELM, DarkRoleplayMedieval.MODID + ":" + "ShipsWheel");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TARGET, DarkRoleplayMedieval.MODID + ":" + "blockTarget");
//		MissingMappings.registerToRemap(DRPMBlocks.APIARY_OAK, DarkRoleplayMedieval.MODID + ":" + "Apiary");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TORCH_HOLDER_EMPTY, DarkRoleplayMedieval.MODID + ":" + "blockTorchHolderEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TORCH_HOLDER_LIT, DarkRoleplayMedieval.MODID + ":" + "blockTorchHolderLit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.TORCH_HOLDER_UNLIT, DarkRoleplayMedieval.MODID + ":" + "blockTorchHolderUnlit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.APPLE_GREEN, DarkRoleplayMedieval.MODID + ":" + "blockAppleGreen");
		MissingMappings.registerToRemap(DRPMedievalBlocks.APPLE_RED, DarkRoleplayMedieval.MODID + ":" + "blockAppleRed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.APPLE_YELLOW, DarkRoleplayMedieval.MODID + ":" + "blockAppleYellow");
		//MissingMappings.registerToRemap(DRPMedievalBlocks.BARLEY, DarkRoleplayMedieval.MODID + ":" + "blockBarley");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUSHROOM_BROWN, DarkRoleplayMedieval.MODID + ":" + "blockMushroomBrown");
		MissingMappings.registerToRemap(DRPMedievalBlocks.MUSHROOM_RED, DarkRoleplayMedieval.MODID + ":" + "blockMushroomRed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.PEAR_GREEN, DarkRoleplayMedieval.MODID + ":" + "blockPearGreen");
		MissingMappings.registerToRemap(DRPMedievalBlocks.PEAR_YELLOW, DarkRoleplayMedieval.MODID + ":" + "blockPearYellow");
		MissingMappings.registerToRemap(DRPMedievalBlocks.CRATE, DarkRoleplayMedieval.MODID + ":" + "blockCrate");
		MissingMappings.registerToRemap(DRPMedievalBlocks.DUNGEON_CHEST, DarkRoleplayMedieval.MODID + ":" + "blockDungeonChest");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_OAK, DarkRoleplayMedieval.MODID + ":" + "logChairOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "logChairSpruce");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_BIRCH, DarkRoleplayMedieval.MODID + ":" + "logChairBirch");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_JUNGLE, DarkRoleplayMedieval.MODID + ":" + "logChairJungle");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_ACACIA, DarkRoleplayMedieval.MODID + ":" + "logChairAcacia");
		MissingMappings.registerToRemap(DRPMedievalBlocks.LOG_CHAIR_DARK_OAK, DarkRoleplayMedieval.MODID + ":" + "logChairDarkOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.BARREL_CHAIR_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "BarrelChair");
		
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameOak, DarkRoleplayMedieval.MODID + ":" + "bedFrameOak");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameSpruce, DarkRoleplayMedieval.MODID + ":" + "bedFrameSpruce");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameBirch, DarkRoleplayMedieval.MODID + ":" + "bedFrameBirch");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameJungle, DarkRoleplayMedieval.MODID + ":" + "bedFrameJungle");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameAcacia, DarkRoleplayMedieval.MODID + ":" + "bedFrameAcacia");
		MissingMappings.registerToRemap(DRPMedievalItems.BedFrameDarkOak, DarkRoleplayMedieval.MODID + ":" + "bedFrameDarkOak");
		MissingMappings.registerToRemap(DRPMedievalItems.Barley, DarkRoleplayMedieval.MODID + ":" + "itemBarley");
		MissingMappings.registerToRemap(DRPMedievalItems.Turnip, DarkRoleplayMedieval.MODID + ":" + "itemTurnip");
		MissingMappings.registerToRemap(DRPMedievalItems.BronzeCoin, DarkRoleplayMedieval.MODID + ":" + "itemBronzeCoin");
		MissingMappings.registerToRemap(DRPMedievalItems.GoldenCoin, DarkRoleplayMedieval.MODID + ":" + "itemGoldenCoin");
		MissingMappings.registerToRemap(DRPMedievalItems.SilverCoin, DarkRoleplayMedieval.MODID + ":" + "itemSilverCoin");
//		MissingMappings.registerToRemap(DRPMedievalItems.Quiver, DarkRoleplayMedieval.MODID + ":" + "itemQuiver");
//		MissingMappings.registerToRemap(DRPMedievalItems.LeatherPurse, DarkRoleplayMedieval.MODID + ":" + "itemLeatherPurse");
//		MissingMappings.registerToRemap(DRPMedievalItems.BronzeRing, DarkRoleplayMedieval.MODID + ":" + "itemBronzeRing");
//		MissingMappings.registerToRemap(DRPMedievalItems.GoldenRing, DarkRoleplayMedieval.MODID + ":" + "itemGoldenRing");
//		MissingMappings.registerToRemap(DRPMedievalItems.SilverRing, DarkRoleplayMedieval.MODID + ":" + "itemSilverRing");
		MissingMappings.registerToRemap(DRPMedievalItems.AppleGreen, DarkRoleplayMedieval.MODID + ":" + "itemAppleGreen");
		MissingMappings.registerToRemap(DRPMedievalItems.AppleYellow, DarkRoleplayMedieval.MODID + ":" + "itemAppleYellow");
		MissingMappings.registerToRemap(DRPMedievalItems.CatfishCooked, DarkRoleplayMedieval.MODID + ":" + "itemCatfishCooked");
		MissingMappings.registerToRemap(DRPMedievalItems.CatfishRaw, DarkRoleplayMedieval.MODID + ":" + "itemCatfishRaw");
		MissingMappings.registerToRemap(DRPMedievalItems.ChickenStew, DarkRoleplayMedieval.MODID + ":" + "itemChickenStew");
		MissingMappings.registerToRemap(DRPMedievalItems.CodStew, DarkRoleplayMedieval.MODID + ":" + "itemCodStew");
		MissingMappings.registerToRemap(DRPMedievalItems.PearGreen, DarkRoleplayMedieval.MODID + ":" + "itemPearGreen");
		MissingMappings.registerToRemap(DRPMedievalItems.PearYellow, DarkRoleplayMedieval.MODID + ":" + "itemPearYellow");
		MissingMappings.registerToRemap(DRPMedievalItems.PumpkinBread, DarkRoleplayMedieval.MODID + ":" + "itemPumpkinBread");
		MissingMappings.registerToRemap(DRPMedievalItems.PumpkinStew, DarkRoleplayMedieval.MODID + ":" + "itemPumpkinStew");
		MissingMappings.registerToRemap(DRPMedievalItems.VegieStew, DarkRoleplayMedieval.MODID + ":" + "itemVegieStew");
		MissingMappings.registerToRemap(DRPMedievalItems.WolfMeatCooked, DarkRoleplayMedieval.MODID + ":" + "itemWolfMeatCooked");
		MissingMappings.registerToRemap(DRPMedievalItems.WolfMeatRaw, DarkRoleplayMedieval.MODID + ":" + "itemWolfMeatRaw");
		MissingMappings.registerToRemap(DRPMedievalItems.BatEar, DarkRoleplayMedieval.MODID + ":" + "itemBatEar");
		MissingMappings.registerToRemap(DRPMedievalItems.DoughBarley, DarkRoleplayMedieval.MODID + ":" + "itemDoughBarley");
		MissingMappings.registerToRemap(DRPMedievalItems.DoughPumpkin, DarkRoleplayMedieval.MODID + ":" + "itemDoughPumpkin");
		MissingMappings.registerToRemap(DRPMedievalItems.DoughWheat, DarkRoleplayMedieval.MODID + ":" + "itemDoughWheat");
		MissingMappings.registerToRemap(DRPMedievalItems.Firewood, DarkRoleplayMedieval.MODID + ":" + "itemFirewood");
		MissingMappings.registerToRemap(DRPMedievalItems.FlourBarley, DarkRoleplayMedieval.MODID + ":" + "itemFlourBarley");
		MissingMappings.registerToRemap(DRPMedievalItems.FlourWheat, DarkRoleplayMedieval.MODID + ":" + "itemFlourWheat");
		MissingMappings.registerToRemap(DRPMedievalItems.FurWolf, DarkRoleplayMedieval.MODID + ":" + "itemFurWolf");
		MissingMappings.registerToRemap(DRPMedievalItems.TriggerTrap, DarkRoleplayMedieval.MODID + ":" + "itemTriggerTrap");
		//MissingMappings.registerToRemap(DRPMedievalItems.SeedBarley, DarkRoleplayMedieval.MODID + ":" + "itemSeedBarley");
	}

	public void registerTileEntitys() {

		GameRegistry.registerTileEntity(TileEntityAnvil.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityAnvil");
		GameRegistry.registerTileEntity(TileEntityMortar.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityGrindstone");
		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityHangingCauldron");
		GameRegistry.registerTileEntity(TileEntityBookOne.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityBookOne");
		GameRegistry.registerTileEntity(TileEntityCauldron.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityCauldron");
		GameRegistry.registerTileEntity(TileEntityChain.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityChain");
		GameRegistry.registerTileEntity(TileEntityHook.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityHook");
		GameRegistry.registerTileEntity(TileEntityKeyHanging.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityKeyHanging");
		GameRegistry.registerTileEntity(TileEntityShipsWheel.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityShipsWheel");
		GameRegistry.registerTileEntity(TileEntityTarget.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityTarget");
		GameRegistry.registerTileEntity(TileEntityRopeAnchor.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityRopeAnchor");
		GameRegistry.registerTileEntity(TileEntityFirepit.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityFirepit");
        GameRegistry.registerTileEntity(TileEntity_FlowerStorage.class, DarkRoleplayMedieval.MODID + "BucketTileEntity");
        GameRegistry.registerTileEntity(RopeCoilTileEntity.class, DarkRoleplayMedieval.MODID + "rope_coil_tilenentity");

		
		
		// Storage Blocks
		GameRegistry.registerTileEntity(TileEntityCrate.class, DarkRoleplayMedieval.MODID + ":" + "TilEntityCrate");
		GameRegistry.registerTileEntity(TileEntityDungeonChest.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityDungeonChest");
		GameRegistry.registerTileEntity(BedFrameTileEntity.class, "BedFrameTileEntity");
		GameRegistry.registerTileEntity(TileEntity_AdvancedCrop.class, DarkRoleplayMedieval.MODID + ":" + "tile_entity_advanced_crop");
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

		if(item.equals(DRPMedievalItems.Firewood)){ return 800; }

		return 0;
	}
}
