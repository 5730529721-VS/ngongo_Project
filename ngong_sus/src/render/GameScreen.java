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
import logic.MainLogic;
import logic.RedBox;

public class GameScreen extends JComponent {

	private static final long serialVersionUID = 1L;
	private final Font scorefont = new Font("Tahoma", Font.BOLD, 20);
	private final Font statusfont = new Font("Tahoma", Font.PLAIN, 10);
	public static final int screenWidth = 500;
	public static final int screenHeight = 500;
	public static final int laneWidth = 400, laneHeight = 20;

	public GameScreen() {
		super();
		setPreferredSize(new Dimension(screenWidth, screenHeight));
		setVisible(true);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.LIGHT_GRAY);
		g2.clearRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.BLUE);
		g2.fillRect(50, 435, laneWidth, laneHeight);
		synchronized (RenderableHolder.getInstance().getRenderableList()) {
			for (IRenderable item : RenderableHolder.getInstance().getRenderableList()) {
				if (!item.isDestroyed()) {
					item.draw(g2);
				}
			}
		}

	}

}
