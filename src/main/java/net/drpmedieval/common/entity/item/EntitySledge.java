package net.drpmedieval.common.entity.item;

import javax.annotation.Nullable;

import net.drpmedieval.common.DarkRoleplayMedieval;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;

public class EntitySledge extends EntityLiving implements IWorldNameable {
	
	public EntitySledge(World worldIn){
        super(worldIn);
        this.setSize(1f, 0.5f);
        //this.preventEntitySpawning = true;
    }

    public EntitySledge(World worldIn, double x, double y, double z){
        this(worldIn);
        this.setPosition(posX, posY, posZ);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }
    
    @Override
	public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack){
        //if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new net.minecraftforge.event.entity.minecart.MinecartInteractEvent(this, player, stack, hand))) return true;

        if (player.isSneaking()){
            return false;
        }
        else if (this.isBeingRidden()){
            return true;
        }
        else{
            if (!this.worldObj.isRemote){
                player.startRiding(this);
            }
            return true;
        }
    }
}
