package net.dark_roleplay.medieval.common.entities.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TrainingDummy extends EntityLiving {

	public float rotation;
	public int health;

	public TrainingDummy(World worldIn) {
		super(worldIn);
		this.setSize(1F, 2F);
	}

	protected void entityInit() {

		super.entityInit();
		//this.dataWatcher.addObject(16, new Byte((byte) 0));
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {

		return 0.1F;
	}

	/**
	 * Gets the pitch of living sounds in living entities.
	 */
	protected float getSoundPitch() {

		return super.getSoundPitch() * 0.95F;
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {

		return "mob.bat.idle";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	//protected String getHurtSound() {

	//	return "mob.bat.hurt";
	//}

	/**
	 * Returns the sound this mob makes on death.
	 */
	//protected String getDeathSound() {

	//	return "mob.bat.death";
	//}

	public boolean canBePushed() {

		return true;
	}

	protected void collideWithEntity(Entity p_82167_1_) {}

	protected void collideWithNearbyEntities() {}

	protected void applyEntityAttributes() {

		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
	}

	public void onUpdate() {

		super.onUpdate();
	}

	protected void updateAITasks() {

		super.updateAITasks();

	}

	protected boolean canTriggerWalking() {

		return false;
	}

	public void fall(float distance, float damageMultiplier) {}

	protected void updateFallState(double y, boolean onGroundIn, Block blockIn, BlockPos pos) {}

	public boolean doesEntityNotTriggerPressurePlate() {

		return false;
	}

	public boolean attackEntityFrom(DamageSource source, float amount) {

		return false;
	}

	public void readEntityFromNBT(NBTTagCompound tagCompund) {

		super.readEntityFromNBT(tagCompund);
		//this.dataWatcher.updateObject(16, Byte.valueOf(tagCompund.getByte("BatFlags")));
	}

	public void writeEntityToNBT(NBTTagCompound tagCompound) {

		super.writeEntityToNBT(tagCompound);
		//tagCompound.setByte("BatFlags", this.dataWatcher.getWatchableObjectByte(16));
	}

	public boolean getCanSpawnHere() {

		return false;
	}

	public float getEyeHeight() {

		return this.height / 2.0F;
	}

}
