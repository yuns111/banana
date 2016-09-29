package banana_admin.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import banana_admin.controller.Controllers;

public class StatsDao {

	public StatsDao() {
		// TODO Auto-generated constructor stub
	}

	public String statsDaySalesMoney(){

		String daySalesMoney = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs.next()){
				daySalesMoney = rs.getString(1);
			}
		} catch(SQLException e){
			System.out.println();
		}


		return daySalesMoney;
	}

	public String statsSexMusicPattern(){

		String sexMusicPattern = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				sexMusicPattern = rs.getString(1);
			}
		} catch(SQLException e){
			System.out.println();
		}


		return sexMusicPattern;
	}

}
