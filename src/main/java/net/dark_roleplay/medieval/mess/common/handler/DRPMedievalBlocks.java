package net.dark_roleplay.medieval.mess.common.handler;

import java.util.ArrayList;
import java.util.List;

import net.dark_roleplay.core_modules.crops.api.blocks.Crop;
import net.dark_roleplay.core_modules.maarg.api.arg.MaterialRequirements;
import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.library.experimental.connected_model.ConnectedModelLoader;
import net.dark_roleplay.medieval.mess.common.References;
import net.dark_roleplay.medieval.mess.common.objects.blocks.building.DryClay;
import net.dark_roleplay.medieval.mess.common.objects.blocks.building.DryClayGrass;
import net.dark_roleplay.medieval.mess.common.objects.blocks.building.MossyLog;
import net.dark_roleplay.medieval.mess.common.objects.blocks.building.ObsidianGlass;
import net.dark_roleplay.medieval.mess.common.objects.blocks.building.PackedIceBricks;
import net.dark_roleplay.medieval.mess.common.objects.blocks.building.SnowBricks;
import net.dark_roleplay.medieval.mess.common.objects.blocks.building.StoneBricks;
import net.dark_roleplay.medieval.mess.common.objects.blocks.building.StonePillar;
import net.dark_roleplay.medieval.mess.common.objects.blocks.building.TimberedClay;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.Anvil;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.ButterChurn;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.Cauldron;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.ChoppingBlock;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.Firepit;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.Forge;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.Grindstone;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.HangingCauldron;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.JuicePress;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.Mortar;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.PotteryTurntable;
import net.dark_roleplay.medieval.mess.common.objects.blocks.craftingstations.SimpleCarpenterWorkbench;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.Chain;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.GoldenShipsBell;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.Hook;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.KeyHanging;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.MugBeer;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.MugEmpty;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.Rope;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.RopeAnchor;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.ShipsHelm;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.Target;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.barrels.BarrelClosed;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.barrels.BarrelEmpty;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.barrels.BarrelFilled;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.barrels.SidewayBarrel;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.buckets.Bucket;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.buckets.BucketDirt;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.candles.BeesWaxCandle;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.chairs.BarrelChair;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.chairs.LogBench;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.chairs.LogChair;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.chairs.SimpleChair;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.clocks.ClockCore;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.clocks.ClockDial;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.clocks.TE_ClockCore;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.firewood_pile.FirewoodPile;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.flowerPot.FlowerPot;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.flowers.FlowersTileEntity;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.hanging_bridges.HangingBridge;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.head_cutting_block.HeadCuttingBlock;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.lanterns.Lantern;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.lecterns.LargeLectern;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.minecart_stopper.MinecartStopper;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.pottery.FiredPottery;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.pottery.UnfiredPottery;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.rope_fence.RopeFence;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.scales.Scale;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.support.WoodSupport;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.tables.BarrelTable;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.tables.SimpleTable;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.tables.SolidSimpleTable;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.tables.WorkTable;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.wall_mounted.EmptyWallMount;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.wall_mounted.LitWallMount;
import net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.wall_mounted.UnlitWallMount;
import net.dark_roleplay.medieval.mess.common.objects.blocks.minerals.AdvancedOre;
import net.dark_roleplay.medieval.mess.common.objects.blocks.other.BeeHive;
import net.dark_roleplay.medieval.mess.common.objects.blocks.other.gunpowder_trail.GunpowderTrail;
import net.dark_roleplay.medieval.mess.common.objects.blocks.plants.Barley;
import net.dark_roleplay.medieval.mess.common.objects.blocks.plants.Hops;
import net.dark_roleplay.medieval.mess.common.objects.blocks.plants.mushrooms.Mushroom;
import net.dark_roleplay.medieval.mess.common.objects.blocks.rotary.Axle;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.Crate;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.DungeonChest;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.barrels.FluidBarrel;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.barrels.TE_FluidBarrel;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.shelf.Shelf;
import net.dark_roleplay.medieval.mess.common.objects.blocks.storage.shelf.TE_Shelf;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.RopeCoilTileEntity;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TE_DungeonChest;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityAnvil;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityBookOne;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityCauldron;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityChain;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityCrate;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityFirepit;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityGrindstone;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityHangingCauldron;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityHook;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityKeyHanging;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityMortar;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityRopeAnchor;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityShipsWheel;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntityTarget;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.TileEntity_FlowerStorage;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.lectern.TileEntity_Lectern;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.roof.TE_Roof;
import net.dark_roleplay.medieval.mess.common.objects.blocks.tileentities.storage.TileEntity_SimpleStorage;
import net.dark_roleplay.medieval.mess.common.objects.blocks.util.shop_sign.ShopSign;
import net.dark_roleplay.medieval.mess.common.objects.blocks.util.shop_sign.TE_ShopSign;
import net.dark_roleplay.medieval.mess.common.spinning_wheel.SpinningWheel;
import net.dark_roleplay.medieval.mess.common.spinning_wheel.SpinningWheelTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

public class DRPMedievalBlocks {

	
	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> reg = event.getRegistry();
		
		MaterialRequirements logRequired = new MaterialRequirements("log_side", "log_top");
		MaterialRequirements plankRequired = new MaterialRequirements("plank");
		MaterialRequirements cleanPlankRequired = new MaterialRequirements("clean_plank");

		for(Material mat : MaterialRegistry.getMaterialsForType("wood")){

			if(logRequired.doesFulfillRequirements(mat)) {
					new FirewoodPile(mat.getName() + "_firewood_pile")
					new MossyLog("mossy_" + mat.getName() + "_log")
					new ChoppingBlock(mat.getName() + "_chopping_block")
					register(reg, DRPMedievalCreativeTabs.DECORATION,
					new LogChair(mat.getName() + "_log_chair"),
					new LogBench(mat.getName() + "_log_bench")
				}
			}
			
			if(plankRequired.doesFulfillRequirements(mat)) {
				register(reg, DRPMedievalCreativeTabs.DECORATION,
					new BarrelEmpty(mat.getName() + "_empty_barrel"),
					new BarrelClosed(mat.getName() + "_closed_barrel"),
					new BarrelFilled(mat.getName() + "_gunpowder_barrel"),
					new SidewayBarrel("laying_" + mat.getName() + "_barrel")
					new FluidBarrel(mat.getName() + "_fluid_barrel")
					new Crate(mat.getName() + "_crate"),
					new DungeonChest("simple_" + mat.getName() + "_chest")
				);
			}
			
			if(cleanPlankRequired.doesFulfillRequirements(mat)) {
				Block solidSimpleTable = new SolidSimpleTable("simple_solid_" + mat.getName() + "_table");			
				Block plankSimpleTable = new SimpleTable("simple_plank_" + mat.getName() + "_table");

					ConnectedModelLoader.registerConnectedModelBlock(solidSimpleTable);
					ConnectedModelLoader.registerConnectedModelBlock(plankSimpleTable);
					solidSimpleTable,
					plankSimpleTable,
					new WoodSupport(mat.getName() + "_wood_support"),
					new SimpleChair("simple_plank_" + mat.getName() + "_chair"),
					new BucketDirt(mat.getName() + "_dirt_bucket"),
					new Bucket(mat.getName() + "_empty_bucket"),
					new Bucket(mat.getName() + "_water_bucket")
					new Block(net.minecraft.block.material.Material.WOOD).setRegistryName(mat.getName() + "_clean_plank").setUnlocalizedName(mat.getName() + "_clean_plank")
					new TimberedClay(mat.getName() + "_timbered_clay_clean", 0),
					new TimberedClay(mat.getName() + "_timbered_clay_diagonal_bt", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_diagonal_tb", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_cross", 2),
					new TimberedClay(mat.getName() + "_timbered_clay_double_diagonal_t_bt", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_double_diagonal_b_bt", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_double_diagonal_t_tb", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_double_diagonal_b_tb", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_arrow_b", 2),
					new TimberedClay(mat.getName() + "_timbered_clay_arrow_t", 2),
					new TimberedClay(mat.getName() + "_timbered_clay_arrow_r", 2),
					new TimberedClay(mat.getName() + "_timbered_clay_arrow_l", 2),
					new TimberedClay(mat.getName() + "_timbered_clay_double_diagonal_l_lr", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_double_diagonal_r_lr", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_double_diagonal_l_rl", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_double_diagonal_r_rl", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_vertical", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_horizontal", 1)
					new LargeLectern("large_" + mat.getName() + "_lectern"),
					new Shelf("simple_" + mat.getName() + "_shelf")
				);
			}
			
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
			new MinecartStopper("minecart_stopper"),
			new Scale("golden_scale")
			new AdvancedOre("tin_ore", 1),
			new DryClay("dry_clay"),
			new DryClayGrass("dry_clay_grass"),
			new StonePillar("andesite_pillar"),
			new AdvancedOre("copper_ore", 1),
			new StonePillar("diorite_pillar"),
			new StonePillar("granite_pillar"),
			new ObsidianGlass("obsidian_glass"),
			new PackedIceBricks("packed_ice_bricks"),
			new AdvancedOre("salpeter_ore", 1),
			new AdvancedOre("sulfur_ore", 1),
			new AdvancedOre("silver_ore", 2),
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
			new RopeAnchor("rope_anchor"),
			new SpinningWheel("spinning_wheel"),
			new Mushroom("mushroom_brown"),
			new Mushroom("mushroom_red")
			new Forge("forge"),
			new SimpleCarpenterWorkbench("simple_carpenter_workbench"),
			new Barley("barley"),
			new Hops("hops"),
			new GunpowderTrail("gunpowder_trail"),
			new HangingBridge("hanging_bridge_bottom" ,0F),
			new HangingBridge("hanging_bridge_top" ,0.5F)
		);
		
		GameRegistry.registerTileEntity(TE_ClockCore.class, new ResourceLocation(References.MODID, "te_clock_core"));
		GameRegistry.registerTileEntity(TE_ShopSign.class, new ResourceLocation(References.MODID,"te_shop_sign"));
        GameRegistry.registerTileEntity(TE_Shelf.class, new ResourceLocation(References.MODID, "te_shelf"));
		GameRegistry.registerTileEntity(TileEntityAnvil.class, new ResourceLocation(References.MODID, "TileEntityAnvil"));
		GameRegistry.registerTileEntity(TileEntityMortar.class, new ResourceLocation(References.MODID, "TileEntityMortar"));
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, new ResourceLocation(References.MODID, "TileEntityGrindstone"));
		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, new ResourceLocation(References.MODID, "TileEntityHangingCauldron"));
		GameRegistry.registerTileEntity(TileEntityBookOne.class, new ResourceLocation(References.MODID, "TileEntityBookOne"));
		GameRegistry.registerTileEntity(TileEntityCauldron.class, new ResourceLocation(References.MODID, "TileEntityCauldron"));
		GameRegistry.registerTileEntity(TileEntityChain.class, new ResourceLocation(References.MODID, "TileEntityChain"));
		GameRegistry.registerTileEntity(TileEntityHook.class, new ResourceLocation(References.MODID, "TileEntityHook"));
		GameRegistry.registerTileEntity(TileEntityKeyHanging.class, new ResourceLocation(References.MODID, "TileEntityKeyHanging"));
		GameRegistry.registerTileEntity(TileEntityShipsWheel.class, new ResourceLocation(References.MODID, "TileEntityShipsWheel"));
		GameRegistry.registerTileEntity(TileEntityTarget.class, new ResourceLocation(References.MODID, "TileEntityTarget"));
		GameRegistry.registerTileEntity(TileEntityRopeAnchor.class, new ResourceLocation(References.MODID, "TileEntityRopeAnchor"));
		GameRegistry.registerTileEntity(TileEntityFirepit.class, new ResourceLocation(References.MODID, "TileEntityFirepit"));
        GameRegistry.registerTileEntity(TileEntity_FlowerStorage.class, new ResourceLocation(References.MODID, "BucketTileEntity"));
        GameRegistry.registerTileEntity(RopeCoilTileEntity.class, new ResourceLocation(References.MODID, "rope_coil_tilenentity"));
		
		// Storage Blocks
        //New Storage
        GameRegistry.registerTileEntity(TE_Roof.class, new ResourceLocation(References.MODID, "tile_entity_roof"));
        GameRegistry.registerTileEntity(TileEntity_SimpleStorage.class, new ResourceLocation(References.MODID, "tile_entity_simple_storage"));
        GameRegistry.registerTileEntity(TileEntity_Lectern.class, new ResourceLocation(References.MODID, "tile_entity_lectern"));
        GameRegistry.registerTileEntity(TE_FluidBarrel.class, new ResourceLocation(References.MODID, "tile_entity_fluid_barrel"));

        //Old Storage
		GameRegistry.registerTileEntity(TileEntityCrate.class, new ResourceLocation(References.MODID, "TilEntityCrate"));
		GameRegistry.registerTileEntity(TE_DungeonChest.class, new ResourceLocation(References.MODID, "TileEntityDungeonChest"));
		
		//New Test Things
		GameRegistry.registerTileEntity(SpinningWheelTileEntity.class, new ResourceLocation(References.MODID, "spinning_wheel"));
		GameRegistry.registerTileEntity(FlowersTileEntity.class, new ResourceLocation(References.MODID, "flower_container"));
		
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
