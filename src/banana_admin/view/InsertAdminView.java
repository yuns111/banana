package banana_admin.view;

import java.util.Scanner;

<<<<<<< HEAD
public class InsertAdminView {
	
=======
import banana_admin.controller.Controllers;
import banana_admin.domain.AdminDomain;

public class InsertAdminView {

>>>>>>> refs/heads/test-branch
	private Scanner keyboard;
	
	public InsertAdminView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void insertAdminView(){
		
<<<<<<< HEAD
		System.out.println("아이디을 입력하세요.");
		String insertID = keyboard.next();
		System.out.println("비밀번호를 입력하세요.");
		String insertPassword = keyboard.next();
		System.out.println("관리자명을 입력하세요.");
		String insertAdminName = keyboard.next();
		
		
		
		
	}
	

=======
		System.out.println("관리자 아이디을 입력하세요.");
		String insertAdminId = keyboard.next();
		System.out.println("관리자 비밀번호를 입력하세요.");
		String insertAdminPassWord = keyboard.next();
		System.out.println("관리자명을 입력하세요.");
		String insertAdminName = keyboard.next();
		
		AdminDomain adminDomain = new AdminDomain(insertAdminId, insertAdminPassWord, insertAdminName);
		Controllers.getAdminController().RegisterProcess(adminDomain);
		
	}
	
	
>>>>>>> refs/heads/test-branch
}
