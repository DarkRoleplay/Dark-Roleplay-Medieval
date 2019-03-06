package net.dark_roleplay.medieval.testing.blocks.spinning_wheel;

import javax.annotation.Nonnull;

import net.dark_roleplay.medieval.holders.MedievalItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerSpinningWheel{}/*  extends Container{

	private SpinningWheelTileEntity te;

	public ContainerSpinningWheel(SpinningWheelTileEntity te, InventoryPlayer playerInventory) {
		this.te = te;

		//Wheel
        this.addSlotToContainer(new SlotItemHandler(te.inventory, 0, 26, 34));
        //Leather Strip
        this.addSlotToContainer(new SlotItemHandler(te.inventory, 1, 46, 34));
        //Pedal
        this.addSlotToContainer(new SlotItemHandler(te.inventory, 2, 66, 34));
        //Spindle
        this.addSlotToContainer(new SlotItemHandler(te.inventory, 3, 86, 34) {
        	@Override
            public boolean isItemValid(@Nonnull ItemStack stack){
                return stack.getItem() == MedievalItems.SPINDLE && super.isItemValid(stack);
            }
        });

        this.bindPlayerInventory(playerInventory);
	}

    protected void bindPlayerInventory(InventoryPlayer playerInventory){
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 9; x++){
                this.addSlotToContainer(new Slot(playerInventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++){
            this.addSlotToContainer(new Slot(playerInventory, x, 8 + x * 18, 142));
        }
    }

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		Vec3d playerPos = player.getPositionVector();
		return this.te.getPos().distanceSqToCenter(playerPos.x, playerPos.y, playerPos.z) < 5D;
	}

}*/
