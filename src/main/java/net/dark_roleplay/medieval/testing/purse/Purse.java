package net.dark_roleplay.medieval.testing.purse;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.dark_roleplay.library.capabilities.CapabilityProvider;
import net.dark_roleplay.library_old.items.DRPItem;
import net.dark_roleplay.medieval.DarkRoleplayMedieval;
import net.dark_roleplay.medieval.common.handler.MedievalGuis;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class Purse extends DRPItem {

	public Purse(String name, String itemFolder, int stackSize) {
		super(name, itemFolder, stackSize);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		player.openGui(DarkRoleplayMedieval.INSTANCE, MedievalGuis.GUI_GENERAL_ITEM_STORAGE, world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

	@Override
	@Nullable
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
		return new CapabilityProvider<IItemHandler>(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY,
				new ItemStackHandler(3) {
					@Override
					public int getSlotLimit(int slot) {
						return 50;
					}

					@Override
					public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
						return (stack.getItem() instanceof ICoin);
					}
				});
	}
}
