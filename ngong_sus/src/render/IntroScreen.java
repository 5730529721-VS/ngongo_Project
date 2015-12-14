package render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class IntroScreen extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton start;

	public IntroScreen(){
		super();
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(GameScreen.screenWidth, GameScreen.screenHeight));
		start = new JButton("StartGame");
		start.setPreferredSize(new Dimension(50, 50));
		add(start, BorderLayout.CENTER);
		setVisible(true);
		start.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.Main.changeScreen(Main.Main.GAME);
				
			}
		});
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, 500, 500);
	}
}
