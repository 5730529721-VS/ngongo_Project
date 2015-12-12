package render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;



public class GameScreen extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static GameAnimation drawknight = DrawingUtility.createAnimation(Resource.knight, 70, 210, 8, 20);
	public static GameAnimation drawmons = DrawingUtility.createAnimation(Resource.monster, 330, 250, 6, 100);
	public static final int screenWidth = 500;
	public static final int screenHeight = 500;
	public static final int lanewidth = 400, laneHeight = 20;
	
	public GameScreen() {
		super();
		setPreferredSize(new Dimension(500, 500));
		setVisible(true);
		
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
		g2.setColor(Color.BLUE);
		g2.fillRect(50, 435, lanewidth, laneHeight);
		synchronized (RenderableHolder.getInstance().getRenderableList()) {
			for (IRenderable item : RenderableHolder.getInstance().getRenderableList()) {
				if (!item.isDestroyed()) {
					item.draw(g2);
				}
			}
		}
//		synchronized (RenderableHolder.getInstance()) {
//			for (IRenderable item : RenderableHolder.getInstance().getRenderableList()){
//					item.draw(g2);
//			}
//		}
	}
}	
	
