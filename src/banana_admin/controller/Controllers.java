package banana_admin.controller;

public class Controllers {

	private static ProgramController programController;
	private static AdminController adminController;
	private static TicketController ticketController;
	private static EmotionController emotionController;
	private static UserController userController;
<<<<<<< HEAD
=======
	private static MusicController musicController;
	private static AdminController adminController;
>>>>>>> refs/remotes/yuns111/master
	private static LoginController loginController;

	public Controllers() {

		ticketController = new TicketController();
		programController = new ProgramController();
		userController = new UserController();
<<<<<<< HEAD
=======
		musicController = new MusicController();
>>>>>>> refs/remotes/yuns111/master
		emotionController = new EmotionController();
		adminController = new AdminController();
		loginController = new LoginController();
	}

	
	
	public static TicketController getTicketController() {
		return ticketController;
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
	
	public static AdminController getAdminController() {

		return adminController;
	}

	public static LoginController getLoginController() {
		
		return loginController;
	}

}
