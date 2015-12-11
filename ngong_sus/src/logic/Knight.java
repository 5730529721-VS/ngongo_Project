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

	}

	public void heal(int amount) {
		life += amount;
		if (life > maxLife) {
			life = maxLife;
		}
	}

}
