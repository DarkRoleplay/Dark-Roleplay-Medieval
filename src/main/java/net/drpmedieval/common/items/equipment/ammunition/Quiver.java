package net.drpmedieval.common.items.equipment.ammunition;

import net.drpcore.api.items.AmmunitionBase;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;;
public class Quiver extends AmmunitionBase {

	public Quiver() {
		this.setRegistryName("Quiver");
		this.setUnlocalizedName("Quiver");
		this.setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
