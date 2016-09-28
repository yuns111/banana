package banana_admin.controller;

public class Controllers {

	private static ProgramController programController;
<<<<<<< HEAD
	private static AdminController adminController;
	
=======
	private static EmotionController emotionController;
	private static UserController userController;
	private static AdminController adminController;
>>>>>>> refs/remotes/yuns111/master
	
	public Controllers() {

		programController = new ProgramController();
<<<<<<< HEAD
=======
		userController=new UserController();
		emotionController = new EmotionController();
>>>>>>> refs/remotes/yuns111/master
		adminController = new AdminController();
		
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

	public static AdminController getAdminController() {
		
		return adminController;
	}

	public static AdminController getAdminController() {
		return adminController;
	}
	
	

}
