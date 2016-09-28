package banana_admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import banana_admin.controller.Controllers;
import banana_admin.domain.Ticket;
import banana_admin.view.AlertView;
import javafx.scene.control.Alert;

public class TicketDao {

	public TicketDao() {
		// TODO Auto-generated constructor stub
	}

	public boolean ticketRegister(Ticket ticketInfo){
		boolean success = false;
		PreparedStatement pstmt1 = null; 		
		PreparedStatement pstmt2 = null;
		int result = 0;
		ResultSet rs1 = null;

		try {

			String sql1 = "select ticketName from ticket where ticketname = ?";
			pstmt1 = Controllers.getProgramController().getConnection().prepareStatement(sql1);
			pstmt1.setString(1, ticketInfo.getTicketName());
			rs1 = pstmt1.executeQuery();

			if(rs1 == null){
				AlertView alertView = new AlertView();
				alertView.alert("동일한 이용권명이 있습니다");

			} else {

				String sql2 = "insert into Ticket values(ticket_ticketnumber_seq.nextval,?,?,?,?)";
				pstmt2 = Controllers.getProgramController().getConnection().prepareStatement(sql2);
				pstmt2.setString(1, ticketInfo.getTicketName());
				pstmt2.setInt(2, ticketInfo.getPrice());
				pstmt2.setInt(3, ticketInfo.getExpirationDate());
				pstmt2.setString(4, ticketInfo.getTicketComment());
				result = pstmt2.executeUpdate();

				if(result != 0){
					success = true;
				}
			}

		} catch (SQLException e) {
			System.out.println("쿼리 이상");
		} finally {
			if(pstmt1 != null){
				try { pstmt1.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt2 != null){
				try { pstmt2.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs1 != null){
				try { rs1.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return success;

	}

	public ArrayList<Ticket> ticketList(){
		ArrayList<Ticket> ticketInfos= new ArrayList<Ticket>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from ticket";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				int ticketNumber = rs.getInt("ticketNumber");
				String ticketName = rs.getString("ticketname");
				int price = rs.getInt("price");
				int expirationDate = rs.getInt("expirationDate");
				String ticketComment = rs.getString("ticketComment");
				Ticket ticketInfo = new Ticket(ticketNumber, ticketName, price, expirationDate, ticketComment);
				ticketInfos.add(ticketInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
				try { rs.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try { pstmt.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ticketInfos;
	}


	public boolean checkTicketNumber(int inputTicketNumber){
		boolean canMake = true;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select ticketnumber from ticket where ticketnumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, inputTicketNumber);
			rs = pstmt.executeQuery();

			if(rs == null){//있는 경우 
				canMake = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
				try { rs.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try { pstmt.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return canMake;
	}


	public boolean updateTicket(Ticket ticketInfo){
		boolean success = false;
		PreparedStatement pstmt = null; 		
		int result = 0;

		try {

			String sql = "update ticket set ticketname = ?, price = ?, expirationdate = ?, ticketcomment = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, ticketInfo.getTicketName());
			pstmt.setInt(2, ticketInfo.getPrice());
			pstmt.setInt(3, ticketInfo.getExpirationDate());
			pstmt.setString(4, ticketInfo.getTicketComment());
			result = pstmt.executeUpdate();

			if(result != 0){
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null){
				try { pstmt.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return success;
	}

	public boolean deleteTicket(int inputTicketNumber){
		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "delete from ticket where ticketNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, inputTicketNumber);

			result = pstmt.executeUpdate();

			if(result != 0) {
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;
	}
}
