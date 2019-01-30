package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.dark_roleplay.core_modules.maarg.api.arg.MaterialRequirements;
import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.dark_roleplay.library.experimental.blocks.behaviors.IBoundingBoxBehavior;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.handler.MedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.MedievalModels;
import net.dark_roleplay.medieval.common.objects.barrel.Barrel;
import net.dark_roleplay.medieval.common.objects.barrel.ItemBarrel;
import net.dark_roleplay.medieval.common.objects.barrel.TileEntityBarrel;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.Settings;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_Container;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_CraftingStation;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.advent_wreath.CandleLighting;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.advent_wreath.CandleParticles;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.placing.CeilingRequired;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.dark_roleplay.medieval.common.objects.blocks.old.DirtStairs;
import net.dark_roleplay.medieval.common.objects.blocks.special.AdventWreath;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ChoppingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
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

		for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
			if(logRequired.doesFulfillRequirements(mat)) {
				if(plankRequired.doesFulfillRequirements(mat)) {

					register(reg, MedievalCreativeTabs.UTILITY,
						new DRPBlock(mat.getName() + "_crate", Settings.WOOD_DECO)
							.addBehaviors(new Behavior_Container())
							.setTileEntityFactory(() -> new DynamicStorageTileEntity(18))
					);
				}

				register(reg, MedievalCreativeTabs.UTILITY,
					new FacedBlock(mat.getName() + "_chopping_block", Settings.WOOD_DECO)
						.addBehaviors(
								new Behavior_CraftingStation(),
								new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.0625f, 0F, 0.0625f, 0.9375f, 0.75f, 0.9375f))
//								new ChoppingBlockActivation()
								//new Behavior_CraftingStation()
						).setTileEntityFactory(TE_ChoppingBlock::new)
					);
			}

			if(plankRequired.doesFulfillRequirements(mat)) {
				Block barrel = new Barrel(mat.getName() + "_barrel", Settings.WOOD_DECO, mat).setTileEntityFactory(TileEntityBarrel::new);

				registerNoItems(reg, barrel);

				barrel.setCreativeTab(MedievalCreativeTabs.UTILITY);
				ItemBarrel itemBlock = (ItemBarrel) new ItemBarrel(barrel).setRegistryName(barrel.getRegistryName());

				ItemRegistryHandler.addBlockItem(itemBlock);
				MedievalModels.addItemToRegisterMesh(itemBlock);
			}
		}

		register(reg, MedievalCreativeTabs.BUILDING_MATS,
			new DirtStairs("dirt_stairs", Settings.STONE_DECO)
		);

		GameRegistry.registerTileEntity(DynamicStorageTileEntity.class, new ResourceLocation(References.MODID, "te_dynamic_storage"));


//		for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
//			if(cleanPlankRequired.doesFulfillRequirements(mat)) {
//				register(reg, MedievalCreativeTabs.UTILITY,
//					new WallShelf(mat.getNamed("double_%wood%_rope_wall_shelf"), Settings.WOOD_DECO).addBehaviors(new FacedBoundingBox(new AxisAlignedBB(0F, 0F, 0.5F, 1F, 1F, 1F)))
//					.setTileEntityFactory(() -> {
//						return new TE_UniversalShelf(4, new Vec3d(0.7, 0.22, -0.2), new Vec3d(0.30, 0.22, -0.2), new Vec3d(0.30, 0.71, -0.2), new Vec3d(0.7, 0.71, -0.2));//TODO Update to NORTH
//					})
//				);
//			}
//		}

//		register(reg, MedievalCreativeTabs.BUILDING_MATS,
//			new DoubleArch("stone_brick_double_arch", Settings.STONE_DECO)
//				.addBehaviors(
//					StoneArchPlacement.INSTANCE
//				)
//		);


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

		GameRegistry.registerTileEntity(TileEntityBarrel.class, new ResourceLocation(References.MODID, "barrel"));
	}

	private static void register(IForgeRegistry<Block> reg, CreativeTabs creativeTab, Block... blocks){
		for(Block block : blocks){
			block.setCreativeTab(creativeTab);
			ItemBlock itemBlock = (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
			ItemRegistryHandler.addBlockItem(itemBlock);
			MedievalModels.addItemToRegisterMesh(itemBlock);
		}
		reg.registerAll(blocks);
	}

	private static void registerNoItems(IForgeRegistry<Block> reg, Block... blocks){
		reg.registerAll(blocks);
	}
}
