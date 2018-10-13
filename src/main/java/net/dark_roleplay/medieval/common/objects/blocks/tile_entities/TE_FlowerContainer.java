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

	public boolean addFlower(ItemStack stack, boolean isClient) {
		for(int i = 0; i < this.flowers.length; i++) {

			if(this.flowers[i] == null) {

				this.flowers[i] = isClient ? new FlowerDataClient(stack) : new FlowerData(stack);

				if(isClient) {
					this.flowers[i] = new FlowerDataClient(stack);
				}else {
					this.flowers[i] = new FlowerData(stack);
				}

				return true;
			}
		}
		return false;
	}

	public FlowerData[] getFlowerData() {
		return this.flowers;

	}

	@Override
	public boolean hasFastRenderer() {
		return false;//ToDo fix this some day
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
	}

	public static class FlowerDataClient extends FlowerData{

		IBakedModel model;
		IBlockState state;

		public FlowerDataClient(ItemStack stack) {
			super(stack);
		}

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

	}
}
