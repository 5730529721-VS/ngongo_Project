package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class HighScoreUtility {
	public static class HighScore implements Comparable<HighScore> {
		public int score;
		public String name;

		public HighScore(String s, int n) {
			name = s;
			score = n;
			// add Exception
		}

		public HighScore(String record) {
			int index = record.indexOf(":");
			name = record.substring(0, index);
			score = Integer.parseInt(record.substring(index + 1, record.length()));
		}

		@Override
		public int compareTo(HighScore other) {
			// TODO Auto-generated method stub
			if (score > other.score) {
				return 1;
			} else if (score < other.score) {
				return -1;
			} else if (name.compareTo(other.name) <= 0) {
				return -1;

			} else
				return 1;

		}

		public static String[] defaultRecord() {
			return new String[] { "a:999", "b:888", "c:777", "d:666", "e:555", "f:444", "g:333", "h:222", "i:111",
					"j:0" };
		}

		public String getRecord() {
			// TODO Auto-generated method stub
			return name + ":" + score;
		}

	}

	private static HighScore[] highScores = null;

	public boolean recordNewHighScore(HighScore newHighScore) {

		if (highScores == null) {
			createDefaultScore();
		}

		for (int i = 0; i < highScores.length; i++) {
			HighScore h = highScores[i];
			if (newHighScore.score > h.score) {
				for (int j = highScores.length - 1; j >= i; j--) {
					highScores[j] = highScores[j - 1];

				}
				highScores[i] = h;
				recordToText();
				return true;
			}
		}

		return false;

	}

	public static void recordToText() {

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
			String str = "";
			for (HighScore s : highScores) {
				str += s.getRecord() + "\n";
			}
			str = str.trim();
			out.write(str);
			out.close();

		} catch (IOException e1) {
			highScores = null;

		}

	}

	public static void displayTop10() {

		String msg = "======= Top 10 players =======" + System.getProperty("line.separator");
		int rank = 1;
		if(highScores == null){
			createDefaultScore();
		}
		for (HighScore h : highScores) {
			if(h == null ){
				System.out.println("kuy");
			}

			msg += rank + " " + h.getRecord() + System.getProperty("line.separator");
			rank++;
		}
		JOptionPane.showMessageDialog(null, msg.trim(), "Top 10", JOptionPane.INFORMATION_MESSAGE);
	}

	private static void createDefaultScore() {
		String[] records = HighScore.defaultRecord();
		highScores = new HighScore[10];
		for (int i = 0; i < HighScore.defaultRecord().length; i++) {
			
			// wrong format
			highScores[i] = new HighScore(records[i]);
		}
		recordToText();
		
		
	}

}
