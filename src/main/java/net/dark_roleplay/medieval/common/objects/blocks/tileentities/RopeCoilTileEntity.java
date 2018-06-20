package net.dark_roleplay.medieval.common.objects.blocks.tileentities;

import java.util.List;

import net.dark_roleplay.medieval.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.common.objects.blocks.other.RopeCoil;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RopeCoilTileEntity extends TileEntity implements ITickable{
	
	private byte ticksPassed = 0;

	//VARIABLE SETTINGS NEED TO SAFE
	private int ropeAmount = 35;
	private int distance = 35;
	private int ropesToStay = 3;
	private int currentDistance = 0;
	private boolean isMoving = true;
	
	boolean lastState = false;
	
	public RopeCoilTileEntity() {}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);


		nbt.setInteger("ropeAmount", this.ropeAmount);
		nbt.setInteger("maxDistance", this.distance);
		nbt.setInteger("ropesToStay", this.ropesToStay);
		
		return nbt;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.ropeAmount = nbt.getInteger("ropeAmount");
		this.distance = nbt.getInteger("maxDistance");
		this.ropesToStay = nbt.getInteger("ropesToStay");
	}
	
	@Override
	public void update(){
		ticksPassed ++;
		if(lastState != world.getBlockState(this.pos).getValue(RopeCoil.POWERED)){
			ticksPassed = 0;
			lastState = !lastState;
			isMoving = true;
		}
		if(ticksPassed >= 15 && isMoving){
			ticksPassed = 0;
			World world = this.getWorld();
			
			boolean isDownGoing = !world.getBlockState(this.getPos()).getValue(RopeCoil.POWERED);
			int offset = 1;
			
			if(!world.isRemote)
			System.out.println(this.ropeAmount);
			//Upwards
			if(!isDownGoing){
				BlockPos offsetPos = this.getPos().add(0, -2, 0);
				for(int i = 0; i < distance + 1; i++){
					if(world.getBlockState(offsetPos).getBlock() == DRPMedievalBlocks.ROPE){
						offset++;
						offsetPos = offsetPos.add(0, -1, 0);
					}else{
						if(offset > 3){
							if(moveUp(world, offsetPos)){
								this.ropeAmount ++;
								this.currentDistance --;
							}else{
								isMoving = false;
							}
						}else{
							isMoving = false;
						}
						break;
					}
				}
			}
			else if(isDownGoing && !world.isRemote){
				//Downwards
				if(this.ropeAmount > 0){
					BlockPos offsetPos = this.getPos().add(0, -1, 0);
					for(int i = 0; i < distance; i++){
						IBlockState state = world.getBlockState(offsetPos);
						if(world.getBlockState(offsetPos).getBlock() == DRPMedievalBlocks.ROPE){
							offset++;
							offsetPos = offsetPos.add(0, -1, 0);
						}else{
							if(moveDown(world, offsetPos)){
								this.ropeAmount --;
								this.currentDistance ++;
							}else{
								isMoving = false;
							}
							break;
						}
					}
				}else{
					isMoving = false;
				}
			}
		
		}
    }
	
	private boolean moveUp(World world, BlockPos centerPos){
		IBlockState state = world.getBlockState(centerPos);
		if(world.getBlockState(centerPos.up()).getBlock() == DRPMedievalBlocks.ROPE){
			
			if(state.getMaterial() == Material.WOOD){
				
				boolean[][] toMove = getBlocksToMove(world, centerPos, true);
				
				for(int i = 0; i < 5; i++){
					for(int j = 0; j < 5; j++){
						if(toMove[i][j]){
							List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(centerPos.add(i-2, 2, j-2)));
							for(Entity entity : entities){
								entity.move(MoverType.SHULKER_BOX, 0, 1.0, 0);
							}
							entities = world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(centerPos.add(i-2, 1, j-2)));
							for(Entity entity : entities){
								entity.move(MoverType.SHULKER_BOX, 0, 1.0, 0);
							}
							if(!world.isRemote){
								world.setBlockState(centerPos.add(i-2, 2, j-2), world.getBlockState(centerPos.add(i-2, 1, j-2)));
								world.setBlockState(centerPos.add(i-2, 1, j-2), world.getBlockState(centerPos.add(i-2, 0, j-2)));
								world.setBlockToAir(centerPos.add(i-2, 0, j-2));
							}
						}
					}
				}
				if(!world.isRemote){
					world.setBlockState(centerPos.add(0, 1, 0), state);
					world.setBlockToAir(centerPos);
				}
			}else if(world.isAirBlock(centerPos)){
				if(!world.isRemote)
					world.setBlockToAir(centerPos.up());
			}
			return true;
		}
		return false;
	}
	
	private boolean moveDown(World world, BlockPos centerPos){
		IBlockState state = world.getBlockState(centerPos);
			
		if(state.getMaterial() == Material.WOOD){
			
			boolean[][] toMove = getBlocksToMove(world, centerPos, false);
			
			if(toMove[2][2]){
				for(int i = 0; i < 5; i++){
					for(int j = 0; j < 5; j++){
						if(toMove[i][j]){
							world.setBlockState(centerPos.add(i-2, -1, j-2), world.getBlockState(centerPos.add(i-2, 0, j-2)));
							world.setBlockState(centerPos.add(i-2, 0, j-2), world.getBlockState(centerPos.add(i-2, 1, j-2)));
							if(world.getBlockState(centerPos.add(i-2, 1, j-2)).getBlock() != DRPMedievalBlocks.ROPE) world.setBlockToAir(centerPos.add(i-2, 1, j-2));
						}
					}
				}
				world.setBlockState(centerPos.add(0, -1, 0), state);
				world.setBlockState(centerPos, DRPMedievalBlocks.ROPE.getDefaultState());
				return true;
			}
			
		}else{
			if(world.isAirBlock(centerPos)){
				world.setBlockState(centerPos, DRPMedievalBlocks.ROPE.getDefaultState());
				return true;
			}
		}
		return false;
	}
	
	public boolean[][] getBlocksToMove(World world, BlockPos centerPos, boolean moveUP){
		boolean[][] toMove = new boolean[5][5];
		
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				toMove[i][j] = world.getBlockState(centerPos.add(i-2, 0, j-2)).getMaterial() == Material.WOOD;
				toMove[i][j] = moveUP ? (world.isAirBlock(centerPos.add(i-2, 1, j-2)) ||( world.getBlockState(centerPos.add(i-2, 1, j-2)).getMaterial() == Material.WOOD && world.isAirBlock(centerPos.add(i-2, 2, j-2)))) && toMove[i][j] : world.isAirBlock(centerPos.add(i-2, -1, j-2)) && toMove[i][j];
			}
		}
		
		return toMove;
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate){
        return oldState.getBlock() != newSate.getBlock();
    }
}
