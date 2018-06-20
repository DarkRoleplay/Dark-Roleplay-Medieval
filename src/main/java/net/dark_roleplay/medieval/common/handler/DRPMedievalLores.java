package net.dark_roleplay.medieval.common.handler;

import java.util.Arrays;

import net.dark_roleplay.core.api.old.util.lore.LoreUtil;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DRPMedievalLores {

	public static final void init(FMLPreInitializationEvent event) {}
	
	public static final void init(FMLInitializationEvent event) {}
	
	public static final void init(FMLPostInitializationEvent event) {
		
//		//OTHER DESCRIPTIONS
//		DRPMedievalLores.registerSHIFT(TRIGGER_TRAP, TextFormatting.WHITE + "Usage:\n" + TextFormatting.GRAY + "Apply it to a Torch Holder and use\nthe Torch Holder as a Lever.");
//		DRPMedievalLores.registerSHIFT(TAP, TextFormatting.WHITE + "Usage:\n" + TextFormatting.GRAY + "Apply it to a Sideway Barrel \nand drain drinks from it.");
//
//		registerSHIFT(Item.getItemFromBlock(CLOCK_CORE), TextFormatting.WHITE + "Usage:\n" + TextFormatting.GRAY + "Switch between ingame time and real time using a wrench.");
//		registerSHIFT(Item.getItemFromBlock(CLOCK_DIAL), TextFormatting.WHITE + "Usage:\n" + TextFormatting.GRAY + "Can only be placed on top of a \"Clock Core\"");
//		
////		DRPMedievalLores.registerSHIFT(VINE_ROPE, "It's not very strong and will probably tear up under bigger weight.");
////		DRPMedievalLores.registerSHIFT(THIN_ROPE, "Better than a Vine Rope but not strong enough to hold more than an animal/player.");
////		DRPMedievalLores.registerSHIFT(ROPE, "Strong enough to handle a few animals/players and maybe even a few blocks.");
////		DRPMedievalLores.registerSHIFT(THICK_ROPE, "As strong as a rope can be, even strong enough for a few big stones");
////		DRPMedievalLores.registerSHIFT(THIN_CHAIN, "You might think a chain is stronger than a rope, and usually it is...\n but this chain is so thin that it's equal to a normal rope.");
////		DRPMedievalLores.registerSHIFT(CHAIN, "A real chain! Can hold a big amount of heavy things...\n *thinking* might even be strong enough to hold a dragon *thinking*");
////		DRPMedievalLores.registerSHIFT(THICK_CHAIN, "Nothing can hold more weight than this chain.");
//		//COINS
//		DRPMedievalLores.registerSHIFT(BRONZE_COIN, "The coin with the lowest value. \n100 of it equal a single Silver Coin.");
//		DRPMedievalLores.registerSHIFT(SILVER_COIN, "The most common coin. \n100 of it equal a single Gold Coin \nand one of it equals 100 Bronze Coins.");
//		DRPMedievalLores.registerSHIFT(GOLDEN_COIN, "The most shiny coin. \nOne of it equal 100 Silver Coins, \nor even 10.000 Bronze Coins");
//		
//		//CRAFT MATS
//		DRPMedievalLores.registerCRAFT_MAT(LEATHER_STRING_TANNED);
//		DRPMedievalLores.registerCRAFT_MAT(LEATHER_TANNED);
//		DRPMedievalLores.registerCRAFT_MAT(LEATHER_STRING);
//		DRPMedievalLores.registerCRAFT_MAT(PLANKS);
//		DRPMedievalLores.registerCRAFT_MAT(FLOUR);
//		DRPMedievalLores.registerCRAFT_MAT(POWDER_CHARCOAL);
//		DRPMedievalLores.registerCRAFT_MAT(ORE_CHUNK_SILVER);
//		DRPMedievalLores.registerCRAFT_MAT(ORE_CHUNK_COPPER);
//		DRPMedievalLores.registerCRAFT_MAT(ORE_CHUNK_SALPETER);
//		DRPMedievalLores.registerCRAFT_MAT(ORE_CHUNK_SULFUR);
//		DRPMedievalLores.registerCRAFT_MAT(ORE_CHUNK_TIN);
//		DRPMedievalLores.registerCRAFT_MAT(BAT_EAR);
//		
//		//WIP's
//		DRPMedievalLores.registerWIP(LEATHER_BOOK_COVER);
//		DRPMedievalLores.registerWIP(LEATHER_BOOK_COVER_THIK);
//		DRPMedievalLores.registerWIP(LEATHER_BOOK_COVER_THIN);
//		DRPMedievalLores.registerWIP(Item.getItemFromBlock(DRPMedievalBlocks.AXLE));
//		DRPMedievalLores.registerWIP(Item.getItemFromBlock(DRPMedievalBlocks.CHEST_TEST));
//		DRPMedievalLores.registerWIP(Item.getItemFromBlock(DRPMedievalBlocks.FORGE));
//		registerWIP(WOODEN_LOCK);
//		registerWIP(WOODEN_KEY);
//		registerWIP(FLINT_KNIFE);
//		
//		DRPMedievalLores.registerWIP(LUTE);
//		DRPMedievalLores.registerWIP(HALBERD);
//		DRPMedievalLores.registerWIP(QUIVER);
//		DRPMedievalLores.registerWIP(BRONZE_RING);
//		DRPMedievalLores.registerWIP(SILVER_RING);
//		DRPMedievalLores.registerWIP(GOLDEN_RING);
//		DRPMedievalLores.registerWIP(LEATHER_PURSE);
	}
	
	private static void registerSHIFT(Item item, String desc){
		LoreUtil.registerSHIFT(item, Arrays.asList(desc.split("\n")));
	}
	
	private static void registerWIP(Item item){
		LoreUtil.registerPERM(item, Arrays.asList((TextFormatting.YELLOW + "WARNING! Item is still W.I.P.").split("\n")));
		LoreUtil.registerALT(item, Arrays.asList(("It is recomended to not use it in any case! \nThe Item might just disapear in a \nfuture version of the mod, \nor it could destroy your world! \nEven though most of the time this \nmeans that the functions aren't done.").split("\n")));
	}
	
	private static void registerCRAFT_MAT(Item item){
		LoreUtil.registerSHIFT(item, Arrays.asList("Just a simple Item used for crafting.".split("\n")));

	}
}
