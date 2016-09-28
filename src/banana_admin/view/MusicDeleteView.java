package banana_admin.view;

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
		musicNumber = keyboard.nextInt();

		Controllers.getMusicController().responseDeleteMusic(musicNumber);
		
	}
	
}
