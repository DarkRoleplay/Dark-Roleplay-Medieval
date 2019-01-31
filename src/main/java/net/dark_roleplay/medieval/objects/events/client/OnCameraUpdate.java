package net.dark_roleplay.medieval.objects.events.client;

import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.objects.guis.telescope.GuiTelescope;
import net.dark_roleplay.medieval.objects.items.consumables.tools.Telescope;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class OnCameraUpdate {

	public static final GuiTelescope telescope = new GuiTelescope();

	@SubscribeEvent
	public static void CamerUpdate(EntityViewRenderEvent.FOVModifier event){
		if(DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL != 0){
			if((((EntityPlayer)event.getEntity()).getHeldItemMainhand().getItem() instanceof Telescope) && (Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)) {
				Minecraft.getMinecraft().gameSettings.smoothCamera = true;
				switch(DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL){
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
				DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL = 0;
				Minecraft.getMinecraft().gameSettings.smoothCamera = false;
			}
		}
	}

	@SubscribeEvent
	public static void GameOverlay(RenderGameOverlayEvent.Post event){
		if((event.getType() == RenderGameOverlayEvent.ElementType.HELMET) && (DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL != 0) && (Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof Telescope)){
			OnCameraUpdate.telescope.draw(Minecraft.getMinecraft());
		}
	}

	@SubscribeEvent
	public static void GameOverlay(RenderHandEvent event){
		if((DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL != 0) && (Minecraft.getMinecraft().player.getHeldItemMainhand().getItem() instanceof Telescope)){
			event.setCanceled(true);
		}
	}
}
