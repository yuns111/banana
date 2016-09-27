package banana_admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import banana_admin.controller.Controllers;
import banana_admin.domain.Admin;
import banana_admin.view.AlertView;

public class AdminDao {

	public AdminDao() {

	}

	//관리자 등록
	public boolean insertAdmin(Admin adminDomain){

		boolean success = false;
		PreparedStatement pstmt1 = null; PreparedStatement pstmt2 = null; PreparedStatement pstmt3 = null;
		ResultSet rs1 = null; ResultSet rs2 = null; ResultSet rs3 = null;


		try {
			
			String adminid = adminDomain.getAdminID();
			
			//유저 아이디 중복확인
			String sql1 = "select * from banana_user where userId = ?";
			pstmt1 = Controllers.getProgramController().getConnection().prepareStatement(sql1);
			pstmt1.setString(1, adminid);
			rs1 = pstmt1.executeQuery();
			
			//관리자아이디 중복확인
			String sql2 = "select * from banana_admin where adminId = ?";
			pstmt2 = Controllers.getProgramController().getConnection().prepareStatement(sql2);
			pstmt2.setString(1, adminid);
			rs2 = pstmt2.executeQuery();
			
			if(rs1.next() || rs2.next()){
				new AlertView().alert("이미 아이디가 있습니다.");
				
			} else {

				String sql3 = "insert into banana_admin values(banana_admin_adminnumber_seq.nextval,?,?,?,2)";
				pstmt3 = Controllers.getProgramController().getConnection().prepareStatement(sql3);
				
				pstmt3.setString(1, adminDomain.getAdminID());
				pstmt3.setString(2, adminDomain.getAdminPassword());
				pstmt3.setString(3, adminDomain.getAdminName());
				
				int result = pstmt3.executeUpdate();

				if(result != 0){
					success = true;
				}
			}

		} catch (SQLException e) {
			AlertView alertView = new AlertView();
			alertView.alert("관리자 등록 시 오류가 발생했습니다.");
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

	//관리자 목록
	public ArrayList<Admin> adminSelectAll() {

		ArrayList<Admin> adminSelectAll = new ArrayList<Admin>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from banana_admin";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Admin admin = new Admin();
				admin.setAdminNumber(rs.getInt("adminNumber"));
				admin.setAdminID(rs.getString("adminID"));
				admin.setAdminPassword(rs.getString("adminPassword"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminGrade(rs.getInt("adminGrade"));
				adminSelectAll.add(admin);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			} if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return adminSelectAll;

	}


	//관리자 수정
	public boolean updateAdmin(Admin updateAdminAllInfo) {

		boolean success = false;
		Statement stmt = null;	

		try {
			String sql = "update banana_admin set adminID" + updateAdminAllInfo.getAdminID() +
					"', adminPassword = '" + updateAdminAllInfo.getAdminPassword() +
					"', adminName = " + updateAdminAllInfo.getAdminName() +
					"' where adminNumber =" + updateAdminAllInfo.getAdminNumber();

			stmt = Controllers.getProgramController().getConnection().createStatement();



			int result = stmt.executeUpdate(sql);

			if(result != 0) {
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return success;

	}

	//관리자 삭제
	public boolean deleteAdmin(int searchDeleteAdminNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "delete from banana_admin where adminNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);

			pstmt.setInt(1, searchDeleteAdminNumber);

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
