package input;

public class InputUtility {

	private static boolean spaceTriggered = false;
	private static boolean spacePressed = false;
	private static boolean enterTriggered = false;
	private static boolean enterPressed = false;

	public static boolean isSpacePressed() {
		return spacePressed;
	}

	public static void setSpacePressed(boolean spacePressed) {
		InputUtility.spacePressed = spacePressed;
	}

	public static boolean isSpaceTriggered() {
		return spaceTriggered;
	}

	public static void setSpaceTriggered(boolean spaceTriggered) {
		InputUtility.spaceTriggered = spaceTriggered;
	}
	
	public static boolean isEnterPressed() {
		return enterPressed;
	}

	public static void setEnterPressed(boolean enterPressed) {
		InputUtility.enterPressed = enterPressed;
	}

	public static boolean isEnterTriggered() {
		return enterTriggered;
	}

	public static void setEnterTriggered(boolean enterTriggered) {
		InputUtility.enterTriggered = enterTriggered;
	}
	
	public static void postUpdate() {
		InputUtility.spaceTriggered = false;
		InputUtility.enterTriggered = false;
	}

}
