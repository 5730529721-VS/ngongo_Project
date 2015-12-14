package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.GameScreen;
import render.Resource;

public class PurpleBox extends Box {
	private int y;

	public PurpleBox(int lenght, int z) {
		super(lenght, z);
		y = GameScreen.laneY;
		minX = (int) (Math.random() * GameScreen.lanewidth)+50;
	}

	@Override
	public synchronized void draw(Graphics2D g2d) {
//		g2d.setColor(Color.MAGENTA);
//		g2d.fillRect(minX, y, length, 50);
		g2d.setColor(new Color(178, 102, 255));
		g2d.fillRect(minX, y, length, 50);
		g2d.drawImage(Resource.shield, minX, y, length, 50, null);
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
