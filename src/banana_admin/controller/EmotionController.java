package banana_admin.controller;

import banana_admin.dao.EmotionDao;
import banana_admin.view.AlertView;
import banana_admin.view.EmotionRegisterView;

public class EmotionController {
	
	EmotionDao emotionDao;
	
	public EmotionController() {
		
		emotionDao = new EmotionDao();
		
	}
	
	//감정 입력
	public void requestRegisterEmotionView(){
		
		//입력 view 호출
		EmotionRegisterView registerView = new EmotionRegisterView();
		registerView.emotionRegister();
		
	}
	
	public void requestRegisterEmotion(String emotionName){
		
		//감정 등록 dao호출
		boolean success = emotionDao.insertRegisterEmotion(emotionName);
		
		if(success){
			
			new AlertView().alert("감정등록성공");
			
		} else {
			
			new AlertView().alert("감정등록실패");
			
		}
	}
	
	//감정 수정
	
	//감정 삭제
	
	//감정 리스트

}
