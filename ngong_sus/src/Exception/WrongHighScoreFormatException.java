package Exception;

import javax.swing.JOptionPane;

public class WrongHighScoreFormatException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void printText(int type) {
		if (type == 1) {
			JOptionPane.showMessageDialog(null, "You can't use this name.", "Wrong format",
					JOptionPane.WARNING_MESSAGE);

		}
		if (type == 2) {
			JOptionPane.showMessageDialog(null, "Fail to load Highscore.", "Wrong format",
					JOptionPane.WARNING_MESSAGE);
			}
			
		}
	
}
