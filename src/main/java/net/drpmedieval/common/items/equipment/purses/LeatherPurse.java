package net.drpmedieval.common.items.equipment.purses;

import net.drpcore.main.DarkRoleplayCore;
import net.drpcore.server.GuiHandler;
import net.drpcore.server.items.PurseBase;
import net.drpmedieval.common.DarkRoleplayMedieval;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LeatherPurse extends PurseBase {

	public LeatherPurse() {
		super(3);
		this.setUnlocalizedName("itemLeatherPurse");
		this.setMaxStackSize(1);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalEquipTab);
	}

}
