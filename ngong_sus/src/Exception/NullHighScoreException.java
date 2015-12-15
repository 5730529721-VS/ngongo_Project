package Exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import ui.HighScoreUtility.HighScore;

public class NullHighScoreException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static HighScore[] highScores;

	public HighScore[] createHighScores(int type) {
		if (type == 1) {
			return createDefaultScore();
		} else {
			return createScoreList();
		}

	}

	private HighScore[] createScoreList() {
		// TODO Auto-generated method stub
		highScores = new HighScore[10];
		try {
			BufferedReader in = new BufferedReader(new FileReader("highscore"));
			int c;
			String str = "";
			while ((c = in.read()) != -1) {
				str += (char) c;
			}
			in.close();
			String[] read = str.split("\n");
			for (int i = 0; i < read.length; i++) {
				highScores[i] = new HighScore(read[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			createDefaultScore();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			createDefaultScore();
		}
		return highScores;

	}

	private static HighScore[] createDefaultScore() {
		String[] records = HighScore.defaultRecord();
		highScores = new HighScore[10];
		for (int i = 0; i < HighScore.defaultRecord().length; i++) {

			highScores[i] = new HighScore(records[i]);
		}

		return highScores;

	}
}
