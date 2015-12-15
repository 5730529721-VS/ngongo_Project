package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.GameScreen;
import render.Resource;

public class Enemy extends Character {

	public Enemy(int attack, int maxLife) {
		super(attack, maxLife);
		life = maxLife;
	}

	@Override
	public void draw(Graphics2D g2) {
		if (isAttack) {
			Resource.monEcho.play();
			GameScreen.drawmons.drawEnemyAttack(g2);
			GameScreen.drawmons.updateAnimation();
		} else if (isDead || isDestroyed) {
			g2.drawImage(Resource.monster.getSubimage(0, 1175, 70, 70), 330, 250, null);
		} else
			g2.drawImage(Resource.monster.getSubimage(8, 383, 85, 85), 330, 250, null);

		// DRAW STATUS LIFE
		g2.setColor(Color.black);
		g2.drawString(life + "/" + maxLife, 350, 70);
		g2.setColor(Color.RED);
		g2.fillRect(350, 80, 2 * life, 10);
		g2.drawImage(Resource.heart, 300, 65, 40, 40, null);
	}

}
