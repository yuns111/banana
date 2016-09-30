package banana_admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Music;


public class MusicUpdateView {

	private Scanner keyboard;

	public MusicUpdateView() {

		keyboard = new Scanner(System.in);

	}

	//수정할 음원 정보 입력
	public void updateMusic() {

		Music music = null;
		String title = null;
		String singer = null;
		String lyrics = null;
		int emotionNumber = 0;
		int musicNumber = 0;
		
		System.out.print("\n수정할 음원 번호를 입력하세요 : ");
		
		while(true){
			try {

				musicNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}

		System.out.println("\n[음원 수정 모드]");
		
		System.out.print("제목 : ");
		title = keyboard.next();
		System.out.print("가수 : ");
		singer = keyboard.next();
		System.out.print("가사 : ");
		lyrics = keyboard.next();
		System.out.print("감정 번호 : ");
		
		while(true){
			try {

				emotionNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}

		music = new Music(musicNumber,title,singer,lyrics,emotionNumber);		
		Controllers.getMusicController().responseUpdateMusic(music);

	}
	
}