package render;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.HighScoreUtility;

public class IntroScreen extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel start;
	private JLabel highscore;

	public IntroScreen() {
		super();
		setLayout(null);
		setPreferredSize(new Dimension(Resource.background.getWidth(), Resource.background.getHeight()));
		start = new JLabel("Start Game");
		start.setFont(new Font("Verdana", Font.PLAIN, 30));
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				Main.Main.changeScreen(Main.Main.GAME);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				start.setFont(new Font("Verdana", Font.BOLD, 40));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				start.setFont(new Font("Verdana", Font.PLAIN, 30));
			}

		});
		highscore = new JLabel("Hall Of Fame");
		highscore.setFont(new Font("Verdana", Font.PLAIN, 30));
		highscore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				HighScoreUtility.displayTop10();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				highscore.setFont(new Font("Verdana", Font.BOLD, 40));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				highscore.setFont(new Font("Verdana", Font.PLAIN, 30));
			}
		});
		this.add(start);
		this.add(highscore);
		this.setVisible(true);

		start.setBounds(450, 140, 300, 50);
		highscore.setBounds(450, 200, 300, 50);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Resource.background, 0, 0, null);
		g2d.drawImage(Resource.gamename, 250, 20, null);

	}
}
