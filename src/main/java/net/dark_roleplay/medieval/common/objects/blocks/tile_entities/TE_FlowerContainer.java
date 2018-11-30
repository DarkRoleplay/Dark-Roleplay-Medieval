package net.dark_roleplay.medieval.common.objects.blocks.tile_entities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants.NBT;

public class TE_FlowerContainer extends TileEntity{

	private FlowerData[] flowers = new FlowerData[0];

	public TE_FlowerContainer() {

	}

	public TE_FlowerContainer(int flowersAmount) {
		this.flowers = new FlowerData[flowersAmount];
	}

	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if(!compound.hasKey("FlowerAmount")) return;
        this.flowers = new FlowerData[compound.getInteger("FlowerAmount")];

        NBTTagList flowersList = compound.getTagList("Flowers", NBT.TAG_COMPOUND);

        for(int i = 0; i < flowersList.tagCount(); i++) {
        	NBTTagCompound flowerTag = flowersList.getCompoundTagAt(i);

        	FlowerData flower = new FlowerData(null);
        	flower.readFromNBT(flowerTag);
        	this.flowers[flowerTag.getByte("Position")] = flower;
        }

    }

	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        compound = super.writeToNBT(compound);

        NBTTagList flowerList = new NBTTagList();
        for(byte i = 0; i < this.flowers.length; i++) {
        	FlowerData flower = this.flowers[i];
        	if(flower == null) continue;
        	NBTTagCompound flowerTag = flower.writeToNBT();
        	flowerTag.setByte("Position", i);
        	flowerList.appendTag(flowerTag);
        }

        compound.setInteger("FlowerAmount", this.flowers.length);
        compound.setTag("Flowers", flowerList);

        return compound;
    }


    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
    	return new SPacketUpdateTileEntity(this.getPos(), 1, this.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public NBTTagCompound getUpdateTag(){
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt){
    	 NBTTagCompound tag = pkt.getNbtCompound();
         this.readFromNBT(tag);
    }


    @Override
    public void handleUpdateTag(NBTTagCompound tag){
        this.readFromNBT(tag);
    }

	public boolean addFlower(ItemStack stack) {
		for(int i = 0; i < this.flowers.length; i++) {
			stack.setCount(1);
			if(this.flowers[i] == null) {
				this.flowers[i] = new FlowerData(stack);
				return true;
			}
		}
		return false;
	}

	public ItemStack removeFlower() {
		for(int i = 0; i < this.flowers.length; i++) {
			if(this.flowers[i] != null) {
				ItemStack stack = this.flowers[i].getStack();
				this.flowers[i] = null;
				return stack;
			}
		}
		return ItemStack.EMPTY;
	}

	public FlowerData[] getFlowerData() {
		return this.flowers;

	}

	public static class FlowerData{
		protected ItemStack stack;

		public FlowerData(ItemStack stack) {
			this.stack = stack;
		}

		public void readFromNBT(NBTTagCompound compound) {
			this.stack = new ItemStack(compound);
		}

		public NBTTagCompound writeToNBT() {
			NBTTagCompound compound = new NBTTagCompound();
			compound = this.stack.writeToNBT(compound);

			return compound;
		}

		//Client Side code from bellow
		IBakedModel model;
		IBlockState state;

		public IBakedModel getModel() {
			return this.model;
		}

		public IBlockState getState() {
			return this.state;
		}

		public void gatherBakedModel() {
			Item item = this.stack.getItem();
			if(!(item instanceof ItemBlock)) return;

			ItemBlock block = (ItemBlock) item;

			IBlockState state = block.getBlock().getStateFromMeta(item.getMetadata(this.stack));
			this.state = state;

			BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
			this.model = blockrendererdispatcher.getModelForState(state);
		}

		public ItemStack getStack() {
			return this.stack;
		}
	}

//	public static class FlowerDataClient extends FlowerData{
//
//		IBakedModel model;
//		IBlockState state;
//
//		public FlowerDataClient(ItemStack stack) {
//			super(stack);
//		}
//
//		public IBakedModel getModel() {
//			return this.model;
//		}
//
//		public IBlockState getState() {
//			return this.state;
//		}
//
//		public void gatherBakedModel() {
//			Item item = this.stack.getItem();
//			if(!(item instanceof ItemBlock)) return;
//
//			ItemBlock block = (ItemBlock) item;
//
//			IBlockState state = block.getBlock().getStateFromMeta(item.getMetadata(this.stack));
//			this.state = state;
//
//			BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
//			this.model = blockrendererdispatcher.getModelForState(state);
//		}
//
//	}
}
