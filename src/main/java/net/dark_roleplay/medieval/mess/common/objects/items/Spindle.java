package net.dark_roleplay.medieval.mess.common.objects.items;

import net.dark_roleplay.library_old.items.DRPItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

public class Spindle extends DRPItem{

	public Spindle(String name, String modelFolder) {
		super(name, modelFolder, 1);
		this.setMaxDamage(512);
	}

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
    	if(world.isRemote)
    		return new ActionResult<ItemStack>(EnumActionResult.PASS, player.getHeldItem(hand));

    	
    	ItemStack spindle = player.getHeldItem(hand);
    	ItemStack otherHand = player.getHeldItem(hand == EnumHand.MAIN_HAND ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND);
    	
    	if(otherHand.getItem() == Item.getItemFromBlock(Blocks.WOOL)) {
    		otherHand.shrink(1);
    		ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(Items.STRING, 1, 0));
        	spindle.attemptDamageItem(1, player.getRNG(), (EntityPlayerMP) player);
        	if(spindle.getItemDamage() > spindle.getMaxDamage()) {
        		spindle.shrink(1);
        	}
        	player.getFoodStats().addExhaustion(0.125F);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, spindle);
    	}else {
    		player.sendStatusMessage(new TextComponentTranslation("drpmedieval.items.spindle.no_wool"), true);
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.getHeldItem(hand));
    	}

    }

	
}
