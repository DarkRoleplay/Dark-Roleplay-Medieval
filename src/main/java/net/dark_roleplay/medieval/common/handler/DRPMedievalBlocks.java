package net.dark_roleplay.medieval.common.handler;

import java.util.ArrayList;
import java.util.List;

import net.dark_roleplay.drpcore.api.Modules;
import net.dark_roleplay.drpcore.api.blocks.Crop;
import net.dark_roleplay.drpcore.modules.materials.AddResourceGenerators;
import net.dark_roleplay.drpcore.modules.materials.Material;
import net.dark_roleplay.drpcore.modules.materials.ResourceGenerator;
import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.blocks.building.DryClay;
import net.dark_roleplay.medieval.common.blocks.building.DryClayGrass;
import net.dark_roleplay.medieval.common.blocks.building.MossyLog;
import net.dark_roleplay.medieval.common.blocks.building.ObsidianGlass;
import net.dark_roleplay.medieval.common.blocks.building.PackedIceBricks;
import net.dark_roleplay.medieval.common.blocks.building.SnowBricks;
import net.dark_roleplay.medieval.common.blocks.building.StoneBricks;
import net.dark_roleplay.medieval.common.blocks.building.StonePillar;
import net.dark_roleplay.medieval.common.blocks.building.Timbering;
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
import net.dark_roleplay.medieval.common.blocks.decorative.hanging_bridges.HangingBridge;
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
import net.dark_roleplay.medieval.common.blocks.other.gunpowder_trail.GunpowderTrail;
import net.dark_roleplay.medieval.common.blocks.plants.Barley;
import net.dark_roleplay.medieval.common.blocks.plants.Hops;
import net.dark_roleplay.medieval.common.blocks.plants.apples.Apple;
import net.dark_roleplay.medieval.common.blocks.plants.mushrooms.Mushroom;
import net.dark_roleplay.medieval.common.blocks.plants.pears.Pear;
import net.dark_roleplay.medieval.common.blocks.rotary.Axle;
import net.dark_roleplay.medieval.common.blocks.storage.Crate;
import net.dark_roleplay.medieval.common.blocks.storage.DungeonChest;
import net.dark_roleplay.medieval.common.blocks.storage.barrels.FluidBarrel;
import net.dark_roleplay.medieval.common.blocks.storage.shelf.Shelf;
import net.dark_roleplay.medieval.common.blocks.util.shop_sign.ShopSign;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
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

@ObjectHolder(References.MODID)
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
	public static final AdvancedOre COPPER_ORE = null;
	public static final Block DRY_CLAY = null;
	public static final Block DRY_CLAY_GRASS = null;
	public static final Block GUNPOWDER_TRAIL = null;
	public static final Block HANGING_BRIDGE_BOTTOM = null;
	public static final Block HANGING_BRIDGE_TOP = null;
	public static final Block ROPE = null;
	public static final Block IRON_HOOK = null;
	public static final AdvancedOre SILVER_ORE = null;
	public static final Block OBSIDIAN_GLASS = null;
	public static final Block ROPE_ANCHOR = null;
	public static final Block ROPE_FENCE = null;
	public static final Block BEESWAX_CANDLE = null;
	public static final Block FLOWER_POT = null;
	public static final Block MOSSY_SPRUCE_LOG = null;
	public static final Block OAK_CHOPPING_BLOCK = null;
	public static final AdvancedOre TIN_ORE = null;
	public static final AdvancedOre SULFUR_ORE = null;
	public static final AdvancedOre SALPETER_ORE = null;
	public static final Block UNFIRED_VASE = null;
	public static final Block FIRED_VASE = null;
	public static final Block SIMPLE_CARPENTER_WORKBENCH = null;
	public static final Block FORGE = null;
	public static final UnlitWallMount CANDLE_HOLDER_UNLIT = null;
	public static final LitWallMount CANDLE_HOLDER_LIT = null;
	public static final UnlitWallMount TORCH_HOLDER_UNLIT = null;
	public static final LitWallMount TORCH_HOLDER_LIT = null;
	public static final EmptyWallMount CANDLE_HOLDER_EMPTY = null;
	public static final EmptyWallMount TORCH_HOLDER_EMPTY = null;
	
	
	public static final Crop BARLEY = null;
	
	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> reg = event.getRegistry();
		
		for(Material mat : Modules.MATERIALS.getMaterials(Modules.MATERIALS.WOOD_KEY)){
			register(reg, DRPMedievalCreativeTabs.DECORATION,
				new FirewoodPile(mat.getFormatValue() + "_firewood_pile"),
				new BarrelChair(mat.getFormatValue() + "_barrel_chair"),
				new BarrelEmpty(mat.getFormatValue() + "_empty_barrel"),
				new BarrelClosed(mat.getFormatValue() + "_closed_barrel"),
				new BarrelFilled(mat.getFormatValue() + "_gunpowder_barrel"),
				new BarrelTable(mat.getFormatValue() + "_barrel_table"),
				new BucketDirt(mat.getFormatValue() + "_dirt_bucket"),
				new Bucket(mat.getFormatValue() + "_empty_bucket"),
				new Bucket(mat.getFormatValue() + "_water_bucket"),
				new LogChair(mat.getFormatValue() + "_log_chair"),
				new SimpleChair("simple_" + mat.getFormatValue() + "_chair"),
				new SimpleTable("simple_" + mat.getFormatValue() + "_table"),
				new SidewayBarrel("laying_" + mat.getFormatValue() + "_barrel"),
				new WoodSupport(mat.getFormatValue() + "_wood_support")
			);
			
			register(reg, DRPMedievalCreativeTabs.BUILDING_MATS,
				new Block(net.minecraft.block.material.Material.WOOD).setRegistryName(mat.getFormatValue() + "_clean_plank").setUnlocalizedName(mat.getFormatValue() + "_clean_plank"),
				new MossyLog("mossy_" + mat.getFormatValue() + "_log")
			);
			
			register(reg, DRPMedievalCreativeTabs.UTILITY,
				new ChoppingBlock(mat.getFormatValue() + "_chopping_block"),
				new Crate(mat.getFormatValue() + "_crate"),
				new DungeonChest("simple_" + mat.getFormatValue() + "_chest"),
				new LargeLectern("large_" + mat.getFormatValue() + "_lectern"),
				new Shelf("simple_" + mat.getFormatValue() + "_shelf")
			);
			
			registerNoItems(reg,
				new Timbering(mat.getFormatValue() + "_timbered_clay_clean"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_diagonal_bt"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_diagonal_tb"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_cross"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_double_diagonal_t_bt"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_double_diagonal_b_bt"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_double_diagonal_t_tb"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_double_diagonal_b_tb"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_arrow_b"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_arrow_t"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_arrow_r"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_arrow_l"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_double_diagonal_l_lr"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_double_diagonal_r_lr"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_double_diagonal_l_rl"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_double_diagonal_r_rl"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_vertical"),
				new Timbering(mat.getFormatValue() + "_timbered_clay_horizontal"),
				new FluidBarrel(mat.getFormatValue() + "_fluid_barrel")
			);
		}
		
		register(reg, DRPMedievalCreativeTabs.DECORATION,
			new HeadCuttingBlock("head_cutting_block"),
			new Lantern("lantern", new net.minecraft.block.material.Material(MapColor.IRON), new AxisAlignedBB(0.25F, 0F, 0.25F, 0.75F, 0.5F, 0.75F)),
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
			new AdvancedOre("tin_ore", 1),
			new DryClay("dry_clay"),
			new DryClayGrass("dry_clay_grass"),
			new StoneBricks("andesite_bricks"),
			new StonePillar("andesite_pillar"),
			new AdvancedOre("copper_ore", 1),
			new StoneBricks("diorite_bricks"),
			new StonePillar("diorite_pillar"),
			new StoneBricks("granite_bricks"),
			new StonePillar("granite_pillar"),
			new ObsidianGlass("obsidian_glass"),
			new PackedIceBricks("packed_ice_bricks"),
			new AdvancedOre("salpeter_ore", 1),
			new AdvancedOre("sulfur_ore", 1),
			new AdvancedOre("silver_ore", 2),
			new SnowBricks("snow_bricks")
		);
		
		register(reg, DRPMedievalCreativeTabs.UTILITY,
			new ButterChurn("butter_churn"),
			new ShopSign("wall_shop_sign"),
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
			
			//TODO MOVE TO OWN TAB
//			new AppleSappling("apple_sapling"),
			new Mushroom("mushroom_brown"),
			new Mushroom("mushroom_red")
		);
		
		
		registerNoItems(reg,
			new Forge("forge"),
			new SimpleCarpenterWorkbench("simple_carpenter_workbench"),
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
	public static void addBlocks(AddResourceGenerators event){
		String texGens = References.MODID + ":argh/texture_generators/"; 
		String modGens = References.MODID + ":argh/json_generators/"; 
		
		event.addAll(
			new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "wooden_blockstates.json"),
				null
			), new ResourceGenerator(
				"wood",
				null,
				new ResourceLocation(texGens + "simple_shelf.json")
			), new ResourceGenerator(
				"wood",
				null,
				new ResourceLocation(texGens + "dirt_bucket.json")
			), new ResourceGenerator(
				"wood",
				null,
				new ResourceLocation(texGens + "simple_chest.json")
			), new ResourceGenerator(
				"wood",
				null,
				new ResourceLocation(texGens + "crate.json")
			), new ResourceGenerator(
				"wood",
				null,
				new ResourceLocation(texGens + "wood_support.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "water_bucket.json"),
				new ResourceLocation(texGens + "water_bucket.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "empty_bucket.json"),
				new ResourceLocation(texGens + "empty_bucket.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "chopping_block.json"),
				new ResourceLocation(texGens + "chopping_block.json")
			), new ResourceGenerator(
				"wood",
				null,
				new ResourceLocation(texGens + "large_lectern.json")
			), new ResourceGenerator(
				"wood",
				null,
				new ResourceLocation(texGens + "clean_plank.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "log_chair.json"),
				new ResourceLocation(texGens + "log_chair.json")
			), new ResourceGenerator(
				"wood",
				null,
				new ResourceLocation(texGens + "mossy_log.json")
			), new ResourceGenerator(
				"wood",
				null,
				new ResourceLocation(texGens + "simple_chair.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "simple_table.json"),
				new ResourceLocation(texGens + "simple_table.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "firewood_pile.json"),
				new ResourceLocation(texGens + "firewood_pile.json")
			), new ResourceGenerator(
				"wood",
				null,
				new ResourceLocation(texGens + "barrel_chair.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "barrel_table.json"),
				new ResourceLocation(texGens + "barrel_table.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "closed_barrel.json"),
				new ResourceLocation(texGens + "closed_barrel.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "empty_barrel.json"),
				new ResourceLocation(texGens + "empty_barrel.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "gunpowder_barrel.json"),
				new ResourceLocation(texGens + "gunpowder_barrel.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "laying_barrel.json"),
				new ResourceLocation(texGens + "laying_barrel.json")
			), new ResourceGenerator(
				"wood",
				new ResourceLocation(modGens + "fluid_barrel.json"),
				new ResourceLocation(texGens + "fluid_barrel.json")
			), new ResourceGenerator(
				"wood", null, new ResourceLocation(texGens + "timbering/timbering.json")
			), new ResourceGenerator(
				"wood", null, new ResourceLocation(texGens + "timbering/timbering_diagonal.json")
			), new ResourceGenerator(
				"wood", null, new ResourceLocation(texGens + "timbering/timbering_double_diagonal_h.json")
			), new ResourceGenerator(
				"wood", null, new ResourceLocation(texGens + "timbering/timbering_double_diagonal_v.json")
			), new ResourceGenerator(
				"wood", null, new ResourceLocation(texGens + "timbering/timbering_arrows.json")
			), new ResourceGenerator(
				"wood", null, new ResourceLocation(texGens + "timbering/timbering_straight.json")
			)
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
