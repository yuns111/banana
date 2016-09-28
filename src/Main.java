import banana_admin.controller.Controllers;

public class Main {

	public static void main(String[] args) {


		new Controllers();
		Controllers.getUserController().requestMenu();

		Controllers.getMusicController().requestSelectAllMusic();
		
	}
	
}