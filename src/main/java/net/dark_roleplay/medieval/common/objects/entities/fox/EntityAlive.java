package net.dark_roleplay.medieval.common.objects.entities.fox;

import net.minecraft.entity.EntityCreature;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityAlive extends EntityCreature{

    private static final DataParameter<Float> FOOD = EntityDataManager.<Float>createKey(EntityAlive.class, DataSerializers.FLOAT);

	public EntityAlive(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected void entityInit(){
		super.entityInit();
        this.dataManager.register(EntityAlive.FOOD, Float.valueOf(1.0F));
    }

    public final float getFood(){
        return this.dataManager.get(EntityAlive.FOOD).floatValue();
    }

    public void setFood(float food){
        this.dataManager.set(EntityAlive.FOOD, Float.valueOf(MathHelper.clamp(food, 0.0F, this.getMaxHealth())));
    }
	
}
