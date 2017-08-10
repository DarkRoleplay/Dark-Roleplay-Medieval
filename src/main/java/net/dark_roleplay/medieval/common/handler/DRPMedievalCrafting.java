package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.drpcore.api.crafting.simple_recipe.RecipeCategory;
import net.dark_roleplay.drpcore.api.crafting.simple_recipe.SimpleRecipe;
import net.dark_roleplay.drpcore.api.crafting.simple_recipe.StackList;
import net.dark_roleplay.drpcore.common.crafting.CraftingRegistry;
import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DRPMedievalCrafting {

	public static void init(FMLPreInitializationEvent event) {}

	public static void init(FMLInitializationEvent event) {}

	public static void init(FMLPostInitializationEvent event) {
		DRPMedievalCrafting.registerAirRecipes();
		DRPMedievalCrafting.registerSpinningWheelRecipes();
		DRPMedievalCrafting.registerMortarRecipes();
		DRPMedievalCrafting.registerAnvilRecipes();
		DRPMedievalCrafting.registerCauldronRecipes();
		DRPMedievalCrafting.registerChoppingBlockRecipes();
		DRPMedievalCrafting.registerPotteryTurntableRecipes();
	}
	
	private static void registerAirRecipes(){
		String MODID = DRPMedievalInfo.MODID;

		/** CREATING CATEGORYS **/
		RecipeCategory SITTABLES = new RecipeCategory(Blocks.AIR, "sittables", new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_OAK));
		RecipeCategory MATERIALS = new RecipeCategory(Blocks.AIR, "crafting_materials", new ItemStack(DRPMedievalItems.PLANKS));
		RecipeCategory FOOD_INGREDIENTS = new RecipeCategory(Blocks.AIR, "food_ingredients", new ItemStack(DRPMedievalItems.DOUGH_PUMPKIN));
		RecipeCategory DECORATION = new RecipeCategory(Blocks.AIR, "decorative", new ItemStack(DRPMedievalBlocks.FLOWER_POT));
		RecipeCategory BUILDING = new RecipeCategory(Blocks.AIR, "building", new ItemStack(DRPMedievalBlocks.GRANITE_BRICKS));
		RecipeCategory STATIONS = new RecipeCategory(Blocks.AIR, "crafting_stations", new ItemStack(DRPMedievalBlocks.POTTERY_TURNTABLE));
		
		/** ADDING RECIPES**/
		SITTABLES.add(
			new SimpleRecipe(new ResourceLocation(MODID, "simple_chair_oak"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_OAK, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_chair_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_SPRUCE, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_chair_birch"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_BIRCH, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_chair_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_JUNGLE, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 3)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_chair_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_DARK_OAK, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 4)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_chair_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_ACACIA, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 5)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_chair_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_OAK, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 0), new ItemStack(Items.IRON_NUGGET, 2, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_chair_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_SPRUCE, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 1), new ItemStack(Items.IRON_NUGGET, 2, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_chair_birch"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_BIRCH, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 2), new ItemStack(Items.IRON_NUGGET, 2, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_chair_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_JUNGLE, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 3), new ItemStack(Items.IRON_NUGGET, 2, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_chair_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_DARK_OAK, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 4), new ItemStack(Items.IRON_NUGGET, 2, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_chair_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_ACACIA, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 5), new ItemStack(Items.IRON_NUGGET, 2, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "log_chair_oak"), new StackList(new ItemStack(DRPMedievalBlocks.LOG_CHAIR_OAK, 1, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "log_chair_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.LOG_CHAIR_SPRUCE, 1, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "log_chair_birch"), new StackList(new ItemStack(DRPMedievalBlocks.LOG_CHAIR_BIRCH, 1, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "log_chair_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.LOG_CHAIR_JUNGLE, 1, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 3)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "log_chair_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.LOG_CHAIR_DARK_OAK, 1, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG2, 1, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "log_chair_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.LOG_CHAIR_ACACIA, 1, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG2, 1, 0)).asArr())
		);	
		
		MATERIALS.add(
			new SimpleRecipe(new ResourceLocation(MODID, "plank_oak"), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 6, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "plank_spruce"), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 6, 1)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "plank_birch"), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 6, 2)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "plank_jungle"), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 6, 3)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 3)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "plank_dark_oak"), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 6, 4)).asArr(), new StackList(new ItemStack(Blocks.LOG2, 1, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "plank_acacia"), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 6, 5)).asArr(), new StackList(new ItemStack(Blocks.LOG2, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "trigger_trap"), new StackList(new ItemStack(DRPMedievalItems.TRIGGER_TRAP, 1, 0)).asArr(), new StackList(new ItemStack(Blocks.TRIPWIRE_HOOK,1,0), new ItemStack(Items.STRING, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "bark_and_glue"), new StackList(new ItemStack(DRPMedievalItems.BARK_AND_GLUE, 4, 0), new ItemStack(Blocks.PLANKS, 4, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 0), new ItemStack(Items.SLIME_BALL, 1, 0)).asArr())
		);
		
		FOOD_INGREDIENTS.add(
			new SimpleRecipe(new ResourceLocation(MODID, "dough_wheat"), new StackList(new ItemStack(DRPMedievalItems.DOUGH, 3, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.FLOUR, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "dough_barley"), new StackList(new ItemStack(DRPMedievalItems.DOUGH, 3, 1)).asArr(),new StackList(new ItemStack(DRPMedievalItems.FLOUR, 3, 1), new ItemStack(Items.WATER_BUCKET, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "dough_wheat_pumpkin"), new StackList(new ItemStack(DRPMedievalItems.DOUGH_PUMPKIN, 3, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.FLOUR, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.PUMPKIN_SEEDS,9,0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "dough_barley_pumpkin"), new StackList(new ItemStack(DRPMedievalItems.DOUGH_PUMPKIN, 3, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.FLOUR, 3, 1), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.PUMPKIN_SEEDS,9,0)).asArr())
		);

		DECORATION.add(
			new SimpleRecipe(new ResourceLocation(MODID, "empty_bucket_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.BUCKET_EMPTY, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 3, 1)).asArr()),
		 	new SimpleRecipe(new ResourceLocation(MODID, "water_bucket_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.BUCKET_WATER, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalBlocks.BUCKET_EMPTY, 1, 0), new ItemStack(Items.WATER_BUCKET, 1, 0)).asArr()),
		 	new SimpleRecipe(new ResourceLocation(MODID, "dirt_bucket_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.BUCKET_DIRT, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalBlocks.BUCKET_EMPTY, 1, 0), new ItemStack(Blocks.DIRT, 1, 0)).asArr()),
		 	new SimpleRecipe(new ResourceLocation(MODID, "flower_pot_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.FLOWER_POT, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS,2,1), new ItemStack(Blocks.DIRT)).asArr()),
		 	new SimpleRecipe(new ResourceLocation(MODID, "rope"), new StackList(new ItemStack(DRPMedievalBlocks.ROPE, 1, 0)).asArr(), new StackList(new ItemStack(Items.STRING,3,0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "rope_anchor"), new StackList(new ItemStack(DRPMedievalBlocks.ROPE_ANCHOR, 3, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_table_oak"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_table_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_SPRUCE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_table_birch"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_BIRCH, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_table_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_JUNGLE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 3)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_table_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_DARK_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 4)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "simple_table_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_ACACIA, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 5)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_empty_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_empty_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_empty_birch"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_BIRCH, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_empty_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_JUNGLE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 3)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_empty_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_DARK_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 4)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_empty_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_ACACIA, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 8, 5)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_closed_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_closed_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_SPRUCE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_closed_birch"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_BIRCH, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_closed_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_JUNGLE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 3)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_closed_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_DARK_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 4)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_closed_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_ACACIA, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 5)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "sideway_barrel_oak"), new StackList(new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "sideway_barrel_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_SPRUCE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "sideway_barrel_birch"), new StackList(new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_BIRCH, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "sideway_barrel_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_JUNGLE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 3)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "sideway_barrel_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_DARK_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 4)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "sideway_barrel_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_ACACIA, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 10, 5)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_water_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_WATER_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_OAK,1,0), new ItemStack(Items.WATER_BUCKET)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_water_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_WATER_SPRUCE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE,1,0), new ItemStack(Items.WATER_BUCKET)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_water_birch"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_WATER_BIRCH, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_BIRCH,1,0), new ItemStack(Items.WATER_BUCKET)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_water_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_WATER_JUNGLE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_JUNGLE,1,0), new ItemStack(Items.WATER_BUCKET)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_water_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_WATER_DARK_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_DARK_OAK,1,0), new ItemStack(Items.WATER_BUCKET)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_water_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_WATER_ACACIA, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_ACACIA,1,0), new ItemStack(Items.WATER_BUCKET)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_gunpowder_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_OAK,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_gunpowder_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_SPRUCE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_gunpowder_birch"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_BIRCH, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_BIRCH,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_gunpowder_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_JUNGLE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_JUNGLE,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_gunpowder_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_DARK_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_DARK_OAK,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_gunpowder_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_ACACIA, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_ACACIA,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "hanging_bridge"), new StackList(new ItemStack(DRPMedievalItems.HANGING_BRIDGE, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS,3,0), new ItemStack(DRPMedievalBlocks.ROPE, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "rope_fence"), new StackList(new ItemStack(DRPMedievalBlocks.ROPE_FENCE, 4, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG,1,0), new ItemStack(DRPMedievalBlocks.ROPE, 4)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "mug_empty"), new StackList(new ItemStack(DRPMedievalBlocks.MUG_EMPTY, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "ships_helm"), new StackList(new ItemStack(DRPMedievalBlocks.SHIPS_HELM, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 4, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "large_target"), new StackList(new ItemStack(DRPMedievalBlocks.TARGET, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 6, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "book"), new StackList(new ItemStack(DRPMedievalBlocks.bookOne, 1, 0)).asArr(), new StackList(new ItemStack(Items.BOOK, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_table_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_TABLE_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 2, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_table_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_TABLE_SPRUCE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 2, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_table_birch"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_TABLE_BIRCH, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 2, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_table_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_TABLE_JUNGLE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 2, 3)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_table_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_TABLE_DARK_OAK, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 2, 4)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "barrel_table_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.BARREL_TABLE_ACACIA, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 2, 5)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "lectern_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.LARGE_LECTERN_SPRUCE, 1, 0)).asArr(),new StackList(new ItemStack(DRPMedievalItems.PLANKS, 6, 1)).asArr())
		);

		BUILDING.add(
			new SimpleRecipe(new ResourceLocation(MODID, "clean_plank_oak"), new StackList(new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 0)).asArr(),new StackList(new ItemStack(Blocks.PLANKS, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "clean_plank_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 1)).asArr(),new StackList(new ItemStack(Blocks.PLANKS, 1, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "clean_plank_birch"), new StackList(new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 2)).asArr(),new StackList(new ItemStack(Blocks.PLANKS, 1, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "clean_plank_jungle"), new StackList(new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 3)).asArr(),new StackList(new ItemStack(Blocks.PLANKS, 1, 3)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "clean_plank_dark_oak"), new StackList(new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 4)).asArr(),new StackList(new ItemStack(Blocks.PLANKS, 1, 5)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "clean_plank_acacia"), new StackList(new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 5)).asArr(),new StackList(new ItemStack(Blocks.PLANKS, 1, 4)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "brick_diorite"), new StackList(new ItemStack(DRPMedievalBlocks.DIORITE_BRICKS, 4, 0)).asArr(),new StackList(new ItemStack(Blocks.STONE, 4, 4)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "pillar_diorite"), new StackList(new ItemStack(DRPMedievalBlocks.DIORITE_PILLAR, 3, 0)).asArr(),new StackList(new ItemStack(Blocks.STONE, 3, 4)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "brick_granite"), new StackList(new ItemStack(DRPMedievalBlocks.GRANITE_BRICKS, 4, 0)).asArr(),new StackList(new ItemStack(Blocks.STONE, 4, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "pillar_granite"), new StackList(new ItemStack(DRPMedievalBlocks.GRANITE_PILLAR, 3, 0)).asArr(),new StackList(new ItemStack(Blocks.STONE, 3, 2)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "brick_andesite"), new StackList(new ItemStack(DRPMedievalBlocks.ANDESITE_BRICKS, 4, 0)).asArr(),new StackList(new ItemStack(Blocks.STONE, 4, 6)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "pillar_andesite"), new StackList(new ItemStack(DRPMedievalBlocks.ANDESITE_PILLAR, 3, 0)).asArr(),new StackList(new ItemStack(Blocks.STONE, 3, 6)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "snow_brick"), new StackList(new ItemStack(DRPMedievalBlocks.SNOW_BRICKS, 1, 0)).asArr(),new StackList(new ItemStack(Blocks.SNOW, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "packed_ice_brick"), new StackList(new ItemStack(DRPMedievalBlocks.PACKED_ICE_BRICKS, 1, 0)).asArr(),new StackList(new ItemStack(Blocks.PACKED_ICE, 1, 0)).asArr())
		);
		
		STATIONS.add(
			new SimpleRecipe(new ResourceLocation(MODID, "anvil"), new StackList(new ItemStack(DRPMedievalBlocks.ANVIL, 1, 0)).asArr(), new StackList(new ItemStack(Items.IRON_INGOT,32,0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "mortar"), new StackList(new ItemStack(DRPMedievalBlocks.MORTAR, 1, 0)).asArr(), new StackList(new ItemStack(Blocks.STONE,1,0), new ItemStack(Items.STICK, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "chopping_block"), new StackList(new ItemStack(DRPMedievalBlocks.CHOPPING_BLOCK, 1, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG,1,0), new ItemStack(Items.IRON_AXE,1,0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "spinning_wheel"), new StackList(new ItemStack(DRPMedievalBlocks.SPINNING_WHEEL, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 20, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "pottery_turntable"), new StackList(new ItemStack(DRPMedievalBlocks.POTTERY_TURNTABLE, 1, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.PLANKS, 14, 0), new ItemStack(Items.IRON_INGOT, 1)).asArr())
		);
		
		/** REGISTERING CATEGORYS **/
		CraftingRegistry.register(SITTABLES);
		CraftingRegistry.register(MATERIALS);
		CraftingRegistry.register(FOOD_INGREDIENTS);
		CraftingRegistry.register(DECORATION);
		CraftingRegistry.register(BUILDING);
		CraftingRegistry.register(STATIONS);
	}
	
	private static void registerSpinningWheelRecipes(){
		String MODID = DRPMedievalInfo.MODID;
		
		/** CREATING CATEGORYS **/
		RecipeCategory MATERIALS = new RecipeCategory(DRPMedievalBlocks.SPINNING_WHEEL, "crafting_materials", new ItemStack(Items.STRING));
		
		/** ADDING RECIPES**/
		MATERIALS.add(
				new SimpleRecipe(new ResourceLocation(MODID, "simple_string"), new StackList(new ItemStack(Items.STRING, 4, 0)).asArr(),new StackList(new ItemStack(Blocks.WOOL, 1, 0)).asArr())
		);
		
		/** REGISTERING CATEGORYS **/
		CraftingRegistry.register(MATERIALS);
	}
	
	private static void registerMortarRecipes(){
		String MODID = DRPMedievalInfo.MODID;
		
		/** CREATING CATEGORYS **/
		RecipeCategory MATERIALS = new RecipeCategory(DRPMedievalBlocks.MORTAR, "crafting_materials", new ItemStack(DRPMedievalItems.FLOUR));
		
		/** ADDING RECIPES**/
		MATERIALS.add(
			new SimpleRecipe(new ResourceLocation(MODID, "wheat_flour"), new StackList(new ItemStack(DRPMedievalItems.FLOUR, 1, 0)).asArr(), new StackList(new ItemStack(Items.WHEAT, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "wheat_barley"), new StackList(new ItemStack(DRPMedievalItems.FLOUR, 1, 1)).asArr(), new StackList(new ItemStack(DRPMedievalItems.BARLEY, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "bone_meal"), new StackList(new ItemStack(Items.DYE, 4, 15)).asArr(), new StackList(new ItemStack(Items.BONE, 1, 0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "charcoal_powder"), new StackList(new ItemStack(DRPMedievalItems.POWDER_CHARCOAL, 3, 0)).asArr(), new StackList(new ItemStack(Items.COAL, 1, 1)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "gunpowder"), new StackList(new ItemStack(Items.GUNPOWDER, 10, 0)).asArr(), new StackList(new ItemStack(DRPMedievalItems.ORE_CHUNK_SALPETER, 7, 0), new ItemStack(DRPMedievalItems.ORE_CHUNK_SULFUR, 1, 0), new ItemStack(DRPMedievalItems.POWDER_CHARCOAL, 2, 0)).asArr())
		);
		
		/** REGISTERING CATEGORYS **/
		CraftingRegistry.register(MATERIALS);
	}
	
	private static void registerAnvilRecipes(){
		String MODID = DRPMedievalInfo.MODID;
		
		/** CREATING CATEGORYS **/
		RecipeCategory MATERIALS = new RecipeCategory(DRPMedievalBlocks.ANVIL, "crafting_materials", new ItemStack(DRPMedievalItems.TAP));
		RecipeCategory DECORATION = new RecipeCategory(DRPMedievalBlocks.ANVIL, "decorative", new ItemStack(DRPMedievalBlocks.GOLDEN_SHIPS_BELL));
		RecipeCategory STATIONS = new RecipeCategory(DRPMedievalBlocks.ANVIL, "crafting_stations", new ItemStack(DRPMedievalBlocks.CAULDRON));
		RecipeCategory STORAGE = new RecipeCategory(DRPMedievalBlocks.ANVIL, "storage", new ItemStack(DRPMedievalBlocks.CRATE));

		/** ADDING RECIPES**/
		MATERIALS.add(
			new SimpleRecipe(new ResourceLocation(MODID, "tap"), new StackList(new ItemStack(DRPMedievalItems.TAP, 2, 0)).asArr(), new StackList(new ItemStack(Items.IRON_INGOT, 1, 0)).asArr())
		);
		
		DECORATION.add(
			new SimpleRecipe(new ResourceLocation(MODID, "torch_holder_empty"), new StackList(new ItemStack(DRPMedievalBlocks.TORCH_HOLDER_EMPTY, 1, 0)).asArr(), new StackList(new ItemStack(Items.IRON_INGOT,1,0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "iron_chain"), new StackList(new ItemStack(DRPMedievalBlocks.CHAIN, 1, 0)).asArr(), new StackList(new ItemStack(Items.IRON_INGOT,1,0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "iron_hook"),new StackList(new ItemStack(DRPMedievalBlocks.IRON_HOOK, 1, 0)).asArr(), new StackList(new ItemStack(Items.IRON_INGOT,1,0)).asArr()),
			new SimpleRecipe(new ResourceLocation(MODID, "golden_ship_bell"), new StackList(new ItemStack(DRPMedievalBlocks.GOLDEN_SHIPS_BELL, 1, 0)).asArr(), new StackList(new ItemStack(Items.GOLD_INGOT,4,0), new ItemStack(DRPMedievalBlocks.ROPE,1,0)).asArr())
		);
		
		STATIONS.add(
			new SimpleRecipe(new ResourceLocation(MODID, "cauldron_firepit"), new StackList(new ItemStack(DRPMedievalBlocks.CAULDRON, 1, 0)).asArr(), new StackList(new ItemStack(Items.IRON_INGOT,16,0)).asArr())	
		);
		
		STORAGE.add(
			new SimpleRecipe(new ResourceLocation(MODID, "crate_spruce"), new StackList(new ItemStack(DRPMedievalBlocks.CRATE, 2, 0)).asArr(), new StackList(new ItemStack(Items.IRON_INGOT,1,0), new ItemStack(DRPMedievalItems.PLANKS, 12, 1)).asArr())
		);		
		
		/** REGISTERING CATEGORYS **/
		CraftingRegistry.register(MATERIALS);
		CraftingRegistry.register(DECORATION);
		CraftingRegistry.register(STATIONS);
		CraftingRegistry.register(STORAGE);
	}
	
	private static void registerChoppingBlockRecipes(){
		String MODID = DRPMedievalInfo.MODID;
		
		/** CREATING CATEGORYS **/
		RecipeCategory MATERIALS = new RecipeCategory(DRPMedievalBlocks.CHOPPING_BLOCK, "crafting_materials", new ItemStack(DRPMedievalItems.FIREWOOD));

		/** ADDING RECIPES**/
		MATERIALS.add(
			new SimpleRecipe( new ResourceLocation(MODID, "firewood_oak"), new StackList(new ItemStack(DRPMedievalItems.FIREWOOD, 4, 0)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 0)).asArr()),
			new SimpleRecipe( new ResourceLocation(MODID, "firewood_spruce"), new StackList(new ItemStack(DRPMedievalItems.FIREWOOD, 4, 1)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 1)).asArr()),
			new SimpleRecipe( new ResourceLocation(MODID, "firewood_birch"), new StackList(new ItemStack(DRPMedievalItems.FIREWOOD, 4, 2)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 2)).asArr()),
			new SimpleRecipe( new ResourceLocation(MODID, "firewood_jungle"), new StackList(new ItemStack(DRPMedievalItems.FIREWOOD, 4, 3)).asArr(), new StackList(new ItemStack(Blocks.LOG, 1, 3)).asArr()),
			new SimpleRecipe( new ResourceLocation(MODID, "firewood_dark_oak"), new StackList(new ItemStack(DRPMedievalItems.FIREWOOD, 4, 4)).asArr(), new StackList(new ItemStack(Blocks.LOG2, 1, 1)).asArr()),
			new SimpleRecipe( new ResourceLocation(MODID, "firewood_acacia"), new StackList(new ItemStack(DRPMedievalItems.FIREWOOD, 4, 5)).asArr(), new StackList(new ItemStack(Blocks.LOG2, 1, 0)).asArr())
		);
		
		/** REGISTERING CATEGORYS **/
		CraftingRegistry.register(MATERIALS);
	}
	
	private static void registerCauldronRecipes(){
		String MODID = DRPMedievalInfo.MODID;
		
		/** CREATING CATEGORYS **/
		RecipeCategory SOUPS = new RecipeCategory(DRPMedievalBlocks.CAULDRON, "soups", new ItemStack(DRPMedievalItems.VEGIE_STEW));
		
		/** ADDING RECIPES**/
		SOUPS.add(
			new SimpleRecipe( new ResourceLocation(MODID, "chicken_stew"), new StackList(new ItemStack(DRPMedievalItems.CHICKEN_STEW, 3, 0)).asArr(), new StackList(new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.CHICKEN, 1, 0), new ItemStack(Items.CARROT, 1, 0)).asArr()),
			new SimpleRecipe( new ResourceLocation(MODID, "cod_stew"), new StackList(new ItemStack(DRPMedievalItems.COD_STEW, 3, 0)).asArr(), new StackList(new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.FISH, 1, 0), new ItemStack(Items.CARROT, 1, 0)).asArr()),		
			new SimpleRecipe( new ResourceLocation(MODID, "veggie_stew"), new StackList(new ItemStack(DRPMedievalItems.VEGIE_STEW, 3, 0)).asArr(), new StackList(new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.POTATO, 1, 0), new ItemStack(Items.CARROT, 1, 0)).asArr()),	
			new SimpleRecipe( new ResourceLocation(MODID, "pumpkin_stew"), new StackList(new ItemStack(DRPMedievalItems.PUMPKIN_STEW, 3, 0)).asArr(), new StackList(new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Blocks.PUMPKIN, 1, 0), new ItemStack(Items.CARROT, 1, 0)).asArr()),	
			new SimpleRecipe( new ResourceLocation(MODID, "rabbit_stew"), new StackList(new ItemStack(Items.RABBIT_STEW, 3, 0)).asArr(), new StackList(new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0),  new ItemStack(Items.RABBIT, 2, 0), new ItemStack(Items.CARROT, 3, 0), new ItemStack(Items.POTATO, 3, 0), new ItemStack(Blocks.BROWN_MUSHROOM, 3, 0)).asArr()),	
			new SimpleRecipe( new ResourceLocation(MODID, "beetroot_stew"), new StackList(new ItemStack(Items.BEETROOT_SOUP, 3, 0)).asArr(), new StackList(new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.BEETROOT, 9, 0)).asArr()),
			new SimpleRecipe( new ResourceLocation(MODID, "mushroom_stew"), new StackList(new ItemStack(Items.MUSHROOM_STEW, 3, 0)).asArr(), new StackList(new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Blocks.RED_MUSHROOM, 3, 0), new ItemStack(Blocks.BROWN_MUSHROOM, 3, 0)).asArr())
		);
		
		/** REGISTERING CATEGORYS **/
		CraftingRegistry.register(SOUPS);
	}
	
	private static void registerPotteryTurntableRecipes(){
		String MODID = DRPMedievalInfo.MODID;
		
		/** CREATING CATEGORYS **/
		RecipeCategory DECORATION = new RecipeCategory(DRPMedievalBlocks.POTTERY_TURNTABLE, "decorative", new ItemStack(DRPMedievalBlocks.UNFIRED_VASE));

		/** ADDING RECIPES**/
		DECORATION.add(
				new SimpleRecipe( new ResourceLocation(MODID, "unfired_vase"), new StackList(new ItemStack(DRPMedievalBlocks.UNFIRED_VASE, 1, 0)).asArr(), new StackList(new ItemStack(Items.CLAY_BALL, 4, 0)).asArr())
		);		
		
		/** REGISTERING CATEGORYS **/
		CraftingRegistry.register(DECORATION);
	}
}

