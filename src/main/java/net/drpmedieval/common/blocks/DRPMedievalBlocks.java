package net.drpmedieval.common.blocks;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.craftingstations.*;
import net.drpmedieval.common.blocks.decorative.*;
import net.drpmedieval.common.blocks.decorative.apiaries.Apiary;
import net.drpmedieval.common.blocks.decorative.barrelChair.BarrelChair;
import net.drpmedieval.common.blocks.decorative.barrels.BarrelClosed;
import net.drpmedieval.common.blocks.decorative.barrels.BarrelEmpty;
import net.drpmedieval.common.blocks.decorative.barrels.BarrelFilled;
import net.drpmedieval.common.blocks.decorative.buckets.Bucket;
import net.drpmedieval.common.blocks.decorative.buckets.BucketDirt;
import net.drpmedieval.common.blocks.decorative.simpleChairs.SimpleChair;
import net.drpmedieval.common.blocks.decorative.simpleTables.SimpleTable;
import net.drpmedieval.common.blocks.other.RegeneratingOre;
import net.drpmedieval.common.blocks.plants.*;
import net.drpmedieval.common.blocks.storage.*;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.drpmedieval.common.items.seeds.SeedBarley;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DRPMedievalBlocks {
	
	/** A **/

	public static Anvil ANVIL = new Anvil();
	public static Apiary APIARY_OAK = new Apiary("ApiaryOak");
	public static Apiary APIARY_BIRCH = new Apiary("ApiaryBirch");
	public static Apiary APIARY_SPRUCE = new Apiary("ApiarySpruce");
	public static Apiary APIARY_JUNGLE = new Apiary("ApiaryJungle");
	public static Apiary APIARY_ACACIA = new Apiary("ApiaryAcacia");
	public static Apiary APIARY_DARK_OAK = new Apiary("ApiaryDarkOak");

	public static AppleGreen APPLE_GREEN = new AppleGreen(); //TODO FIX APPLES
	public static AppleRed APPLE_RED = new AppleRed();
	public static AppleYellow APPLE_YELLOW = new AppleYellow();

	/** B **/

	public static Barley BARLEY = new Barley();
	
	public static BarrelChair BARREL_CHAIR_OAK = new BarrelChair("BarrelChairOak");
	public static BarrelChair BARREL_CHAIR_BIRCH = new BarrelChair("BarrelChairBirch");
	public static BarrelChair BARREL_CHAIR_SPRUCE = new BarrelChair("BarrelChairSpruce");
	public static BarrelChair BARREL_CHAIR_JUNGLE = new BarrelChair("BarrelChairJungle");
	public static BarrelChair BARREL_CHAIR_ACACIA = new BarrelChair("BarrelChairAcacia");
	public static BarrelChair BARREL_CHAIR_DARK_OAK = new BarrelChair("BarrelChairDarkOak");
	//public static BarrelClosed BARREL_CLOSED = new BarrelClosed();
	
	public static BarrelEmpty BARREL_EMPTY_OAK = new BarrelEmpty("BarrelEmptyOak");
	public static BarrelEmpty BARREL_EMPTY_BIRCH = new BarrelEmpty("BarrelEmptyBirch");
	public static BarrelEmpty BARREL_EMPTY_SPRUCE = new BarrelEmpty("BarrelEmptySpruce");
	public static BarrelEmpty BARREL_EMPTY_JUNGLE = new BarrelEmpty("BarrelEmptyJungle");
	public static BarrelEmpty BARREL_EMPTY_ACACIA = new BarrelEmpty("BarrelEmptyAcacia");
	public static BarrelEmpty BARREL_EMPTY_DARK_OAK = new BarrelEmpty("BarrelEmptyDarkOak");
	
	public static BarrelFilled BARREL_WATER_OAK = new BarrelFilled("BarrelWaterOak");
	public static BarrelFilled BARREL_WATER_BIRCH = new BarrelFilled("BarrelWaterBirch");
	public static BarrelFilled BARREL_WATER_SPRUCE = new BarrelFilled("BarrelWaterSpruce");
	public static BarrelFilled BARREL_WATER_JUNGLE = new BarrelFilled("BarrelWaterJungle");
	public static BarrelFilled BARREL_WATER_ACACIA = new BarrelFilled("BarrelWaterAcacia");
	public static BarrelFilled BARREL_WATER_DARK_OAK = new BarrelFilled("BarrelWaterDarkOak");
	
	public static BarrelClosed BARREL_CLOSED_OAK = new BarrelClosed("BarrelClosedOak");
	public static BarrelClosed BARREL_CLOSED_BIRCH = new BarrelClosed("BarrelClosedBirch");
	public static BarrelClosed BARREL_CLOSED_SPRUCE = new BarrelClosed("BarrelClosedSpruce");
	public static BarrelClosed BARREL_CLOSED_JUNGLE = new BarrelClosed("BarrelClosedJungle");
	public static BarrelClosed BARREL_CLOSED_ACACIA = new BarrelClosed("BarrelClosedAcacia");
	public static BarrelClosed BARREL_CLOSED_DARK_OAK = new BarrelClosed("BarrelClosedDarkOak");
	
	public static BarrelFilled BARREL_GUNPOWDER_OAK = new BarrelFilled("BarrelGunpowderOak");
	public static BarrelFilled BARREL_GUNPOWDER_BIRCH = new BarrelFilled("BarrelGunpowderBirch");
	public static BarrelFilled BARREL_GUNPOWDER_SPRUCE = new BarrelFilled("BarrelGunpowderSpruce");
	public static BarrelFilled BARREL_GUNPOWDER_JUNGLE = new BarrelFilled("BarrelGunpowderJungle");
	public static BarrelFilled BARREL_GUNPOWDER_ACACIA = new BarrelFilled("BarrelGunpowderAcacia");
	public static BarrelFilled BARREL_GUNPOWDER_DARK_OAK = new BarrelFilled("BarrelGunpowderDarkOak");
		
	public static BedFrame BED_FRAME_OAK = new BedFrame("BedFrameOak","BedFrameOak",DRPMedievalItems.BedFrameOak);
	public static BedFrame BED_FRAME_SPRUCE = new BedFrame("BedFrameSpruce","BedFrameSpruce",DRPMedievalItems.BedFrameSpruce);
	public static BedFrame BED_FRAME_BIRCH = new BedFrame("BedFrameBirch","BedFrameBirch",DRPMedievalItems.BedFrameBirch);
	public static BedFrame BED_FRAME_JUNGLE = new BedFrame("BedFrameJungle","BedFrameJungle",DRPMedievalItems.BedFrameJungle);
	public static BedFrame BED_FRAME_ACACIA = new BedFrame("BedFrameAcacia","BedFrameAcacia",DRPMedievalItems.BedFrameAcacia);
	public static BedFrame BED_FRAME_DARK_OAK = new BedFrame("BedFrameDarkOak","BedFrameDarkOak",DRPMedievalItems.BedFrameDarkOak);

	public static BookOne bookOne = new BookOne();
	public static BucketDirt BUCKET_DIRT = new BucketDirt();
	public static Bucket BUCKET_EMPTY = new Bucket("BucketEmpty", "BucketEmpty");
	public static Bucket BUCKET_WATER = new Bucket("BucketWater", "BucketWater");

	/** C **/

	public static Cauldron CAULDRON = new Cauldron();
	public static Chain CHAIN = new Chain();
	public static ChoppingBlock CHOPPING_BLOCK = new ChoppingBlock();
	public static CleanPlanks CLEAN_PLANKS = new CleanPlanks();
	public static Crate CRATE = new Crate();

	/** D **/

	public static DungeonChest DUNGEON_CHEST = new DungeonChest();

	/** E **/

	/** F **/

	public static Firepit FIREPIT = new Firepit();

	/** G **/

	public static GoldenShipsBell GOLDEN_SHIPS_BELL = new GoldenShipsBell();
	public static Grindstone GRINDSTONE = new Grindstone();

	/** H **/

	public static HangingBridge HANGING_BRIDGE = new HangingBridge();
	public static HangingCauldron HANGING_CAULDRON = new HangingCauldron();

	/** I **/
	public static Hook IRON_HOOK = new Hook();
	
	/** J **/

	/** K **/

	public static KeyHanging KEY_HANGING = new KeyHanging();

	/** L **/

	public static LogChair LOG_CHAIR_OAK = new LogChair("LogChairOak","LogChairOak");
	public static LogChair LOG_CHAIR_SPRUCE = new LogChair("LogChairSpruce","LogChairSpruce");
	public static LogChair LOG_CHAIR_BIRCH = new LogChair("LogChairBirch","LogChairBirch");
	public static LogChair LOG_CHAIR_JUNGLE = new LogChair("LogChairJungle","LogChairJungle");
	public static LogChair LOG_CHAIR_ACACIA = new LogChair("LogChairAcacia","LogChairAcacia");
	public static LogChair LOG_CHAIR_DARK_OAK = new LogChair("LogChairDarkOak","LogChairDarkOak");

	
	/** M **/

	public static Mortar MORTAR = new Mortar();
	public static MugBeer MUG_BEER = new MugBeer();
	public static MugEmpty MUG_EMPTY = new MugEmpty();
	public static MushroomBrown MUSHROOM_BROWN = new MushroomBrown();
	public static MushroomRed MUSHROOM_RED = new MushroomRed();

	/** N **/

	/** O **/

	/** P **/

	public static PearGreen PEAR_GREEN = new PearGreen(); //TODO FIX PEARS
	public static PearYellow PEAR_YELLOW = new PearYellow();
	public static PotionEmpty POTION_EMPTY = new PotionEmpty(); //TODO Fix Potions

	/** Q **/

	/** R **/

	public static RegeneratingOre rgO = new RegeneratingOre("regenOre", DRPMedievalCreativeTabs.drpmedievalMiscTab, 0.4F, 5); //TODO REGENERATING ORES
	public static Rope ROPE = new Rope();
	public static RopeAnchor ROPE_ANCHOR = new RopeAnchor();

	/** S **/

	public static SimpleChair SIMPLE_CHAIR_OAK = new SimpleChair("SimpleChairOak");
	public static SimpleChair SIMPLE_CHAIR_BIRCH = new SimpleChair("SimpleChairBirch");
	public static SimpleChair SIMPLE_CHAIR_SPRUCE = new SimpleChair("SimpleChairSpruce");
	public static SimpleChair SIMPLE_CHAIR_JUNGLE = new SimpleChair("SimpleChairJungle");
	public static SimpleChair SIMPLE_CHAIR_ACACIA = new SimpleChair("SimpleChairAcacia");
	public static SimpleChair SIMPLE_CHAIR_DARK_OAK = new SimpleChair("SimpleChairDarkOak");
	
	public static SimpleTable SIMPLE_TABLE_OAK = new SimpleTable("SimpleTableOak");
	public static SimpleTable SIMPLE_TABLE_BIRCH = new SimpleTable("SimpleTableBirch");
	public static SimpleTable SIMPLE_TABLE_SPRUCE = new SimpleTable("SimpleTableSpruce");
	public static SimpleTable SIMPLE_TABLE_JUNGLE = new SimpleTable("SimpleTableJungle");
	public static SimpleTable SIMPLE_TABLE_ACACIA = new SimpleTable("SimpleTableAcacia");
	public static SimpleTable SIMPLE_TABLE_DARK_OAK = new SimpleTable("SimpleTableDarkOak");
	
	public static ShipsHelm SHIPS_HELM = new ShipsHelm();

	/** T **/

	public static Target TARGET = new Target();
	public static TorchHolderEmpty TORCH_HOLDER_EMPTY = new TorchHolderEmpty();
	public static TorchHolderLit TORCH_HOLDER_LIT = new TorchHolderLit();
	public static TorchHolderUnlit TORCH_HOLDER_UNLIT = new TorchHolderUnlit();

	/** U **/

	/** V **/

	/** W **/

	/** X **/

	/** Y **/

	/** Z **/

	public static void preInit(FMLPreInitializationEvent event) {
		//registerBlock(rgO);
		
		registerBlock(SIMPLE_CHAIR_OAK);
		registerBlock(SIMPLE_CHAIR_BIRCH, false);
		registerBlock(SIMPLE_CHAIR_SPRUCE, false);
		registerBlock(SIMPLE_CHAIR_JUNGLE, false);
		registerBlock(SIMPLE_CHAIR_ACACIA, false);
		registerBlock(SIMPLE_CHAIR_DARK_OAK, false);
		
		registerBlock(SIMPLE_TABLE_OAK, false);
		registerBlock(SIMPLE_TABLE_BIRCH, false);
		registerBlock(SIMPLE_TABLE_SPRUCE, false);
		registerBlock(SIMPLE_TABLE_JUNGLE, false);
		registerBlock(SIMPLE_TABLE_ACACIA, false);
		registerBlock(SIMPLE_TABLE_DARK_OAK, false);
		
		registerBlock(BARREL_EMPTY_OAK);
		registerBlock(BARREL_EMPTY_BIRCH);
		registerBlock(BARREL_EMPTY_SPRUCE);
		registerBlock(BARREL_EMPTY_JUNGLE);
		registerBlock(BARREL_EMPTY_ACACIA);
		registerBlock(BARREL_EMPTY_DARK_OAK);
		
		registerBlock(BARREL_WATER_OAK);
		registerBlock(BARREL_WATER_BIRCH);
		registerBlock(BARREL_WATER_SPRUCE);
		registerBlock(BARREL_WATER_JUNGLE);
		registerBlock(BARREL_WATER_ACACIA);
		registerBlock(BARREL_WATER_DARK_OAK);
		
		registerBlock(BARREL_CLOSED_OAK);
		registerBlock(BARREL_CLOSED_BIRCH);
		registerBlock(BARREL_CLOSED_SPRUCE);
		registerBlock(BARREL_CLOSED_JUNGLE);
		registerBlock(BARREL_CLOSED_ACACIA);
		registerBlock(BARREL_CLOSED_DARK_OAK);
		
		registerBlock(BARREL_GUNPOWDER_OAK);
		registerBlock(BARREL_GUNPOWDER_BIRCH);
		registerBlock(BARREL_GUNPOWDER_SPRUCE);
		registerBlock(BARREL_GUNPOWDER_JUNGLE);
		registerBlock(BARREL_GUNPOWDER_ACACIA);
		registerBlock(BARREL_GUNPOWDER_DARK_OAK);
		
		registerBlock(BED_FRAME_OAK, null);
		registerBlock(BED_FRAME_BIRCH, null);
		registerBlock(BED_FRAME_SPRUCE, null);
		registerBlock(BED_FRAME_JUNGLE, null);
		registerBlock(BED_FRAME_ACACIA, null);
		registerBlock(BED_FRAME_DARK_OAK, null);
		
		registerBlock(APIARY_OAK);
		registerBlock(APIARY_BIRCH);
		registerBlock(APIARY_SPRUCE);
		registerBlock(APIARY_JUNGLE);
		registerBlock(APIARY_ACACIA);
		registerBlock(APIARY_DARK_OAK);
		
		registerBlock(BARREL_CHAIR_OAK);
		registerBlock(BARREL_CHAIR_BIRCH);
		registerBlock(BARREL_CHAIR_SPRUCE);
		registerBlock(BARREL_CHAIR_JUNGLE);
		registerBlock(BARREL_CHAIR_ACACIA);
		registerBlock(BARREL_CHAIR_DARK_OAK);
		
		registerBlock(LOG_CHAIR_OAK);
		registerBlock(LOG_CHAIR_BIRCH);
		registerBlock(LOG_CHAIR_SPRUCE);
		registerBlock(LOG_CHAIR_JUNGLE);
		registerBlock(LOG_CHAIR_ACACIA);
		registerBlock(LOG_CHAIR_DARK_OAK);
		
		registerBlock(CLEAN_PLANKS);
		
		registerBlock(CHOPPING_BLOCK);
		registerBlock(APPLE_RED, null);
		registerBlock(APPLE_YELLOW, null);
		registerBlock(APPLE_GREEN, null);
		registerBlock(PEAR_YELLOW, null);
		registerBlock(PEAR_GREEN, null);
		registerBlock(MUSHROOM_BROWN);
		registerBlock(MUSHROOM_RED);
		registerBlock(BUCKET_EMPTY);
		registerBlock(BUCKET_DIRT);
		registerBlock(BUCKET_WATER);
		registerBlock(MUG_EMPTY);
		registerBlock(MUG_BEER);
		registerBlock(MORTAR);
		registerBlock(GRINDSTONE);
		registerBlock(ANVIL);
		registerBlock(CAULDRON);
		registerBlock(HANGING_CAULDRON);
		registerBlock(HANGING_BRIDGE);
		registerBlock(bookOne);
		registerBlock(ROPE);
		registerBlock(ROPE_ANCHOR);
		registerBlock(CHAIN);
		registerBlock(CRATE);
		registerBlock(DUNGEON_CHEST);
		registerBlock(IRON_HOOK);
		registerBlock(KEY_HANGING);
		registerBlock(SHIPS_HELM);
		registerBlock(TARGET);
		registerBlock(TORCH_HOLDER_EMPTY);
		registerBlock(TORCH_HOLDER_UNLIT);
		registerBlock(TORCH_HOLDER_LIT);
		registerBlock(FIREPIT);
		registerBlock(BARLEY,null);
		DRPMedievalItems.SeedBarley = new SeedBarley();
		DRPMedievalItems.registerItem(DRPMedievalItems.SeedBarley);
		
		registerBlock(GOLDEN_SHIPS_BELL);
		
	}

	public static final void init(FMLInitializationEvent event) {}

	public static final void postInit(FMLPostInitializationEvent event) {}

	public static final void registerBlockOld(Block block) {

		GameRegistry.registerBlock(block, (block.getUnlocalizedName().split("[.]"))[1]);
	}
	
	public static final void registerBlock(Block block) {
		registerBlock(block,new ItemBlock(block).setRegistryName(block.getRegistryName()),true);
	}
	
	public static final void registerBlock(Block block, boolean registerMesh) {
		registerBlock(block,new ItemBlock(block).setRegistryName(block.getRegistryName()), registerMesh);
	}

	public static final void registerBlock(Block block, Item item) {
		registerBlock(block, item, true);

	}
	
	public static final void registerBlock(Block block, Item item, boolean registerMesh) {
		GameRegistry.register(block);
		if(item != null){
			GameRegistry.register(item);
			DarkRoleplayMedieval.proxy.addItemToRegisterMesh(item);
		}
	}
	
}
