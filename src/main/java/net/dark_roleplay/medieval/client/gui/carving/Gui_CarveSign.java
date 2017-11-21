package net.dark_roleplay.medieval.client.gui.carving;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import net.dark_roleplay.medieval.client.gui.storage.Gui_SimpleStorage;
import net.dark_roleplay.medieval.common.blocks.util.shop_sign.TE_ShopSign;
import net.dark_roleplay.medieval.common.handler.DRPMedievalPackets;
import net.dark_roleplay.medieval.common.network.packets.SyncPacket_ShopSign;
import net.dark_roleplay.medieval.common.util.nbt.ImageConversion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;

public class Gui_CarveSign extends GuiScreen{

	private BufferedImage img;
	private ResourceLocation imgLoc;
	private boolean imgChanged = false;
	
	private static final int COLOR_BLACK = new Color(0, 0, 0).getRGB();
	private static final int COLOR_BG = new Color(98, 75, 61).getRGB();
	private static final int COLOR_INVISIBLE = new Color(0, 0, 0, 0).getRGB();
	private static final int COLOR_DRAWING_1 = new Color(32,16,0,255).getRGB();
	private static final int COLOR_DRAWING_2 = new Color(48,32,0,255).getRGB();
	private static final int COLOR_DRAWING_3 = new Color(64,48,0,255).getRGB();

	
	
	private int drawWidth = 32, drawHeight = 24;
	
	TE_ShopSign te;
	
	int[] imgBuf;
	
	public Gui_CarveSign(TE_ShopSign te){
		this.te = te;
		if(te.getIMG() != null){
			imgBuf = ImageConversion.bufToIntAr(te.getIMG());
		}else{
			imgBuf = new int[drawWidth * drawHeight];
			for(int i = 0; i < imgBuf.length; i++){
				int line = i / drawWidth % 2;
				imgBuf[i] = COLOR_INVISIBLE;
			}
		}
		img = ImageConversion.intArToBuf(drawWidth, drawHeight, imgBuf);

	    imgLoc = Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation("gui_carve_carving", new DynamicTexture(img));
	}
	
	private int sizeX, sizeY;
	private int scaleFactor = 8;
	private int posX, posY;
	
	@Override
	public void initGui(){
		
		
		this.sizeX = drawWidth * scaleFactor;
		this.sizeY = drawHeight * scaleFactor;
		
		this.posX = (this.width - sizeX) / 2;
		this.posY = (this.height - sizeY) / 2;
		
    }
	
	@Override
	public void onGuiClosed(){
		te.setDrawing(img);
		DRPMedievalPackets.sendToServer(new SyncPacket_ShopSign(te));
    }
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		
		super.drawScreen(mouseX, mouseY, partialTicks);

		//Update Image
		if(imgChanged){
			imgLoc = Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation("gui_carve_carving", new DynamicTexture(img));
			this.imgChanged = false;
		}
		
		//Bind Texture
		this.mc.getTextureManager().bindTexture(imgLoc);
		
		//Draw Image
		this.drawRect(this.posX, this.posY, this.posX + sizeX, this.posY + sizeY, COLOR_BG);
		GL11.glColor4f(1f, 1f, 1f, 1f);
		drawFullTextureScaled(this.posX, this.posY, sizeX, sizeY);
				
		//Draw Lines
		GlStateManager.color(255, 255, 255);
		drawLines(this.posX, this.posY, sizeX, sizeY);
		
		if(leftDown){
			mouseDragged(mouseX, mouseY, 0);
		}else if(rightDown){
			mouseDragged(mouseX, mouseY, 1);
		}
		
    }
	
	private void drawLines(int posX, int posY, int sizeX, int sizeY){
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glLineWidth(1);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);

		for(int i = 0; i < this.drawWidth + 1; i++){
			drawVerLine(posX + ((scaleFactor) * i), posY, sizeY);
		}
		for(int i = 0; i < this.drawHeight + 1; i++){
			drawHorLine(posX, posY + (scaleFactor * i), sizeX);
		}

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glPopMatrix();
	}
	
	private void drawHorLine(int posX, int posY, int length){
		GL11.glBegin(GL11.GL_LINE_STRIP);GL11.glVertex2f(posX, posY);GL11.glVertex2f(posX + length, posY);GL11.glEnd();
	}
	
	private void drawVerLine(int posX, int posY, int length){
		GL11.glBegin(GL11.GL_LINE_STRIP);GL11.glVertex2f(posX, posY);GL11.glVertex2f(posX, posY + length);GL11.glEnd();
	}
	
	private boolean leftDown = false;
	private boolean rightDown = false;

	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException{
        	int posX = (mouseX - this.posX) / scaleFactor;
        	int posY = (mouseY - this.posY) / scaleFactor;
        	if(posX >= 0 && posX < this.drawWidth){
        		if(posY >= 0 && posY < this.drawHeight){
        			imgBuf[posX + (drawWidth * posY)] = mouseButton == 0 ? COLOR_DRAWING_1 : COLOR_INVISIBLE;
            		img = ImageConversion.intArToBuf(drawWidth, drawHeight, imgBuf);
            		this.imgChanged = true;
        		}
        	}
        	if(mouseButton == 0){
        		leftDown = true;
        	}else{
        		rightDown = true;
        	}
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
	
	protected void mouseReleased(int mouseX, int mouseY, int state){
		super.mouseReleased(mouseX, mouseY, state);
		if(state == 0){
    		leftDown = false;
    	}else{
    		rightDown = false;
    	}
    }
	
	protected void mouseDragged(int mouseX, int mouseY, int mouseButton){
		int posX = (mouseX - this.posX) / scaleFactor;
    	int posY = (mouseY - this.posY) / scaleFactor;
    	if(posX >= 0 && posX < this.drawWidth){
    		if(posY >= 0 && posY < this.drawHeight){
    			imgBuf[posX + (drawWidth * posY)] = mouseButton == 0 ? COLOR_DRAWING_1 : COLOR_INVISIBLE;
        		img = ImageConversion.intArToBuf(drawWidth, drawHeight, imgBuf);
        		this.imgChanged = true;
    		}
    	}
	}
	
	public static void drawFullTextureScaled(int x, int y,int width, int height){
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos((double)x, (double)(y + height), 0.0D).tex(0D, 1D).endVertex();
        bufferbuilder.pos((double)(x + width), (double)(y + height), 0.0D).tex(1D, 1D).endVertex();
        bufferbuilder.pos((double)(x + width), (double)y, 0.0D).tex(1D, 0D).endVertex();
        bufferbuilder.pos((double)x, (double)y, 0.0D).tex(0D, 0D).endVertex();
        tessellator.draw();
    }
}
