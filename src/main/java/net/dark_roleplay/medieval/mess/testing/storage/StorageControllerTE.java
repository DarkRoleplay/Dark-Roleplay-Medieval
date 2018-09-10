package net.dark_roleplay.medieval.mess.testing.storage;

import net.minecraft.tileentity.TileEntity;

public class StorageControllerTE extends TileEntity{

	protected ControllerStackHandler inventoryMain = null;

	public StorageControllerTE() {
		this(9);
	}
	
	public StorageControllerTE(int size) {
//		this.inventoryMain = new ItemStackHandler(size) {
//			@Override
//		    protected void onContentsChanged(int slot){
//				StorageControllerTE.this.markDirty();
//		    }
//		};
	}
	
}
