package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.objects.gui.general_storage.GeneralContainer;
import net.dark_roleplay.medieval.common.objects.gui.general_storage.GeneralGui;
import net.dark_roleplay.medieval.testing.blocks.spinning_wheel.ContainerSpinningWheel;
import net.dark_roleplay.medieval.testing.blocks.spinning_wheel.GuiSpinningWheel;
import net.dark_roleplay.medieval.testing.blocks.spinning_wheel.SpinningWheelTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class MedievalGuis implements IGuiHandler {

	public static final int GUI_GENERAL_STORAGE = 0;
	public static final int GUI_CRATE = 1;
	public static final int GUI_MINIGAME_MUSIK = 2;
	
	public static final int GUI_SPINNING_WHEEL_PARTS = 20;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		switch (ID) {
			case GUI_GENERAL_STORAGE:
				return new GeneralContainer( world.getTileEntity(new BlockPos(x, y, z)), player.inventory);
			case GUI_SPINNING_WHEEL_PARTS:
				TileEntity teSpinning = world.getTileEntity(new BlockPos(x, y, z));
				if(teSpinning instanceof SpinningWheelTileEntity)
					return new ContainerSpinningWheel((SpinningWheelTileEntity) world.getTileEntity(new BlockPos(x, y, z)), player.inventory);
				return null;
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		switch (ID) {
			case GUI_GENERAL_STORAGE:
				return new GeneralGui(new GeneralContainer( world.getTileEntity(new BlockPos(x, y, z)), player.inventory));
			case GUI_SPINNING_WHEEL_PARTS:
				TileEntity teSpinning = world.getTileEntity(new BlockPos(x, y, z));
				if(teSpinning instanceof SpinningWheelTileEntity)
					return new GuiSpinningWheel(new ContainerSpinningWheel((SpinningWheelTileEntity) world.getTileEntity(new BlockPos(x, y, z)), player.inventory));
				return null;
			default:
				return null;
		}
	}

}
