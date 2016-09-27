package banana_admin.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import banana_admin.controller.Controllers;

public class EmotionDao {
	
	public EmotionDao() {
		
	}
	
	public boolean insertRegisterEmotion(String emotionName){
		
		boolean success = false;
		PreparedStatement pstmt = null;
		
		String sql = "insert into emotion (emotion_seq.nextval,?)";
		
		try {
			
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, emotionName);
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				success = true;
			}
			
		} catch (SQLException e) {
			System.out.println("감정등록시 오류가 있습니다.");
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return success;
	}
	

}
