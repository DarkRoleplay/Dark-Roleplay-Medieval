package net.dark_roleplay.medieval.client.events;

import net.dark_roleplay.medieval.common.items.misc.StringCoil;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class ItemColorHandler implements IItemColor{

	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex) {

		if(stack.getItem() instanceof StringCoil && tintIndex == 0){
			StringCoil coil = (StringCoil) stack.getItem();
			return coil.getColor(stack);
		}
		return 0;
	}}
