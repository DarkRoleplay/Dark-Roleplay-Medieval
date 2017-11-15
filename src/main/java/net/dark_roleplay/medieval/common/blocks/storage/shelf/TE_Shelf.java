package net.dark_roleplay.medieval.common.blocks.storage.shelf;

import net.dark_roleplay.medieval.api.storage.LockStackHandler;
import net.dark_roleplay.medieval.common.blocks.tileentities.storage.TileEntity_SimpleStorage;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

public class TE_Shelf extends TileEntity {

    private ItemStackHandler itemStackHandler;
	
    public TE_Shelf(){
    	this(8);
    }
    
	public TE_Shelf(int size){
		this.itemStackHandler =  new ItemStackHandler(8) {
	        @Override
	        protected void onContentsChanged(int slot) {
	        	TE_Shelf.this.markDirty();
	        }
		};
	}
    
}
