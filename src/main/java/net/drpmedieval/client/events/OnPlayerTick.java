package net.drpmedieval.client.events;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.util.LocalizedStringList;
import net.drpmedieval.common.util.UpdateCheck;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class OnPlayerTick {

	private boolean hasShownUp = false;

	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event) {

		if(UpdateCheck.isNewVersionAvailable() && !hasShownUp){
			ClickEvent downloadURL = new ClickEvent(Action.OPEN_URL, UpdateCheck.getDownloadURL());
			ClickEvent changelogURL = new ClickEvent(Action.OPEN_URL, UpdateCheck.getChangelogURL());

			ChatComponentText separator = new ChatComponentText(EnumChatFormatting.DARK_PURPLE + "-------------------------------------");
			ChatComponentText line1 = new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal(LocalizedStringList.modName)+":");
			ChatComponentText line2 = new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal(LocalizedStringList.updateNewVersionAvailable));
			ChatComponentText line3 = new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal(LocalizedStringList.updateCurrentVersion)+": " + DarkRoleplayMedieval.VERSION + StatCollector.translateToLocal(LocalizedStringList.updateLatestVersion)+": " + UpdateCheck.getVersion());
			ChatComponentText line4 = new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal(LocalizedStringList.updateOpenDownload));
			ChatComponentText line5 = new ChatComponentText(EnumChatFormatting.GOLD + StatCollector.translateToLocal(LocalizedStringList.updateOpenChangelog));

			line4.getChatStyle().setChatClickEvent(downloadURL);
			line5.getChatStyle().setChatClickEvent(changelogURL);

			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(separator);
			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(line1);
			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(line2);
			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(line3);
			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(line4);
			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(line5);
			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(separator);
			hasShownUp = true;
		}
	}
}
