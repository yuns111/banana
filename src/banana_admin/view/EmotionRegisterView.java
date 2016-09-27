package banana_admin.view;

import java.util.Scanner;

import banana_admin.controller.Controllers;

public class EmotionRegisterView {
	
	private Scanner keyboard;
	
	public void emotionRegister(){
		
		System.out.print("등록할 감정 명 : ");
		String emotionName = keyboard.next();
		
		Controllers.getEmotionController().requestRegisterEmotion(emotionName);
	}

}
