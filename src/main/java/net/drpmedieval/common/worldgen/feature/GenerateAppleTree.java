package net.drpmedieval.common.worldgen.feature;

import java.util.Collections;
import java.util.Random;

import net.drpmedieval.common.blocks.DRPMBlocks;
import net.drpmedieval.common.blocks.helper.TreePlant;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GenerateAppleTree {

	public static void generateTree(World world, BlockPos pos, TreePlant fruit){
		
		Random random = new Random();
		
		int height = random.nextInt(3) + 5;
		
		for(int i = 0; i < height ; i++){
			world.setBlockState(pos.add(0,i,0),DRPMBlocks.LOGS_1.getDefaultState());
		}
		
		for(int y = 0; y < 2; y ++){
			for(int x = 0; x < 5; x ++){
				for(int z = 0; z < 5; z++){
					BlockPos pos2 = pos.add(x - 2,height - y,z - 2);
					if((z == 0 || z == 4) && (x == 0 || x == 4)){
						if(random.nextBoolean())
							if(world.getBlockState(pos2).getBlock() == Blocks.AIR){
								world.setBlockState(pos2, DRPMBlocks.LEAVES_1.getDefaultState());
							}
					}else{
						if(world.getBlockState(pos2).getBlock() == Blocks.AIR){
							world.setBlockState(pos2, DRPMBlocks.LEAVES_1.getDefaultState());
						}
					}
				}
			}
		}
		
		for(int y = 0; y < 2; y ++){
			for(int x = 0; x < 3; x ++){
				for(int z = 0; z < 3; z++){
					BlockPos pos2 = pos.add(x - 1,height + y + 1,z - 1);
					if((z == 0 || z == 2) && (x == 0 || x == 2) && y == 0){
						if(random.nextBoolean())
							if(world.getBlockState(pos2).getBlock() == Blocks.AIR){
								world.setBlockState(pos2, DRPMBlocks.LEAVES_1.getDefaultState());
							}
					}else if(x == 1 || z == 1){
						if(world.getBlockState(pos2).getBlock() == Blocks.AIR){
							world.setBlockState(pos2, DRPMBlocks.LEAVES_1.getDefaultState());
						}
					}
				}
			}
		}
		
		for(int i = 0; i < random.nextInt(3) + 5; i++){
			
			int x = random.nextInt(5) - 2;
			int z = random.nextInt(5) - 2;
			
			int trys = 0;
			
			while(world.getBlockState(pos.add(x, height  - 1 ,z)).getBlock() != DRPMBlocks.LEAVES_1 && world.getBlockState(pos.add(x, height - 2 ,z)).getBlock() != Blocks.AIR && trys != 5){
				x = random.nextInt(5) - 2;
				z = random.nextInt(5) - 2;
				trys ++;
			}
			
			trys = 0;
			world.setBlockState(pos.add(x, height - 2,z), fruit.getStateFromMeta(random.nextInt(Collections.max(fruit.AGE.getAllowedValues()) - 2)));
		}
		
	}
	
}
