package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.GameScreen;

public class Bar implements IMovable{
	private int x,direction,y;
	
	public Bar(int x){
		this.x=x;
		y = GameScreen.laneY;
		direction=1;
	}
	
	public void move(){
		this.x+=5*direction;
		if(x>=GameScreen.lanewidth+50||x<=50){
			direction= -direction;;
		}
	}
	@Override
	public synchronized void draw(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillRect(x, y, 1, 50);
	}

	@Override
	public int getZ() {
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isVisible() {
		return false;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}
	
	public int getX() {
		return x;
	}

	@Override
	public boolean isMoving() {
		return true;
	}

}
