package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.dark_roleplay.core_modules.maarg.api.arg.MaterialRequirements;
import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.dark_roleplay.library.experimental.blocks.behaviors.IBoundingBoxBehavior;
import net.dark_roleplay.library.experimental.connected_model.ConnectedModelLoader;
import net.dark_roleplay.library.util.InDevUtil;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.Settings;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.AxisBoundingBox;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_Bell;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_CanPlaceChains;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_Chair;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_ClockCore;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_Container;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_CraftingStation;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_DrawBanner;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_FlowerContainer;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.FacedBoundingBox;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.chopping_block.ChoppingBlockActivation;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.AxisBlock;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.PillarBlock;
import net.dark_roleplay.medieval.common.objects.blocks.old.AdvancedOre;
import net.dark_roleplay.medieval.common.objects.blocks.old.BeesWaxCandle;
import net.dark_roleplay.medieval.common.objects.blocks.old.ClockDial;
import net.dark_roleplay.medieval.common.objects.blocks.old.DryClay;
import net.dark_roleplay.medieval.common.objects.blocks.old.DryClayGrass;
import net.dark_roleplay.medieval.common.objects.blocks.old.DungeonChest;
import net.dark_roleplay.medieval.common.objects.blocks.old.Forge;
import net.dark_roleplay.medieval.common.objects.blocks.old.HangingBridge;
import net.dark_roleplay.medieval.common.objects.blocks.old.HangingCauldron;
import net.dark_roleplay.medieval.common.objects.blocks.old.Hops;
import net.dark_roleplay.medieval.common.objects.blocks.old.JuicePress;
import net.dark_roleplay.medieval.common.objects.blocks.old.Lantern;
import net.dark_roleplay.medieval.common.objects.blocks.old.LargeLectern;
import net.dark_roleplay.medieval.common.objects.blocks.old.LogBench;
import net.dark_roleplay.medieval.common.objects.blocks.old.MossyLog;
import net.dark_roleplay.medieval.common.objects.blocks.old.NormalRoof;
import net.dark_roleplay.medieval.common.objects.blocks.old.Rope;
import net.dark_roleplay.medieval.common.objects.blocks.old.RopeAnchor;
import net.dark_roleplay.medieval.common.objects.blocks.old.RopeFence;
import net.dark_roleplay.medieval.common.objects.blocks.old.Shelf;
import net.dark_roleplay.medieval.common.objects.blocks.old.ShopSign;
import net.dark_roleplay.medieval.common.objects.blocks.old.SidewayBarrel;
import net.dark_roleplay.medieval.common.objects.blocks.old.SimpleCarpenterWorkbench;
import net.dark_roleplay.medieval.common.objects.blocks.old.SimpleTable;
import net.dark_roleplay.medieval.common.objects.blocks.old.SolidSimpleTable;
import net.dark_roleplay.medieval.common.objects.blocks.old.Target;
import net.dark_roleplay.medieval.common.objects.blocks.old.TimberedClay;
import net.dark_roleplay.medieval.common.objects.blocks.old.WoodSupport;
import net.dark_roleplay.medieval.common.objects.blocks.old.WorkTable;
import net.dark_roleplay.medieval.common.objects.blocks.old.wall_mounted.EmptyWallMount;
import net.dark_roleplay.medieval.common.objects.blocks.old.wall_mounted.LitWallMount;
import net.dark_roleplay.medieval.common.objects.blocks.old.wall_mounted.UnlitWallMount;
import net.dark_roleplay.medieval.common.objects.blocks.old.wall_mounted.WallMounted;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Banner;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ChoppingBlock;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ClockCore;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_DungeonChest;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FlowerContainer;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_FluidBarrel;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Roof;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_Shelf;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ShopSign;
import net.dark_roleplay.medieval.common.objects.blocks.vanilla_overwrites.TorchOverride;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityAnvil;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityBookOne;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityCauldron;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityChain;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityCrate;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityFirepit;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityGrindstone;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityHangingCauldron;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityHook;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityKeyHanging;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityMortar;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityRopeAnchor;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityShipsWheel;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntityTarget;
import net.dark_roleplay.medieval.common.objects.tile_entities.old.TileEntity_Lectern;
import net.dark_roleplay.medieval.handler.ItemRegistryHandler;
import net.dark_roleplay.medieval.testing.blocks.spinning_wheel.SpinningWheel;
import net.dark_roleplay.medieval.testing.blocks.spinning_wheel.SpinningWheelTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = References.MODID)
@ObjectHolder(References.MODID)
public class MedievalBlocks {

	//Blockss

	public static final Block
	 DRY_CLAY = null,
	 DRY_CLAY_GRASS = null,
	 ANVIL = null,
	 GRINDSTONE = null,
	 HANGING_CAULDRON = null,
	 MORTAR = null,
	 CAULDRON = null,
	 ROPE_ANCHOR = null,
	 FIREPIT_LIT = null,
	 ROPE = null,
	 ROPE_FENCE = null,
	 FORGE = null,
	 SIMPLE_CARPENTER_WORKBENCH = null,
	 OAK_TIMBERED_CLAY_CLEAN = null,
	 OBSIDIAN_GLASS = null,
	 UNFIRED_VASE = null,
	 FIRED_VASE = null,
	 HANGING_BRIDGE_BOTTOM = null,
	 HANGING_BRIDGE_TOP = null,
	 CLOCK_CORE = null,
	 IRON_HOOK = null,
	 BEESWAX_CANDLE = null;

	public static final EmptyWallMount CANDLE_HOLDER_EMPTY = null;
	public static final UnlitWallMount CANDLE_HOLDER_UNLIT = null;
	public static final LitWallMount CANDLE_HOLDER_LIT = null;

	public static final AdvancedOre
	 SALPETER_ORE = null,
	 SILVER_ORE = null,
	 TIN_ORE = null,
	 COPPER_ORE = null,
	 SULFUR_ORE = null;

	public static final EmptyWallMount TORCH_HOLDER_EMPTY = null;
	public static final UnlitWallMount TORCH_HOLDER_UNLIT = null;
	public static final LitWallMount TORCH_HOLDER_LIT = null;

	public static final Block CHAIN = null;

	//	new Rope("rope"),
	//	new RopeAnchor("rope_anchor"),

	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Block> registryEvent) {
		IForgeRegistry<Block> reg = registryEvent.getRegistry();

		MaterialRequirements logRequired = new MaterialRequirements("log_side", "log_top");
		MaterialRequirements plankRequired = new MaterialRequirements("planks");
		MaterialRequirements cleanPlankRequired = new MaterialRequirements("clean_planks");



		for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
			if(logRequired.doesFulfillRequirements(mat)) {
				register(reg, MedievalCreativeTabs.UTILITY,
					new FacedBlock(mat.getName() + "_chopping_block", Settings.WOOD_DECO)
						.addBehaviors(
								new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.0625f, 0F, 0.0625f, 0.9375f, 0.75f, 0.9375f)),
								new ChoppingBlockActivation()
								//new Behavior_CraftingStation()
						).setTileEntityFactory(TE_ChoppingBlock::new),
					new DRPBlock(mat.getName() + "_crate", Settings.WOOD_DECO)
						.addBehaviors(
								new Behavior_Container()).setTileEntityFactory(() -> new DynamicStorageTileEntity(18)
						)
				);

				register(reg, MedievalCreativeTabs.BUILDING_MATS,
					new MossyLog("mossy_" + mat.getName() + "_log"), //TODO Update to DRPBlock
					new WoodSupport(mat.getName() + "_wood_support", Settings.WOOD_DECO) //TODO Update to DRPBlock
				);

				register(reg, MedievalCreativeTabs.DECORATION,
					new LogBench(mat.getName() + "_log_bench", Settings.WOOD_DECO)
						.addBehaviors(new Behavior_Chair(0.25F)), //TODO Update to DRPBlock
					new FacedBlock(mat.getName() + "_log_chair", Settings.WOOD_DECO)
						.addBehaviors(new Behavior_Chair(0.1875F)),
					new AxisBlock(mat.getName() + "_firewood_pile", Settings.WOOD_DECO)
				);

				if(plankRequired.doesFulfillRequirements(mat)) {
					register(reg, MedievalCreativeTabs.UTILITY,
						new DungeonChest("simple_" + mat.getName() + "_chest", Settings.WOOD_DECO)
							.setTileEntityFactory(TE_DungeonChest::new)//TODO Update to DRPBlock
					);
				}

				if(cleanPlankRequired.doesFulfillRequirements(mat)) {
					register(reg, MedievalCreativeTabs.UTILITY,
							new WorkTable(mat.getName() + "_work_table") //TODO Update to DRPBlock  //TODO fix Settings
					);
				}
			}

			if(plankRequired.doesFulfillRequirements(mat)) {
				register(reg, MedievalCreativeTabs.DECORATION,
					new FacedBlock(mat.getName() + "_barrel_chair", Settings.WOOD_DECO).addBehaviors(new Behavior_Chair(0.3125f)),
					new AxisBlock(mat.getName() + "_barrel_table", Settings.WOOD_DECO),
					new DRPBlock(mat.getName() + "_empty_barrel", Settings.WOOD_DECO),
					new DRPBlock(mat.getName() + "_closed_barrel", Settings.WOOD_DECO),
					new DRPBlock(mat.getName() + "_gunpowder_barrel", Settings.WOOD_DECO),
					new DRPBlock(mat.getName() + "_fluid_barrel", Settings.WOOD_DECO).setTileEntityFactory(TE_FluidBarrel::new),
					new SidewayBarrel("laying_" + mat.getName() + "_barrel", Settings.WOOD_DECO) //TODO Update to DRPBlock
				);
			}

			if(cleanPlankRequired.doesFulfillRequirements(mat)) {
				Block solidSimpleTable = new SolidSimpleTable("simple_solid_" + mat.getName() + "_table"); //TODO Update to DRPBlock
				Block plankSimpleTable = new SimpleTable("simple_plank_" + mat.getName() + "_table"); //TODO Update to DRPBlock

				ConnectedModelLoader.registerConnectedModelBlock(solidSimpleTable);
				ConnectedModelLoader.registerConnectedModelBlock(plankSimpleTable);

				register(reg, MedievalCreativeTabs.BUILDING_MATS,
					new DRPBlock(mat.getName() + "_clean_plank", Settings.WOOD_SOLID)
				);

				register(reg, MedievalCreativeTabs.UTILITY,
					new Shelf("simple_" + mat.getName() + "_shelf", Settings.WOOD_DECO).setTileEntityFactory(TE_Shelf::new), //TODO Update to DRPBlock
					new LargeLectern("large_" + mat.getName() + "_lectern") //TODO Update to DRPBlock
				);

				register(reg, MedievalCreativeTabs.DECORATION,
					new FacedBlock("simple_plank_" + mat.getName() + "_chair", Settings.WOOD_DECO).addBehaviors(new Behavior_Chair(0.3125F)).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.0625f, 0f, 0.0625f, 0.9375f, 1f, 0.9375f))),
					new AxisBlock(mat.getName() + "_empty_bucket", Settings.WOOD_DECO).addBehaviors(new AxisBoundingBox(new AxisAlignedBB(0.21875F, 0f, 0.21875F, 0.78125f, 0.5625f, 0.78125F))),
					new AxisBlock(mat.getName() + "_water_bucket", Settings.WOOD_DECO).addBehaviors(new AxisBoundingBox(new AxisAlignedBB(0.21875F, 0f, 0.21875F, 0.78125f, 0.5625f, 0.78125F))),
					new AxisBlock(mat.getName() + "_dirt_bucket", Settings.WOOD_DECO).addBehaviors(new AxisBoundingBox(new AxisAlignedBB(0.21875F, 0f, 0.21875F, 0.78125f, 0.5625f, 0.78125F)), new Behavior_FlowerContainer()).setTileEntityFactory(() -> new TE_FlowerContainer(3)),
					new AxisBlock(mat.getName() + "_flower_pot", Settings.WOOD_DECO).addBehaviors(new AxisBoundingBox(new AxisAlignedBB(0.21875f, 0f, 0f, 0.78125f, 0.5625f, 1f)), new Behavior_FlowerContainer()).setTileEntityFactory(() -> new TE_FlowerContainer(3)),
					solidSimpleTable,
					plankSimpleTable
				);

				registerNoItems(reg,  //TODO Update to DRPBlock
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
				);
			}
		}

		//Crafting Stations Tab
		register(reg, MedievalCreativeTabs.UTILITY,
			new FacedBlock("minecart_stopper", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0.0625f, 0f, 0f, 0.9375, 1f, 0.875f))),
			new FacedBlock("butter_churn", Settings.WOOD_DECO).addBehaviors(new Behavior_CraftingStation(), new FacedBoundingBox(new AxisAlignedBB(0.4375f, 0f, 0.3125f , 0.8125f, 0.75f, 0.6875f))),
			new FacedBlock("spinning_wheel", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0.3125f, 0f, 0f, 1f, 0.6875f, 1f)), new Behavior_CraftingStation()),
			new FacedBlock("grindstone", Settings.WOOD_DECO).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.0625f, 0F, 0.0625f, 0.9375f, 0.9375f, 0.9375f)),new Behavior_CraftingStation()).setTileEntityFactory(TileEntityGrindstone::new), //TODO fix Settings
			new DRPBlock("firepit_lit", Settings.STONE_DECO_TESR).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0f, 0F, 0f, 1f, 0.5f, 1f)),new Behavior_CraftingStation()).setTileEntityFactory(TileEntityFirepit::new), //TODO fix Settings
			new FacedBlock("cauldron", Settings.METAL_DECO_TESR).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.0625f, 0F, 0.0625f, 0.9375f, 1f, 0.9375f)),new Behavior_CraftingStation()).setTileEntityFactory(TileEntityCauldron::new), //TODO fix Settings
			new FacedBlock("anvil", Settings.METAL_DECO_TESR).addBehaviors(new Behavior_CraftingStation(), new FacedBoundingBox(new AxisAlignedBB(0F, 0F, 0.1875F, 1F, 1F, 0.8125F))).setTileEntityFactory(TileEntityAnvil::new), //TODO fix Settings
			new FacedBlock("mortar", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0.25f, 0f, 0.25f, 0.75f, 0.25f, 0.75f)), new Behavior_CraftingStation()).setTileEntityFactory(TileEntityMortar::new), //TODO fix Settings
			new FacedBlock("clock_core", Settings.WOOD_DECO).setTileEntityFactory(TE_ClockCore::new).addBehaviors(new Behavior_ClockCore()),
			new FacedBlock("pottery_turntable", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0f, 0f, 0.0625f, 1f, 0.9375f, 0.9375f)), new Behavior_CraftingStation()),
			new HangingCauldron("hanging_cauldron"), //TODO Update to DRPBlock  //TODO fix Settings
			new JuicePress("juice_press", Settings.WOOD_DECO).addBehaviors(new Behavior_CraftingStation()) //TODO Update to DRPBlock  //TODO fix Settings
		);

		//Decoration Tab
		//	new Chain("chain"),
		//	new Hook("iron_hook"),
		register(reg, MedievalCreativeTabs.DECORATION,
			new FacedBlock("long_hanging_banner", Settings.WOOD_DECO_TESR).setTileEntityFactory(TE_Banner::new).addBehaviors(new Behavior_DrawBanner()),
			new FacedBlock("chain", Settings.METAL_DECO_TESR).setTileEntityFactory(TileEntityChain::new).addBehaviors(new Behavior_CanPlaceChains(), new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.375F, 0F, 0.375F, 0.625F, 1F, 0.625F))),
			new FacedBlock("iron_hook", Settings.METAL_DECO_TESR).setTileEntityFactory(TileEntityHook::new).addBehaviors(new Behavior_CanPlaceChains(), new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.3125F, 0.375F, 0.3125F, 0.6875F, 1F, 0.6875F))),
			new FacedBlock("golden_scale", Settings.METAL_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0f, 0f, 0.25f, 1f, 1f, 0.75f))),
			new FacedBlock("mug_beer", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0.3125f, 0f, 0.3125f, 0.6875f, 0.4375f, 0.6875f))),
			new FacedBlock("mug_empty", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0.3125f, 0f, 0.3125f, 0.6875f, 0.4375f, 0.6875f))),
			new Rope("rope"),
			new RopeAnchor("rope_anchor"),
			new WallMounted("key_hanging", Settings.METAL_DECO_TESR, new AxisAlignedBB(0.3125F, 0.125F, 0.8125F, 0.6875F, 0.875F, 1F)).setTileEntityFactory(TileEntityKeyHanging::new),
			new DRPBlock("unfired_vase", Settings.WOOD_DECO).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.3125f, 0f, 0.3125f, 0.6875f, 0.59375f, 0.6875f))), //TODO fix Settings
			new DRPBlock("fired_vase", Settings.WOOD_DECO).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.3125f, 0f, 0.3125f, 0.6875f, 0.59375f, 0.6875f))), //TODO fix Settings
			new DRPBlock("mushroom_brown", Settings.PLANT_DECO),
			new DRPBlock("mushroom_red", Settings.PLANT_DECO),
			new BeesWaxCandle("beeswax_candle"), //TODO Update to DRPBlock //TODO fix Settings
			new RopeFence("rope_fence"), //TODO Update to DRPBlock //TODO fix Settings
			new FacedBlock("head_cutting_block", Settings.WOOD_DECO).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0f, 0f, 0f, 1f, 0.5f, 1f))),
			new ClockDial("clock_dial", new AxisAlignedBB(0.0F, 0.0F, 0.875F, 1.0, 1.0F, 1.0F)), //TODO Update to DRPBlock
			new DRPBlock("bee_hive", Settings.PAPER_DECO).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.1875f, 0.1875f, 0.1875f, 0.8125f, 1f, 0.8125f))), //TODO Update to DRPBlock
			new EmptyWallMount("candle_holder_empty", Settings.METAL_DECO, new AxisAlignedBB(0.3125F, 0F, 0.5F, 0.6875F, 0.9375F, 1.0F)), //TODO Update to DRPBlock
			new LitWallMount("candle_holder_lit", Settings.METAL_DECO, new AxisAlignedBB(0.3125F, 0F, 0.5F, 0.6875F, 0.9375F, 1.0F), 0.19D, 1.05D), //TODO Update to DRPBlock
			new UnlitWallMount("candle_holder_unlit", Settings.METAL_DECO, new AxisAlignedBB(0.3125F, 0F, 0.5F, 0.6875F, 0.9375F, 1.0F)), //TODO Update to DRPBlock
			new EmptyWallMount("torch_holder_empty", Settings.METAL_DECO, new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F)), //TODO Update to DRPBlock
			new LitWallMount("torch_holder_lit", Settings.METAL_DECO, new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F), 0.23D, 0.82D), //TODO Update to DRPBlock
			new UnlitWallMount("torch_holder_unlit", Settings.METAL_DECO, new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F)), //TODO Update to DRPBlock
			new ShopSign("wall_shop_sign", Settings.METAL_DECO).setTileEntityFactory(TE_ShopSign::new), //TODO Update to DRPBlock
			new WallMounted("ships_helm", Settings.WOOD_DECO_TESR, new AxisAlignedBB(0F, 0F, 0.625F, 1F, 1F, 1F)).setTileEntityFactory(TileEntityShipsWheel::new), //TODO Update to DRPBlock
			new Target("target", Settings.WOOD_DECO_TESR).setTileEntityFactory(TileEntityTarget::new), //TODO Update to DRPBlock
			new Lantern("lantern", new net.minecraft.block.material.Material(MapColor.IRON), new AxisAlignedBB(0.25F, 0F, 0.25F, 0.75F, 0.5F, 0.75F)), //TODO Update to DRPBlock
			new FacedBlock("golden_ship_bell", Settings.METAL_DECO).addBehaviors(new Behavior_Bell(), new FacedBoundingBox(new AxisAlignedBB(0.25f, 0f, 0.25f, 0.75f, 1f, 0.75f)))
		);

		//Building Blocks Tab
		register(reg, MedievalCreativeTabs.BUILDING_MATS,
			new DRPBlock("andesite_bricks", Settings.STONE_SOLID),
			new DRPBlock("diorite_bricks", Settings.STONE_SOLID),
			new DRPBlock("granite_bricks", Settings.STONE_SOLID),
			new PillarBlock("andesite_pillar", Settings.STONE_SOLID),
			new PillarBlock("diorite_pillar", Settings.STONE_SOLID),
			new PillarBlock("granite_pillar", Settings.STONE_SOLID),
			new DRPBlock("snow_bricks", Settings.SNOW_SOLID),
			new DRPBlock("packed_ice_bricks", Settings.PACKED_ICE),//TODO make slippery
			new DRPBlock("obsidian_glass", Settings.OBSIDIAN_GLASS.setBlockRenderLayer(BlockRenderLayer.TRANSLUCENT)), //TODO fix Settings
			new DryClay("dry_clay"), //TODO Update to DRPBlock
			new DryClayGrass("dry_clay_grass"), //TODO Update to DRPBlock
			new AdvancedOre("tin_ore", 1), //TODO Update to DRPBlock
			new AdvancedOre("copper_ore", 1), //TODO Update to DRPBlock
			new AdvancedOre("salpeter_ore", 1), //TODO Update to DRPBlock
			new AdvancedOre("sulfur_ore", 1), //TODO Update to DRPBlock
			new AdvancedOre("silver_ore", 2) //TODO Update to DRPBlock
		);

		registerNoItems(reg,
			new Hops("hops"), //TODO Update to DRPBlock
//			new Barley("barley"), //TODO Update to DRPBlock
			new HangingBridge("hanging_bridge_bottom" ,0F), //TODO Update to DRPBlock
			new HangingBridge("hanging_bridge_top" ,0.5F), //TODO Update to DRPBlock
			new Forge("forge", Settings.METAL_DECO).addBehaviors(new Behavior_CraftingStation()), //TODO Update to DRPBlock  //TODO fix Settings
			new SimpleCarpenterWorkbench("simple_carpenter_workbench", Settings.WOOD_DECO).addBehaviors(new Behavior_CraftingStation()) //TODO Update to DRPBlock  //TODO fix Settings
		);

		if(InDevUtil.isDevEnv()) {
			reg.register(new TorchOverride());
			register(reg, MedievalCreativeTabs.UTILITY,
				new NormalRoof("oak_roof", Settings.WOOD_DECO),
				new SpinningWheel("spinning_wheel2", Settings.WOOD_DECO).setTileEntityFactory(SpinningWheelTileEntity::new).addBehaviors(new Behavior_CraftingStation()) //TODO Update to DRPBlock
			);

			GameRegistry.registerTileEntity(TE_Roof.class, new ResourceLocation(References.MODID, "tile_entity_roof"));
			GameRegistry.registerTileEntity(TileEntity_Lectern.class, new ResourceLocation(References.MODID, "tile_entity_lectern"));
			GameRegistry.registerTileEntity(SpinningWheelTileEntity.class, new ResourceLocation(References.MODID, "spinning_wheel"));
			GameRegistry.registerTileEntity(TE_Banner.class, new ResourceLocation(References.MODID, "tile_entity_banner"));

		}

		//TODO Finally make new models!
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

		//New Storage
		GameRegistry.registerTileEntity(TE_FluidBarrel.class, new ResourceLocation(References.MODID, "tile_entity_fluid_barrel"));
		GameRegistry.registerTileEntity(TE_Shelf.class, new ResourceLocation(References.MODID, "te_shelf"));
		GameRegistry.registerTileEntity(TE_ChoppingBlock.class, new ResourceLocation(References.MODID, "te_chopping_block"));

		GameRegistry.registerTileEntity(TE_ClockCore.class, new ResourceLocation(References.MODID, "te_clock_core"));
		GameRegistry.registerTileEntity(TE_ShopSign.class, new ResourceLocation(References.MODID,"te_shop_sign"));

		//Old Storage
		GameRegistry.registerTileEntity(DynamicStorageTileEntity.class, new ResourceLocation(References.MODID, "te_dynamic_storage"));
		GameRegistry.registerTileEntity(TileEntityCrate.class, new ResourceLocation(References.MODID, "TilEntityCrate"));
		GameRegistry.registerTileEntity(TE_DungeonChest.class, new ResourceLocation(References.MODID, "TileEntityDungeonChest"));

		//New Test Things
		GameRegistry.registerTileEntity(TE_FlowerContainer.class, new ResourceLocation(References.MODID, "flower_container"));
	}

	protected static void register(IForgeRegistry<Block> reg, CreativeTabs creativeTab, Block... blocks){
		for(Block block : blocks){
			block.setCreativeTab(creativeTab);
			ItemBlock itemBlock = (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
			ItemRegistryHandler.addBlockItem(itemBlock);
			MedievalModels.addItemToRegisterMesh(itemBlock);
		}
		reg.registerAll(blocks);
	}

	protected static void registerNoItems(IForgeRegistry<Block> reg, Block... blocks){
		reg.registerAll(blocks);
	}
}
