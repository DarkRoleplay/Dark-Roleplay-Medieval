package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
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

	protected static final VillagerRegistry.VillagerProfession PROFESSION_CARPENTER = DRPMedievalVillagers.createProf(new ResourceLocation(DRPMedievalInfo.MODID, "carpenter"), new ResourceLocation(DRPMedievalInfo.MODID, "textures/entities/villager/carpenter.png"), new ResourceLocation(DRPMedievalInfo.MODID, "textures/entities/villager/zombie/carpenter.png") );
    protected static final VillagerRegistry.VillagerCareer CAREER_CARPENTER = DRPMedievalVillagers.createCarrer(DRPMedievalVillagers.PROFESSION_CARPENTER, new ResourceLocation(DRPMedievalInfo.MODID, "carpenter"));  
	
	public static void init(FMLPreInitializationEvent event) {

	}
	
	public static void init(FMLInitializationEvent event) {
		DRPMedievalVillagers.CAREER_CARPENTER.addTrade(1, new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 0), new EntityVillager.PriceInfo(1,2)),
				new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 1), new EntityVillager.PriceInfo(1,2)),
				new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 2), new EntityVillager.PriceInfo(1,2)),
				new EmeraldsForStacks(new ItemStack(Blocks.LOG, 16, 3), new EntityVillager.PriceInfo(1,2)),
				new EmeraldsForStacks(new ItemStack(Blocks.LOG2, 16, 0), new EntityVillager.PriceInfo(1,2)),
				new EmeraldsForStacks(new ItemStack(Blocks.LOG2, 16, 1), new EntityVillager.PriceInfo(1,2)));
		
        //VillagerRegistry.instance().register(DRPMedievalVillagers.PROFESSION_CARPENTER);
	}
	
	public static void init(FMLPostInitializationEvent event) {
		
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
