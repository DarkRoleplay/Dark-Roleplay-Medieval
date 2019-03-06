package net.dark_roleplay.medieval.objects.guis;

import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;

public class TelescopeOverlay extends Gui{
	
	private static final ResourceLocation SCOPE = new ResourceLocation(DarkRoleplayMedieval.MODID, "textures/guis/overlays/telescope_overlay.png");
	
	private static final int BLACK = 0xFF000000;
	
	public void draw(Minecraft mc){
        int width = Minecraft.getInstance().mainWindow.getScaledWidth();
        int height = Minecraft.getInstance().mainWindow.getScaledHeight();
        
        mc.getTextureManager().bindTexture(TelescopeOverlay.SCOPE);

    	GlStateManager.enableBlend();      
        GlStateManager.disableAlphaTest();

    	GlStateManager.color4f(1F, 1F, 1F, 1F);
        if(width >= height){
        	int xPos = width - height;
        	Gui.drawModalRectWithCustomSizedTexture(xPos / 2, 0, 0, 0, height, height, height, height);
            Gui.drawRect(0, 0, xPos / 2, height, TelescopeOverlay.BLACK);
            Gui.drawRect(width - (xPos/2) - 1, 0, width, height, TelescopeOverlay.BLACK);
        }else{
        	int yPos = height - width;
        	Gui.drawModalRectWithCustomSizedTexture(0, yPos / 2, 0, 0, width, width, width, width);
            Gui.drawRect(0, 0, width, yPos/2, TelescopeOverlay.BLACK);
            Gui.drawRect(0, height - (yPos/2) - 1, width, height, TelescopeOverlay.BLACK);
        }
    }
}
