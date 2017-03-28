package net.drpmedieval.common.blocks;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.building.*;
import net.drpmedieval.common.blocks.craftingstations.*;
import net.drpmedieval.common.blocks.decorative.*;
import net.drpmedieval.common.blocks.decorative.apiaries.*;
import net.drpmedieval.common.blocks.decorative.barrels.*;
import net.drpmedieval.common.blocks.decorative.buckets.*;
import net.drpmedieval.common.blocks.decorative.chairs.*;
import net.drpmedieval.common.blocks.decorative.flowerPot.FlowerPot;
import net.drpmedieval.common.blocks.decorative.hangingBridges.HangingBridge2;
import net.drpmedieval.common.blocks.decorative.lecterns.LargeLectern;
import net.drpmedieval.common.blocks.decorative.ropeFence.RopeFence;
import net.drpmedieval.common.blocks.decorative.tables.*;
import net.drpmedieval.common.blocks.minerals.AdvancedOre;
import net.drpmedieval.common.blocks.other.RegeneratingOre;
import net.drpmedieval.common.blocks.other.RopeCoil;
import net.drpmedieval.common.blocks.plants.*;
import net.drpmedieval.common.blocks.plants.apples.Apple;
import net.drpmedieval.common.blocks.plants.mushrooms.Mushroom;
import net.drpmedieval.common.blocks.plants.pears.Pear;
import net.drpmedieval.common.blocks.plants.sapling.AppleSappling;
import net.drpmedieval.common.blocks.rotary.Axle;
import net.drpmedieval.common.blocks.storage.*;
import net.drpmedieval.common.items.DRPMItems;
import net.drpmedieval.common.items.blocks.CleanPlankItem;
import net.drpmedieval.common.items.seeds.SeedBarley;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DRPMBlocks {
	
	/** A **/

	public static StoneBricks ANDESITE_BRICKS = new StoneBricks("andesite_bricks");
	public static StonePillar ANDESITE_PILLAR = new StonePillar("andesite_pillar");
	
	public static Anvil ANVIL = new Anvil("anvil");
//	public static Apiary APIARY_OAK = new Apiary("apiary_oak");
//	public static Apiary APIARY_BIRCH = new Apiary("apiary_birch");
//	public static Apiary APIARY_SPRUCE = new Apiary("apiary_spruce");
//	public static Apiary APIARY_JUNGLE = new Apiary("apiary_jungle");
//	public static Apiary APIARY_ACACIA = new Apiary("apiary_acacia");
//	public static Apiary APIARY_DARK_OAK = new Apiary("apiary_dark_oak");

	public static Apple APPLE_GREEN = new Apple("apple_green", new ItemStack(DRPMItems.AppleGreen, 1)); //TODO FIX APPLES
	public static Apple APPLE_RED = new Apple("apple_red", new ItemStack(Items.APPLE, 1));
	public static Apple APPLE_YELLOW = new Apple("apple_yellow", new ItemStack(DRPMItems.AppleYellow, 1));
	public static AppleSappling APPLE_SAPPLING = new AppleSappling("apple_sapling");
	public static Axle AXLE = new Axle("axle");
	
	/** B **/

	public static Barley BARLEY = new Barley();
	
	public static BarrelChair BARREL_CHAIR_OAK = new BarrelChair("barrel_chair_oak");
	public static BarrelChair BARREL_CHAIR_BIRCH = new BarrelChair("barrel_chair_birch");
	public static BarrelChair BARREL_CHAIR_SPRUCE = new BarrelChair("barrel_chair_spruce");
	public static BarrelChair BARREL_CHAIR_JUNGLE = new BarrelChair("barrel_chair_jungle");
	public static BarrelChair BARREL_CHAIR_ACACIA = new BarrelChair("barrel_chair_acacia");
	public static BarrelChair BARREL_CHAIR_DARK_OAK = new BarrelChair("barrel_chair_dark_oak");
	
	public static BarrelEmpty BARREL_EMPTY_OAK = new BarrelEmpty("barrel_empty_oak");
	public static BarrelEmpty BARREL_EMPTY_BIRCH = new BarrelEmpty("barrel_empty_birch");
	public static BarrelEmpty BARREL_EMPTY_SPRUCE = new BarrelEmpty("barrel_empty_spruce");
	public static BarrelEmpty BARREL_EMPTY_JUNGLE = new BarrelEmpty("barrel_empty_jungle");
	public static BarrelEmpty BARREL_EMPTY_ACACIA = new BarrelEmpty("barrel_empty_acacia");
	public static BarrelEmpty BARREL_EMPTY_DARK_OAK = new BarrelEmpty("barrel_empty_dark_oak");
	
	public static BarrelFilled BARREL_WATER_OAK = new BarrelFilled("barrel_water_oak");
	public static BarrelFilled BARREL_WATER_BIRCH = new BarrelFilled("barrel_water_birch");
	public static BarrelFilled BARREL_WATER_SPRUCE = new BarrelFilled("barrel_water_spruce");
	public static BarrelFilled BARREL_WATER_JUNGLE = new BarrelFilled("barrel_water_jungle");
	public static BarrelFilled BARREL_WATER_ACACIA = new BarrelFilled("barrel_water_acacia");
	public static BarrelFilled BARREL_WATER_DARK_OAK = new BarrelFilled("barrel_water_dark_oak");
	
	public static BarrelClosed BARREL_CLOSED_OAK = new BarrelClosed("barrel_closed_oak");
	public static BarrelClosed BARREL_CLOSED_BIRCH = new BarrelClosed("barrel_closed_birch");
	public static BarrelClosed BARREL_CLOSED_SPRUCE = new BarrelClosed("barrel_closed_spruce");
	public static BarrelClosed BARREL_CLOSED_JUNGLE = new BarrelClosed("barrel_closed_jungle");
	public static BarrelClosed BARREL_CLOSED_ACACIA = new BarrelClosed("barrel_closed_acacia");
	public static BarrelClosed BARREL_CLOSED_DARK_OAK = new BarrelClosed("barrel_closed_dark_oak");
	
	public static BarrelFilled BARREL_GUNPOWDER_OAK = new BarrelFilled("barrel_gunpowder_oak");
	public static BarrelFilled BARREL_GUNPOWDER_BIRCH = new BarrelFilled("barrel_gunpowder_birch");
	public static BarrelFilled BARREL_GUNPOWDER_SPRUCE = new BarrelFilled("barrel_gunpowder_spruce");
	public static BarrelFilled BARREL_GUNPOWDER_JUNGLE = new BarrelFilled("barrel_gunpowder_jungle");
	public static BarrelFilled BARREL_GUNPOWDER_ACACIA = new BarrelFilled("barrel_gunpowder_acacia");
	public static BarrelFilled BARREL_GUNPOWDER_DARK_OAK = new BarrelFilled("barrel_gunpowder_dark_oak");
		
	public static BedFrame BED_FRAME_OAK = new BedFrame("bed_frame_oak", DRPMItems.BedFrameOak);
	public static BedFrame BED_FRAME_SPRUCE = new BedFrame("bed_frame_spruce", DRPMItems.BedFrameSpruce);
	public static BedFrame BED_FRAME_BIRCH = new BedFrame("bed_frame_birch", DRPMItems.BedFrameBirch);
	public static BedFrame BED_FRAME_JUNGLE = new BedFrame("bed_frame_jungle", DRPMItems.BedFrameJungle);
	public static BedFrame BED_FRAME_ACACIA = new BedFrame("bed_frame_acacia", DRPMItems.BedFrameAcacia);
	public static BedFrame BED_FRAME_DARK_OAK = new BedFrame("bed_frame_dark_oak", DRPMItems.BedFrameDarkOak);
	
	public static BarrelTable BARREL_TABLE_OAK = new BarrelTable("barrel_table_oak");
	public static BarrelTable BARREL_TABLE_BIRCH = new BarrelTable("barrel_table_birch");
	public static BarrelTable BARREL_TABLE_JUNGLE = new BarrelTable("barrel_table_jungle");
	public static BarrelTable BARREL_TABLE_SPRUCE = new BarrelTable("barrel_table_spruce");
	public static BarrelTable BARREL_TABLE_DARK_OAK = new BarrelTable("barrel_table_dark_oak");
	public static BarrelTable BARREL_TABLE_ACACIA = new BarrelTable("barrel_table_acacia");

	public static BookOne bookOne = new BookOne("book_one");
	public static BucketDirt BUCKET_DIRT = new BucketDirt("bucket_dirt");
	public static Bucket BUCKET_EMPTY = new Bucket("bucket_empty");
	public static Bucket BUCKET_WATER = new Bucket("bucket_water");

	/** C **/

	public static Cauldron CAULDRON = new Cauldron("cauldron");
	public static Chain CHAIN = new Chain("chain");
	public static ChoppingBlock CHOPPING_BLOCK = new ChoppingBlock("chopping_block");
	public static CleanPlanks CLEAN_PLANKS = new CleanPlanks("clean_planks");
	public static Crate CRATE = new Crate("crate");
	public static AdvancedOre COPPER_ORE = new AdvancedOre("copper_ore");
	
	
	/** D **/
	
	public static StoneBricks DIORITE_BRICKS = new StoneBricks("diorite_bricks");
	public static StonePillar DIORITE_PILLAR = new StonePillar("diorite_pillar");
	public static DungeonChest DUNGEON_CHEST = new DungeonChest("dungeon_chest");

	/** E **/

	/** F **/

	public static Firepit FIREPIT = new Firepit("firepit_lit");
	public static FlowerPot FLOWER_POT = new FlowerPot("flower_pot");
	
	/** G **/

	public static GoldenShipsBell GOLDEN_SHIPS_BELL = new GoldenShipsBell("golden_ship_bell");
	
	public static StoneBricks GRANITE_BRICKS = new StoneBricks("granite_bricks");
	public static StonePillar GRANITE_PILLAR = new StonePillar("granite_pillar");
	
	public static Grindstone GRINDSTONE = new Grindstone("grindstone");

	/** H **/

	public static Hops HOPS = new Hops("hops");
	public static HangingBridge HANGING_BRIDGE = new HangingBridge("hanging_bridge");
	public static HangingBridge2 HANGING_BRIDGE_BOTTOM = new HangingBridge2("hanging_bridge_bottom" ,0F); //TODO NEW
	public static HangingBridge2 HANGING_BRIDGE_TOP = new HangingBridge2("hanging_bridge_top" ,0.5F); //TODO NEW
	public static HangingCauldron HANGING_CAULDRON = new HangingCauldron("hanging_cauldron");

	/** I **/
	public static Hook IRON_HOOK = new Hook("iron_hook");
	
	/** J **/

	/** K **/

	public static KeyHanging KEY_HANGING = new KeyHanging("key_hanging");

	/** L **/

	public static Leaves1 LEAVES_1 = new Leaves1("leaves1", "leaves1");//TODO PORT TO WOOD HANDLER
	public static Logs1 LOGS_1 = new Logs1("logs1", "logs1");//TODO PORT TO WOOD HANDLER
	public static LargeLectern LARGE_LECTERN_SPRUCE = new LargeLectern("large_lectern_spruce");//TODO PORT TO WOOD HANDLER
	
	public static LogChair LOG_CHAIR_OAK = new LogChair("log_chair_oak");//TODO PORT TO WOOD HANDLER
	public static LogChair LOG_CHAIR_SPRUCE = new LogChair("log_chair_spruce");
	public static LogChair LOG_CHAIR_BIRCH = new LogChair("log_chair_birch");
	public static LogChair LOG_CHAIR_JUNGLE = new LogChair("log_chair_jungle");
	public static LogChair LOG_CHAIR_ACACIA = new LogChair("log_chair_acacia");
	public static LogChair LOG_CHAIR_DARK_OAK = new LogChair("log_chair_dark_oak");

	
	/** M **/

	public static Mortar MORTAR = new Mortar("mortar");
	public static MossyLog MOSSY_LOG_ACACIA = new MossyLog("mossy_log_acacia");//TODO PORT TO WOOD HANDLER
	public static MossyLog MOSSY_LOG_BIRCH = new MossyLog("mossy_log_birch");
	public static MossyLog MOSSY_LOG_DARK_OAK = new MossyLog("mossy_log_dark_oak");
	public static MossyLog MOSSY_LOG_JUNGLE = new MossyLog("mossy_log_jungle");
	public static MossyLog MOSSY_LOG_OAK = new MossyLog("mossy_log_oak");
	public static MossyLog MOSSY_LOG_SPRUCE = new MossyLog("mossy_log_spruce");
	
	
	public static MugBeer MUG_BEER = new MugBeer("mug_beer");
	public static MugEmpty MUG_EMPTY = new MugEmpty("mug_empty");
	public static Mushroom MUSHROOM_BROWN = new Mushroom("mushroom_brown");
	public static Mushroom MUSHROOM_RED = new Mushroom("mushroom_red");

	/** N **/

	/** O **/

	/** P **/

	public static Planks1 PLANKS_1 = new Planks1("planks1", "planks1");
	public static PackedIceBricks PACKED_ICE_BRICKS = new PackedIceBricks("packed_ice_bricks");
	public static Pear PEAR_GREEN = new Pear("pear_green", new ItemStack(DRPMItems.PearGreen, 1)); //TODO FIX PEARS
	public static Pear PEAR_YELLOW = new Pear("pear_yellow", new ItemStack(DRPMItems.PearYellow, 1));
	public static PotionEmpty POTION_EMPTY = new PotionEmpty("potion_empty"); //TODO Fix Potions

	/** Q **/

	/** R **/

	public static RegeneratingOre rgO = new RegeneratingOre("regenOre", DRPMedievalCreativeTabs.drpmedievalMiscTab, 0.4F, 5); //TODO REGENERATING ORES
	public static Rope ROPE = new Rope("rope");
	public static RopeCoil ROPE_COIL = new RopeCoil("rope_coil");
	public static RopeAnchor ROPE_ANCHOR = new RopeAnchor("rope_anchor");
	public static RopeFence ROPE_FENCE = new RopeFence("rope_fence");
	
	/** S **/

	public static AdvancedOre SALPETER_ORE = new AdvancedOre("salpeter_ore");
	public static AdvancedOre SULFUR_ORE = new AdvancedOre("sulfur_ore");
	public static AdvancedOre SILVER_ORE = new AdvancedOre("silver_ore");
	
	public static SimpleChair SIMPLE_CHAIR_OAK = new SimpleChair("simple_chair_oak");;
	public static SimpleChair SIMPLE_CHAIR_BIRCH = new SimpleChair("simple_chair_birch");
	public static SimpleChair SIMPLE_CHAIR_SPRUCE = new SimpleChair("simple_chair_spruce");
	public static SimpleChair SIMPLE_CHAIR_JUNGLE = new SimpleChair("simple_chair_jungle");
	public static SimpleChair SIMPLE_CHAIR_ACACIA = new SimpleChair("simple_chair_acacia");
	public static SimpleChair SIMPLE_CHAIR_DARK_OAK = new SimpleChair("simple_chair_dark_oak");
	
	public static SimpleTable SIMPLE_TABLE_OAK = new SimpleTable("simple_table_oak");
	public static SimpleTable SIMPLE_TABLE_BIRCH = new SimpleTable("simple_table_birch");
	public static SimpleTable SIMPLE_TABLE_SPRUCE = new SimpleTable("simple_table_spruce");
	public static SimpleTable SIMPLE_TABLE_JUNGLE = new SimpleTable("simple_table_jungle");
	public static SimpleTable SIMPLE_TABLE_ACACIA = new SimpleTable("simple_table_acacia");
	public static SimpleTable SIMPLE_TABLE_DARK_OAK = new SimpleTable("simple_table_dark_oak");
	
	public static SidewayBarrel SIDEWAY_BARREL_ACACIA = new SidewayBarrel("sideway_barrel_acacia");
	public static SidewayBarrel SIDEWAY_BARREL_BIRCH = new SidewayBarrel("sideway_barrel_birch");
	public static SidewayBarrel SIDEWAY_BARREL_OAK = new SidewayBarrel("sideway_barrel_oak");
	public static SidewayBarrel SIDEWAY_BARREL_JUNGLE = new SidewayBarrel("sideway_barrel_jungle");
	public static SidewayBarrel SIDEWAY_BARREL_SPRUCE = new SidewayBarrel("sideway_barrel_spruce");
	public static SidewayBarrel SIDEWAY_BARREL_DARK_OAK = new SidewayBarrel("sideway_barrel_dark_oak");
	
	
	public static ShipsHelm SHIPS_HELM = new ShipsHelm("ships_helm");
	
	public static SnowBricks SNOW_BRICKS = new SnowBricks("snow_bricks");
	
	public static SpinningWheel SPINNING_WHEEL = new SpinningWheel("spinning_wheel");

	/** T **/

	public static AdvancedOre TIN_ORE = new AdvancedOre("tin_ore");
	public static Target TARGET = new Target("target");
	public static TorchHolderEmpty TORCH_HOLDER_EMPTY = new TorchHolderEmpty("torch_holder_empty");
	public static TorchHolderLit TORCH_HOLDER_LIT = new TorchHolderLit("torch_holder_lit");
	public static TorchHolderUnlit TORCH_HOLDER_UNLIT = new TorchHolderUnlit("torch_holder_unlit");

	/** U **/

	/** V **/

	/** W **/

	/** X **/

	/** Y **/

	/** Z **/

	public static void preInit(FMLPreInitializationEvent event) {
		//registerBlock(rgO);
		WoodHelper.init();

		registerBlock(SNOW_BRICKS);
		//registerBlock(APPLE_SAPPLING);
		
		TIN_ORE.setOre(DRPMItems.TIN_ORE_CHUNK);
		COPPER_ORE.setOre(DRPMItems.COPPER_ORE_CHUNK);
		SILVER_ORE.setOre(DRPMItems.SILVER_ORE_CHUNK);
		SULFUR_ORE.setOre(DRPMItems.SULFUR_ORE_CHUNK);
		SALPETER_ORE.setOre(DRPMItems.SALPETER_ORE_CHUNK);
		
		registerBlock(HOPS, null, false);
		//registerBlock(ROPE_COIL);
		
		registerBlock(AXLE);
		
		registerBlock(TIN_ORE);
		registerBlock(COPPER_ORE);
		registerBlock(SILVER_ORE);
		registerBlock(SULFUR_ORE);
		registerBlock(SALPETER_ORE);
		
		registerBlock(ANDESITE_PILLAR);
		registerBlock(ANDESITE_BRICKS);
		registerBlock(DIORITE_PILLAR);
		registerBlock(DIORITE_BRICKS);
		registerBlock(GRANITE_PILLAR);
		registerBlock(GRANITE_BRICKS);
		
		registerBlock(SIMPLE_CHAIR_OAK, false);
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
		
		//TODO FIX APIARYS
//		REGISTERBLOCK(APIARY_OAK);
//		REGISTERBLOCK(APIARY_BIRCH);
//		REGISTERBLOCK(APIARY_SPRUCE);
//		REGISTERBLOCK(APIARY_JUNGLE);
//		REGISTERBLOCK(APIARY_ACACIA);
//		REGISTERBLOCK(APIARY_DARK_OAK);

		registerBlock(BARREL_TABLE_OAK);
		registerBlock(BARREL_TABLE_BIRCH);
		registerBlock(BARREL_TABLE_JUNGLE);
		registerBlock(BARREL_TABLE_SPRUCE);
		registerBlock(BARREL_TABLE_DARK_OAK);
		registerBlock(BARREL_TABLE_ACACIA);
		
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
		
		registerBlock(CLEAN_PLANKS, new CleanPlankItem(CLEAN_PLANKS));
		registerBlock(FLOWER_POT);
		
		registerBlock(SIDEWAY_BARREL_ACACIA);
		registerBlock(SIDEWAY_BARREL_BIRCH);
		registerBlock(SIDEWAY_BARREL_OAK);
		registerBlock(SIDEWAY_BARREL_JUNGLE);
		registerBlock(SIDEWAY_BARREL_SPRUCE);
		registerBlock(SIDEWAY_BARREL_DARK_OAK);
		
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
		
		registerBlock(MOSSY_LOG_ACACIA);
		registerBlock(MOSSY_LOG_BIRCH);
		registerBlock(MOSSY_LOG_DARK_OAK);
		registerBlock(MOSSY_LOG_JUNGLE);
		registerBlock(MOSSY_LOG_SPRUCE);
		registerBlock(MOSSY_LOG_OAK);
		
		//TODO FIX UP APPLE TREES
		//registerBlock(PLANKS_1);
		//registerBlock(LEAVES_1);
		//registerBlock(LOGS_1);
		
		registerBlock(HANGING_BRIDGE);
		//TODO FIX UP HANGING BRIDGE
		//registerBlock(HANGING_BRIDGE_BOTTOM);
		//registerBlock(HANGING_BRIDGE_TOP);
		
		registerBlock(LARGE_LECTERN_SPRUCE);
		registerBlock(ROPE_FENCE);
		
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
		//registerBlock(BARLEY,null);
		registerBlock(PACKED_ICE_BRICKS);
		
		registerBlock(SPINNING_WHEEL);
		
		DRPMItems.SeedBarley = new SeedBarley();
		//DRPMedievalItems.registerItem(DRPMedievalItems.SeedBarley);
		
		registerBlock(GOLDEN_SHIPS_BELL);
		
	}

	public static final void init(FMLInitializationEvent event) {}

	public static final void postInit(FMLPostInitializationEvent event) {}

	//public static final void registerBlockOld(Block block) {

		//GameRegistry.registerBlock(block, (block.getUnlocalizedName().split("[.]"))[1]);
	//}
	
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
