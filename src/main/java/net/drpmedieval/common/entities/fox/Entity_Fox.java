package net.drpmedieval.common.entities.fox;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;

public class Entity_Fox extends EntityCreature implements IWorldNameable{

	public Entity_Fox(World worldIn) {
        super(worldIn);
        this.setSize(0.9F, 0.5F);
        this.setAIMoveSpeed(0.5F);
	}
	
	@Override
	protected void initEntityAI(){
//        this.tasks.addTask(0, new EntityAISwimming(this));
//        this.tasks.addTask(1, new EntityAIPanic(this, 0.6D));
//        this.tasks.addTask(3, new EntityAITempt(this, 0.6D, Items.WHEAT, false));
//        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.5D));
//        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
//        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

}
