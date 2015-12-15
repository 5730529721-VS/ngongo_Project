package logic;

import java.awt.Graphics2D;

import render.IRenderable;
import ui.DrawingUtility;

public class PlayerStatus implements IRenderable{
	
	private int score;
	
	public PlayerStatus() {
		super();
		score = 0;
	}
	
	public int getScore() {
		return score;
	}

	public void addScore(int add){
		this.score += add;
	}

	@Override
	public synchronized void draw(Graphics2D g2) {
		DrawingUtility.drawStatusbar(g2, getScore());
		
	}

	@Override
	public int getZ() {
		return -9999;
	}

	@Override
	public boolean isVisible() {
		return true;
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}
	
}
