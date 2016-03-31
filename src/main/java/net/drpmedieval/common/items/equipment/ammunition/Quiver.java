package net.drpmedieval.common.items.equipment.ammunition;

import net.drpcore.server.items.AmmunitionContainerBase;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;

public class Quiver extends AmmunitionContainerBase{
	
	public Quiver(){
		this.setUnlocalizedName("itemQuiver");
		this.setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}
	
}
