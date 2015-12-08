package logic;

import java.util.ArrayList;

public class MainLogic {
	public static int boxZ;
	public int creationDelay;
	public int creationDelayCounter;
	private ArrayList<Box> boxes;
	private Knight knight;
	private Enemy enemy;
	private Bar bar;
	private boolean isPause;
	
	public MainLogic(){
		boxes = new ArrayList<Box>();
		knight = new Knight(1, 5, 50);
		enemy = new Enemy(2, 7, 50);
		bar = new Bar();
		setPause(false);
		creationDelay = 5;
		creationDelayCounter = 0;
		
	}
	
	public void generateBox(){
		
	}

	public boolean isPause() {
		return isPause;
	}

	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}

	public Knight getKnight() {
		return knight;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public Bar getBar() {
		return bar;
	}

}
