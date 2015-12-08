package logic;

import java.awt.Graphics2D;

public class YellowBox extends Box {
	public YellowBox(int lenght){
		super(lenght);
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
		return false;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

}
