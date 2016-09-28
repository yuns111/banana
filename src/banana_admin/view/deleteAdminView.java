package banana_admin.view;

import java.util.Scanner;

public class DeleteAdminView {
	
	private Scanner keyboard;
	
	public DeleteAdminView() {
		
		keyboard = new Scanner(System.in);
		
	}

	public int searchDeleteAdminNumber() {
		
		int searchDeleteAdminNumber = 0;
		
		System.out.println("\n[관리자 삭제 모드]");
		System.out.print("관리자 번호 : ");
		searchDeleteAdminNumber = keyboard.nextInt();
		
		return searchDeleteAdminNumber;
		
	}
	
}
