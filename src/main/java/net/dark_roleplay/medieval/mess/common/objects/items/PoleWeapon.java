package net.dark_roleplay.medieval.mess.common.objects.items;

import net.dark_roleplay.core.api.old.items.weapons.IExtendedRange;
import net.dark_roleplay.library_old.items.DRPItem;

public class PoleWeapon extends DRPItem implements IExtendedRange{

	private int additionalRange;
	
	public PoleWeapon(String name, int additionalRange, String... subNames){
		this(name, null, additionalRange, subNames);
	}
	
	public PoleWeapon(
			String name, String itemFolder, int additionalRange, String... subNames){
		super(name, itemFolder, 1, subNames);
		this.additionalRange = additionalRange;
	}

	@Override
	public float getRange() {
		return this.additionalRange;
	}

	
}
