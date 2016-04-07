package net.drpmedieval.common.items.currency;

import java.util.ArrayList;

import net.drpcore.main.RandomSystems;
import net.drpcore.server.items.CurrencyBase;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BronzeCoin extends CurrencyBase {

	public BronzeCoin() {
		super(1, null);
		this.setUnlocalizedName("itemBronzeCoin");
		this.setMaxStackSize(100);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
		this.setValue(1);
	}
}
