package banana_admin.controller;

public class Controllers {
	
	private static ProgramController programController;
	private static AdminController adminController;
	
	public Controllers() {
		
		programController = new ProgramController();
		adminController = new AdminController();
		
	}

	public static ProgramController getProgramController() {

		return programController;

	}

	public static AdminController getAdminController() {
		
		return adminController;
		
	}

}
