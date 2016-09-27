package banana_admin.view;

import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.User;

public class UserInfoUpdateView {

	private Scanner keyboard;

	public UserInfoUpdateView() {

		keyboard = new Scanner(System.in);

	}

	//수정할 회원 정보 입력
	public void willUpdateUser(int userNumber) {

		User user = null;

		System.out.println("[회원수정 모드]");
		System.out.println("회원Password : ");
		String userPassword = keyboard.next();
		System.out.println("회원이름 : ");
		String userName = keyboard.next();
		System.out.println("회원 성별:");
		String userGender=keyboard.next();
		System.out.println("휴대폰 번호");
		String userPhoneNumber=keyboard.next();

		user = new User(userNumber,userPassword,userName,userGender,userPhoneNumber);
		Controllers.getUserController().requestResponseUser(user);
		

	}

}