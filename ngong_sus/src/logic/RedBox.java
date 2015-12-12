package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.GameScreen;

public class RedBox extends Box implements IMovable {
	private int speed, y;
	private boolean isMoving;

	public RedBox(int speed, int lenght, int z) {
		super(lenght, z);
		this.setSpeed(speed);
		this.minX = GameScreen.lanewidth;
		y = 425;
		isMoving = true;
	}

	public void move() {
		if (isMoving()) {
			minX -= speed;
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.RED);
		g2d.fillRect(minX, y, length, 50);

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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed < 0)
			speed = 0;
		this.speed = speed;
	}

	@Override
	public boolean isMoving() {
		// TODO Auto-generated method stub
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

}
