package net.dark_roleplay.medieval.objects.items.equipment.tools;

import net.dark_roleplay.medieval.objects.helper.TelescopeHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemTelescope extends Item {

	public ItemTelescope(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(world.isRemote)
			TelescopeHelper.increaseZoom();
		
		return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
}