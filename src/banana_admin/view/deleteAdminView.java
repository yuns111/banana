package banana_admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;

public class DeleteAdminView {

	private Scanner keyboard;

	public DeleteAdminView() {

		keyboard = new Scanner(System.in);

	}

	public void searchDeleteAdminNumber() {

		int searchDeleteAdminNumber = -1;

		System.out.println("\n[관리자 삭제 모드]");
		System.out.print("관리자 번호 : ");

		while(true){
			try {

				searchDeleteAdminNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}

		Controllers.getAdminController().requestDeleteAdmin(searchDeleteAdminNumber);

	}

}