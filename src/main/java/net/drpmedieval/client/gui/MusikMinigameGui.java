package net.drpmedieval.client.gui;

import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.drpcore.api.guis.guis.DRPGuiScreen;
import net.drpcore.client.gui.ITimedGui;
import net.drpmedieval.common.DarkRoleplayMedieval;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;

public class MusikMinigameGui extends DRPGuiScreen implements ITimedGui{

	private int noteWidth = 20;
	private int currentNote = 0;
	private int currentTick = 0;
	private boolean key1 = false;
	private boolean key2 = false;
	private boolean key3 = false;
	private boolean key4 = false;
	private boolean key5 = false;
	private boolean key6 = false;
	private ArrayList<Note> notes = new ArrayList<Note>();
	private ArrayList<Integer> notePositions = new ArrayList<Integer>();
	private int fails = 0;
	private int speed = 5;
	
	
	public MusikMinigameGui(ArrayList<Note> notes) {
		super(new ResourceLocation(DarkRoleplayMedieval.MODID + ":textures/guis/MusikMinigame.png"), 0, 0);
		this.notes = notes;
		for(int i=0; i < this.notes.size(); i++){
			Note nt = this.notes.get(i);
			switch(nt.getType()){
				case 0:
					notePositions.add( i-1 >= 0 ? notePositions.get(i-1) + 160 : +0);
					break;
				case 1:
					notePositions.add( i-1 >= 0 ? notePositions.get(i-1) + 80 : +0);
					break;
				case 2:
					notePositions.add( i-1 >= 0 ? notePositions.get(i-1) + 40 : +0);
					break;
				case 3:
					notePositions.add( i-1 >= 0 ? notePositions.get(i-1) + 20 : +0);
					break;
				default:
					notePositions.add( i-1 >= 0 ? notePositions.get(i-1) + 40 : +0);
					break;
			}
		}
	}

	@Override
	protected void drawBackground(int mouseX, int mouseY, float partialTicks){
		this.drawDefaultBackground();
	}
	
	@Override
	public void increaseTimer(int arg0) {
		if(currentTick < 20){
			currentTick ++;
		}else{
			//Call Musik
			currentTick = 1;
			currentNote ++;
		}
		if(!notes.isEmpty()){
			int h = (currentTick * speed) + ( (speed * 20) * currentNote) - 7 - (notePositions.get(0));
			if(h > this.height){
	    		notes.remove(0);
	    		notePositions.remove(0);
	    		fails ++;
			}
		}
	}

	@Override
	protected void drawMiddleground(int mouseX, int mouseY, float partialTicks){

    }
	
	@Override
	protected void drawForeground(int arg0, int arg1, float arg2) {
		mc.renderEngine.bindTexture(this.bgTexture);
		int bX = this.width / 2;
		//Lines
		this.drawVerticalLine((int) (bX - (2.5F * noteWidth)), -1, this.height, getIntFromColor(255,150,150,150));
		this.drawVerticalLine((int) (bX - (1.5F * noteWidth)), -1, this.height, getIntFromColor(255,150,150,150));
	    this.drawVerticalLine((int) (bX - (0.5F * noteWidth)), -1, this.height, getIntFromColor(255,150,150,150));
	    this.drawVerticalLine((int) (bX + (0.5F * noteWidth)), -1, this.height, getIntFromColor(255,150,150,150));
	    this.drawVerticalLine((int) (bX + (1.5F * noteWidth)), -1, this.height, getIntFromColor(255,150,150,150));
	    this.drawVerticalLine((int) (bX + (2.5F * noteWidth)), -1, this.height, getIntFromColor(255,150,150,150));
	    //Buttons
	    GlStateManager.color(255, 255, 255, 255);
	    this.drawTexturedModalRect((bX - (3 * noteWidth)), this.height - 20,0,key1 ? 20 : 0, 20, 20);
	    this.drawTexturedModalRect((bX - (2 * noteWidth)), this.height - 20,20,key2 ? 20 : 0, 20, 20);
	    this.drawTexturedModalRect((bX - (1 * noteWidth)), this.height - 20,40,key3 ? 20 : 0, 20, 20);
	    this.drawTexturedModalRect((bX + (0 * noteWidth)), this.height - 20,60,key4 ? 20 : 0, 20, 20);
	    this.drawTexturedModalRect((bX + (1 * noteWidth)), this.height - 20,80,key5 ? 20 : 0, 20, 20);
	    this.drawTexturedModalRect((bX + (2 * noteWidth)), this.height - 20,100,key6 ? 20 : 0, 20, 20);

	    if(!notes.isEmpty()){
	    	for(int i = 0; i < notes.size(); i++){
		    	Note nt = notes.get(i);
				int h = (currentTick * speed) + ( (speed * 20) * currentNote) - (notePositions.get(i));
		    	if(h  > -20)
			    this.drawTexturedModalRect(bX + (int)((nt.getLane()+ 0.5) * noteWidth) - 3, h,120,0, 10, 16);
		    }
	    }
	    this.fontRendererObj.drawStringWithShadow("Fails: " + this.fails, 5, 5, getIntFromColor(255,255,255,255));

	}
	
	public int getIntFromColor(int Alpha,int Red, int Green, int Blue){
		Alpha = (Alpha << 24) & 0xFF000000;
	    Red = (Red << 16) & 0x00FF0000;
	    Green = (Green << 8) & 0x0000FF00;
	    Blue = Blue & 0x000000FF;

	    return Alpha | Red | Green | Blue;
	}
	
	public void triggerNote(short lane){
		if(!notes.isEmpty()){
			int h = (currentTick * speed) + ( (speed * 20) * currentNote) + 13 - (notePositions.get(0));
			Note nt = notes.get(0);
			if(h > this.height - 20 && h < this.height && nt.getLane() + 4 == lane){
	    		Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.getPosition().add(0.5,0.5,0.5), SoundEvents.BLOCK_NOTE_HARP, SoundCategory.PLAYERS, nt.getVolume(), nt.getPitch(), true);
	    		notes.remove(0);
	    		notePositions.remove(0);
			}else{
	    		fails ++;
			}
		}
	}
	
    protected void keyTyped(char typedChar, int keyCode, boolean down) throws IOException{
        if (keyCode == 2){
        	if(down){
        		key1 = true;
        		this.triggerNote((short)1);
        	}else{
        		key1 = false;
        	}
        }if (keyCode == 3){
        	if(down){
        		key2 = true;
        		this.triggerNote((short)2);
        	}else{
        		key2 = false;
        	}
        }if (keyCode == 4){
        	if(down){
        		key3 = true;
        		this.triggerNote((short)3);
        	}else{
        		key3 = false;
        	}
        }if (keyCode == 5){
        	if(down){
        		key4 = true;
        		this.triggerNote((short)4);
        	}else{
        		key4 = false;
        	}
        }if (keyCode == 6){
        	if(down){
        		key5 = true;
        		this.triggerNote((short)5);
        	}else{
        		key5 = false;
        	}
        }if (keyCode == 7){
        	if(down){
        		key6 = true;
        		this.triggerNote((short)6);
        	}else{
        		key6 = false;
        	}
        }
    }
    
    @Override
    public void handleKeyboardInput() throws IOException
    {
        char c0 = Keyboard.getEventCharacter();
        this.keyTyped(c0, Keyboard.getEventKey(),Keyboard.getEventKeyState());
        
        if (Keyboard.getEventKey() == 0 && c0 >= 32 || Keyboard.getEventKeyState())
        {
            this.keyTyped(c0, Keyboard.getEventKey());
        }

        this.mc.dispatchKeypresses();
    }

	
}
