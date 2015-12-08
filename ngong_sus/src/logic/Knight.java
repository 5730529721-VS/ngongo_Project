package logic;

import java.awt.Graphics2D;

public class Knight extends Character {

	public Knight(int minAttack, int maxAttack, int maxLife) {
		// TODO Auto-generated constructor stub
		super(minAttack, maxAttack, maxLife);
		life = maxLife;

	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub

	}

	public void heal(int amount) {
		life += amount;
		if (life > maxLife) {
			life = maxLife;
		}
	}

}
