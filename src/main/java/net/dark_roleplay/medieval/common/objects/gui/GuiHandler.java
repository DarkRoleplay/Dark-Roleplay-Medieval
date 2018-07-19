package net.dark_roleplay.medieval.common.objects.gui;

import java.util.ArrayList;

import net.dark_roleplay.medieval.client.gui.MusikMinigameGui;
import net.dark_roleplay.medieval.client.gui.Note;
import net.dark_roleplay.medieval.client.gui.storage.Gui_SimpleStorage;
import net.dark_roleplay.medieval.common.objects.blocks.tileentities.TE_DungeonChest;
import net.dark_roleplay.medieval.common.objects.blocks.tileentities.TileEntityCrate;
import net.dark_roleplay.medieval.common.objects.blocks.tileentities.storage.TileEntity_SimpleStorage;
import net.dark_roleplay.medieval.common.objects.gui.container.Container_SimpleStorage;
import net.dark_roleplay.medieval.common.objects.gui.storage.general.GeneralContainer;
import net.dark_roleplay.medieval.common.objects.gui.storage.general.GeneralGui;
import net.dark_roleplay.medieval.common.spinning_wheel.ContainerSpinningWheel;
import net.dark_roleplay.medieval.common.spinning_wheel.GuiSpinningWheel;
import net.dark_roleplay.medieval.common.spinning_wheel.SpinningWheelTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int GUI_GENERAL_STORAGE = 0;
	public static final int GUI_CRATE = 1;
	public static final int GUI_MINIGAME_MUSIK = 2;
	public static final int GUI_SIMPLE_STORAGE = 4;
	
	
	
	public static final int GUI_SPINNING_WHEEL_PARTS = 20;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		switch (ID) {
			case GUI_GENERAL_STORAGE:
				return new GeneralContainer( world.getTileEntity(new BlockPos(x, y, z)), player.inventory);
			case GUI_SIMPLE_STORAGE:
				BlockPos pos = new BlockPos(x, y, z);
		        TileEntity te = world.getTileEntity(pos);
		        if (te instanceof TileEntity_SimpleStorage)
					return new Container_SimpleStorage(player.inventory, (TileEntity_SimpleStorage) te);
				return null;
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
			case GUI_MINIGAME_MUSIK:
				ArrayList<Note> test = new ArrayList<Note>(){{
					
					this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_1_E);this.add(Note.HALF_1_E);this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_1_E);this.add(Note.HALF_1_E);this.add(Note.QUARTER_1_E);
					this.add(Note.QUARTER_1_F);this.add(Note.QUARTER_1_C);this.add(Note.QUARTER_1_D);this.add(Note.HALF_1_E);this.add(Note.QUARTER_1_F);this.add(Note.QUARTER_1_F);this.add(Note.QUARTER_1_F);
					this.add(Note.QUARTER_1_F);this.add(Note.QUARTER_1_F);this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_1_E);this.add(Note.EIGHT_1_E);this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_1_D);
					this.add(Note.QUARTER_1_D);this.add(Note.QUARTER_1_E);this.add(Note.HALF_1_D);this.add(Note.HALF_2_G);this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_1_E);this.add(Note.HALF_1_E);this.add(Note.QUARTER_1_E);
					this.add(Note.QUARTER_1_E);this.add(Note.HALF_1_E);this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_2_G);this.add(Note.QUARTER_1_C);this.add(Note.QUARTER_1_D);this.add(Note.FULL_1_E);this.add(Note.QUARTER_1_F);
					this.add(Note.QUARTER_1_F);this.add(Note.QUARTER_1_F);this.add(Note.QUARTER_1_F);this.add(Note.QUARTER_1_F);this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_2_G);
					this.add(Note.QUARTER_2_G);this.add(Note.QUARTER_1_F);this.add(Note.QUARTER_1_D);this.add(Note.HALF_1_C);this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_1_D);this.add(Note.QUARTER_1_C);this.add(Note.FULL_NONE);
					this.add(Note.QUARTER_1_E);this.add(Note.QUARTER_1_D);this.add(Note.QUARTER_1_C);this.add(Note.FULL_NONE);
					
					}};
				return new MusikMinigameGui(test);
			case GUI_SIMPLE_STORAGE:
				BlockPos pos = new BlockPos(x, y, z);
		        TileEntity te = world.getTileEntity(pos);
		        if (te instanceof TileEntity_SimpleStorage) {
		        	TileEntity_SimpleStorage containerTileEntity = (TileEntity_SimpleStorage) te;
		            return new Gui_SimpleStorage(containerTileEntity, new Container_SimpleStorage(player.inventory, containerTileEntity));
		        }
		        return null;
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
