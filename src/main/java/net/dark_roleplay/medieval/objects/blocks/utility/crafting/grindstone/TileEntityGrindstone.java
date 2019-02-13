package net.dark_roleplay.medieval.objects.blocks.utility.crafting.grindstone;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityGrindstone extends TileEntity implements ITickable{

	private float speed = 0F;
	private float lastRotation = 0F;
	private float rotation = 0F;


	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound = super.writeToNBT(compound);
		compound.setFloat("speed", this.speed);

		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.speed = compound.getFloat("speed");

		super.readFromNBT(compound);
	}

	public float getSpeed() {
		return this.speed;
	}

	public void addSpeed(float speed) {
		this.speed = Math.min(speed + this.speed, 1440F);
	}

	public float getRotation() {
		return this.rotation;
	}

	public float getLastRotation() {
		return this.lastRotation;
	}

	@Override
	public void update() {
		if(this.speed > 0) {
			this.lastRotation = this.rotation;
			this.rotation += (this.speed / 20F);
			if(this.rotation >= 360) {
				this.lastRotation -= 360;
				this.rotation -= 360;
			}
			this.speed -= 7F;
		}else {
			this.lastRotation = this.rotation;
		}
	}
}