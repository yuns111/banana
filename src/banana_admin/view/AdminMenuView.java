package banana_admin.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;

public class AdminMenuView {

	Scanner keyboard;

	public AdminMenuView() {

		keyboard = new Scanner(System.in);
	}

	public void adminMenuView(){

		while(true){
			System.out.println("\n[관리자 메뉴]");
			System.out.print("[1.로그인 2.프로그램 종료] : ");
			int choiceAdminMenu = 0;

			try{

				choiceAdminMenu= keyboard.nextInt();

				if(choiceAdminMenu == 1){

					Controllers.getLoginController().requestLogin();

				} else if(choiceAdminMenu == 2){
					break;

				} else {

					System.out.println("잘못입력하셨습니다 다시 선택해주세요.");
				}

			} catch (InputMismatchException e) {} finally {
				System.out.println("잘못입력하셨습니다 다시 선택해주세요.");
			}
		}
	}

	public void adminSubMenuView_M(){

		while(true){
			System.out.println("\n[M관리자 메뉴]");
			System.out.print("[1.관리자 관리 2.음원 관리 3.회원 관리 4.이용권 관리 5.감정 관리 6.통계 0.프로그램종료] : ");
			int choiceSubAdminMenu = 0;

			try{

				choiceSubAdminMenu = keyboard.nextInt();

				if(choiceSubAdminMenu == 1){

					Controllers.getAdminController().requestSelectAllAdmin();

				} else if(choiceSubAdminMenu == 2){

					Controllers.getMusicController().requestSelectAllMusic();

				} else if(choiceSubAdminMenu == 3){

					Controllers.getUserController().requestAllUser();

				} else if(choiceSubAdminMenu == 4){

					Controllers.getTicketController().requestTicketList();

				} else if(choiceSubAdminMenu == 5){

					Controllers.getEmotionController().requestSelectAllEmotion();

				} else if(choiceSubAdminMenu == 6){

					Controllers.getStatsController().requestStatsAnalysis();

				}  else if(choiceSubAdminMenu == 0){

					Controllers.getProgramController().requestExitProgram();

				} else {

					System.out.println("잘못입력하셨습니다 다시 선택해주세요.");
				}
			}catch (InputMismatchException e) {
				System.out.println("잘못입력하셨습니다 다시 선택해주세요.");

			}
		}
	}

	//일발관리자 메뉴
	public void adminSubMenuView(){

		while(true){
			System.out.println("\n[관리자 메뉴]");
			System.out.print("[1.음원 관리 2.회원 관리 3.이용권 관리 4.감정 관리 5.통계 0.프로그램종료] : ");
			int choiceSubAdminMenu = 0;

			try{
				choiceSubAdminMenu = keyboard.nextInt();

				if(choiceSubAdminMenu == 1){

					Controllers.getMusicController().requestSelectAllMusic();

				} else if(choiceSubAdminMenu == 2){

					Controllers.getUserController().requestAllUser();

				} else if(choiceSubAdminMenu == 3){

					Controllers.getTicketController().requestTicketList();

				} else if(choiceSubAdminMenu == 4){

					Controllers.getEmotionController().requestSelectAllEmotion();

				} else if(choiceSubAdminMenu == 5){

					Controllers.getStatsController().requestStatsAnalysis();

				} else if(choiceSubAdminMenu == 0){

					Controllers.getProgramController().requestExitProgram();

				}  else {

					System.out.println("잘못입력하셨습니다 다시 선택해주세요.");

				}
			}catch(InputMismatchException e){
				System.out.println("잘못입력하셨습니다 다시 선택해주세요.");
			}
		}
	}

	public void adminManage(){

		while(true){
			System.out.println("[관리자 관리 모드]");
			System.out.print("[1.관리자 등록 2.관리자 수정 3.관리자 삭제 0.이전메뉴] : ");

			int choiceAdminManage = 0;

			try{
				choiceAdminManage = keyboard.nextInt();

				if(choiceAdminManage == 1){

					Controllers.getAdminController().menuViewToInsertView();

				} else if(choiceAdminManage == 2){

					Controllers.getAdminController().requestUpdateAdminNumber();

				} else if(choiceAdminManage == 3){

					Controllers.getAdminController().requestDeleteAdminNumber();

				} else if(choiceAdminManage == 0){

					Controllers.getAdminController().goToMAdminMenu();

				} else {

					System.out.println("잘못입력하셨습니다 다시 선택해주세요.");

				}
			}catch(InputMismatchException e){
				System.out.println("잘못입력하셨습니다 다시 선택해주세요.");
			}
		}
	}
}