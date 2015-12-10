package logic;

import java.awt.Graphics2D;
import render.Resource;

public class Knight extends Character {
	

	public Knight(int minAttack, int maxAttack, int maxLife) {
		// TODO Auto-generated constructor stub
		super(minAttack, maxAttack, maxLife);
		life = maxLife;
		
	}

	@Override
	public void draw(Graphics2D g2) {

		g2.drawImage(Resource.knight.getSubimage(25, 50,70,65), 0, 0, null);

		g2.drawImage(Resource.knight.getSubimage(70, 825,60,120), 0, 0, null);

		g2.drawImage(Resource.knight.getSubimage(180, 825,60,120), 0, 0, null);

		g2.drawImage(Resource.knight.getSubimage(280, 825,60,120), 0, 0, null);

		g2.drawImage(Resource.knight.getSubimage(380, 825,60,120), 0, 0, null);
	}

}
