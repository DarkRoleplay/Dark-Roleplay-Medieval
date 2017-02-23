package net.drpmedieval.common.items.equipment.ammunition;

import net.dark_roleplay.drpcore.api.items.DRPEquip;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;;

public class Quiver extends DRPEquip {

	public Quiver() {
		super("quiver", DRPEquip.DRPEquip_TYPE.TYPE_AMMO_STORAGE);
		this.setRegistryName("Quiver");
		this.setUnlocalizedName("Quiver");
		this.setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
