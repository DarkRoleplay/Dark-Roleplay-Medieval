package net.dark_roleplay.medieval.mess.common.handler;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

import static net.minecraft.entity.passive.EntityVillager.PriceInfo;

import net.dark_roleplay.medieval.mess.common.References;
import net.dark_roleplay.medieval.mess.common.objects.entities.villager.EmeraldsForStacks;
import net.dark_roleplay.medieval.mess.common.objects.villagers.BasicTradeList;

@Mod.EventBusSubscriber(modid = References.MODID)
@ObjectHolder(value = References.MODID)
public class DRPMedievalVillagers {

	public static final VillagerRegistry.VillagerProfession CARPENTER = null;

	private static VillagerRegistry.VillagerCareer CARPENTER_TIMBERER;
	
	public static void init(FMLPreInitializationEvent event) {

	}
	
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
	
	public static void init(FMLPostInitializationEvent event) {
		
	}

	@SubscribeEvent
	public static void registerVillager(RegistryEvent.Register<VillagerRegistry.VillagerProfession> e) {
		VillagerRegistry.VillagerProfession carpenter = createProf(new ResourceLocation(References.MODID, "carpenter"), new ResourceLocation(References.MODID, "textures/entities/villager/carpenter.png"), new ResourceLocation(References.MODID, "textures/entities/villager/zombie/carpenter.png"));
		CARPENTER_TIMBERER = DRPMedievalVillagers.createCarrer(carpenter, new ResourceLocation(References.MODID, "carpenter"));  
		e.getRegistry().register(
			carpenter
		);
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
