package net.dark_roleplay.medieval.mess.common.objects.items;

import java.util.Random;

import net.dark_roleplay.library_old.items.DRPItem;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WarHorn extends DRPItem{

	public WarHorn(String name, String itemFolder, int stackSize, String... subNames) {
		super(name, itemFolder, stackSize, subNames);
		this.setMaxDamage(512);
	}

	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
		BlockPos pos = player.getPosition();
		float heightPitchOffset = (pos.getY() - 62) * 0.00075F;
		System.out.println(heightPitchOffset);
		Random rnd = new Random();
		world.playSound(pos.getX(), pos.getY(), pos.getZ(), DRPMedievalSounds.WAR_HORN, SoundCategory.MASTER, 20F, 1F - (0.05F * + (rnd.nextFloat() - 0.5F)) + heightPitchOffset, true);	

		player.getHeldItem(hand).damageItem(1, player);

        player.getCooldownTracker().setCooldown(this, 60);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
