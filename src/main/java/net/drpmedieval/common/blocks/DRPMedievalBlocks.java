package net.drpmedieval.common.blocks;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.blocks.craftingstations.*;
import net.drpmedieval.common.blocks.decorative.*;
import net.drpmedieval.common.blocks.plants.*;
import net.drpmedieval.common.blocks.storage.*;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DRPMedievalBlocks {

	/*
	 @Override
	 public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
     {
         return new AxisAlignedBB(,,,,,);
     }
	 */
	
	/** A **/

	public static Anvil anvil = new Anvil();
	public static Apiary apiary = new Apiary();
	public static AppleGreen appleGreen = new AppleGreen();
	public static AppleRed appleRed = new AppleRed();
	public static AppleYellow appleYellow = new AppleYellow();

	/** B **/

	public static Barley barley = new Barley();
	public static BarrelChair barrelChair = new BarrelChair();
	public static BarrelClosed barrelClosed = new BarrelClosed();
	public static BarrelEmpty barrelEmpty = new BarrelEmpty();
	public static BarrelFilled barrelGunpowder = new BarrelFilled("BarrelGunpowder","BarrelGunpowder");
		
	public static BedFrame bedFrameOak = new BedFrame("BedFrameOak","BedFrameOak",DRPMedievalItems.BedFrameOak);
	public static BedFrame bedFrameSpruce = new BedFrame("BedFrameSpruce","BedFrameSpruce",DRPMedievalItems.BedFrameSpruce);
	public static BedFrame bedFrameBirch = new BedFrame("BedFrameBirch","BedFrameBirch",DRPMedievalItems.BedFrameBirch);
	public static BedFrame bedFrameJungle = new BedFrame("BedFrameJungle","BedFrameJungle",DRPMedievalItems.BedFrameJungle);
	public static BedFrame bedFrameAcacia = new BedFrame("BedFrameAcacia","BedFrameAcacia",DRPMedievalItems.BedFrameAcacia);
	public static BedFrame bedFrameDarkOak = new BedFrame("BedFrameDarkOak","BedFrameDarkOak",DRPMedievalItems.BedFrameDarkOak);

	public static BookOne bookOne = new BookOne();
	public static BucketDirt bucketDirt = new BucketDirt();
	public static Bucket bucketEmpty = new Bucket("BucketEmpty", "BucketEmpty");
	public static Bucket bucketWater = new Bucket("BucketWater", "BucketWater");

	/** C **/

	public static Cauldron cauldron = new Cauldron();
	public static Chain chain = new Chain();
	public static ChoppingBlock choppingBlock = new ChoppingBlock();
	public static CleanPlanks cleanPlanks = new CleanPlanks();
	public static Crate crate = new Crate();

	/** D **/

	public static DungeonChest dungeonChest = new DungeonChest();

	/** E **/

	/** F **/

	public static Firepit firepit = new Firepit();

	/** G **/

	public static Grindstone grindstone = new Grindstone();

	/** H **/

	public static HangingBridge hangingBridge = new HangingBridge();
	public static HangingCauldron hangingCauldron = new HangingCauldron();

	/** I **/
	public static Hook ironHook = new Hook();
	
	/** J **/

	/** K **/

	public static KeyHanging keyHanging = new KeyHanging();

	/** L **/

	public static LogChair logChairOak = new LogChair("LogChairOak","LogChairOak");
	public static LogChair logChairSpruce = new LogChair("LogChairSpruce","LogChairSpruce");
	public static LogChair logChairBirch = new LogChair("LogChairBirch","LogChairBirch");
	public static LogChair logChairJungle = new LogChair("LogChairJungle","LogChairJungle");
	public static LogChair logChairAcacia = new LogChair("LogChairAcacia","LogChairAcacia");
	public static LogChair logChairDarkOak = new LogChair("LogChairDarkOak","LogChairDarkOak");

	
	/** M **/

	public static Mortar mortar = new Mortar();
	public static MugBeer mugBeer = new MugBeer();
	public static MugEmpty mugEmpty = new MugEmpty();
	public static MushroomBrown mushroomBrown = new MushroomBrown();
	public static MushroomRed mushroomRed = new MushroomRed();

	/** N **/

	/** O **/

	/** P **/

	public static PearGreen pearGreen = new PearGreen();
	public static PearYellow pearYellow = new PearYellow();
	public static PotionEmpty potionEmpty = new PotionEmpty();

	/** Q **/

	/** R **/

	public static Rope rope = new Rope();
	public static RopeAnchor ropeAnchor = new RopeAnchor();

	/** S **/

	public static ShipsWheel shipsWheel = new ShipsWheel();

	/** T **/

	public static Target target = new Target();
	public static TorchHolderEmpty torchHolderEmpty = new TorchHolderEmpty();
	public static TorchHolderLit torchHolderLit = new TorchHolderLit();
	public static TorchHolderUnlit torchHolderUnlit = new TorchHolderUnlit();

	/** U **/

	/** V **/

	/** W **/

	/** X **/

	/** Y **/

	/** Z **/

	public static void preInit(FMLPreInitializationEvent event) {

		registerBlock(barrelEmpty);
		registerBlock(barrelClosed);
		registerBlock(barrelGunpowder);
		
		registerBlock(bedFrameOak, null);
		registerBlock(bedFrameSpruce, null);
		registerBlock(bedFrameBirch, null);
		registerBlock(bedFrameJungle, null);
		registerBlock(bedFrameAcacia, null);
		registerBlock(bedFrameDarkOak, null);
		
		registerBlock(apiary);
		registerBlock(barrelChair);
		
		registerBlock(logChairOak);
		registerBlock(logChairSpruce);
		registerBlock(logChairBirch);
		registerBlock(logChairJungle);
		registerBlock(logChairAcacia);
		registerBlock(logChairDarkOak);
		
		registerBlock(cleanPlanks, null);
		
		registerBlock(choppingBlock);
		registerBlock(appleRed, null);
		registerBlock(appleYellow, null);
		registerBlock(appleGreen, null);
		registerBlock(pearYellow, null);
		registerBlock(pearGreen, null);
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
		registerBlock(ironHook);
		registerBlock(keyHanging);
		registerBlock(shipsWheel);
		registerBlock(target);
		registerBlock(torchHolderEmpty);
		registerBlock(torchHolderUnlit);
		registerBlock(torchHolderLit);
		registerBlock(firepit);
		registerBlock(barley, null);
		
	}

	public static final void init(FMLInitializationEvent event) {}

	public static final void postInit(FMLPostInitializationEvent event) {}

	public static final void registerBlockOld(Block block) {

		GameRegistry.registerBlock(block, (block.getUnlocalizedName().split("[.]"))[1]);
	}
	
	public static final void registerBlock(Block block) {
		registerBlock(block,new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	public static final void registerBlock(Block block, Item item) {
		GameRegistry.register(block);
		if(item != null){
			GameRegistry.register(item);
			DarkRoleplayMedieval.proxy.addItemToRegisterMesh(item);
		}
	}
	
}
