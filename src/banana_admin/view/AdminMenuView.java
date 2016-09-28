package banana_admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;

public class AdminMenuView {

	Scanner keyboard;

	public AdminMenuView() {

		keyboard = new Scanner(System.in);
	}

	public void adminMenuView(){

		while(true){
			System.out.println("관리자 메뉴");
			System.out.println("1.로그인 2.프로그램 종료");
			int choiceAdminMenu = keyboard.nextInt();

			if(choiceAdminMenu == 1){
				//로그인으로 이동

			} else if(choiceAdminMenu == 2){
				break;

			} else {try {} catch (InputMismatchException e) {} finally {
				System.out.println("잘못입력하셨습니다.");
			}
			}
		}
	}
	
	public void adminSubMenuView_M(){
		
		while(true){
			System.out.println("관리자 메뉴");
			System.out.print("1.관리자관리 2.음원관리 3.회원권 관리 4.이용권 관리 5.감정 6.통계");
			int choiceSubAdminMenu = keyboard.nextInt();
			if(choiceSubAdminMenu == 1){
				this.adminManage();
			} else if(choiceSubAdminMenu == 2){
				
			} else if(choiceSubAdminMenu == 3){
				
			} else if(choiceSubAdminMenu == 4){
				
			} else if(choiceSubAdminMenu == 5){
				
			} else if(choiceSubAdminMenu == 6){
				
			} else{try {} catch (InputMismatchException e) {} finally {
				System.out.println("잘못입력하셨습니다.");
			}
			}
			
		}
	}
	
	public void adminManage(){
		
		
		
		while(true){
			System.out.println("관리자 관리");
			System.out.println("1.관리자 등록 2.관리자 수정 3.관리자 삭제");
			int choiceAdminManage = keyboard.nextInt();
			
			if(choiceAdminManage == 1){
				Controllers.getAdminController().menuViewToInsertView();
			} else if(choiceAdminManage == 2){
				
			} else if(choiceAdminManage == 3){
				
			} else {
				try {} catch (InputMismatchException e) {} finally {
					System.out.println("잘못입력하셨습니다.");
				}
				
			}
			
		}
	}
}