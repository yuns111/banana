package banana_admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import banana_admin.controller.Controllers;
import banana_admin.domain.Emotion;

public class EmotionDao {
	
	public EmotionDao() {
		
	}
	
	//감정등록메서드
	public boolean insertRegisterEmotion(String emotionName){
		
		boolean success = false;
		PreparedStatement pstmt = null;
		
		String sql = "insert into emotion values(emotion_seq.nextval,?)";
		
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
	
	//감정전체목록호출메서드
	public ArrayList<Emotion> selectAllEmotion(){
		
		ArrayList<Emotion> emotionList = new ArrayList<Emotion>();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from emotion";
		
		try {
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				
				Emotion emotion = new Emotion();
				
				emotion.setEmotionNumber(rs.getInt(1));
				emotion.setEmotionName(rs.getString(2));
				
				emotionList.add(emotion);
			}
			
			
		} catch (SQLException e) {
			System.out.println("감정리스트 호출시 오류가 있습니다.");
			e.printStackTrace();
		} finally {
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return emotionList;
	}
	
	//감정명 수정dao
	public boolean updateEmotion(Emotion updateEmotion){
		
		boolean success = false;
		
		PreparedStatement pstmt = null;
		String sql = "update Emotion set emotionName = ? where emotionNumber = ?";
		
		try {
			
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
		
			pstmt.setString(1, updateEmotion.getEmotionName());
			pstmt.setInt(2, updateEmotion.getEmotionNumber());
			
			int result = pstmt.executeUpdate();
			
			if(result != 0){
				success = true;
			}
			
		} catch (SQLException e) {
			System.out.println("감정수정시 오류가 있습니다.");
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
		}
		
		return success;
	}
	
	//감정 삭제 dao
	public boolean deleteEmotion(int deleteNumber){
		
		boolean success = false;
		
		Statement stmt = null;
		String sql = "delete from Emotion where EmotionNumber = "+deleteNumber;
		
		try {
			
			stmt = Controllers.getProgramController().getConnection().createStatement();
			int result = stmt.executeUpdate(sql);
			
			if(result != 0){
				success = true;
			}
			
		} catch (SQLException e) {
			System.out.println("감정삭제시 오류가 있습니다.");
			e.printStackTrace();
		}
		
		return success;
	}
	

}
