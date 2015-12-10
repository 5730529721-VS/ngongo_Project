package Main;

import input.InputUtility;

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
