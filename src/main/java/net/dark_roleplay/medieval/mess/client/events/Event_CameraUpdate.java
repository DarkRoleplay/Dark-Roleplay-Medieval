package net.dark_roleplay.medieval.mess.client.events;

import net.dark_roleplay.medieval.mess.client.ClientProxy;
import net.dark_roleplay.medieval.mess.client.gui.telescope.Gui_Telescope;
import net.dark_roleplay.medieval.mess.common.objects.items.Telescope;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_CameraUpdate {

	public static final Gui_Telescope telescope = new Gui_Telescope();
	
	@SubscribeEvent
	public void CamerUpdate(EntityViewRenderEvent.CameraSetup event){
//		event.
	}
	
	@SubscribeEvent
	public void CamerUpdate(EntityViewRenderEvent.FOVModifier event){
		if(ClientProxy.telescopeLevel != 0){
			if((((EntityPlayer)event.getEntity()).getHeldItemMainhand().getItem() instanceof Telescope) && (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)) {
				Minecraft.getMinecraft().gameSettings.smoothCamera = true;
				switch(ClientProxy.telescopeLevel){
					case 1:
						event.setFOV(50F);
						break;
					case 2:
						event.setFOV(30F);
						break;
					case 3:
						event.setFOV(10F);
						break;
				}
			}else{
				ClientProxy.telescopeLevel = 0;
				Minecraft.getMinecraft().gameSettings.smoothCamera = false;
			}
		}
	}
	
	@SubscribeEvent
	public void GameOverlay(RenderGameOverlayEvent.Post event){
		if((event.getType() == RenderGameOverlayEvent.ElementType.HELMET) && (ClientProxy.telescopeLevel != 0) && (Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof Telescope)){
			Event_CameraUpdate.telescope.draw(Minecraft.getMinecraft());
		}
	}
	
	@SubscribeEvent
	public void GameOverlay(RenderHandEvent event){
		if((ClientProxy.telescopeLevel != 0) && (Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof Telescope)){
			event.setCanceled(true);
		}
	}
}
 