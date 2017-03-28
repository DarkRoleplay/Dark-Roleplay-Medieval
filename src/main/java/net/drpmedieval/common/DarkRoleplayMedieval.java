package net.drpmedieval.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.drpmedieval.common.achievements.DRPMedievalAchievements;
import net.drpmedieval.common.blocks.DRPMBlocks;
import net.drpmedieval.common.blocks.tileentitys.*;
import net.drpmedieval.common.config.DRPMedievalConfig;
import net.drpmedieval.common.crafting.DRPMedievalCrafting;
import net.drpmedieval.common.entity.DRPMedievalEntities;
import net.drpmedieval.common.entity.entitySittable.EntitySittable;
import net.drpmedieval.common.events.AttachCapabilityTileEntity;
import net.drpmedieval.common.events.EventHelper;
import net.drpmedieval.common.events.MissingMappings;
import net.drpmedieval.common.gui.GuiHandler;
import net.drpmedieval.common.items.DRPMItems;
import net.drpmedieval.common.proxy.CommonProxy;
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

		DRPMBlocks.preInit(event);
		DRPMItems.preInit(event);
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

		DRPMBlocks.init(event);
		DRPMItems.init(event);
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
		DRPMBlocks.postInit(event);
		DRPMItems.postInit(event);
		DRPMedievalEntities.postInit(event);
		DRPMedievalConfig.postInit(event);
		DRPMedievalAchievements.postInit(event);
		DRPMedievalCrafting.postInit(event);
		proxy.postInit(event);
		
		LoreHelper.registerItemDesc(DRPMItems.TriggerTrap, new ArrayList<String>(){{add(TextFormatting.WHITE + "Usage:");add(TextFormatting.GRAY + "Apply it to a Torch Holder");add(TextFormatting.GRAY + "and use the Torch Holder as a Lever.");}});
		
		MissingMappings.registerToRemap(DRPMBlocks.ANVIL, DarkRoleplayMedieval.MODID + ":" + "blockAnvil");
		MissingMappings.registerToRemap(DRPMBlocks.CAULDRON, DarkRoleplayMedieval.MODID + ":" + "blockCauldron");
		MissingMappings.registerToRemap(DRPMBlocks.CHOPPING_BLOCK, DarkRoleplayMedieval.MODID + ":" + "blockChoppingBlock");
		MissingMappings.registerToRemap(DRPMBlocks.FIREPIT, DarkRoleplayMedieval.MODID + ":" + "blockFirepit");
		MissingMappings.registerToRemap(DRPMBlocks.GRINDSTONE, DarkRoleplayMedieval.MODID + ":" + "blockGrindstone");
		MissingMappings.registerToRemap(DRPMBlocks.HANGING_CAULDRON, DarkRoleplayMedieval.MODID + ":" + "blockHangingCauldron");
		MissingMappings.registerToRemap(DRPMBlocks.MORTAR, DarkRoleplayMedieval.MODID + ":" + "blockMortar");
		MissingMappings.registerToRemap(DRPMBlocks.BARREL_CLOSED_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "blockBarrelClosed");
		MissingMappings.registerToRemap(DRPMBlocks.BARREL_CLOSED_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "BarrelClosed");
		MissingMappings.registerToRemap(DRPMBlocks.BARREL_EMPTY_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "blockBarrelEmpty");
		MissingMappings.registerToRemap(DRPMBlocks.BARREL_EMPTY_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "BarrelEmpty");
		MissingMappings.registerToRemap(DRPMBlocks.BARREL_GUNPOWDER_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "blockBarrelGunpowder");
		MissingMappings.registerToRemap(DRPMBlocks.BARREL_GUNPOWDER_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "BarrelGunpowder");
		MissingMappings.registerToRemap(DRPMBlocks.BED_FRAME_OAK, DarkRoleplayMedieval.MODID + ":" + "bedFrameOak");
		MissingMappings.registerToRemap(DRPMBlocks.BED_FRAME_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "bedFrameSpruce");
		MissingMappings.registerToRemap(DRPMBlocks.BED_FRAME_BIRCH, DarkRoleplayMedieval.MODID + ":" + "bedFrameBirch");
		MissingMappings.registerToRemap(DRPMBlocks.BED_FRAME_JUNGLE, DarkRoleplayMedieval.MODID + ":" + "bedFrameJungle");
		MissingMappings.registerToRemap(DRPMBlocks.BED_FRAME_ACACIA, DarkRoleplayMedieval.MODID + ":" + "bedFrameAcacia");
		MissingMappings.registerToRemap(DRPMBlocks.BED_FRAME_DARK_OAK, DarkRoleplayMedieval.MODID + ":" + "bedFrameDarkOak");
		MissingMappings.registerToRemap(DRPMBlocks.bookOne, DarkRoleplayMedieval.MODID + ":" + "blockBookOne");
		MissingMappings.registerToRemap(DRPMBlocks.BUCKET_EMPTY, DarkRoleplayMedieval.MODID + ":" + "blockBucketEmpty");
		MissingMappings.registerToRemap(DRPMBlocks.BUCKET_WATER, DarkRoleplayMedieval.MODID + ":" + "blockBucketWater");
		MissingMappings.registerToRemap(DRPMBlocks.BUCKET_DIRT, DarkRoleplayMedieval.MODID + ":" + "blockBucketDirt");
		MissingMappings.registerToRemap(DRPMBlocks.CHAIN, DarkRoleplayMedieval.MODID + ":" + "blockChain");
		MissingMappings.registerToRemap(DRPMBlocks.CLEAN_PLANKS, DarkRoleplayMedieval.MODID + ":" + "cleanPlanks");
		MissingMappings.registerToRemap(DRPMBlocks.HANGING_BRIDGE, DarkRoleplayMedieval.MODID + ":" + "blockHangingBridge");
		MissingMappings.registerToRemap(DRPMBlocks.IRON_HOOK, DarkRoleplayMedieval.MODID + ":" + "blockHook");
		MissingMappings.registerToRemap(DRPMBlocks.KEY_HANGING, DarkRoleplayMedieval.MODID + ":" + "blockKeyHanging");
		MissingMappings.registerToRemap(DRPMBlocks.MUG_BEER, DarkRoleplayMedieval.MODID + ":" + "blockMugBeer");
		MissingMappings.registerToRemap(DRPMBlocks.MUG_EMPTY, DarkRoleplayMedieval.MODID + ":" + "blockMugEmpty");
		MissingMappings.registerToRemap(DRPMBlocks.ROPE, DarkRoleplayMedieval.MODID + ":" + "blockRope");
		MissingMappings.registerToRemap(DRPMBlocks.ROPE_ANCHOR, DarkRoleplayMedieval.MODID + ":" + "blockRopeAnchor");
		MissingMappings.registerToRemap(DRPMBlocks.SHIPS_HELM, DarkRoleplayMedieval.MODID + ":" + "blockShipsWheel");
		MissingMappings.registerToRemap(DRPMBlocks.SHIPS_HELM, DarkRoleplayMedieval.MODID + ":" + "ShipsWheel");
		MissingMappings.registerToRemap(DRPMBlocks.TARGET, DarkRoleplayMedieval.MODID + ":" + "blockTarget");
//		MissingMappings.registerToRemap(DRPMBlocks.APIARY_OAK, DarkRoleplayMedieval.MODID + ":" + "Apiary");
		MissingMappings.registerToRemap(DRPMBlocks.TORCH_HOLDER_EMPTY, DarkRoleplayMedieval.MODID + ":" + "blockTorchHolderEmpty");
		MissingMappings.registerToRemap(DRPMBlocks.TORCH_HOLDER_LIT, DarkRoleplayMedieval.MODID + ":" + "blockTorchHolderLit");
		MissingMappings.registerToRemap(DRPMBlocks.TORCH_HOLDER_UNLIT, DarkRoleplayMedieval.MODID + ":" + "blockTorchHolderUnlit");
		MissingMappings.registerToRemap(DRPMBlocks.APPLE_GREEN, DarkRoleplayMedieval.MODID + ":" + "blockAppleGreen");
		MissingMappings.registerToRemap(DRPMBlocks.APPLE_RED, DarkRoleplayMedieval.MODID + ":" + "blockAppleRed");
		MissingMappings.registerToRemap(DRPMBlocks.APPLE_YELLOW, DarkRoleplayMedieval.MODID + ":" + "blockAppleYellow");
		//MissingMappings.registerToRemap(DRPMedievalBlocks.BARLEY, DarkRoleplayMedieval.MODID + ":" + "blockBarley");
		MissingMappings.registerToRemap(DRPMBlocks.MUSHROOM_BROWN, DarkRoleplayMedieval.MODID + ":" + "blockMushroomBrown");
		MissingMappings.registerToRemap(DRPMBlocks.MUSHROOM_RED, DarkRoleplayMedieval.MODID + ":" + "blockMushroomRed");
		MissingMappings.registerToRemap(DRPMBlocks.PEAR_GREEN, DarkRoleplayMedieval.MODID + ":" + "blockPearGreen");
		MissingMappings.registerToRemap(DRPMBlocks.PEAR_YELLOW, DarkRoleplayMedieval.MODID + ":" + "blockPearYellow");
		MissingMappings.registerToRemap(DRPMBlocks.CRATE, DarkRoleplayMedieval.MODID + ":" + "blockCrate");
		MissingMappings.registerToRemap(DRPMBlocks.DUNGEON_CHEST, DarkRoleplayMedieval.MODID + ":" + "blockDungeonChest");
		MissingMappings.registerToRemap(DRPMBlocks.LOG_CHAIR_OAK, DarkRoleplayMedieval.MODID + ":" + "logChairOak");
		MissingMappings.registerToRemap(DRPMBlocks.LOG_CHAIR_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "logChairSpruce");
		MissingMappings.registerToRemap(DRPMBlocks.LOG_CHAIR_BIRCH, DarkRoleplayMedieval.MODID + ":" + "logChairBirch");
		MissingMappings.registerToRemap(DRPMBlocks.LOG_CHAIR_JUNGLE, DarkRoleplayMedieval.MODID + ":" + "logChairJungle");
		MissingMappings.registerToRemap(DRPMBlocks.LOG_CHAIR_ACACIA, DarkRoleplayMedieval.MODID + ":" + "logChairAcacia");
		MissingMappings.registerToRemap(DRPMBlocks.LOG_CHAIR_DARK_OAK, DarkRoleplayMedieval.MODID + ":" + "logChairDarkOak");
		MissingMappings.registerToRemap(DRPMBlocks.BARREL_CHAIR_SPRUCE, DarkRoleplayMedieval.MODID + ":" + "BarrelChair");
		
		MissingMappings.registerToRemap(DRPMItems.BedFrameOak, DarkRoleplayMedieval.MODID + ":" + "bedFrameOak");
		MissingMappings.registerToRemap(DRPMItems.BedFrameSpruce, DarkRoleplayMedieval.MODID + ":" + "bedFrameSpruce");
		MissingMappings.registerToRemap(DRPMItems.BedFrameBirch, DarkRoleplayMedieval.MODID + ":" + "bedFrameBirch");
		MissingMappings.registerToRemap(DRPMItems.BedFrameJungle, DarkRoleplayMedieval.MODID + ":" + "bedFrameJungle");
		MissingMappings.registerToRemap(DRPMItems.BedFrameAcacia, DarkRoleplayMedieval.MODID + ":" + "bedFrameAcacia");
		MissingMappings.registerToRemap(DRPMItems.BedFrameDarkOak, DarkRoleplayMedieval.MODID + ":" + "bedFrameDarkOak");
		MissingMappings.registerToRemap(DRPMItems.Barley, DarkRoleplayMedieval.MODID + ":" + "itemBarley");
		MissingMappings.registerToRemap(DRPMItems.Turnip, DarkRoleplayMedieval.MODID + ":" + "itemTurnip");
		MissingMappings.registerToRemap(DRPMItems.BronzeCoin, DarkRoleplayMedieval.MODID + ":" + "itemBronzeCoin");
		MissingMappings.registerToRemap(DRPMItems.GoldenCoin, DarkRoleplayMedieval.MODID + ":" + "itemGoldenCoin");
		MissingMappings.registerToRemap(DRPMItems.SilverCoin, DarkRoleplayMedieval.MODID + ":" + "itemSilverCoin");
//		MissingMappings.registerToRemap(DRPMedievalItems.Quiver, DarkRoleplayMedieval.MODID + ":" + "itemQuiver");
//		MissingMappings.registerToRemap(DRPMedievalItems.LeatherPurse, DarkRoleplayMedieval.MODID + ":" + "itemLeatherPurse");
//		MissingMappings.registerToRemap(DRPMedievalItems.BronzeRing, DarkRoleplayMedieval.MODID + ":" + "itemBronzeRing");
//		MissingMappings.registerToRemap(DRPMedievalItems.GoldenRing, DarkRoleplayMedieval.MODID + ":" + "itemGoldenRing");
//		MissingMappings.registerToRemap(DRPMedievalItems.SilverRing, DarkRoleplayMedieval.MODID + ":" + "itemSilverRing");
		MissingMappings.registerToRemap(DRPMItems.AppleGreen, DarkRoleplayMedieval.MODID + ":" + "itemAppleGreen");
		MissingMappings.registerToRemap(DRPMItems.AppleYellow, DarkRoleplayMedieval.MODID + ":" + "itemAppleYellow");
		MissingMappings.registerToRemap(DRPMItems.CatfishCooked, DarkRoleplayMedieval.MODID + ":" + "itemCatfishCooked");
		MissingMappings.registerToRemap(DRPMItems.CatfishRaw, DarkRoleplayMedieval.MODID + ":" + "itemCatfishRaw");
		MissingMappings.registerToRemap(DRPMItems.ChickenStew, DarkRoleplayMedieval.MODID + ":" + "itemChickenStew");
		MissingMappings.registerToRemap(DRPMItems.CodStew, DarkRoleplayMedieval.MODID + ":" + "itemCodStew");
		MissingMappings.registerToRemap(DRPMItems.PearGreen, DarkRoleplayMedieval.MODID + ":" + "itemPearGreen");
		MissingMappings.registerToRemap(DRPMItems.PearYellow, DarkRoleplayMedieval.MODID + ":" + "itemPearYellow");
		MissingMappings.registerToRemap(DRPMItems.PumpkinBread, DarkRoleplayMedieval.MODID + ":" + "itemPumpkinBread");
		MissingMappings.registerToRemap(DRPMItems.PumpkinStew, DarkRoleplayMedieval.MODID + ":" + "itemPumpkinStew");
		MissingMappings.registerToRemap(DRPMItems.VegieStew, DarkRoleplayMedieval.MODID + ":" + "itemVegieStew");
		MissingMappings.registerToRemap(DRPMItems.WolfMeatCooked, DarkRoleplayMedieval.MODID + ":" + "itemWolfMeatCooked");
		MissingMappings.registerToRemap(DRPMItems.WolfMeatRaw, DarkRoleplayMedieval.MODID + ":" + "itemWolfMeatRaw");
		MissingMappings.registerToRemap(DRPMItems.BatEar, DarkRoleplayMedieval.MODID + ":" + "itemBatEar");
		MissingMappings.registerToRemap(DRPMItems.DoughBarley, DarkRoleplayMedieval.MODID + ":" + "itemDoughBarley");
		MissingMappings.registerToRemap(DRPMItems.DoughPumpkin, DarkRoleplayMedieval.MODID + ":" + "itemDoughPumpkin");
		MissingMappings.registerToRemap(DRPMItems.DoughWheat, DarkRoleplayMedieval.MODID + ":" + "itemDoughWheat");
		MissingMappings.registerToRemap(DRPMItems.Firewood, DarkRoleplayMedieval.MODID + ":" + "itemFirewood");
		MissingMappings.registerToRemap(DRPMItems.FlourBarley, DarkRoleplayMedieval.MODID + ":" + "itemFlourBarley");
		MissingMappings.registerToRemap(DRPMItems.FlourWheat, DarkRoleplayMedieval.MODID + ":" + "itemFlourWheat");
		MissingMappings.registerToRemap(DRPMItems.FurWolf, DarkRoleplayMedieval.MODID + ":" + "itemFurWolf");
		MissingMappings.registerToRemap(DRPMItems.TriggerTrap, DarkRoleplayMedieval.MODID + ":" + "itemTriggerTrap");
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
        GameRegistry.registerTileEntity(BucketTileEntity.class, DarkRoleplayMedieval.MODID + "BucketTileEntity");
        GameRegistry.registerTileEntity(RopeCoilTileEntity.class, DarkRoleplayMedieval.MODID + "rope_coil_tilenentity");

		
		
		// Storage Blocks
		GameRegistry.registerTileEntity(TileEntityCrate.class, DarkRoleplayMedieval.MODID + ":" + "TilEntityCrate");
		GameRegistry.registerTileEntity(TileEntityDungeonChest.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityDungeonChest");
		GameRegistry.registerTileEntity(BedFrameTileEntity.class, "BedFrameTileEntity");
	}

	public void registerFurnaceRecipes() {

		GameRegistry.addSmelting(DRPMItems.DoughWheat, new ItemStack(Items.BREAD), 0.1f);
		GameRegistry.addSmelting(DRPMItems.DoughBarley, new ItemStack(Items.BREAD), 0.1f);
		GameRegistry.addSmelting(DRPMItems.WolfMeatRaw, new ItemStack(DRPMItems.WolfMeatCooked), 0.1f);
		GameRegistry.addSmelting(DRPMItems.DoughPumpkin, new ItemStack(DRPMItems.PumpkinBread), 0.1f);
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

		if(item.equals(DRPMItems.Firewood)){ return 800; }

		return 0;
	}
}
