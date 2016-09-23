package net.drpmedieval.common.crafting;

import net.drpcore.common.crafting.AdvancedRecipe;
import net.drpcore.common.crafting.CraftingController;
import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DRPMedievalCrafting {

	//Used to do all Crafting stuff (Registration)
	public static void preInit(FMLPreInitializationEvent event) {}
	
	public static void init(FMLInitializationEvent event) {
		
		CraftingController cc = CraftingController.INSTANCE;
		
		/*cc.registerRecipe("TEST", 
				new AdvancedRecipe(DarkRoleplayCore.MODID,
						new ItemStack(Items.BONE, 1), //Preview
						new ItemStack(Items.DIAMOND_SWORD, 1), //Output
						new ItemStack[] {
								new ItemStack(Items.WATER_BUCKET, 1), //Primary
								new ItemStack(Blocks.PLANKS, 2)
								},
						new ItemStack[] {
								new ItemStack(Blocks.GLASS, 1), //secondary
								new ItemStack(Blocks.DIRT, 2)
								}
				).setCraftingTime(20));*/
		
	/**---------- Free Crafting ----------*/

		/**---------- Craft Mats ----------*/
		//Planks Oak/Birch/Spruce/Jungle
			cc.registerRecipe("CraftMats", 
				new AdvancedRecipe(DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalItems.Plank),
					new ItemStack(DRPMedievalItems.Plank, 6), 
					new ItemStack[] {
						new ItemStack(Blocks.LOG)
					}
				)/*{
					@Override
					public ItemStack[] getOutput(ItemStack[] primaryIngr, ItemStack[] secondaryIngr) {
						switch(primaryIngr[0].getMetadata()){
							case 0:
								return new ItemStack[] {new ItemStack(DRPMedievalItems.Plank, 6, 0)};
							case 1:
								return new ItemStack[] {new ItemStack(DRPMedievalItems.Plank, 6, 1)};
							case 2:
								return new ItemStack[] {new ItemStack(DRPMedievalItems.Plank, 6, 2)};
							case 3:
								return new ItemStack[] {new ItemStack(DRPMedievalItems.Plank, 6, 3)};
							default:
								return new ItemStack[] {getDefaultOutput()};			
						}
				}}*/.setCraftingTime(2));
		//Planks Dark Oak/Acacia
			cc.registerRecipe("CraftMats", 
				new AdvancedRecipe(DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalItems.Plank),
					new ItemStack(DRPMedievalItems.Plank, 6), 
					new ItemStack[] {
						new ItemStack(Blocks.LOG2)
					}
				)/*{
					@Override
					public ItemStack[] getOutput(ItemStack[] primaryIngr, ItemStack[] secondaryIngr) {
						switch(primaryIngr[0].getMetadata()){
							case 0:
								return new ItemStack[] {new ItemStack(DRPMedievalItems.Plank, 6, 4)};
							case 1:
								return new ItemStack[] {new ItemStack(DRPMedievalItems.Plank, 6, 5)};
						}
					return new ItemStack[] {getDefaultOutput()};
				}}*/.setCraftingTime(2));
		
		/**---------- Decorative ----------*/
		
		//Empty Barrel
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.barrelEmpty , 1),
					new ItemStack(DRPMedievalBlocks.barrelEmpty , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalItems.Plank, 5),
						new ItemStack(Items.IRON_INGOT, 2)})
				.setCraftingTime(3));
		
		//Closed Barrel
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
						new ItemStack(DRPMedievalBlocks.barrelClosed , 1),
						new ItemStack(DRPMedievalBlocks.barrelClosed , 1),
						new ItemStack[] {
							new ItemStack(DRPMedievalItems.Plank, 6),
							new ItemStack(Items.IRON_INGOT, 2)})
				.setCraftingTime(3));
				
		//Gunpowder Barrel
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.barrelGunpowder , 1),
					new ItemStack(DRPMedievalBlocks.barrelGunpowder , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalBlocks.barrelEmpty, 1),
						new ItemStack(Items.GUNPOWDER, 9)})
				.setCraftingTime(3));
			
		//Hanging Bridge
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.hangingBridge , 1),
					new ItemStack(DRPMedievalBlocks.hangingBridge , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalItems.Plank, 3),
						new ItemStack(DRPMedievalBlocks.rope,4)})
				.setCraftingTime(3));
			
		//Empty Mug
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.mugEmpty , 1),
					new ItemStack(DRPMedievalBlocks.mugEmpty , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalItems.Plank, 1)})
				.setCraftingTime(3));
			
		//Rope
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.rope , 3),
					new ItemStack(DRPMedievalBlocks.rope , 3),
					new ItemStack[] {
						new ItemStack(Items.STRING,9 )})
				.setCraftingTime(5));
			
		//Rope Anchor
		/*	cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.ropeAnchor , 1),
					new ItemStack(DRPMedievalBlocks.ropeAnchor , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalBlocks.rope,1)},
					new ItemStack[] {
						new ItemStack(Blocks.LOG, 1),
						new ItemStack(Blocks.LOG2, 1)
					}
				){
				@Override
				public short doConditionsMet(ItemStack[] primaryInput, ItemStack[] secondaryInput,int multiplier, EntityPlayer player, BlockPos stationPos) {

					if(secondaryInput != null && secondaryInput.length == 0 || secondaryInput != null && secondaryInput.length == 2){
						return 2;
					}
					
					if( ! doesHaveIngredients(player,primaryInput , multiplier)) {
						return 1;
					}else if(! doesHaveIngredients(player,secondaryInput,multiplier)){
						return 1;
					}
					return 0;
				}
				
				@Override
				public String getUnmetConditionText(short ID) {

					switch (ID) {
						case 0:
							return "Looks like all conditions are met!";
						case 1:
							return "You are missing a few Ingredients!";
						case 2:
							return "You need to select 1 Log Type!";
						default:
							return "Missing Condition! Ask mod Author for better information!";
					}
				}
		}
		.setCraftingTime(3));*/
			
		//Book
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.bookOne , 1),
					new ItemStack(DRPMedievalBlocks.bookOne , 1),
					new ItemStack[] {
						new ItemStack(Items.BOOK,1 )}));
		
		//Ships Wheel
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.shipsWheel , 1),
					new ItemStack(DRPMedievalBlocks.shipsWheel , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalItems.Plank,4 )})
				.setCraftingTime(10));
			
		//Bucket Empty
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.bucketEmpty , 1),
					new ItemStack(DRPMedievalBlocks.bucketEmpty , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalItems.Plank, 1),
						new ItemStack(Items.IRON_INGOT , 1)})
				.setCraftingTime(3));
			
		//Bucket Dirt
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.bucketDirt , 1),
					new ItemStack(DRPMedievalBlocks.bucketDirt , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalBlocks.bucketEmpty, 1),
						new ItemStack(Blocks.DIRT, 1)})
				.setCraftingTime(3));
			
		//Bucket Dirt
			cc.registerRecipe("Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.bucketWater , 1),
					new ItemStack(DRPMedievalBlocks.bucketWater , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalBlocks.bucketEmpty, 1)})
				.setCraftingTime(3));
		
		/**---------- Storage ----------*/
			
			
		//Dungeon Chest
			cc.registerRecipe("Storage",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.dungeonChest , 1),
					new ItemStack(DRPMedievalBlocks.dungeonChest , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalItems.Plank, 4),
						new ItemStack(Items.IRON_INGOT,1)})
				.setCraftingTime(5));
			
		//Crate
			cc.registerRecipe("Storage",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.crate , 1),
					new ItemStack(DRPMedievalBlocks.crate , 1),
					new ItemStack[] {
						new ItemStack(DRPMedievalItems.Plank, 6),
						new ItemStack(Items.IRON_INGOT,1)})
				.setCraftingTime(5));
		
		/**---------- Crafting Stations ----------*/
			
			
		//Anvil ---DOUBLE ITEMS---
			/*cc.registerRecipe("Crafting Stations",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.anvil , 1),
					new ItemStack(DRPMedievalBlocks.anvil , 1),
					new ItemStack[] {
						new ItemStack(Items.IRON_INGOT, 32),
						new ItemStack(Items.STICK, 1)
					})
				.setCraftingTime(30));*/
			
			
		//Firepit
			cc.registerRecipe("Crafting Stations",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
						new ItemStack(DRPMedievalBlocks.firepit , 1),
						new ItemStack(DRPMedievalBlocks.firepit , 1),
						new ItemStack[] {
							new ItemStack(DRPMedievalItems.Firewood, 6),
							new ItemStack(Blocks.COBBLESTONE,2)})
				.setCraftingTime(5));
				
		//Chopping Block
			cc.registerRecipe("Crafting Stations",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.choppingBlock , 1),
					new ItemStack(DRPMedievalBlocks.choppingBlock , 1),
					new ItemStack[] {
						new ItemStack(Items.IRON_AXE,1),
						new ItemStack(Blocks.LOG, 1)
						})
					//new ItemStack[] {
					//	new ItemStack(Blocks.LOG, 1)
					//})
				.setCraftingTime(5));

		//Mortar
			cc.registerRecipe("Crafting Stations",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.mortar , 1),
					new ItemStack(DRPMedievalBlocks.mortar , 1),
					new ItemStack[] {
						new ItemStack(Items.STICK,1),
						new ItemStack(Blocks.STONE,1),
					})
				.setCraftingTime(5));
			
		//Grindstone
			cc.registerRecipe("Crafting Stations",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.grindstone , 1),
					new ItemStack(DRPMedievalBlocks.grindstone , 1),
					new ItemStack[] {
						new ItemStack(Blocks.LOG,2),
						new ItemStack(Blocks.STONE,1),
					})
				.setCraftingTime(5));
		
		/**---------- Misc Items ----------*/

		//Trigger Trap
			cc.registerRecipe("Misc Items",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalItems.TriggerTrap , 1),
					new ItemStack(DRPMedievalItems.TriggerTrap , 1),
					new ItemStack[] {
							new ItemStack(Items.STRING, 2), 
							new ItemStack(Blocks.TRIPWIRE_HOOK, 1)
					})
				.setCraftingTime(2));
			
		//Leather Purse
			cc.registerRecipe("Misc Items",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalItems.LeatherPurse , 1),
					new ItemStack(DRPMedievalItems.LeatherPurse , 1),
					new ItemStack[] {
							new ItemStack(Items.LEATHER, 2), 
							new ItemStack(DRPMedievalItems.LeatherString,1)
					})
				.setCraftingTime(5));
			
		//Golden Coin
			cc.registerRecipe("Misc Items",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalItems.GoldenCoin , 1),
					new ItemStack(DRPMedievalItems.GoldenCoin , 1),
					new ItemStack[] {
							new ItemStack(DRPMedievalItems.SilverCoin, 100)
					}));
			
		//Silver Coin (from Gold)
			cc.registerRecipe("Misc Items",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalItems.SilverCoin , 100),
					new ItemStack(DRPMedievalItems.SilverCoin , 100),
					new ItemStack[] {
							new ItemStack(DRPMedievalItems.GoldenCoin, 1)
					}));	
		
		//Silver Coin (from Bronze)
			cc.registerRecipe("Misc Items",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalItems.SilverCoin , 1),
					new ItemStack(DRPMedievalItems.SilverCoin , 1),
					new ItemStack[] {
							new ItemStack(DRPMedievalItems.BronzeCoin, 100)
					}));
			
		//Bronze Coin (from Silver)
			cc.registerRecipe("Misc Items",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalItems.BronzeCoin , 100),
					new ItemStack(DRPMedievalItems.BronzeCoin , 100),
					new ItemStack[] {
							new ItemStack(DRPMedievalItems.SilverCoin, 1)
					}));	
	
		//Bronze Coin (from Silver)
			cc.registerRecipe("Food Items",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalItems.DoughWheat , 1),
					new ItemStack(DRPMedievalItems.DoughWheat , 1),
					new ItemStack[] {
							new ItemStack(DRPMedievalItems.FlourWheat, 1), 
							new ItemStack(Items.POTIONITEM,1,0)
					}));
		
			

	/**---------- Anvil Crafting Station ----------*/
			
		/**---------- Crafting Stations ----------*/

		//Cauldron
			cc.registerRecipe(DRPMedievalBlocks.anvil,"Crafting Stations",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.cauldron, 1),
					new ItemStack(DRPMedievalBlocks.cauldron , 1),
					new ItemStack[] {
							new ItemStack(Items.IRON_INGOT, 12), 
							new ItemStack(DRPMedievalItems.Firewood, 5)
					})
				.setCraftingTime(15));
			
		//Hanging Cauldron
			cc.registerRecipe(DRPMedievalBlocks.anvil,"Crafting Stations",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.hangingCauldron, 1),
					new ItemStack(DRPMedievalBlocks.hangingCauldron , 1),
					new ItemStack[] {
							new ItemStack(Items.IRON_INGOT, 10)
					})
				.setCraftingTime(15));
			
			
		/**---------- Decorative ----------*/

		//Chain
			cc.registerRecipe(DRPMedievalBlocks.anvil,"Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.chain, 3),
					new ItemStack(DRPMedievalBlocks.chain , 3),
					new ItemStack[] {
							new ItemStack(Items.IRON_INGOT, 2)
					})
				.setCraftingTime(10));

		//Iron Hook
			cc.registerRecipe(DRPMedievalBlocks.anvil,"Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.ironHook, 1),
					new ItemStack(DRPMedievalBlocks.ironHook , 1),
					new ItemStack[] {
							new ItemStack(Items.IRON_INGOT, 1)
					})
				.setCraftingTime(10));	
			
		//Torch Holder
			cc.registerRecipe(DRPMedievalBlocks.anvil,"Deco",
				new AdvancedRecipe(
					DarkRoleplayMedieval.MODID,
					new ItemStack(DRPMedievalBlocks.torchHolderEmpty, 3),
					new ItemStack(DRPMedievalBlocks.torchHolderEmpty , 3),
					new ItemStack[] {
							new ItemStack(Items.IRON_INGOT, 2)
					})
				.setCraftingTime(10));	

//		/* Chopping Block Crafting Station */
//
//		// Firewood
//
//		/* Firewood */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 0), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log), 1, 0)}, null));
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 1), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log), 1, 1)}, null));
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 2), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log), 1, 2)}, null));
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 3), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log), 1, 3)}, null));
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 4), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log2), 1, 0)}, null));
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 5), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log2), 1, 1)}, null));
//
//		/* Mortar */
//
//		// Pulverize
//
//		/* Flour Wheat */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.mortar, "Pulverize", new ItemStack(DRPMedievalItems.itemFlourWheat), new ItemStack[] {new ItemStack(Items.wheat)}, null));
//		/* Bone Meal */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.mortar, "Pulverize", new ItemStack(Items.dye, 4, 15), new ItemStack[] {new ItemStack(Items.bone)}, null));
//
//		/* Cauldron */
//
//		// Stews
//
//		/* Pumpkin Stew */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(DRPMedievalItems.itemPumpkinStew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Blocks.pumpkin)}, new ItemStack[] {new ItemStack(Items.carrot), new ItemStack(Items.milk_bucket)}));
//		/* Vegie Stew */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(DRPMedievalItems.itemVegieStew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Items.potato), new ItemStack(Items.carrot)}, null));
//		/* Vegie Stew */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(DRPMedievalItems.itemCodStew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Items.fish, 1, 0)}, new ItemStack[] {new ItemStack(Items.carrot), new ItemStack(Items.potato)}));
//		/* Chicken Stew */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(DRPMedievalItems.itemChickenStew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Items.chicken, 1, 0), new ItemStack(Items.carrot)}, null));
//		/* Mushroom Stew */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(Items.mushroom_stew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Blocks.red_mushroom), new ItemStack(Blocks.brown_mushroom)}, null));
//		/* Rabbit Stew */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(Items.rabbit_stew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Items.rabbit), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Blocks.brown_mushroom)}, null));

		
	}
	
	public static void postInit(FMLPostInitializationEvent event) {}
	
}

