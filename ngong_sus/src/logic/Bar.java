package logic;

import java.awt.Graphics2D;

import render.IRenderable;

public class Bar implements IRenderable{
	int x;
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
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
