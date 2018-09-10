package net.dark_roleplay.medieval.mess.common.objects.blocks.decorative.flowers;

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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FlowersTileEntity extends TileEntity{
	
	private FlowerData[] flowers = new FlowerData[0];
	
	public FlowersTileEntity() {
		
	}

	
	public FlowersTileEntity(int flowersAmount) {
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
        	flowers[flowerTag.getByte("Position")] = flower;
        }
        
    }

	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        compound = super.writeToNBT(compound);
        
        NBTTagList flowerList = new NBTTagList();
        for(byte i = 0; i < flowers.length; i++) {
        	FlowerData flower = flowers[i];
        	if(flower == null) continue;
        	NBTTagCompound flowerTag = flower.writeToNBT();
        	flowerTag.setByte("Position", i);
        	flowerList.appendTag(flowerTag);
        }
        
        compound.setInteger("FlowerAmount", flowers.length);
        compound.setTag("Flowers", flowerList);
        
        return compound;
    }
	
	public boolean addFlower(ItemStack stack, boolean isClient) {
		for(int i = 0; i < flowers.length; i++) {

			if(flowers[i] == null) {
				
				flowers[i] = isClient ? new FlowerDataClient(stack) : new FlowerData(stack);
				
				if(isClient) {
					flowers[i] = new FlowerDataClient(stack);
				}else {
					flowers[i] = new FlowerData(stack);
				}
				
				return true;
			}
		}
		return false;
	}
	
	public FlowerData[] getFlowerData() {
		return flowers;
		
	}
	
	public boolean hasFastRenderer() {
		return false;//ToDo fix this some day
	}
	
	protected static class FlowerData{
		protected ItemStack stack;
		
		public FlowerData(ItemStack stack) {
			this.stack = stack;
		}
		
		public void readFromNBT(NBTTagCompound compound) {
			this.stack = new ItemStack(compound);
		}
		
		public NBTTagCompound writeToNBT() {
			NBTTagCompound compound = new NBTTagCompound();
			compound = stack.writeToNBT(compound);
			
			return compound;
		}
	}
	
	@SideOnly(Side.CLIENT)
	protected static class FlowerDataClient extends FlowerData{

		IBakedModel model;
		IBlockState state;
		
		public FlowerDataClient(ItemStack stack) {
			super(stack);
		}
		
		public IBakedModel getModel() {
			return model;
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
