package net.drpmedieval.common.items.equipment.purses;


import net.drpcore.api.items.equip.PurseBase;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;

public class LeatherPurse extends PurseBase {

	public LeatherPurse() {
		super(3);
		this.setRegistryName("LeatherPurse");
		this.setUnlocalizedName("LeatherPurse");
		this.setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
