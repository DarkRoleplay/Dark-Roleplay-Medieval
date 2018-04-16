package net.dark_roleplay.medieval.work_in_progress;

import java.util.HashMap;
import java.util.Map;

public class BoardControll {

	private static int nextID = 0;
	
	private static Map<Integer, Board> runningBoards = new HashMap<Integer, Board>();
	
	public static void addNewBoard(Board board) {
		runningBoards.put(nextID + 1, board);
		board.setID(nextID + 1);
		nextID ++;
	}
	
	public static Board getBoard(int id) {
		if(runningBoards.containsKey(id)) {
			return runningBoards.get(id);
		}
		
		return null;
	}
}
