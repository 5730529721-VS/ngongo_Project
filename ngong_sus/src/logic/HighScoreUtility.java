package logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import Exception.NullHighScoreException;
import Exception.WrongHighScoreFormatException;

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
			try {
				if (index < 0) {

					throw new WrongHighScoreFormatException();
				}
				name = record.substring(0, index);
				score = Integer.parseInt(record.substring(index + 1, record.length()));
			}

			catch (WrongHighScoreFormatException e) {
				// TODO Auto-generated catch block
				e.printText(2);
				name = "player";
				score = 0;
			}

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

	public static void recordNewHighScore(int scoreIn) {
		try {
			if (highScores == null) {
				System.out.println("outRecord");
				throw new NullHighScoreException();

			}
		} catch (NullHighScoreException e) {
			// TODO Auto-generated catch block
			highScores = e.createDefaultText();
			recordToText();
		}

		for (int i = 0; i < highScores.length; i++) {

			HighScore h = highScores[i];
			try{
			if (h == null) {
				throw new NullHighScoreException();
			}
			}catch(NullHighScoreException e){
				e.createDefaultText();
			}

			if (scoreIn > h.score) {
				for (int j = highScores.length - 1; j >= i; j--) {
					highScores[j] = highScores[j - 1];

				}
				String nameIn = JOptionPane
						.showInputDialog("Congratulation!!! you are on ranked " + (i + 1) + "\nEnter your name");
				try {
					if (nameIn.indexOf(":") >= 0 || nameIn.equals("")) {
						throw new WrongHighScoreFormatException();
					}
				} catch (WrongHighScoreFormatException e) {
					// TODO Auto-generated catch block
					e.printText(1);
				}
				highScores[i] = new HighScore(nameIn, scoreIn);
				recordToText();
				return;
				// return true;
			}
		}

		JOptionPane.showMessageDialog(null, "You did not break any record. T,T", "GAME OVER!!!", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "BYE");
		// return false;

	}

	private static void recordToText() {

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

		String msg = "<<<<<<< Top 10 knights >>>>>>>" + System.getProperty("line.separator");
		int rank = 1;
		try {
			if (highScores == null) {

				throw new NullHighScoreException();
			}

			System.out.println("out10");
		} catch (NullHighScoreException e) {
			// TODO Auto-generated catch block
			highScores = e.createDefaultText();
			recordToText();
		}
		for (HighScore h : highScores) {
			if (h == null) {
				System.out.println("kuy");
			}

			msg += rank + ".) " + h.getRecord() + System.getProperty("line.separator");
			rank++;
		}
		JOptionPane.showMessageDialog(null, msg.trim(), "Top 10", JOptionPane.INFORMATION_MESSAGE);
	}

}
