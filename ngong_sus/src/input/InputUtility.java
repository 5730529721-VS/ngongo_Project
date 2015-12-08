package input;

public class InputUtility {

	private static boolean spaceTriggered = false;
	private static boolean spacePressed = false;

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

	public static void postUpdate() {
		InputUtility.spaceTriggered = false;
	}

}