package banana_admin.controller;

import java.util.ArrayList;

import banana_admin.dao.EmotionDao;
import banana_admin.domain.Emotion;
import banana_admin.view.AlertView;
import banana_admin.view.EmotionRegisterView;
import banana_admin.view.EmotionSelectAllView;
import banana_admin.view.EmotionUpdateDeleteView;

public class EmotionController {

	EmotionDao emotionDao;

	public EmotionController() {

		emotionDao = new EmotionDao();

	}

	//감정 입력
	public void requestRegisterEmotionView() {

		//입력 view 호출
		EmotionRegisterView registerView = new EmotionRegisterView();
		registerView.emotionRegister();

	}

	public void requestRegisterEmotion(String emotionName) {

		//감정 등록 dao호출
		boolean success = emotionDao.insertRegisterEmotion(emotionName);

		if(success) {
			
			new AlertView().alert("감정등록성공");
			
		} else {
			
			new AlertView().alert("감정등록실패");
			
		}

		Controllers.getEmotionController().requestSelectAllEmotion();
		
	}

	public void requestSelectOneEmotion(int select) {
		
		//수정,삭제할 감정 번호 선택
		//select 1:수정, 2:삭제
		if(select == 1) {
			
			EmotionUpdateDeleteView updateView = new EmotionUpdateDeleteView();
			updateView.selectOneForUpdate();
			
		} else {
			
			EmotionUpdateDeleteView deleteView = new EmotionUpdateDeleteView();
			deleteView.selectOneForDelete();
			
		}
		
	}

	//감정 수정
	public void requestUpdateEmotion(Emotion updateEmotion) {

		//선택한 번호의 감정 수정 dao 호출
		boolean success = emotionDao.updateEmotion(updateEmotion);

		if(success) {
			
			new AlertView().alert("감정수정성공");
			
		} else {
			
			new AlertView().alert("감정수정실패");
			
		}

		Controllers.getEmotionController().requestSelectAllEmotion();
		
	}

	//감정 삭제
	public void requestdeleteEmotion(int deleteNumber) {

		//감정삭제 dao 호출
		boolean success = emotionDao.deleteEmotion(deleteNumber);

		if(success) {
			
			new AlertView().alert("감정삭제성공");
			
		} else {
			
			new AlertView().alert("감정삭제실패");
			
		}

		Controllers.getEmotionController().requestSelectAllEmotion();

	}

	//감정 리스트
	public void requestSelectAllEmotion() {

		//dao에서 목록가져옴
		ArrayList<Emotion> emotions = new ArrayList<Emotion>();
		emotions = emotionDao.selectAllEmotion();

		//view호출
		EmotionSelectAllView selectAllView = new EmotionSelectAllView();
		selectAllView.EmotionSelectAll(emotions);

	}

	//감정메뉴 호출 컨트롤러
	public void gotoEmotionMenu() {

		EmotionSelectAllView emotionMenu = new EmotionSelectAllView();
		emotionMenu.menu();

	}

}