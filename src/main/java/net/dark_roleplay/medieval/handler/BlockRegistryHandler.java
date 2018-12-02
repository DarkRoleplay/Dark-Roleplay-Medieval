package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.library.experimental.blocks.DRPBlock;
import net.dark_roleplay.library.experimental.blocks.behaviors.IBoundingBoxBehavior;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.handler.MedievalCreativeTabs;
import net.dark_roleplay.medieval.common.handler.MedievalModels;
import net.dark_roleplay.medieval.common.objects.blocks.BlockProperties;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.advent_wreath.CandleLighting;
import net.dark_roleplay.medieval.common.objects.blocks.behaviors.placing.CeilingRequired;
import net.dark_roleplay.medieval.common.objects.blocks.special.AdventWreath;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
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
			new DRPBlock("mistletoe", BlockProperties.Settings.PLANT_DECO) {
				@Override public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {return NULL_AABB;}
			}.addBehaviors(CeilingRequired.INSTANCE, new IBoundingBoxBehavior.SimpleImpl(new AxisAlignedBB(0.25F, 0.1875F, 0.25F, 0.75F, 1.0F, 0.75F))),

			new AdventWreath("advent_wreath", BlockProperties.Settings.PLANT_DECO).addBehaviors(new CandleLighting()) //TODO Make behavior Singleton
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
