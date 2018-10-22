package net.dark_roleplay.medieval.client.objects.items.color_handlers;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class PaintBrushColors implements IItemColor {

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		return tintIndex == 1 ? 0x202020 : 0xFFFFFF;
	}

}
