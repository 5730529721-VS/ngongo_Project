package logic;

import java.awt.Color;
import java.awt.Graphics2D;

public class RedBox extends Box {
	private int speed,y;
	
	public RedBox(int speed,int lenght,int z){
		super(lenght,z);
		this.setSpeed(speed);
		this.minX = -20;
		this.y = 100;
	}
	
	public void move(){
		minX += speed;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.RED);
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed < 0)
			speed = 0;
		this.speed = speed;
	}

}
