package banana_admin.view;

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
		int updateNumber = keyboard.nextInt();
		
		System.out.print("감정 명 : ");
		String updateName = keyboard.next();
		
		Emotion emotion = new Emotion(updateNumber, updateName);
		
		Controllers.getEmotionController().requestUpdateEmotion(emotion);
	}
	
	public void selectOneForDelete(){
		
		System.out.print("삭제할 감정 번호 : ");
		int deleteNumber = keyboard.nextInt();
		
		Controllers.getEmotionController().requestdeleteEmotion(deleteNumber);
		
	}

}
