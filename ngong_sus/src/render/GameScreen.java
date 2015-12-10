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

import logic.Knight;

public class GameScreen extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Font scorefont = new Font("Tahoma", Font.BOLD, 20);
	private final Font statusfont = new Font("Tahoma", Font.PLAIN, 10);

	public GameScreen() {
		super();
		setPreferredSize(new Dimension(375, 1000));
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
		try {
			g2.drawImage(Resource.knight.getSubimage(25, 50,70,65), 0, 0, null);
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			g2.drawImage(Resource.knight.getSubimage(70, 825,60,120), 0, 0, null);
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	
}
