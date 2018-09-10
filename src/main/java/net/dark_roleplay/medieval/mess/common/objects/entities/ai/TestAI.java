package net.dark_roleplay.medieval.mess.common.objects.entities.ai;

import net.dark_roleplay.medieval.mess.common.objects.entities.fox.EntityAlive;
import net.minecraft.entity.ai.EntityAIBase;

public class TestAI extends EntityAIBase{

	private final EntityAlive entity;

	public TestAI(EntityAlive entity){
		this.entity = entity;
		this.setMutexBits(1);

	    // DEBUG
	    System.out.println("EntityAIPanicHerdAnimal constructor()");
	}
	
	@Override
	public boolean shouldExecute() {
		return false;
	}

}
