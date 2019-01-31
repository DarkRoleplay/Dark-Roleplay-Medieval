package net.dark_roleplay.medieval.objects.blocks.utility.other.clock_core;

import java.awt.image.BufferedImage;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.objects.other.ImageConversion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityClockCore extends TileEntity {

	private boolean realTime;
	private boolean hasUpdate;
	
	public TileEntityClockCore(){
		this.realTime = false;
	}
	
	public void setRealTime(boolean realTime){
		this.realTime = realTime;
	}
	
	public boolean isRealTime(){
		return this.realTime;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("real_time")){
        	this.realTime = compound.getBoolean("real_time");
        }
    }

	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
    	compound = super.writeToNBT(compound);
    	compound.setBoolean("real_time", realTime);
    	return compound;
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
    	NBTTagCompound nbtTag = new NBTTagCompound();
        return writeToNBT(nbtTag);
    }

    @Override
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound nbtTag = getUpdateTag();
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
        
    }
    
    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }
}

