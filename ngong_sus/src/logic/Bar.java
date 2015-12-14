package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.GameScreen;
import render.IRenderable;

public class Bar implements IRenderable{
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
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.black);
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

}
