package net.dark_roleplay.medieval.handler;

import java.util.Random;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.dark_roleplay.core_modules.maarg.api.arg.MaterialRequirements;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.dark_roleplay.library.experimental.blocks.behaviors.IBoundingBoxBehavior;
import net.dark_roleplay.library.util.InDevUtil;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.objects.barrel.Barrel;
import net.dark_roleplay.medieval.common.objects.barrel.ItemBarrel;
import net.dark_roleplay.medieval.common.objects.barrel.TileEntityBarrel;
import net.dark_roleplay.medieval.holders.MedievalBlockProperties;
import net.dark_roleplay.medieval.holders.MedievalBlockProperties.Settings;
import net.dark_roleplay.medieval.holders.MedievalCreativeTabs;
import net.dark_roleplay.medieval.objects.blocks.building.advanced_ore.AdvancedOre;
import net.dark_roleplay.medieval.objects.blocks.building.dirt_stairs.DirtStairs;
import net.dark_roleplay.medieval.objects.blocks.building.double_arch.DoubleArch;
import net.dark_roleplay.medieval.objects.blocks.building.double_arch.behaviors.StoneArchPlacement;
import net.dark_roleplay.medieval.objects.blocks.building.dry_clay.DryClay;
import net.dark_roleplay.medieval.objects.blocks.building.dry_clay.DryClayGrass;
import net.dark_roleplay.medieval.objects.blocks.building.hanging_bridge.HangingBridge;
import net.dark_roleplay.medieval.objects.blocks.building.mossy_log.MossyLog;
import net.dark_roleplay.medieval.objects.blocks.building.roofs.Roof;
import net.dark_roleplay.medieval.objects.blocks.building.simple_wood_stairs.SimpleWoodStairs;
import net.dark_roleplay.medieval.objects.blocks.building.timbered_clay.TimberedClay;
import net.dark_roleplay.medieval.objects.blocks.building.wood_supports.WoodSupport;
import net.dark_roleplay.medieval.objects.blocks.building.wooden_window.WoodenWindow;
import net.dark_roleplay.medieval.objects.blocks.decoration.advent_wreath.AdventWreath;
import net.dark_roleplay.medieval.objects.blocks.decoration.advent_wreath.behaviors.CandleLighting;
import net.dark_roleplay.medieval.objects.blocks.decoration.advent_wreath.behaviors.CandleParticles;
import net.dark_roleplay.medieval.objects.blocks.decoration.barrels.SidewayBarrel;
import net.dark_roleplay.medieval.objects.blocks.decoration.barrels.TileEntityFluidBarrel;
import net.dark_roleplay.medieval.objects.blocks.decoration.barrels.behaviors.Behavior_EmptyBarrel;
import net.dark_roleplay.medieval.objects.blocks.decoration.barrels.behaviors.Behavior_FluidFill;
import net.dark_roleplay.medieval.objects.blocks.decoration.candles.BeesWaxCandle;
import net.dark_roleplay.medieval.objects.blocks.decoration.clock_dial.ClockDial;
import net.dark_roleplay.medieval.objects.blocks.decoration.flower_container.TileEntityFlowerContainer;
import net.dark_roleplay.medieval.objects.blocks.decoration.flower_container.behaviors.FlowerContainer;
import net.dark_roleplay.medieval.objects.blocks.decoration.lantern.Lantern;
import net.dark_roleplay.medieval.objects.blocks.decoration.log_bench.LogBench;
import net.dark_roleplay.medieval.objects.blocks.decoration.rope.Rope;
import net.dark_roleplay.medieval.objects.blocks.decoration.rope.RopeAnchor;
import net.dark_roleplay.medieval.objects.blocks.decoration.rope_fence.RopeFence;
import net.dark_roleplay.medieval.objects.blocks.decoration.shop_signs.ShopSign;
import net.dark_roleplay.medieval.objects.blocks.decoration.shop_signs.TileEntityShopSign;
import net.dark_roleplay.medieval.objects.blocks.decoration.tables.simple_table.SimpleTable;
import net.dark_roleplay.medieval.objects.blocks.decoration.tables.simple_table.SolidSimpleTable;
import net.dark_roleplay.medieval.objects.blocks.decoration.target.Target;
import net.dark_roleplay.medieval.objects.blocks.decoration.wall_mounted.EmptyWallMount;
import net.dark_roleplay.medieval.objects.blocks.decoration.wall_mounted.LitWallMount;
import net.dark_roleplay.medieval.objects.blocks.decoration.wall_mounted.UnlitWallMount;
import net.dark_roleplay.medieval.objects.blocks.decoration.wall_mounted.WallMounted;
import net.dark_roleplay.medieval.objects.blocks.general.AxisBlock;
import net.dark_roleplay.medieval.objects.blocks.general.FacedBlock;
import net.dark_roleplay.medieval.objects.blocks.general.PillarBlock;
import net.dark_roleplay.medieval.objects.blocks.general.behaviors.AxisBoundingBox;
import net.dark_roleplay.medieval.objects.blocks.general.behaviors.Behavior_Bell;
import net.dark_roleplay.medieval.objects.blocks.general.behaviors.Behavior_CanPlaceChains;
import net.dark_roleplay.medieval.objects.blocks.general.behaviors.Behavior_Chair;
import net.dark_roleplay.medieval.objects.blocks.general.behaviors.Behavior_ClockCore;
import net.dark_roleplay.medieval.objects.blocks.general.behaviors.Behavior_Container;
import net.dark_roleplay.medieval.objects.blocks.general.behaviors.Behavior_CraftingStation;
import net.dark_roleplay.medieval.objects.blocks.general.behaviors.FacedBoundingBox;
import net.dark_roleplay.medieval.objects.blocks.general.behaviors.placing.CeilingRequired;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityAnvil;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityCauldron;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityChain;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityFirepit;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityGrindstone;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityHook;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityKeyHanging;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityMortar;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityShipsWheel;
import net.dark_roleplay.medieval.objects.blocks.other.old_tesr.TileEntityTarget;
import net.dark_roleplay.medieval.objects.blocks.plants.hops.Hops;
import net.dark_roleplay.medieval.objects.blocks.plants.mushrooms.Mushrooms;
import net.dark_roleplay.medieval.objects.blocks.utility.crafting.carpenter_workbench.simple_carpenter_workbench.SimpleCarpenterWorkbench;
import net.dark_roleplay.medieval.objects.blocks.utility.crafting.cauldron.HangingCauldron;
import net.dark_roleplay.medieval.objects.blocks.utility.crafting.chopping_block.TileEntityChoppingBlock;
import net.dark_roleplay.medieval.objects.blocks.utility.crafting.forge.Forge;
import net.dark_roleplay.medieval.objects.blocks.utility.crafting.juice_press.JuicePress;
import net.dark_roleplay.medieval.objects.blocks.utility.other.clock_core.TileEntityClockCore;
import net.dark_roleplay.medieval.objects.blocks.utility.other.lecterns.large_lectern.LargeLectern;
import net.dark_roleplay.medieval.objects.blocks.utility.other.work_table.WorkTable;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.chests.simple_chest.SimpleChest;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.chests.simple_chest.TileEntitySimpleChest;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.shelfs.Shelf;
import net.dark_roleplay.medieval.objects.blocks.utility.storage.shelfs.TileEntityShelf;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = References.MODID)
public class BlockRegistryHandler {

	private static final MaterialRequirements logRequired = new MaterialRequirements("log_side", "log_top");
	private static final MaterialRequirements plankRequired = new MaterialRequirements("planks");
	private static final MaterialRequirements cleanPlankRequired = new MaterialRequirements("clean_planks");

	private static final IItemPropertyGetter isClosedGetter = (stack, world, entity) -> {
		if(!stack.hasTagCompound()) return 1F;
		else if(stack.getTagCompound().hasKey("is_closed")) return stack.getTagCompound().getBoolean("is_closed") ? 1F : 1F;
		return 1F;
	};

	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Block> registryEvent) {
		IForgeRegistry<Block> reg = registryEvent.getRegistry();

		register(reg, MedievalCreativeTabs.BUILDING_MATS,
			new Roof("clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("white_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("orange_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("magenta_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("light_blue_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("yellow_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("light_green_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("pink_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("gray_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("light_gray_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("cyan_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("purple_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("blue_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("brown_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("green_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("red_clay_shingle_roof", Settings.WOOD_ROOF),
			new Roof("black_clay_shingle_roof", Settings.WOOD_ROOF),
			new DirtStairs("dirt_stairs", Settings.STONE_DECO),
			new DoubleArch("stone_brick_double_arch", Settings.STONE_DECO).addBehaviors(StoneArchPlacement.INSTANCE),
			new DRPBlock("andesite_bricks", Settings.STONE_SOLID),
			new DRPBlock("diorite_bricks", Settings.STONE_SOLID),
			new DRPBlock("granite_bricks", Settings.STONE_SOLID),
			new PillarBlock("andesite_pillar", Settings.STONE_SOLID),
			new PillarBlock("diorite_pillar", Settings.STONE_SOLID),
			new PillarBlock("granite_pillar", Settings.STONE_SOLID),
			new DRPBlock("snow_bricks", Settings.SNOW_SOLID),
			new DRPBlock("packed_ice_bricks", Settings.PACKED_ICE),//TODO make slippery
			new DryClay("dry_clay"), //TODO Update to DRPBlock
			new DryClayGrass("dry_clay_grass"), //TODO Update to DRPBlock
			new AdvancedOre("tin_ore", 1), //TODO Update to DRPBlock
			new AdvancedOre("copper_ore", 1), //TODO Update to DRPBlock
			new AdvancedOre("salpeter_ore", 1), //TODO Update to DRPBlock
			new AdvancedOre("sulfur_ore", 1), //TODO Update to DRPBlock
			new AdvancedOre("silver_ore", 2), //TODO Update to DRPBlock
			new DRPBlock("obsidian_glass", Settings.OBSIDIAN_GLASS.setBlockRenderLayer(BlockRenderLayer.TRANSLUCENT)) {
			    @Override
				@SideOnly(Side.CLIENT)
			    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side){
			        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));

			        return blockState != iblockstate;
			    }
			}
		);

		register(reg, MedievalCreativeTabs.DECORATION,
			new FacedBlock("minecart_stopper", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0.0625f, 0f, 0f, 0.9375, 1f, 0.875f))),
			new DRPBlock("mistletoe", MedievalBlockProperties.Settings.PLANT_DECO) {
				@Override public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {return NULL_AABB;}
			}.addBehaviors(CeilingRequired.INSTANCE, new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.25F, 0.1875F, 0.25F, 0.75F, 1.0F, 0.75F))),
			new AdventWreath("advent_wreath", MedievalBlockProperties.Settings.PLANT_DECO).addBehaviors(new CandleLighting(), new CandleParticles(), new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0F, 0F, 0F, 1F, 0.6825F, 1F))) //TODO Make behavior Singleton
		);

		register(reg, MedievalCreativeTabs.UTILITY,
			new FacedBlock("butter_churn", Settings.WOOD_DECO).addBehaviors(new Behavior_CraftingStation(), new FacedBoundingBox(new AxisAlignedBB(0.4375f, 0f, 0.3125f , 0.8125f, 0.75f, 0.6875f))),
			new FacedBlock("spinning_wheel", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0.3125f, 0f, 0f, 1f, 0.6875f, 1f)), new Behavior_CraftingStation()),
			new FacedBlock("grindstone", Settings.STONE_DECO).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.0625f, 0F, 0.0625f, 0.9375f, 0.9375f, 0.9375f)),new Behavior_CraftingStation()).setTileEntityFactory(TileEntityGrindstone::new), //TODO fix Settings
			new DRPBlock("firepit_lit", Settings.STONE_DECO_TESR).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0f, 0F, 0f, 1f, 0.5f, 1f)),new Behavior_CraftingStation()).setTileEntityFactory(TileEntityFirepit::new), //TODO fix Settings
			new FacedBlock("cauldron", Settings.METAL_DECO_TESR).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.0625f, 0F, 0.0625f, 0.9375f, 1f, 0.9375f)),new Behavior_CraftingStation()).setTileEntityFactory(TileEntityCauldron::new), //TODO fix Settings
			new FacedBlock("anvil", Settings.METAL_DECO_TESR).addBehaviors(new Behavior_CraftingStation(), new FacedBoundingBox(new AxisAlignedBB(0F, 0F, 0.1875F, 1F, 1F, 0.8125F))).setTileEntityFactory(TileEntityAnvil::new), //TODO fix Settings
			new FacedBlock("mortar", Settings.STONE_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0.25f, 0f, 0.25f, 0.75f, 0.25f, 0.75f)), new Behavior_CraftingStation()).setTileEntityFactory(TileEntityMortar::new), //TODO fix Settings
			new FacedBlock("clock_core", Settings.WOOD_DECO).setTileEntityFactory(TileEntityClockCore::new).addBehaviors(new Behavior_ClockCore()),
			new FacedBlock("pottery_turntable", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0f, 0f, 0.0625f, 1f, 0.9375f, 0.9375f)), new Behavior_CraftingStation()),
			new HangingCauldron("hanging_cauldron"), //TODO Update to DRPBlock  //TODO fix Settings
			new JuicePress("juice_press", Settings.WOOD_DECO).addBehaviors(new Behavior_CraftingStation()) //TODO Update to DRPBlock  //TODO fix Settings
		);

		register(reg, MedievalCreativeTabs.DECORATION,
			new FacedBlock("chain", Settings.METAL_DECO_TESR).setTileEntityFactory(TileEntityChain::new).addBehaviors(new Behavior_CanPlaceChains(), new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.375F, 0F, 0.375F, 0.625F, 1F, 0.625F))),
			new FacedBlock("iron_hook", Settings.METAL_DECO_TESR).setTileEntityFactory(TileEntityHook::new).addBehaviors(new Behavior_CanPlaceChains(), new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.3125F, 0.375F, 0.3125F, 0.6875F, 1F, 0.6875F))),
			new FacedBlock("golden_scale", Settings.METAL_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0f, 0f, 0.25f, 1f, 1f, 0.75f))),
			new FacedBlock("mug_beer", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0.3125f, 0f, 0.3125f, 0.6875f, 0.4375f, 0.6875f))),
			new FacedBlock("mug_empty", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0.3125f, 0f, 0.3125f, 0.6875f, 0.4375f, 0.6875f))),
			new Rope("rope"),
			new RopeAnchor("rope_anchor"),
			new WallMounted("key_hanging", Settings.METAL_DECO_TESR, new AxisAlignedBB(0.3125F, 0.125F, 0.8125F, 0.6875F, 0.875F, 1F)).setTileEntityFactory(TileEntityKeyHanging::new),
			new DRPBlock("unfired_vase", Settings.UNFIRED_POTTERY).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.3125f, 0f, 0.3125f, 0.6875f, 0.59375f, 0.6875f))), //TODO fix Settings
			new DRPBlock("fired_vase", Settings.FIRED_POTTERY).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.3125f, 0f, 0.3125f, 0.6875f, 0.59375f, 0.6875f))), //TODO fix Settings
			new Mushrooms("mushroom_brown", Settings.PLANT_DECO).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0F, 0F, 0F, 1F, 0.5F, 1F))),
			new Mushrooms("mushroom_red", Settings.PLANT_DECO).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0F, 0F, 0F, 1F, 0.5F, 1F))),
			new BeesWaxCandle("beeswax_candle"), //TODO Update to DRPBlock //TODO fix Settings
			new RopeFence("rope_fence"), //TODO Update to DRPBlock //TODO fix Settings
			new FacedBlock("head_cutting_block", Settings.STONE_DECO).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0f, 0f, 0f, 1f, 0.5f, 1f))),
			new ClockDial("clock_dial", new AxisAlignedBB(0.0F, 0.0F, 0.875F, 1.0, 1.0F, 1.0F)), //TODO Update to DRPBlock
			new DRPBlock("bee_hive", Settings.PAPER_DECO).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.1875f, 0.1875f, 0.1875f, 0.8125f, 1f, 0.8125f))), //TODO Update to DRPBlock
			new EmptyWallMount("candle_holder_empty", Settings.METAL_DECO, new AxisAlignedBB(0.3125F, 0F, 0.5F, 0.6875F, 0.9375F, 1.0F)), //TODO Update to DRPBlock
			new LitWallMount("candle_holder_lit", Settings.METAL_DECO, new AxisAlignedBB(0.3125F, 0F, 0.5F, 0.6875F, 0.9375F, 1.0F), 0.19D, 1.05D), //TODO Update to DRPBlock
			new UnlitWallMount("candle_holder_unlit", Settings.METAL_DECO, new AxisAlignedBB(0.3125F, 0F, 0.5F, 0.6875F, 0.9375F, 1.0F)), //TODO Update to DRPBlock
			new EmptyWallMount("torch_holder_empty", Settings.METAL_DECO, new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F)), //TODO Update to DRPBlock
			new LitWallMount("torch_holder_lit", Settings.METAL_DECO, new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F), 0.23D, 0.82D), //TODO Update to DRPBlock
			new UnlitWallMount("torch_holder_unlit", Settings.METAL_DECO, new AxisAlignedBB(0.375F, 0.2F, 0.75F, 0.625F, 0.8F, 1.0F)), //TODO Update to DRPBlock
			new ShopSign("wall_shop_sign", Settings.METAL_DECO).setTileEntityFactory(TileEntityShopSign::new), //TODO Update to DRPBlock
			new WallMounted("ships_helm", Settings.WOOD_DECO_TESR, new AxisAlignedBB(0F, 0F, 0.625F, 1F, 1F, 1F)).setTileEntityFactory(TileEntityShipsWheel::new), //TODO Update to DRPBlock
			new Target("target", Settings.WOOD_DECO_TESR).setTileEntityFactory(TileEntityTarget::new), //TODO Update to DRPBlock
			new Lantern("lantern", new net.minecraft.block.material.Material(MapColor.IRON), new AxisAlignedBB(0.25F, 0F, 0.25F, 0.75F, 0.5F, 0.75F)), //TODO Update to DRPBlock
			new FacedBlock("golden_ship_bell", Settings.METAL_DECO).addBehaviors(new Behavior_Bell(), new FacedBoundingBox(new AxisAlignedBB(0.25f, 0f, 0.25f, 0.75f, 1f, 0.75f)))
		);

		registerNoItems(reg,
				new Hops("hops"), //TODO Update to DRPBlock
//				new Barley("barley"), //TODO Update to DRPBlock
				new HangingBridge("hanging_bridge_bottom" ,0F), //TODO Update to DRPBlock
				new HangingBridge("hanging_bridge_top" ,0.5F), //TODO Update to DRPBlock
				new Forge("forge", Settings.METAL_DECO).addBehaviors(new Behavior_CraftingStation()), //TODO Update to DRPBlock  //TODO fix Settings
				new SimpleCarpenterWorkbench("simple_carpenter_workbench", Settings.WOOD_DECO).addBehaviors(new Behavior_CraftingStation()) //TODO Update to DRPBlock  //TODO fix Settings
			);

//		new FacedBlock("long_hanging_banner", Settings.WOOD_DECO_TESR).setTileEntityFactory(TE_Banner::new).addBehaviors(new Behavior_DrawBanner()),

		/**for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
			if(cleanPlankRequired.doesFulfillRequirements(mat)) {
				register(reg, MedievalCreativeTabs.UTILITY,
					new WallShelf(mat.getNamed("double_%wood%_rope_wall_shelf"), Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0F, 0F, 0.5F, 1F, 1F, 1F)))
					.setTileEntityFactory(() -> {
						return new TE_UniversalShelf(4, new Vec3d(0.7, 0.22, -0.2), new Vec3d(0.30, 0.22, -0.2), new Vec3d(0.30, 0.71, -0.2), new Vec3d(0.7, 0.71, -0.2));//TODO Update to NORTH
					})
				);
			}
		}**/

		if(InDevUtil.isDevEnv()) {
//			reg.register(new TorchOverride());
//			register(reg, MedievalCreativeTabs.UTILITY,
//				new SpinningWheel("spinning_wheel2", Settings.WOOD_DECO).setTileEntityFactory(SpinningWheelTileEntity::new).addBehaviors(new Behavior_CraftingStation()) //TODO Update to DRPBlock
//			);

//			reg.register(new BuildingScanner());
//			GameRegistry.registerTileEntity(TE_BuildingScanner.class, new ResourceLocation(References.MODID, "te_building_scanner"));
//			GameRegistry.registerTileEntity(TileEntity_Lectern.class, new ResourceLocation(References.MODID, "tile_entity_lectern"));
//			GameRegistry.registerTileEntity(SpinningWheelTileEntity.class, new ResourceLocation(References.MODID, "spinning_wheel"));
//			GameRegistry.registerTileEntity(TE_Banner.class, new ResourceLocation(References.MODID, "tile_entity_banner"));
		}

		MaterialRegistry.getMaterialsForType("wood").forEach(mat -> {
			if(logRequired.doesFulfillRequirements(mat)) {
				if(plankRequired.doesFulfillRequirements(mat)) {

					register(reg, MedievalCreativeTabs.UTILITY,
						new DRPBlock(mat.getName() + "_crate", Settings.WOOD_DECO)
							.addBehaviors(new Behavior_Container())
							.setTileEntityFactory(() -> new DynamicStorageTileEntity(18)),
						new SimpleChest("simple_" + mat.getName() + "_chest", Settings.WOOD_DECO)
							.setTileEntityFactory(TileEntitySimpleChest::new)//TODO Update to DRPBlock
					);
				}

				if(cleanPlankRequired.doesFulfillRequirements(mat)) {
					register(reg, MedievalCreativeTabs.BUILDING_MATS,
						new SimpleWoodStairs("simple_" + mat.getName() + "_stairs", Settings.WOOD_DECO)
					);

					register(reg, MedievalCreativeTabs.UTILITY,
							new WorkTable(mat.getName() + "_work_table") //TODO Update to DRPBlock  //TODO fix Settings
					);
				}

				register(reg, MedievalCreativeTabs.UTILITY,
					new FacedBlock(mat.getName() + "_chopping_block", Settings.WOOD_DECO)
						.addBehaviors(
								new Behavior_CraftingStation(), new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.0625f, 0F, 0.0625f, 0.9375f, 0.75f, 0.9375f))
								//, new ChoppingBlockActivation(), new Behavior_CraftingStation()
						)
						.setTileEntityFactory(TileEntityChoppingBlock::new)
				);

				register(reg, MedievalCreativeTabs.BUILDING_MATS,
					new MossyLog("mossy_" + mat.getName() + "_log") //TODO Update to DRPBlock
				);

				register(reg, MedievalCreativeTabs.DECORATION,
					new LogBench(mat.getName() + "_log_bench", Settings.WOOD_DECO)
						.addBehaviors(new Behavior_Chair(0.25F)), //TODO Update to DRPBlock
					new FacedBlock(mat.getName() + "_log_chair", Settings.WOOD_DECO)
						.addBehaviors(new Behavior_Chair(0.1875F)),
					new AxisBlock(mat.getName() + "_firewood_pile", Settings.WOOD_DECO) {
						@Override public int quantityDropped(Random random){ return 16; }
					    @Override public Item getItemDropped(IBlockState state, Random rand, int fortune){return Item.getByNameOrId(References.MODID + ":" + mat.getName() + "_firewood"); }
					}
				);
			}

			if(plankRequired.doesFulfillRequirements(mat)) {
				register(reg, MedievalCreativeTabs.DECORATION,
					new FacedBlock(mat.getName() + "_barrel_chair", Settings.WOOD_DECO).addBehaviors(new Behavior_Chair(0.3125f)),
					new AxisBlock(mat.getName() + "_barrel_table", Settings.WOOD_DECO),
					new DRPBlock(mat.getName() + "_empty_barrel", Settings.WOOD_DECO).addBehaviors(new Behavior_EmptyBarrel(References.MODID + ":%wood%_fluid_barrel", mat)),
					new DRPBlock(mat.getName() + "_closed_barrel", Settings.WOOD_DECO),
					new DRPBlock(mat.getName() + "_gunpowder_barrel", Settings.WOOD_DECO),
					new DRPBlock(mat.getName() + "_fluid_barrel", Settings.WOOD_DECO).addBehaviors(new Behavior_FluidFill()).setTileEntityFactory(TileEntityFluidBarrel::new),
					new SidewayBarrel("laying_" + mat.getName() + "_barrel", Settings.WOOD_DECO) //TODO Update to DRPBlock
				);

				Block barrel = new Barrel(mat.getName() + "_barrel", Settings.WOOD_DECO, mat).setTileEntityFactory(TileEntityBarrel::new);

				registerNoItems(reg, barrel);

				barrel.setCreativeTab(MedievalCreativeTabs.UTILITY);
				ItemBarrel itemBlock = (ItemBarrel) new ItemBarrel(barrel).setRegistryName(barrel.getRegistryName());

				ItemRegistryHandler.addBlockItem(itemBlock);
				ModelRegistryHandler.addItemToRegisterMesh(itemBlock);
			}

			if(cleanPlankRequired.doesFulfillRequirements(mat)) {
				Block solidSimpleTable = new SolidSimpleTable("simple_solid_" + mat.getName() + "_table"); //TODO Update to DRPBlock
				Block plankSimpleTable = new SimpleTable("simple_plank_" + mat.getName() + "_table"); //TODO Update to DRPBlock

				register(reg, MedievalCreativeTabs.BUILDING_MATS,
					new Roof(mat.getName() + "_shingle_roof", Settings.WOOD_ROOF),
					new DRPBlock(mat.getName() + "_clean_plank", Settings.WOOD_SOLID),
					new WoodenWindow(mat.getName() + "_window_cross", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0F, 0F, 0.8125F, 1F, 1F, 0.9375F))),
					new WoodenWindow(mat.getName() + "_window_vertical", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0F, 0F, 0.8125F, 1F, 1F, 0.9375F))),
					new WoodenWindow(mat.getName() + "_window_dense_diamond", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0F, 0F, 0.8125F, 1F, 1F, 0.9375F))),
					new WoodenWindow(mat.getName() + "_window_dense_vertical", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0F, 0F, 0.8125F, 1F, 1F, 0.9375F))),
					new WoodenWindow(mat.getName() + "_window_grid", Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0F, 0F, 0.8125F, 1F, 1F, 0.9375F))),
					new WoodSupport(mat.getName() + "_wood_support", Settings.WOOD_DECO) //TODO Update to DRPBlock
				);

				register(reg, MedievalCreativeTabs.UTILITY,
					new Shelf("simple_" + mat.getName() + "_shelf", Settings.WOOD_DECO).setTileEntityFactory(TileEntityShelf::new), //TODO Update to DRPBlock
					new LargeLectern("large_" + mat.getName() + "_lectern") //TODO Update to DRPBlock
				);

				register(reg, MedievalCreativeTabs.DECORATION,
					new FacedBlock("simple_plank_" + mat.getName() + "_chair", Settings.WOOD_DECO).addBehaviors(new Behavior_Chair(0.3125F)).addBehaviors(new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.0625f, 0f, 0.0625f, 0.9375f, 1f, 0.9375f))),
					new AxisBlock(mat.getName() + "_empty_bucket", Settings.WOOD_DECO).addBehaviors(new AxisBoundingBox(new AxisAlignedBB(0.21875F, 0f, 0.21875F, 0.78125f, 0.5625f, 0.78125F))),
					new AxisBlock(mat.getName() + "_water_bucket", Settings.WOOD_DECO).addBehaviors(new AxisBoundingBox(new AxisAlignedBB(0.21875F, 0f, 0.21875F, 0.78125f, 0.5625f, 0.78125F))),
					new AxisBlock(mat.getName() + "_dirt_bucket", Settings.WOOD_DECO).addBehaviors(new AxisBoundingBox(new AxisAlignedBB(0.21875F, 0f, 0.21875F, 0.78125f, 0.5625f, 0.78125F)), new FlowerContainer()).setTileEntityFactory(() -> new TileEntityFlowerContainer(3)),
					new AxisBlock(mat.getName() + "_flower_pot", Settings.WOOD_DECO).addBehaviors(new AxisBoundingBox(new AxisAlignedBB(0.21875f, 0f, 0f, 0.78125f, 0.5625f, 1f)), new FlowerContainer()).setTileEntityFactory(() -> new TileEntityFlowerContainer(3)),
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
					new TimberedClay(mat.getName() + "_timbered_clay_horizontal", 1),
					new TimberedClay(mat.getName() + "_timbered_clay_straight_cross", 1)
				);
			}
		});
	}

	private static void register(IForgeRegistry<Block> reg, CreativeTabs creativeTab, Block... blocks){
		for(Block block : blocks){
			block.setCreativeTab(creativeTab);
			ItemBlock itemBlock = (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
			ItemRegistryHandler.addBlockItem(itemBlock);
			ModelRegistryHandler.addItemToRegisterMesh(itemBlock);
		}
		reg.registerAll(blocks);
	}

	private static void registerNoItems(IForgeRegistry<Block> reg, Block... blocks){
		reg.registerAll(blocks);
	}
}
