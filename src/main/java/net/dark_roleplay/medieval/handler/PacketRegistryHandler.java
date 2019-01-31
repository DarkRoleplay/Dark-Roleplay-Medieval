package net.dark_roleplay.medieval.handler;

import net.dark_roleplay.medieval.holders.MedievalNetwork;
import net.dark_roleplay.medieval.objects.packets.blocks.SyncPacket_ShopSign;
import net.dark_roleplay.medieval.objects.packets.other.MergeCoins;
import net.minecraftforge.fml.relauncher.Side;

public class PacketRegistryHandler {

	public static void init() {
		int i = 0;
		MedievalNetwork.INSTANCE.registerMessage(SyncPacket_ShopSign.class, SyncPacket_ShopSign.class , i++, Side.SERVER);
		MedievalNetwork.INSTANCE.registerMessage(MergeCoins.class, MergeCoins.class, i++, Side.SERVER);
	}
}
