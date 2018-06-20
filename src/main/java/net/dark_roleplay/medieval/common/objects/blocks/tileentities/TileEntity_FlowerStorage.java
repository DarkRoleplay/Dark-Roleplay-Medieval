package net.dark_roleplay.medieval.common.objects.blocks.tileentities;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntity_FlowerStorage  extends TileEntity {

	private int flower1 = 0;
	private int flower2 = 0;
	private int flower3 = 0;
	
	public int getFlower(byte flower){
		switch(flower){
		case 0:
			return this.flower1;
		case 1:
			return this.flower2;
		case 2:
			return this.flower3;
		default:
			return 0;
		}
	}
	
	public void addFlower(int flowerID){
		if(flower1 == 0){
			flower1 = flowerID;
		}else if(flower2 == 0){
			flower2 = flowerID;
		}else if(flower3 == 0){
			flower3 = flowerID;
		}
		

        IBlockState state = world.getBlockState(getPos());
		world.notifyBlockUpdate(getPos(), state, state, 3);
		markDirty();
	}
	
	public int removeFlower(){
		int flower = 0;
		
		if(flower3 != 0){
			flower3 = 0;
			flower = flower3;
		}else if(flower2 != 0){
			flower2 = 0;
			flower = flower2;
		}else if(flower1 != 0){
			flower1 = 0;
			flower = flower1;
		}
		
		markDirty();
		if (world != null) {
            IBlockState state = world.getBlockState(getPos());
            world.notifyBlockUpdate(getPos(), state, state, 3);
        }
		
		return flower;
	}

    @Override
    public NBTTagCompound getUpdateTag() {
    	NBTTagCompound nbtTag = new NBTTagCompound();

        this.writeToNBT(nbtTag);
        return writeToNBT(nbtTag);
    }

    @Override

    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {

        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new SPacketUpdateTileEntity(getPos(), 1, nbtTag);
    }
    
    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("flower1") && compound.hasKey("flower2") && compound.hasKey("flower3")) {
            this.flower1 = compound.getInteger("flower1");
            this.flower2 = compound.getInteger("flower2");
            this.flower3 = compound.getInteger("flower3");
        } else {
        	this.flower1 = 0;
            this.flower2 = 0;
            this.flower3 = 0;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("flower1", this.flower1);
        compound.setInteger("flower2", this.flower2);
        compound.setInteger("flower3", this.flower3);
        return compound;
    }
}