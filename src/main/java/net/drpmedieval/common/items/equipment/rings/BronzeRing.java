package net.drpmedieval.common.items.equipment.rings;


import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.drpmedieval.common.handler.DRPMedievalCreativeTabs;

public class BronzeRing extends DRPEquip {

	public BronzeRing() {
		super("rings", DRPEquip.DRPEquip_TYPE.TYPE_RING);
		this.setRegistryName("BronzeRing");
		this.setUnlocalizedName("BronzeRing");
		this.setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
