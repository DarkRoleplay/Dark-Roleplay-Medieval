package net.dark_roleplay.medieval.holders;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class MedievalGuis{

	public static final int GUI_GENERAL_STORAGE = 0;
	public static final int GUI_CRATE = 1;
	public static final int GUI_MINIGAME_MUSIK = 2;
	public static final int GUI_GENERAL_ITEM_STORAGE = 3;

	public static final int GUI_SPINNING_WHEEL_PARTS = 20;
	public static final int GUI_CHOPPING_BLOCK = 21;
	
//	@Override
//	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public static GuiScreen openGui(FMLPlayMessages.OpenContainer message) {
		return null;
	}
	
//	@Override
//	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
//
//		switch (ID) {
//			case GUI_GENERAL_STORAGE:
//				return new ContainerUniversal( te, player.inventory);
//			case GUI_GENERAL_ITEM_STORAGE:
//				return new ItemInventoryContainer(player.getHeldItem(EnumHand.MAIN_HAND), player.inventory);
//			case GUI_SPINNING_WHEEL_PARTS:
//				if(te instanceof SpinningWheelTileEntity)
//					return new ContainerSpinningWheel((SpinningWheelTileEntity) te, player.inventory);
//				return null;
//			case GUI_CHOPPING_BLOCK:
//				if(te instanceof TileEntityChoppingBlock)
//					return new ContainerChoppingBlock(te, player.inventory);
//				return null;
//			default:
//				return null;
//		}
//	}
//
//	@Override
//	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
//
//		switch (ID) {
//			case GUI_GENERAL_STORAGE:
//				return new GuiUniversal(new ContainerUniversal(te, player.inventory));
//			case GUI_GENERAL_ITEM_STORAGE:
//				return new PurseGUI(new ItemInventoryContainer(player.getHeldItem(EnumHand.MAIN_HAND), player.inventory));
//			case GUI_SPINNING_WHEEL_PARTS:
//				if(te instanceof SpinningWheelTileEntity)
//					return new GuiSpinningWheel(new ContainerSpinningWheel((SpinningWheelTileEntity) te, player.inventory));
//				return null;
//			case GUI_CHOPPING_BLOCK:
//				if(te instanceof TileEntityChoppingBlock)
//					return new GuiChoppingBlock(new ContainerChoppingBlock(te, player.inventory));
//				return null;
//			default:
//				return null;
//		}
//	}

}
