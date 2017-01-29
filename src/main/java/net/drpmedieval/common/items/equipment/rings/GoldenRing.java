package net.drpmedieval.common.items.equipment.rings;

import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;

public class GoldenRing extends DRPEquip {

	public GoldenRing() {
		super("rings", DRPEquip.DRPEquip_TYPE.TYPE_MONEY_STORAGE);
		this.setRegistryName("GoldenRing");
		this.setUnlocalizedName("GoldenRing");
		this.setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
