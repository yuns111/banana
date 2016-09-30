package banana_admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;

public class MusicDeleteView {

	private Scanner keyboard;

	public MusicDeleteView() {

		keyboard = new Scanner(System.in);

	}

	public void getDeleteMusicNumber() {

		int musicNumber = 0;

		System.out.print("\n삭제할 음원 번호를 입력하세요 : ");

		while(true){
			try {

				musicNumber= keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");
				
			} 
		}

		Controllers.getMusicController().responseDeleteMusic(musicNumber);

	}

}