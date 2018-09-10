package net.dark_roleplay.medieval.mess.common.world_generation.feature;

import java.util.Random;

import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalConfig;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
		case 0: 
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		}
		
	}

	public void generateOverworld(World world, Random rand, int x, int z) {
		if(DRPMedievalConfig.WORLD_GEN.GENERATE_COPPER)
			generateOre(DRPMedievalBlocks.COPPER_ORE, world, rand, x, z, 6, 10, 3, 5, 68, Blocks.STONE);
		if(DRPMedievalConfig.WORLD_GEN.GENERATE_TIN)
			generateOre(DRPMedievalBlocks.TIN_ORE, world, rand, x, z, 4, 6, 5, 5, 68, Blocks.STONE);
		if(DRPMedievalConfig.WORLD_GEN.GENERATE_SILVER)
			generateOre(DRPMedievalBlocks.SILVER_ORE, world, rand, x, z, 5, 7, 1, 5, 32, Blocks.STONE);
		if(DRPMedievalConfig.WORLD_GEN.GENERATE_SULFUR)
			generateOre(DRPMedievalBlocks.SULFUR_ORE, world, rand, x, z, 5, 7, 2, 5, 12, Blocks.STONE);
		if(DRPMedievalConfig.WORLD_GEN.GENERATE_SALPETER)
			generateSalpeter(DRPMedievalBlocks.SALPETER_ORE, world, rand, x, z, 8, 12, 1, 60, 68, Blocks.STONE);

	}
	
	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn) {
		int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), vienSize);
		for(int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
		}
	}
	
	public void generateSalpeter(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn) {
		int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), vienSize);
		for(int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = 0;
			int zRand = chunkZ * 16 + random.nextInt(16);
			for(int j = 0; j < 128; j++){
				IBlockState state = world.getBlockState(new BlockPos(xRand,0 + j,zRand));
				if(state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.AIR){
					yRand = --j;
					break;
				}
			}
			
			gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
		}
	}
}
