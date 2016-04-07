package net.drpmedieval.common.items.currency;

import java.util.ArrayList;

import net.drpcore.main.RandomSystems;
import net.drpcore.server.items.CurrencyBase;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class SilverCoin extends CurrencyBase {

	public SilverCoin() {
		super(100, null);
		this.setUnlocalizedName("itemSilverCoin");
		this.setMaxStackSize(100);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
		this.setValue(100);
	}
}