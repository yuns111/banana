package banana_admin.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import banana_admin.controller.Controllers;
import banana_admin.domain.Ticket;

public class TicketMenuView {

	Scanner keyboard;
	
	public TicketMenuView() {
		
		keyboard = new Scanner(System.in);
		
	}
	//이용권 메뉴
	public void ticketMenu(){

		while(true){
			
			Controllers.getTicketController().goToTicketList();
			
			System.out.println("이용권 관리");
			System.out.println("1.이용권 등록 2.이용권 수정 3.이용권 삭제");
			int choiceTicketMenu = keyboard.nextInt();

			if(choiceTicketMenu == 1){
				this.ticketRegisterMenu();
			} else if(choiceTicketMenu == 2){
				this.ticketUpdateMenu();
			} else if(choiceTicketMenu == 3){
				this.ticketDeleteMenu();
			} else{try {} catch (InputMismatchException e) {} finally {
				System.out.println("잘못입력하셨습니다.");
			}
			}

		}
	}

	public void ticketList(){
		System.out.println("이용권 번호\t이용권명\t\t이용권 가격\t이용권 기한\t이용권 설명");
		ArrayList<Ticket> ticketInfos = Controllers.getTicketController().requestTicketList();

		for(int i = 0; i< ticketInfos.size();i++){
			System.out.print(ticketInfos.get(i).getTicketNumber() + "\t");
			System.out.print(ticketInfos.get(i).getTicketName()+ "\t");
			System.out.print(ticketInfos.get(i).getPrice()+ "\t");
			System.out.print(ticketInfos.get(i).getExpirationDate()+ "\t");
			System.out.println(ticketInfos.get(i).getTicketComment());
		}
	}


	public void ticketRegisterMenu(){

		Controllers.getTicketController().goToTicketList();

		System.out.println("이용권 등록");
		System.out.print("1.이용권명:");
		String ticketName = keyboard.next();
		System.out.print("2.이용권 가격:");
		int price = keyboard.nextInt();
		System.out.print("3.이용권 기한:");
		int expirationDate = keyboard.nextInt();
		System.out.print("4.이용권 설명:");
		String ticketComment = keyboard.next();

		Ticket ticketInfo = new Ticket(ticketName, price, expirationDate, ticketComment);
		Controllers.getTicketController().requestTicketRegister(ticketInfo);

	}


	public void ticketUpdateMenu(){

		Controllers.getTicketController().goToTicketList();

		System.out.println("이용권 수정");
		System.out.println("이용권번호를 입력하세요.");
		int inputTicketNumber = keyboard.nextInt();

		boolean canMake = Controllers.getTicketController().requestCheckNumber(inputTicketNumber);

		if(!canMake){
			System.out.println("찾으시는 번호가 없습니다.");
		} else {

			System.out.print("1.이용권명:");
			String ticketName = keyboard.next();
			System.out.print("2.이용권 가격:");
			int price = keyboard.nextInt();
			System.out.print("3.이용권 기한:");
			int expirationDate = keyboard.nextInt();
			System.out.println("4.이용권 설명:");
			String ticketComment = keyboard.next();

			Ticket ticketInfo = new Ticket(inputTicketNumber, ticketName, price, expirationDate, ticketComment);
			Controllers.getTicketController().requestUpdateTicket(ticketInfo);

		}
	}

	public void ticketDeleteMenu(){

		Controllers.getTicketController().goToTicketList();

		System.out.println("이용권 삭제");
		System.out.println("이용권번호를 입력하세요.");

		int inputTicketNumber = keyboard.nextInt();

		boolean canMake = Controllers.getTicketController().requestCheckNumber(inputTicketNumber);

		if(!canMake){
			System.out.println("찾으시는 번호가 없습니다.");
		} else {

			System.out.println("정말 삭제하시겠습니까?y/press any key");
			char question = keyboard.next().charAt(0);

			if(question == 'y'){
				boolean success = Controllers.getTicketController().requestDeleteTicket(inputTicketNumber);
				if(success){
					System.out.println("삭제에 성공하였습니다.");
				} else {
					System.out.println("삭제에 실패하였습니다.");
				}
			} else {

			}
		}

	}
}
