package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.objects.blocks.TorchHolder;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = DarkRoleplayMedieval.MODID, bus = Bus.MOD)
public class BlockRegistryHandler {

	private static IForgeRegistry<Block> registry = null;

	private static Block.Properties PLACEHOLDER = Block.Properties.create(Material.WOOD);
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Block> registryEvent) {
		registry = registryEvent.getRegistry();
		
		reg(new TorchHolder(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F, 3.0F).sound(SoundType.METAL)), "torch_holder");
	}
	
	protected static void reg(Block block, String registryName) {
		block.setRegistryName(new ResourceLocation(DarkRoleplayMedieval.MODID, registryName));
		registry.register(block);
	}
}
