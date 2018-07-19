package net.dark_roleplay.medieval.client.gui.storage;

import java.awt.Color;

import net.dark_roleplay.core.api.old.gui.modular.ModularGui_Drawer;
import net.dark_roleplay.medieval.common.References;
import net.dark_roleplay.medieval.common.objects.blocks.tileentities.storage.TileEntity_SimpleStorage;
import net.dark_roleplay.medieval.common.objects.gui.container.Container_SimpleStorage;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class Gui_SimpleStorage extends GuiContainer {
	
    private static final ResourceLocation background = new ResourceLocation(References.MODID, "textures/guis/storage/dynamic_storage.png");

    private int size;
    
    private String containerName;
    
    public Gui_SimpleStorage(TileEntity_SimpleStorage te, Container_SimpleStorage container) {
        super(container);

		IItemHandler itemHandler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

//		containerName = itemHandler.
		
		this.size = itemHandler.getSlots();

        this.xSize = 176;
        this.ySize = 112 + (int)(Math.ceil(this.size/9D) * 18);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    	int posX = (this.width - this.xSize)/2;
    	int posY = (this.height - this.ySize)/2;

        ModularGui_Drawer.drawBackground(posX, posY, this.xSize, this.ySize);

        this.mc.getTextureManager().bindTexture(Gui_SimpleStorage.background);
        for(Slot slot : this.inventorySlots.inventorySlots){
        	this.drawTexturedModalRect((posX + slot.xPos) - 1, (posY + slot.yPos) - 1, 0, 238, 18, 18);
        }
        
        this.fontRenderer.drawString("Container", posX + 9, posY + 6, new Color(55, 55, 55).getRGB());
        this.fontRenderer.drawString("Inventory", posX + 9, posY + 19 + (int)(Math.ceil((this.size)/9D) * 18), new Color(55, 55, 55).getRGB());
 

    }
}