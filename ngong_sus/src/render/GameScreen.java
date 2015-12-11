package render;

import input.InputUtility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

import javax.swing.JComponent;

import logic.Knight;


public class GameScreen extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GameAnimation drawknight = DrawingUtility.createAnimation(Resource.knight, 70, 210, 8, 3);
	public GameAnimation drawmons = DrawingUtility.createAnimation(Resource.monster, 330, 250, 6, 3);
	public static final int screenWidth = 500;
	public static final int screenHeight = 500;
	
	public GameScreen() {
		super();
		setPreferredSize(new Dimension(500, 500));
		setVisible(true);
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE)
					InputUtility.setSpacePressed(false);

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					if (!InputUtility.isSpacePressed()) {
						InputUtility.setSpaceTriggered(true);
					}
					InputUtility.setSpacePressed(true);
				}
			}
		});
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.LIGHT_GRAY);
		g2.clearRect(0, 50, 500, 300);
		g2.drawImage(Resource.field, 0, 50, 520, 300, null);
		g2.drawImage(Resource.heart,20, 65 , 40, 40, null);
		g2.drawImage(Resource.heart,300, 65 , 40, 40, null);
		g2.setColor(Color.RED);
		g2.fillRect(75, 80, 100, 10);
		g2.fillRect(350, 80, 100, 10);
		DrawingUtility.drawStatusbar(g2, 100, 0);
		drawknight.drawKnightAttack(g2);
		drawmons.drawEnemyAttack(g2);
//		synchronized (RenderableHolder.getInstance()) {
//			for (IRenderable item : RenderableHolder.getInstance().getRenderableList()){
//					item.draw(g2);
//			}
//		}
		drawknight.updateAnimation();
		drawmons.updateAnimation();
	}
}	
	
