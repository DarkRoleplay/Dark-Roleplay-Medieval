package net.dark_roleplay.medieval.one_twelve.objects.guis.sign_drawing;

public class GuiSignDrawing{//  extends GuiScreen{
//
//	private BufferedImage img;
//	private ResourceLocation imgLoc;
//	private boolean imgChanged = false;
//
//	private static final int COLOR_BLACK = new Color(0, 0, 0).getRGB();
//	private static final int COLOR_BG = new Color(98, 75, 61).getRGB();
//	private static final int COLOR_INVISIBLE = new Color(0, 0, 0, 0).getRGB();
//	private static final int COLOR_DRAWING_1 = new Color(32,16,0,255).getRGB();
//	private static final int COLOR_DRAWING_2 = new Color(48,32,0,255).getRGB();
//	private static final int COLOR_DRAWING_3 = new Color(64,48,0,255).getRGB();
//
//
//
//	private int drawWidth = 32, drawHeight = 24;
//
//	TileEntityShopSign te;
//
//	int[] imgBuf;
//
//	public GuiSignDrawing(TileEntityShopSign te){
//		this.te = te;
//		if(te.getIMG() != null){
//			this.imgBuf = ImageConversion.bufToIntAr(te.getIMG());
//		}else{
//			this.imgBuf = new int[this.drawWidth * this.drawHeight];
//			for(int i = 0; i < this.imgBuf.length; i++){
//				int line = i / this.drawWidth % 2;
//				this.imgBuf[i] = COLOR_INVISIBLE;
//			}
//		}
//		this.img = ImageConversion.intArToBuf(this.drawWidth, this.drawHeight, this.imgBuf);
//
//	    this.imgLoc = Minecraft.getInstance().getTextureManager().getDynamicTextureLocation("gui_carve_carving", new DynamicTexture(this.img));
//	}
//
//	private int sizeX, sizeY;
//	private int scaleFactor = 8;
//	private int posX, posY;
//
//	@Override
//	public void initGui(){
//
//
//		this.sizeX = this.drawWidth * this.scaleFactor;
//		this.sizeY = this.drawHeight * this.scaleFactor;
//
//		this.posX = (this.width - this.sizeX) / 2;
//		this.posY = (this.height - this.sizeY) / 2;
//
//    }
//
//	@Override
//	public void onGuiClosed(){
//		this.te.setDrawing(this.img);
//		MedievalNetwork.sendToServer(new SyncPacket_ShopSign(this.te));
//    }
//
//	@Override
//	public void drawScreen(int mouseX, int mouseY, float partialTicks){
//
//		super.drawScreen(mouseX, mouseY, partialTicks);
//
//		//Update Image
//		if(this.imgChanged){
//			this.imgLoc = Minecraft.getInstance().getTextureManager().getDynamicTextureLocation("gui_carve_carving", new DynamicTexture(this.img));
//			this.imgChanged = false;
//		}
//
//		//Bind Texture
//		this.mc.getTextureManager().bindTexture(this.imgLoc);
//
//		//Draw Image
//		this.drawRect(this.posX, this.posY, this.posX + this.sizeX, this.posY + this.sizeY, COLOR_BG);
//		GL11.glColor4f(1f, 1f, 1f, 1f);
//		drawFullTextureScaled(this.posX, this.posY, this.sizeX, this.sizeY);
//
//		//Draw Lines
//		GlStateManager.color(255, 255, 255);
//		this.drawLines(this.posX, this.posY, this.sizeX, this.sizeY);
//
//		if(this.leftDown){
//			this.mouseDragged(mouseX, mouseY, 0);
//		}else if(this.rightDown){
//			this.mouseDragged(mouseX, mouseY, 1);
//		}
//
//    }
//
//	private void drawLines(int posX, int posY, int sizeX, int sizeY){
//		GL11.glPushMatrix();
//		GL11.glDisable(GL11.GL_TEXTURE_2D);
//		GL11.glDisable(GL11.GL_DEPTH_TEST);
//		GL11.glLineWidth(1);
//		GL11.glEnable(GL11.GL_LINE_SMOOTH);
//		GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
//
//		for(int i = 0; i < this.drawWidth + 1; i++){
//			this.drawVerLine(posX + ((this.scaleFactor) * i), posY, sizeY);
//		}
//		for(int i = 0; i < this.drawHeight + 1; i++){
//			this.drawHorLine(posX, posY + (this.scaleFactor * i), sizeX);
//		}
//
//		GL11.glEnable(GL11.GL_TEXTURE_2D);
//		GL11.glEnable(GL11.GL_DEPTH_TEST);
//		GL11.glPopMatrix();
//	}
//
//	private void drawHorLine(int posX, int posY, int length){
//		GL11.glBegin(GL11.GL_LINE_STRIP);GL11.glVertex2f(posX, posY);GL11.glVertex2f(posX + length, posY);GL11.glEnd();
//	}
//
//	private void drawVerLine(int posX, int posY, int length){
//		GL11.glBegin(GL11.GL_LINE_STRIP);GL11.glVertex2f(posX, posY);GL11.glVertex2f(posX, posY + length);GL11.glEnd();
//	}
//
//	private boolean leftDown = false;
//	private boolean rightDown = false;
//
//	@Override
//	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException{
//        	int posX = (mouseX - this.posX) / this.scaleFactor;
//        	int posY = (mouseY - this.posY) / this.scaleFactor;
//        	if(posX >= 0 && posX < this.drawWidth){
//        		if(posY >= 0 && posY < this.drawHeight){
//        			this.imgBuf[posX + (this.drawWidth * posY)] = mouseButton == 0 ? COLOR_DRAWING_1 : COLOR_INVISIBLE;
//            		this.img = ImageConversion.intArToBuf(this.drawWidth, this.drawHeight, this.imgBuf);
//            		this.imgChanged = true;
//        		}
//        	}
//        	if(mouseButton == 0){
//        		this.leftDown = true;
//        	}else{
//        		this.rightDown = true;
//        	}
//        super.mouseClicked(mouseX, mouseY, mouseButton);
//    }
//
//	@Override
//	protected void mouseReleased(int mouseX, int mouseY, int state){
//		super.mouseReleased(mouseX, mouseY, state);
//		if(state == 0){
//    		this.leftDown = false;
//    	}else{
//    		this.rightDown = false;
//    	}
//    }
//
//	protected void mouseDragged(int mouseX, int mouseY, int mouseButton){
//		int posX = (mouseX - this.posX) / this.scaleFactor;
//    	int posY = (mouseY - this.posY) / this.scaleFactor;
//    	if(posX >= 0 && posX < this.drawWidth){
//    		if(posY >= 0 && posY < this.drawHeight){
//    			this.imgBuf[posX + (this.drawWidth * posY)] = mouseButton == 0 ? COLOR_DRAWING_1 : COLOR_INVISIBLE;
//        		this.img = ImageConversion.intArToBuf(this.drawWidth, this.drawHeight, this.imgBuf);
//        		this.imgChanged = true;
//    		}
//    	}
//	}
//
//	public static void drawFullTextureScaled(int x, int y,int width, int height){
//        Tessellator tessellator = Tessellator.getInstance();
//        BufferBuilder bufferbuilder = tessellator.getBuffer();
//        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
//        bufferbuilder.pos(x, y + height, 0.0D).tex(0D, 1D).endVertex();
//        bufferbuilder.pos(x + width, y + height, 0.0D).tex(1D, 1D).endVertex();
//        bufferbuilder.pos(x + width, y, 0.0D).tex(1D, 0D).endVertex();
//        bufferbuilder.pos(x, y, 0.0D).tex(0D, 0D).endVertex();
//        tessellator.draw();
//    }
}
