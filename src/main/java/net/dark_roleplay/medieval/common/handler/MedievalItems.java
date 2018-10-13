package net.dark_roleplay.medieval.common.handler;

import java.util.ArrayList;
import java.util.List;

import net.dark_roleplay.core.api.old.items.DRPFood;
import net.dark_roleplay.core_modules.maarg.api.arg.MaterialRequirements;
import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.library.util.InDevUtil;
import net.dark_roleplay.library_old.items.DRPItem;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.objects.items.BarkAndGlue;
import net.dark_roleplay.medieval.common.objects.items.DRPMStew;
import net.dark_roleplay.medieval.common.objects.items.HangingBridge_Item;
import net.dark_roleplay.medieval.common.objects.items.ItemFirewood;
import net.dark_roleplay.medieval.common.objects.items.ItemMultiBlock;
import net.dark_roleplay.medieval.common.objects.items.tools.FlintKnife;
import net.dark_roleplay.medieval.common.objects.items.tools.StreetStomper;
import net.dark_roleplay.medieval.common.objects.items.tools.Telescope;
import net.dark_roleplay.medieval.common.objects.items.tools.WarHorn;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = References.MODID)
@ObjectHolder(References.MODID)
public class MedievalItems {

	//Items

	public static final Item WOODEN_WRENCH = null;
	public static final Item TIMBERED_CLAY = null;
	public static final Item DRY_CLAY_CHUNK = null;
	public static final Item TRIGGER_TRAP = null;
	public static final Item ORE_CHUNK_SALPETER = null;
	public static final Item ORE_CHUNK_SILVER = null;
	public static final Item ORE_CHUNK_TIN = null;
	public static final Item ORE_CHUNK_COPPER = null;
	public static final Item ORE_CHUNK_SULFUR = null;
	public static final Item HANGING_BRIDGE = null;

	public static final Item DOUGH = null;
	public static final Item RAW_WOLF = null;
	public static final Item COOKED_WOLF = null;
	public static final Item RAW_CATFISH = null;
	public static final Item COOKED_CATFISH = null;
	public static final Item PUMPKIN_DOUGH = null;
	public static final Item PUMPKIN_BREAD = null;
	public static final Item HOPS = null;
	public static final Item TAP = null;
	public static final Item BLACK_PAINTBRUSH = null;

	public static final Item SPINDLE = null;
	public static final Item BARLEY = null;
	public static final Item LANTERN = null;
	public static final Item BEESWAX_CANDLE = null;

	public static final Item COIN_BRONZE = null;
	public static final Item COIN_SILVER = null;
	public static final Item COIN_GOLDEN = null;

	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Item> registryEvent) {
		IForgeRegistry<Item> reg = registryEvent.getRegistry();

		MaterialRequirements logRequired = new MaterialRequirements("log_side", "log_top");
		new MaterialRequirements("plank");
		MaterialRequirements cleanPlankRequired = new MaterialRequirements("clean_plank");

		for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
			if(cleanPlankRequired.doesFulfillRequirements(mat)) {
        		register(reg, MedievalCreativeTabs.MISCELLANEOUS,
    				new DRPItem(mat.getName() + "_wood_beam", "wood_beams", 64) {
	    				@Override
	    				public int getItemBurnTime(ItemStack itemStack){
	    			        return 400;
    					}
    				},
    				new DRPItem(mat.getName() + "_planks", "planks", 64) {
	    				@Override
	    				public int getItemBurnTime(ItemStack itemStack){
	    			        return 400;
    					}
    				}
        		);
        	}

			if(logRequired.doesFulfillRequirements(mat)) {
				register(reg, MedievalCreativeTabs.MISCELLANEOUS,
					new ItemFirewood(mat.getName() + "_firewood", "firewood", 64)
				);
			}

		}

		register(reg, MedievalCreativeTabs.MISCELLANEOUS,
				new DRPItem("grass", "misc", 64),
				new DRPItem("hay", "misc", 64),
				new DRPItem("leather_string", "misc", 64),
				new DRPItem("leather_string_tanned", "misc", 64),
				new DRPItem("leather_tanned", "misc", 64),
				new DRPItem("dry_clay_chunk", "misc", 64),
				new DRPItem("charcoal_powder", "misc", 64),
				new DRPItem("ore_chunk_silver", "misc/ores", 64),
				new DRPItem("ore_chunk_tin", "misc/ores", 64),
				new DRPItem("ore_chunk_copper", "misc/ores", 64),
				new DRPItem("ore_chunk_sulfur", "misc/ores", 64),
				new DRPItem("ore_chunk_salpeter", "misc/ores", 64),
				new DRPItem("leather_book_cover", "misc/books", 64),
				new DRPItem("leather_book_cover_thik", "misc/books", 64),
				new DRPItem("leather_book_cover_thin", "misc/books", 64),

				new DRPItem("barley", "cereals", 64),
				new DRPItem("pumpkin_dough", "misc/dough", 64, "wheat", "barley"),
				new DRPItem("flour", "misc/flour", 64, "wheat", "barley"),
				new DRPItem("dough", "misc/dough", 64, "wheat", "barley"),

				new DRPItem("tap", "misc", 64),
				new DRPItem("trigger_trap", "misc", 64),
				new DRPItem("coin_bronze", "misc/currency", 50),
				new DRPItem("coin_silver", "misc/currency", 50),
				new DRPItem("coin_golden", "misc/currency", 50),
				new BarkAndGlue("bark_and_glue", 64),

				new DRPItem("bat_ear", "mobs/bat", 64),
				new DRPItem("fur_wolf", "mobs/wolf", 64)
			);

		register(reg, MedievalCreativeTabs.EQUIPMENT,
				new FlintKnife("flint_knife", "equipment/tools", 1),
				new DRPItem("wooden_wrench", "equipment/tools", 1),
				new StreetStomper("wood_street_stomper", "equipment/tools", 1, 256),
				new StreetStomper("stone_street_stomper", "equipment/tools", 1, 512),
				new DRPItem("wooden_lock", "misc/locks", 16),
				new DRPItem("wooden_key", "misc/keys", 16),
				new DRPItem("clean_paintbrush", "paintbrushes", 1),
				new DRPItem("black_paintbrush", "paintbrushes", 1),
				new Telescope("golden_telescope", "equipment/telescope"),
				new Telescope("silver_telescope", "equipment/telescope"),
				new WarHorn("bone_war_horn","equipment/tools/horns", 1)
		);

		register(reg, MedievalCreativeTabs.FOOD,
			new DRPFood(4, 0.3F, "apple_green", "food/fruits", 64),
			new DRPFood(4, 0.3F, "apple_yellow", "food/fruits", 64),
			new DRPFood(6, 0.6F, "cooked_catfish", "food/fish", 64),
			new DRPFood(2, 0.3F, "raw_catfish", "food/fish", 64),
			new DRPFood(1, 0.1F, "blue_berries", "food/fruits", 64),
			new DRPFood(2, 0.2F, "grapes", "food/fruits", 64),
			new DRPFood(2, 0.4F, "garlic", "food/vegetables", 64),
			new DRPFood(2, 0.4F, "onion", "food/vegetables", 64),
			new DRPFood(4, 0.4F, "cauliflower", "food/vegetables", 64),
			new DRPFood(6, 0.4F, "cooked_wolf", "food/meat", 64),
			new DRPFood(2, 0.15F, "raw_wolf", "food/meat", 64),
			new DRPFood(4, 0.3F, "pear_green", "food/fruits", 64),
			new DRPFood(4, 0.3F, "pear_yellow", "food/fruits", 64),
			new DRPFood(2, 0.4F, "turnip", "food/vegetables", 64),
			new DRPFood(2, 0.4F, "hops", "food/vegetables", 64),
			new DRPFood(6, 0.5F, "pumpkin_bread", "food/bakewares", 64),
			new DRPMStew(8, 0.5F, "chicken_stew"),
			new DRPMStew(7, 0.5F, "cod_stew"),
			new DRPMStew(6, 0.3F, "vegie_stew"),
			new DRPMStew(6, 0.3F, "pumpkin_stew")
		);


		register(reg, MedievalCreativeTabs.DECORATION,
				new HangingBridge_Item("hanging_bridge", "blocks", 64)
		);

		register(reg, MedievalCreativeTabs.UTILITY,
				new ItemMultiBlock(MedievalBlocks.SIMPLE_CARPENTER_WORKBENCH).setRegistryName("simple_carpenter_workbench"),
				new ItemMultiBlock(MedievalBlocks.FORGE).setRegistryName("forge")
		);

		register(reg, MedievalCreativeTabs.BUILDING_MATS,
				new ItemBlock(MedievalBlocks.OAK_TIMBERED_CLAY_CLEAN).setRegistryName("timbered_clay"));


		if(InDevUtil.isDevEnv()) {
			register(reg, MedievalCreativeTabs.FOOD,
				new DRPFood(6, 0.5F, "honey_comb", "food/other", 64)
			);

			register(reg, MedievalCreativeTabs.MISCELLANEOUS,
				new DRPItem("stone_brick", "misc", 64),
				new DRPItem("beeswax", "misc", 64),
				new DRPItem("empty_frame", "misc/apiary_frames", 1),
				new DRPItem("honey_frame", "misc/apiary_frames", 1),
				new DRPItem("brute_frame", "misc/apiary_frames", 1),
				new DRPItem("sugar_frame", "misc/apiary_frames", 1),
				new DRPItem("wax_frame", "misc/apiary_frames", 1)
			);


//			new PoleWeapon("halberd", "equipment/weapons/pole_weapons", 20),
//			new DRPEquip("quiver", "quivers", DRPEquip.TYPE.TYPE_AMMO_STORAGE),
//			new DRPEquip("leather_purse", "purses", DRPEquip.TYPE.TYPE_MONEY_STORAGE),
//			new DRPEquip("ring_bronze", "rings", DRPEquip.TYPE.TYPE_RING),
//			new DRPEquip("ring_silver", "rings", DRPEquip.TYPE.TYPE_RING),
//			new DRPEquip("ring_golden", "rings", DRPEquip.TYPE.TYPE_RING),
		}

		for(ItemBlock block : blockItems){
			reg.register(block);
		}
	}

	protected static void register(IForgeRegistry<Item> reg, CreativeTabs creativeTab, Item... items){
		for(Item item : items)
			item.setCreativeTab(creativeTab);
		reg.registerAll(items);
	}


	private static List<ItemBlock> blockItems = new ArrayList<ItemBlock>();

	public static void addBlockItem(ItemBlock item){
		blockItems.add(item);
	}
}
