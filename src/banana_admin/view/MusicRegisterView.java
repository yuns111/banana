package banana_admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Music;


public class MusicRegisterView {

	private Scanner keyboard;

	public MusicRegisterView() {

		keyboard = new Scanner(System.in);

	}


	public void musicRegister() {

		String title = null;
		String singer = null;
		String lyrics = null;
		int emotionNumber = 0;
		int playingCount = 0;

		boolean exit = true;

		do {

			try {					
				System.out.println("\n[음원 등록 모드]");

				System.out.print("제목 : ");	
				title = keyboard.next();

				System.out.print("가수 : ");
				singer = keyboard.next();

				System.out.print("가사 : ");
				lyrics = keyboard.next();

				System.out.print("감정번호 : ");
				System.out.println("1.? 2.? 3.? 4.?");
				emotionNumber = keyboard.nextInt();

				exit = false;

			} catch(InputMismatchException e){			
				System.out.println("숫자를 입력하세요");
				keyboard = new Scanner(System.in); 
			}

		} while(exit);

		Music music = new Music(title, singer, lyrics, emotionNumber);
		Controllers.getMusicController().responseRegisterMusic(music);

	}

}
