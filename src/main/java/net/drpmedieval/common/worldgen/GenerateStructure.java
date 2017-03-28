package net.drpmedieval.common.worldgen;

import java.util.Random;

import net.drpmedieval.common.blocks.DRPMBlocks;
import net.drpmedieval.common.worldgen.feature.GenerateAppleTree;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenerateStructure implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) {
		
//		if(random.nextInt(50) == 0){
//			int x = chunkX * 16 + random.nextInt(16);
//			int z = chunkZ * 16 + random.nextInt(16);
//			int y = getWorldHeightAt(world,x,z);
//			
//			boolean hasBiome = false;
//			
//			for(BiomeDictionary.Type type : BiomeDictionary.getTypes(world.getBiomeForCoordsBody(new BlockPos(x,y,z)))){
//				if(type == BiomeDictionary.Type.FOREST)
//					hasBiome = true;
//			}
//			
//			if(hasBiome){
////				switch(random.nextInt(1)){
////				case 0:
////					GenerateAppleTree.generateTree(world, new BlockPos(x,y,z).add(0,1,0),DRPMBlocks.APPLE_GREEN);
////					break;
////				case 1:
////					GenerateAppleTree.generateTree(world, new BlockPos(x,y,z).add(0,1,0),DRPMBlocks.APPLE_RED);
////					break;
////				case 2:
//					GenerateAppleTree.generateTree(world, new BlockPos(x,y,z).add(0,1,0),DRPMBlocks.APPLE_YELLOW);
////					break;
////					
////				}
//			}
//		}
	}

	private static int getWorldHeightAt(World world, int x, int z){
		int height = 0;
		for(int i = 0; i < 255; i ++){
			BlockPos pos = new BlockPos(x,i,z);
			IBlockState state = world.getBlockState(pos);
			Block block = state.getBlock();
			if(block.isSideSolid(state, world, pos, EnumFacing.UP)){
				height = i;
			}
		}
		return height;
	}
	
}
