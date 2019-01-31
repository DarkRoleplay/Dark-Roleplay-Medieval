package net.dark_roleplay.medieval.objects.items.consumables;

import java.util.List;

import javax.annotation.Nullable;

import net.dark_roleplay.core_modules.locks.api.items.IKey;
import net.dark_roleplay.library_old.items.DRPItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Key extends DRPItem implements IKey{

	public Key(String name, String itemFolder, int stackSize, String... subNames){
		super(name, itemFolder, stackSize, subNames);
	}

	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
		if(stack.hasTagCompound()){
			tooltip.add(stack.getTagCompound().getString("keyID"));
		}else{
			tooltip.add("No Data");
		}
    }
}
