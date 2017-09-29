package net.dark_roleplay.medieval.client.gui.crafting.melting;

import java.awt.Color;

import org.lwjgl.util.Point;

import net.dark_roleplay.drpcore.api.gui.advanced.Gui_Screen;
import net.dark_roleplay.medieval.client.gui.crafting.cooking.parts.Gui_RoundPanel;import net.dark_roleplay.medieval.common.DRPMedievalInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class MeltingOres extends Gui_Screen{
	
	private ResourceLocation forge;
	
	private boolean initialized = false;
	private int left, top;
	
	private float scaleFactor = 0.75F;
	
	public MeltingOres(){
		this.forge = new ResourceLocation(DRPMedievalInfo.MODID + ":textures/guis/forge_background.png");
	}
	
	public void initGui(){
		this.left = (int) (this.width/2 - Math.ceil(128 * scaleFactor));
		this.top = (int) (this.height/2 - Math.ceil(77 * scaleFactor));
		if(!initialized){
			
		}
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		this.mc.renderEngine.bindTexture(this.forge);
		this.drawScaledCustomSizeModalRect(this.left, this.top, 0, 0, 256, 154, (int) Math.ceil(256 * scaleFactor), (int) Math.ceil(154 * scaleFactor), 256, 256);
		
		for(int i = 1; i <= 4; i++){
			this.drawLine(this.left + (int)(16 * scaleFactor),  this.top + (int)(((i*30) + 2) * scaleFactor), this.left + (int)(239 * scaleFactor),  this.top + (int)(((i*30) + 2) * scaleFactor), new Color(255,255,255).getRGB());
		}
		
		for(int i = 0; i < 7; i++){
			this.drawLine(this.left + (int)((27*i)+16 * scaleFactor),  this.top + (int)(32 * scaleFactor), this.left + (int)((27*i)+16 * scaleFactor),  this.top + (int)(122 * scaleFactor), new Color(255,255,255).getRGB());
		}
		
//		this.drawTexturedModalRect(this.left, this.top, 0, 0, 256, 140);
	}
	
	
	
	
	protected static void drawLine(int x1, int y1, int x2, int y2, int color) {

		float f3 = (float) (color >> 24 & 255) / 255.0F;
		float f = (float) (color >> 16 & 255) / 255.0F;
		float f1 = (float) (color >> 8 & 255) / 255.0F;
		float f2 = (float) (color & 255) / 255.0F;
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder vertexbuffer = tessellator.getBuffer();
		GlStateManager.enableBlend();
		GlStateManager.disableTexture2D();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.color(f, f1, f2, f3);

		float angle = getAngleRad(new Point(x1,y1), new Point(x2,y2));
		
		double halfPi = Math.PI / 2;
		
		float a1 = (float) (x1 + 0.5F * Math.cos(angle + halfPi)), a2 = (float) (y1 + 0.5F * Math.sin(angle + halfPi));
		float b1 = (float) (x2 + 0.5F * Math.cos(angle + halfPi)), b2 = (float) (y2 + 0.5F * Math.sin(angle + halfPi));
		float c1 = (float) (x2 + 0.5F * Math.cos(angle - halfPi)), c2 = (float) (y2 + 0.5F * Math.sin(angle - halfPi));
		float d1 = (float) (x1 + 0.5F * Math.cos(angle - halfPi)), d2 = (float) (y1 + 0.5F * Math.sin(angle - halfPi));

		
		vertexbuffer.begin(7, DefaultVertexFormats.POSITION);
		//new
		vertexbuffer.pos(a1, a2, 0.0D).endVertex();
		vertexbuffer.pos(b1, b2, 0.0D).endVertex();
		vertexbuffer.pos(c1, c2, 0.0D).endVertex();
		vertexbuffer.pos(d1, d2, 0.0D).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.disableBlend();
	}
	
	private static float getAngleRad(Point a, Point b){
		Point vec = new Point(b.getX() - a.getX(), b.getY() - a.getY());
		return (float) (Math.acos(vec.getX() / (Math.sqrt(Math.pow(vec.getX(), 2) + Math.pow(vec.getY(), 2)))));
	}
}