package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JOptionPane;

import ui.ScoreParsingException;

public class HighScoreUtility {

	public static class HighScoreRecord implements Comparable<HighScoreRecord>{
		private String name = "";
		private int score = 0;
		
		public HighScoreRecord(String name, int score) {
			this.name = name;
			this.score = score;
		}
		
		//RECORD FORMAT IS {NAME : SCORE}
		public HighScoreRecord(String record) throws ScoreParsingException{
			int colonIndex = record.indexOf(":");
			if (colonIndex == -1) throw new ScoreParsingException(1);
			String playerName = record.substring(0, colonIndex);
			String playerScore = record.substring(colonIndex + 1);
			try{
				this.score = Integer.parseInt(playerScore); 
				this.name = playerName;
			}
			catch(Exception e){
				throw new ScoreParsingException(0);
			}
		}
		
		private String getRecord(){
			return name.trim()+":"+score;
		}
		
		private static String[] defaultRecord(){
			return new String[]{"A:8","B:3","C:3",
					"D:0","E:0","F:0",
					"G:0","H:0","I:0","J:0"};
		}

		@Override
		public int compareTo(HighScoreRecord o) {
			int compare = Integer.compare(this.score, o.score);
			return -compare;
		}
	}
	
	private static HighScoreRecord[] highScoreRecord = null;

	private static String readFileName = "highscore";
	
	public static void recordHighScore(int score){
		if(!loadHighScore() || highScoreRecord == null){
			JOptionPane.showMessageDialog(null, "Error loading highscore record", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int index = highScoreRecord.length;
		for (int i=0; i<highScoreRecord.length; i++){
			if (score > highScoreRecord[i].score){
				index = i;
				break;
			}
		}
		if(index >= highScoreRecord.length){
			JOptionPane.showMessageDialog(null, "Game over\nYour score is" + score, "Game over", JOptionPane.INFORMATION_MESSAGE);
		}else{
			for(int i=highScoreRecord.length-1; i>=index+1; i--){
				highScoreRecord[i] = highScoreRecord[i-1];
			}
			String namein = JOptionPane.showInputDialog(null, "Congratulation, you are ranked " + (index+1) + "\n" + "Please enter your name", "High score" , JOptionPane.INFORMATION_MESSAGE);
			highScoreRecord[index] = new HighScoreRecord(namein, score);
			try {
				
				BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
				//Fill code
				String highscoreString = "";
				for (HighScoreRecord r : highScoreRecord){
					highscoreString += r.getRecord() + "\n";
				}
				out.write(getXORed(highscoreString));
				out.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Error saving high score record", 
						"Error", JOptionPane.ERROR_MESSAGE);
				highScoreRecord = null;
				return;
			}
		}
	}
	
	public static void displayTop10(){
		if(!loadHighScore() || highScoreRecord == null){
			JOptionPane.showMessageDialog(null, "Error loading highscore record", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String msg = "======= Top 10 players ======="+System.getProperty("line.separator");
		int rank = 1;
		for(HighScoreRecord record : highScoreRecord){
			msg += rank+" "+record.getRecord()+System.getProperty("line.separator");
			rank++;
		}
		JOptionPane.showMessageDialog(null, msg.trim(), "Top 10", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static boolean loadHighScore(){
		File f = new File(readFileName);
		//If no high score, create default
		if(!f.exists()){
			if(!createDefaultScoreFile()) return false;
		}
		//Read high score -- if fail: delete the file, create default one and read it again 
		if(!readAndParseScoreFile(f)){
			f.delete();
			if(!createDefaultScoreFile()) return false;
			return readAndParseScoreFile(f);
		}
		return true;
		
	}
	
	private static boolean readAndParseScoreFile(File f){
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));
			highScoreRecord = new HighScoreRecord[10];
			String str = "";
			int c;
			while((c = in.read()) != -1){
				str += (char)c;
			}
			in.close();
			String[] records = getXORed(str).split("\n");
			for(int i=0; i<highScoreRecord.length; i++){
				try{
					highScoreRecord[i] = new HighScoreRecord(records[i]);
				}catch(ScoreParsingException e){
					System.err.println("Error parsing line "+(i+1)+", "+e.getMessage());
					highScoreRecord[i] = new HighScoreRecord("ERROR_RECORD", 0);
				}
			}
			Arrays.sort(highScoreRecord);
			return true;
		} catch (Exception e) {
			highScoreRecord = null;
		}
		return false;
	}
	
	private static boolean createDefaultScoreFile(){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("highscore"));
			String str = "";
			for(String s : HighScoreRecord.defaultRecord()){
				str += s+"\n";
			}
			str = str.trim();
			out.write(getXORed(str));
			out.close();
			return true;
		} catch (IOException e1) {
			highScoreRecord = null;
			return false;
		}
	}
	
	private static final byte[] key = "RmAAq2b5d8fjgu9dhher".getBytes();
	
	//This method does both encryption and decryption 
	private static String getXORed(String in){
		byte[] inData = in.getBytes();
		for (int i = 0 ; i < inData.length ; i++){
			inData[i] ^= key[i%(key.length)];
		}
		return new String(inData);
	}

	public static void setReadFileName(String name){
		readFileName = name;
	}	
}

