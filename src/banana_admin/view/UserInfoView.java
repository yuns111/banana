package banana_admin.view;

import java.util.ArrayList;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.User;

public class UserInfoView {

	private Scanner keyboard;

	public UserInfoView() {

		keyboard = new Scanner(System.in);

	}

	public void printUserInfo(ArrayList<User> user) {

		System.out.println("\n[회원관리 모드]");

		System.out.println("회원번호\t회원id\t회원이름");

		for(int i=0;i<user.size();i++){
			System.out.print(user.get(i).getUserNumber() + "\t");
			System.out.print(user.get(i).getUserId() + "\t");
			System.out.println(user.get(i).getUserName());
		}

		Controllers.getUserController().requestMenu();

	}

	public void menu() {
		
		while(true) {

			System.out.print("[1]회원정보조회  [2]회원정보수정  [3]회원강제탈퇴  [0]메뉴로 돌아가기] : ");

			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {
			case 1:
				Controllers.getUserController().requestOneUser();
				break;
			case 2:
				Controllers.getUserController().requestUpdateUserInfo();
				break;
			case 3:
				Controllers.getUserController().requestDeleteUser();
				break;
			case 0:
				break;

			default:
				new AlertView().alert("메뉴를 다시 선택해 주세요.");
			}
		}

	}

}