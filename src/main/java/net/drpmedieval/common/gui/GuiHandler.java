package net.drpmedieval.common.gui;

import java.util.ArrayList;

import net.drpmedieval.client.gui.MusikMinigameGui;
import net.drpmedieval.client.gui.Note;
import net.drpmedieval.common.blocks.tileentitys.TileEntityCrate;
import net.drpmedieval.common.blocks.tileentitys.TileEntityDungeonChest;
import net.drpmedieval.common.gui.container.ContainerCrate;
import net.drpmedieval.common.gui.container.ContainerDungeonChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int GUI_DUNGEONCHEST = 0;
	public static final int GUI_CRATE = 1;
	public static final int GUI_MINIGAME_MUSIK = 2;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		switch (ID) {
			case GUI_DUNGEONCHEST:
				return new ContainerDungeonChest(player.inventory, (TileEntityDungeonChest) world.getTileEntity(new BlockPos(x, y, z)));
			case GUI_CRATE:
				return new ContainerCrate(player.inventory, (TileEntityCrate) world.getTileEntity(new BlockPos(x, y, z)));
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		switch (ID) {
			case GUI_DUNGEONCHEST:
				return new GuiDungeonChest(new ContainerDungeonChest(player.inventory, (TileEntityDungeonChest) world.getTileEntity(new BlockPos(x, y, z))));
			case GUI_CRATE:
				return new GuiCrate(new ContainerCrate(player.inventory, (TileEntityCrate) world.getTileEntity(new BlockPos(x, y, z))));
			case GUI_MINIGAME_MUSIK:
				ArrayList<Note> test = new ArrayList<Note>(){{
					
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_E);
					add(Note.HALF_1_E);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_E);
					add(Note.HALF_1_E);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_C);
					add(Note.QUARTER_1_D);
					add(Note.HALF_1_E);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_E);
					add(Note.EIGHT_1_E);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_D);
					add(Note.QUARTER_1_D);
					add(Note.QUARTER_1_E);
					add(Note.HALF_1_D);
					add(Note.HALF_2_G);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_E);
					add(Note.HALF_1_E);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_E);
					add(Note.HALF_1_E);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_2_G);
					add(Note.QUARTER_1_C);
					add(Note.QUARTER_1_D);
					add(Note.FULL_1_E);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_2_G);
					add(Note.QUARTER_2_G);
					add(Note.QUARTER_1_F);
					add(Note.QUARTER_1_D);
					add(Note.HALF_1_C);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_D);
					add(Note.QUARTER_1_C);
					add(Note.FULL_NONE);
					add(Note.QUARTER_1_E);
					add(Note.QUARTER_1_D);
					add(Note.QUARTER_1_C);
					add(Note.FULL_NONE);
					
					}};
				return new MusikMinigameGui(test);
			default:
				return null;
		}
	}

}
