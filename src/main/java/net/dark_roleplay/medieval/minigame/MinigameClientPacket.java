package net.dark_roleplay.medieval.minigame;

import java.util.Optional;
import java.util.function.Supplier;

import net.dark_roleplay.library.networking.SimplePacket;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class MinigameClientPacket extends SimplePacket<MinigameClientPacket>{

	private int id = -1;
	private NBTTagCompound nbt = null;
	
	public MinigameClientPacket() {}
	public MinigameClientPacket(int id, NBTTagCompound nbt) {
		this.id = id;
		this.nbt = nbt;
	}
	
	@Override
	public MinigameClientPacket decode(PacketBuffer buffer) {
		if(buffer.readBoolean())
			return new MinigameClientPacket(buffer.readInt(), buffer.readCompoundTag());
		return new MinigameClientPacket();
	}

	@Override
	public void encode(MinigameClientPacket instance, PacketBuffer buffer) {
		buffer.writeBoolean(nbt != null);
		if(nbt == null) return;
		buffer.writeInt(this.id);
		buffer.writeCompoundTag(this.nbt);
	}

	@Override
	public void onMessage(MinigameClientPacket instance, Supplier<NetworkEvent.Context> context) {
		if(instance.nbt == null) return;
		
		Optional<IMinigame> minigame = MinigameHandler.getMinigame(instance.id);
		if(!minigame.isPresent()) return;
		minigame.get().handlePacket(instance.nbt, context.get().getSender());
			
	}

}
