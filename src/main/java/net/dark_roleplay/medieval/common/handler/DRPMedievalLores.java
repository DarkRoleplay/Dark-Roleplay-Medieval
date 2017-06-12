package net.dark_roleplay.medieval.common.handler;

import java.util.Arrays;

import net.dark_roleplay.medieval.common.util.LoreHelper;
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
		DRPMedievalLores.registerSHIFT(DRPMedievalItems.TriggerTrap, TextFormatting.WHITE + "Usage:\n" + TextFormatting.GRAY + "Apply it to a Torch Holder and use\nthe Torch Holder as a Lever.");
		DRPMedievalLores.registerSHIFT(DRPMedievalItems.TAP, TextFormatting.WHITE + "Usage:\n" + TextFormatting.GRAY + "Apply it to a Sideway Barrel \nand drain drinks from it.");

		
		//COINS
		DRPMedievalLores.registerSHIFT(DRPMedievalItems.BronzeCoin, "The coin with the lowest value. \n100 of it equal a single Silver Coin.");
		DRPMedievalLores.registerSHIFT(DRPMedievalItems.SilverCoin, "The most common coin. \n100 of it equal a single Gold Coin \nand one of it equals 100 Bronze Coins.");
		DRPMedievalLores.registerSHIFT(DRPMedievalItems.GoldenCoin, "The most shiny coin. \nOne of it equal 100 Silver Coins, \nor even 10.000 Bronze Coins");
		
		//CRAFT MATS
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.TannedLeatherString);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.TannedLeather);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.LeatherString);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.Plank);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.FlourWheat);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.FlourBarley);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.CHARCOAL_POWDER);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.SILVER_ORE_CHUNK);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.COPPER_ORE_CHUNK);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.SALPETER_ORE_CHUNK);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.SULFUR_ORE_CHUNK);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.TIN_ORE_CHUNK);
		DRPMedievalLores.registerCRAFT_MAT(DRPMedievalItems.BatEar);



		
		
		//WIP's
		DRPMedievalLores.registerWIP(DRPMedievalItems.LeatherBookCover);
		DRPMedievalLores.registerWIP(DRPMedievalItems.LeatherBookCoverThik);
		DRPMedievalLores.registerWIP(Item.getItemFromBlock(DRPMedievalBlocks.AXLE));
		DRPMedievalLores.registerWIP(Item.getItemFromBlock(DRPMedievalBlocks.CHEST_TEST));

		DRPMedievalLores.registerWIP(DRPMedievalItems.LeatherBookCoverThin);
		DRPMedievalLores.registerWIP(DRPMedievalItems.Quiver);
		DRPMedievalLores.registerWIP(DRPMedievalItems.BronzeRing);
		DRPMedievalLores.registerWIP(DRPMedievalItems.SilverRing);
		DRPMedievalLores.registerWIP(DRPMedievalItems.GoldenRing);
		DRPMedievalLores.registerWIP(DRPMedievalItems.LeatherPurse);
		DRPMedievalLores.registerWIP(DRPMedievalItems.SLEDGE);
	}
	
	private static void registerSHIFT(Item item, String desc){
		LoreHelper.registerSHIFT_DESC(item, Arrays.asList(desc.split("\n")));
	}
	
	private static void registerWIP(Item item){
		LoreHelper.registerPERM_DESC(item, Arrays.asList((TextFormatting.YELLOW + "WARNING! Item is still W.I.P.").split("\n")));
		LoreHelper.registerALT_DESC(item, Arrays.asList(("It is recomended to not use it in any case! \nThe Item might just disapear in a \nfuture version of the mod, \nor it could destroy your world! \nEven though most of the time this \nmeans that the functions aren't done.").split("\n")));
	}
	
	private static void registerCRAFT_MAT(Item item){
		LoreHelper.registerSHIFT_DESC(item, Arrays.asList("Just a simple Item used for crafting.".split("\n")));

	}
}
