package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.drpcore.common.crafting.CraftingRegistry;
import net.dark_roleplay.drpcore.common.crafting.SimpleRecipe;
import net.dark_roleplay.medieval.common.DRPInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class DRPMedievalCrafting {

//	//Used to do all Crafting stuff (Registration)
//	public static void preInit(FMLPreInitializationEvent event) {}
//	
//	public static void init(FMLInitializationEvent event) {}

	public static void postInit(FMLPostInitializationEvent event) {
		//Decorative Stuff
		
		DRPMedievalCrafting.registerAirRecipes();
		DRPMedievalCrafting.registerSpinningWheelRecipes();
		DRPMedievalCrafting.registerMortarRecipes();
		DRPMedievalCrafting.registerAnvilRecipes();
		DRPMedievalCrafting.registerCauldronRecipes();
		DRPMedievalCrafting.registerChoppingBlockRecipes();
		
	}
	
	private static void registerAirRecipes(){

		//Sittables
		/*Simple Chairs*/
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_chair_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_chair_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_chair_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_BIRCH, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_chair_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_JUNGLE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 3)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_chair_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_DARK_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 4)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_chair_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_CHAIR_ACACIA, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 5)}), false);
		
		/*Barrel Chairs*/
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_chair_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_chair_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_chair_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_BIRCH, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_chair_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_JUNGLE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 3)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_chair_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_DARK_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 4)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_chair_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CHAIR_ACACIA, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 5)}), false);
		
		/*Barrel Chairs*/
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "log_chair_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.LOG_CHAIR_OAK, 1, 0)},new ItemStack[]{new ItemStack(Blocks.LOG, 1, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "log_chair_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.LOG_CHAIR_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(Blocks.LOG, 1, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "log_chair_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.LOG_CHAIR_BIRCH, 1, 0)},new ItemStack[]{new ItemStack(Blocks.LOG, 1, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "log_chair_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.LOG_CHAIR_JUNGLE, 1, 0)},new ItemStack[]{new ItemStack(Blocks.LOG, 1, 3)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "log_chair_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.LOG_CHAIR_DARK_OAK, 1, 0)},new ItemStack[]{new ItemStack(Blocks.LOG2, 1, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"sittables",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "log_chair_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.LOG_CHAIR_ACACIA, 1, 0)},new ItemStack[]{new ItemStack(Blocks.LOG2, 1, 0)}), false);
		
		//Crafting Materials
		/*Planks Different Types*/
		CraftingRegistry.registerRecipe(Blocks.AIR,"crafting_materials",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "plank_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 6, 0)},new ItemStack[]{new ItemStack(Blocks.LOG, 1, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"crafting_materials",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "plank_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 6, 1)},new ItemStack[]{new ItemStack(Blocks.LOG, 1, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"crafting_materials",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "plank_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 6, 2)},new ItemStack[]{new ItemStack(Blocks.LOG, 1, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"crafting_materials",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "plank_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 6, 3)},new ItemStack[]{new ItemStack(Blocks.LOG, 1, 3)}), false);	
		CraftingRegistry.registerRecipe(Blocks.AIR,"crafting_materials",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "plank_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 6, 4)},new ItemStack[]{new ItemStack(Blocks.LOG2, 1, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"crafting_materials",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "plank_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 6, 5)},new ItemStack[]{new ItemStack(Blocks.LOG2, 1, 0)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"crafting_materials",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "trigger_trap"),
				new ItemStack[]{new ItemStack(DRPMedievalItems.TriggerTrap, 1, 0)},new ItemStack[]{new ItemStack(Blocks.TRIPWIRE_HOOK,1,0), new ItemStack(Items.STRING, 1, 0)}), false);	
		CraftingRegistry.registerRecipe(Blocks.AIR,"crafting_materials",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "bark_and_glue"),
				new ItemStack[]{new ItemStack(DRPMedievalItems.BarkAndGlue, 4, 0), new ItemStack(Blocks.PLANKS, 4, 0)},new ItemStack[]{new ItemStack(Blocks.LOG, 1, 0), new ItemStack(Items.SLIME_BALL, 1, 0)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"food_ingredients",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "dough_wheat"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.DoughWheat, 3, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.FlourWheat,3,0), new ItemStack(Items.WATER_BUCKET, 1, 0)}), false);	
		CraftingRegistry.registerRecipe(Blocks.AIR,"food_ingredients",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "dough_barley"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.DoughBarley, 3, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.FlourBarley,3,0), new ItemStack(Items.WATER_BUCKET, 1, 0)}), false);	
		CraftingRegistry.registerRecipe(Blocks.AIR,"food_ingredients",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "dough_wheat_pumpkin"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.DoughPumpkin, 3, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.FlourWheat,3,0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.PUMPKIN_SEEDS,9,0)}), false);	
		CraftingRegistry.registerRecipe(Blocks.AIR,"food_ingredients",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "dough_barley_pumpkin"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.DoughPumpkin, 3, 1)},new ItemStack[]{new ItemStack(DRPMedievalItems.FlourBarley,3,0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.PUMPKIN_SEEDS,9,0)}), false);	
		
		/*Empty Bucket Spruce*/
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative", new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "empty_bucket_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BUCKET_EMPTY, 1, 0)}, new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 3, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative", new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "water_bucket_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BUCKET_WATER, 1, 0)}, new ItemStack[]{new ItemStack(DRPMedievalBlocks.BUCKET_EMPTY, 1, 0), new ItemStack(Items.WATER_BUCKET, 1, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative", new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "dirt_bucket_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BUCKET_DIRT, 1, 0)}, new ItemStack[]{new ItemStack(DRPMedievalBlocks.BUCKET_EMPTY, 1, 0), new ItemStack(Blocks.DIRT, 1, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative", new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "flower_pot_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.FLOWER_POT, 1, 0)}, new ItemStack[]{new ItemStack(DRPMedievalItems.Plank,2,1), new ItemStack(Blocks.DIRT)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "rope"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.ROPE, 1, 0)}, new ItemStack[]{new ItemStack(Items.STRING,3,0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "rope_anchor"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.ROPE_ANCHOR, 3, 0)}, new ItemStack[]{new ItemStack(Blocks.LOG, 1, 0)}), false);
		
		/*SimpleTables*/
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_table_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_table_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_table_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_BIRCH, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_table_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_JUNGLE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 3)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_table_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_DARK_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 4)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_table_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIMPLE_TABLE_ACACIA, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 5)}), false);
		
		/*Barrels*/
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_empty_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_empty_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_empty_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_BIRCH, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_empty_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_JUNGLE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 3)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_empty_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_DARK_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 4)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_empty_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_ACACIA, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 8, 5)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_closed_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_closed_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_closed_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_BIRCH, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_closed_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_JUNGLE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 3)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_closed_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_DARK_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 4)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_closed_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_CLOSED_ACACIA, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 5)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "sideway_barrel_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "sideway_barrel_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "sideway_barrel_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_BIRCH, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "sideway_barrel_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_JUNGLE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 3)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "sideway_barrel_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_DARK_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 4)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "sideway_barrel_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SIDEWAY_BARREL_ACACIA, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 10, 5)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_water_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_WATER_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_OAK,1,0), new ItemStack(Items.WATER_BUCKET)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_water_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_WATER_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE,1,0), new ItemStack(Items.WATER_BUCKET)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_water_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_WATER_BIRCH, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_BIRCH,1,0), new ItemStack(Items.WATER_BUCKET)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_water_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_WATER_JUNGLE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_JUNGLE,1,0), new ItemStack(Items.WATER_BUCKET)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_water_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_WATER_DARK_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_DARK_OAK,1,0), new ItemStack(Items.WATER_BUCKET)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_water_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_WATER_ACACIA, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_ACACIA,1,0), new ItemStack(Items.WATER_BUCKET)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_gunpowder_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_OAK,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_gunpowder_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_SPRUCE,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_gunpowder_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_BIRCH, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_BIRCH,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_gunpowder_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_JUNGLE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_JUNGLE,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_gunpowder_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_DARK_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_DARK_OAK,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_gunpowder_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_GUNPOWDER_ACACIA, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_EMPTY_ACACIA,1,0), new ItemStack(Items.GUNPOWDER, 9, 0)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "hanging_bridge"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.HANGING_BRIDGE, 1, 0)}, new ItemStack[]{new ItemStack(DRPMedievalItems.Plank,3,0), new ItemStack(DRPMedievalBlocks.ROPE, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "rope_fence"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.ROPE_FENCE, 4, 0)}, new ItemStack[]{new ItemStack(Blocks.LOG,1,0), new ItemStack(DRPMedievalBlocks.ROPE, 4)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "mug_empty"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.MUG_EMPTY, 1, 0)}, new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 1, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "ships_helm"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SHIPS_HELM, 1, 0)}, new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 4, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "large_target"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.TARGET, 1, 0)}, new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 6, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "book"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.bookOne, 1, 0)}, new ItemStack[]{new ItemStack(Items.BOOK, 1, 0)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_table_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_TABLE_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 2, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_table_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_TABLE_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 2, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_table_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_TABLE_BIRCH, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 2, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_table_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_TABLE_JUNGLE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 2, 3)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_table_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_TABLE_DARK_OAK, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 2, 4)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "barrel_table_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.BARREL_TABLE_ACACIA, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 2, 5)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"decorative",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "lectern_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.LARGE_LECTERN_SPRUCE, 1, 0)},new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 6, 1)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "clean_plank_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 0)},new ItemStack[]{new ItemStack(Blocks.PLANKS, 1, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "clean_plank_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 1)},new ItemStack[]{new ItemStack(Blocks.PLANKS, 1, 1)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "clean_plank_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 2)},new ItemStack[]{new ItemStack(Blocks.PLANKS, 1, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "clean_plank_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 3)},new ItemStack[]{new ItemStack(Blocks.PLANKS, 1, 3)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "clean_plank_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 4)},new ItemStack[]{new ItemStack(Blocks.PLANKS, 1, 5)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "clean_plank_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.CLEAN_PLANKS, 1, 5)},new ItemStack[]{new ItemStack(Blocks.PLANKS, 1, 4)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "brick_diorite"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.DIORITE_BRICKS, 4, 0)},new ItemStack[]{new ItemStack(Blocks.STONE, 4, 4)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "pillar_diorite"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.DIORITE_PILLAR, 3, 0)},new ItemStack[]{new ItemStack(Blocks.STONE, 3, 4)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "brick_granite"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.GRANITE_BRICKS, 4, 0)},new ItemStack[]{new ItemStack(Blocks.STONE, 4, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "pillar_granite"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.GRANITE_PILLAR, 3, 0)},new ItemStack[]{new ItemStack(Blocks.STONE, 3, 2)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "brick_andesite"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.ANDESITE_BRICKS, 4, 0)},new ItemStack[]{new ItemStack(Blocks.STONE, 4, 6)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "pillar_andesite"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.ANDESITE_PILLAR, 3, 0)},new ItemStack[]{new ItemStack(Blocks.STONE, 3, 6)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "snow_brick"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SNOW_BRICKS, 1, 0)},new ItemStack[]{new ItemStack(Blocks.SNOW, 1, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR,"building",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "packed_ice_brick"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.PACKED_ICE_BRICKS, 1, 0)},new ItemStack[]{new ItemStack(Blocks.PACKED_ICE, 1, 0)}), false);
		
		CraftingRegistry.registerRecipe(Blocks.AIR, "crafting_stations",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "anvil"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.ANVIL, 1, 0)}, new ItemStack[]{new ItemStack(Items.IRON_INGOT,32,0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "crafting_stations",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "mortar"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.MORTAR, 1, 0)}, new ItemStack[]{new ItemStack(Blocks.STONE,1,0), new ItemStack(Items.STICK, 1, 0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "crafting_stations",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "chopping_block"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.CHOPPING_BLOCK, 1, 0)}, new ItemStack[]{new ItemStack(Blocks.LOG,1,0), new ItemStack(Items.IRON_AXE,1,0)}), false);
		CraftingRegistry.registerRecipe(Blocks.AIR, "crafting_stations",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "spinning_wheel"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.SPINNING_WHEEL, 1, 0)}, new ItemStack[]{new ItemStack(DRPMedievalItems.Plank, 20, 0)}), false);
	}
	
	private static void registerSpinningWheelRecipes(){
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.SPINNING_WHEEL,"crafting_materials",new SimpleRecipe(new ResourceLocation(DRPInfo.MODID, "simple_string"),
			new ItemStack[]{new ItemStack(Items.STRING, 4, 0)},new ItemStack[]{new ItemStack(Blocks.WOOL, 1, 0)}), false);
	}
	
	private static void registerMortarRecipes(){
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.MORTAR, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "wheat_flour"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.FlourWheat, 1, 0)}, new ItemStack[]{new ItemStack(Items.WHEAT, 1, 0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.MORTAR, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "wheat_barley"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.FlourBarley, 1, 0)}, new ItemStack[]{new ItemStack(DRPMedievalItems.Barley, 1, 0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.MORTAR, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "bone_meal"),
			new ItemStack[]{new ItemStack(Items.DYE, 4, 15)}, new ItemStack[]{new ItemStack(Items.BONE, 1, 0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.MORTAR, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "charcoal_powder"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.CHARCOAL_POWDER, 3, 0)}, new ItemStack[]{new ItemStack(Items.COAL, 1, 1)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.MORTAR, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "gunpowder"),
			new ItemStack[]{new ItemStack(Items.GUNPOWDER, 10, 0)}, new ItemStack[]{new ItemStack(DRPMedievalItems.SALPETER_ORE_CHUNK, 7, 0), new ItemStack(DRPMedievalItems.SULFUR_ORE_CHUNK, 1, 0), new ItemStack(DRPMedievalItems.CHARCOAL_POWDER, 2, 0)}), false);
	}
	
	private static void registerAnvilRecipes(){
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.ANVIL, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "tap"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.TAP, 2, 0)}, new ItemStack[]{new ItemStack(Items.IRON_INGOT, 1, 0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.ANVIL, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "torch_holder_empty"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.TORCH_HOLDER_EMPTY, 1, 0)}, new ItemStack[]{new ItemStack(Items.IRON_INGOT,1,0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.ANVIL, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "iron_chain"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.CHAIN, 1, 0)}, new ItemStack[]{new ItemStack(Items.IRON_INGOT,1,0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.ANVIL, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "iron_hook"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.IRON_HOOK, 1, 0)}, new ItemStack[]{new ItemStack(Items.IRON_INGOT,1,0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.ANVIL, "decorative",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "golden_ship_bell"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.GOLDEN_SHIPS_BELL, 1, 0)}, new ItemStack[]{new ItemStack(Items.GOLD_INGOT,4,0), new ItemStack(DRPMedievalBlocks.ROPE,1,0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.ANVIL, "crafting_stations",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "cauldron_firepit"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.CAULDRON, 1, 0)}, new ItemStack[]{new ItemStack(Items.IRON_INGOT,16,0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.ANVIL, "storage",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "crate_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalBlocks.CRATE, 2, 0)}, new ItemStack[]{new ItemStack(Items.IRON_INGOT,1,0), new ItemStack(DRPMedievalItems.Plank, 12, 1)}), false);
	}
	
	private static void registerChoppingBlockRecipes(){
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CHOPPING_BLOCK, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "firewood_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Firewood, 4, 0)}, new ItemStack[]{new ItemStack(Blocks.LOG, 1, 0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CHOPPING_BLOCK, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "firewood_spruce"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Firewood, 4, 1)}, new ItemStack[]{new ItemStack(Blocks.LOG, 1, 1)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CHOPPING_BLOCK, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "firewood_birch"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Firewood, 4, 2)}, new ItemStack[]{new ItemStack(Blocks.LOG, 1, 2)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CHOPPING_BLOCK, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "firewood_jungle"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Firewood, 4, 3)}, new ItemStack[]{new ItemStack(Blocks.LOG, 1, 3)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CHOPPING_BLOCK, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "firewood_dark_oak"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Firewood, 4, 4)}, new ItemStack[]{new ItemStack(Blocks.LOG2, 1, 1)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CHOPPING_BLOCK, "crafting_materials",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "firewood_acacia"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.Firewood, 4, 5)}, new ItemStack[]{new ItemStack(Blocks.LOG2, 1, 0)}), false);
	}
	
	private static void registerCauldronRecipes(){
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CAULDRON, "soups",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "chicken_stew"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.ChickenStew, 3, 0)}, new ItemStack[]{new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.CHICKEN, 1, 0), new ItemStack(Items.CARROT, 1, 0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CAULDRON, "soups",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "cod_stew"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.CodStew, 3, 0)}, new ItemStack[]{new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.FISH, 1, 0), new ItemStack(Items.CARROT, 1, 0)}), false);		
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CAULDRON, "soups",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "veggie_stew"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.VegieStew, 3, 0)}, new ItemStack[]{new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.POTATO, 1, 0), new ItemStack(Items.CARROT, 1, 0)}), false);	
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CAULDRON, "soups",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "pumpkin_stew"),
			new ItemStack[]{new ItemStack(DRPMedievalItems.PumpkinStew, 3, 0)}, new ItemStack[]{new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Blocks.PUMPKIN, 1, 0), new ItemStack(Items.CARROT, 1, 0)}), false);	
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CAULDRON, "soups",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "rabbit_stew"),
			new ItemStack[]{new ItemStack(Items.RABBIT_STEW, 3, 0)}, new ItemStack[]{new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0),  new ItemStack(Items.RABBIT, 2, 0), new ItemStack(Items.CARROT, 3, 0), new ItemStack(Items.POTATO, 3, 0), new ItemStack(Blocks.BROWN_MUSHROOM, 3, 0)}), false);	
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CAULDRON, "soups",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "beetroot_stew"),
			new ItemStack[]{new ItemStack(Items.BEETROOT_SOUP, 3, 0)}, new ItemStack[]{new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Items.BEETROOT, 9, 0)}), false);
		CraftingRegistry.registerRecipe(DRPMedievalBlocks.CAULDRON, "soups",new SimpleRecipe( new ResourceLocation(DRPInfo.MODID, "mushroom_stew"),
			new ItemStack[]{new ItemStack(Items.MUSHROOM_STEW, 3, 0)}, new ItemStack[]{new ItemStack(Items.BOWL, 3, 0), new ItemStack(Items.WATER_BUCKET, 1, 0), new ItemStack(Blocks.RED_MUSHROOM, 3, 0), new ItemStack(Blocks.BROWN_MUSHROOM, 3, 0)}), false);
		
	}
	
}

