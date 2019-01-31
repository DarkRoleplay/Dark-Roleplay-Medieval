package net.dark_roleplay.medieval.objects.packets.other;

import io.netty.buffer.ByteBuf;
import net.dark_roleplay.library.networking.PacketBase;
import net.dark_roleplay.medieval.holders.MedievalItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class MergeCoins extends PacketBase.Server<MergeCoins>{

	protected int slot = 0;

	public MergeCoins(){}

	public MergeCoins(int slot){
		this.slot = slot;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.slot = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.slot);
	}

	@Override
	public void handleServerSide(MergeCoins message, EntityPlayer player) {
		player.getServer().addScheduledTask(() -> {
			ItemStack stack = player.inventory.getStackInSlot(Math.min(player.inventory.getSizeInventory() - 1, message.slot));
			if(stack.getItem() != MedievalItems.BRONZE_COIN && stack.getItem() != MedievalItems.SILVER_COIN) return;
			ItemStack held = player.inventory.getItemStack();
			if(held.getItem() != MedievalItems.BRONZE_COIN && held.getItem() != MedievalItems.SILVER_COIN) return;

			if(held.getItem() == MedievalItems.BRONZE_COIN) {
				player.inventory.setInventorySlotContents(Math.min(player.inventory.getSizeInventory() - 1, message.slot), new ItemStack(MedievalItems.SILVER_COIN, 1));
				player.inventory.setItemStack(ItemStack.EMPTY);
			} else {
				player.inventory.setInventorySlotContents(Math.min(player.inventory.getSizeInventory() - 1, message.slot), new ItemStack(MedievalItems.GOLD_COIN, 1));
				player.inventory.setItemStack(ItemStack.EMPTY);
			}
			player.inventoryContainer.detectAndSendChanges();
		});
	}

}
