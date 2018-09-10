package net.dark_roleplay.medieval.mess.common.objects.entities;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Wheelbarrel extends Entity implements IWorldNameable {

	private static final DataParameter<Integer> TIME_SINCE_HIT = EntityDataManager.<Integer>createKey(EntityBoat.class,
			DataSerializers.VARINT);

	private float deltaRotation;
	private boolean leftInputDown;
	private boolean rightInputDown;
	private boolean forwardInputDown;
	private boolean backInputDown;

	public Wheelbarrel(World world) {
		super(world);
		this.preventEntitySpawning = true;
		this.setSize(1.0F, 1.0F);
	}

	public Wheelbarrel(World world, double x, double y, double z) {
		this(world);
		this.setPosition(x, y, z);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
	}

	@Override
	protected void entityInit() {
		this.dataManager.register(TIME_SINCE_HIT, Integer.valueOf(0));

	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		super.onUpdate();

		if (this.canPassengerSteer()) {

			// this.updateMotion();

			if (this.world.isRemote) {
				this.control();
				// this.world.sendPacketToServer(new CPacketSteerBoat(this.getPaddleState(0),
				// this.getPaddleState(1)));
			}

			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		} else {
			this.motionX = 0.0D;
			this.motionY = 0.0D;
			this.motionZ = 0.0D;
		}

		this.doBlockCollisions();
	}

	private void control() {
		if (this.isBeingRidden()) {

			float f = 0.0F;

			// if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown &&
			// !this.backInputDown) {
			// f += 0.005F;
			// }
			//
			// this.rotationYaw += this.deltaRotation;
			//
			if (this.forwardInputDown) {
				f += 0.04F;
			}

			if (this.backInputDown) {
				f -= 0.005F;
			}

			boolean hasMotion = this.motionX > 0F || this.motionZ > 0F || f > 0F;

			if (this.leftInputDown && hasMotion) {
				this.deltaRotation += -1.0F;
			}

			if (this.rightInputDown && hasMotion) {
				++this.deltaRotation;
			}

			this.motionX += (double) (MathHelper.sin(-this.rotationYaw * 0.017453292F) * f);
			this.motionZ += (double) (MathHelper.cos(this.rotationYaw * 0.017453292F) * f);
		}
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand) {
		System.out.println("Test");
		if (player.isSneaking()) {
			return false;
		} else {
			// if (!this.world.isRemote && this.outOfControlTicks < 60.0F) {
			player.startRiding(this);
			// }

			return true;
		}
	}

	public void updatePassenger(Entity passenger) {
		if (this.isPassenger(passenger)) {
			float f = 0.0F;
			float f1 = (float) ((this.isDead ? 0.009999999776482582D : this.getMountedYOffset())
					+ passenger.getYOffset());

			if (this.getPassengers().size() > 1) {
				int i = this.getPassengers().indexOf(passenger);

				if (i == 0) {
					f = 0.2F;
				} else {
					f = -0.6F;
				}

				if (passenger instanceof EntityAnimal) {
					f = (float) ((double) f + 0.2D);
				}
			}

			Vec3d vec3d = (new Vec3d((double) f, 0.0D, 0.0D))
					.rotateYaw(-this.rotationYaw * 0.017453292F - ((float) Math.PI / 2F));
			passenger.setPosition(this.posX + vec3d.x, this.posY + (double) f1, this.posZ + vec3d.z);
			passenger.rotationYaw += this.deltaRotation;
			passenger.setRotationYawHead(passenger.getRotationYawHead() + this.deltaRotation);
			this.applyYawToEntity(passenger);

			if (passenger instanceof EntityAnimal && this.getPassengers().size() > 1) {
				int j = passenger.getEntityId() % 2 == 0 ? 90 : 270;
				passenger.setRenderYawOffset(((EntityAnimal) passenger).renderYawOffset + (float) j);
				passenger.setRotationYawHead(passenger.getRotationYawHead() + (float) j);
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

	@SideOnly(Side.CLIENT)
	public void updateInputs(boolean lefInput, boolean rightInput, boolean forwardInput, boolean backwardInput) {
		this.leftInputDown = lefInput;
		this.rightInputDown = rightInput;
		this.forwardInputDown = forwardInput;
		this.backInputDown = backwardInput;
	}

	@SideOnly(Side.CLIENT)
	public void applyOrientationToEntity(Entity entityToUpdate) {
		this.applyYawToEntity(entityToUpdate);
	}

	protected boolean canFitPassenger(Entity passenger) {
		return this.getPassengers().size() < 2;
	}

	@Nullable
	public Entity getControllingPassenger() {
		List<Entity> list = this.getPassengers();
		return list.isEmpty() ? null : (Entity) list.get(0);
	}
}
