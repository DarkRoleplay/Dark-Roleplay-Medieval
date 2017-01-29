package net.drpmedieval.common.items.equipment.purses;

import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;

public class LeatherPurse extends DRPEquip {

	public LeatherPurse() {
		//super(3);
		super("purses", DRPEquip.DRPEquip_TYPE.TYPE_MONEY_STORAGE);
		this.setRegistryName("LeatherPurse");
		this.setUnlocalizedName("LeatherPurse");
		this.setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
