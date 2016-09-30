package banana_admin.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import banana_admin.controller.Controllers;
import banana_admin.domain.Stats;

public class StatsDao {

	public StatsDao() {

	}

	//일별 매출액
	public ArrayList<Stats> statsDaySalesMoney() {

		String day = null;
		int daySumPrice = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Stats> Statss = new ArrayList<Stats>();

		try {
			
			String sql = "SELECT STARTDATE , SUM(PRICE) FROM PURCHASETICKET GROUP BY STARTDATE ORDER BY STARTDATE";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				day = rs.getString(1);
				daySumPrice = rs.getInt(2);		
				Stats st = new Stats(day,daySumPrice);
				Statss.add(st);
				
			}

		} catch(SQLException e) {
			
			System.out.println("SQL 문장 에러");
			
		} finally {

			if(pstmt != null) {
				
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			} if(rs != null) {
				
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}

		}

		return Statss;
		
	}

	//총 매출액
	public int totalSumPrice() {

		int totalSumPrice = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			String sql = "select sum(price) from PURCHASETICKET";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				
				totalSumPrice = rs.getInt(1);
				
			}

		} catch(SQLException e) {
			
			System.out.println("SQL 문장 에러");
			
		} finally {

			if(pstmt != null) {
				
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			} if(rs != null) {
				
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}

		}

		return totalSumPrice;

	}

	//성별 음악패턴
	public ArrayList<Stats> statsGenderMusicPattern() {

		String emotionName = null;
		int rank = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Stats> Statss = new ArrayList<Stats>();

		//쿼리 내 pattern은 뷰
		try {
			
			String sqlM = "SELECT RANK() OVER (order by pattern.emotionCount desc) rank,e.EMOTIONNAME from pattern, emotion e where pattern.USERGENDER = 'M' and pattern.EMOTIONNUMBER = e.EMOTIONNUMBER";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sqlM);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				rank = rs.getInt(1);
				emotionName = rs.getString(2);
				Stats st = new Stats("남성",emotionName, rank);
				
				Statss.add(st);
				
			}

			rs.close();
			pstmt.close();
			
			String sqlF = "SELECT RANK() OVER (order by pattern.emotionCount desc) rank,e.EMOTIONNAME from pattern, emotion e where pattern.USERGENDER = 'F' and pattern.EMOTIONNUMBER = e.EMOTIONNUMBER";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sqlF);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				rank = rs.getInt(1);
				emotionName = rs.getString(2);
				Stats st = new Stats("여성",emotionName, rank);
				
				Statss.add(st);
				
			}

		} catch(SQLException e) {
			
			System.out.println("SQL 문장 에러");
			
		} finally {

			if(pstmt != null) {
				
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			} if(rs != null) {
				
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
				
			}

		}

		return Statss;
		
	}

}