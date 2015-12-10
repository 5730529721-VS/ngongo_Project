package logic;

import java.awt.Color;
import java.awt.Graphics2D;

public class GreenBox extends Box {
	private int x;
	public GreenBox(int lenght){
		super(lenght);
	}
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.RED);
		g2d.fillRect(100, 0, 50, 50);
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
