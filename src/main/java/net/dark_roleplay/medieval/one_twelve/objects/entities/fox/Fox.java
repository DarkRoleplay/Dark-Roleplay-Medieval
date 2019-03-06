package net.dark_roleplay.medieval.one_twelve.objects.entities.fox;

public class Fox{}/* extends EntityCreature implements IWorldNameable{

	public Fox(World worldIn) {
        super(worldIn);
        this.setSize(0.9F, 0.6F);
        this.setAIMoveSpeed(0.5F);
	}
	
	@Override
	protected void initEntityAI(){
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(3, new EntityAIPanic(this, 0.8D));
        this.tasks.addTask(4, new EntityAITempt(this, 0.8D, Items.WHEAT, false));

        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.7D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));

        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityChicken>(this, EntityChicken.class, false));
    }
	
	@Override
	protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
    }

	@Override
	public boolean attackEntityAsMob(Entity entityIn){
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

        if (flag){
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }
}*/
