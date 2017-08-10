package net.dark_roleplay.medieval.client.gui.info;

import java.awt.Color;
import java.util.Map;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.ForgeVersion.CheckResult;
import net.minecraftforge.fml.common.versioning.ComparableVersion;

public class Gui_UpdateAvailaable extends GuiScreen{

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		this.drawDefaultBackground();
		
		FontRenderer font;
		font = this.fontRenderer;
		
		font.drawString("press \"ESC\" to close", 5, 5, new Color(255, 255, 255).getRGB());
		
		CheckResult status = DRPMedievalInfo.VERSION_STATUS;
		
		String updateMessage = "There is a new update available!\n\n\n";
		updateMessage += "Your version: " + DRPMedievalInfo.VERSION + "\n\n";
		updateMessage += "Target version: " + status.target.toString() + "\n\n\n";
		
		Map<ComparableVersion, String> changes = status.changes;
		
		if(changes.containsKey(status.target)){
			updateMessage += "Changelog:\n";
			updateMessage += changes.get(status.target) + "\n";
		}
		
		updateMessage += status.url;
		
		font.drawSplitString(updateMessage, (this.width / 2) - 150, (this.height / 2) - 75, 300, new Color(255, 255, 255).getRGB());
	
//		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//	    clipboard.setContents(selection, selection);
	}
	
}
