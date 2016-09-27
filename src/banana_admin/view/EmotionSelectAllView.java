package banana_admin.view;

import java.util.ArrayList;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Emotion;

public class EmotionSelectAllView {
	
	private Scanner keyboard;

	public EmotionSelectAllView() {

		keyboard = new Scanner(System.in);
	}

	public void EmotionSelectAll(ArrayList<Emotion> emotions){

		if(emotions.size() == 0){

			System.out.println("등록된 감정이 없습니다.");
		} else {
			
			System.out.println("[번호]\t[감정명]");
			for(int i=0; i<emotions.size(); i++){

				System.out.println(emotions.get(i).getEmotionNumber()+"\t"
						+emotions.get(i).getEmotionName());
			}
		}
		
		this.menu();
	}
	
	public void menu(){
		
		System.out.println("[1.감정 등록  2.감정명 수정  3.감정 삭제]");
		int selectedNumber = keyboard.nextInt();
		
		switch(selectedNumber){
		case 1 :
			Controllers.getEmotionController().requestRegisterEmotionView();
			break;
		case 2 :
			Controllers.getEmotionController().requestSelectOneEmotion(1);
			break;
		case 3 : 
			Controllers.getEmotionController().requestSelectOneEmotion(2);
			break;
		default :
			System.out.println("잘못입력하셨습니다.");
			break;
		}
		
		
		
		
	}

}
