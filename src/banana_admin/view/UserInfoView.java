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
		
		SelectOneUserView sel = new SelectOneUserView();
		
		while(true) {


			System.out.print("[1]회원정보조회  [2]회원정보수정  [3]회원강제탈퇴  [0]메뉴로 돌아가기] : ");

			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {
			case 1:
				new AlertView().alert("유저 컨트롤러에 회원정보조회를 요청함."); 
				sel.selectOneView();
				Controllers.getUserController().requestOneUser();
				break;
			case 2:
				new AlertView().alert("유저 컨트롤러에 회원정보수정을 요청함.");
				sel.selectOneView();
				Controllers.getUserController().requestUpdateUserInfo();
				break;
			case 3:
				new AlertView().alert("유저 컨트롤러에 회원탈퇴를 요청함.");
				sel.selectOneView();
				Controllers.getUserController().requestDeleteUser();
				break;
			case 0:
				new AlertView().alert("관리자 컨트롤러에 관리자 메뉴를 요청함.");
				
				break;

			default:
				new AlertView().alert("메뉴를 다시 선택해 주세요.");
			}
		}

	}

}