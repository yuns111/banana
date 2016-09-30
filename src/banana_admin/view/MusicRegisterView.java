package banana_admin.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Emotion;
import banana_admin.domain.Music;


public class MusicRegisterView {

	private Scanner keyboard;

	public MusicRegisterView() {

		keyboard = new Scanner(System.in);

	}

	public void musicRegister(ArrayList<Emotion> emotions) {

		String title = null;
		String singer = null;
		String lyrics = null;
		int emotionNumber = -1;
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
				
				for(int i=0; i< emotions.size(); i++) {
					
					System.out.print((i+1)+"."+emotions.get(i).getEmotionName()+"  ");
					
				}
				
				System.out.println("");
				
				while(true){
					try {

						emotionNumber = keyboard.nextInt();
						break;

					} catch (InputMismatchException e) {

						keyboard = new Scanner(System.in);
						System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

					} 
				}
				exit = false;

			} catch(InputMismatchException e) {	
				
				System.out.println("숫자를 입력하세요");
				keyboard = new Scanner(System.in); 
				
			}

		} while(exit);

		Music music = new Music(title, singer, lyrics, emotionNumber);
		Controllers.getMusicController().responseRegisterMusic(music);

	}

}