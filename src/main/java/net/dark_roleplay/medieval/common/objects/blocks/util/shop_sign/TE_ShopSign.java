package net.dark_roleplay.medieval.common.objects.blocks.util.shop_sign;

import java.awt.image.BufferedImage;

import javax.annotation.Nullable;

import net.dark_roleplay.medieval.common.util.nbt.ImageConversion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TE_ShopSign extends TileEntity {

	private BufferedImage img;
	private ResourceLocation drawing;
	private boolean hasUpdate;
	
	public void setDrawing(BufferedImage img){
		this.img = img;
		this.hasUpdate = true;
		this.markDirty();
	}
	
	public ResourceLocation getDrawing(){
		if(hasUpdate && img != null){
			this.drawing = Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation("shop_sign", new DynamicTexture(img));
			this.hasUpdate = false;
		}
		return drawing;
	}
	
	public BufferedImage getIMG(){
		return img;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        if(compound.hasKey("img")){
        	img = ImageConversion.imgFromNBT((NBTTagCompound) compound.getTag("img"));
    		this.hasUpdate = true;
        }
    }

	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
    	compound = super.writeToNBT(compound);
    	if(this.img != null){
    		compound.setTag("img", ImageConversion.imgToNBT(img));
    	}
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

        System.out.println("DEBUG2");
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
        
    }
    
    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
        System.out.println("DEBUG");
    }
}

