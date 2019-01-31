package net.dark_roleplay.medieval.handler;

import java.util.Random;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.dark_roleplay.core_modules.maarg.api.arg.MaterialRequirements;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.dark_roleplay.library.experimental.blocks.behaviors.IBoundingBoxBehavior;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.handler.MedievalCreativeTabs;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.Settings;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_Chair;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_Container;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_CraftingStation;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.advent_wreath.CandleLighting;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.advent_wreath.CandleParticles;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.placing.CeilingRequired;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.stone_arch.StoneArchPlacement;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.AxisBlock;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.dark_roleplay.medieval.common.objects.blocks.old.DirtStairs;
import net.dark_roleplay.medieval.common.objects.blocks.old.DungeonChest;
import net.dark_roleplay.medieval.common.objects.blocks.old.LogBench;
import net.dark_roleplay.medieval.common.objects.blocks.old.MossyLog;
import net.dark_roleplay.medieval.common.objects.blocks.old.WoodSupport;
import net.dark_roleplay.medieval.common.objects.blocks.old.WorkTable;
import net.dark_roleplay.medieval.common.objects.blocks.special.AdventWreath;
import net.dark_roleplay.medieval.common.objects.blocks.special.DoubleArch;
import net.dark_roleplay.medieval.common.objects.blocks.special.SimpleWoodStairs;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ChoppingBlock;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_DungeonChest;
import net.dark_roleplay.medieval.common.objects.blocks_cleanup.building.roof.Roof;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = References.MODID)
public class BlockRegistryHandler {

	private static final MaterialRequirements logRequired = new MaterialRequirements("log_side", "log_top");
	private static final MaterialRequirements plankRequired = new MaterialRequirements("planks");
	private static final MaterialRequirements cleanPlankRequired = new MaterialRequirements("clean_planks");

	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Block> registryEvent) {
		IForgeRegistry<Block> reg = registryEvent.getRegistry();

		MaterialRegistry.getMaterialsForType("wood").forEach(mat -> {
			if(logRequired.doesFulfillRequirements(mat)) {
				if(plankRequired.doesFulfillRequirements(mat)) {

					register(reg, MedievalCreativeTabs.UTILITY,
						new DRPBlock(mat.getName() + "_crate", Settings.WOOD_DECO)
							.addBehaviors(new Behavior_Container())
							.setTileEntityFactory(() -> new DynamicStorageTileEntity(18)),
						new DungeonChest("simple_" + mat.getName() + "_chest", Settings.WOOD_DECO)
							.setTileEntityFactory(TE_DungeonChest::new)//TODO Update to DRPBlock
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
						.setTileEntityFactory(TE_ChoppingBlock::new)
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
					new AxisBlock(mat.getName() + "_firewood_pile", Settings.WOOD_DECO) {
						@Override public int quantityDropped(Random random){ return 16; }
					    @Override public Item getItemDropped(IBlockState state, Random rand, int fortune){return Item.getByNameOrId(References.MODID + ":" + mat.getName() + "_firewood"); }
					}
				);
			}

			if(cleanPlankRequired.doesFulfillRequirements(mat)) {
				register(reg, MedievalCreativeTabs.BUILDING_MATS,
					new Roof(mat.getName() + "_shingle_roof", Settings.WOOD_ROOF)
				);
			}

		});

		register(reg, MedievalCreativeTabs.BUILDING_MATS,
			new DirtStairs("dirt_stairs", Settings.STONE_DECO),
			new DoubleArch("stone_brick_double_arch", Settings.STONE_DECO)
				.addBehaviors(StoneArchPlacement.INSTANCE),

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
			new Roof("black_clay_shingle_roof", Settings.WOOD_ROOF)
		);


		register(reg, MedievalCreativeTabs.DECORATION,
			new DRPBlock("mistletoe", BlockProperties.Settings.PLANT_DECO) {
				@Override public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {return NULL_AABB;}
			}.addBehaviors(CeilingRequired.INSTANCE, new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.25F, 0.1875F, 0.25F, 0.75F, 1.0F, 0.75F))),

			new AdventWreath("advent_wreath", BlockProperties.Settings.PLANT_DECO) {
				@Override public int getLightValue(IBlockState state) {
					int currentLit = state.getValue(BlockProperties.BURNING_CANDLES);
					return currentLit == 0 ? 0 : 7 + (currentLit * 2);
				}
			}.addBehaviors(new CandleLighting(), new CandleParticles(), new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0F, 0F, 0F, 1F, 0.6825F, 1F))) //TODO Make behavior Singleton
		);

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
