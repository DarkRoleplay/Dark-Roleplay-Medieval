package net.dark_roleplay.medieval.common.entities.entity.projectile;

import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityRopedArrow extends EntityArrow{
	
    private static final DataParameter<Integer> ROPE_AMOUNT = EntityDataManager.<Integer>createKey(EntityTippedArrow.class, DataSerializers.VARINT);
	
    public EntityRopedArrow(World worldIn){
        super(worldIn);
        this.setSize(1f, 1f);
    }

    public EntityRopedArrow(World worldIn, double x, double y, double z){
        super(worldIn, x, y, z);
    }

    public EntityRopedArrow(World worldIn, EntityLivingBase shooter){
        super(worldIn, shooter);
    }
    
    protected void entityInit(){
        super.entityInit();
        this.dataManager.register(ROPE_AMOUNT, Integer.valueOf(0));
    }
    
    public void writeEntityToNBT(NBTTagCompound compound){
        super.writeEntityToNBT(compound);
        compound.setInteger("ropes_amount", this.dataManager.get(ROPE_AMOUNT));
    }

    public void readEntityFromNBT(NBTTagCompound compound){
        super.readEntityFromNBT(compound);
    	this.dataManager.set(ROPE_AMOUNT, Integer.valueOf(compound.getInteger("ropes_amount")));
    }
    
    protected void arrowHit(EntityLivingBase living){
        super.arrowHit(living);
    }
    
    protected ItemStack getArrowStack(){
    	return new ItemStack(DRPMedievalItems.ROPED_ARROW);
    }
    
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id){
        if (id == 0){}else{
            super.handleStatusUpdate(id);
        }
    }
}
