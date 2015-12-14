package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.GameScreen;
import render.Resource;

public class Knight extends Character {

	public Knight(int minAttack, int maxAttack, int maxLife) {
		super(minAttack, maxAttack, maxLife);
		life = maxLife;

	}

	@Override
	public void draw(Graphics2D g2) {
		if (isAttack){
			GameScreen.drawknight.drawEnemyAttack(g2);
			GameScreen.drawknight.updateAnimation();
		}
		else if (isDead || isDestroyed){
			g2.drawImage(Resource.knight.getSubimage(30, 1220, 70, 70), 70, 265, null);
		}
		else
		g2.drawImage(Resource.knight.getSubimage(25, 50,70,65), 70, 265, null);
		
		//DRAW STATUS LIFE
		g2.setColor(Color.RED);
		g2.fillRect(75, 80, 2*life, 10);
		g2.drawImage(Resource.heart,20, 65 , 40, 40, null);
	}

	public void heal(int amount) {
		life += amount;
		if (life > maxLife) {
			life = maxLife;
		}
	}

}
