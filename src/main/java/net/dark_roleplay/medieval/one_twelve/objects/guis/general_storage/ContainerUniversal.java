package net.dark_roleplay.medieval.one_twelve.objects.guis.general_storage;

public class ContainerUniversal{//  extends Container{
//
//	protected TileEntity te;
//	protected int slotCount;
//
//	public ContainerUniversal(TileEntity te, InventoryPlayer playerInventory) {
//		this.te = te;
//
//		if(this.te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
//			IItemHandler handler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
//
//			this.slotCount = handler.getSlots();
//
//			int size = handler.getSlots();
//
//			outer:
//			for(int y = 0; y < Math.ceil(size / 9F); y++) {
//				for(int x = 0; x < 9; x++) {
//					if(x + (y * 9) > size) break outer;
//			        this.addSlotToContainer(new SlotItemHandler(handler, x + (y * 9), 8 + (x * 18), 8 + (y * 18)));
//				}
//			}
//		}
//
//        this.bindPlayerInventory(playerInventory);
//	}
//
//    protected void bindPlayerInventory(InventoryPlayer playerInventory){
//        for (int y = 0; y < 3; y++){
//            for (int x = 0; x < 9; x++){
//                this.addSlotToContainer(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
//            }
//        }
//
//        for (int x = 0; x < 9; x++){
//            this.addSlotToContainer(new Slot(playerInventory, x, 8 + x * 18, 142));
//        }
//    }
//
//	@Override
//	public boolean canInteractWith(EntityPlayer player) {
//		Vec3d playerPos = player.getPositionVector();
//		return this.te.getPos().distanceSqToCenter(playerPos.x, playerPos.y, playerPos.z) < 7D;
//	}
//
//	@Override
//    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index){
//        ItemStack itemstack = ItemStack.EMPTY;
//        Slot slot = this.inventorySlots.get(index);
//
//        if (slot != null && slot.getHasStack()){
//            ItemStack itemstack1 = slot.getStack();
//            itemstack = itemstack1.copy();
//
//            if (index < this.slotCount) {
//                if (!this.mergeItemStack(itemstack1, this.slotCount, this.inventorySlots.size(), true)){
//                    return ItemStack.EMPTY;
//                }
//            } else if (!this.mergeItemStack(itemstack1, 0, this.slotCount, false)){
//                return ItemStack.EMPTY;
//            }
//
//            if (itemstack1.isEmpty()){
//                slot.putStack(ItemStack.EMPTY);
//            }else{
//                slot.onSlotChanged();
//            }
//        }
//
//        return itemstack;
//    }

}
