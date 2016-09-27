package banana_admin.controller;

public class Controllers {
	
	private static ProgramController programController;
	private static EmotionController emotionController;
	
	public Controllers() {
		
		programController = new ProgramController();
		emotionController = new EmotionController();
	}

	public static ProgramController getProgramController() {

		return programController;

	}

	public static EmotionController getEmotionController() {
		return emotionController;
	}
	
	

}
