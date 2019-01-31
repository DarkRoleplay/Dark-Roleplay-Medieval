package net.dark_roleplay.medieval.objects.items.consumables.tools.paint_brush;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class ColorHandlerPaintBrush implements IItemColor {

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		return tintIndex == 1 ? 0x202020 : 0xFFFFFF;
	}

}
