package net.dark_roleplay.medieval.one_twelve.objects.events;

//PORT to 1.13
//@EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class MouseClick {
//
//	@SubscribeEvent
//	public static void onRightClick(GuiScreenEvent.MouseInputEvent.Pre event) {
//		if(Mouse.getEventButton() != 1 || !Mouse.getEventButtonState()) return;
//	 	Minecraft mc = Minecraft.getInstance();
//		GuiScreen gui = event.getGui();
//		if(gui instanceof GuiContainer) {
//			GuiContainer container = (GuiContainer) gui;
//			Slot under = container.getSlotUnderMouse();
//			ItemStack held = mc.player.inventory.getItemStack();
//			if(under != null && !held.isEmpty() && under.inventory == mc.player.inventory) {
//				ItemStack stack = under.getStack();
//				if(ItemStack.areItemStacksEqualUsingNBTShareTag(held, stack)) {
//					if(stack.getCount() == 50) {
//						if(stack.getItem() == MedievalItems.BRONZE_COIN || stack.getItem() == MedievalItems.SILVER_COIN) {
//							MedievalNetwork.sendToServer(new MergeCoins(under.getSlotIndex()));
//							event.setCanceled(true);
//							mc.player.inventory.setItemStack(ItemStack.EMPTY);
//						}
//					}
//				}
//			}
//		}
//	}

}
