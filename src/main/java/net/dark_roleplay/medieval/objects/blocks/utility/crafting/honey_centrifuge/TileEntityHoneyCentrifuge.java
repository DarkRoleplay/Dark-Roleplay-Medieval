package net.dark_roleplay.medieval.objects.blocks.utility.crafting.honey_centrifuge;

import net.dark_roleplay.core.api.storage.DynamicStorageTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;

public class TileEntityHoneyCentrifuge extends DynamicStorageTileEntity implements ITickable{

	private float progress = 0F;
	private float speed = 0F;
	private float lastRotation = 0F;
	private float rotation = 0F;

	public TileEntityHoneyCentrifuge() {
		super(4);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound = super.writeToNBT(compound);

		compound.setFloat("progress", this.progress);
		compound.setFloat("speed", this.speed);

		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.progress = compound.getFloat("progress");
		this.speed = compound.getFloat("speed");

		super.readFromNBT(compound);
	}

	public float getProgress() {
		return this.progress;
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
			this.progress += (this.speed / 20F);
			this.lastRotation = this.rotation;
			this.rotation += (this.speed / 20F);
			if(this.rotation >= 360) {
				this.lastRotation -= 360;
				this.rotation -= 360;
			}
			this.speed -= 10F;
		}else {
			this.lastRotation = this.rotation;
		}
	}
}