package net.dark_roleplay.medieval.holders;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MedievalCreativeTabs {

	//TODO Updateh Items
	public static final ItemGroup DECORATION = new ItemGroup("drpmedieval.decoration") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(MedievalItems.OAK_SOLID_CHAIR_ARMREST);
		}
	};
	
//	public static final ItemGroup BUILDING_MATS = new ItemGroup("drpmedieval.building_materials") {
//		@OnlyIn(Dist.CLIENT)
//		public ItemStack createIcon() {
//			return new ItemStack(Blocks.POWERED_RAIL);
//		}
//	};
	
//	public static final ItemGroup UTILITY = new ItemGroup("drpmedieval.utility") {
//		@OnlyIn(Dist.CLIENT)
//		public ItemStack createIcon() {
//			return new ItemStack(Blocks.POWERED_RAIL);
//		}
//	};
	
	public static final ItemGroup FOOD = new ItemGroup("drpmedieval.food") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(MedievalItems.CARAMELIZED_RED_APPLE);
		}
	};
	
	public static final ItemGroup EQUIPMENT = new ItemGroup("drpmedieval.equipment") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(MedievalItems.GOLDEN_TELESCOPE);
		}
	};
	
	public static final ItemGroup MISCELLANEOUS = new ItemGroup("drpmedieval.miscellaneous") {
		@OnlyIn(Dist.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(MedievalItems.HAY);
		}
	};
	
//	public static final ItemGroup CREATIVE = new ItemGroup("drpmedieval.creative_only") {
//		@OnlyIn(Dist.CLIENT)
//		public ItemStack createIcon() {
//			return new ItemStack(Blocks.BARRIER.asItem());
//		}
//	};
}
