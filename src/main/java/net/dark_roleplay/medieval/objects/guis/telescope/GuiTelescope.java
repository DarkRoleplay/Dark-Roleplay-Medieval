package net.dark_roleplay.medieval.objects.guis.telescope;

import java.awt.Color;

import net.dark_roleplay.medieval.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class GuiTelescope extends Gui{
	
	private static final ResourceLocation SCOPE = new ResourceLocation(References.MODID, "textures/guis/telescope_limitation.png");
	
	private static final int BLACK = new Color(0,0,0).getRGB();
	
	public void draw(Minecraft mc){
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();
 
//        this.drawCenteredString(mc.fontRendererObj, "test", width / 2, (height / 2) - 4, Integer.parseInt("FFAA00", 16))
        mc.getTextureManager().bindTexture(GuiTelescope.SCOPE);

        if(width >= height){
        	int xPos = width - height;
        	
            Gui.drawScaledCustomSizeModalRect(xPos / 2, 0, 0, 0, 256, 256, height, height, 256, 256);
            Gui.drawRect(0, 0, xPos / 2, height, GuiTelescope.BLACK);
            Gui.drawRect(width - (xPos/2) - 1, 0, width, height, GuiTelescope.BLACK);
        }else{
        	int yPos = height - width;
        	
            Gui.drawScaledCustomSizeModalRect(0, yPos/2, 0, 0, 256, 256, width, width, 256, 256);
            Gui.drawRect(0, 0, width, yPos/2, GuiTelescope.BLACK);
            Gui.drawRect(0, height - (yPos/2) - 1, width, height, GuiTelescope.BLACK);
        }
    }
	
}
