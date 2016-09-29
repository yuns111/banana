import banana_admin.controller.Controllers;

public class Main {

	public static void main(String[] args) {


		new Controllers();

		System.out.println("관리자모드");
		Controllers.getTicketController().goToTicketMenuView();
		Controllers.getUserController().requestMenu();
		Controllers.getMusicController().requestSelectAllMusic();
		
		Controllers.getAdminController().goToMenu();
		
	}
}