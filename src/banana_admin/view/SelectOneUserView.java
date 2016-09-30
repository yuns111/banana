package banana_admin.view;
import java.util.InputMismatchException;
import java.util.Scanner;
import banana_admin.controller.Controllers;
import banana_admin.domain.User;

public class SelectOneUserView {

	private Scanner keyboard;

	public SelectOneUserView(){

		keyboard=new Scanner(System.in);
		
	}

	public void selectOneView() {

		int selectUserNumber;
		System.out.print("\n유저 번호 입력해주세요: ");
		
		while(true){
			try {

				selectUserNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}


		Controllers.getUserController().responseOneUser(selectUserNumber);
		
	}
	
	public void selectDeleteView() {

		int selectUserNumber = 0;
		System.out.print("\n유저 번호 입력해주세요: ");
		
		while(true){
			try {

				selectUserNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");
				
			} 
		}

		Controllers.getUserController().responseDeleteUser(selectUserNumber);
		
	}

	public void selectOneUserView(User user) {

		if(user.getUserId() != null) {
			
			System.out.println();
			System.out.println("회원id: "+user.getUserId());
			System.out.println("회원이름: "+user.getUserName());
			System.out.println("성별: "+user.getUserGender());
			System.out.println("전화번호: "+user.getUserPhoneNumber());
			
		} else {
			
			System.out.println("해당 유저가 없습니다.\n");
			
		}
		
	}

}