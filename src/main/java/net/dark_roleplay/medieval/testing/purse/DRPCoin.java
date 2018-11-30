package net.dark_roleplay.medieval.testing.purse;

import net.dark_roleplay.library_old.items.DRPItem;

public class DRPCoin extends DRPItem implements ICoin{

	//TODO Move away from ICoin
	public DRPCoin(String name, String itemFolder, int stackSize, String... subNames) {
		super(name, itemFolder, stackSize, subNames);
	}

}
