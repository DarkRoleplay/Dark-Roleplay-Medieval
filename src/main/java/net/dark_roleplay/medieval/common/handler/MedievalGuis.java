package net.dark_roleplay.medieval.common.handler;

import net.dark_roleplay.medieval.common.objects.blocks.tile_entities.TE_ChoppingBlock;
import net.dark_roleplay.medieval.common.objects.gui.chopping_block.ChoppingBlockContainer;
import net.dark_roleplay.medieval.common.objects.gui.chopping_block.ChoppingBlockGui;
import net.dark_roleplay.medieval.common.objects.gui.general_storage.GeneralContainer;
import net.dark_roleplay.medieval.common.objects.gui.general_storage.GeneralGui;
import net.dark_roleplay.medieval.testing.blocks.spinning_wheel.ContainerSpinningWheel;
import net.dark_roleplay.medieval.testing.blocks.spinning_wheel.GuiSpinningWheel;
import net.dark_roleplay.medieval.testing.blocks.spinning_wheel.SpinningWheelTileEntity;
import net.dark_roleplay.medieval.testing.purse.ItemInventoryContainer;
import net.dark_roleplay.medieval.testing.purse.PurseGUI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class MedievalGuis implements IGuiHandler {

	public static final int GUI_GENERAL_STORAGE = 0;
	public static final int GUI_CRATE = 1;
	public static final int GUI_MINIGAME_MUSIK = 2;
	public static final int GUI_GENERAL_ITEM_STORAGE = 3;

	public static final int GUI_SPINNING_WHEEL_PARTS = 20;
	public static final int GUI_CHOPPING_BLOCK = 21;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));

		switch (ID) {
			case GUI_GENERAL_STORAGE:
				return new GeneralContainer( te, player.inventory);
			case GUI_GENERAL_ITEM_STORAGE:
				return new ItemInventoryContainer(player.getHeldItem(EnumHand.MAIN_HAND), player.inventory);
			case GUI_SPINNING_WHEEL_PARTS:
				if(te instanceof SpinningWheelTileEntity)
					return new ContainerSpinningWheel((SpinningWheelTileEntity) te, player.inventory);
				return null;
			case GUI_CHOPPING_BLOCK:
				if(te instanceof TE_ChoppingBlock)
					return new ChoppingBlockContainer(te, player.inventory);
				return null;
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));

		switch (ID) {
			case GUI_GENERAL_STORAGE:
				return new GeneralGui(new GeneralContainer(te, player.inventory));
			case GUI_GENERAL_ITEM_STORAGE:
				return new PurseGUI(new ItemInventoryContainer(player.getHeldItem(EnumHand.MAIN_HAND), player.inventory));
			case GUI_SPINNING_WHEEL_PARTS:
				if(te instanceof SpinningWheelTileEntity)
					return new GuiSpinningWheel(new ContainerSpinningWheel((SpinningWheelTileEntity) te, player.inventory));
				return null;
			case GUI_CHOPPING_BLOCK:
				if(te instanceof TE_ChoppingBlock)
					return new ChoppingBlockGui(new ChoppingBlockContainer(te, player.inventory));
				return null;
			default:
				return null;
		}
	}

}
