package net.dark_roleplay.medieval.common.skills.lumberjack;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeCutting {

	public static void cutTree(World world, BlockPos pos, EntityPlayer entityPlayer){
		if(!isTree(world, pos))
			return;

		System.out.println("DEBUG1");
		
		List<BlockPos> logs = getLogs(world, pos, new ArrayList<BlockPos>());
		
		for(BlockPos pos1 : logs){
			world.destroyBlock(pos1, true);
		}
	}
	
	private static boolean isTree(World world, BlockPos pos){
		Block ground;
		for(int i = 0; i < 5; i++){
			if((ground = world.getBlockState(pos.add(0, -i, 0)).getBlock()) == Blocks.DIRT || ground == Blocks.GRASS){
				for(int j = 0; j < 20; j++){
					if(world.getBlockState(pos.add(0, j, 0)).getBlock() instanceof BlockLeaves){
						return true;
					}else if(!(world.getBlockState(pos.add(0, j,0)).getBlock() instanceof BlockLog)){
						return false;
					}
				}
			}
		}
		
		return false;
	}
	
	private static List<BlockPos> getLogs(World world, BlockPos pos, List<BlockPos> logs){
		logs.add(pos);
		
		if(!logs.contains(pos.north()) && world.getBlockState(pos.north()).getBlock() instanceof BlockLog){
			logs = getLogs(world, pos.north(), logs);
		}
		if(!logs.contains(pos.east()) && world.getBlockState(pos.east()).getBlock() instanceof BlockLog){
			logs = getLogs(world, pos.east(), logs);
		}
		if(!logs.contains(pos.south()) && world.getBlockState(pos.south()).getBlock() instanceof BlockLog){
			logs = getLogs(world, pos.south(), logs);
		}
		if(!logs.contains(pos.west()) && world.getBlockState(pos.west()).getBlock() instanceof BlockLog){
			logs = getLogs(world, pos.west(), logs);
		}
		
		if(!logs.contains(pos.north().up()) && world.getBlockState(pos.north().up()).getBlock() instanceof BlockLog){
			logs = getLogs(world, pos.north().up(), logs);
		}
		if(!logs.contains(pos.east().up()) && world.getBlockState(pos.east().up()).getBlock() instanceof BlockLog){
			logs = getLogs(world, pos.east().up(), logs);
		}
		if(!logs.contains(pos.south().up()) && world.getBlockState(pos.south().up()).getBlock() instanceof BlockLog){
			logs = getLogs(world, pos.south().up(), logs);
		}
		if(!logs.contains(pos.west().up()) && world.getBlockState(pos.west().up()).getBlock() instanceof BlockLog){
			logs = getLogs(world, pos.west().up(), logs);
		}
		
		if(!logs.contains(pos.up()) && world.getBlockState(pos.up()).getBlock() instanceof BlockLog){
			logs = getLogs(world, pos.up(), logs);
		}
		
		return logs;
	}
}
