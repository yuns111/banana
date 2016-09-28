package banana_admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import banana_admin.controller.Controllers;
import banana_admin.domain.AdminDomain;
import banana_admin.view.AlertView;

public class AdminDao {

	
	public boolean insertAdmin(AdminDomain adminDomain){
		boolean success = false;
		PreparedStatement pstmt1 = null; PreparedStatement pstmt2 = null; PreparedStatement pstmt3 = null;
		ResultSet rs1 = null; ResultSet rs2 = null; ResultSet rs3 = null;
		
		
		try {
			String adminid = adminDomain.getAdminID();
			String sql1 = "select * from banana_user where userId = ?";
			pstmt1 = Controllers.getProgramController().getConnection().prepareStatement(sql1);
			pstmt1.setString(1, adminid);
			rs1 = pstmt1.executeQuery();
			
			String sql2 = "select * from banana_admin where adminId = ?";
			pstmt2 = Controllers.getProgramController().getConnection().prepareStatement(sql2);
			pstmt2.setString(1, adminid);
			rs2 = pstmt2.executeQuery();
			
			if(rs1.next() || rs2.next()){
				new AlertView().alertView("이미 아이디가 있습니다.");
			} else {
				
			String sql3 = "insert into banana_admin values(banana_admin_adminnumber_seq,?,?,?,2";
				pstmt3 = Controllers.getProgramController().getConnection().prepareStatement(sql3);
				pstmt3.setString(2, adminDomain.getAdminID());
				pstmt3.setString(3, adminDomain.getAdminPassword());
				pstmt3.setString(4, adminDomain.getAdminName());
				int result = pstmt3.executeUpdate();
				
				if(result != 0){
					success = true;
				}
			}
			
		} catch (SQLException e) {
			AlertView alertView = new AlertView();
			alertView.alertView("관리자 등록 시 오류가 발생했습니다.");
			e.printStackTrace();
		} finally {
			if(pstmt3 != null){
				try {pstmt3.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs3 != null){
				try {rs3.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt2 != null){
				try {pstmt2.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs2 != null){
				try {rs2.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt1 != null){
				try {pstmt1.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs1 != null){
				try {rs1.close();} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return success;
		
	}
	
	
	public ArrayList<AdminDomain> selectAllAdmin(){
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<AdminDomain> adminInfo = new ArrayList<AdminDomain>();
		
		
		try {
			String sql = "select * from banana_admin";
			stmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int adminNumber = rs.getInt("adminNumber");
				String adminID = rs.getString("adminID");
				String adminPassword = rs.getString("adminPassword");
				String adminName = rs.getString("adminName");
				int adminGrade = rs.getInt("adminGrade");
				
				AdminDomain adminDomain = new AdminDomain(adminNumber, adminID, adminPassword, adminName, adminGrade);
				adminInfo.add(adminDomain);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null){try { stmt.close();} catch (SQLException e) {e.printStackTrace();}
			}
			if(rs != null){try { rs.close();} catch (SQLException e) {e.printStackTrace();}
			}
		}
		
		return adminInfo; 
	}
	
}
