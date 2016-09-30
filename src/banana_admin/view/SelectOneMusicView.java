package banana_admin.view;
import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Music;

public class SelectOneMusicView {

	private Scanner keyboard;

	public SelectOneMusicView() {

		keyboard = new Scanner(System.in);

	}

	public void getSelectOneMusicNumber() {

		int musicNumber = -1;

		System.out.print("\n조회할 음원 번호를 입력하세요 : ");
		
		while(true){
			try {

				musicNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}
		
		Controllers.getMusicController().responseSelectOneMusic(musicNumber);
		
	}

	public void printMusicInfo(Music music) {

		System.out.println("음원번호: " + music.getMusicNumber());
		System.out.println("제목: " + music.getTitle());
		System.out.println("가수: " + music.getSinger());
		System.out.println("감정번호: " + music.getEmotionNumber());
		System.out.println("재생횟수: " + music.getPlayingCount());

	}

}