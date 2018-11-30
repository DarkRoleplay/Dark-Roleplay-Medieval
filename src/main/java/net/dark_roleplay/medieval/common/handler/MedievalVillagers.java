package net.dark_roleplay.medieval.common.handler;

import java.util.Random;

import net.dark_roleplay.medieval.References;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityVillager.PriceInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

@EventBusSubscriber(modid = References.MODID)
@ObjectHolder(value = References.MODID)
public class MedievalVillagers {

	public static final VillagerRegistry.VillagerProfession CARPENTER = null;

	private static VillagerRegistry.VillagerCareer CARPENTER_TIMBERER;

	public static void init(FMLInitializationEvent event) {
		CARPENTER_TIMBERER.addTrade(1,
			new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 0), new PriceInfo(1,2)),
			new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 1), new PriceInfo(1,2)),
			new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 2), new PriceInfo(1,2)),
			new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 3), new PriceInfo(1,2)),
			new EmeraldsForStacks(new ItemStack(Blocks.LOG2, 16, 0), new PriceInfo(1,2)),
			new EmeraldsForStacks(new ItemStack(Blocks.LOG2, 16, 1), new PriceInfo(1,2))
		);
	}

	@SubscribeEvent
	public static void registerVillager(RegistryEvent.Register<VillagerRegistry.VillagerProfession> e) {
		VillagerRegistry.VillagerProfession carpenter = createProf(new ResourceLocation(References.MODID, "carpenter"), new ResourceLocation(References.MODID, "textures/entities/villager/carpenter.png"), new ResourceLocation(References.MODID, "textures/entities/villager/zombie/carpenter.png"));
		CARPENTER_TIMBERER = createCarrer(carpenter, new ResourceLocation(References.MODID, "carpenter"));
		e.getRegistry().register(
			carpenter
		);
	}

	public static VillagerRegistry.VillagerProfession createProf(ResourceLocation name, ResourceLocation textureVillager, ResourceLocation textureZombie){
		return new VillagerRegistry.VillagerProfession(name.getNamespace() + ":" + name.getPath(),
				textureVillager.getNamespace() + ":" + textureVillager.getPath(),
				textureZombie.getNamespace() + ":" + textureZombie.getPath());
	}

	public static VillagerRegistry.VillagerCareer createCarrer(VillagerRegistry.VillagerProfession prof, ResourceLocation name){
		return new VillagerRegistry.VillagerCareer(prof, name.getNamespace() + ":" + name.getPath());
	}

	public static class EmeraldsForStacks implements EntityVillager.ITradeList{
	    public ItemStack stack1;
	    public ItemStack stack2;
	    public EntityVillager.PriceInfo price;

	    public EmeraldsForStacks(ItemStack stack1, EntityVillager.PriceInfo price){
	        this.stack1 = stack1;
	        this.price = price;
	    }

	    public EmeraldsForStacks(ItemStack stack1, ItemStack stack2, EntityVillager.PriceInfo price){
	        this.stack1 = stack1;
	        this.stack2 = stack2;
	        this.price = price;
	    }

	    @Override
		public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random){
	        int i = 1;

	        if (this.price != null){
	            i = this.price.getPrice(random);
	        }

	        if(this.stack2 != null) {
				recipeList.add(new MerchantRecipe(this.stack1, this.stack2, new ItemStack(Items.EMERALD, i, 0)));
			} else {
				recipeList.add(new MerchantRecipe(this.stack1, new ItemStack(Items.EMERALD, i, 0)));
			}
	    }
	}

}
