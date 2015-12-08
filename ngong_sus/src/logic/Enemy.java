package logic;

import java.awt.Graphics2D;

public class Enemy extends Character{

	public Enemy(int minAttack, int maxAttack, int maxLife) {
		super(minAttack, maxAttack, maxLife);
		// TODO Auto-generated constructor stub
		life = maxLife;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

}
