package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.DrawingUtility;
import render.GameScreen;
import render.Resource;

public class RedBox extends Box implements IMovable {
	private int speed, y, movingDirection, leftbound, rightbound;
	private boolean isMoving;

	public RedBox(int speed, int lenght) {
		super(lenght, Integer.MAX_VALUE - 1);
		setSpeed(speed);
		minX = GameScreen.lanewidth;
		y = GameScreen.laneY;
		isMoving = true;
		movingDirection = 1;
		leftbound = 50;
		rightbound = GameScreen.lanewidth + 50;
	}

	public void move() {
		if (isMoving()) {
			minX -= (speed * movingDirection);
		}
	}

	@Override
	public synchronized void draw(Graphics2D g2) {
		g2.setColor(new Color(255, 0, 0));
		g2.fillRect(minX, y, length, 50);
		g2.drawImage(Resource.skull, minX, y, length, 50, null);
		g2.setColor(new Color(0, 51, 102));
		g2.setFont(DrawingUtility.scorefont);
		g2.drawString("Bounced " + MainLogic.runBox.getBouncedCount(), 200, 380);
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
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	public boolean isBouncing() {
		if (minX <= leftbound || minX + length >= rightbound)
			return true;
		return false;
	}

	public void flipDirection() {
		this.movingDirection = -movingDirection;
	}

}
