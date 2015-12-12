package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.GameScreen;
import render.IRenderable;

public class Bar implements IRenderable{
	int x,direction;
	public Bar(int x){
		this.x=x;
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
		// TODO Auto-generated method stub
		g2d.setColor(Color.black);
		g2d.fillRect(x, 425, 1, 50);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

}
