package net.dark_roleplay.medieval.one_twelve.objects.packets.blocks;

import java.awt.image.BufferedImage;
import java.util.function.Supplier;

import net.dark_roleplay.library.networking.SimplePacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class SyncPacket_ShopSign extends SimplePacket<SyncPacket_ShopSign>{
//PORT to 1.13
	BufferedImage img;
	BlockPos pos;
	
	public SyncPacket_ShopSign(){
		img = null;
		pos = null;
	}

//	public SyncPacket_ShopSign(TileEntityShopSign te){
//		this.img = te.getIMG();
//		this.pos = te.getPos();
//	}
	
//	@Override
//	public void fromBytes(ByteBuf buf) {
//		this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
//		
//		int width = buf.readInt(), height = buf.readInt();
//		
//		int[] imageBytes = new int[width * height];
//		for(int i = 0; i < imageBytes.length; i++){
//			imageBytes[i] = buf.readInt();
//		}
//		this.img = ImageConversion.intArToBuf(width, height, imageBytes);
//	}
//
//	@Override
//	public void toBytes(ByteBuf buf) {
//		buf.writeInt(this.pos.getX());
//		buf.writeInt(this.pos.getY());
//		buf.writeInt(this.pos.getZ());
//		
//		buf.writeInt(this.img.getWidth());
//		buf.writeInt(this.img.getHeight());
//		
//		int[] imageBytes = ((DataBufferInt) img.getData().getDataBuffer()).getData();
//		
//		for(int i = 0; i < imageBytes.length; i++){
//			buf.writeInt(imageBytes[i]);
//		}
//	}
	
	@Override
	public SyncPacket_ShopSign decode(PacketBuffer packet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void encode(SyncPacket_ShopSign message, PacketBuffer packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(SyncPacket_ShopSign message, Supplier<Context> context) {
		context.get().enqueueWork(() -> {
//			World world = player.getEntityWorld();
//			TileEntity tileEntity = world.getTileEntity(message.pos);
//			if(!(tileEntity instanceof TileEntityShopSign))
//				return;
//			TileEntityShopSign te = (TileEntityShopSign) tileEntity;
//			
//			te.setDrawing(message.img);
		});
	}
}
