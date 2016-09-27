package banana_admin.view;

import java.util.Scanner;

public class InsertAdminView {
	
	private Scanner keyboard;
	
	public InsertAdminView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void insertAdminView(){
		
		System.out.println("아이디을 입력하세요.");
		String insertID = keyboard.next();
		System.out.println("비밀번호를 입력하세요.");
		String insertPassword = keyboard.next();
		System.out.println("관리자명을 입력하세요.");
		String insertAdminName = keyboard.next();
		
		
		
		
	}
	

}
