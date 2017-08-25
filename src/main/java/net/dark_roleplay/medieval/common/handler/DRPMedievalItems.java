package net.dark_roleplay.medieval.common.handler;

import java.util.ArrayList;
import java.util.List;

import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.dark_roleplay.drpcore.api.items.DRPFood;
import net.dark_roleplay.drpcore.api.items.DRPItem;
import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.items.blocks.AdvancedBedItem;
import net.dark_roleplay.medieval.common.items.blocks.HangingBridge_Item;
import net.dark_roleplay.medieval.common.items.book.WriteablePage;
import net.dark_roleplay.medieval.common.items.consumable.BarkAndGlue;
import net.dark_roleplay.medieval.common.items.consumable.RopedArrow;
import net.dark_roleplay.medieval.common.items.entities.Sledge;
import net.dark_roleplay.medieval.common.items.equipment.instruments.Instrument;
import net.dark_roleplay.medieval.common.items.equipment.other.Telescope;
import net.dark_roleplay.medieval.common.items.equipment.weapons.PoleWeapon;
import net.dark_roleplay.medieval.common.items.food.DRPMStew;
import net.dark_roleplay.medieval.common.items.food.PumpkinBread;
import net.dark_roleplay.medieval.common.items.misc.DoughBarley;
import net.dark_roleplay.medieval.common.items.misc.DoughPumpkin;
import net.dark_roleplay.medieval.common.items.misc.DoughWheat;
import net.dark_roleplay.medieval.common.items.misc.Firewood;
import net.dark_roleplay.medieval.common.items.misc.LeatherBookCover;
import net.dark_roleplay.medieval.common.items.misc.LeatherBookCoverThik;
import net.dark_roleplay.medieval.common.items.misc.LeatherBookCoverThin;
import net.dark_roleplay.medieval.common.items.misc.Plank;
import net.dark_roleplay.medieval.common.items.misc.StringCoil;
import net.dark_roleplay.medieval.common.items.seeds.SeedBarley;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class DRPMedievalItems {

	
	private static List<ItemBlock> blockItems = new ArrayList<ItemBlock>();
	
	public static void addBlockItem(ItemBlock item){
		blockItems.add(item);
	}
	
	/** In Dev Items **/
	
	public static WriteablePage wpg = new WriteablePage();
	
	/** A **/
	

	public static DRPFood BLUE_BERRY;
	public static DRPFood GRAPE;
	public static DRPFood GARLIC;
	public static DRPFood ONION;
	public static DRPFood CAULIFLOWER;
	public static DRPFood APPLE_GREEN;
	public static DRPFood APPLE_YELLOW;
	public static DRPFood FISH_COOKED_CATFISH;
	public static DRPFood FISH_RAW_CATFISH;
	public static DRPFood PEAR_GREEN;
	public static DRPFood PEAR_YELLOW;
	public static DRPFood TURNIP;
	public static DRPFood HOPS;
	public static DRPFood MEAT_COOKED_WOLF;
	public static DRPFood MEAT_RAW_WOLF;
	public static DRPFood PUMPKIN_BREAD;
	
	public static DRPItem BARLEY;
	public static DRPItem BAT_EAR;
	public static DRPItem FUR_WOLF;
	public static DRPItem TAP;
	public static DRPItem LEATHER_STRING;
	public static DRPItem LEATHER_TANNED;
	public static DRPItem LEATHER_STRING_TANNED;
	public static DRPItem TRIGGER_TRAP;
	public static DRPItem POWDER_CHARCOAL;
	public static DRPItem ORE_CHUNK_SILVER;
	public static DRPItem ORE_CHUNK_TIN;
	public static DRPItem ORE_CHUNK_COPPER;
	public static DRPItem ORE_CHUNK_SULFUR;
	public static DRPItem ORE_CHUNK_SALPETER;
	public static DRPItem DRY_CLAY_CHUNK;
	public static DRPItem FIREWOOD;
	public static DRPItem PLANKS;
	public static DRPItem DOUGH;
	public static DRPItem DOUGH_PUMPKIN;
	public static DRPItem FLOUR;
	public static DRPItem BRONZE_COIN;
	public static DRPItem SILVER_COIN;
	public static DRPItem GOLDEN_COIN;
	public static DRPItem LEATHER_BOOK_COVER;
	public static DRPItem LEATHER_BOOK_COVER_THIK;
	public static DRPItem LEATHER_BOOK_COVER_THIN;

	public static DRPItem CLEAN_PAINTBRUSH;
	public static DRPItem BLACK_PAINTBRUSH;

	public static Telescope GOLDEN_TELESCOPE;
	public static Telescope SILVER_TELESCOPE;
	
	public static HangingBridge_Item HANGING_BRIDGE;
	
	public static Instrument LUTE;
	
	public static PoleWeapon HALBERD;
	
	public static DRPEquip QUIVER;
	public static DRPEquip LEATHER_PURSE;
	public static DRPEquip BRONZE_RING;
	public static DRPEquip SILVER_RING;
	public static DRPEquip GOLDEN_RING;
	
	public static DRPMStew CHICKEN_STEW;
	public static DRPMStew COD_STEW;
	public static DRPMStew VEGIE_STEW;
	public static DRPMStew PUMPKIN_STEW;

	//OLD SYSTEM
	public static BarkAndGlue BARK_AND_GLUE;
	public static RopedArrow ROPED_ARROW = new RopedArrow();
	public static SeedBarley SeedBarley;
	public static StringCoil StringCoil = new StringCoil();
	public static Sledge SLEDGE = new Sledge();

	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> reg = event.getRegistry();
		
		reg.register(APPLE_GREEN = (DRPFood) new DRPFood(4, 0.3F, "apple_green", "food/fruits", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(APPLE_YELLOW = (DRPFood) new DRPFood(4, 0.3F, "apple_yellow", "food/fruits", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(FISH_COOKED_CATFISH = (DRPFood) new DRPFood(6, 0.6F, "fish_cooked_catfish", "food/fish", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(FISH_RAW_CATFISH = (DRPFood) new DRPFood(2, 0.3F, "fish_raw_catfish", "food/fish", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(BLUE_BERRY = (DRPFood) new DRPFood(1, 0.1F, "blue_berrys", "food/fruits", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(GRAPE = (DRPFood) new DRPFood(2, 0.2F,"grapes", "food/fruits", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(GARLIC = (DRPFood) new DRPFood(2, 0.4F,"garlic", "food/vegetables", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(ONION = (DRPFood) new DRPFood(2, 0.4F,"onion", "food/vegetables", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(CAULIFLOWER = (DRPFood) new DRPFood(4, 0.4F,"cauliflower", "food/vegetables", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(MEAT_COOKED_WOLF = (DRPFood) new DRPFood(6, 0.4F,"meat_cooked_wolf", "food/meat", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(MEAT_RAW_WOLF = (DRPFood) new DRPFood(2, 0.15F,"meat_raw_wolf", "food/meat", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(PEAR_YELLOW = (DRPFood) new DRPFood(4, 0.3F,"pear_green", "food/fruits", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(PEAR_GREEN = (DRPFood) new DRPFood(4, 0.3F,"pear_yellow", "food/fruits", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(TURNIP = (DRPFood) new DRPFood(2, 0.4F,"turnip", "food/vegetables", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(HOPS = (DRPFood) new DRPFood(2, 0.4F,"hops", "food/vegetables", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		reg.register(PUMPKIN_BREAD = (DRPFood) new DRPFood(6, 0.5F,"pumpkin_bread", "food/bakewares", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab));
		
		reg.register(BARLEY = (DRPItem) new DRPItem("barley", "cereals", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		
		reg.register(TAP = (DRPItem) new DRPItem("tap", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(LEATHER_STRING = (DRPItem) new DRPItem("leather_string", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(LEATHER_STRING_TANNED = (DRPItem) new DRPItem("leather_string_tanned", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(LEATHER_TANNED = (DRPItem) new DRPItem("leather_tanned", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(TRIGGER_TRAP = (DRPItem) new DRPItem("trigger_trap", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(BAT_EAR = (DRPItem) new DRPItem("bat_ear", "mobs/bat", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(FUR_WOLF = (DRPItem) new DRPItem("fur_wolf", "mobs/wolf", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(DRY_CLAY_CHUNK = (DRPItem) new DRPItem("dry_clay_chunk", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(POWDER_CHARCOAL = (DRPItem) new DRPItem("powder_charcoal", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(ORE_CHUNK_SILVER = (DRPItem) new DRPItem("ore_chunk_silver", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(ORE_CHUNK_TIN = (DRPItem) new DRPItem("ore_chunk_tin", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(ORE_CHUNK_COPPER = (DRPItem) new DRPItem("ore_chunk_copper", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(ORE_CHUNK_SULFUR = (DRPItem) new DRPItem("ore_chunk_sulfur", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(ORE_CHUNK_SALPETER = (DRPItem) new DRPItem("ore_chunk_salpeter", "misc", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(FIREWOOD = (DRPItem) new DRPItem("firewood", "firewood", 64, "oak", "birch", "spruce", "jungle", "acacia", "dark_oak").setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(PLANKS = (DRPItem) new DRPItem("planks", "planks", 64, "oak", "spruce", "birch", "jungle", "dark_oak", "acacia").setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(CLEAN_PAINTBRUSH = (DRPItem) new DRPItem("clean_paintbrush", "paintbrushes", 1).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));
		reg.register(BLACK_PAINTBRUSH = (DRPItem) new DRPItem("black_paintbrush", "paintbrushes", 1).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));
		
		reg.register(BRONZE_COIN = (DRPItem) new DRPItem("coin_bronze", "misc/currency", 50).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(SILVER_COIN = (DRPItem) new DRPItem("coin_silver", "misc/currency", 50).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(GOLDEN_COIN = (DRPItem) new DRPItem("coin_golden", "misc/currency", 50).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));

		
		reg.register(HANGING_BRIDGE = (HangingBridge_Item) new HangingBridge_Item("hanging_bridge", "blocks", 64).setCreativeTab(DRPMedievalCreativeTabs.DECORATION));
		
		reg.register((GOLDEN_TELESCOPE = new Telescope("golden_telescope", "equipment/telescope")).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));
		reg.register((SILVER_TELESCOPE = new Telescope("silver_telescope", "equipment/telescope")).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));
		
		reg.register(HALBERD = (PoleWeapon) new PoleWeapon("halberd", "equipment/weapons/pole_weapons", 20).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));

		reg.register((LUTE = new Instrument("lute", "equipment/instruments", DRPMedievalSounds.GUITAR)).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));
		reg.register(QUIVER = (DRPEquip) new DRPEquip("quiver", "quivers", DRPEquip.TYPE.TYPE_AMMO_STORAGE).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));

		reg.register(LEATHER_PURSE = (DRPEquip) new DRPEquip("leather_purse", "purses", DRPEquip.TYPE.TYPE_MONEY_STORAGE).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));
		reg.register(BRONZE_RING = (DRPEquip) new DRPEquip("ring_bronze", "rings", DRPEquip.TYPE.TYPE_RING).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));
		reg.register(SILVER_RING = (DRPEquip) new DRPEquip("ring_silver", "rings", DRPEquip.TYPE.TYPE_RING).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));
		reg.register(GOLDEN_RING = (DRPEquip) new DRPEquip("ring_golden", "rings", DRPEquip.TYPE.TYPE_RING).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab));
		
		reg.register(BARK_AND_GLUE  = (BarkAndGlue) new BarkAndGlue("bark_and_glue", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));

		reg.register(CHICKEN_STEW = new DRPMStew(8, 0.5F, "chicken_stew"));
		reg.register(COD_STEW = new DRPMStew(7, 0.5F, "cod_stew"));
		reg.register(VEGIE_STEW = new DRPMStew(6, 0.3F, "vegie_stew"));
		reg.register(PUMPKIN_STEW = new DRPMStew(6, 0.3F, "pumpkin_stew"));
		reg.register(DOUGH = (DRPItem) new DRPItem("dough", "misc/dough", 64, "wheat", "barley").setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(FLOUR = (DRPItem) new DRPItem("flour", "misc/flour", 64, "wheat", "barley").setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(DOUGH_PUMPKIN = (DRPItem) new DRPItem("pumpkin_dough", "misc/dough", 64, "wheat", "barley").setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		
		reg.register(LEATHER_BOOK_COVER = (DRPItem) new DRPItem("leather_book_cover", "misc/books", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(LEATHER_BOOK_COVER_THIK = (DRPItem) new DRPItem("leather_book_cover_thik", "misc/books", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		reg.register(LEATHER_BOOK_COVER_THIN = (DRPItem) new DRPItem("leather_book_cover_thin", "misc/books", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab));
		
		DRPMedievalItems.SeedBarley = new SeedBarley();
		reg.register(DRPMedievalItems.ROPED_ARROW);
		reg.register(DRPMedievalItems.SLEDGE);
	
		for(ItemBlock block : blockItems){
			reg.register(block);
		}
		
		DRPMedievalBlocks.TIN_ORE.setOre(DRPMedievalItems.ORE_CHUNK_TIN);
		DRPMedievalBlocks.COPPER_ORE.setOre(DRPMedievalItems.ORE_CHUNK_COPPER);
		DRPMedievalBlocks.SILVER_ORE.setOre(DRPMedievalItems.ORE_CHUNK_SILVER);
		DRPMedievalBlocks.SULFUR_ORE.setOre(DRPMedievalItems.ORE_CHUNK_SULFUR);
		DRPMedievalBlocks.SALPETER_ORE.setOre(DRPMedievalItems.ORE_CHUNK_SALPETER);
		
		
		DRPMedievalBlocks.TORCH_HOLDER_UNLIT.init(DRPMedievalBlocks.TORCH_HOLDER_LIT);
		DRPMedievalBlocks.TORCH_HOLDER_LIT.init(DRPMedievalBlocks.TORCH_HOLDER_UNLIT);
		DRPMedievalBlocks.TORCH_HOLDER_EMPTY.init(DRPMedievalBlocks.TORCH_HOLDER_UNLIT, Item.getItemFromBlock(Blocks.TORCH));
		
		DRPMedievalBlocks.CANDLE_HOLDER_UNLIT.init(DRPMedievalBlocks.CANDLE_HOLDER_LIT);
		DRPMedievalBlocks.CANDLE_HOLDER_LIT.init(DRPMedievalBlocks.CANDLE_HOLDER_UNLIT);
		DRPMedievalBlocks.CANDLE_HOLDER_EMPTY.init(DRPMedievalBlocks.CANDLE_HOLDER_UNLIT, Item.getItemFromBlock(DRPMedievalBlocks.BEESWAX_CANDLE));
	}
}
