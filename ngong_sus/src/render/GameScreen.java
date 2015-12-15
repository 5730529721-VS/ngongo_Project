package render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import ui.DrawingUtility;

public class GameScreen extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static GameAnimation drawknight = DrawingUtility.createAnimation(Resource.knight, 70, 210, 8, 100);
	public static GameAnimation drawmons = DrawingUtility.createAnimation(Resource.monster, 330, 250, 6, 100);
	public static final int screenWidth = 500;
	public static final int screenHeight = 500;
	public static final int lanewidth = 400, laneHeight = 10;
	public static final int laneY = 405;
	public static boolean isPause;

	public GameScreen() {
		super();
		setPreferredSize(new Dimension(500, 500));
		setVisible(true);
	}

	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(Resource.field, 0, 50, 500, 300, null);
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(0, 350, 500, 150);
		g2.setColor(new Color(0, 76, 153));
		g2.fillRect(50, 420, lanewidth, laneHeight);
		synchronized (RenderableHolder.getInstance().getRenderableList()) {
			for ( int i= RenderableHolder.getInstance().getRenderableList().size()-1;i>=0;i--) {
				IRenderable item = RenderableHolder.getInstance().getRenderableList().get(i);
				if (!item.isDestroyed()) {
					item.draw(g2);
				}
			}
		}
		
	}
}
