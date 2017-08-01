package net.dark_roleplay.medieval.client;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DRPImageNBT {

	BufferedImage indexedImage = new BufferedImage(100, 10,BufferedImage.TYPE_BYTE_INDEXED);
	
	public DRPImageNBT(){
		Graphics gfx = this.indexedImage.getGraphics();
		gfx.drawString("TEST", 1, 1);
	}
	
	public BufferedImage getImage(){
		return this.indexedImage;
	}
	
}
