package net.drpmedieval.common;

import java.util.ArrayList;
import java.util.List;

import net.drpmedieval.common.achievements.DRPMedievalAchievements;
import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.tileentitys.*;
import net.drpmedieval.common.config.DRPMedievalConfig;
import net.drpmedieval.common.crafting.DRPMedievalCrafting;
import net.drpmedieval.common.entity.DRPMedievalEntities;
import net.drpmedieval.common.entity.entitySittable.EntitySittable;
import net.drpmedieval.common.events.AttachCapabilityTileEntity;
import net.drpmedieval.common.events.EventHelper;
import net.drpmedieval.common.events.MissingMappings;
import net.drpmedieval.common.gui.GuiHandler;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.drpmedieval.common.proxy.CommonProxy;
import net.drpmedieval.common.util.LoreHelper;
import net.drpmedieval.common.worldgen.GenerateStructure;
import net.drpmedieval.common.worldgen.WorldLoot;
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
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = DarkRoleplayMedieval.MODID, version = DarkRoleplayMedieval.VERSION, name = DarkRoleplayMedieval.NAME, acceptedMinecraftVersions = DarkRoleplayMedieval.ACCEPTEDVERSIONS, dependencies = DarkRoleplayMedieval.DEPENDECIES, updateJSON = DarkRoleplayMedieval.UPDATECHECK)
public class DarkRoleplayMedieval {

	public static final String NAME = "Dark Roleplay Medieval";
	public static final String VERSION = "0.1.5";
	public static final String MODID = "drpmedieval";
	public static final String ACCEPTEDVERSIONS = "[1.9.4,)";
	public static final String DEPENDECIES = "required-after:drpcore@0.1.4b,)";
	public static final String UPDATECHECK = "https://raw.githubusercontent.com/DarkRoleplay/Dark-Roleplay-Medieval/master/DarkRoleplayMedieval.json";
	
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
		DRPMedievalCrafting.preInit(event);
		proxy.preInit(event);
		
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
		DRPMedievalCrafting.init(event);
		proxy.init(event);
		
		WorldLoot.registerChestLoot();
		WorldLoot.registerFishingLoot();
		WorldLoot.registerGrassLoot();

		EventHelper.registerEvents();
		
		registerTileEntitys();
		
		registerFurnaceRecipes();

		MinecraftForge.EVENT_BUS.register(new AttachCapabilityTileEntity());
		
		GameRegistry.registerWorldGenerator(new GenerateStructure(), -5);

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
		
		MissingMappings.registerToRemap(DRPMedievalBlocks.anvil, DarkRoleplayMedieval.MODID + ":" + "blockAnvil");
		MissingMappings.registerToRemap(DRPMedievalBlocks.cauldron, DarkRoleplayMedieval.MODID + ":" + "blockCauldron");
		MissingMappings.registerToRemap(DRPMedievalBlocks.choppingBlock, DarkRoleplayMedieval.MODID + ":" + "blockChoppingBlock");
		MissingMappings.registerToRemap(DRPMedievalBlocks.firepit, DarkRoleplayMedieval.MODID + ":" + "blockFirepit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.grindstone, DarkRoleplayMedieval.MODID + ":" + "blockGrindstone");
		MissingMappings.registerToRemap(DRPMedievalBlocks.hangingCauldron, DarkRoleplayMedieval.MODID + ":" + "blockHangingCauldron");
		MissingMappings.registerToRemap(DRPMedievalBlocks.mortar, DarkRoleplayMedieval.MODID + ":" + "blockMortar");
		MissingMappings.registerToRemap(DRPMedievalBlocks.barrelClosed, DarkRoleplayMedieval.MODID + ":" + "blockBarrelClosed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.barrelEmpty, DarkRoleplayMedieval.MODID + ":" + "blockBarrelEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.barrelGunpowder, DarkRoleplayMedieval.MODID + ":" + "blockBarrelGunpowder");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bedFrameOak, DarkRoleplayMedieval.MODID + ":" + "bedFrameOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bedFrameSpruce, DarkRoleplayMedieval.MODID + ":" + "bedFrameSpruce");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bedFrameBirch, DarkRoleplayMedieval.MODID + ":" + "bedFrameBirch");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bedFrameJungle, DarkRoleplayMedieval.MODID + ":" + "bedFrameJungle");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bedFrameAcacia, DarkRoleplayMedieval.MODID + ":" + "bedFrameAcacia");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bedFrameDarkOak, DarkRoleplayMedieval.MODID + ":" + "bedFrameDarkOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bookOne, DarkRoleplayMedieval.MODID + ":" + "blockBookOne");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bucketEmpty, DarkRoleplayMedieval.MODID + ":" + "blockBucketEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bucketWater, DarkRoleplayMedieval.MODID + ":" + "blockBucketWater");
		MissingMappings.registerToRemap(DRPMedievalBlocks.bucketDirt, DarkRoleplayMedieval.MODID + ":" + "blockBucketDirt");
		MissingMappings.registerToRemap(DRPMedievalBlocks.chain, DarkRoleplayMedieval.MODID + ":" + "blockChain");
		MissingMappings.registerToRemap(DRPMedievalBlocks.cleanPlanks, DarkRoleplayMedieval.MODID + ":" + "cleanPlanks");
		MissingMappings.registerToRemap(DRPMedievalBlocks.hangingBridge, DarkRoleplayMedieval.MODID + ":" + "blockHangingBridge");
		MissingMappings.registerToRemap(DRPMedievalBlocks.ironHook, DarkRoleplayMedieval.MODID + ":" + "blockHook");
		MissingMappings.registerToRemap(DRPMedievalBlocks.keyHanging, DarkRoleplayMedieval.MODID + ":" + "blockKeyHanging");
		MissingMappings.registerToRemap(DRPMedievalBlocks.mugBeer, DarkRoleplayMedieval.MODID + ":" + "blockMugBeer");
		MissingMappings.registerToRemap(DRPMedievalBlocks.mugEmpty, DarkRoleplayMedieval.MODID + ":" + "blockMugEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.rope, DarkRoleplayMedieval.MODID + ":" + "blockRope");
		MissingMappings.registerToRemap(DRPMedievalBlocks.ropeAnchor, DarkRoleplayMedieval.MODID + ":" + "blockRopeAnchor");
		MissingMappings.registerToRemap(DRPMedievalBlocks.shipsWheel, DarkRoleplayMedieval.MODID + ":" + "blockShipsWheel");
		MissingMappings.registerToRemap(DRPMedievalBlocks.target, DarkRoleplayMedieval.MODID + ":" + "blockTarget");
		MissingMappings.registerToRemap(DRPMedievalBlocks.torchHolderEmpty, DarkRoleplayMedieval.MODID + ":" + "blockTorchHolderEmpty");
		MissingMappings.registerToRemap(DRPMedievalBlocks.torchHolderLit, DarkRoleplayMedieval.MODID + ":" + "blockTorchHolderLit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.torchHolderUnlit, DarkRoleplayMedieval.MODID + ":" + "blockTorchHolderUnlit");
		MissingMappings.registerToRemap(DRPMedievalBlocks.appleGreen, DarkRoleplayMedieval.MODID + ":" + "blockAppleGreen");
		MissingMappings.registerToRemap(DRPMedievalBlocks.appleRed, DarkRoleplayMedieval.MODID + ":" + "blockAppleRed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.appleYellow, DarkRoleplayMedieval.MODID + ":" + "blockAppleYellow");
		MissingMappings.registerToRemap(DRPMedievalBlocks.barley, DarkRoleplayMedieval.MODID + ":" + "blockBarley");
		MissingMappings.registerToRemap(DRPMedievalBlocks.mushroomBrown, DarkRoleplayMedieval.MODID + ":" + "blockMushroomBrown");
		MissingMappings.registerToRemap(DRPMedievalBlocks.mushroomRed, DarkRoleplayMedieval.MODID + ":" + "blockMushroomRed");
		MissingMappings.registerToRemap(DRPMedievalBlocks.pearGreen, DarkRoleplayMedieval.MODID + ":" + "blockPearGreen");
		MissingMappings.registerToRemap(DRPMedievalBlocks.pearYellow, DarkRoleplayMedieval.MODID + ":" + "blockPearYellow");
		MissingMappings.registerToRemap(DRPMedievalBlocks.crate, DarkRoleplayMedieval.MODID + ":" + "blockCrate");
		MissingMappings.registerToRemap(DRPMedievalBlocks.dungeonChest, DarkRoleplayMedieval.MODID + ":" + "blockDungeonChest");
		MissingMappings.registerToRemap(DRPMedievalBlocks.logChairOak, DarkRoleplayMedieval.MODID + ":" + "logChairOak");
		MissingMappings.registerToRemap(DRPMedievalBlocks.logChairSpruce, DarkRoleplayMedieval.MODID + ":" + "logChairSpruce");
		MissingMappings.registerToRemap(DRPMedievalBlocks.logChairBirch, DarkRoleplayMedieval.MODID + ":" + "logChairBirch");
		MissingMappings.registerToRemap(DRPMedievalBlocks.logChairJungle, DarkRoleplayMedieval.MODID + ":" + "logChairJungle");
		MissingMappings.registerToRemap(DRPMedievalBlocks.logChairAcacia, DarkRoleplayMedieval.MODID + ":" + "logChairAcacia");
		MissingMappings.registerToRemap(DRPMedievalBlocks.logChairDarkOak, DarkRoleplayMedieval.MODID + ":" + "logChairDarkOak");
		
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
		MissingMappings.registerToRemap(DRPMedievalItems.Quiver, DarkRoleplayMedieval.MODID + ":" + "itemQuiver");
		MissingMappings.registerToRemap(DRPMedievalItems.LeatherPurse, DarkRoleplayMedieval.MODID + ":" + "itemLeatherPurse");
		MissingMappings.registerToRemap(DRPMedievalItems.BronzeRing, DarkRoleplayMedieval.MODID + ":" + "itemBronzeRing");
		MissingMappings.registerToRemap(DRPMedievalItems.GoldenRing, DarkRoleplayMedieval.MODID + ":" + "itemGoldenRing");
		MissingMappings.registerToRemap(DRPMedievalItems.SilverRing, DarkRoleplayMedieval.MODID + ":" + "itemSilverRing");
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
		MissingMappings.registerToRemap(DRPMedievalItems.SeedBarley, DarkRoleplayMedieval.MODID + ":" + "itemSeedBarley");



	}

	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {

		EntityRegistry.registerModEntity(entityClass, entityName, 0, DarkRoleplayMedieval.instance, 64, 5, false, solidColor, spotColor);
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

		// Storage Blocks
		GameRegistry.registerTileEntity(TileEntityCrate.class, DarkRoleplayMedieval.MODID + ":" + "TilEntityCrate");
		GameRegistry.registerTileEntity(TileEntityDungeonChest.class, DarkRoleplayMedieval.MODID + ":" + "TileEntityDungeonChest");
		GameRegistry.registerTileEntity(BedFrameTileEntity.class, "BedFrameTileEntity");
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
