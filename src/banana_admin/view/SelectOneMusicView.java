package banana_admin.view;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Music;
import banana_admin.domain.User;

public class SelectOneMusicView {

	private Scanner keyboard;

	public SelectOneMusicView() {

		keyboard = new Scanner(System.in);

	}

	public void getSelectOneMusicNumber() {

		int musicNumber = 0;

		System.out.print("\n조회할 음원 번호를 입력하세요 : ");
		musicNumber = keyboard.nextInt();

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
