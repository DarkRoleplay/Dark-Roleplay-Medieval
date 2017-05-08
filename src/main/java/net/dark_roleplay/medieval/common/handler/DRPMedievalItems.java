package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.items.blocks.AdvancedBedItem;
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

	public static Barley Barley = new Barley();
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
	public static DRPMMiscItem TIN_ORE_CHUNK = new DRPMMiscItem("tin_ore_chunk");
	public static DRPMMiscItem COPPER_ORE_CHUNK = new DRPMMiscItem("copper_ore_chunk");
	public static DRPMMiscItem SULFUR_ORE_CHUNK = new DRPMMiscItem("sulfur_ore_chunk");
	public static DRPMMiscItem SALPETER_ORE_CHUNK = new DRPMMiscItem("salpeter_ore_chunk");

	
	
	public static final void preInit(FMLPreInitializationEvent event) {

		BedFrameOak.setBed(DRPMedievalBlocks.BED_FRAME_OAK);
		BedFrameSpruce.setBed(DRPMedievalBlocks.BED_FRAME_SPRUCE);
		BedFrameBirch.setBed(DRPMedievalBlocks.BED_FRAME_BIRCH);
		BedFrameJungle.setBed(DRPMedievalBlocks.BED_FRAME_JUNGLE);
		BedFrameAcacia.setBed(DRPMedievalBlocks.BED_FRAME_ACACIA);
		BedFrameDarkOak.setBed(DRPMedievalBlocks.BED_FRAME_DARK_OAK);
		
		SeedBarley = new SeedBarley();
		
		// Under Development Items
		//registerItem(wpg, false); //TODO CHANGE BOOL AND FIX
		
		registerItem(HOPS);
		
		registerItem(CHARCOAL_POWDER);
		registerItem(SILVER_ORE_CHUNK);
		registerItem(TIN_ORE_CHUNK);
		registerItem(COPPER_ORE_CHUNK);
		registerItem(SULFUR_ORE_CHUNK);
		registerItem(SALPETER_ORE_CHUNK);
		
		// A
		registerItem(AppleGreen);
		registerItem(AppleYellow);
		// B
		registerItem(BarkAndGlue);
		//registerItem(bedFrameOak);
		//registerItem(bedFrameSpruce);
		//registerItem(bedFrameBirch);
		//registerItem(bedFrameJungle);
		//registerItem(bedFrameAcacia);
		//registerItem(bedFrameDarkOak);
		
		registerItem(Barley);
		registerItem(BatEar);
		registerItem(BronzeCoin);
		registerItem((Item) BronzeRing);
		// C
		registerItem(CatfishCooked);
		registerItem(CatfishRaw);
		registerItem(ChickenStew);
		registerItem(CodStew);
		// D
		registerItem(DoughBarley);
		registerItem(DoughPumpkin,false);
		registerItem(DoughWheat);
		// E
		// F
		registerItem(Firewood);
		registerItem(FlourBarley);
		registerItem(FlourWheat);
		registerItem(FurWolf);
		// G
		registerItem(GoldenCoin);
		registerItem((Item) GoldenRing);
		// H
		// I
		// J
		// K
		// L
		registerItem(LeatherBookCover);
		registerItem(LeatherBookCoverThik);
		registerItem(LeatherBookCoverThin);
		registerItem((Item) LeatherPurse);
		registerItem(LeatherString);
		// M
		// N
		// O
		// P
		registerItem(PearGreen);
		registerItem(PearYellow);
		registerItem(Plank);
		registerItem(PumpkinBread);
		registerItem(PumpkinStew);
		// Q
		registerItem(Quiver);
		// R
		registerItem(ROPED_ARROW);
		// S
		registerItem(SilverCoin);
		registerItem(SilverRing);
		registerItem(SLEDGE);
		// T
		registerItem(TAP);
		registerItem(TannedLeather);
		registerItem(TannedLeatherString);
		registerItem(TriggerTrap);
		registerItem(Turnip);
		// V
		registerItem(VegieStew);
		// W
		registerItem(WolfMeatCooked);
		registerItem(WolfMeatRaw);
		// X
		// Y
		// Z

	}

	public static final void init(FMLInitializationEvent event) {}

	public static final void postInit(FMLPostInitializationEvent event) {}

	public static final void registerItem(Item item){
		registerItem(item,true);
	}
	
	public static final void registerItem(Item item, boolean registerModel) {
		GameRegistry.register(item);
		if(registerModel)
			DarkRoleplayMedieval.proxy.addItemToRegisterMesh(item);
	}
}
