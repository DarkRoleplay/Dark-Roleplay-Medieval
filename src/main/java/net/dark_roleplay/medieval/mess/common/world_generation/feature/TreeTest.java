package net.dark_roleplay.medieval.mess.common.world_generation.feature;

import java.util.Random;

import net.dark_roleplay.medieval.mess.common.objects.blocks.helper.TreePlant;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeTest {
	
	public static void generateTree(World world, BlockPos pos, TreePlant fruit){

		Random rnd = new Random();
		
		int height = rnd.nextInt(10) + 5;
		
		for(int i = 0; i < 8; i ++){
			
			float randomWidth = 1;
			
			while(randomWidth > 0.1){
				randomWidth = rnd.nextFloat();
			}
			
			randomWidth += 1;
			
			int curHeight = 0;
			float currentX = -1;
			
			while(curHeight < height){
				switch(i){
				case 0:
					world.setBlockState(pos.add(currentX,Math.exp(currentX) / randomWidth,0), Blocks.LEAVES.getDefaultState());
					System.out.println(randomWidth);
					break;
				case 1:
					break;
				case 2:
					//world.setBlockState(pos.add(0,k,Math.exp(width / k - 1)), Blocks.leaves.getDefaultState());
					break;
				case 3:
					break;
				case 4:
					//world.setBlockState(pos.add(-Math.exp(width / k - 1),k,0), Blocks.leaves.getDefaultState());
					break;
				case 5:
					break;
				case 6:
					//world.setBlockState(pos.add(0,k,-Math.exp(width / k - 1)), Blocks.leaves.getDefaultState());
					break;
				case 7:
					break;
				}
				curHeight = (int) (Math.exp(currentX) * randomWidth);
				currentX += 0.1F;
				
			}
			for(int k = 0; k < height; k++){
				
				
				

				Math.exp(k);
				
			}
			
		}
		
	}
	
}