package net.drpmedieval.common.items.currency;

import java.util.ArrayList;

import net.drpcore.server.items.CurrencyBase;
import net.drpmedieval.common.util.DRPMedievalCreativeTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class GoldenCoin extends CurrencyBase {

	public GoldenCoin() {
		super(10000, new ArrayList<CurrencyBase>() {

			{
				add(new SilverCoin());
				add(new BronzeCoin());
			}
		});
		this.setUnlocalizedName("itemGoldenCoin");
		this.setMaxStackSize(100);
		this.setCreativeTab(DRPMedievalCreativeTabs.drpmedievalMiscTab);
		this.setValue(10000);
	}
}
