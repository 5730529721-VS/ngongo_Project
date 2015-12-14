package Exception;

import logic.HighScoreUtility;
import logic.HighScoreUtility.HighScore;

public class NullHighScoreException extends Exception {
	private static HighScore[] highScores;
	
	public HighScore[] createDefaultText(){
		return createDefaultScore();
		
	}
	private static HighScore[] createDefaultScore() {
		String[] records = HighScore.defaultRecord();
		highScores = new HighScore[10];
		for (int i = 0; i < HighScore.defaultRecord().length; i++) {

			// wrong format
			highScores[i] = new HighScore(records[i]);
		}
		
		return highScores;

	}
}
