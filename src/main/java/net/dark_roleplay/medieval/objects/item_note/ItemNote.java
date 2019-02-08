package net.dark_roleplay.medieval.objects.item_note;

import net.dark_roleplay.library_old.items.DRPItem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemNote extends DRPItem {

	public ItemNote(String name, String itemFolder, int stackSize, String... subNames) {
		super(name, itemFolder, stackSize, subNames);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(world.isRemote) Minecraft.getMinecraft().displayGuiScreen(new GuiItemNote());

		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
}
