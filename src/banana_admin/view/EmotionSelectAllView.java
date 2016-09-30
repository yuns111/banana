package banana_admin.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Emotion;

public class EmotionSelectAllView {

	private Scanner keyboard;
	public EmotionSelectAllView() {

		keyboard = new Scanner(System.in);

	}


	public void EmotionSelectAll(ArrayList<Emotion> emotions) {

		if(emotions.size() == 0) {

			System.out.println("등록된 감정이 없습니다.");

		} else {

			System.out.println("번호\t감정명");

			for(int i=0; i<emotions.size(); i++) {

				System.out.println(emotions.get(i).getEmotionNumber()+"\t"
						+emotions.get(i).getEmotionName());

			}

		}

		Controllers.getEmotionController().gotoEmotionMenu();

	}

	public void menu() {

		int selectedNumber = -1;

		while(true) {

			System.out.println("[감정관리모드]");
			System.out.print("[1.감정 등록  2.감정명 수정  3.감정 삭제 0.이전메뉴] : ");


			try {

				selectedNumber= keyboard.nextInt();

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);

			}


			switch(selectedNumber) {

			case 1 :
				Controllers.getEmotionController().requestRegisterEmotionView();
				break;
			case 2 :
				Controllers.getEmotionController().requestSelectOneEmotion(1);
				break;
			case 3 : 
				Controllers.getEmotionController().requestSelectOneEmotion(2);
				break;
			case 0 :
				if(Controllers.getLoginController().requestCheckMaster()) {
					Controllers.getAdminController().goToMAdminMenu();
				} else {
					Controllers.getAdminController().goToAdminMenu();
				}
				break;
			default :
				System.out.println("잘못입력하셨습니다 다시 선택해주세요.");
				break;
			}

		}

	}

}