package net.dark_roleplay.medieval.objects.events;

import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.objects.enums.TelescopeZoom;
import net.dark_roleplay.medieval.objects.guis.TelescopeOverlay;
import net.dark_roleplay.medieval.objects.helper.TelescopeHelper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = DarkRoleplayMedieval.MODID, value = Dist.CLIENT)
public class TelescopeEvents {

	public static final TelescopeOverlay telescope = new TelescopeOverlay();
	
	private static SmoothCameraStage prevSmoothCamera = SmoothCameraStage.UNKNOWN;
	
	@SubscribeEvent
	public static void updateFov(EntityViewRenderEvent.FOVModifier event) {
		TelescopeZoom zoom = TelescopeHelper.getCurrentZoom();
		if(zoom == TelescopeZoom.LOW) event.setFOV(50);
		else if(zoom == TelescopeZoom.MEDIUM) event.setFOV(30);
		else if(zoom == TelescopeZoom.HIGH) event.setFOV(10);
		else if(prevSmoothCamera != SmoothCameraStage.UNKNOWN){
			Minecraft.getInstance().gameSettings.smoothCamera = prevSmoothCamera == SmoothCameraStage.TRUE ? true : false;
			prevSmoothCamera = SmoothCameraStage.UNKNOWN;
			return;
		}else return;
		
		if(SmoothCameraStage.UNKNOWN == prevSmoothCamera)
			prevSmoothCamera = Minecraft.getInstance().gameSettings.smoothCamera ? SmoothCameraStage.TRUE : SmoothCameraStage.FALSE;
		Minecraft.getInstance().gameSettings.smoothCamera = true;
	}

	@SubscribeEvent
	public static void GameOverlay(RenderGameOverlayEvent.Post event){
		if(TelescopeHelper.getCurrentZoom() != TelescopeZoom.NONE){
			telescope.draw(Minecraft.getInstance());
		}
	}
	
	@SubscribeEvent
	public static void GameOverlay(RenderHandEvent event){
		if(TelescopeHelper.getCurrentZoom() != TelescopeZoom.NONE){
			event.setCanceled(true);
		}
	}
	
	private static enum SmoothCameraStage{ 
		UNKNOWN,
		FALSE,
		TRUE;
	}
}