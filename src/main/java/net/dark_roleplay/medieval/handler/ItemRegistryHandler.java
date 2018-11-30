package net.dark_roleplay.medieval.handler;

import java.util.HashSet;
import java.util.Set;

import net.dark_roleplay.core.api.old.items.DRPFood;
import net.dark_roleplay.core_modules.maarg.api.arg.MaterialRequirements;
import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.library.util.InDevUtil;
import net.dark_roleplay.library_old.items.DRPItem;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.handler.MedievalBlocks;
import net.dark_roleplay.medieval.common.handler.MedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.ResourceFolders;
import net.dark_roleplay.medieval.common.objects.items.BarkAndGlue;
import net.dark_roleplay.medieval.common.objects.items.DRPMStew;
import net.dark_roleplay.medieval.common.objects.items.HangingBridge_Item;
import net.dark_roleplay.medieval.common.objects.items.ItemFirewood;
import net.dark_roleplay.medieval.common.objects.items.ItemMultiBlock;
import net.dark_roleplay.medieval.common.objects.items.tools.FlintKnife;
import net.dark_roleplay.medieval.common.objects.items.tools.StreetStomper;
import net.dark_roleplay.medieval.common.objects.items.tools.Telescope;
import net.dark_roleplay.medieval.common.objects.items.tools.WarHorn;
import net.dark_roleplay.medieval.testing.purse.DRPCoin;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = References.MODID)
public class ItemRegistryHandler {

	//Helper to register ItemBlocks
	private static Set<Item> blockItems = new HashSet<Item>();

	@SubscribeEvent
	public static final void registerItems(RegistryEvent.Register<Item> registryEvent) {
		IForgeRegistry<Item> reg = registryEvent.getRegistry();

		registerItems(reg, MedievalCreativeTabs.EQUIPMENT,
			new FlintKnife("flint_knife", ResourceFolders.Items.TOOLS + "/knifes", 1),
			new DRPItem("wood_wrench", ResourceFolders.Items.TOOLS + "/wrenches", 1),
			new StreetStomper("wood_street_stomper", ResourceFolders.Items.TOOLS + "/street_stompers", 1, 256),
			new StreetStomper("stone_street_stomper", ResourceFolders.Items.TOOLS + "/street_stompers", 1, 512),
			new DRPItem("clean_paintbrush", ResourceFolders.Items.TOOLS + "/paintbrushes", 1),
			new DRPItem("dirty_paintbrush", ResourceFolders.Items.TOOLS + "/paintbrushes", 1),
			new Telescope("golden_telescope", ResourceFolders.Items.OTHER_EQUIPMENT + "/telescopes"),
			new Telescope("silver_telescope", ResourceFolders.Items.OTHER_EQUIPMENT + "/telescopes"),
			new WarHorn("bone_war_horn", ResourceFolders.Items.INSTRUMENTS + "/horns", 1),
			new DRPItem("wooden_lock", ResourceFolders.Items.CONSUMABLES + "/locks", 16),
			new DRPItem("wooden_key", ResourceFolders.Items.CONSUMABLES + "/keys", 16)
		);

		registerItems(reg, MedievalCreativeTabs.FOOD,
			new DRPFood(6, 0.5F, "honey_comb", ResourceFolders.Items.OTHER_FOOD + "/honey", 64),
			new DRPFood(3, 0.5F, "butter", ResourceFolders.Items.OTHER_FOOD + "/butter", 64),
			new DRPFood(4, 0.3F, "apple_green", ResourceFolders.Items.FRUITS + "/apples", 64),
			new DRPFood(4, 0.3F, "apple_yellow", ResourceFolders.Items.FRUITS + "/apples", 64),
			new DRPFood(1, 0.1F, "blue_berries", ResourceFolders.Items.FRUITS + "/berries", 64),
			new DRPFood(2, 0.2F, "grapes", ResourceFolders.Items.FRUITS + "/berries", 64),
			new DRPFood(4, 0.3F, "pear_green", ResourceFolders.Items.FRUITS + "/pears", 64),
			new DRPFood(4, 0.3F, "pear_yellow", ResourceFolders.Items.FRUITS + "/pears", 64),
			new DRPFood(6, 0.6F, "cooked_catfish", ResourceFolders.Items.FISH + "/catfish", 64),
			new DRPFood(2, 0.3F, "raw_catfish",  ResourceFolders.Items.FISH + "/catfish", 64),
			new DRPFood(6, 0.4F, "cooked_wolf",  ResourceFolders.Items.MEAT + "/wolf", 64),
			new DRPFood(2, 0.15F, "raw_wolf", ResourceFolders.Items.MEAT + "/wolf", 64),
			new DRPFood(2, 0.4F, "turnip", ResourceFolders.Items.VEGETABLES, 64),
			new DRPFood(2, 0.4F, "eggplant", ResourceFolders.Items.VEGETABLES, 64),
			new DRPFood(2, 0.4F, "hops", ResourceFolders.Items.VEGETABLES, 64),
			new DRPFood(4, 0.6F, "cauliflower", ResourceFolders.Items.VEGETABLES, 64),
			new DRPFood(2, 0.4F, "garlic", ResourceFolders.Items.VEGETABLES, 64),
			new DRPFood(2, 0.4F, "onion", ResourceFolders.Items.VEGETABLES, 64),
			new DRPFood(2, 0.4F, "bell_pepper", ResourceFolders.Items.VEGETABLES, 64),
			new DRPFood(6, 0.5F, "pumpkin_bread", ResourceFolders.Items.BAKEWARES + "/breads", 64),
			new DRPMStew(8, 0.5F, "chicken_stew", ResourceFolders.Items.STEWS),
			new DRPMStew(7, 0.5F, "cod_stew", ResourceFolders.Items.STEWS),
			new DRPMStew(6, 0.3F, "vegie_stew", ResourceFolders.Items.STEWS),
			new DRPMStew(6, 0.3F, "pumpkin_stew", ResourceFolders.Items.STEWS),
			new DRPFood(4, 0.5F, "ginger_bread", ResourceFolders.Items.BAKEWARES + "/breads", 64)
		);

		registerItems(reg, MedievalCreativeTabs.MATERIALS,
			new DRPItem("grass", ResourceFolders.Items.PLANT_MATS, 64),
			new DRPItem("hay", ResourceFolders.Items.PLANT_MATS, 64),
			new DRPItem("wheat_pumpkin_dough", ResourceFolders.Items.COOKING_MATS + "/doughs", 64),
			new DRPItem("barley_pumpkin_dough", ResourceFolders.Items.COOKING_MATS + "/doughs", 64),
			new DRPItem("barley", ResourceFolders.Items.COOKING_MATS + "/cereals", 64),
			new DRPItem("wheat_flour", ResourceFolders.Items.COOKING_MATS + "/flours", 64),
			new DRPItem("barley_flour", ResourceFolders.Items.COOKING_MATS + "/flours", 64),
			new DRPItem("wheat_dough", ResourceFolders.Items.COOKING_MATS + "/doughs", 64),
			new DRPItem("barley_dough", ResourceFolders.Items.COOKING_MATS + "/doughs", 64),
			new DRPCoin("bronze_coin", ResourceFolders.Items.CURRENCIES, 50),
			new DRPCoin("silver_coin", ResourceFolders.Items.CURRENCIES, 50),
			new DRPCoin("gold_coin", ResourceFolders.Items.CURRENCIES, 50),
			new DRPItem("bat_ear", ResourceFolders.Items.MOB_DROPS + "/bat", 64),
			new DRPItem("wolf_fur", ResourceFolders.Items.MOB_DROPS + "/wolf", 64),
			new DRPItem("tap", ResourceFolders.Items.ATTACHMENTS, 64),
			new DRPItem("trigger_trap", ResourceFolders.Items.ATTACHMENTS, 64),
			new DRPItem("leather_string", ResourceFolders.Items.LEATHER_MATS, 64),
			new DRPItem("tanned_leather_string", ResourceFolders.Items.LEATHER_MATS, 64),
			new DRPItem("tanned_leather", ResourceFolders.Items.LEATHER_MATS, 64),
			new DRPItem("leather_book_cover", ResourceFolders.Items.BOOKS, 64),
			new DRPItem("thik_leather_book_cover", ResourceFolders.Items.BOOKS, 64),
			new DRPItem("thin_leather_book_cover", ResourceFolders.Items.BOOKS, 64),
			new DRPItem("dry_clay_chunk", ResourceFolders.Items.MINERALS, 64),
			new DRPItem("silver_ore_chunk", ResourceFolders.Items.MINERALS, 64),
			new DRPItem("tin_ore_chunk", ResourceFolders.Items.MINERALS, 64),
			new DRPItem("copper_ore_chunk", ResourceFolders.Items.MINERALS, 64),
			new DRPItem("sulfur_ore_chunk", ResourceFolders.Items.MINERALS, 64),
			new DRPItem("salpeter_ore_chunk", ResourceFolders.Items.MINERALS, 64),
			new DRPItem("charcoal_powder", ResourceFolders.Items.PROCESSED_MINERALS, 64),
			new BarkAndGlue("bark_and_glue", ResourceFolders.Items.OTHER_CONSUMABLES, 64)
		);

		registerItems(reg, MedievalCreativeTabs.DECORATION,
			new HangingBridge_Item("hanging_bridge", ResourceFolders.Items.BLOCKS, 64)
		);


		//TODO Fix that

		registerItems(reg, MedievalCreativeTabs.UTILITY,
				new ItemMultiBlock(MedievalBlocks.SIMPLE_CARPENTER_WORKBENCH).setRegistryName("simple_carpenter_workbench"),
				new ItemMultiBlock(MedievalBlocks.FORGE).setRegistryName("forge")
		);

		registerItems(reg, MedievalCreativeTabs.BUILDING_MATS, new ItemBlock(MedievalBlocks.OAK_TIMBERED_CLAY_CLEAN).setRegistryName("timbered_clay"));


		if(InDevUtil.isDevEnv()) {
//			registerItems(reg, MedievalCreativeTabs.MATERIALS,
//				new DRPItem("stone_bricks", ResourceFolders.Items.PROCESSED_MATERIALS, 64)
//			);
//
//			registerItems(reg, MedievalCreativeTabs.EQUIPMENT,
//				new Purse("leather_purse", ResourceFolders.Items.OTHER_EQUIPMENT, 1)
//			);
//
//			registerItems(reg, MedievalCreativeTabs.MATERIALS,
//				new DRPItem("beeswax", "misc", 64),
//				new DRPItem("empty_frame", "misc/apiary_frames", 1),
//				new DRPItem("honey_frame", "misc/apiary_frames", 1),
//				new DRPItem("brute_frame", "misc/apiary_frames", 1),
//				new DRPItem("sugar_frame", "misc/apiary_frames", 1),
//				new DRPItem("wax_frame", "misc/apiary_frames", 1)
//			);
		}


		MaterialRequirements logRequired = new MaterialRequirements("log_side", "log_top");
		MaterialRequirements planksRequired = new MaterialRequirements("planks");
		MaterialRequirements cleanPlankRequired = new MaterialRequirements("clean_planks");

		//Register Wooden Items
		for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
			if(cleanPlankRequired.doesFulfillRequirements(mat)) {
				registerItems(reg, MedievalCreativeTabs.MATERIALS,
    				new DRPItem(mat.getName() + "_wood_beam", ResourceFolders.Items.PROCESSED_MATERIALS + "/wood_beams", 64) {
	    				@Override
	    				public int getItemBurnTime(ItemStack itemStack){
	    			        return 400;
    					}
    				},
    				new DRPItem(mat.getName() + "_planks", ResourceFolders.Items.PROCESSED_MATERIALS + "/planks", 64) {
	    				@Override
	    				public int getItemBurnTime(ItemStack itemStack){
	    			        return 400;
    					}
    				}
        		);
        	}

			if(logRequired.doesFulfillRequirements(mat)) {
				registerItems(reg, MedievalCreativeTabs.MATERIALS,
					new ItemFirewood(mat.getName() + "_firewood", ResourceFolders.Items.PROCESSED_MATERIALS + "/firewood", 64)
				);
			}
		}

		for(Item item : blockItems){
			reg.register(item);
		}
	}

	protected static void registerItems(IForgeRegistry<Item> reg, CreativeTabs creativeTab, Item... items){
		for(Item item : items)
			item.setCreativeTab(creativeTab);
		reg.registerAll(items);
	}

	//Helper to Register ItemBlocks
	public static void addBlockItem(ItemBlock item){
		blockItems.add(item);
	}
}
