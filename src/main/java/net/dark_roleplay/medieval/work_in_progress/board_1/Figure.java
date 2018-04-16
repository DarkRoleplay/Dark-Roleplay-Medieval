package net.dark_roleplay.medieval.work_in_progress.board_1;

import java.util.List;

public abstract class Figure {

	protected Field pos;
	
	protected CheckerBoard.Color color = CheckerBoard.Color.BLACK;
	
	public abstract List<Field> getPossibleMoves();

	public Field getPos() {
		return pos;
	}

	public void moveTo(Field newPos) {
		if(getPossibleMoves().contains(newPos)){
			this.pos = newPos; 
		}
	}
	
	public CheckerBoard.Color getColor() {
		return color;
	}
}
