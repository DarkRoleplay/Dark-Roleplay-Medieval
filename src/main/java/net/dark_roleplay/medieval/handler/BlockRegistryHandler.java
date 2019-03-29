package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.drpmarg.api.Constants;
import net.dark_roleplay.drpmarg.api.MaterialRequirements;
import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.objects.blocks.decoration.benches.BenchBlock;
import net.dark_roleplay.medieval.objects.blocks.decoration.chairs.PlankChairBlock;
import net.dark_roleplay.medieval.objects.blocks.decoration.chairs.SolidChairArmrestBlock;
import net.dark_roleplay.medieval.objects.blocks.decoration.chairs.SolidChairBlock;
import net.dark_roleplay.medieval.objects.blocks.decoration.light_sources.TorchHolderBlock;
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
		
		reg(new TorchHolderBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(4.0F, 3.0F).sound(SoundType.METAL)), "torch_holder");

		MaterialRequirements planks = new MaterialRequirements(Constants.MAT_WOOD, "planks");
		
		planks.execute(material -> {
			reg(new PlankChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(4.0F, 3.0F).sound(SoundType.WOOD)), String.format("%s_plank_chair", material.getName()));
			reg(new SolidChairBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(4.0F, 3.0F).sound(SoundType.WOOD)), String.format("%s_solid_chair", material.getName()));
			reg(new SolidChairArmrestBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(4.0F, 3.0F).sound(SoundType.WOOD)), String.format("%s_solid_chair_armrest", material.getName()));
			reg(new BenchBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(4.0F, 3.0F).sound(SoundType.WOOD)), String.format("%s_solid_bench", material.getName()));

		});
	}
	
	protected static void reg(Block block, String registryName) {
		block.setRegistryName(new ResourceLocation(DarkRoleplayMedieval.MODID, registryName));
		registry.register(block);
	}
}
