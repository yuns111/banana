import banana_admin.controller.Controllers;

public class Main {

	public static void main(String[] args) {
	
		new Controllers();
		Controllers.getAdminController().requestSelectAllAdmin();
		Controllers.getAdminController().requestDelete();
		Controllers.getAdminController().requestUpdateAdminNumber();
		Controllers.getAdminController().menuViewToInsertView(); // insert
		
		
	}

}
