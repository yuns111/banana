package banana_admin.controller;

public class Controllers {

	private static ProgramController programController;
	private static EmotionController emotionController;
	private static UserController userController;
<<<<<<< HEAD
	private static MusicController musicController;
=======
	private static AdminController adminController;
	private static LoginController loginController;
>>>>>>> refs/remotes/origin/master
	
	public Controllers() {

		programController = new ProgramController();
<<<<<<< HEAD
		userController = new UserController();
		emotionController = new EmotionController();
		musicController = new MusicController();

=======
		userController=new UserController();
		emotionController = new EmotionController();
		adminController = new AdminController();
		loginController = new LoginController();
		
>>>>>>> refs/remotes/origin/master
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

<<<<<<< HEAD
	public static MusicController getMusicController() {
		return musicController;
=======
	public static AdminController getAdminController() {
		
		return adminController;
	}

	public static LoginController getLoginController() {
		return loginController;
>>>>>>> refs/remotes/origin/master
	}

}
