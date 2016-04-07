package net.drpmedieval.common.worldgen;

import net.drpmedieval.common.items.DRPMedievalItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.FishingHooks;
import net.minecraftforge.common.MinecraftForge;

public class WorldLoot {

	public static void registerChestLoot() {

		// Bonus Chest
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemBronzeCoin), 15, 30, 40));

		// Dungeon Chest
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemBronzeCoin), 25, 50, 50));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemSilverCoin), 5, 15, 40));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemSilverCoin), 1, 3, 30));

		// Mineshaft Corridor
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemBronzeCoin), 1, 5, 30));

		// Nether Fortress
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemBronzeCoin), 15, 30, 20));

		// Desert Pyramid Chest
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemBronzeCoin), 32, 64, 35));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemSilverCoin), 5, 25, 30));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemSilverCoin), 3, 10, 20));

		// Jungle Pyramid Chest
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemBronzeCoin), 32, 64, 40));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemSilverCoin), 3, 17, 20));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemSilverCoin), 3, 10, 30));

		// Jungle Pyramid Dispenser

		// Stronghold Corridor
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemBronzeCoin), 1, 16, 20));

		// Stronghold Crossing
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemBronzeCoin), 1, 16, 20));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemSilverCoin), 1, 10, 15));

		// Stronghold Library
		// ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new
		// WeightedRandomChestContent(new
		// ItemStack(DRPMedievalItems.itemBronzeCoin),32,64,50));

		// Village Blacksmith
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemBronzeCoin), 1, 64, 60));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemBronzeCoin), 1, 64, 60));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemSilverCoin), 1, 32, 30));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(DRPMedievalItems.itemGoldenCoin), 1, 3, 10));
	}

	public static void registerGrassLoot() {

		MinecraftForge.addGrassSeed(new ItemStack(DRPMedievalItems.itemSeedBarley), 1);
	}

	public static void registerFishingLoot() {

		FishingHooks.addFish(new WeightedRandomFishable(new ItemStack(DRPMedievalItems.itemCatfishRaw, 1), 10));
		FishingHooks.addTreasure(new WeightedRandomFishable(new ItemStack(DRPMedievalItems.itemBronzeCoin, 1), 40));
		FishingHooks.addTreasure(new WeightedRandomFishable(new ItemStack(DRPMedievalItems.itemSilverCoin, 1), 15));
		FishingHooks.addTreasure(new WeightedRandomFishable(new ItemStack(DRPMedievalItems.itemGoldenCoin, 1), 5));
	}

}
