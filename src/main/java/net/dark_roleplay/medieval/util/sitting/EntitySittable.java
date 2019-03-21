package net.dark_roleplay.medieval.util.sitting;

import net.dark_roleplay.medieval.holders.MedievalEntities;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntitySittable extends Entity {
	public int blockPosX;
	public int blockPosY;
	public int blockPosZ;

	private boolean enforceRotation = false;
	
	public EntitySittable(World world) {
		super(MedievalEntities.SITTABLE, world);
		this.noClip = true;
		this.height = 0.01F;
		this.width = 0.01F;
	}

	public EntitySittable(World world, double x, double y, double z, double yOffset) {
		this(world);
		this.blockPosX = (int) x;
		this.blockPosY = (int) y;
		this.blockPosZ = (int) z;
		setPosition(x + 0.5D, y + yOffset, z + 0.5D);
	}

	public EntitySittable(World world, double x, double y, double z, double yOffset, EnumFacing facing) {
		this(world);
		this.blockPosX = (int) x;
		this.blockPosY = (int) y;
		this.blockPosZ = (int) z;
		setPositionConsideringRotation(x + 0.5D, y + yOffset, z + 0.5D, facing);
	}

	public void setPositionConsideringRotation(double x, double y, double z, EnumFacing facing) {
		switch (facing) {
			case NORTH:
				setRotation(180, 0);
				break;
			case EAST:
				setRotation(270, 0);
				break;
			case SOUTH:
				setRotation(0, 0);
				break;
			case WEST:
				setRotation(90, 0);
				break;
			case UP:
			case DOWN:
			default:
				break;
		}
		setPosition(x, y, z);
	}

	@Override
	public double getMountedYOffset() {
		return this.height * 0.0D;
	}

	@Override
	protected boolean shouldSetPosAfterLoading() {
		return false;
	}

	@Override
	public void tick() {
		if (!this.getEntityWorld().isRemote) {
			if (!this.isBeingRidden()
					|| this.getEntityWorld().isAirBlock(new BlockPos(blockPosX, blockPosY, blockPosZ))) {
				this.remove();
			}
		}
	}

	/**
	 * Applies this boat's yaw to the given entity. Used to update the orientation
	 * of its passenger.
	 */
	protected void applyYawToEntity(Entity entityToUpdate) {
		entityToUpdate.setRenderYawOffset(this.rotationYaw);
		float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - this.rotationYaw);
		float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
		entityToUpdate.prevRotationYaw += f1 - f;
		entityToUpdate.rotationYaw += f1 - f;
		entityToUpdate.setRotationYawHead(entityToUpdate.rotationYaw);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void applyOrientationToEntity(Entity entityToUpdate) {
//		if(this.enforceRotation)
		this.applyYawToEntity(entityToUpdate);
	}

	@Override
	protected boolean canBeRidden(Entity entityIn) {
		return true;
	}

	@Override
	protected void registerData() {
	}

	@Override
	protected void readAdditional(NBTTagCompound compound) {
	}

	@Override
	protected void writeAdditional(NBTTagCompound compound) {
	}
}
