package net.drpmedieval.common.items.consumable;

import net.drpmedieval.common.entity.projectile.EntityRopedArrow;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RopedArrow extends ItemArrow{

    public RopedArrow(){
		this.setRegistryName("RopedArrow");
		this.setUnlocalizedName("RopedArrow");
        this.setCreativeTab(null);
    }

    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter){
        EntityRopedArrow entityRopedArrow = new EntityRopedArrow(worldIn, shooter);
        return entityRopedArrow;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player){
        return false;
    }
	
}
