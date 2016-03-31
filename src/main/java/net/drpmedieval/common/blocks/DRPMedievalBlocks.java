package net.drpmedieval.common.blocks;

import net.drpmedieval.common.blocks.*;
import net.drpmedieval.common.blocks.craftingstations.Anvil;
import net.drpmedieval.common.blocks.craftingstations.Cauldron;
import net.drpmedieval.common.blocks.craftingstations.ChoppingBlock;
import net.drpmedieval.common.blocks.craftingstations.Firepit;
import net.drpmedieval.common.blocks.craftingstations.Grindstone;
import net.drpmedieval.common.blocks.craftingstations.HangingCauldron;
import net.drpmedieval.common.blocks.craftingstations.Mortar;
import net.drpmedieval.common.blocks.decorative.BarrelClosed;
import net.drpmedieval.common.blocks.decorative.BarrelEmpty;
import net.drpmedieval.common.blocks.decorative.BarrelGunpowder;
import net.drpmedieval.common.blocks.decorative.BookOne;
import net.drpmedieval.common.blocks.decorative.BucketDirt;
import net.drpmedieval.common.blocks.decorative.BucketEmpty;
import net.drpmedieval.common.blocks.decorative.BucketWater;
import net.drpmedieval.common.blocks.decorative.Chain;
import net.drpmedieval.common.blocks.decorative.HangingBridge;
import net.drpmedieval.common.blocks.decorative.Hook;
import net.drpmedieval.common.blocks.decorative.KeyHanging;
import net.drpmedieval.common.blocks.decorative.MugBeer;
import net.drpmedieval.common.blocks.decorative.MugEmpty;
import net.drpmedieval.common.blocks.decorative.PotionEmpty;
import net.drpmedieval.common.blocks.decorative.Rope;
import net.drpmedieval.common.blocks.decorative.RopeAnchor;
import net.drpmedieval.common.blocks.decorative.ShipsWheel;
import net.drpmedieval.common.blocks.decorative.Target;
import net.drpmedieval.common.blocks.decorative.TorchHolderEmpty;
import net.drpmedieval.common.blocks.decorative.TorchHolderLit;
import net.drpmedieval.common.blocks.decorative.TorchHolderUnlit;
import net.drpmedieval.common.blocks.plants.AppleGreen;
import net.drpmedieval.common.blocks.plants.AppleRed;
import net.drpmedieval.common.blocks.plants.AppleYellow;
import net.drpmedieval.common.blocks.plants.Barley;
import net.drpmedieval.common.blocks.plants.MushroomBrown;
import net.drpmedieval.common.blocks.plants.MushroomRed;
import net.drpmedieval.common.blocks.plants.PearGreen;
import net.drpmedieval.common.blocks.plants.PearYellow;
import net.drpmedieval.common.blocks.storage.Crate;
import net.drpmedieval.common.blocks.storage.DungeonChest;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DRPMedievalBlocks {

	/**A**/
	
	public static Anvil anvil = new Anvil();
	public static AppleGreen appleGreen = new AppleGreen();
	public static AppleRed appleRed = new AppleRed();
	public static AppleYellow appleYellow = new AppleYellow();
	
	/**B**/
	
	public static Barley barley = new Barley();
	public static BarrelClosed barrelClosed = new BarrelClosed();
	public static BarrelEmpty barrelEmpty = new BarrelEmpty();
	public static BarrelGunpowder barrelGunpowder = new BarrelGunpowder();
	public static BookOne bookOne = new BookOne();
	public static BucketDirt bucketDirt = new BucketDirt();
	public static BucketEmpty bucketEmpty = new BucketEmpty();
	public static BucketWater bucketWater = new BucketWater();
	
	/**C**/
	
	public static Cauldron cauldron = new Cauldron();
	public static Chain chain = new Chain();
	public static ChoppingBlock choppingBlock = new ChoppingBlock();
	public static Crate crate = new Crate();
	
	/**D**/
	
	public static DungeonChest dungeonChest = new DungeonChest();
	
	/**E**/
	
	/**F**/
	
	public static Firepit firepit = new Firepit();
	
	/**G**/
	
	public static Grindstone grindstone = new Grindstone();
	
	/**H**/
	
	public static HangingBridge hangingBridge = new HangingBridge();
	public static HangingCauldron hangingCauldron = new HangingCauldron();
	public static Hook hook = new Hook();
	
	/**I**/
	
	/**J**/
	
	/**K**/
	
	public static KeyHanging keyHanging = new KeyHanging();
	
	/**L**/
	
	/**M**/
	
	public static Mortar mortar = new Mortar();
	public static MugBeer mugBeer = new MugBeer();
	public static MugEmpty mugEmpty = new MugEmpty();
	public static MushroomBrown mushroomBrown = new MushroomBrown();
	public static MushroomRed mushroomRed = new MushroomRed();
	
	/**N**/
	
	/**O**/
	
	/**P**/
	
	public static PearGreen pearGreen = new PearGreen();
	public static PearYellow pearYellow = new PearYellow();
	public static PotionEmpty potionEmpty = new PotionEmpty();
	
	/**Q**/
	
	/**R**/
	
	public static Rope rope = new Rope();
	public static RopeAnchor ropeAnchor = new RopeAnchor();
	
	/**S**/
	
	public static ShipsWheel shipsWheel = new ShipsWheel();
	
	/**T**/
	
	public static Target target = new Target();
	public static TorchHolderEmpty torchHolderEmpty = new TorchHolderEmpty();
	public static TorchHolderLit torchHolderLit = new TorchHolderLit();
	public static TorchHolderUnlit torchHolderUnlit = new TorchHolderUnlit();
	
	/**U**/
	
	/**V**/
	
	/**W**/
	
	/**X**/
	
	/**Y**/
	
	/**Z**/
	
	public static void blockPreInit(FMLPreInitializationEvent event){
		registerBlock(barrelEmpty);
		registerBlock(barrelClosed);
		registerBlock(barrelGunpowder);
		registerBlock(choppingBlock);
		registerBlock(appleRed);
		registerBlock(appleYellow);
		registerBlock(appleGreen);
		registerBlock(pearYellow);
		registerBlock(pearGreen);
		registerBlock(mushroomBrown);
		registerBlock(mushroomRed);
		registerBlock(bucketEmpty);
		registerBlock(bucketDirt);
		registerBlock(bucketWater);
		registerBlock(mugEmpty);
		registerBlock(mugBeer);
		registerBlock(mortar);
		registerBlock(grindstone);
		registerBlock(anvil);
		registerBlock(cauldron);
		registerBlock(hangingCauldron);
		registerBlock(hangingBridge);
		registerBlock(bookOne);
		registerBlock(rope);
		registerBlock(ropeAnchor);
		registerBlock(chain);
		registerBlock(crate);
		registerBlock(dungeonChest);
		registerBlock(hook);
		registerBlock(keyHanging);
		registerBlock(shipsWheel);
		registerBlock(target);
		registerBlock(torchHolderEmpty);
		registerBlock(torchHolderUnlit);
		registerBlock(torchHolderLit);
		registerBlock(firepit);
		registerBlock(barley);
	}
	
	public static final void blockInit(FMLInitializationEvent event){}

	public static final void blockPostInit(FMLPostInitializationEvent event){}
	
	public static final void registerBlock(Block block){
		GameRegistry.registerBlock(block,(block.getUnlocalizedName().split("[.]"))[1]);
	}
	
}
