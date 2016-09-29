package banana_admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import banana_admin.controller.Controllers;
import banana_admin.domain.User;

public class UserDao {

	public UserDao() {

	}


	//회원 수정 Dao 메서드
	public boolean updateUserInfo(User user) {

		boolean success = false;
		PreparedStatement pstmt = null;

		int result = 0;

		try {

			String sql = "update banana_user set userPassword=?,userName = ?,userGender=?,userPhoneNumber=? where userNumber=? ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1,user.getUserPassword());
			pstmt.setString(2,user.getUserName());
			pstmt.setString(3,user.getUserGender());
			pstmt.setString(4,user.getUserPhoneNumber());
			pstmt.setInt(5,user.getUserNumber());
			result = pstmt.executeUpdate();

			if(result != 0) {
				success = true;
			}			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;

	}

	//회원 삭제 Dao 메서드
	public boolean deleteUser(int userNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;

		int result = 0;

		try {

			String sql = "delete from banana_user where userNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1,userNumber);
			result = pstmt.executeUpdate();

			if(result != 0) {
				success = true;
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return success;

	}
	
	//회원 조회 메서드
	public User selectOneUser(int userNumber){
		User user=new User();

		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {

			String sql = "select * from banana_user where userNumber=?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, userNumber);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserGender(rs.getString("userGender"));
				user.setUserPhoneNumber(rs.getString("userPhoneNumber"));
			}						
			pstmt.executeUpdate();		

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	//회원 모든 리스트
	public ArrayList<User> AllUserList(){
				
		Statement stmt = null;
		ResultSet rs=null;
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select * from banana_user";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				User user=new User();
				
				user.setUserNumber(rs.getInt("userNumber"));
				user.setUserId(rs.getString("userId"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserName(rs.getString("userName"));
				user.setUserGender(rs.getString("userGender"));
				user.setUserPhoneNumber(rs.getString("userPhoneNumber"));
				userList.add(user);
			}						


		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return userList;

	}


}