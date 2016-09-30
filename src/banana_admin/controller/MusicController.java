package banana_admin.controller;

import java.util.ArrayList;

import banana_admin.dao.MusicDao;
import banana_admin.domain.Music;
import banana_admin.view.AlertView;
import banana_admin.view.MusicDeleteView;
import banana_admin.view.MusicInfoView;
import banana_admin.view.MusicRegisterView;
import banana_admin.view.MusicUpdateView;
import banana_admin.view.SelectOneMusicView;

public class MusicController {

	private MusicDao musicDao;

	public MusicController() {

		musicDao = new MusicDao();

	}

	//음원 목록 보기 요청을 처리하는 메서드
	public void requestSelectAllMusic() {

		ArrayList<Music> musicList = musicDao.selectAllMusic();

		MusicInfoView musicInfoView = new MusicInfoView();
		musicInfoView.printMusicList(musicList);

	}

	//음원 관리 서브메뉴 요청
	public void requestMusicInfoSub(){

		MusicInfoView musicInfoView = new MusicInfoView();
		musicInfoView.musicInfoSub();

	}

	//음원 등록 요청을 처리하는 메서드
	public void requestRegisterMusic() {

		//음원 등록에 필요한 정보를 취득하는 뷰
		MusicRegisterView musicRegisterView = new MusicRegisterView();
		musicRegisterView.musicRegister(Controllers.getEmotionController().emotionDao.selectAllEmotion());

	}

	//음원 등록 응답
	public void responseRegisterMusic(Music music) {

		//Dao에서 등록
		AlertView alertView = new AlertView();
		boolean success = musicDao.insertRegisterMusic(music);

		if(success) {
			alertView.alert("음원등록 성공.");
		} else {
			alertView.alert("음원등록 실패.");
		}

		Controllers.getMusicController().requestSelectAllMusic();

	}

	//음원 조회 요청을 처리하는 메서드
	public void requestSelectOneMusic() {

		SelectOneMusicView selectOneMusicView = new SelectOneMusicView();
		selectOneMusicView.getSelectOneMusicNumber();

	}

	//음원 조회 응답
	public void responseSelectOneMusic(int musicNumber) {

		Music music = musicDao.selectOneMusic(musicNumber);
		SelectOneMusicView selectOneMusicView = new SelectOneMusicView();
		selectOneMusicView.printMusicInfo(music);

	}

	//음원 수정 요청을 처리하는 메서드
	public void requestUpdateMusic() {

		MusicUpdateView musicUpdateView = new MusicUpdateView();
		musicUpdateView.updateMusic();

	}

	//음원 수정 응답
	public void responseUpdateMusic(Music music) {

		//Dao 통해 수정
		AlertView alertView = new AlertView();
		boolean success = musicDao.updateMusic(music);

		if(success) {
			alertView.alert("음원 수정 성공");
		} else {
			alertView.alert("음원 수정 실패");
		}

		Controllers.getMusicController().requestSelectAllMusic();

	}

	//음원 삭제 요청을 처리하는 메서드
	public void requestDeleteMusic() {

		MusicDeleteView musicDeleteView = new MusicDeleteView();
		musicDeleteView.getDeleteMusicNumber();


	}

	public void responseDeleteMusic(int musicNumber) {

		//dao
		boolean success = musicDao.deleteMusic(musicNumber);
		AlertView alertView = new AlertView();

		if(success) {
			alertView.alert("음원삭제 성공");
		} else {
			alertView.alert("음원삭제 실패");
		}

		Controllers.getMusicController().requestSelectAllMusic();
	}

}