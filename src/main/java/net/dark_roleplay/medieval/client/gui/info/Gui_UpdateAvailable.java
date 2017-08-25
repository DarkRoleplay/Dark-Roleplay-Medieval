package net.dark_roleplay.medieval.client.gui.info;

import java.awt.Color;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.ForgeVersion.CheckResult;
import net.minecraftforge.fml.common.versioning.ComparableVersion;

public class Gui_UpdateAvailable extends GuiScreen{

    private URI link;
	
    GuiButton btnUpdate;
    GuiButton btnLater;
    
	@Override
	public void initGui(){
		super.initGui();
		btnUpdate = new GuiButton(0, (this.width / 2) - 76, this.height - 30, 75, 20, "DOWNLOAD");
		btnLater = new GuiButton(1, (this.width / 2) + 1, this.height - 30, 75, 20, "LATER");

		this.addButton(btnUpdate);
		this.addButton(btnLater);
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);

		FontRenderer font;
		font = this.fontRenderer;
		
		CheckResult status = DRPMedievalInfo.VERSION_STATUS;
		
		String updateMessage = "There is a new update for \"" + DRPMedievalInfo.NAME + "\" available!\n\n";
		updateMessage += "v" + DRPMedievalInfo.VERSION + " ---> v" + status.target.toString() + "\n\n";
		
		Map<ComparableVersion, String> changes = status.changes;
		
		if(changes.containsKey(status.target)){
			updateMessage += "Changelog:\n";
			updateMessage += changes.get(status.target) + "\n";
		}
		
		try {
			this.link = new URI(status.url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		font.drawSplitString(updateMessage, 15, 15, this.width - 30, new Color(255, 255, 255).getRGB());
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException{
		if(button == btnUpdate){
			if (this.mc.gameSettings.chatLinksPrompt){
		           this.mc.displayGuiScreen(new GuiConfirmOpenLink(this, link.toString(), 0, false));
		    }else{
		        this.openWebLink(link);
		    }
		}else if(button == btnLater){
			this.mc.displayGuiScreen(null);
		}
		
    }
	
	@Override
	public void confirmClicked(boolean result, int id){
        if (id == 0){
            if (result){
                this.openWebLink(this.link);
            }
            this.mc.displayGuiScreen(this);
        }
    }
	
	private void openWebLink(URI url){
        try{
            Class<?> oclass = Class.forName("java.awt.Desktop");
            Object object = oclass.getMethod("getDesktop").invoke((Object)null);
            oclass.getMethod("browse", URI.class).invoke(object, url);
        }catch (Throwable throwable1){
            Throwable throwable = throwable1.getCause();
            DRPMedievalInfo.LOGGER.error("Couldn't open link: {}", (Object)(throwable == null ? "<UNKNOWN>" : throwable.getMessage()));
        }
    }
}
