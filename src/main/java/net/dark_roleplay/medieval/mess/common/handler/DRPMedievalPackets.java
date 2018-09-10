package net.dark_roleplay.medieval.mess.common.handler;

import net.dark_roleplay.medieval.mess.common.objects.packets.SyncPacket_ShopSign;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class DRPMedievalPackets {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("drp99_medieval".toLowerCase());

	
	
	public static void init() {
		int i = 0;
		INSTANCE.registerMessage(SyncPacket_ShopSign.class, SyncPacket_ShopSign.class , i++, Side.SERVER);
	}

	public static void sendTo(IMessage message, EntityPlayerMP player) {
		INSTANCE.sendTo(message, player);
	}

	public static void sendToServer(IMessage message) {
		INSTANCE.sendToServer(message);
	}
}
