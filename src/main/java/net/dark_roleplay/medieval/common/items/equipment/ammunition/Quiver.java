package net.dark_roleplay.medieval.common.items.equipment.ammunition;

import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;

public class Quiver extends DRPEquip {

	public Quiver() {
		super("quiver", "quivers", DRPEquip.DRPEquip_TYPE.TYPE_AMMO_STORAGE);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
