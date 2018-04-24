package net.dark_roleplay.medieval.client.gui.crafting.cooking.parts;

import java.awt.Color;

import net.dark_roleplay.drpcore.api.old.gui.advanced.Gui_Panel;
import net.minecraft.client.renderer.GlStateManager;

public class Gui_RoundPanel extends Gui_Panel.IMPL{

	private int resoulution;
	
	public Gui_RoundPanel(int posX, int posY, int diameter, int resoulution) {
		super(posX, posY, diameter, diameter);
		this.resoulution = resoulution;
	}
	
	@Override
	public void draw(int mouseX, int mouseY, float partialTick) {
		GlStateManager.pushMatrix();
        GlStateManager.translate((float)(this.posX), (float)(this.posY), -400.0F);
        GlStateManager.enableDepth();
        

		GlStateManager.depthFunc(518);
		drawCenteredCircle(width / 2, height / 2, width/2, this.resoulution, new Color(255,255,255).getRGB());
	    GlStateManager.depthFunc(515);
		
	    GlStateManager.color(1F, 1F, 1F);
	    
	    this.drawBackground(mouseX - this.posX, mouseY - this.posY, partialTick);
	    this.drawMiddleground(mouseX - this.posX, mouseY - this.posY, partialTick);
	    this.drawForeground(mouseX - this.posX, mouseY - this.posY, partialTick);
	    
		GlStateManager.popMatrix();
	    GlStateManager.depthFunc(515);
	    GlStateManager.disableDepth();
	}
}
