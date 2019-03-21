package net.dark_roleplay.medieval.testing.guis.brewing;

public class PanelBrew{}/*  extends Panel{

	private float rotation = 0F;
	
	public PanelBrew(int posX, int posY, int radius, int circleResolution, int bgColor) {
		super(posX, posY, radius, circleResolution, bgColor);
	}
	
	@Override
	public void draw(int mouseX, int mouseY, float partialTick) {
		this.mouseY = mouseY - this.posX;
		this.mouseX = mouseX - this.posX;
		GlStateManager.pushMatrix();
        
        GlStateManager.translate((float)(this.posX), (float)(this.posY), -400.0F);
        
        GlStateManager.enableDepth();
		GlStateManager.depthFunc(518);
	    drawCenteredCircle(width, width, width, height, 0xFFAA0000);
	    GlStateManager.depthFunc(515);
	    
	    GlStateManager.color(1F, 1F, 1F);


	    this.drawBackground(mouseX - this.posX, mouseY - this.posY, partialTick);
	    this.drawMiddleground(mouseX - this.posX, mouseY - this.posY, partialTick);
	    this.drawForeground(mouseX - this.posX, mouseY - this.posY, partialTick);

	    GlStateManager.disableDepth();
		GlStateManager.popMatrix();
	}
	
	@Override
	public void drawForeground(int mouseX, int mouseY, float partialTick){	    
		GlStateManager.pushMatrix();
        GlStateManager.translate(width, width, 0);
	    GlStateManager.rotate(rotation, 0F, 0F, 1F);
	    
        Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("drpmedieval", "textures/guis/brewing_temp.png"));

        drawTexturedModalRect(-width, -width, 0, 0, width * 2, width * 2);
//		drawGradientRect(, width, width, 0xFF000033, 0xFF0000FF);
		
	    rotation += 0.5F;
		GlStateManager.popMatrix();
	}
}*/
