package banana_admin.view;

import java.util.ArrayList;
import java.util.Scanner;

import banana_admin.domain.Admin;

<<<<<<< HEAD
public class selectAllAdminView {
   
   private Scanner keyboard;
   
   public selectAllAdminView() {
      
      keyboard = new Scanner(System.in);
      
   }
   
   public void adminSelectAll(ArrayList<Admin> adminList) {
      
      System.out.println("\n[관리자 목록]");
      System.out.println("관리자번호\t관리자ID\t관리자이름\t관리자등급");
      
      if(adminList.size() == 0) {
         new AlertView().alert("관리자가 없습니다.");
      } else {
         for(int i = 0; i < adminList.size(); i++) {
            System.out.print(adminList.get(i).getAdminNumber() + "\t");
            System.out.print(adminList.get(i).getAdminID() + "\t");
            System.out.print(adminList.get(i).getAdminName() + "\t");
            System.out.println(adminList.get(i).getAdminGrade());
         }
      }
      
   }
=======
public class SelectAllAdminView {
	
	private Scanner keyboard;
	
	public SelectAllAdminView() {
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void adminSelectAll(ArrayList<Admin> adminList) {
		
		System.out.println("\n[관리자 목록]");
		System.out.println("관리자번호\t관리자ID\t관리자이름\t관리자등급");
		
		if(adminList.size() == 0) {
			new AlertView().alert("관리자가 없습니다.");
		} else {
			for(int i = 0; i < adminList.size(); i++) {
				System.out.print(adminList.get(i).getAdminNumber() + "\t");
				System.out.print(adminList.get(i).getAdminID() + "\t");
				System.out.print(adminList.get(i).getAdminName() + "\t");
				System.out.println(adminList.get(i).getAdminGrade());
			}
		}
		
	}
>>>>>>> refs/remotes/yuns111/master

   
   
}