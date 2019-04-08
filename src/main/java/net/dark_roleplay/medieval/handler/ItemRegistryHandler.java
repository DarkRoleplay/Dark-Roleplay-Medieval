package net.dark_roleplay.medieval.handler;

import static net.dark_roleplay.medieval.holders.MedievalCreativeTabs.DECORATION;
import static net.dark_roleplay.medieval.holders.MedievalCreativeTabs.EQUIPMENT;
import static net.dark_roleplay.medieval.holders.MedievalCreativeTabs.FOOD;
import static net.dark_roleplay.medieval.holders.MedievalCreativeTabs.MISCELLANEOUS;

import net.dark_roleplay.drpmarg.api.Constants;
import net.dark_roleplay.drpmarg.api.MaterialRequirements;
import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.holders.MedievalBlocks;
import net.dark_roleplay.medieval.objects.items.equipment.tools.ItemTelescope;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = DarkRoleplayMedieval.MODID, bus = Bus.MOD)
public class ItemRegistryHandler {

	private static Item.Properties PLACEHOLDER = new Properties().group(MISCELLANEOUS);

	private static IForgeRegistry<Item> registry = null;
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> registryEvent) {
		registry = registryEvent.getRegistry();

		//FOOD
		reg(new ItemFood( 4, 0.2F, false, new Properties().group(FOOD)), "bell_pepper");
		reg(new ItemFood( 0, 0.1F, false, new Properties().group(FOOD)), "blueberries");
		reg(new ItemFood( 8, 0.2F, false, new Properties().group(FOOD)), "butter");
		reg(new ItemFood( 6, 0.4F, false, new Properties().group(FOOD)), "caramelized_green_apple");
		reg(new ItemFood( 6, 0.4F, false, new Properties().group(FOOD)), "caramelized_red_apple");
		reg(new ItemFood( 6, 0.4F, false, new Properties().group(FOOD)), "caramelized_yellow_apple");
		reg(new ItemFood( 6, 0.3F, false, new Properties().group(FOOD)), "cauliflower");
		reg(new ItemSoup( 7, new Properties().maxStackSize(1).group(FOOD)), "chicken_stew");
		reg(new ItemSoup( 6, new Properties().maxStackSize(1).group(FOOD)), "cod_stew");
		reg(new ItemFood( 4, 0.3F, false, new Properties().group(FOOD)), "eggplant");
		reg(new ItemFood( 1, 0.1F, false, new Properties().group(FOOD)), "garlic");
		reg(new ItemFood( 4, 0.3F, false, new Properties().group(FOOD)), "green_apple");
		reg(new ItemFood( 4, 0.3F, false, new Properties().group(FOOD)), "green_pear");
		reg(new ItemFood( 6, 0.5F, false, new Properties().group(FOOD)), "grilled_catfish");
		reg(new ItemFood( 6, 0.5F, true , new Properties().group(FOOD)), "grilled_wolf");
		reg(new ItemFood(10, 0.6F, false, new Properties().group(FOOD)), "honey_comb");
		reg(new ItemFood( 2, 0.1F, false, new Properties().group(FOOD)), "hops");
		reg(new ItemFood( 3, 0.2F, false, new Properties().group(FOOD)), "onion");
		reg(new ItemSoup( 6, new Properties().maxStackSize(1).group(FOOD)), "pumpkin_stew");
		reg(new ItemFood( 3, 0.2F, false, new Properties().group(FOOD)), "raw_catfish");
		reg(new ItemFood( 4, 0.2F,  true, new Properties().group(FOOD)), "raw_wolf");
		reg(new ItemFood( 4, 0.2F, false, new Properties().group(FOOD)), "red_grapes");
		reg(new ItemFood( 0, 0.2F, false, new Properties().group(FOOD)), "spruce_tea");
		reg(new ItemFood( 4, 0.2F, false, new Properties().group(FOOD)), "turnip");
		reg(new ItemSoup( 6, new Properties().maxStackSize(1).group(FOOD)), "vegetable_stew");
		reg(new ItemFood( 4, 0.3F, false, new Properties().group(FOOD)), "yellow_apple");
		reg(new ItemFood( 4, 0.3F, false, new Properties().group(FOOD)), "yellow_pear");
		
		//Tools
		reg(new Item(new Properties().maxStackSize(1).group(EQUIPMENT)), "bone_war_horn");
		reg(new Item(new Properties().maxStackSize(1).group(EQUIPMENT)), "clean_paintbrush");
		reg(new Item(new Properties().maxStackSize(1).group(EQUIPMENT)), "dirty_paintbrush");
		reg(new ItemTelescope(new Properties().maxStackSize(1).group(EQUIPMENT)), "golden_telescope");
		reg(new ItemTelescope(new Properties().maxStackSize(1).group(EQUIPMENT)), "silver_telescope");
		reg(new Item(new Properties().maxStackSize(1).group(EQUIPMENT)), "stone_street_stomper");
		reg(new Item(new Properties().maxStackSize(1).group(EQUIPMENT)), "wooden_key");
		reg(new Item(new Properties().maxStackSize(1).group(EQUIPMENT)), "wooden_lock");
		reg(new Item(new Properties().maxStackSize(1).group(EQUIPMENT)), "wooden_street_stomper");
		reg(new Item(new Properties().maxStackSize(1).group(EQUIPMENT)), "wooden_wrench");
		
		reg(new Item(new Properties().group(MISCELLANEOUS)), "barley");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "barley_dough");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "barley_flour");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "bat_ear");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "bat_wing");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "bronze_coin");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "charcoal_powder");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "copper_coin");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "copper_ore_chunk");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "cut_grass");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "dry_clay_chunk");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "gold_coin");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "hardened_leather");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "hardened_leather_strip");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "hay");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "leather_book_cover");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "leather_strip");
//		reg(new Item(new Properties().group(MISCELLANEOUS)), "rope");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "salpeter_ore_chunk");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "silver_coin");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "silver_ore_chunk");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "sulfur_ore_chunk");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "thick_leather_book_cover");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "thin_leather_book_cover");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "tin_ore_chunk");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "trigger_trap");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "wheat_dough");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "wheat_flour");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "wolf_fur");
		reg(new Item(new Properties().group(MISCELLANEOUS)), "wooden_cup");
		
		reg(new ItemBlock(MedievalBlocks.TORCH_HOLDER, new Properties().group(DECORATION)), "torch_holder");

//		registry = null;
		
		MaterialRequirements planks = new MaterialRequirements(Constants.MAT_WOOD, "planks");
		
		planks.execute(material -> {
			reg(new ItemBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DarkRoleplayMedieval.MODID, String.format("%s_plank_chair", material.getName()))), new Properties().group(DECORATION)), String.format("%s_plank_chair", material.getName()));
			reg(new ItemBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DarkRoleplayMedieval.MODID, String.format("%s_solid_chair", material.getName()))), new Properties().group(DECORATION)), String.format("%s_solid_chair", material.getName()));
			reg(new ItemBlock(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DarkRoleplayMedieval.MODID, String.format("%s_solid_chair_armrest", material.getName()))), new Properties().group(DECORATION)), String.format("%s_solid_chair_armrest", material.getName()));
		});
	}

	protected static void reg(Item item, String registryName) {
		item.setRegistryName(new ResourceLocation(DarkRoleplayMedieval.MODID, registryName));
		registry.register(item);
	}
}
// No more code

//	new DRPItem("asparagus", "food/vegetables", 64),
//	new DRPItem("asparagus_cut", "food/vegetables/cut", 64),
//	new DRPItem("asparagus_peeled", "food/vegetables/peeled", 64),
//	new DRPItem("aubergine", "food/vegetables", 64),
//	new DRPItem("aubergine_cut", "food/vegetables/cut", 64),
//	new DRPItem("aubergine_peeled", "food/vegetables/peeled", 64),
//	new DRPItem("bean_pod", "food/vegetables", 64),
//	new DRPItem("beans", "food/vegetables/peeled", 64),
//	new DRPItem("bell_pepper", "food/vegetables", 64),
//	new DRPItem("bell_pepper_cut", "food/vegetables/cut", 64),
//	new DRPItem("broccoli", "food/vegetables", 64),
//	new DRPItem("broccoli_cut", "food/vegetables/cut", 64),
//	new DRPItem("brussel_sprouts", "food/vegetables", 64),
//	new DRPItem("brussel_sprouts_cut", "food/vegetables/cut", 64),
//	new DRPItem("cantaloupe", "food/vegetables", 64),
//	new DRPItem("cantaloupe_cut", "food/vegetables/cut", 64),
//	new DRPItem("cantaloupe_peeled", "food/vegetables/peeled", 64),
//	//new DRPItem("carrot", "food/vegetables", 64),
//	new DRPItem("carrot_cut", "food/vegetables/cut", 64),
//	new DRPItem("carrot_peeled", "food/vegetables/peeled", 64),
//	new DRPItem("cauliflower_cut", "food/vegetables/cut", 64),
//	new DRPItem("celery", "food/vegetables", 64),
//	new DRPItem("celery_cut", "food/vegetables/cut", 64),
//	new DRPItem("cucumber", "food/vegetables", 64),
//	new DRPItem("cucumber_cut", "food/vegetables/cut", 64),
//	new DRPItem("cucumber_peeled", "food/vegetables/peeled", 64),
//	new DRPItem("garlic_cut", "food/vegetables/cut", 64),
//	new DRPItem("garlic_peeled", "food/vegetables/peeled", 64),
//	new DRPItem("horseradish", "food/vegetables", 64),
//	new DRPItem("horseradish_cut", "food/vegetables/cut", 64),
//	new DRPItem("jute", "food/other", 64),
//	new DRPItem("kohlrabi", "food/vegetables", 64),
//	new DRPItem("kohlrabi_cut", "food/vegetables/cut", 64),
//	new DRPItem("kohlrabi_peeled", "food/vegetables/peeled", 64),
//	new DRPItem("leek", "food/vegetables", 64),
//	new DRPItem("leek_cut", "food/vegetables/cut", 64),
//	new DRPItem("lentil", "food/vegetables", 64),
//	new DRPItem("lettuce", "food/vegetables", 64),
//	new DRPItem("lettuce_cut", "food/vegetables/cut", 64),
//	new DRPItem("onion_cut", "food/vegetables/cut", 64),
//	new DRPItem("onion_peeled", "food/vegetables/peeled", 64),
//	new DRPItem("parsley", "food/herbs", 64),
//	new DRPItem("parsley_cut", "food/herbs/cut", 64),
//	new DRPItem("parsley_root", "food/vegetables", 64),
//	new DRPItem("parsley_root_cut", "food/vegetables/cut", 64),
//	new DRPItem("pea_pod", "food/vegetables", 64),
//	new DRPItem("pea_pod_cut", "food/vegetables/cut", 64),
//	new DRPItem("peas", "food/vegetables/peeled", 64),
//	//new DRPItem("potato", "food/vegetables", 64),
//	new DRPItem("potato_cut", "food/vegetables/cut", 64),
//	new DRPItem("potato_peeled", "food/vegetables/peeled", 64),
//	//new DRPItem("red_beet", "food/vegetables", 64),
//	new DRPItem("red_beet_cut", "food/vegetables/cut", 64),
//	new DRPItem("red_beet_peeled", "food/vegetables/peeled", 64),
//	new DRPItem("red_cabbage", "food/vegetables", 64),
//	new DRPItem("red_cabbage_cut", "food/vegetables/cut", 64),
//	new DRPItem("rhubarb", "food/vegetables", 64),
//	new DRPItem("rhubarb_cut", "food/vegetables/cut", 64),
//	new DRPItem("spinach", "food/vegetables", 64),
//	new DRPItem("spinach_cut", "food/vegetables/cut", 64),
//	new DRPItem("sugar_beet", "food/vegetables", 64),
//	new DRPItem("sugar_beet_cut", "food/vegetables/cut", 64),
//	new DRPItem("sweet_potato", "food/vegetables", 64),
//	new DRPItem("sweet_potato_cut", "food/vegetables/cut", 64),
//	new DRPItem("sweet_potato_peeled", "food/vegetables/peeled", 64),
//	new DRPItem("white_cabbage", "food/vegetables", 64),
//	new DRPItem("white_cabbage_cut", "food/vegetables/cut", 64),
//	new DRPItem("zucchini", "food/vegetables", 64),
//	new DRPItem("zucchini_cut", "food/vegetables/cut", 64),
//	new DRPItem("zucchini_peeled", "food/vegetables/peeled", 64),

//	new PoleWeapon("halberd", "equipment/weapons/pole_weapons", 20),
//	new DRPEquip("quiver", "quivers", DRPEquip.TYPE.TYPE_AMMO_STORAGE),
//	new DRPEquip("leather_purse", "purses", DRPEquip.TYPE.TYPE_MONEY_STORAGE),
//	new DRPEquip("ring_bronze", "rings", DRPEquip.TYPE.TYPE_RING),
//	new DRPEquip("ring_silver", "rings", DRPEquip.TYPE.TYPE_RING),
//	new DRPEquip("ring_golden", "rings", DRPEquip.TYPE.TYPE_RING),