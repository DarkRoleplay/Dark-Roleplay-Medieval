package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.core_modules.maarg.api.arg.MaterialRequirements;
import net.dark_roleplay.library.util.InDevUtil;
import net.dark_roleplay.library_old.items.DRPItem;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.objects.items.ItemMultiBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = References.MODID)
@ObjectHolder(References.MODID)
public class MedievalItemsOld {

	//Items

	public static final Item TIMBERED_CLAY = null;;
	public static final Item HANGING_BRIDGE = null;
;
	public static final Item BLACK_PAINTBRUSH = null;

	public static final Item SPINDLE = null;
	public static final Item BARLEY = null;
	public static final Item LANTERN = null;
	public static final Item BEESWAX_CANDLE = null;

	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Item> registryEvent) {
		IForgeRegistry<Item> reg = registryEvent.getRegistry();

		MaterialRequirements logRequired = new MaterialRequirements("log_side", "log_top");
		MaterialRequirements planksRequired = new MaterialRequirements("plank");
		MaterialRequirements cleanPlankRequired = new MaterialRequirements("clean_plank");

		register(reg, MedievalCreativeTabs.MATERIALS,
				new DRPItem("barley", "cereals", 64)
			);

		register(reg, MedievalCreativeTabs.UTILITY,
				new ItemMultiBlock(MedievalBlocks.SIMPLE_CARPENTER_WORKBENCH).setRegistryName("simple_carpenter_workbench"),
				new ItemMultiBlock(MedievalBlocks.FORGE).setRegistryName("forge")
		);

		register(reg, MedievalCreativeTabs.BUILDING_MATS,
				new ItemBlock(MedievalBlocks.OAK_TIMBERED_CLAY_CLEAN).setRegistryName("timbered_clay"));


		if(InDevUtil.isDevEnv()) {
			register(reg, MedievalCreativeTabs.MATERIALS,
				new DRPItem("stone_brick", "misc", 64),
				new DRPItem("beeswax", "misc", 64),
				new DRPItem("empty_frame", "misc/apiary_frames", 1),
				new DRPItem("honey_frame", "misc/apiary_frames", 1),
				new DRPItem("brute_frame", "misc/apiary_frames", 1),
				new DRPItem("sugar_frame", "misc/apiary_frames", 1),
				new DRPItem("wax_frame", "misc/apiary_frames", 1)
			);

//			new DRPItem("asparagus", "food/vegetables", 64),
//			new DRPItem("asparagus_cut", "food/vegetables/cut", 64),
//			new DRPItem("asparagus_peeled", "food/vegetables/peeled", 64),
//			new DRPItem("aubergine", "food/vegetables", 64),
//			new DRPItem("aubergine_cut", "food/vegetables/cut", 64),
//			new DRPItem("aubergine_peeled", "food/vegetables/peeled", 64),
//			new DRPItem("bean_pod", "food/vegetables", 64),
//			new DRPItem("beans", "food/vegetables/peeled", 64),
//			new DRPItem("bell_pepper", "food/vegetables", 64),
//			new DRPItem("bell_pepper_cut", "food/vegetables/cut", 64),
//			new DRPItem("broccoli", "food/vegetables", 64),
//			new DRPItem("broccoli_cut", "food/vegetables/cut", 64),
//			new DRPItem("brussel_sprouts", "food/vegetables", 64),
//			new DRPItem("brussel_sprouts_cut", "food/vegetables/cut", 64),
//			new DRPItem("cantaloupe", "food/vegetables", 64),
//			new DRPItem("cantaloupe_cut", "food/vegetables/cut", 64),
//			new DRPItem("cantaloupe_peeled", "food/vegetables/peeled", 64),
//			//new DRPItem("carrot", "food/vegetables", 64),
//			new DRPItem("carrot_cut", "food/vegetables/cut", 64),
//			new DRPItem("carrot_peeled", "food/vegetables/peeled", 64),
//			new DRPItem("cauliflower_cut", "food/vegetables/cut", 64),
//			new DRPItem("celery", "food/vegetables", 64),
//			new DRPItem("celery_cut", "food/vegetables/cut", 64),
//			new DRPItem("cucumber", "food/vegetables", 64),
//			new DRPItem("cucumber_cut", "food/vegetables/cut", 64),
//			new DRPItem("cucumber_peeled", "food/vegetables/peeled", 64),
//			new DRPItem("garlic_cut", "food/vegetables/cut", 64),
//			new DRPItem("garlic_peeled", "food/vegetables/peeled", 64),
//			new DRPItem("horseradish", "food/vegetables", 64),
//			new DRPItem("horseradish_cut", "food/vegetables/cut", 64),
//			new DRPItem("jute", "food/other", 64),
//			new DRPItem("kohlrabi", "food/vegetables", 64),
//			new DRPItem("kohlrabi_cut", "food/vegetables/cut", 64),
//			new DRPItem("kohlrabi_peeled", "food/vegetables/peeled", 64),
//			new DRPItem("leek", "food/vegetables", 64),
//			new DRPItem("leek_cut", "food/vegetables/cut", 64),
//			new DRPItem("lentil", "food/vegetables", 64),
//			new DRPItem("lettuce", "food/vegetables", 64),
//			new DRPItem("lettuce_cut", "food/vegetables/cut", 64),
//			new DRPItem("onion_cut", "food/vegetables/cut", 64),
//			new DRPItem("onion_peeled", "food/vegetables/peeled", 64),
//			new DRPItem("parsley", "food/herbs", 64),
//			new DRPItem("parsley_cut", "food/herbs/cut", 64),
//			new DRPItem("parsley_root", "food/vegetables", 64),
//			new DRPItem("parsley_root_cut", "food/vegetables/cut", 64),
//			new DRPItem("pea_pod", "food/vegetables", 64),
//			new DRPItem("pea_pod_cut", "food/vegetables/cut", 64),
//			new DRPItem("peas", "food/vegetables/peeled", 64),
//			//new DRPItem("potato", "food/vegetables", 64),
//			new DRPItem("potato_cut", "food/vegetables/cut", 64),
//			new DRPItem("potato_peeled", "food/vegetables/peeled", 64),
//			//new DRPItem("red_beet", "food/vegetables", 64),
//			new DRPItem("red_beet_cut", "food/vegetables/cut", 64),
//			new DRPItem("red_beet_peeled", "food/vegetables/peeled", 64),
//			new DRPItem("red_cabbage", "food/vegetables", 64),
//			new DRPItem("red_cabbage_cut", "food/vegetables/cut", 64),
//			new DRPItem("rhubarb", "food/vegetables", 64),
//			new DRPItem("rhubarb_cut", "food/vegetables/cut", 64),
//			new DRPItem("spinach", "food/vegetables", 64),
//			new DRPItem("spinach_cut", "food/vegetables/cut", 64),
//			new DRPItem("sugar_beet", "food/vegetables", 64),
//			new DRPItem("sugar_beet_cut", "food/vegetables/cut", 64),
//			new DRPItem("sweet_potato", "food/vegetables", 64),
//			new DRPItem("sweet_potato_cut", "food/vegetables/cut", 64),
//			new DRPItem("sweet_potato_peeled", "food/vegetables/peeled", 64),
//			new DRPItem("white_cabbage", "food/vegetables", 64),
//			new DRPItem("white_cabbage_cut", "food/vegetables/cut", 64),
//			new DRPItem("zucchini", "food/vegetables", 64),
//			new DRPItem("zucchini_cut", "food/vegetables/cut", 64),
//			new DRPItem("zucchini_peeled", "food/vegetables/peeled", 64),

//			new PoleWeapon("halberd", "equipment/weapons/pole_weapons", 20),
//			new DRPEquip("quiver", "quivers", DRPEquip.TYPE.TYPE_AMMO_STORAGE),
//			new DRPEquip("leather_purse", "purses", DRPEquip.TYPE.TYPE_MONEY_STORAGE),
//			new DRPEquip("ring_bronze", "rings", DRPEquip.TYPE.TYPE_RING),
//			new DRPEquip("ring_silver", "rings", DRPEquip.TYPE.TYPE_RING),
//			new DRPEquip("ring_golden", "rings", DRPEquip.TYPE.TYPE_RING),
		}
	}

	protected static void register(IForgeRegistry<Item> reg, CreativeTabs creativeTab, Item... items){
		for(Item item : items)
			item.setCreativeTab(creativeTab);
		reg.registerAll(items);
	}
}
