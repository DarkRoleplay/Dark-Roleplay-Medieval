package net.dark_roleplay.medieval.common.blocks.tileentitys;

import java.io.IOException;

import net.dark_roleplay.medieval.common.blocks.helper.EnumMattressType;
import net.dark_roleplay.medieval.common.capabilities.blocks.bedframe.DefaultBedFrameMattress;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCapabilities;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;

public class BedFrameTileEntity extends TileEntity {

	protected DefaultBedFrameMattress mattress;

	public BedFrameTileEntity() {
		mattress = new DefaultBedFrameMattress();
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return (oldState.getBlock() != newSate.getBlock());
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setString("mattress", mattress.getMattress().toString());
		super.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		mattress.setMattress(EnumMattressType.getType(compound.getString("mattress")));
		super.readFromNBT(compound);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == DRPMedievalCapabilities.MATTRESS;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return (T) mattress;
	}

	public Packet<?> getDescriptionPacket() {
		net.minecraft.network.play.server.SPacketUpdateTileEntity data = new net.minecraft.network.play.server.SPacketUpdateTileEntity() {

			@Override
			public void readPacketData(PacketBuffer buf) throws IOException {
				buf.writeString(mattress.getMattress().toString());
			}

			@Override
			public void writePacketData(PacketBuffer buf) throws IOException {
				switch (buf.readString(10)) {
				case "none":
					mattress.setMattress(EnumMattressType.NONE);
					break;
				case "straw":
					mattress.setMattress(EnumMattressType.STRAW);
					break;
				case "wool":
					mattress.setMattress(EnumMattressType.WOOL);
					break;
				default:
					mattress.setMattress(EnumMattressType.NONE);
					break;
				}
			}

		};
		return null;
	}

	@Override
	public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt){
		pkt.getNbtCompound();
    }
	
}
