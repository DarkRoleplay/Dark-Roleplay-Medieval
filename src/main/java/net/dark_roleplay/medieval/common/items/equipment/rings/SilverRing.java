package net.dark_roleplay.medieval.common.items.equipment.rings;

import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;

public class SilverRing extends DRPEquip {

	public SilverRing() {
		super("silver_ring","rings", DRPEquip.DRPEquip_TYPE.TYPE_MONEY_STORAGE);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}