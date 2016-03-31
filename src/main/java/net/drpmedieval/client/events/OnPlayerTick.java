package net.drpmedieval.client.events;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.util.UpdateCheck;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class OnPlayerTick {

	private boolean hasShownUp = false;
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event){
		if(UpdateCheck.isNewVersionAvailable() && !hasShownUp /*&& Minecraft.getMinecraft().currentScreen == null*/){
			ClickEvent downloadURL = new ClickEvent(Action.OPEN_URL, UpdateCheck.getDownloadURL());
			ClickEvent changelogURL = new ClickEvent(Action.OPEN_URL, UpdateCheck.getChangelogURL());
 			 
			ChatComponentText separator = new ChatComponentText(EnumChatFormatting.DARK_PURPLE + "-------------------------------------");
			ChatComponentText line1 = new ChatComponentText(EnumChatFormatting.GOLD + "Dark Roleplay Medieval:");
			ChatComponentText line2 = new ChatComponentText(EnumChatFormatting.GOLD + "There is a new Version available!");
			ChatComponentText line3 = new ChatComponentText(EnumChatFormatting.GOLD + "Your version: "+DarkRoleplayMedieval.VERSION + " latest version: "+ UpdateCheck.getVersion());
			ChatComponentText line4 = new ChatComponentText(EnumChatFormatting.GOLD + "Click here to open the download page");
			ChatComponentText line5 = new ChatComponentText(EnumChatFormatting.GOLD + "Click here to open the changelog");
			
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
