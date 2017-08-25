package net.dark_roleplay.medieval.common.events.blocks;

import net.dark_roleplay.drpcore.common.capabilities.player.skill.ISkillController;
import net.dark_roleplay.drpcore.common.handler.DRPCoreCapabilities;
import net.dark_roleplay.drpcore.common.handler.DRPCoreSkills;
import net.dark_roleplay.medieval.common.handler.DRPMedievalSkills;
import net.dark_roleplay.medieval.common.skills.lumberjack.TreeCutting;
import net.minecraft.block.BlockLog;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_BlockBreak {
	@SubscribeEvent
    public void breakBlock(BlockEvent.BreakEvent event){
		if(event.getState().getBlock() instanceof BlockLog && ((ISkillController)event.getPlayer().getCapability(DRPCoreCapabilities.DRPCORE_SKILL_CONTROLLER, null)).hasSkill(DRPMedievalSkills.BASIC_CARPENTING)){
			TreeCutting.cutTree(event.getWorld(), event.getPos(), event.getPlayer());
		}
	}
}
