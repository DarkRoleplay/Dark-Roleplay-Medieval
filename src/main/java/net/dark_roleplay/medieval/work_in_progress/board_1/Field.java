package net.dark_roleplay.medieval.work_in_progress.board_1;

public class Field {
	
	private int posX = 0, posY = 0;
	
	public Field(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
	
	@Override
	public boolean equals(Object f2) {
		if(f2.getClass() != this.getClass())
			return false;
		else {
			Field field2 = (Field) f2;
			return field2.getPosX() == this.posX && field2.getPosY() == this.posY;
		}
	}
}
