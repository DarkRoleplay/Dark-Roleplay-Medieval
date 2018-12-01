package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.handler.MedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.MedievalModels;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = References.MODID)
public class BlockRegistryHandler {

	@SubscribeEvent
	public static final void register(RegistryEvent.Register<Block> registryEvent) {
		IForgeRegistry<Block> reg = registryEvent.getRegistry();

		register(reg, MedievalCreativeTabs.CHRISTMAS,
			new DRPBlock("mistletoe", BlockProperties.Settings.PLANT_DECO)
		);
	}

	private static void register(IForgeRegistry<Block> reg, CreativeTabs creativeTab, Block... blocks){
		for(Block block : blocks){
			block.setCreativeTab(creativeTab);
			ItemBlock itemBlock = (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
			ItemRegistryHandler.addBlockItem(itemBlock);
			MedievalModels.addItemToRegisterMesh(itemBlock);
		}
		reg.registerAll(blocks);
	}

	private static void registerNoItems(IForgeRegistry<Block> reg, Block... blocks){
		reg.registerAll(blocks);
	}
}
