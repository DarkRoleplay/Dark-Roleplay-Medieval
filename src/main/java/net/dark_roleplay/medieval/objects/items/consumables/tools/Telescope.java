package net.dark_roleplay.medieval.objects.items.consumables.tools;

import net.dark_roleplay.library_old.items.DRPItem;
import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Telescope extends DRPItem{

	public Telescope(String name, String foldername) {
		super(name, foldername, 1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer playerIn, EnumHand handIn){
		if(world.isRemote){
			DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL ++;

			if(DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL == 4){
				DarkRoleplayMedieval.ClientProxy.TELESCOPE_LEVEL = 0;
				Minecraft.getMinecraft().gameSettings.smoothCamera = false;
			}
		}
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }


}
