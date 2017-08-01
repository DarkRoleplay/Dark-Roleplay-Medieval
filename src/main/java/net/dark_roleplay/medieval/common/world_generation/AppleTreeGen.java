package net.dark_roleplay.medieval.common.world_generation;

import java.util.ArrayList;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class AppleTreeGen extends WorldGenerator{

	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		
		int height = 3 + rand.nextInt(5);
		
		ArrayList<BlockPos> fruitPos = Lists.<BlockPos>newArrayList();
		
		for(int i = 0; i < (height - 2); i++){
			world.setBlockState(position.add(0, i, 0), Blocks.LOG.getDefaultState());
		}
		
		for(int i = height - 2; i < height; i++){
			this.fillCube(position.add(-2, i, -2), 5, 1, 5, world, Blocks.LEAVES.getDefaultState());
			this.fillCube(position.add(-1, i + 1, -1), 3, 1, 3, world, Blocks.LEAVES.getDefaultState());
			world.setBlockState(position.add(0, i, 0), Blocks.LOG.getDefaultState());
		}
		return false;
	}
	
	private void fillCube(BlockPos startingPos, int sizeX, int sizeY, int sizeZ, World world, IBlockState state){
		for(int x = 0; x < sizeX; x++){
			for(int y = 0; y < sizeY; y++){
				for(int z = 0; z < sizeZ; z++){
					world.setBlockState(startingPos.add(x, y, z), Blocks.LEAVES.getDefaultState());
				}	
			}
		}
	}

}
