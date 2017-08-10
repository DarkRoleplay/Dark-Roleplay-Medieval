package net.dark_roleplay.medieval.common.items.equipment.weapons;

import net.dark_roleplay.drpcore.api.items.DRPItem;
import net.dark_roleplay.drpcore.api.items.weapons.IExtendedRange;

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
