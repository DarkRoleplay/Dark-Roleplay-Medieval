package net.dark_roleplay.medieval.one_twelve.objects.events.client;

//PORT to 1.13
//@EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class OnCameraUpdate {
//
//	public static final GuiTelescope telescope = new GuiTelescope();
//
//	@SubscribeEvent
//	public static void CamerUpdate(EntityViewRenderEvent.FOVModifier event){
//		if(DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL != 0){
//			if((((EntityPlayer)event.getEntity()).getHeldItemMainhand().getItem() instanceof Telescope) && (Minecraft.getInstance().gameSettings.thirdPersonView == 0)) {
//				Minecraft.getInstance().gameSettings.smoothCamera = true;
//				switch(DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL){
//					case 1:
//						event.setFOV(50F);
//						break;
//					case 2:
//						event.setFOV(30F);
//						break;
//					case 3:
//						event.setFOV(10F);
//						break;
//				}
//			}else{
//				DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL = 0;
//				Minecraft.getInstance().gameSettings.smoothCamera = false;
//			}
//		}
//	}
//
//	@SubscribeEvent
//	public static void GameOverlay(RenderGameOverlayEvent.Post event){
//		if((event.getType() == RenderGameOverlayEvent.ElementType.HELMET) && (DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL != 0) && (Minecraft.getInstance().player.getHeldItemMainhand().getItem() instanceof Telescope)){
//			OnCameraUpdate.telescope.draw(Minecraft.getInstance());
//		}
//	}
//
//	@SubscribeEvent
//	public static void GameOverlay(RenderHandEvent event){
//		if((DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL != 0) && (Minecraft.getInstance().player.getHeldItemMainhand().getItem() instanceof Telescope)){
//			event.setCanceled(true);
//		}
//	}
}
