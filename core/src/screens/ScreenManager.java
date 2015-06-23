package screens;

public class ScreenManager {
	private static Screen currentScreen;
	
	public static void setScreen(Screen screen) {
		currentScreen = screen;
		currentScreen.create();
	}
	
	public static Screen getCurrentScreen() {
		return currentScreen;
	}
}
