package net.dark_roleplay.medieval.common.objects.blocks.tile_entities;

import net.minecraft.tileentity.TileEntity;

public class TileEntityBarrel extends TileEntity{

	StorageType storageType = StorageType.ITEMS;

	public TileEntityBarrel() {

	}



	public static enum StorageType {
		FLUID,
		ITEMS,
		DRINK
	}
}
