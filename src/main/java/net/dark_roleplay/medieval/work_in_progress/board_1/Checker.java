package net.dark_roleplay.medieval.work_in_progress.board_1;

import java.util.ArrayList;
import java.util.List;

public class Checker extends Figure{

	private boolean isChecker = false;
	
	public Checker(Field pos, CheckerBoard.Color color) {
		this.pos = pos;
		this.color = color;
	}
	
	@Override
	public List<Field> getPossibleMoves() {
		
		List<Field> fields = new ArrayList();
		
		int posX = this.pos.getPosX();
		int posY = this.pos.getPosY();
		
		if(!isChecker) {
			switch(this.getColor()) {
				case BLACK:
					if(posY > 0) {
						if(posX > 0) {
							fields.add(new Field(posX - 1, posY - 1));
						}
						if(posX < 7) {
							fields.add(new Field(posX + 1, posY - 1));
						}
					}
					break;
				case WHITE:
					if(posY < 7) {
						if(posX > 0) {
							fields.add(new Field(posX - 1, posY + 1));
						}
						if(posX < 7) {
							fields.add(new Field(posX + 1, posY + 1));
						}
					}
					break;
				default:
					break;
			}
		}else {
			
		}
		
		return null;
	}
	
}
