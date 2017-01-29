package net.drpmedieval.common.util;

import java.util.List;

import net.drpmedieval.common.entity.entitySittable.EntitySittable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class SittingUtil {


	public static boolean sitOnBlock(World par1World, double x, double y, double z, EntityPlayer player, double par6){
		if (!checkForExistingEntity(par1World, x, y, z, player)){
			EntitySittable nemb = new EntitySittable(par1World, x, y, z, par6);
			System.out.println("DEBUG1");
			if(par1World.spawnEntity(nemb))
				System.out.println("DEBUG2");
			if(player.startRiding(nemb))
				System.out.println("DEBUG3");
		}
		
		return true;
	}

	public static boolean sitOnBlockWithRotationOffset(World par1World, double x, double y, double z, EntityPlayer par5EntityPlayer, double par6, int metadata, double offset){
		if (!checkForExistingEntity(par1World, x, y, z, par5EntityPlayer)){
			EntitySittable nemb = new EntitySittable(par1World, x, y, z, par6, metadata, offset);
			par1World.spawnEntity(nemb);
			par5EntityPlayer.startRiding(nemb);
		}
		return true;
	}

	public static boolean checkForExistingEntity(World par1World, double x, double y, double z, EntityPlayer par5EntityPlayer)
	{
		List<EntitySittable> listEMB = par1World.getEntitiesWithinAABB(EntitySittable.class, new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).expand(1D, 1D, 1D));
		for (EntitySittable mount : listEMB)
		{
			if (mount.blockPosX == x && mount.blockPosY == y && mount.blockPosZ == z)
			{
				if (!mount.isBeingRidden())
				{
					par5EntityPlayer.startRiding(mount);
				}
				return true;
			}
		}
		return false;
	}
	
	public static boolean isSomeoneSitting(World world, double x, double y, double z)
	{
		List<EntitySittable> listEMB = world.getEntitiesWithinAABB(EntitySittable.class, new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D).expand(1D, 1D, 1D));
		for (EntitySittable mount : listEMB)
		{
			if (mount.blockPosX == x && mount.blockPosY == y && mount.blockPosZ == z)
			{
				return mount.isBeingRidden();
			}
		}
		return false;
	}
	
}
