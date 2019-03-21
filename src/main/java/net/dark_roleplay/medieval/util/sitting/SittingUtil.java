package net.dark_roleplay.medieval.util.sitting;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class SittingUtil {

	public static boolean sitOnBlock(World world, double x, double y, double z, EntityPlayer player, double offset){
		if (!checkForExistingEntity(world, x, y, z, player) && !world.isRemote){
			if(!world.isRemote) {
				EntitySittable nemb = new EntitySittable(world, x, y, z, offset);
				world.spawnEntity(nemb);
				player.startRiding(nemb);
			}
		}
		
		return true;
	}

	public static boolean sitOnBlockWithRotation(World world, double x, double y, double z, EntityPlayer player, EnumFacing facing, double offset){
		if (!checkForExistingEntity(world, x, y, z, player)){
			EntitySittable nemb = new EntitySittable(world, x, y, z, offset, facing);
			world.spawnEntity(nemb);
			player.startRiding(nemb);
		}
		return true;
	}

	public static boolean checkForExistingEntity(World world, double x, double y, double z, EntityPlayer player){
		List<EntitySittable> listEMB = world.getEntitiesWithinAABB(EntitySittable.class, new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).expand(1D, 1D, 1D));
		for (EntitySittable mount : listEMB){
			if (mount.blockPosX == x && mount.blockPosY == y && mount.blockPosZ == z){
				if (!mount.isBeingRidden()){
					player.startRiding(mount);
				}
				return true;
			}
		}
		return false;
	}
	
	public static boolean isSomeoneSitting(World world, double x, double y, double z){
		List<EntitySittable> listEMB = world.getEntitiesWithinAABB(EntitySittable.class, new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).expand(1D, 1D, 1D));
		for (EntitySittable mount : listEMB){
			if (mount.blockPosX == x && mount.blockPosY == y && mount.blockPosZ == z){
				return mount.isBeingRidden();
			}
		}
		return false;
	}
}
