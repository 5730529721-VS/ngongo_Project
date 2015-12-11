package render;

import input.InputUtility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import logic.GreenBox;
import logic.Knight;
import logic.RedBox;

public class GameScreen extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Font scorefont = new Font("Tahoma", Font.BOLD, 20);
	private final Font statusfont = new Font("Tahoma", Font.PLAIN, 10);
	public static final int screenWidth = 375;
	public static final int screenHeight = 1000;

	public GameScreen() {
		super();
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setVisible(true);
		
		
		//move to main naja
//		this.addKeyListener(new KeyListener() {
//
//			@Override
//			public void keyTyped(KeyEvent arg0) {
//			}
//
//			@Override
//			public void keyReleased(KeyEvent arg0) {
//				if (arg0.getKeyCode() == KeyEvent.VK_SPACE)
//					InputUtility.setSpacePressed(false);
//
//			}
//
//			@Override
//			public void keyPressed(KeyEvent arg0) {
//				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
//					if (!InputUtility.isSpacePressed()) {
//						InputUtility.setSpaceTriggered(true);
//					}
//					InputUtility.setSpacePressed(true);
//				}
//			}
//		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.LIGHT_GRAY);
		g2.clearRect(0, 0, getWidth(), getHeight());

		synchronized (RenderableHolder.getInstance()) {
			for (int i = RenderableHolder.getInstance().getRenderableList().size() - 1; i >= 0; i--) {
				IRenderable item = RenderableHolder.getInstance().getRenderableList().get(i);
				
				if (item.isDestroyed()) {
					RenderableHolder.getInstance().getRenderableList().remove(item);
				} else {
					item.draw(g2);
				}
			}
		}

	}

}
