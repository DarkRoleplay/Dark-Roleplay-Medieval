package net.drpmedieval.common.items.misc;

import net.drpcore.main.DarkRoleplayCore;
import net.drpcore.server.GuiHandler;
import net.drpcore.server.items.PurseBase;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BatEar extends Item {

	public BatEar() {
		this.setUnlocalizedName("itemBatEar");
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
	}
}