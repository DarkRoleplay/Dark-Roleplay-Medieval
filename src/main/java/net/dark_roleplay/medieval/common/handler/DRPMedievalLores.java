package net.dark_roleplay.medieval.common.handler;

import java.util.Arrays;

import net.dark_roleplay.drpcore.api.util.lore.LoreUtil;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class DRPMedievalLores {

	public static final void init(FMLPreInitializationEvent event) {}
	
	public static final void init(FMLInitializationEvent event) {}
	
	public static final void init(FMLPostInitializationEvent event) {
		
		//OTHER DESCRIPTIONS
		DRPMedievalLores.registerSHIFT(DRPMedievalItems.TRIGGER_TRAP, TextFormatting.WHITE + "Usage:\n" + TextFormatting.GRAY + "Apply it to a Torch Holder and use\nthe Torch Holder as a Lever.");
		DRPMedievalLores.registerSHIFT(DRPMedievalItems.TAP, TextFormatting.WHITE + "Usage:\n" + TextFormatting.GRAY + "Apply it to a Sideway Barrel \nand drain drinks from it.");

		
		//COINS
		DRPMedievalLores.registerSHIFT(DRPMedievalItems.BRONZE_COIN, "The coin with the lowest value. \n100 of it equal a single Silver Coin.");
		DRPMedievalLores.registerSHIFT(DRPMedievalItems.SILVER_COIN, "The most common coin. \n100 of it equal a single Gold Coin \nand one of it equals 100 Bronze Coins.");
		DRPMedievalLores.registerSHIFT(DRPMedievalItems.GOLDEN_COIN, "The most shiny coin. \nOne of it equal 100 Silver Coins, \nor even 10.000 Bronze Coins");
		
		//CRAFT MATS
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.LEATHER_STRING_TANNED);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.LEATHER_TANNED);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.LEATHER_STRING);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.PLANKS);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.FLOUR);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.POWDER_CHARCOAL);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.ORE_CHUNK_SILVER);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.ORE_CHUNK_COPPER);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.ORE_CHUNK_SALPETER);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.ORE_CHUNK_SULFUR);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.ORE_CHUNK_TIN);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.BAT_EAR);



		
		
		//WIP's
		DRPMedievalLores.registerWIP(DRPMedievalItems.LEATHER_BOOK_COVER);
		DRPMedievalLores.registerWIP(DRPMedievalItems.LEATHER_BOOK_COVER_THIK);
		DRPMedievalLores.registerWIP(DRPMedievalItems.LEATHER_BOOK_COVER_THIN);
		DRPMedievalLores.registerWIP(Item.getItemFromBlock(DRPMedievalBlocks.AXLE));
		DRPMedievalLores.registerWIP(Item.getItemFromBlock(DRPMedievalBlocks.CHEST_TEST));
		DRPMedievalLores.registerWIP(Item.getItemFromBlock(DRPMedievalBlocks.FORGE));

		DRPMedievalLores.registerWIP(DRPMedievalItems.LUTE);
		DRPMedievalLores.registerWIP(DRPMedievalItems.HALBERD);
		DRPMedievalLores.registerWIP(DRPMedievalItems.QUIVER);
		DRPMedievalLores.registerWIP(DRPMedievalItems.BRONZE_RING);
		DRPMedievalLores.registerWIP(DRPMedievalItems.SILVER_RING);
		DRPMedievalLores.registerWIP(DRPMedievalItems.GOLDEN_RING);
		DRPMedievalLores.registerWIP(DRPMedievalItems.LEATHER_PURSE);
		DRPMedievalLores.registerWIP(DRPMedievalItems.SLEDGE);
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
