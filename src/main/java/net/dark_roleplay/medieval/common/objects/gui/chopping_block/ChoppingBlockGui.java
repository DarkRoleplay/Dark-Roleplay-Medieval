package net.dark_roleplay.medieval.common.objects.gui.chopping_block;

import net.dark_roleplay.library.experimental.guis.modular.ModularGui_Drawer;
import net.dark_roleplay.medieval.References;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

public class ChoppingBlockGui extends GuiContainer{

    public ChoppingBlockGui(Container inventorySlots) {
		super(inventorySlots);
	}

	private static final ResourceLocation background = new ResourceLocation(References.MODID, "textures/guis/storage/dynamic_storage.png");

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    	int posX = (this.width - this.xSize)/2;
    	int posY = (this.height - this.ySize)/2;

		ModularGui_Drawer.drawBackground(posX, posY, this.xSize, this.ySize);

        this.mc.getTextureManager().bindTexture(background);
        for(Slot slot : this.inventorySlots.inventorySlots){
        	this.drawTexturedModalRect((posX + slot.xPos) - 1, (posY + slot.yPos) - 1, 0, 238, 18, 18);


        }
	}
}