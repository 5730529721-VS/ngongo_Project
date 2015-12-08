package logic;

import java.awt.Graphics2D;

public class RedBox extends Box {
	private int speed;
	
	public RedBox(int speed, int lenght) {
		super(lenght);
		this.setSpeed(speed);
	}
	
	public void move(){
		minX+=speed;
	}

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

}
