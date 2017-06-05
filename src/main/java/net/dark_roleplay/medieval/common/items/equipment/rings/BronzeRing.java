package net.dark_roleplay.medieval.common.items.equipment.rings;


import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.dark_roleplay.medieval.common.handler.DRPMedievalCreativeTabs;

public class BronzeRing extends DRPEquip {

	public BronzeRing() {
		super("bronze_ring", "rings", DRPEquip.DRPEquip_TYPE.TYPE_RING);
		this.setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
