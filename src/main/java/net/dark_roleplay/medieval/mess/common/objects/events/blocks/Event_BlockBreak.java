package net.dark_roleplay.medieval.mess.common.objects.events.blocks;

import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_BlockBreak {
	@SubscribeEvent
    public void breakBlock(BlockEvent.BreakEvent event){
//		if(event.getState().getBlock() instanceof BlockLog && ((ISkillController)event.getPlayer().getCapability(DRPCoreCapabilities.DRPCORE_SKILL_CONTROLLER, null)).hasSkill(DRPMedievalSkills.BASIC_CARPENTING)){
//			TreeCutting.cutTree(event.getWorld(), event.getPos(), event.getPlayer());
//		}
	}
}
