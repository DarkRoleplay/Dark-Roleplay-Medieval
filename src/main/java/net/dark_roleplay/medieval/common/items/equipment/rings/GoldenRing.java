package net.dark_roleplay.medieval.common.items.equipment.rings;

import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;

public class GoldenRing extends DRPEquip {

	public GoldenRing() {
		super("golden_ring", "rings", DRPEquip.DRPEquip_TYPE.TYPE_MONEY_STORAGE);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
