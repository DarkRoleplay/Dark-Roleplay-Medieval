package net.dark_roleplay.medieval.common.objects.packets.blocks;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import io.netty.buffer.ByteBuf;
import net.dark_roleplay.library.networking.PacketBase;
import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ShopSign;
import net.dark_roleplay.medieval.old.ImageConversion;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SyncPacket_ShopSign extends PacketBase.Server<SyncPacket_ShopSign>{

	BufferedImage img;
	BlockPos pos;
	
	public SyncPacket_ShopSign(){
		img = null;
		pos = null;
	}

	public SyncPacket_ShopSign(TE_ShopSign te){
		this.img = te.getIMG();
		this.pos = te.getPos();
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
		
		int width = buf.readInt(), height = buf.readInt();
		
		int[] imageBytes = new int[width * height];
		for(int i = 0; i < imageBytes.length; i++){
			imageBytes[i] = buf.readInt();
		}
		this.img = ImageConversion.intArToBuf(width, height, imageBytes);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.pos.getX());
		buf.writeInt(this.pos.getY());
		buf.writeInt(this.pos.getZ());
		
		buf.writeInt(this.img.getWidth());
		buf.writeInt(this.img.getHeight());
		
		int[] imageBytes = ((DataBufferInt) img.getData().getDataBuffer()).getData();
		
		for(int i = 0; i < imageBytes.length; i++){
			buf.writeInt(imageBytes[i]);
		}
	}

	@Override
	public void handleServerSide(SyncPacket_ShopSign message, EntityPlayer player) {
		player.getServer().addScheduledTask(new Runnable(){
			@Override
			public void run() {
				World world = player.getEntityWorld();
				TileEntity tileEntity = world.getTileEntity(message.pos);
				if(!(tileEntity instanceof TE_ShopSign))
					return;
				TE_ShopSign te = (TE_ShopSign) tileEntity;
				
				te.setDrawing(message.img);
			}
		});
	}

}
