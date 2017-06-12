package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.drpcore.api.items.DRPFood;
import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.items.blocks.AdvancedBedItem;
import net.dark_roleplay.medieval.common.items.blocks.HangingBridge_Item;
import net.dark_roleplay.medieval.common.items.book.WriteablePage;
import net.dark_roleplay.medieval.common.items.consumable.BarkAndGlue;
import net.dark_roleplay.medieval.common.items.consumable.RopedArrow;
import net.dark_roleplay.medieval.common.items.crops.Barley;
import net.dark_roleplay.medieval.common.items.crops.Hops;
import net.dark_roleplay.medieval.common.items.crops.Turnip;
import net.dark_roleplay.medieval.common.items.currency.BronzeCoin;
import net.dark_roleplay.medieval.common.items.currency.GoldenCoin;
import net.dark_roleplay.medieval.common.items.currency.SilverCoin;
import net.dark_roleplay.medieval.common.items.entities.Sledge;
import net.dark_roleplay.medieval.common.items.equipment.ammunition.Quiver;
import net.dark_roleplay.medieval.common.items.equipment.other.HorseBag;
import net.dark_roleplay.medieval.common.items.equipment.other.SaddleHorse;
import net.dark_roleplay.medieval.common.items.equipment.other.Telescope;
import net.dark_roleplay.medieval.common.items.equipment.purses.LeatherPurse;
import net.dark_roleplay.medieval.common.items.equipment.rings.BronzeRing;
import net.dark_roleplay.medieval.common.items.equipment.rings.GoldenRing;
import net.dark_roleplay.medieval.common.items.equipment.rings.SilverRing;
import net.dark_roleplay.medieval.common.items.food.AppleGreen;
import net.dark_roleplay.medieval.common.items.food.AppleYellow;
import net.dark_roleplay.medieval.common.items.food.CatfishCooked;
import net.dark_roleplay.medieval.common.items.food.CatfishRaw;
import net.dark_roleplay.medieval.common.items.food.ChickenStew;
import net.dark_roleplay.medieval.common.items.food.CodStew;
import net.dark_roleplay.medieval.common.items.food.PearGreen;
import net.dark_roleplay.medieval.common.items.food.PearYellow;
import net.dark_roleplay.medieval.common.items.food.PumpkinBread;
import net.dark_roleplay.medieval.common.items.food.PumpkinStew;
import net.dark_roleplay.medieval.common.items.food.VegieStew;
import net.dark_roleplay.medieval.common.items.food.WolfMeatCooked;
import net.dark_roleplay.medieval.common.items.food.WolfMeatRaw;
import net.dark_roleplay.medieval.common.items.misc.BatEar;
import net.dark_roleplay.medieval.common.items.misc.DRPMMiscItem;
import net.dark_roleplay.medieval.common.items.misc.DoughBarley;
import net.dark_roleplay.medieval.common.items.misc.DoughPumpkin;
import net.dark_roleplay.medieval.common.items.misc.DoughWheat;
import net.dark_roleplay.medieval.common.items.misc.Firewood;
import net.dark_roleplay.medieval.common.items.misc.FlourBarley;
import net.dark_roleplay.medieval.common.items.misc.FlourWheat;
import net.dark_roleplay.medieval.common.items.misc.FurWolf;
import net.dark_roleplay.medieval.common.items.misc.LeatherBookCover;
import net.dark_roleplay.medieval.common.items.misc.LeatherBookCoverThik;
import net.dark_roleplay.medieval.common.items.misc.LeatherBookCoverThin;
import net.dark_roleplay.medieval.common.items.misc.LeatherString;
import net.dark_roleplay.medieval.common.items.misc.Plank;
import net.dark_roleplay.medieval.common.items.misc.StringCoil;
import net.dark_roleplay.medieval.common.items.misc.TannedLeather;
import net.dark_roleplay.medieval.common.items.misc.TannedLeatherString;
import net.dark_roleplay.medieval.common.items.misc.Tap;
import net.dark_roleplay.medieval.common.items.misc.TriggerTrap;
import net.dark_roleplay.medieval.common.items.seeds.SeedBarley;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DRPMedievalItems {

	/** In Dev Items **/
	
	public static WriteablePage wpg = new WriteablePage();
	
	/** A **/

	public static AppleGreen AppleGreen = new AppleGreen();
	public static AppleYellow AppleYellow = new AppleYellow();

	/** B **/

	public static BarkAndGlue BarkAndGlue = new BarkAndGlue();
	public static AdvancedBedItem BedFrameOak = new AdvancedBedItem("BedFrameOak", "BedFrameOak");
	public static AdvancedBedItem BedFrameSpruce = new AdvancedBedItem("BedFrameSpruce", "BedFrameSpruce");
	public static AdvancedBedItem BedFrameBirch = new AdvancedBedItem("BedFrameBirch", "BedFrameBirch");
	public static AdvancedBedItem BedFrameJungle = new AdvancedBedItem("BedFrameJungle", "BedFrameJungle");
	public static AdvancedBedItem BedFrameAcacia = new AdvancedBedItem("BedFrameAcacia", "BedFrameAcacia");
	public static AdvancedBedItem BedFrameDarkOak = new AdvancedBedItem("BedFrameDarkOak", "BedFrameDarkOak");

	public static Barley BARLEY;
	public static BatEar BatEar = new BatEar();
	public static BronzeCoin BronzeCoin = new BronzeCoin();
	public static BronzeRing BronzeRing = new BronzeRing();

	/** C **/

	public static CatfishCooked CatfishCooked = new CatfishCooked();
	public static CatfishRaw CatfishRaw = new CatfishRaw();
	public static ChickenStew ChickenStew = new ChickenStew();
	public static CodStew CodStew = new CodStew();

	/** D **/

	public static DoughBarley DoughBarley = new DoughBarley();
	public static DoughPumpkin DoughPumpkin = new DoughPumpkin();
	public static DoughWheat DoughWheat = new DoughWheat();

	/** E **/

	/** F **/

	public static Firewood Firewood = new Firewood();
	public static FlourBarley FlourBarley = new FlourBarley();
	public static FlourWheat FlourWheat = new FlourWheat();
	public static FurWolf FurWolf = new FurWolf();

	/** G **/

	public static GoldenCoin GoldenCoin = new GoldenCoin();
	public static GoldenRing GoldenRing = new GoldenRing();

	/** H **/

	public static HangingBridge_Item HANGING_BRIDGE = new HangingBridge_Item("hanging_bridge");
	public static HorseBag HorseBag = new HorseBag();

	/** I **/

	/** J **/

	/** K **/

	/** L **/

	public static LeatherBookCover LeatherBookCover = new LeatherBookCover();
	public static LeatherBookCoverThik LeatherBookCoverThik = new LeatherBookCoverThik();
	public static LeatherBookCoverThin LeatherBookCoverThin = new LeatherBookCoverThin();
	public static LeatherPurse LeatherPurse = new LeatherPurse();
	public static LeatherString LeatherString = new LeatherString();

	/** M **/

	/** N **/

	/** O **/

	/** P **/

	public static PearGreen PearGreen = new PearGreen();
	public static PearYellow PearYellow = new PearYellow();
	public static Plank Plank = new Plank();
	public static PumpkinBread PumpkinBread = new PumpkinBread();
	public static PumpkinStew PumpkinStew = new PumpkinStew();

	
	/** Q **/

	public static Quiver Quiver = new Quiver();

	/** R **/
	
	public static RopedArrow ROPED_ARROW = new RopedArrow();

	/** S **/

	public static SaddleHorse SaddleHorse = new SaddleHorse();
	public static SeedBarley SeedBarley;
	public static SilverCoin SilverCoin = new SilverCoin();
	public static SilverRing SilverRing = new SilverRing();
	public static StringCoil StringCoil = new StringCoil();
	public static Sledge SLEDGE = new Sledge();

	/** T **/

	public static Tap TAP = new Tap("tap");
	public static TannedLeather TannedLeather = new TannedLeather();
	public static TannedLeatherString TannedLeatherString = new TannedLeatherString();
	public static Telescope TELESCOPE = new Telescope("golden_telescope", "telescope");
	public static TriggerTrap TriggerTrap = new TriggerTrap();
	public static Turnip Turnip = new Turnip();

	/** U **/

	/** V **/

	public static VegieStew VegieStew = new VegieStew();

	/** W **/

	public static WolfMeatCooked WolfMeatCooked = new WolfMeatCooked();
	public static WolfMeatRaw WolfMeatRaw = new WolfMeatRaw();

	/** X **/

	/** Y **/

	/** Z **/

	
	public static Hops HOPS = new Hops("hops");
	public static DRPMMiscItem CHARCOAL_POWDER = new DRPMMiscItem("charcoal_powder");
	public static DRPMMiscItem SILVER_ORE_CHUNK = new DRPMMiscItem("silver_ore_chunk");
	public static DRPMMiscItem TIN_ORE_CHUNK;
	public static DRPMMiscItem COPPER_ORE_CHUNK = new DRPMMiscItem("copper_ore_chunk");
	public static DRPMMiscItem SULFUR_ORE_CHUNK = new DRPMMiscItem("sulfur_ore_chunk");
	public static DRPMMiscItem SALPETER_ORE_CHUNK = new DRPMMiscItem("salpeter_ore_chunk");

	

	public static DRPFood BLUE_BERRY;
	public static DRPFood GRAPE;
	public static DRPFood GARLIC;
	public static DRPFood ONION;
	public static DRPFood CAULIFLOWER;
	
	public static final void init(FMLPreInitializationEvent event) {

		DRPMedievalItems.BedFrameOak.setBed(DRPMedievalBlocks.BED_FRAME_OAK);
		DRPMedievalItems.BedFrameSpruce.setBed(DRPMedievalBlocks.BED_FRAME_SPRUCE);
		DRPMedievalItems.BedFrameBirch.setBed(DRPMedievalBlocks.BED_FRAME_BIRCH);
		DRPMedievalItems.BedFrameJungle.setBed(DRPMedievalBlocks.BED_FRAME_JUNGLE);
		DRPMedievalItems.BedFrameAcacia.setBed(DRPMedievalBlocks.BED_FRAME_ACACIA);
		DRPMedievalItems.BedFrameDarkOak.setBed(DRPMedievalBlocks.BED_FRAME_DARK_OAK);
		
		DRPMedievalItems.SeedBarley = new SeedBarley();
		
		// Under Development Items
		//register(wpg, false); //TODO CHANGE BOOL AND FIX
		
		DRPMedievalItems.register(DRPMedievalItems.BLUE_BERRY = (DRPFood) new DRPFood(1, 0.1F, "blue_berrys", "fruits", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab), false);
		DRPMedievalItems.register(DRPMedievalItems.GRAPE = (DRPFood) new DRPFood(2, 0.2F,"grapes", "fruits", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab), false);
		DRPMedievalItems.register(DRPMedievalItems.GARLIC = (DRPFood) new DRPFood(2, 0.4F,"garlic", "vegetables", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab), false);
		DRPMedievalItems.register(DRPMedievalItems.ONION = (DRPFood) new DRPFood(2, 0.4F,"onion", "vegetables", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab), false);
		DRPMedievalItems.register(DRPMedievalItems.CAULIFLOWER = (DRPFood) new DRPFood(4, 0.4F,"cauliflower", "vegetables", 64).setCreativeTab(DRPMedievalCreativeTabs.drpmedievalFoodTab), false);
		
		
		DRPMedievalItems.register(DRPMedievalItems.HOPS);
		
		DRPMedievalItems.register(DRPMedievalItems.HANGING_BRIDGE);
		
		DRPMedievalItems.register(DRPMedievalItems.CHARCOAL_POWDER);
		DRPMedievalItems.register(DRPMedievalItems.SILVER_ORE_CHUNK);
		DRPMedievalItems.register(DRPMedievalItems.TIN_ORE_CHUNK = new DRPMMiscItem("tin_ore_chunk"));
		DRPMedievalItems.register(DRPMedievalItems.COPPER_ORE_CHUNK);
		DRPMedievalItems.register(DRPMedievalItems.SULFUR_ORE_CHUNK);
		DRPMedievalItems.register(DRPMedievalItems.SALPETER_ORE_CHUNK);
		
		// A
		DRPMedievalItems.register(DRPMedievalItems.AppleGreen);
		DRPMedievalItems.register(DRPMedievalItems.AppleYellow);
		// B
		DRPMedievalItems.register(DRPMedievalItems.BarkAndGlue);
		//register(bedFrameOak);
		//register(bedFrameSpruce);
		//register(bedFrameBirch);
		//register(bedFrameJungle);
		//register(bedFrameAcacia);
		//register(bedFrameDarkOak);
		
		DRPMedievalItems.register(DRPMedievalItems.BARLEY = new Barley("barley"));
		DRPMedievalItems.register(DRPMedievalItems.BatEar);
		DRPMedievalItems.register(DRPMedievalItems.BronzeCoin);
		DRPMedievalItems.register(DRPMedievalItems.BronzeRing);
		// C
		DRPMedievalItems.register(DRPMedievalItems.CatfishCooked);
		DRPMedievalItems.register(DRPMedievalItems.CatfishRaw);
		DRPMedievalItems.register(DRPMedievalItems.ChickenStew);
		DRPMedievalItems.register(DRPMedievalItems.CodStew);
		// D
		DRPMedievalItems.register(DRPMedievalItems.DoughBarley);
		DRPMedievalItems.register(DRPMedievalItems.DoughPumpkin,false);
		DRPMedievalItems.register(DRPMedievalItems.DoughWheat);
		// E
		// F
		DRPMedievalItems.register(DRPMedievalItems.Firewood);
		DRPMedievalItems.register(DRPMedievalItems.FlourBarley);
		DRPMedievalItems.register(DRPMedievalItems.FlourWheat);
		DRPMedievalItems.register(DRPMedievalItems.FurWolf);
		// G
		DRPMedievalItems.register(DRPMedievalItems.GoldenCoin);
		DRPMedievalItems.register(DRPMedievalItems.GoldenRing);
		// H
		// I
		// J
		// K
		// L
		DRPMedievalItems.register(DRPMedievalItems.LeatherBookCover);
		DRPMedievalItems.register(DRPMedievalItems.LeatherBookCoverThik);
		DRPMedievalItems.register(DRPMedievalItems.LeatherBookCoverThin);
		DRPMedievalItems.register(DRPMedievalItems.LeatherPurse);
		DRPMedievalItems.register(DRPMedievalItems.LeatherString);
		// M
		// N
		// O
		// P
		DRPMedievalItems.register(DRPMedievalItems.PearGreen);
		DRPMedievalItems.register(DRPMedievalItems.PearYellow);
		DRPMedievalItems.register(DRPMedievalItems.Plank);
		DRPMedievalItems.register(DRPMedievalItems.PumpkinBread);
		DRPMedievalItems.register(DRPMedievalItems.PumpkinStew);
		// Q
		DRPMedievalItems.register(DRPMedievalItems.Quiver);
		// R
		DRPMedievalItems.register(DRPMedievalItems.ROPED_ARROW);
		// S
		DRPMedievalItems.register(DRPMedievalItems.SilverCoin);
		DRPMedievalItems.register(DRPMedievalItems.SilverRing);
		DRPMedievalItems.register(DRPMedievalItems.SLEDGE);
		// T
		DRPMedievalItems.register(DRPMedievalItems.TELESCOPE);
		DRPMedievalItems.register(DRPMedievalItems.TAP);
		DRPMedievalItems.register(DRPMedievalItems.TannedLeather);
		DRPMedievalItems.register(DRPMedievalItems.TannedLeatherString);
		DRPMedievalItems.register(DRPMedievalItems.TriggerTrap);
		DRPMedievalItems.register(DRPMedievalItems.Turnip);
		// V
		DRPMedievalItems.register(DRPMedievalItems.VegieStew);
		// W
		DRPMedievalItems.register(DRPMedievalItems.WolfMeatCooked);
		DRPMedievalItems.register(DRPMedievalItems.WolfMeatRaw);
		// X
		// Y
		// Z

	}

	public static final void init(FMLInitializationEvent event) {}

	public static final void init(FMLPostInitializationEvent event) {}

	public static final void register(Item item){
		DRPMedievalItems.register(item,true);
	}
	
	public static final void register(Item item, boolean registerModel) {
		GameRegistry.register(item);
		if(registerModel) {
			DarkRoleplayMedieval.proxy.addItemToRegisterMesh(item);
		}
	}
}
