package net.dark_roleplay.medieval.common.entities.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityTraining extends EntityLiving {

	public float rotation;

	@SideOnly(Side.CLIENT)
	public EntityTraining(World worldIn, double posX, double posY, double posZ) {
		this(worldIn);
		this.setPosition(posX, posY, posZ);
	}

	public EntityTraining(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void entityInit() {

	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompund) {

	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound) {

	}

}
