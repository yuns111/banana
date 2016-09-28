package banana_admin.controller;

import java.util.ArrayList;

import banana_admin.dao.TicketDao;
import banana_admin.domain.Ticket;
import banana_admin.view.AlertView;
import banana_admin.view.TicketMenuView;

public class TicketController {

	TicketDao ticketDao;

	public TicketController() {

		ticketDao = new TicketDao();
	}

	public void goToTicketMenuView(){
		TicketMenuView ticketMenuView = new TicketMenuView();
		ticketMenuView.ticketMenu();
	}
	
	public void goToTicketList(){
		TicketMenuView ticketMenuView = new TicketMenuView();
		ticketMenuView.ticketList();
	}
	
	public void requestTicketRegister(Ticket ticketInfo){

		//다오로 정보 전달
		boolean success = ticketDao.ticketRegister(ticketInfo);

		if(success){
			AlertView alert = new AlertView();
			alert.alert("이용권 등록에 성공하였습니다.");
		} else {
			System.out.println("이용권 등록에 실패하였습니다.");
		}
	}

	public ArrayList<Ticket> requestTicketList(){

		ArrayList<Ticket> ticketInfos = ticketDao.ticketList();

		return ticketInfos;
	}
	
	public boolean requestCheckNumber(int inputTicketNumber){
		boolean canMake= ticketDao.checkTicketNumber(inputTicketNumber);

			return canMake;
	}
	
	public void requestUpdateTicket(Ticket ticketInfo){

		boolean success = ticketDao.updateTicket(ticketInfo);
		
		if(success){
			System.out.println("정보 수정이 성공적으로 이루어졌습니다.");
		} else {
			System.out.println("정보 수정에 실패하였습니다.");
		}
	}

	public boolean requestDeleteTicket(int inputTicketNumber){
		boolean success = ticketDao.deleteTicket(inputTicketNumber);
		
		return success;
	}
}
