package net.dark_roleplay.medieval.mess.common.world_generation;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenHandler_Trees implements IWorldGenerator {

	private AppleTreeGen gen_apple_tree;
	
	public GenHandler_Trees(){
	    this.gen_apple_tree = new AppleTreeGen();
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
			case 0:
//				this.gen_apple_tree.generate(world, random, new BlockPos((chunkX * 16) + 8, 100, (chunkZ * 16) + 8));
				
				break;
			default:
				return;
		}
		
	}
}
