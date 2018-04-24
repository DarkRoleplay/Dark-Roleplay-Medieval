package net.dark_roleplay.medieval.work_in_progress;

import io.netty.buffer.ByteBuf;
import net.dark_roleplay.library.networking.PacketBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class PacketSendAction extends PacketBase.Server<PacketSendAction>{

	private int boardID = 0;
	private NBTTagCompound tag = null;
	
	public PacketSendAction(Board board, Action action) {
		this.tag = action.writeAction(new NBTTagCompound());
		this.boardID = board.getID();
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.tag = ByteBufUtils.readTag(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, tag);
	}
	
	@Override
	public void handleServerSide(PacketSendAction arg0, EntityPlayer arg1) {
		
		
	}

}
