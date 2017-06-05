package net.dark_roleplay.medieval.common.items.equipment.purses;

import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;

public class LeatherPurse extends DRPEquip {

	public LeatherPurse() {
		//super(3);
		super("leather_purse", "purses", DRPEquip.DRPEquip_TYPE.TYPE_MONEY_STORAGE);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
