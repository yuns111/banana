package banana_admin.controller;

public class Controllers {

	private static ProgramController programController;
	private static TicketController ticketController;
	private static EmotionController emotionController;
	private static UserController userController;
	private static MusicController musicController;
	private static AdminController adminController;
	private static LoginController loginController;
	private static StatsController statsController;

	public Controllers() {

		ticketController = new TicketController();
		programController = new ProgramController();
		userController = new UserController();
		musicController = new MusicController();
		emotionController = new EmotionController();
		adminController = new AdminController();
		loginController = new LoginController();
		statsController = new StatsController();
		
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

	public static StatsController getStatsController() {
		
		return statsController;
		
	}
		
}