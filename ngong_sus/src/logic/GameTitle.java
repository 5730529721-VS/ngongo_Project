package logic;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import render.GameScreen;
import ui.HighScoreUtility;


public class GameTitle extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isOn;
	
	public GameTitle(){
		setPreferredSize(new Dimension(GameScreen.screenWidth,GameScreen.screenHeight));
		JButton startButton = new JButton("start");
		JButton highscoreButton = new JButton("Hall of Fame");
		startButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				super.mouseClicked(arg0);
				//Game Start
				
			}
			
		});
		
		highscoreButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				super.mouseClicked(e);
				//displayHighScore
				HighScoreUtility.displayTop10();
			}
		});
		add(startButton);
		add(highscoreButton);
		setVisible(true);
	}
	
	public boolean isOn(){
		return isOn;
	}
	
}
