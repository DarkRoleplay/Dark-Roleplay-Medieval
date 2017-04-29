package net.dark_roleplay.medieval.common.items.book;

import org.lwjgl.util.Color;
import org.lwjgl.util.Point;

import net.minecraft.nbt.NBTTagCompound;

public class TextComponent extends PageComponent{

	private String textKey = "text";
	
	protected String text;
	protected int[] colors = new int[8];
	
	public TextComponent(){
		super(new Point(0,0));
	}
	
	public TextComponent(Point pos, String text) {
		super(pos);
		this.text = text;
		for(int i = 0; i < 8; i++){
			Color clr = new Color(255,255,255,255);
			this.setColor((short) i, clr);
		}
	}

	public String getText(){
		return this.text;
	}
	
	@Override
	public NBTTagCompound parseToCompound(){
		if(this.text != null){
			NBTTagCompound tag = new NBTTagCompound();
				tag.setString(textKey, this.text);
				
			return tag;
		}
		return null;
	}

	@Override
	public boolean parseFromCompound(NBTTagCompound tag) {
		this.text = tag.getString(textKey);
		
		return false;
	}

	
	public void setColor(short pos, Color color){
		int col =  (color.getAlpha() & 0xff << 24) | ((color.getRed() & 0xff) << 16) | ((color.getGreen() & 0xff) << 8) | (color.getBlue() & 0xff);;
		if(pos < 8)
		this.colors[pos] = col;
	}
	
}
