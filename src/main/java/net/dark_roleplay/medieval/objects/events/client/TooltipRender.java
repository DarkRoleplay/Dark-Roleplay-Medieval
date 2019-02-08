package net.dark_roleplay.medieval.objects.events.client;

import net.dark_roleplay.medieval.References;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = References.MODID, value = Side.CLIENT)
public class TooltipRender extends Gui {

	@SubscribeEvent
	public static void toolTipColor(RenderTooltipEvent.Color event) {
		event.setBorderStart(0xFF00FF00);
		event.setBorderEnd(0xFF00FF00);
	}

	@SubscribeEvent
	public static void tooltip(ItemTooltipEvent event) {
		event.getToolTip().add("");
		event.getToolTip().add("");
		event.getToolTip().add("");
		event.getToolTip().add("");
		event.getToolTip().add("                                      ");
	}

	@SubscribeEvent
	public static void tooltip(RenderTooltipEvent.PostText event) {
//		Gui.drawRect(event.getX() + 1, event.getY() + event.getHeight() - 48, event.getX() + 150, event.getY() + event.getHeight(), 0xFFFFFFCC);
		event.getFontRenderer().drawString("This apple might be poisoned..", event.getX() + 3, event.getY() + event.getHeight() - 46, 0x0);
		event.getFontRenderer().drawString("Or not, you won't know while", event.getX() + 3, event.getY() + event.getHeight() - 38, 0x0);
		event.getFontRenderer().drawString("you're alive", event.getX() + 3, event.getY() + event.getHeight() - 30, 0x0);

	}

	@SubscribeEvent
	public static void tooltip(RenderTooltipEvent.PostBackground event) {
		Gui.drawRect(event.getX() + 1, event.getY() + event.getHeight() - 48, event.getX() + 150, event.getY() + event.getHeight(), 0xFFFFFFCC);
		GlStateManager.color(1F, 1F, 1F);
	}
}
