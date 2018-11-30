package net.dark_roleplay.medieval.common.objects.items.consumables;

import java.util.List;

import javax.annotation.Nullable;

import net.dark_roleplay.core_modules.locks.api.LockHelper;
import net.dark_roleplay.core_modules.locks.api.LockHelper.LockResult;
import net.dark_roleplay.core_modules.locks.api.items.ILock;
import net.dark_roleplay.core_modules.locks.handler.Localized;
import net.dark_roleplay.library_old.items.DRPItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Lock extends DRPItem implements ILock{

	public Lock(String name, String itemFolder, int stackSize, String... subNames){
		super(name, itemFolder, stackSize, subNames);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//		System.out.println(UUID.randomUUID().toString());
//		return EnumActionResult.SUCCESS;
		if(player.getHeldItemMainhand().hasTagCompound()){
			LockResult result = LockHelper.setLock(world, pos, player.getHeldItemMainhand());
			switch(result){
				case ALREADY_LOCKED:
					Localized.ALREADY_LOCKED.sendStatus(player, true);
					break;
				case INVALID_BLOCK:
					Localized.INVALID_BLOCK.sendStatus(player, true);
					break;
				case OTHER:
					Localized.ERROR.sendStatus(player, true);
					break;
				case SUCCESS:
					Localized.SUCCESS.sendStatus(player, true);
					break;
			}
		}

        return EnumActionResult.SUCCESS;
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
