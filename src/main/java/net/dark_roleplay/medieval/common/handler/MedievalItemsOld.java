package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.library.util.InDevUtil;
import net.dark_roleplay.medieval.References;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@EventBusSubscriber(modid = References.MODID)
@ObjectHolder(References.MODID)
public class MedievalItemsOld {

	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Item> registryEvent) {
		if(InDevUtil.isDevEnv()) {

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
}
