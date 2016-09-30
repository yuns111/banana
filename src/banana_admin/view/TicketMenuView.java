package banana_admin.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sun.corba.se.impl.io.TypeMismatchException;

import banana_admin.controller.Controllers;
import banana_admin.domain.Ticket;

public class TicketMenuView {

	Scanner keyboard;

	public TicketMenuView() {

		keyboard = new Scanner(System.in);

	}
	
	//이용권 메뉴
	public void ticketMenu() {

		while(true) {

			System.out.println("\n[이용권관리모드]");
			System.out.print("[1.이용권 등록 2.이용권 수정 3.이용권 삭제 0.이전메뉴] : ");
			int choiceTicketMenu = 0;

			try {
				
				choiceTicketMenu = keyboard.nextInt();
				
			} catch (TypeMismatchException e) {
				
				keyboard = new Scanner(System.in);
				
			}
			
			if(choiceTicketMenu == 1) {

				Controllers.getTicketController().gotoTicketRegister();

			} else if(choiceTicketMenu == 2) {

				Controllers.getTicketController().gotoTicketUpdate();

			} else if(choiceTicketMenu == 3) {

				Controllers.getTicketController().gotoTicketDelete();

			} else if(choiceTicketMenu == 0) {

				if(Controllers.getLoginController().requestCheckMaster()) {

					Controllers.getAdminController().goToMAdminMenu();

				} else {

					Controllers.getAdminController().goToAdminMenu();
					
				}
			} else {
				
				System.out.println("잘못입력하셨습니다 다시 선택해주세요.");
				
			}

		}
		
	}

	public void ticketList(ArrayList<Ticket> ticketInfos) {

		System.out.println("\n번호\t이용권명\t\t가격\t기한\t이용권 설명");

		for(int i = 0; i < ticketInfos.size(); i++) {
			
			System.out.print(ticketInfos.get(i).getTicketNumber() + "\t");
			System.out.print(ticketInfos.get(i).getTicketName()+ "\t");
			System.out.print(ticketInfos.get(i).getPrice()+ "\t");
			System.out.print(ticketInfos.get(i).getExpirationDate()+ "\t");
			System.out.println(ticketInfos.get(i).getTicketComment());
			
		}

		Controllers.getTicketController().goToTicketMenuView();

	}

	public void ticketRegisterMenu() {

		System.out.println("\n[이용권 등록]");
		System.out.print("1.이용권명 : ");
		String ticketName = keyboard.next();
		System.out.print("2.이용권 가격 : ");

		int price = 0;
		
		while(true){
			try {

				price = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}

		System.out.print("3.이용권 기한 : ");
		
		int expirationDate = 0;
		
		while(true){
			try {

				expirationDate = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");
				
			} 
		}
		
		System.out.print("4.이용권 설명 : ");
		String ticketComment = keyboard.next();

		Ticket ticketInfo = new Ticket(ticketName, price, expirationDate, ticketComment);

		Controllers.getTicketController().requestTicketRegister(ticketInfo);

	}

	public void ticketUpdateMenu() {

		System.out.println("\n[이용권 수정]");
		System.out.print("이용권번호를 입력하세요 : ");
		int inputTicketNumber = 0;
		
		while(true){
			try {

				inputTicketNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}

		boolean canMake = Controllers.getTicketController().requestCheckNumber(inputTicketNumber);

		if(!canMake) {
			
			System.out.println("찾으시는 번호가 없습니다.");
			
		} else {

			System.out.print("1.이용권명 : ");
			String ticketName = keyboard.next();

			int price = 0;
			
			while(true){
				try {

					price = keyboard.nextInt();
					break;

				} catch (InputMismatchException e) {

					keyboard = new Scanner(System.in);
					System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

				} 
			}

			System.out.print("3.이용권 기한 : ");
			
			int expirationDate = 0;
			
			while(true){
				try {

					expirationDate = keyboard.nextInt();
					break;

				} catch (InputMismatchException e) {

					keyboard = new Scanner(System.in);
					System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

				} 
			}
			System.out.print("4.이용권 설명 : ");
			String ticketComment = keyboard.next();

			Ticket ticketInfo = new Ticket(inputTicketNumber, ticketName, price, expirationDate, ticketComment);
			Controllers.getTicketController().requestUpdateTicket(ticketInfo);

		}
		
	}

	public void ticketDeleteMenu() {

		System.out.println("\n[이용권 삭제]");
		System.out.print("이용권번호를 입력하세요 : ");

		int inputTicketNumber = 0;
		
		while(true){
			try {

				inputTicketNumber = keyboard.nextInt();
				break;

			} catch (InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.print("잘못입력하셨습니다. 다시 입력해주세요 : ");

			} 
		}
		
		boolean canMake = Controllers.getTicketController().requestCheckNumber(inputTicketNumber);

		if(!canMake) {
			
			System.out.println("찾으시는 번호가 없습니다.");
			
		} else {

			System.out.print("정말 삭제하시겠습니까?(y/press any key) : ");
			char question = keyboard.next().charAt(0);

			if(question == 'y') {

				boolean success = Controllers.getTicketController().requestDeleteTicket(inputTicketNumber);

				if(success) {
					
					System.out.println("삭제에 성공하였습니다.");
					
				} else {
					
					System.out.println("삭제에 실패하였습니다.");
					
				}
				
			} else {

				System.out.println("이용권을 삭제하지 않습니다.");
				
			}
			
		}

		Controllers.getTicketController().requestTicketList();

	}
	
}