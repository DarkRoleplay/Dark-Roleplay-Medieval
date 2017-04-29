package net.dark_roleplay.medieval.common.items.entities;

import java.util.List;

import net.dark_roleplay.medieval.common.entity.item.EntitySledge;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Sledge extends Item{
	
	public Sledge() {
		this.setRegistryName("Sledge");
		this.setUnlocalizedName("Sledge");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}
	
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (facing == EnumFacing.DOWN)
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            boolean flag = worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos);
            BlockPos blockpos = flag ? pos : pos.offset(facing);

            if (!playerIn.canPlayerEdit(blockpos, facing, stack))
            {
                return EnumActionResult.FAIL;
            }
            else
            {
                BlockPos blockpos1 = blockpos.up();
                boolean flag1 = !worldIn.isAirBlock(blockpos) && !worldIn.getBlockState(blockpos).getBlock().isReplaceable(worldIn, blockpos);
                flag1 = flag1 | (!worldIn.isAirBlock(blockpos1) && !worldIn.getBlockState(blockpos1).getBlock().isReplaceable(worldIn, blockpos1));

                if (flag1)
                {
                    return EnumActionResult.FAIL;
                }
                else
                {
                    double d0 = (double)blockpos.getX();
                    double d1 = (double)blockpos.getY();
                    double d2 = (double)blockpos.getZ();
                    List<Entity> list = worldIn.getEntitiesWithinAABBExcludingEntity((Entity)null, new AxisAlignedBB(d0, d1, d2, d0 + 1.0D, d1 + 2.0D, d2 + 1.0D));

                    if (!list.isEmpty())
                    {
                        return EnumActionResult.FAIL;
                    }
                    else
                    {
                        if (!worldIn.isRemote)
                        {
                            worldIn.setBlockToAir(blockpos);
                            worldIn.setBlockToAir(blockpos1);
                            EntitySledge entitySledge = new EntitySledge(worldIn, d0 + 0.5D, d1, d2 + 0.5D);
                            float f = (float)MathHelper.floor(MathHelper.wrapDegrees(playerIn.rotationYaw - 180.0F)); //(float)MathHelper.floor_float((MathHelper.wrapDegrees(playerIn.rotationYaw - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                            entitySledge.setLocationAndAngles(d0 + 0.5D, d1, d2 + 0.5D, f, 0.0F);
                            ItemMonsterPlacer.applyItemEntityDataToEntity(worldIn, playerIn, stack, entitySledge);
                            worldIn.spawnEntity(entitySledge);
                            worldIn.playSound((EntityPlayer)null, entitySledge.posX, entitySledge.posY, entitySledge.posZ, SoundEvents.ENTITY_ARMORSTAND_PLACE, SoundCategory.BLOCKS, 0.75F, 0.8F);
                        }

                        stack.shrink(1);;
                        return EnumActionResult.SUCCESS;
                    }
                }
            }
        }
    }

}
