package net.dark_roleplay.medieval.objects.blocks.decoration.shop_signs;

import net.dark_roleplay.medieval.objects.guis.sign_drawing.GuiSignDrawing;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DrawingGuiHelper {

	public static void openGUI(World world, BlockPos pos) {
		if(!world.isRemote) return;
		Minecraft.getMinecraft().displayGuiScreen(new GuiSignDrawing((TileEntityShopSign) world.getTileEntity(pos)));
	}

}
