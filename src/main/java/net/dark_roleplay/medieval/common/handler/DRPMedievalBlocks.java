package net.dark_roleplay.medieval.common.handler;

import java.util.ArrayList;
import java.util.List;

import net.dark_roleplay.drpcore.api.Modules;
import net.dark_roleplay.drpcore.api.blocks.Crop;
import net.dark_roleplay.drpcore.modules.wood.Event_AddBlocks;
import net.dark_roleplay.drpcore.modules.wood.Wood;
import net.dark_roleplay.drpcore.modules.wood.WoodenBlock;
import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.dark_roleplay.medieval.common.blocks.building.DryClay;
import net.dark_roleplay.medieval.common.blocks.building.MossyLog;
import net.dark_roleplay.medieval.common.blocks.building.ObsidianGlass;
import net.dark_roleplay.medieval.common.blocks.building.PackedIceBricks;
import net.dark_roleplay.medieval.common.blocks.building.SnowBricks;
import net.dark_roleplay.medieval.common.blocks.building.StoneBricks;
import net.dark_roleplay.medieval.common.blocks.building.StonePillar;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Anvil;
import net.dark_roleplay.medieval.common.blocks.craftingstations.ButterChurn;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Cauldron;
import net.dark_roleplay.medieval.common.blocks.craftingstations.ChoppingBlock;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Firepit;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Forge;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Grindstone;
import net.dark_roleplay.medieval.common.blocks.craftingstations.HangingCauldron;
import net.dark_roleplay.medieval.common.blocks.craftingstations.JuicePress;
import net.dark_roleplay.medieval.common.blocks.craftingstations.Mortar;
import net.dark_roleplay.medieval.common.blocks.craftingstations.PotteryTurntable;
import net.dark_roleplay.medieval.common.blocks.craftingstations.SimpleCarpenterWorkbench;
import net.dark_roleplay.medieval.common.blocks.craftingstations.SpinningWheel;
import net.dark_roleplay.medieval.common.blocks.decorative.BookOne;
import net.dark_roleplay.medieval.common.blocks.decorative.Chain;
import net.dark_roleplay.medieval.common.blocks.decorative.GoldenShipsBell;
import net.dark_roleplay.medieval.common.blocks.decorative.Hook;
import net.dark_roleplay.medieval.common.blocks.decorative.KeyHanging;
import net.dark_roleplay.medieval.common.blocks.decorative.MugBeer;
import net.dark_roleplay.medieval.common.blocks.decorative.MugEmpty;
import net.dark_roleplay.medieval.common.blocks.decorative.Rope;
import net.dark_roleplay.medieval.common.blocks.decorative.RopeAnchor;
import net.dark_roleplay.medieval.common.blocks.decorative.ShipsHelm;
import net.dark_roleplay.medieval.common.blocks.decorative.Target;
import net.dark_roleplay.medieval.common.blocks.decorative.barrels.BarrelClosed;
import net.dark_roleplay.medieval.common.blocks.decorative.barrels.BarrelEmpty;
import net.dark_roleplay.medieval.common.blocks.decorative.barrels.BarrelFilled;
import net.dark_roleplay.medieval.common.blocks.decorative.barrels.SidewayBarrel;
import net.dark_roleplay.medieval.common.blocks.decorative.buckets.Bucket;
import net.dark_roleplay.medieval.common.blocks.decorative.buckets.BucketDirt;
import net.dark_roleplay.medieval.common.blocks.decorative.candles.BeesWaxCandle;
import net.dark_roleplay.medieval.common.blocks.decorative.chairs.BarrelChair;
import net.dark_roleplay.medieval.common.blocks.decorative.chairs.LogChair;
import net.dark_roleplay.medieval.common.blocks.decorative.chairs.SimpleChair;
import net.dark_roleplay.medieval.common.blocks.decorative.clocks.ClockCore;
import net.dark_roleplay.medieval.common.blocks.decorative.clocks.ClockDial;
import net.dark_roleplay.medieval.common.blocks.decorative.firewood_pile.FirewoodPile;
import net.dark_roleplay.medieval.common.blocks.decorative.flowerPot.FlowerPot;
import net.dark_roleplay.medieval.common.blocks.decorative.hangingBridges.HangingBridge;
import net.dark_roleplay.medieval.common.blocks.decorative.head_cutting_block.HeadCuttingBlock;
import net.dark_roleplay.medieval.common.blocks.decorative.lanterns.Lantern;
import net.dark_roleplay.medieval.common.blocks.decorative.lecterns.LargeLectern;
import net.dark_roleplay.medieval.common.blocks.decorative.minecart_stopper.MinecartStopper;
import net.dark_roleplay.medieval.common.blocks.decorative.pottery.FiredPottery;
import net.dark_roleplay.medieval.common.blocks.decorative.pottery.UnfiredPottery;
import net.dark_roleplay.medieval.common.blocks.decorative.rope_fence.RopeFence;
import net.dark_roleplay.medieval.common.blocks.decorative.scales.Scale;
import net.dark_roleplay.medieval.common.blocks.decorative.support.WoodSupport;
import net.dark_roleplay.medieval.common.blocks.decorative.tables.BarrelTable;
import net.dark_roleplay.medieval.common.blocks.decorative.tables.SimpleTable;
import net.dark_roleplay.medieval.common.blocks.decorative.tables.WorkTable;
import net.dark_roleplay.medieval.common.blocks.decorative.wall_mounted.EmptyWallMount;
import net.dark_roleplay.medieval.common.blocks.decorative.wall_mounted.LitWallMount;
import net.dark_roleplay.medieval.common.blocks.decorative.wall_mounted.UnlitWallMount;
import net.dark_roleplay.medieval.common.blocks.minerals.AdvancedOre;
import net.dark_roleplay.medieval.common.blocks.other.BeeHive;
import net.dark_roleplay.medieval.common.blocks.other.RopeCoil;
import net.dark_roleplay.medieval.common.blocks.other.gunpowder_trail.GunpowderTrail;
import net.dark_roleplay.medieval.common.blocks.plants.Barley;
import net.dark_roleplay.medieval.common.blocks.plants.Hops;
import net.dark_roleplay.medieval.common.blocks.plants.apples.Apple;
import net.dark_roleplay.medieval.common.blocks.plants.mushrooms.Mushroom;
import net.dark_roleplay.medieval.common.blocks.plants.pears.Pear;
import net.dark_roleplay.medieval.common.blocks.plants.sapling.AppleSappling;
import net.dark_roleplay.medieval.common.blocks.rotary.Axle;
import net.dark_roleplay.medieval.common.blocks.storage.Crate;
import net.dark_roleplay.medieval.common.blocks.storage.DungeonChest;
import net.dark_roleplay.medieval.common.blocks.storage.shelf.Shelf;
import net.dark_roleplay.medieval.common.blocks.util.shop_sign.ShopSign;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(DRPMedievalInfo.MODID)
@Mod.EventBusSubscriber
public class DRPMedievalBlocks {

	
//	public static SimpleChest CHEST_TEST = new SimpleChest("simple_chest");
	
	static List<Block> blocks = new ArrayList<Block>();
	
	public static final Block OAK_FIREWOOD_PILE = null;

	public static final Block ANVIL = null;
	public static final Block CAULDRON = null;
	public static final Block CHAIN = null;
	public static final Block FIREPIT = null;
	public static final Block GRINDSTONE = null;
	public static final Block HANGING_CAULDRON = null;
	public static final Block KEY_HANGING = null;
	public static final Block MORTAR = null;
	public static final Block SHIPS_HELM = null;
	public static final Block TARGET = null;
	public static final Block CLOCK_CORE = null;
	public static final Block COPPER_ORE = null;
	public static final Block DRY_CLAY_CHUNK = null;
	public static final Block GUNPOWDER_TRAIL = null;
	public static final Block HANGING_BRIDGE_BOTTOM = null;
	public static final Block HANGING_BRIDGE_TOP = null;
	public static final Block ROPE = null;
	public static final Block IRON_HOOK = null;
	public static final Block SILVER_ORE = null;
	public static final Block OBSIDIAN_GLASS = null;
	public static final Block ROPE_ANCHOR = null;
	public static final Block ROPE_FENCE = null;
	public static final Block BEESWAX_CANDLE = null;
	public static final Block FLOWER_POT = null;
	public static final Block MOSSY_SPRUCE_LOG = null;
	public static final Block OAK_CHOPPING_BLOCK = null;
	public static final Block TIN_ORE = null;
	public static final Block SULFUR_ORE = null;
	public static final Block SALPETER_ORE = null;

	public static final Crop BARLEY = null;
	
	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> reg = event.getRegistry();
		
		for(Wood wood : Modules.WOODS.getWoods()){
			register(reg, DRPMedievalCreativeTabs.DECORATION,
				new FirewoodPile(wood.getName() + "_firewood_pile"),
				new BarrelChair(wood.getName() + "_barrel_chair"),
				new BarrelEmpty(wood.getName() + "_empty_barrel"),
				new BarrelFilled(wood.getName() + "_water_barrel"),
				new BarrelClosed(wood.getName() + "_closed_barrel"),
				new BarrelFilled(wood.getName() + "_gunpowder_barrel"),
				new BarrelTable(wood.getName() + "_barrel_table"),
				new BucketDirt(wood.getName() + "_dirt_bucket"),
				new Bucket(wood.getName() + "_empty_bucket"),
				new Bucket(wood.getName() + "_water_bucket"),
				new LogChair(wood.getName() + "_log_chair"),
				new SimpleChair("simple_" + wood.getName() + "_chair"),
				new SimpleTable("simple_" + wood.getName() + "_table"),
				new SidewayBarrel("laying_" + wood.getName() + "_barrel"),
				new WoodSupport(wood.getName() + "_wood_support")
			);
			
			register(reg, DRPMedievalCreativeTabs.BUILDING_MATS,
				new Block(Material.WOOD).setRegistryName(wood.getName() + "_clean_plank").setUnlocalizedName(wood.getName() + "_clean_plank"),
				new MossyLog("mossy_" + wood.getName() + "_log")
			);
			
			register(reg, DRPMedievalCreativeTabs.UTILITY,
				new ChoppingBlock(wood.getName() + "_chopping_block"),
				new Crate(wood.getName() + "_crate"),
				new DungeonChest("simple_" + wood.getName() + "_chest"),
				new LargeLectern("large_" + wood.getName() + "_lectern"),
				new Shelf("simple_" + wood.getName() + "_shelf")
			);
		}
		
		register(reg, DRPMedievalCreativeTabs.DECORATION,
			new HeadCuttingBlock("head_cutting_block"),
			new Lantern("lantern", new Material(MapColor.IRON), new AxisAlignedBB(0.25F, 0F, 0.25F, 0.75F, 0.5F, 0.75F)),
			new WorkTable("work_table"),
			new UnfiredPottery("unfired_vase", new AxisAlignedBB(0.3125F, 0F, 0.3125F, 0.6875F, 0.5815F, 0.6875F)),
			new FiredPottery("fired_vase", new AxisAlignedBB(0.3125F, 0F, 0.3125F, 0.6875F, 0.5815F, 0.6875F)),
			new BeesWaxCandle("beeswax_candle"),
			new EmptyWallMount("candle_holder_empty", new AxisAlignedBB(0.3125F, 0F, 0.5F, 0.6875F, 0.9375F, 1.0F)),
			new LitWallMount("candle_holder_lit", new AxisAlignedBB(0.3125F, 0F, 0.5F, 0.6875F, 0.9375F, 1.0F), 0.19D, 1.05D),
			new UnlitWallMount("candle_holder_unlit", new AxisAlignedBB(0.3125F, 0F, 0.5F, 0.6875F, 0.9375F, 1.0F)),
			new EmptyWallMount("torch_holder_empty", new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F)),
			new LitWallMount("torch_holder_lit", new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F), 0.23D, 0.82D),
			new UnlitWallMount("torch_holder_unlit", new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F)),
			new Target("target"),
			new BeeHive("bee_hive"),
			new BookOne("book_one"),
			new Chain("chain"),
			new ClockCore("clock_core"),
			new ClockDial("clock_dial", new AxisAlignedBB(0.0F, 0.0F, 0.875F, 1.0, 1.0F, 1.0F)),
			new FlowerPot("flower_pot"),
			new GoldenShipsBell("golden_ship_bell"),
			new Hook("iron_hook"),
			new KeyHanging("key_hanging"),
			new MugBeer("mug_beer"),
			new MugEmpty("mug_empty"),
			new RopeFence("rope_fence"),
			new ShipsHelm("ships_helm"),
			new SpinningWheel("spinning_wheel"),
			new MinecartStopper("minecart_stopper"),
			new Scale("golden_scale")
		);
		
		register(reg, DRPMedievalCreativeTabs.BUILDING_MATS,
			new AdvancedOre("tin_ore", 1, DRPMedievalItems.ORE_CHUNK_TIN),
			new DryClay("dry_clay"),
			new StoneBricks("andesite_bricks"),
			new StonePillar("andesite_pillar"),
			new AdvancedOre("copper_ore", 1, DRPMedievalItems.ORE_CHUNK_COPPER),
			new StoneBricks("diorite_bricks"),
			new StonePillar("diorite_pillar"),
			new StoneBricks("granite_bricks"),
			new StonePillar("granite_pillar"),
			new ObsidianGlass("obsidian_glass"),
			new PackedIceBricks("packed_ice_bricks"),
			new AdvancedOre("salpeter_ore", 1, DRPMedievalItems.ORE_CHUNK_SALPETER),
			new AdvancedOre("sulfur_ore", 1, DRPMedievalItems.ORE_CHUNK_SULFUR),
			new AdvancedOre("silver_ore", 2, DRPMedievalItems.ORE_CHUNK_SILVER),
			new SnowBricks("snow_bricks")
		);
		
		register(reg, DRPMedievalCreativeTabs.UTILITY,
			new ButterChurn("butter_churn"),
			new ShopSign("wall_shop_sign"),
			new Forge("forge"),
			new Anvil("anvil"),
			new Axle("axle"),
			new Cauldron("cauldron"),
			new Firepit("firepit_lit"),
			new Grindstone("grindstone"),
			new HangingCauldron("hanging_cauldron"),
			new JuicePress("juice_press"),
			new Mortar("mortar"),
			new PotteryTurntable("pottery_turntable"),
			new Rope("rope"),
//			new RopeCoil("rope_coil"),
			new RopeAnchor("rope_anchor"),
			new SimpleCarpenterWorkbench("simple_carpenter_workbench"),
			
			
			//TODO MOVE TO OWN TAB
//			new AppleSappling("apple_sapling"),
			new Mushroom("mushroom_brown"),
			new Mushroom("mushroom_red")
		);
		
		registerNoItems(reg,
			new Barley("barley"),
			new Apple("apple_green", new ItemStack(DRPMedievalItems.APPLE_GREEN, 1)),
			new Apple("apple_red", new ItemStack(Items.APPLE, 1)),
			new Apple("apple_yellow", new ItemStack(DRPMedievalItems.APPLE_YELLOW, 1)),
			new Pear("pear_green", new ItemStack(DRPMedievalItems.PEAR_GREEN, 1)),
			new Pear("pear_yellow", new ItemStack(DRPMedievalItems.PEAR_YELLOW, 1)),
			new Hops("hops"),
			new GunpowderTrail("gunpowder_trail"),
			new HangingBridge("hanging_bridge_bottom" ,0F),
			new HangingBridge("hanging_bridge_top" ,0.5F)
		);
	}
	
	@SubscribeEvent
	public static void addBlocks(Event_AddBlocks event){
//		new BucketDirt(wood.getName() + "_dirt_bucket"),
//		new DungeonChest("simple_" + wood.getName() + "_chest"),

		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "simple_%wood%_shelf"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/simple_shelf.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/simple_shelf.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/simple_shelf.json"))
		);

		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_dirt_bucket"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/dirt_bucket.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/dirt_bucket.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/dirt_bucket.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "simple_%wood%_chest"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/simple_chest.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/simple_chest.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/simple_chest.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_crate"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/crate.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/crate.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/crate.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_wood_support"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/wood_support.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/wood_support.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/wood_support.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_water_bucket"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/water_bucket.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/water_bucket.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/water_bucket.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_empty_bucket"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/empty_bucket.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/empty_bucket.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/empty_bucket.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_chopping_block"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/chopping_block.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/chopping_block.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/chopping_block.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "large_%wood%_lectern"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/large_lectern.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/large_lectern.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/large_lectern.json"))
		);	
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_clean_plank"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/clean_plank.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/clean_plank.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/clean_plank.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_log_chair"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/log_chair.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/log_chair.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/log_chair.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "mossy_%wood%_log"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/mossy_log.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/mossy_log.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/mossy_log.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "simple_%wood%_chair"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/simple_chair.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/simple_chair.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/simple_chair.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "simple_%wood%_table"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/simple_table.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/simple_table.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/simple_table.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_firewood_pile"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/firewood_pile.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/firewood_pile.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/firewood_pile.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_barrel_chair"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/barrel_chair.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/barrel_chair.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/barrel_chair.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_barrel_table"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/barrel_table.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/barrel_table.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/barrel_table.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_closed_barrel"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/closed_barrel.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/closed_barrel.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/closed_barrel.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_empty_barrel"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/empty_barrel.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/empty_barrel.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/empty_barrel.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_gunpowder_barrel"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/gunpowder_barrel.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/gunpowder_barrel.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/gunpowder_barrel.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "laying_%wood%_barrel"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/laying_barrel.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/laying_barrel.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/laying_barrel.json"))
		);
		
		Modules.WOODS.addWoodenBlock(new WoodenBlock(new ResourceLocation(DRPMedievalInfo.MODID, "%wood%_water_barrel"))
			.setBaseBlockState(new ResourceLocation(DRPMedievalInfo.MODID, "argh/blockstates/water_barrel.json"))
			.setTextureGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/texture_generators/water_barrel.json"))
			.setModelGenerator(new ResourceLocation(DRPMedievalInfo.MODID, "argh/model_generators/water_barrel.json"))
		);
	}
	
	protected static void register(IForgeRegistry<Block> reg, CreativeTabs creativeTab, Block... blocks){
		for(Block block : blocks){
			block.setCreativeTab(creativeTab);
			ItemBlock itemBlock = (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
			DRPMedievalItems.addBlockItem(itemBlock);
			DRPMedievalModels.addItemToRegisterMesh(itemBlock);
		}
		reg.registerAll(blocks);
	}
	
	protected static void registerNoItems(IForgeRegistry<Block> reg, Block... blocks){
		reg.registerAll(blocks);
	}
}
