package net.dark_roleplay.medieval.client.gui.crafting.cooking;

import net.dark_roleplay.drpcore.api.gui.advanced.Gui_Screen;
import net.dark_roleplay.medieval.client.gui.crafting.cooking.parts.Gui_RoundPanel;

public class CookingMinigame extends Gui_Screen{

	private Gui_RoundPanel soupPanel;
	
	private boolean initialized = false;
	
	public CookingMinigame(){
	}
	
	public void initGui(){
		if(!initialized){
			this.addElement(this.soupPanel = new Gui_RoundPanel(this.width/2 - 50, this.height/2 - 50, 100, 32));
			this.initialized = true;
		}
		this.soupPanel.setPos(this.width/2 - 50, this.height/2 - 50);
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}
