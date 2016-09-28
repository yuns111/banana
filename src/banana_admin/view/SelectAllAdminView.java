package banana_admin.view;

import java.util.ArrayList;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.AdminDomain;

public class SelectAllAdminView {

	Scanner keyboard;
	
	public SelectAllAdminView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void selectAllAdminView(){
		System.out.println("관리자번호/t관리자ID/t관리자PW/t관리자명/t관리자등급");
		ArrayList<AdminDomain> adminInfo= Controllers.getAdminController().requestSelectAllAdmin();
		
		for(int i = 0; i<adminInfo.size();i++){
		System.out.println(adminInfo.get(i).getAdminNumber() +"/t");
		System.out.println(adminInfo.get(i).getAdminID() +"/t");
		System.out.println(adminInfo.get(i).getAdminPassword() +"/t");
		System.out.println(adminInfo.get(i).getAdminName() +"/t");
		System.out.println(adminInfo.get(i).getAdminGrade());
		}
		
	}
	
}
