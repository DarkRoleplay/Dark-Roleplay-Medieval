package net.dark_roleplay.medieval.work_in_progress.board_1;

import java.util.HashSet;
import java.util.Set;

import net.dark_roleplay.medieval.work_in_progress.Action;
import net.dark_roleplay.medieval.work_in_progress.Board;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class CheckerBoard extends IForgeRegistryEntry.Impl<Board> implements Board{
	
	private EntityPlayer playerBlack = null;
	private EntityPlayer playerWhite = null;
	
	private Set<Checker> checkersBlack = new HashSet<Checker>();
	private Set<Checker> checkersWhite = new HashSet<Checker>();
	
	private int boardID = -1;
	
	private boolean currentTurn = false;
	
	public CheckerBoard() {
		this.setRegistryName("drpmedieval:board_1");
		int offset = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				checkersWhite.add(new Checker(new Field(j * 2 + offset, i), CheckerBoard.Color.WHITE));
				checkersBlack.add(new Checker(new Field(7 - j * 2 + offset, 7 - i), CheckerBoard.Color.BLACK));
			}
		}
	}

	@Override
	public boolean canJoin() {
		return playerBlack == null || playerWhite == null;
	}

	@Override
	public void join(EntityPlayer player) {
		if(playerBlack == null) {
			playerBlack = player;
		}else if(playerWhite == null) {
			playerWhite = player;
		}
	}

	@Override
	public void leave(EntityPlayer player) {
		if(playerBlack == player) {
			playerBlack = null;
		}else if(playerWhite == player) {
			playerWhite = null;
		}
	}

	@Override
	public byte getMaxParticipants() {
		return 2;
	}
	
	@Override
	public int getID() {
		return this.boardID;
	}

	@Override
	public void setID(int id) {
		this.boardID = id;
	}
	
	@Override
	public NBTTagCompound writeBoard(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readBoard(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int checkWin() {
		return checkersWhite.isEmpty() ? 1 : checkersBlack.isEmpty() ? 2 : 0;
	}

	@Override
	public void onMove(Action action) {
		// TODO Auto-generated method stub
		
	}

	public static enum Color{
		BLACK,
		WHITE;
	}
}
