package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.GameScreen;

public class PurpleBox extends Box {
	private int y;
	public PurpleBox(int lenght,int z){
		super(lenght,z);
		y=100;
		minX=(int) (Math.random()*GameScreen.screenWidth);
	}

	
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.MAGENTA);
		g2d.fillRect(minX, y, length+10, 50);
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return isVisible;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return isDestroyed;
	}

}
