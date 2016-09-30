package banana_admin.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Music;

public class MusicInfoView {

	private Scanner keyboard;

	public MusicInfoView() {

		keyboard = new Scanner(System.in);

	}

	public void printMusicList(ArrayList<Music> musicList) {

		System.out.println("음원번호\t제목\t\t가수\t감정번호\t재생횟수");

		for(int i = 0; i < musicList.size(); i++) {
			
			System.out.print(musicList.get(i).getMusicNumber() + "\t");
			String title = musicList.get(i).getTitle();
			
			if(title.length() >= 6) {
				
				title = title.substring(0, 5);
				title = title + "..";
				
			} else {
				
				title = title + "\t";
				
			}
			
			System.out.print(title + "\t");
			System.out.print(musicList.get(i).getSinger() + "\t");
			System.out.print(musicList.get(i).getEmotionNumber() + "\t");
			System.out.println(musicList.get(i).getPlayingCount());

		}

		Controllers.getMusicController().requestMusicInfoSub();

	}

	public void musicInfoSub() {

		while(true) {

			int selectedMenu = 0;
			System.out.println("\n[음원관리 모드]");
			System.out.print("[1.음원등록 2.음원조회  3.음원수정  4.음원삭제  0.이전메뉴] : ");

			try {

				selectedMenu = keyboard.nextInt();

			}

			catch(InputMismatchException e) {

				keyboard = new Scanner(System.in);

			}

			switch (selectedMenu) {

			case 1:
				Controllers.getMusicController().requestRegisterMusic();
				break;
			case 2:
				Controllers.getMusicController().requestSelectOneMusic();
				break;
			case 3:
				Controllers.getMusicController().requestUpdateMusic();
				break;
			case 4:
				Controllers.getMusicController().requestDeleteMusic();
				break;
			case 0:
				if(Controllers.getLoginController().requestCheckMaster()) {
					Controllers.getAdminController().goToMAdminMenu();
				} else {
					Controllers.getAdminController().goToAdminMenu();
				}
				break;
			default:
				System.out.println("잘못입력하셨습니다 다시 선택해주세요.");
			}

		}

	}

}