package net.dark_roleplay.medieval.common.testing.protection;

import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class Event_WorldChange {

	@SubscribeEvent
	public void onEntityDrop(BlockEvent.BreakEvent event) {
//		if(ProtectionHelper.isProtected(event.getWorld(), event.getPos())) {
//			event.setCanceled(true);
//		}
	}
	
}
