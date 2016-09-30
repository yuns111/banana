package banana_admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Emotion;

public class EmotionUpdateDeleteView {

	private Scanner keyboard;

	public EmotionUpdateDeleteView() {

		keyboard = new Scanner(System.in);

	}

	public void selectOneForUpdate(){

		System.out.print("수정할 감정 번호 : ");

		int updateNumber = -1;

		while(true){
			try {

				updateNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}

		System.out.print("감정 명 : ");
		String updateName = keyboard.next();

		Emotion emotion = new Emotion(updateNumber, updateName);

		Controllers.getEmotionController().requestUpdateEmotion(emotion);

	}

	public void selectOneForDelete() {

		System.out.print("삭제할 감정 번호 : ");


		int deleteNumber = -1;

		while(true){
			try {

				deleteNumber= keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");
				
			} 
		}

		Controllers.getEmotionController().requestdeleteEmotion(deleteNumber);

	}

}