package net.drpmedieval.common.items.misc;

import java.awt.Color;
import java.util.List;

import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class StringCoil extends Item {

	public StringCoil() {
		this.setRegistryName("StringCoil");
		this.setUnlocalizedName("StringCoil");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}

	public boolean hasColor(ItemStack stack) {

		NBTTagCompound nbttagcompound = stack.getTagCompound();
		return nbttagcompound != null && nbttagcompound.hasKey("display", 10) ? nbttagcompound.getCompoundTag("display").hasKey("color", 3) : false;
	}

	public int getColor(ItemStack stack) {

		NBTTagCompound nbttagcompound = stack.getTagCompound();
		if(nbttagcompound != null) {
			NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
			if(nbttagcompound1 != null && nbttagcompound1.hasKey("color", 3)) {
				return nbttagcompound1.getInteger("color");
			}
		}
		return 256 * 256 * 256 - 1;
	}

	public int blend(int a, int b, float ratio){
		if (ratio > 1f) {
	        ratio = 1f;
	    } else if (ratio < 0f) {
	        ratio = 0f;
	    }
	    float iRatio = 1.0f - ratio;

	    int aR = ((a & 0xff0000) >> 16);
	    int aG = ((a & 0xff00) >> 8);
	    int aB = (a & 0xff);

	    int bR = ((b & 0xff0000) >> 16);
	    int bG = ((b & 0xff00) >> 8);
	    int bB = (b & 0xff);

	    int R = (int) ((aR * iRatio) + (bR * ratio));
	    int G = (int) ((aG * iRatio) + (bG * ratio));
	    int B = (int) ((aB * iRatio) + (bB * ratio));

	    return R << 16 | G << 8 | B;
	}
	
	public void removeColor(ItemStack stack) {

		NBTTagCompound nbttagcompound = stack.getTagCompound();
		if(nbttagcompound != null) {
			NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
			if(nbttagcompound1.hasKey("color")) {
				nbttagcompound1.removeTag("color");
			}
		}
	}

	public void setColor(ItemStack stack, int color) {

		NBTTagCompound nbttagcompound = stack.getTagCompound();
		if(nbttagcompound == null) {
			nbttagcompound = new NBTTagCompound();
			stack.setTagCompound(nbttagcompound);
		}
		NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
		if( ! nbttagcompound.hasKey("display", 10)) {
			nbttagcompound.setTag("display", nbttagcompound1);
		}
		nbttagcompound1.setInteger("color", color);
	}
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand){
		
		System.out.println("Red: " + (((getColor(stack) / 256) / 256) % 256) + " Green: " + (((getColor(stack) / 256) % 256)) + " Blue: " + ((getColor(stack) % 256)));
		if(stack.hasDisplayName())
			setColor(stack,Integer.parseInt(stack.getDisplayName(),16));
		
        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }
	
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected){
		setColor(stack,getColor(stack) + 25);

    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced){
		tooltip.add("This Model has been designed by: Xor");
		tooltip.add("Visit his Website: http://models.xor.boole.io/");
		
    }
	
}
