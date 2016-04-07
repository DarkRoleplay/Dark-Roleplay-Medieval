package net.drpmedieval.common;

import java.util.Random;

import net.drpcore.main.crafting.CraftingManager;
import net.drpcore.main.crafting.CraftingRecipe;
import net.drpmedieval.client.events.OnPlayerTick;
import net.drpmedieval.common.achievements.AchievementPages;
import net.drpmedieval.common.achievements.Achievements;
import net.drpmedieval.common.blocks.DRPMedievalBlocks;
import net.drpmedieval.common.blocks.tileentitys.*;
import net.drpmedieval.common.entity.TrainingDummy;
import net.drpmedieval.common.entity.renders.RenderTrainingDummy;
import net.drpmedieval.common.events.EventHelper;
import net.drpmedieval.common.events.LivingDrop;
import net.drpmedieval.common.gui.GuiHandler;
import net.drpmedieval.common.helper.EntityCreator;
import net.drpmedieval.common.items.DRPMedievalItems;
import net.drpmedieval.common.proxy.CommonProxy;
import net.drpmedieval.common.util.UpdateCheck;
import net.drpmedieval.common.worldgen.WorldLoot;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.FishingHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = DarkRoleplayMedieval.MODID, version = DarkRoleplayMedieval.VERSION, name = DarkRoleplayMedieval.NAME, acceptedMinecraftVersions = DarkRoleplayMedieval.ACCEPTEDVERSIONS)
public class DarkRoleplayMedieval {

	public static boolean isOnServer = false;

	public static final String NAME = "Dark Roleplay Medieval";
	public static final String VERSION = "0.1.2";
	public static final String MODID = "drpmedieval";
	public static final String ACCEPTEDVERSIONS = "1.8,1.8.9";

	@SidedProxy(serverSide = "net.drpmedieval.common.proxy.CommonProxy", clientSide = "net.drpmedieval.client.ClientProxy")
	public static CommonProxy proxy;

	@net.minecraftforge.fml.common.Mod.Instance(MODID)
	public static DarkRoleplayMedieval instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		DRPMedievalBlocks.blockPreInit(event);
		DRPMedievalItems.itemPreInit(event);

		proxy.checkForUpdates();

		registerTileEntitys();
		registerEntitys();

		proxy.registerEntityRenders();

		if(event.getSide() == Side.SERVER) this.isOnServer = true;

		GameRegistry.registerFuelHandler(new DarkRoleplayFuelHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		DRPMedievalBlocks.blockInit(event);
		DRPMedievalItems.itemInit(event);

		WorldLoot.registerChestLoot();
		WorldLoot.registerFishingLoot();
		WorldLoot.registerGrassLoot();

		EventHelper.registerEvents();

		AchievementPages.Load(event);

		registerCraftingRecipes();
		registerFurnaceRecipes();

		proxy.registerRenders();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		DRPMedievalBlocks.blockPostInit(event);
		DRPMedievalItems.itemPostInit(event);
	}

	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor) {

		EntityRegistry.registerModEntity(entityClass, entityName, 0, DarkRoleplayMedieval.instance, 64, 5, false, solidColor, spotColor);
	}

	public void registerTileEntitys() {

		GameRegistry.registerTileEntity(TileEntityAnvil.class, "TileEntityAnvil");
		GameRegistry.registerTileEntity(TileEntityMortar.class, "TileEntityMortar");
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, "TileEntityGrindstone");
		GameRegistry.registerTileEntity(TileEntityHangingCauldron.class, "TileEntityHangingCauldron");
		GameRegistry.registerTileEntity(TileEntityBookOne.class, "TileEntityBookOne");
		GameRegistry.registerTileEntity(TileEntityCauldron.class, "TileEntityCauldron");
		GameRegistry.registerTileEntity(TileEntityChain.class, "TileEntityChain");
		GameRegistry.registerTileEntity(TileEntityHook.class, "TileEntityHook");
		GameRegistry.registerTileEntity(TileEntityKeyHanging.class, "TileEntityKeyHanging");
		GameRegistry.registerTileEntity(TileEntityShipsWheel.class, "TileEntityShipsWheel");
		GameRegistry.registerTileEntity(TileEntityTarget.class, "TileEntityTarget");
		GameRegistry.registerTileEntity(TileEntityRopeAnchor.class, "TileEntityRopeAnchor");
		GameRegistry.registerTileEntity(TileEntityFirepit.class, "TileEntityFirepit");

		// Storage Blocks
		GameRegistry.registerTileEntity(TileEntityCrate.class, "TilEntityCrate");
		GameRegistry.registerTileEntity(TileEntityDungeonChest.class, "TileEntityDungeonChest");
	}

	public void registerCraftingRecipes() {

		CraftingManager CM = new CraftingManager();

		/* Crafted without Crafting Station */

		// Decorative Blocks

		// CraftingManager.RegisterRecipe(new CraftingRecipe(null, "Blocks", new
		// ItemStack(), new ItemStack[]{},null));
		/* Empty Barrel */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.barrelEmpty, 1), new ItemStack[] {new ItemStack(Blocks.planks, 5, 0), new ItemStack(Items.iron_ingot, 2)}, null));
		/* Closed Barrel */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.barrelClosed, 1), new ItemStack[] {new ItemStack(Blocks.planks, 6, 0), new ItemStack(Items.iron_ingot, 2)}, null));
		/* Gunpowder Barrel */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.barrelGunpowder, 1), new ItemStack[] {new ItemStack(Blocks.planks, 5, 0), new ItemStack(Items.iron_ingot, 2), new ItemStack(Items.gunpowder, 9)}, null));
		/* Hanging Bridge */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.hangingBridge, 1), new ItemStack[] {new ItemStack(Blocks.planks, 1, 0), new ItemStack(Items.string, 6)}, null));
		/* Mug Empty */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.mugEmpty, 1), new ItemStack[] {new ItemStack(Blocks.planks, 2)}, null));
		/* Rope */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.rope, 3), new ItemStack[] {new ItemStack(Items.string, 9)}, null));
		/* Rope Anchor */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.ropeAnchor, 1), new ItemStack[] {new ItemStack(Blocks.log, 1, 0), new ItemStack(DRPMedievalBlocks.rope, 1)}, null));
		/* Book */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.bookOne, 1), new ItemStack[] {new ItemStack(Items.book)}, null));
		/* Ships Wheel */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.shipsWheel, 1), new ItemStack[] {new ItemStack(Blocks.planks, 4)}, null));
		/* Bucket Empty */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.bucketEmpty, 1), new ItemStack[] {new ItemStack(Blocks.planks, 2), new ItemStack(Items.iron_ingot)}, null));
		/* Bucket Dirt */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.bucketDirt, 1), new ItemStack[] {new ItemStack(DRPMedievalBlocks.bucketEmpty, 1), new ItemStack(Blocks.dirt)}, null));
		/* Bucket Water */
		CM.RegisterRecipe(new CraftingRecipe(null, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.bucketWater, 1), new ItemStack[] {new ItemStack(DRPMedievalBlocks.bucketEmpty, 1), new ItemStack(Items.water_bucket)}, null));

		// Storage

		/* Crate */
		CM.RegisterRecipe(new CraftingRecipe(null, "Storage", new ItemStack(DRPMedievalBlocks.crate, 1), new ItemStack[] {new ItemStack(Blocks.planks, 6), new ItemStack(Items.iron_ingot, 4)}, null));
		/* Dungeon Chest */
		CM.RegisterRecipe(new CraftingRecipe(null, "Storage", new ItemStack(DRPMedievalBlocks.dungeonChest, 1), new ItemStack[] {new ItemStack(Blocks.planks, 4), new ItemStack(Items.iron_ingot, 2)}, null));

		// Crafting Stations

		/* Firepit */
		CM.RegisterRecipe(new CraftingRecipe(null, "Crafting Stations", new ItemStack(DRPMedievalBlocks.firepit, 1), new ItemStack[] {new ItemStack(DRPMedievalItems.itemFirewood, 6), new ItemStack(Blocks.cobblestone, 3)}, null));

		/* Chopping Block */
		CM.RegisterRecipe(new CraftingRecipe(null, "Crafting Stations", new ItemStack(DRPMedievalBlocks.choppingBlock, 1), new ItemStack[] {new ItemStack(Blocks.log, 1, 0), new ItemStack(Items.iron_axe, 1)}, null));

		/* Anvil */
		CM.RegisterRecipe(new CraftingRecipe(null, "Crafting Stations", new ItemStack(DRPMedievalBlocks.anvil, 1), new ItemStack[] {new ItemStack(Items.iron_ingot, 32), new ItemStack(Items.stick, 1)}, null));

		/* Mortar */
		CM.RegisterRecipe(new CraftingRecipe(null, "Crafting Stations", new ItemStack(DRPMedievalBlocks.mortar, 1), new ItemStack[] {new ItemStack(Blocks.stone, 1, 0), new ItemStack(Items.stick, 1)}, null));

		/* Grindstone */
		CM.RegisterRecipe(new CraftingRecipe(null, "Crafting Stations", new ItemStack(DRPMedievalBlocks.grindstone, 1), new ItemStack[] {new ItemStack(Blocks.stone, 4), new ItemStack(Blocks.log, 3, 0)}, null));

		// Items

		/* Trigger Trap */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemTriggerTrap, 2), new ItemStack[] {new ItemStack(Items.string, 2), new ItemStack(Blocks.tripwire_hook, 1)}, null));
		/* Leather Purse */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemLeatherPurse, 1), new ItemStack[] {new ItemStack(Items.leather, 3), new ItemStack(DRPMedievalBlocks.rope, 1)}, null));

		/* Golden Coin */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemGoldenCoin, 1), new ItemStack[] {new ItemStack(DRPMedievalItems.itemSilverCoin, 100)}, null));
		/* Silver Coin */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemSilverCoin, 1), new ItemStack[] {new ItemStack(DRPMedievalItems.itemBronzeCoin, 100)}, null));
		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemSilverCoin, 100), new ItemStack[] {new ItemStack(DRPMedievalItems.itemGoldenCoin, 1)}, null));
		/* Bronze Coin */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items", new ItemStack(DRPMedievalItems.itemBronzeCoin, 100), new ItemStack[] {new ItemStack(DRPMedievalItems.itemSilverCoin, 1)}, null));

		// Food
		/* Wheat Dough */
		CM.RegisterRecipe(new CraftingRecipe(null, "Food", new ItemStack(DRPMedievalItems.itemDoughWheat, 1), new ItemStack[] {new ItemStack(DRPMedievalItems.itemFlourWheat, 1), new ItemStack(DRPMedievalItems.itemFlourWheat)}, null));

		// Item --> Block

		/* Apple Red */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.appleRed), new ItemStack[] {new ItemStack(Items.apple)}, null));
		/* Apple Green */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.appleGreen), new ItemStack[] {new ItemStack(DRPMedievalItems.itemAppleGreen)}, null));
		/* Apple Yellow */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.appleYellow), new ItemStack[] {new ItemStack(DRPMedievalItems.itemAppleYellow)}, null));
		/* Pear Green */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.pearGreen), new ItemStack[] {new ItemStack(DRPMedievalItems.itemPearGreen)}, null));
		/* Pear Yellow */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.pearYellow), new ItemStack[] {new ItemStack(DRPMedievalItems.itemPearYellow)}, null));
		/* Mushroom Brown */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.mushroomBrown), new ItemStack[] {new ItemStack(Blocks.brown_mushroom)}, null));
		/* Mushroom Red */
		CM.RegisterRecipe(new CraftingRecipe(null, "Items --> Blocks", new ItemStack(DRPMedievalBlocks.mushroomRed), new ItemStack[] {new ItemStack(Blocks.red_mushroom)}, null));

		/* Anvil Crafting Station */

		// Crafting Stations

		/* Cauldron on Firepit */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.anvil, "Crafting Stations", new ItemStack(DRPMedievalBlocks.cauldron, 1), new ItemStack[] {new ItemStack(Items.iron_ingot, 12), new ItemStack(DRPMedievalItems.itemFirewood, 5)}, null));

		// Decorative Blocks

		/* Chain */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.anvil, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.chain, 3), new ItemStack[] {new ItemStack(Items.iron_ingot, 3)}, null));
		/* Hook */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.anvil, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.hook, 1), new ItemStack[] {new ItemStack(Items.iron_ingot, 2)}, null));
		/* Hanging Cauldron */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.anvil, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.hangingCauldron), new ItemStack[] {new ItemStack(Items.iron_ingot, 12)}, null));
		/* Torch Holder */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.anvil, "Decorative Blocks", new ItemStack(DRPMedievalBlocks.torchHolderEmpty), new ItemStack[] {new ItemStack(Items.iron_ingot)}, null));

		/* Chopping Block Crafting Station */

		// Firewood

		/* Firewood */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 0), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log), 1, 0)}, null));
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 1), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log), 1, 1)}, null));
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 2), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log), 1, 2)}, null));
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 3), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log), 1, 3)}, null));
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 4), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log2), 1, 0)}, null));
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.choppingBlock, "Firewood", new ItemStack(DRPMedievalItems.itemFirewood, 4, 5), new ItemStack[] {new ItemStack(Item.getItemFromBlock(Blocks.log2), 1, 1)}, null));

		/* Mortar */

		// Pulverize

		/* Flour Wheat */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.mortar, "Pulverize", new ItemStack(DRPMedievalItems.itemFlourWheat), new ItemStack[] {new ItemStack(Items.wheat)}, null));
		/* Bone Meal */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.mortar, "Pulverize", new ItemStack(Items.dye, 4, 15), new ItemStack[] {new ItemStack(Items.bone)}, null));

		/* Cauldron */

		// Stews

		/* Pumpkin Stew */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(DRPMedievalItems.itemPumpkinStew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Blocks.pumpkin)}, new ItemStack[] {new ItemStack(Items.carrot), new ItemStack(Items.milk_bucket)}));
		/* Vegie Stew */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(DRPMedievalItems.itemVegieStew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Items.potato), new ItemStack(Items.carrot)}, null));
		/* Vegie Stew */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(DRPMedievalItems.itemCodStew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Items.fish, 1, 0)}, new ItemStack[] {new ItemStack(Items.carrot), new ItemStack(Items.potato)}));
		/* Chicken Stew */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(DRPMedievalItems.itemChickenStew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Items.chicken, 1, 0), new ItemStack(Items.carrot)}, null));
		/* Mushroom Stew */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(Items.mushroom_stew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Blocks.red_mushroom), new ItemStack(Blocks.brown_mushroom)}, null));
		/* Rabbit Stew */
		CM.RegisterRecipe(new CraftingRecipe(DRPMedievalBlocks.cauldron, "Stews", new ItemStack(Items.rabbit_stew, 3), new ItemStack[] {new ItemStack(Items.bowl, 3), new ItemStack(Items.water_bucket), new ItemStack(Items.rabbit), new ItemStack(Items.carrot), new ItemStack(Items.potato), new ItemStack(Blocks.brown_mushroom)}, null));

	}

	public void registerEntitys() {}

	public void registerFurnaceRecipes() {

		GameRegistry.addSmelting(DRPMedievalItems.itemDoughWheat, new ItemStack(Items.bread), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.itemDoughBarley, new ItemStack(Items.bread), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.itemWolfMeatRaw, new ItemStack(DRPMedievalItems.itemWolfMeatCooked), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.itemDoughPumpkin, new ItemStack(DRPMedievalItems.itemPumpkinBread), 0.1f);
	}
}

class DarkRoleplayFuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {

		Item item = fuel.getItem();

		if(item.equals(DRPMedievalItems.itemFirewood)){ return 800; }

		return 0;
	}
}
