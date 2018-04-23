package net.dark_roleplay.medieval.work_in_progress.board_1;

import net.dark_roleplay.medieval.work_in_progress.Action;
import net.dark_roleplay.medieval.work_in_progress.Board;
import net.dark_roleplay.medieval.work_in_progress.BoardControll;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class ActionMove implements Action{

	private Checker checker = null;
	private Field newField = null;
	private int boardID = -1;
	
	public ActionMove(Checker checker, int boardID, Field newField) {
		this.checker = checker;
		this.boardID = boardID;
		this.newField = newField;
	}
	
	@Override
	public void onActionReceived(Action a) {
		Board board = BoardControll.getBoard(a.getBoardID());
		if(board != null) board.onMove(a);
	}

	@Override
	public NBTTagCompound writeAction(NBTTagCompound tag) {
		if(tag == null)
			tag = new NBTTagCompound();
		
		return tag;
	}

	@Override
	public void readAction(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBoardID() {
		return this.boardID;
	}
}
