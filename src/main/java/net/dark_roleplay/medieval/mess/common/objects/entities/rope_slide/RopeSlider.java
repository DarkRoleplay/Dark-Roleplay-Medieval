package net.dark_roleplay.medieval.mess.common.objects.entities.rope_slide;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RopeSlider extends Entity{

	BlockPos target = null;
	Vec3d move = null;
	
	public RopeSlider(World world) {
		super(world);
	}
	
	public RopeSlider(World world, BlockPos pos, BlockPos target) {
		super(world);
		this.setPosition(pos.getX(), pos.getY(), pos.getZ());
		this.target = target;
	}
	
	@Override
	protected void entityInit() {
		this.setNoGravity(true);
		this.setInvisible(true);
	}
	
	@Override
	public void onUpdate(){
        if (!this.world.isRemote) {
        	if(this.move == null && target != null) {
	            BlockPos movement = this.getPosition().subtract(target);
	            double mult = 1D / ((movement.getX() * movement.getX()) + (movement.getY() * movement.getY()) + (movement.getZ() * movement.getZ()));
	            this.move = new Vec3d(mult * movement.getX(), mult * movement.getY(), mult * movement.getZ());
        	}else if(this.move != null) {
        		this.move(MoverType.SELF, this.move.x, this.move.y, this.move.z);
//        		this.motionX = this.move.x;
//        		this.motionY = this.move.y;
//        		this.motionZ = this.move.z;
        	}
        }

        super.onUpdate();
    }

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		
	}

}
