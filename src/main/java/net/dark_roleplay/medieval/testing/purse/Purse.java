package net.dark_roleplay.medieval.testing.purse;

public class Purse{}/*  extends DRPItem {

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
*/