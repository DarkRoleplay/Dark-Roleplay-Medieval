package net.drpmedieval.common.crafting;

import net.drpcore.common.crafting.AdvancedRecipe;
import net.drpcore.common.crafting.CraftingController;
import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DRPMedievalCrafting {

	//Used to do all Crafting stuff (Registration)
	public static void preInit(FMLPreInitializationEvent event) {}
	
	public static void init(FMLInitializationEvent event) {
			
		CraftingController cc = CraftingController.INSTANCE;
		
		//Empty Barrel
		cc.registerRecipe("Decoration", new AdvancedRecipe(DarkRoleplayMedieval.MODID,new ItemStack(DRPMedievalBlocks.barrelEmpty , 1), new ItemStack(DRPMedievalBlocks.barrelEmpty , 1), new ItemStack[] {new ItemStack(Blocks.PLANKS, 5, 0), new ItemStack(Items.IRON_INGOT, 2)}));
		

		/* Crafted without Crafting Station */

		// Decorative Blocks

//		// CraftingManager.RegisterRecipe(new CraftingRecipe(null, "Blocks", new
//		// ItemStack(), new ItemStack[]{},null));
//		/* Empty Barrel */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.barrelEmpty, 1), new ItemStack[] {new ItemStack(Blocks.planks, 5, 0), new ItemStack(Items.iron_ingot, 2)}, null));
//		/* Closed Barrel */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.barrelClosed, 1), new ItemStack[] {new ItemStack(Blocks.planks, 6, 0), new ItemStack(Items.iron_ingot, 2)}, null));
//		/* Gunpowder Barrel */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.barrelGunpowder, 1), new ItemStack[] {new ItemStack(Blocks.planks, 5, 0), new ItemStack(Items.iron_ingot, 2), new ItemStack(Items.gunpowder, 9)}, null));
//		/* Hanging Bridge */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.hangingBridge, 1), new ItemStack[] {new ItemStack(Blocks.planks, 1, 0), new ItemStack(Items.string, 6)}, null));
//		/* Mug Empty */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.mugEmpty, 1), new ItemStack[] {new ItemStack(Blocks.planks, 2)}, null));
//		/* Rope */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.rope, 3), new ItemStack[] {new ItemStack(Items.string, 9)}, null));
//		/* Rope Anchor */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.ropeAnchor, 1), new ItemStack[] {new ItemStack(Blocks.log, 1, 0), new ItemStack(DRPMedievalBlocks.rope, 1)}, null));
//		/* Book */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.bookOne, 1), new ItemStack[] {new ItemStack(Items.book)}, null));
//		/* Ships Wheel */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.shipsWheel, 1), new ItemStack[] {new ItemStack(Blocks.planks, 4)}, null));
//		/* Bucket Empty */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.bucketEmpty, 1), new ItemStack[] {new ItemStack(Blocks.planks, 2), new ItemStack(Items.iron_ingot)}, null));
//		/* Bucket Dirt */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.bucketDirt, 1), new ItemStack[] {new ItemStack(DRPMedievalBlocks.bucketEmpty, 1), new ItemStack(Blocks.dirt)}, null));
//		/* Bucket Water */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.bucketWater, 1), new ItemStack[] {new ItemStack(DRPMedievalBlocks.bucketEmpty, 1), new ItemStack(Items.water_bucket)}, null));
//
//		// Storage
//
//		/* Crate */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Storage", new ItemStack(DRPMedievalBlocks.crate, 1), new ItemStack[] {new ItemStack(Blocks.planks, 6), new ItemStack(Items.iron_ingot, 4)}, null));
//		/* Dungeon Chest */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Storage", new ItemStack(DRPMedievalBlocks.dungeonChest, 1), new ItemStack[] {new ItemStack(Blocks.planks, 4), new ItemStack(Items.iron_ingot, 2)}, null));
//
//		// Crafting Stations
//
//		/* Firepit */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Crafting Stations", new ItemStack(DRPMedievalBlocks.firepit, 1), new ItemStack[] {new ItemStack(DRPMedievalItems.itemFirewood, 6), new ItemStack(Blocks.cobblestone, 3)}, null));
//
//		/* Chopping Block */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Crafting Stations", new ItemStack(DRPMedievalBlocks.choppingBlock, 1), new ItemStack[] {new ItemStack(Blocks.log, 1, 0), new ItemStack(Items.iron_axe, 1)}, null));
//
//		/* Anvil */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Crafting Stations", new ItemStack(DRPMedievalBlocks.anvil, 1), new ItemStack[] {new ItemStack(Items.iron_ingot, 32), new ItemStack(Items.stick, 1)}, null));
//
//		/* Mortar */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Crafting Stations", new ItemStack(DRPMedievalBlocks.mortar, 1), new ItemStack[] {new ItemStack(Blocks.stone, 1, 0), new ItemStack(Items.stick, 1)}, null));
//
//		/* Grindstone */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Crafting Stations", new ItemStack(DRPMedievalBlocks.grindstone, 1), new ItemStack[] {new ItemStack(Blocks.stone, 4), new ItemStack(Blocks.log, 3, 0)}, null));
//
//		// Items
//
//		/* Trigger Trap */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemTriggerTrap, 2), new ItemStack[] {new ItemStack(Items.string, 2), new ItemStack(Blocks.tripwire_hook, 1)}, null));
//		/* Leather Purse */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemLeatherPurse, 1), new ItemStack[] {new ItemStack(Items.leather, 3), new ItemStack(DRPMedievalBlocks.rope, 1)}, null));
//
//		/* Golden Coin */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemGoldenCoin, 1), new ItemStack[] {new ItemStack(DRPMedievalItems.itemSilverCoin, 100)}, null));
//		/* Silver Coin */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemSilverCoin, 1), new ItemStack[] {new ItemStack(DRPMedievalItems.itemBronzeCoin, 100)}, null));
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemSilverCoin, 100), new ItemStack[] {new ItemStack(DRPMedievalItems.itemGoldenCoin, 1)}, null));
//		/* Bronze Coin */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemBronzeCoin, 100), new ItemStack[] {new ItemStack(DRPMedievalItems.itemSilverCoin, 1)}, null));
//
//		// Food
//		/* Wheat Dough */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Food", new ItemStack(DRPMedievalItems.itemDoughWheat, 1), new ItemStack[] {new ItemStack(DRPMedievalItems.itemFlourWheat, 1), new ItemStack(DRPMedievalItems.itemFlourWheat)}, null));
//
//		// Item --> Block
//
//		/* Apple Red */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.appleRed), new ItemStack[] {new ItemStack(Items.apple)}, null));
//		/* Apple Green */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.appleGreen), new ItemStack[] {new ItemStack(DRPMedievalItems.itemAppleGreen)}, null));
//		/* Apple Yellow */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.appleYellow), new ItemStack[] {new ItemStack(DRPMedievalItems.itemAppleYellow)}, null));
//		/* Pear Green */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.pearGreen), new ItemStack[] {new ItemStack(DRPMedievalItems.itemPearGreen)}, null));
//		/* Pear Yellow */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.pearYellow), new ItemStack[] {new ItemStack(DRPMedievalItems.itemPearYellow)}, null));
//		/* Mushroom Brown */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.mushroomBrown), new ItemStack[] {new ItemStack(Blocks.brown_mushroom)}, null));
//		/* Mushroom Red */
//		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.mushroomRed), new ItemStack[] {new ItemStack(Blocks.red_mushroom)}, null));
//
//		/* Anvil Crafting Station */
//
//		// Crafting Stations
//
//		/* Cauldron on Firepit */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.anvil, "Crafting Stations", new ItemStack(DRPMedievalBlocks.cauldron, 1), new ItemStack[] {new ItemStack(Items.iron_ingot, 12), new ItemStack(DRPMedievalItems.itemFirewood, 5)}, null));
//
//		// Decorative Blocks
//
//		/* Chain */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.anvil, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.chain, 3), new ItemStack[] {new ItemStack(Items.iron_ingot, 3)}, null));
//		/* Hook */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.anvil, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.hook, 1), new ItemStack[] {new ItemStack(Items.iron_ingot, 2)}, null));
//		/* Hanging Cauldron */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.anvil, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.hangingCauldron), new ItemStack[] {new ItemStack(Items.iron_ingot, 12)}, null));
//		/* Torch Holder */
//		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.anvil, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.torchHolderEmpty), new ItemStack[] {new ItemStack(Items.iron_ingot)}, null));
//
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

