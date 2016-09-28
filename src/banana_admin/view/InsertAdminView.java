package banana_admin.view;

import java.util.Scanner;

import banana_admin.controller.Controllers;
<<<<<<< HEAD
import banana_admin.domain.AdminDomain;

public class InsertAdminView {

	private Scanner keyboard;
	
	public InsertAdminView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void insertAdminView(){
		
		System.out.println("관리자 아이디을 입력하세요.");
		String insertAdminId = keyboard.next();
		System.out.println("관리자 비밀번호를 입력하세요.");
		String insertAdminPassWord = keyboard.next();
		System.out.println("관리자명을 입력하세요.");
		String insertAdminName = keyboard.next();
		
		AdminDomain adminDomain = new AdminDomain(insertAdminId, insertAdminPassWord, insertAdminName);
		Controllers.getAdminController().RegisterProcess(adminDomain);
		
	}
	
=======
import banana_admin.domain.Admin;

public class InsertAdminView {

	 private Scanner keyboard;
	   
	   public InsertAdminView() {
	      
	      keyboard = new Scanner(System.in);
	      
	   }
	   
	   public void insertAdminView(){
	      
	      System.out.println("관리자 아이디를 입력하세요.");
	      String insertAdminId = keyboard.next();
	      System.out.println("관리자 비밀번호를 입력하세요.");
	      String insertAdminPassWord = keyboard.next();
	      System.out.println("관리자명을 입력하세요.");
	      String insertAdminName = keyboard.next();
	      
	      Admin adminDomain = new Admin(insertAdminId, insertAdminPassWord, insertAdminName);
	      
	      Controllers.getAdminController().requestRegisterAdmin(adminDomain);
	      
	   }
>>>>>>> refs/remotes/yuns111/master
	
}
