package net.dark_roleplay.medieval.common.objects.gui.storage.general;

import javax.annotation.Nonnull;

import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.common.spinning_wheel.SpinningWheelTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class GeneralContainer extends Container{

	protected TileEntity te;

	public GeneralContainer(TileEntity te, InventoryPlayer playerInventory) {
		this.te = te;
		
		if(this.te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
			IItemHandler handler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
			
			int size = handler.getSlots();
			
			for(int y = 0; y < Math.ceil(size / 9F); y++) {
				for(int x = 0; x < 9; x++) {
			        addSlotToContainer(new SlotItemHandler(handler, x + (y * 9), 5 + (x * 18), 5 + (y * 18)));
				}
			}
		}
		
        bindPlayerInventory(playerInventory);
	}
	
    protected void bindPlayerInventory(InventoryPlayer playerInventory){
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 9; x++){
                addSlotToContainer(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++){
            addSlotToContainer(new Slot(playerInventory, x, 8 + x * 18, 142));
        }
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		Vec3d playerPos = player.getPositionVector();
		return te.getPos().distanceSqToCenter(playerPos.x, playerPos.y, playerPos.z) < 7D;
	}

}
