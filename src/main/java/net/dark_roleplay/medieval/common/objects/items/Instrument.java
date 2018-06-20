package net.dark_roleplay.medieval.common.objects.items;

import net.dark_roleplay.library_old.items.DRPItem;
import net.dark_roleplay.medieval.common.testing.music.InstrumentSounds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Instrument extends DRPItem{

	private InstrumentSounds instrument;
	
	public Instrument(String name, InstrumentSounds instrument, String... subNames){
		this(name, null, instrument, subNames);
	}

	
	public Instrument(String name, String itemFolder, InstrumentSounds instrument, String... subNames){
		super(name, itemFolder, 1, subNames);
		this.instrument = instrument;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand){
//		Random rnd = new Random();
//		this.instrument.playInstrument(world, player, player.getPosition(), rnd.nextInt(12));
//		this.instrument.playInstrument(world, player, player.getPosition(), rnd.nextInt(12));
//		this.instrument.playInstrument(world, player, player.getPosition(), rnd.nextInt(12));
//
		return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
}
