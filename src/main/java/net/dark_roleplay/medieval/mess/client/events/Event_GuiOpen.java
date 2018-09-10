package net.dark_roleplay.medieval.mess.client.events;

import net.dark_roleplay.core.common.handler.DRPCoreConfigs;
import net.dark_roleplay.medieval.mess.client.gui.info.Gui_UpdateAvailable;
import net.dark_roleplay.medieval.mess.common.References;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.ForgeVersion.Status;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_GuiOpen {

	public static boolean hasOpened = false;
	
	@SubscribeEvent
	public void onEvent(GuiOpenEvent  event) {
		if(!hasOpened && event.getGui() instanceof GuiMainMenu){
			if(DRPCoreConfigs.GENERAL.UPDATE_GUI && References.VERSION_STATUS.status == Status.OUTDATED || References.VERSION_STATUS.status == Status.BETA_OUTDATED){
				event.setGui(new Gui_UpdateAvailable());
				hasOpened = true;
			}
		}
	}
	
}
