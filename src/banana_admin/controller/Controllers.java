package banana_admin.controller;

public class Controllers {

	private static ProgramController programController;
	private static EmotionController emotionController;
	private static UserController userController;
	private static MusicController musicController;
	
	public Controllers() {

		programController = new ProgramController();
		userController = new UserController();
		emotionController = new EmotionController();
		musicController = new MusicController();

	}

	public static ProgramController getProgramController() {

		return programController;

	}

	public static UserController getUserController() {
		return userController;
	}


	public static EmotionController getEmotionController() {
		return emotionController;
	}

	public static MusicController getMusicController() {
		return musicController;
	}

}
