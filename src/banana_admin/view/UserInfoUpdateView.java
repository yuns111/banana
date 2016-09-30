package banana_admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.User;

public class UserInfoUpdateView {

	private Scanner keyboard;

	public UserInfoUpdateView() {

		keyboard = new Scanner(System.in);

	}
	
	public void selectUpdateView() {

		int selectUserNumber = 0;
		System.out.print("\n유저 번호 입력해주세요: ");
		
		while(true){
			try {

				selectUserNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");
				keyboard = new Scanner(System.in);

			} 
		}

		Controllers.getUserController().responseUpdateUserInfo(selectUserNumber);
		
	}

	//수정할 회원 정보 입력
	public void willUpdateUser(int userNumber) {

		User user = null;

		System.out.println("\n[회원수정 모드]");
		
		System.out.print("회원Password : ");
		String userPassword = keyboard.next();
		System.out.print("회원이름 : ");
		String userName = keyboard.next();
		System.out.print("회원 성별 :");
		String userGender=keyboard.next();
		System.out.print("휴대폰 번호 : ");
		String userPhoneNumber=keyboard.next();

		user = new User(userNumber,userPassword,userName,userGender,userPhoneNumber);
		Controllers.getUserController().requestResponseUser(user);

	}

}