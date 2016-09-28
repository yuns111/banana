package banana_admin.view;

import java.util.ArrayList;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Music;

public class MusicInfoView {

	private Scanner keyboard;

	public MusicInfoView() {

		keyboard = new Scanner(System.in);

	}

	public void printMusicList(ArrayList<Music> musicList) {

		System.out.println("\n[음원관리 모드]");

		System.out.println("음원번호\t제목\t가수\t감정번호\t재생횟수");

		for(int i = 0; i < musicList.size(); i++) {
			System.out.print(musicList.get(i).getMusicNumber() + "\t");
			System.out.print(musicList.get(i).getTitle() + "\t");
			System.out.print(musicList.get(i).getSinger() + "\t");
			System.out.print(musicList.get(i).getEmotionNumber() + "\t");
			System.out.println(musicList.get(i).getPlayingCount());
		}

		Controllers.getMusicController().requestMusicInfoSub();

	}

	public void musicInfoSub() {
		
		while(true) {

			System.out.print("[1]음원조회  [2]음원수정  [3]음원삭제  [0]프로그램 종료] : ");

			int selectedMenu = keyboard.nextInt();

			switch (selectedMenu) {
			case 1:
				Controllers.getMusicController().requestSelectOneMusic();
				break;
			case 2:
				Controllers.getMusicController().requestUpdateMusic();
				break;
			case 3:
				Controllers.getMusicController().requestDeleteMusic();
				break;
			case 0:
				Controllers.getProgramController().requestExitProgram();
				break;

			default:
				new AlertView().alert("메뉴를 다시 선택해 주세요.");
				
			}
		}

	}
	
}
