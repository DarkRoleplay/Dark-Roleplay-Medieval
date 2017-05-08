package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.DRPInfo;
import net.dark_roleplay.medieval.common.villager.EmeraldsForStacks;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class DRPMedievalVillagers {

	protected static final VillagerRegistry.VillagerProfession PROFESSION_CARPENTER = DRPMedievalVillagers.createProf(new ResourceLocation(DRPInfo.MODID, "carpenter"), new ResourceLocation(DRPInfo.MODID, "textures/entities/villager/carpenter.png"), new ResourceLocation(DRPInfo.MODID, "textures/entities/villager/zombie/carpenter.png") );
    protected static final VillagerRegistry.VillagerCareer CAREER_CARPENTER = DRPMedievalVillagers.createCarrer(DRPMedievalVillagers.PROFESSION_CARPENTER, new ResourceLocation(DRPInfo.MODID, "carpenter"));
//	.addTrade(3, new ListItemForEmeralds(MoDropsItems.adaptive_egg, new PriceInfo(26, 33)))
//	.addTrade(1, new EmeraldForItems(Items.GOLD_INGOT, new PriceInfo(8, 9)))
//	.addTrade(1, new ListItemForEmeralds(MoDropsItems.biomatter, new PriceInfo(1, 1)))
//	.addTrade(2, new ListItemForEmeralds(MoDropsItems.compressed_biomatter, new PriceInfo(8, 10)))
//  		.addTrade(2, new ListItemForEmeralds(Charcoal, new PriceInfo(1, 3)));   
  
	
	public static void preInit(FMLPreInitializationEvent event) {

	}
	
	public static void init(FMLInitializationEvent event) {
		DRPMedievalVillagers.CAREER_CARPENTER.addTrade(1, new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 0), new EntityVillager.PriceInfo(1,2)),
				new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 1), new EntityVillager.PriceInfo(1,2)),
				new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 2), new EntityVillager.PriceInfo(1,2)),
				new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 3), new EntityVillager.PriceInfo(1,2)),
				new EmeraldsForStacks(new ItemStack(Blocks.LOG2, 16, 0), new EntityVillager.PriceInfo(1,2)),
				new EmeraldsForStacks(new ItemStack(Blocks.LOG2, 16, 1), new EntityVillager.PriceInfo(1,2)));


		
		
        VillagerRegistry.instance().register(DRPMedievalVillagers.PROFESSION_CARPENTER);
	}
	
	public static void postInit(FMLPostInitializationEvent event) {
		
	}


	
	public static VillagerRegistry.VillagerProfession createProf(ResourceLocation name, ResourceLocation textureVillager, ResourceLocation textureZombie){
		return new VillagerRegistry.VillagerProfession(name.getResourceDomain() + ":" + name.getResourcePath(),
				textureVillager.getResourceDomain() + ":" + textureVillager.getResourcePath(),
				textureZombie.getResourceDomain() + ":" + textureZombie.getResourcePath());
	}
	
	public static VillagerRegistry.VillagerCareer createCarrer(VillagerRegistry.VillagerProfession prof, ResourceLocation name){
		return new VillagerRegistry.VillagerCareer(prof, name.getResourceDomain() + ":" + name.getResourcePath());
	}
}
