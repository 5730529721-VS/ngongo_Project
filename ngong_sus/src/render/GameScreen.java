package render;

import input.InputUtility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;


public class GameScreen extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GameAnimation drawknight = DrawingUtility.createAnimation(Resource.knight, 100, 100, 8, 3);
	public GameAnimation drawmons = DrawingUtility.createAnimation(Resource.monster, 300, 300, 6, 3);

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
		g2.clearRect(0, 0, getWidth(), getHeight());
		g2.drawImage(Resource.heart,105 ,100 , 30, 30, null);
		g2.setColor(Color.RED);
		g2.fillRect(50, 110, 50, 10);
		DrawingUtility.drawStatusbar(g2, 10, 0);
		
		drawknight.drawKnightAttack(g2);
		drawmons.drawEnemyAttack(g2);
		/*synchronized (RenderableHolder.getInstance()) {
			for (IRenderable item : RenderableHolder.getInstance().getRenderableList()){
					item.draw(g2);
			}
		}*/
		drawknight.updateAnimation();
		drawmons.updateAnimation();
	}
	
	
}
