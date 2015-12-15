package logic;

import java.awt.Graphics2D;
import render.GameScreen;
import render.Resource;

public class YellowBox extends Box {
	private int y;

	public YellowBox(int lenght, int z) {
		super(lenght, z);
		y = GameScreen.laneY;
		minX = (int) (Math.random() * GameScreen.lanewidth)+50;
		if (minX + lenght >= GameScreen.lanewidth + 50){
			minX = 50;
		}
	}

	@Override
	public synchronized void draw(Graphics2D g2d) {
		g2d.drawImage(Resource.sword, minX, y, length, 50, null);
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public boolean isVisible() {
		return isVisible;
	}

	@Override
	public boolean isDestroyed() {
		return isDestroyed;
	}

}
