package render;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import ui.HighScoreUtility;

public class IntroScreen extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton start;
	private JButton highscore;

	public IntroScreen(){
		super();
		setLayout(null);
		setPreferredSize(new Dimension(Resource.background.getWidth(), Resource.background.getHeight()));
		start = new JButton("StartGame");
		start.setBounds(450, 170, 100, 23);
		highscore = new JButton("HighScore");
		highscore.setBounds(600, 170, 100, 23);
		this.add(start);
		this.add(highscore);
		this.setVisible(true);
		highscore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				HighScoreUtility.displayTop10();
			}
		});
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.Main.changeScreen(Main.Main.GAME);
			}
		});
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Resource.background, 0, 0, null);
	}
}
