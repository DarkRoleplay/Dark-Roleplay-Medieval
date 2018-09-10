package net.dark_roleplay.medieval.mess.common.objects.items;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import net.dark_roleplay.library_old.items.DRPItem;
import net.dark_roleplay.medieval.mess.api.items.ILock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Lock extends DRPItem implements ILock{

	public Lock(String name, int stackSize, String... subNames){
		super(name, null, stackSize, subNames);
	}
	
	public Lock(String name, String itemFolder, int stackSize, String... subNames){
		super(name, itemFolder, stackSize, subNames);
	}

	@Override
	public int getTier() {
		return 0;
	}

	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag){
		UUID id;
		if((id = this.getUUID(stack)) != null){
			tooltip.add(id.toString());
		}else{
			tooltip.add("Not combined");
		}
    }
}
