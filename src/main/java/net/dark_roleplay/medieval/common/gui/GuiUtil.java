package net.dark_roleplay.medieval.common.gui;

import net.dark_roleplay.medieval.client.gui.carving.Gui_CarveSign;
import net.dark_roleplay.medieval.common.objects.blocks.util.shop_sign.TE_ShopSign;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GuiUtil {

	public static void openShopSignGui(World world, BlockPos pos){
		if(world.isRemote)
			Minecraft.getMinecraft().displayGuiScreen(new Gui_CarveSign((TE_ShopSign) world.getTileEntity(pos))); 
	}
	
}
