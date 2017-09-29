package net.dark_roleplay.medieval.client.gui;

import net.dark_roleplay.medieval.common.entities.entity.item.EntitySledge;
import net.dark_roleplay.medieval.common.inventory.ContainerSledgeInventory;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiSledgeInventory  extends GuiContainer{
	
    private static final ResourceLocation HORSE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/horse.png");
    /** The player inventory bound to this GUI. */
    private final IInventory playerInventory;
    /** The horse inventory bound to this GUI. */
    private final IInventory sledgeInventory;
    /** The EntityHorse whose inventory is currently being accessed. */
    private final EntitySledge sledgeEntity;
    /** The mouse x-position recorded during the last rendered frame. */
    private float mousePosx;
    /** The mouse y-position recorded during the last renderered frame. */
    private float mousePosY;

    public GuiSledgeInventory(ContainerSledgeInventory container){
		super(container);
        this.playerInventory = container.playerInventory;
        this.sledgeInventory = container.sledgeInventory;
        this.sledgeEntity = container.theSledge;
       // this.allowUserInput = false;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
        this.fontRenderer.drawString(this.sledgeInventory.getDisplayName().getUnformattedText(), 8, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(HORSE_GUI_TEXTURES);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        if (this.sledgeEntity.isChested()){
            this.drawTexturedModalRect(i + 79, j + 17, 0, this.ySize, 90, 54);
        }
        this.drawTexturedModalRect(i + 7, j + 35, 0, this.ySize + 54, 18, 18);

        GuiInventory.drawEntityOnScreen(i + 51, j + 60, 17, (float)(i + 51) - this.mousePosx, (float)(j + 75 - 50) - this.mousePosY, this.sledgeEntity);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.mousePosx = (float)mouseX;
        this.mousePosY = (float)mouseY;
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}