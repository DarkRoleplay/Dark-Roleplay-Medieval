package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.core_modules.maarg.api.arg.MaterialRequirements;
import net.dark_roleplay.core_modules.maarg.api.materials.Material;
import net.dark_roleplay.core_modules.maarg.handler.MaterialRegistry;
import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties.Settings;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.Behavior_Chair;
import net.dark_roleplay.medieval.common.objects.blocks.blocks.FacedBlock;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = References.MODID)
@ObjectHolder(References.MODID)
public class MedievalBlocks {
	
	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Block> registryEvent) {
		IForgeRegistry<Block> reg = registryEvent.getRegistry();

		MaterialRequirements logRequired = new MaterialRequirements("log_side", "log_top");
		MaterialRequirements plankRequired = new MaterialRequirements("plank");
		MaterialRequirements cleanPlankRequired = new MaterialRequirements("clean_plank");
		
		for(Material mat : MaterialRegistry.getMaterialsForType("wood")){
			if(plankRequired.doesFulfillRequirements(mat)) {
				
				registerNoItems(reg, 
					new FacedBlock(mat.getName() + "_barrel_chair", Settings.WOOD_DECO).setActivatedBehavior(new Behavior_Chair()),
					new DRPBlock(mat.getName() + "_barrel_table", Settings.WOOD_DECO)
				);
			}
		}
		
		//Crafting Stations Tab
		registerNoItems(reg, 
			new FacedBlock("butter_churn", Settings.WOOD_DECO)	
		);
		
		//Storage Tab

//		new StonePillar("andesite_pillar"),
//		new AdvancedOre("copper_ore", 1),
//		new StonePillar("diorite_pillar"),
//		new StonePillar("granite_pillar"),
		//Building Blocks Tab
		registerNoItems(registryEvent.getRegistry(), 
			new DRPBlock("andesite_bricks", Settings.STONE_SOLID),
			new DRPBlock("diorite_bricks", Settings.STONE_SOLID),
			new DRPBlock("granite_bricks", Settings.STONE_SOLID),
			new DRPBlock("snow_bricks", Settings.SNOW_SOLID)
		);

		if(References.IS_DEV) {
			
		}
	}

	protected static void register(IForgeRegistry<Block> reg, CreativeTabs creativeTab, Block... blocks){
		for(Block block : blocks){
			block.setCreativeTab(creativeTab);
//			ItemBlock itemBlock = (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
//			DRPMedievalItems.addBlockItem(itemBlock);
//			DRPMedievalModels.addItemToRegisterMesh(itemBlock);
		}
		reg.registerAll(blocks);
	}
	
	protected static void registerNoItems(IForgeRegistry<Block> reg, Block... blocks){
		reg.registerAll(blocks);
	}
}
