package net.dark_roleplay.medieval.mess.common.testing.protection;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ProtectionHelper {

	public static boolean isProtected(World world, BlockPos pos){
		if((pos.getX() % 2) == 1)
			return true;
		return false;
	}
	
}
