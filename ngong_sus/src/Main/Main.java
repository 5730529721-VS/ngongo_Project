package Main;

import input.InputUtility;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.MainLogic;
import render.GameScreen;
import render.IntroScreen;
import render.Resource;

public class Main {
	private static JComponent currentScreen;
	public static JFrame frame;
	private static GameScreen gameScreen;
	private static MainLogic logic;
	private static IntroScreen introScreen;
	
	public static final int INTRO = 1;
	public static final int GAME = 2;
	
	public static void main(String[] args) {
		frame = new JFrame("NGONG-sus project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gameScreen = new GameScreen();
		logic = new MainLogic();
		introScreen = new IntroScreen();
		currentScreen = introScreen;
		
		changeScreen(INTRO);
		
		
		frame.setVisible(true);
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE)
					InputUtility.setSpacePressed(false);
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					InputUtility.setEnterPressed(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					if (!InputUtility.isSpacePressed()) {
						InputUtility.setSpaceTriggered(true);
					}
					InputUtility.setSpacePressed(true);
				}
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!InputUtility.isEnterPressed()) {
						InputUtility.setEnterTriggered(true);
					}
					InputUtility.setEnterPressed(true);
				}
			}
		});
//		frame.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showMessageDialog(null, "Mouse is not needed", "Don't even try", JOptionPane.INFORMATION_MESSAGE);
//			}
//		});
		while (true) {
			try {
				Thread.sleep(20);
				frame.requestFocus();
			} catch (InterruptedException e) {}
				logic.update();
				gameScreen.repaint();
				InputUtility.postUpdate();

		}
	}
	
	public static void changeScreen(int screen){
		System.out.println("---------- CHANGE THE SCREEN ------------");
		frame.remove(currentScreen);
		switch (screen) {
		case INTRO:
			Resource.introSound.play();
			currentScreen = introScreen;
			MainLogic.endGame();
			break;

		case GAME:
			Resource.introSound.stop();
			currentScreen = gameScreen;
			MainLogic.startgame();
			break;
		}
		frame.add(currentScreen);
		frame.pack();
		frame.repaint();
	}
	
	public static void pauseTriggered(){
		JLabel pauseLabel = new JLabel("pause");
		pauseLabel.setBounds(GameScreen.screenWidth/2, GameScreen.screenHeight/2, 100, 30);
		frame.add(pauseLabel);
		if(MainLogic.isPause()){
			pauseLabel.setText("");
		}else{
			pauseLabel.setText("PAUSE");
		}
		frame.validate();
		//yung mai dai
		
	}
}
