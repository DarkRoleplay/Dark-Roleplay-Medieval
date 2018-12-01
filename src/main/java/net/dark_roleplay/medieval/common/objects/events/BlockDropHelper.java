package net.dark_roleplay.medieval.common.objects.events;

import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.holders.MedievalBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = References.MODID)
public class BlockDropHelper {

	@SubscribeEvent
    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {
		if(event.getState().getBlock() == Blocks.LEAVES) {
			int meta = event.getState().getBlock().getMetaFromState(event.getState()) % 4;
			if(meta == 0 || meta == 2) {
				if(event.getWorld().rand.nextFloat() < 0.00075)
					event.getDrops().add(new ItemStack(MedievalBlocks.MISTLETOE));
			}
		}
    }

}
