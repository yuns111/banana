package banana_admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Admin;

public class UpdateAdminView {

	private Scanner keyboard;

	public UpdateAdminView() {

		keyboard = new Scanner(System.in);

	}

	//수정할 관리자 번호 입력 화면
	public void searchUpdateAdminNumber() {

		int searchAdminNumber = 0;

		System.out.println("\n[수정할 관리자 선택]");
		System.out.print("관리자 번호 : ");
		
		while(true){
			try {

				searchAdminNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}

		Controllers.getAdminController().requestSearchNumberQuery(searchAdminNumber);

	}

	//수정할 관리자 정보 입력 화면
	public void adminUpdateInfo(int adminNumber) {

		System.out.println("[관리자 수정 모드]");
		System.out.print("관리자 ID : ");
		String adminID = keyboard.next();
		System.out.print("관리자 PW : ");
		String adminPassword = keyboard.next();
		System.out.print("관리자 이름 : ");
		String adminName = keyboard.next();
		
		Admin adminUpdateInfo = new Admin(adminNumber, adminID, adminPassword, adminName);
		
		Controllers.getAdminController().requestUpdateInfo(adminUpdateInfo);

	}

}