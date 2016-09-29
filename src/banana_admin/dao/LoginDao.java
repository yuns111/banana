package banana_admin.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import banana_admin.controller.Controllers;
import banana_admin.domain.Login;
import banana_admin.repository.LoginRepository;

public class LoginDao {

	public LoginDao() {
		new LoginRepository();
	}

	public boolean insert(Login login){

		boolean success = false;
		String userPassword = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			//아이디랑 비밀번호 체크
			String sql = "select ADMINPASSWORD from banana_admin where adminID = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, login.getLoginId());
			rs = pstmt.executeQuery();

			while(rs.next()){

				userPassword = rs.getString(1);
			}

			if(userPassword.equals(login.getLoginPassword())){
				//맞으면 repository에 넣기
				success = true;
				LoginRepository.getLogin().setLoginId(login.getLoginId());
				LoginRepository.getLogin().setLoginPassword(login.getLoginPassword());
			}

		} catch(SQLException e){

			System.out.println("SQL문장이 잘못되었습니다.");	

		} finally{

			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}

		return success;
	}

	public int checkGrade(){

		int grade = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			//아이디랑 비밀번호 체크
			String sql = "select adminGrade from banana_admin where adminId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());

			rs = pstmt.executeQuery();

			while(rs.next()){

				grade = rs.getInt(1);
			}

		} catch(SQLException e){

			System.out.println("SQL문장이 잘못되었습니다.");	

		} finally{

			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}

		return grade;
	}

	public boolean delete(){

		boolean success = false;
		LoginRepository.getLogin().setLoginId(null);
		LoginRepository.getLogin().setLoginPassword(null);
		success = true;
		return success;
	}

}
