package net.dark_roleplay.medieval.mess.work_in_progress_2.gui.brewing;

import net.dark_roleplay.core.api.old.gui.DRPGuiScreen;
import net.dark_roleplay.medieval.client.objects.guis.blocks.Gui_SimpleStorage;
import net.minecraft.util.ResourceLocation;

public class GuiBrewing extends DRPGuiScreen{

	private static final ResourceLocation cauldron = new ResourceLocation("drpmedieval", "textures/guis/cauldron_gui.png");
	private PanelBrew brewing = new PanelBrew(100, 100, 75, 50, 0x1A000000);
	
	public GuiBrewing() {
		
			this.elements.add(brewing);
	}
	
	@Override
	protected void reAdjust() {
		super.reAdjust();
		brewing.setPos(this.width /2 - 75, this.height/2 - 75);
		this.guiLeft = this.width/2 - 79;
		this.guiTop = this.height/2 - 79;
	}

	
	@Override
	protected void drawForeground(int mouseX, int mouseY, float partialTicks) {
        this.mc.getTextureManager().bindTexture(cauldron);
    	this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, 158, 158);

	}

	
}
