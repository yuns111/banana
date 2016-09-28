package banana_admin.controller;

public class Controllers {

	private static ProgramController programController;
<<<<<<< HEAD
	private static EmotionController emotionController;
	private static UserController userController;
=======
	private static AdminController adminController;
	
>>>>>>> refs/remotes/origin/pr/2
	public Controllers() {

		programController = new ProgramController();
<<<<<<< HEAD
		userController=new UserController();

		emotionController = new EmotionController();

=======
		adminController = new AdminController();
		
>>>>>>> refs/remotes/origin/pr/2
	}

	public static ProgramController getProgramController() {

		return programController;

	}

<<<<<<< HEAD
	public static UserController getUserController() {
		return userController;
	}


	public static EmotionController getEmotionController() {
		return emotionController;
	}


=======
	public static AdminController getAdminController() {
		
		return adminController;
		
	}

>>>>>>> refs/remotes/origin/pr/2
}
