package net.drpmedieval.common.items;

import net.drpmedieval.common.items.*;
import net.drpmedieval.common.items.crops.Barley;
import net.drpmedieval.common.items.crops.Turnip;
import net.drpmedieval.common.items.currency.BronzeCoin;
import net.drpmedieval.common.items.currency.GoldenCoin;
import net.drpmedieval.common.items.currency.SilverCoin;
import net.drpmedieval.common.items.equipment.ammunition.Quiver;
import net.drpmedieval.common.items.equipment.purses.LeatherPurse;
import net.drpmedieval.common.items.equipment.rings.BronzeRing;
import net.drpmedieval.common.items.equipment.rings.GoldenRing;
import net.drpmedieval.common.items.equipment.rings.SilverRing;
import net.drpmedieval.common.items.food.AppleGreen;
import net.drpmedieval.common.items.food.AppleYellow;
import net.drpmedieval.common.items.food.CatfishCooked;
import net.drpmedieval.common.items.food.CatfishRaw;
import net.drpmedieval.common.items.food.ChickenStew;
import net.drpmedieval.common.items.food.CodStew;
import net.drpmedieval.common.items.food.PearGreen;
import net.drpmedieval.common.items.food.PearYellow;
import net.drpmedieval.common.items.food.PumpkinBread;
import net.drpmedieval.common.items.food.PumpkinStew;
import net.drpmedieval.common.items.food.VegieStew;
import net.drpmedieval.common.items.food.WolfMeatCooked;
import net.drpmedieval.common.items.food.WolfMeatRaw;
import net.drpmedieval.common.items.misc.BatEar;
import net.drpmedieval.common.items.misc.DoughBarley;
import net.drpmedieval.common.items.misc.DoughWheat;
import net.drpmedieval.common.items.misc.Firewood;
import net.drpmedieval.common.items.misc.FlourBarley;
import net.drpmedieval.common.items.misc.FlourWheat;
import net.drpmedieval.common.items.misc.FurWolf;
import net.drpmedieval.common.items.misc.TriggerTrap;
import net.drpmedieval.common.items.seeds.SeedBarley;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DRPMedievalItems {

	/**A**/
	
	public static AppleGreen itemAppleGreen = new AppleGreen();
	public static AppleYellow itemAppleYellow = new AppleYellow();
	
	/**B**/

	public static Barley itemBarley = new Barley();
	public static BatEar itemBatEar = new BatEar();
	public static BronzeCoin itemBronzeCoin = new BronzeCoin();
	public static BronzeRing itemBronzeRing = new BronzeRing();
	
	/**C**/
	
	public static CatfishCooked itemCatfishCooked = new CatfishCooked();
	public static CatfishRaw itemCatfishRaw = new CatfishRaw();
	public static ChickenStew itemChickenStew = new ChickenStew();
	public static CodStew itemCodStew = new CodStew();
	
	/**D**/
	
	public static DoughBarley itemDoughBarley = new DoughBarley();
	public static DoughWheat itemDoughWheat = new DoughWheat();
	
	/**E**/
	
	/**F**/
	
	public static Firewood itemFirewood = new Firewood();
	public static FlourBarley itemFlourBarley = new FlourBarley();
	public static FlourWheat itemFlourWheat = new FlourWheat();
	public static FurWolf itemFurWolf = new FurWolf();
	
	/**G**/
	
	public static GoldenCoin itemGoldenCoin = new GoldenCoin();
	public static GoldenRing itemGoldenRing = new GoldenRing();
	
	/**H**/
	
	/**I**/
	
	/**J**/
	
	/**K**/
	
	/**L**/
	
	public static LeatherPurse itemLeatherPurse = new LeatherPurse();
	
	/**M**/
	
	/**N**/
	
	/**O**/
	
	/**P**/
	
	public static PearGreen itemPearGreen = new PearGreen();
	public static PearYellow itemPearYellow = new PearYellow();
	public static PumpkinBread itemPumpkinBread = new PumpkinBread();
	public static PumpkinStew itemPumpkinStew = new PumpkinStew();
	
	/**Q**/
	
	public static Quiver itemQuiver = new Quiver();
	
	/**R**/
	
	/**S**/
	
	public static SeedBarley itemSeedBarley = new SeedBarley();
	public static SilverCoin itemSilverCoin = new SilverCoin();
	public static SilverRing itemSilverRing = new SilverRing();
	
	/**T**/
	
	public static TriggerTrap itemTriggerTrap = new TriggerTrap();
	public static Turnip itemTurnip = new Turnip();
	
	/**U**/
	
	/**V**/
	
	public static VegieStew itemVegieStew = new VegieStew();
	
	/**W**/
	
	public static WolfMeatCooked itemWolfMeatCooked = new WolfMeatCooked();
	public static WolfMeatRaw itemWolfMeatRaw = new WolfMeatRaw();
	
	/**X**/
	
	/**Y**/
	
	/**Z**/

	public static final void itemPreInit(FMLPreInitializationEvent event){
		//A
			registerItem(itemAppleGreen);
			registerItem(itemAppleYellow);
		//B
			registerItem(itemBarley);
			registerItem(itemBatEar);
			registerItem(itemBronzeCoin);
			registerItem(itemBronzeRing);
		//C
			registerItem(itemCatfishCooked);
			registerItem(itemCatfishRaw);
			registerItem(itemChickenStew);
			registerItem(itemCodStew);
		//D
			registerItem(itemDoughBarley);
			registerItem(itemDoughWheat);
		//E
		//F
			registerItem(itemFirewood);
			registerItem(itemFlourBarley);
			registerItem(itemFlourWheat);
			registerItem(itemFurWolf);
		//G
			registerItem(itemGoldenCoin);
			registerItem(itemGoldenRing);
		//H
		//I
		//J
		//K
		//L
			registerItem(itemLeatherPurse);
		//M
		//N
		//O
		//P
			registerItem(itemPearGreen);
			registerItem(itemPearYellow);
			registerItem(itemPumpkinBread);
			registerItem(itemPumpkinStew);
		//Q
			registerItem(itemQuiver);
		//R
		//S
			registerItem(itemSeedBarley);
			registerItem(itemSilverCoin);
			registerItem(itemSilverRing);
		//T
			registerItem(itemTriggerTrap);
			registerItem(itemTurnip);
		//V
			registerItem(itemVegieStew);
		//W
			registerItem(itemWolfMeatCooked);
			registerItem(itemWolfMeatRaw);
		//X
		//Y
		//Z
	}
	
	public static final void itemInit(FMLInitializationEvent event){}

	public static final void itemPostInit(FMLPostInitializationEvent event){}
	
	public static final void registerItem(Item item){
		GameRegistry.registerItem(item, (item.getUnlocalizedName().split("[.]"))[1]);
	}
}
