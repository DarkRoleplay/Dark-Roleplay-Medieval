package net.dark_roleplay.medieval.client.events;

import net.dark_roleplay.drpcore.common.handler.DRPCoreConfigs;
import net.dark_roleplay.medieval.client.gui.info.Gui_UpdateAvailable;
import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.ForgeVersion.Status;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_GuiOpen {

	public static boolean hasOpened = false;
	
	@SubscribeEvent
	public void onEvent(GuiOpenEvent  event) {
		if(!hasOpened && event.getGui() instanceof GuiMainMenu){
			if(DRPCoreConfigs.GENERAL.UPDATE_GUI && DRPMedievalInfo.VERSION_STATUS.status == Status.OUTDATED || DRPMedievalInfo.VERSION_STATUS.status == Status.BETA_OUTDATED){
				event.setGui(new Gui_UpdateAvailable());
				hasOpened = true;
			}
		}
	}
	
}
