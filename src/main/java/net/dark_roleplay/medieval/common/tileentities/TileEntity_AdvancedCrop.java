package net.dark_roleplay.medieval.common.tileentities;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import net.dark_roleplay.medieval.api.blocks.plants.Block_AdvancedCrop;
import net.dark_roleplay.medieval.common.blocks.other.RopeCoil;
import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntity_AdvancedCrop extends TileEntity implements ITickable{

	private byte ticksPassed = 0;
	
	private Map<BlockPos, Integer> crops = new HashMap<BlockPos, Integer>();
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt = super.writeToNBT(nbt);

		nbt.setInteger("crop_amount", crops.size());
		int i = 0;
		for(BlockPos pos : crops.keySet()){
			nbt.setIntArray("position_" + i, new int[]{pos.getX(), pos.getY(), pos.getZ()});
			nbt.setInteger("age_" + i, crops.get(pos));
			i++;
		}

		return nbt;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		
		int amount = nbt.getInteger("crop_amount");
		
		for(int i = 0; i < amount; i++){
			int[] pos = nbt.getIntArray("position_" + i);
			int age = nbt.getInteger("age_" + i);
			BlockPos position = new BlockPos(pos[0], pos[1], pos[2]);
		
			crops.put(position, age);
		}
	}
	
	@Override
	public void update(){
		ticksPassed ++;
		if(ticksPassed >= 200){
			System.out.println(this.getWorld().getCurrentDate().get(Calendar.DAY_OF_YEAR));
		}
    }
	
	public void updateCrops(){
		Iterator<BlockPos> oldCrops = this.crops.keySet().iterator();
		
		while(oldCrops.hasNext()){
			BlockPos pos = oldCrops.next();
			if(!(this.getWorld().getBlockState(pos).getBlock() instanceof Block_AdvancedCrop)){
				oldCrops.remove();
			}
		}
	}
	
	public boolean addCrop(BlockPos pos){
		if(!crops.containsKey(pos)){
			crops.put(pos, 0);
			return true;
		}else{
			return false;
		}
	}
	
	public void removeCrop(BlockPos pos){
		if(crops.containsKey(pos)){
			crops.remove(pos);
		}
	}
	
	public BlockPos getNextCrop(){
		BlockPos pos;
		this.updateCrops();
		if(this.crops.keySet().iterator().hasNext()){
			pos = this.crops.keySet().iterator().next();
//			while(!(this.getWorld().getBlockState(pos).getBlock() instanceof Block_AdvancedCrop)){
//				this.removeCrop(pos);
//				if(this.crops.keySet().iterator().hasNext()){
//					pos = this.crops.keySet().iterator().next();
//					break;
//				}else{
//					break none;
//				}
//	    	}
			return pos;
		}else{
			return null;
		}
	}
	
	public Set<BlockPos> getCrops(){
		return this.crops.keySet();
	}
	
}
