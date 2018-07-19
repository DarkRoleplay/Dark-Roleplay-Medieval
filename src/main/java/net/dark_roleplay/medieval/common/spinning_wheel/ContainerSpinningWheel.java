package net.dark_roleplay.medieval.common.spinning_wheel;

import javax.annotation.Nonnull;

import net.dark_roleplay.core.common.handler.DRPCoreItems;
import net.dark_roleplay.medieval.common.handler.DRPMedievalItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerSpinningWheel extends Container{

	private SpinningWheelTileEntity te;
	
	public ContainerSpinningWheel(SpinningWheelTileEntity te, InventoryPlayer playerInventory) {
		this.te = te;
		
		//Wheel
        addSlotToContainer(new SlotItemHandler(te.inventory, 0, 26, 34));
        //Leather Strip
        addSlotToContainer(new SlotItemHandler(te.inventory, 1, 46, 34));
        //Pedal
        addSlotToContainer(new SlotItemHandler(te.inventory, 2, 66, 34));
        //Spindle
        addSlotToContainer(new SlotItemHandler(te.inventory, 3, 86, 34) {
        	@Override
            public boolean isItemValid(@Nonnull ItemStack stack){
                return stack.getItem() == DRPMedievalItems.SPINDLE && super.isItemValid(stack);
            }
        });

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
		return te.getPos().distanceSqToCenter(playerPos.x, playerPos.y, playerPos.z) < 5D;
	}

}
