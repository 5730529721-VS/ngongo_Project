package logic;

import java.util.ArrayList;

import render.RenderableHolder;

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
	
	public void start(){
		
	}
	
	public void generateBox(){
		double rand = Math.random()*4;
		if (rand > 0 && rand < 1){
			RenderableHolder.getInstance().add(new RedBox((int)(Math.random()*10), (int)(Math.random()*5)));
		}
		else if (rand < 2){
			RenderableHolder.getInstance().add(new GreenBox((int)(Math.random()*20)));
		}
		else if (rand < 3){
			RenderableHolder.getInstance().add(new PurpleBox((int)(Math.random()*10)));
		}
		else {
			RenderableHolder.getInstance().add(new YellowBox((int)(Math.random()*30)));
		}
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
