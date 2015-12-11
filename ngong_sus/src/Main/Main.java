package Main;

import input.InputUtility;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import logic.MainLogic;
import render.GameScreen;

public class Main {

	public static void main(String[] args) {

		JFrame frame = new JFrame("NGONG-sus project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameScreen gameScreen = new GameScreen();
		MainLogic logic = new MainLogic();
		

		frame.getContentPane().add(gameScreen);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(new KeyListener() {

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
		while (true) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}
				logic.update();
				gameScreen.repaint();
				InputUtility.postUpdate();
				

		}
	}
}
