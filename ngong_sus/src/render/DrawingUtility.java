package render;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class DrawingUtility {
	private static final Font scorefont = new Font("Tahoma", Font.BOLD, 20);
	
	public static void drawStatusbar(Graphics2D g2, int score, int life){
		g2.setColor(Color.black);
		g2.fillRect(0, 0, 500, 50);
		g2.setFont(scorefont);
		g2.setColor(Color.white);
		g2.drawString("SCORE : " + score, 5, 40);
	}
	
	public static GameAnimation createAnimation(BufferedImage image,int x, int y, int frameCount, int frameDelay){
		GameAnimation anim = new GameAnimation(image,frameCount, frameDelay);
		anim.centerAnimationAt(x, y);
		anim.play();
		return anim;
	}

}
