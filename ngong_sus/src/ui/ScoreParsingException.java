package ui;

public class ScoreParsingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorType;
	
	public ScoreParsingException(int errorType){
		this.errorType = errorType;
	}
	
	@Override
	public String getMessage(){
		/* fill code */
		String out = "";
		if (errorType == 0)
			out = "No record score";
		else if (errorType == 1)
			out = "Wrong record format";
		return out;
	}
}
