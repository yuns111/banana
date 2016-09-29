package banana_admin.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import banana_admin.controller.Controllers;
import banana_admin.domain.Stats;

public class StatsDao {

	public StatsDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Stats> statsDaySalesMoney(){

		String day = null;
		String daySumPrice = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Stats> Statss = new ArrayList<Stats>();

		try {
			String sql = "SELECT STARTDATE , SUM(PRICE) FROM PURCHASETICKET GROUP BY STARTDATE ORDER BY STARTDATE";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				day = rs.getString(1);
				daySumPrice = rs.getString(2);			
				Stats st = new Stats(day,daySumPrice);
				Statss.add(st);
			}

		} catch(SQLException e){
			System.out.println();
		}

		return Statss;
	}


	public ArrayList<Stats> statsGenderMusicPattern(){

		String emotionName = null;
		int rank = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Stats> Statss = new ArrayList<Stats>();

		try {
			String sqlM = "SELECT RANK() OVER (order by pattern.emotionCount desc) rank,e.EMOTIONNAME from pattern, emotion e where pattern.USERGENDER = 'M' and pattern.EMOTIONNUMBER = e.EMOTIONNUMBER";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sqlM);
			rs = pstmt.executeQuery();

			while(rs.next()){
				rank = rs.getInt(1);
				emotionName = rs.getString(2);
				Stats st = new Stats("남성",emotionName, rank);
				Statss.add(st);
			}
			
			String sqlF = "SELECT RANK() OVER (order by pattern.emotionCount desc) rank,e.EMOTIONNAME from pattern, emotion e where pattern.USERGENDER = 'F' and pattern.EMOTIONNUMBER = e.EMOTIONNUMBER";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sqlF);
			rs = pstmt.executeQuery();

			while(rs.next()){
				rank = rs.getInt(1);
				emotionName = rs.getString(2);
				Stats st = new Stats("여성",emotionName, rank);
				Statss.add(st);
			}
			
		} catch(SQLException e){
			System.out.println();
		}

		return Statss;
	}

}
