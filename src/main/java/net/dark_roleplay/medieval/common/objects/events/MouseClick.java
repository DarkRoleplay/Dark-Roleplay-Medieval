package net.dark_roleplay.medieval.common.objects.events;

import org.lwjgl.input.Mouse;

import net.dark_roleplay.medieval.References;
import net.dark_roleplay.medieval.common.handler.MedievalItems;
import net.dark_roleplay.medieval.common.handler.MedievalPackets;
import net.dark_roleplay.medieval.common.objects.packets.other.MergeCoins;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class MouseClick {

	@SubscribeEvent
	public static void onRightClick(GuiScreenEvent.MouseInputEvent.Pre event) {
		if(Mouse.getEventButton() != 1 || !Mouse.getEventButtonState()) return;
	 	Minecraft mc = Minecraft.getMinecraft();
		GuiScreen gui = event.getGui();
		if(gui instanceof GuiContainer) {
			GuiContainer container = (GuiContainer) gui;
			Slot under = container.getSlotUnderMouse();
			ItemStack held = mc.player.inventory.getItemStack();
			if(under != null && !held.isEmpty() && under.inventory == mc.player.inventory) {
				ItemStack stack = under.getStack();
				if(ItemStack.areItemStacksEqualUsingNBTShareTag(held, stack)) {
					if(stack.getCount() == 50) {
						if(stack.getItem() == MedievalItems.COIN_BRONZE || stack.getItem() == MedievalItems.COIN_SILVER) {
							MedievalPackets.sendToServer(new MergeCoins(under.getSlotIndex()));
							event.setCanceled(true);
							mc.player.inventory.setItemStack(ItemStack.EMPTY);
						}
					}
				}
			}
		}
	}

}
