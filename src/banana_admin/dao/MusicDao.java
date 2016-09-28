package banana_admin.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import banana_admin.controller.Controllers;
import banana_admin.domain.Music;

public class MusicDao {

	public MusicDao() {

	}

	public boolean insertRegisterMusic(Music music) {

		PreparedStatement pstmt = null;
		boolean success = false;
		int result = 0;

		try {

			//음원 등록
			String sql = "insert into music(musicNumber, title, singer, lyrics, emotionNumber) values(music_musicnumber_seq.nextval, ?, ?, ?, ?)";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);

			pstmt.setString(1, music.getTitle());
			pstmt.setString(2, music.getSinger());
			pstmt.setString(3, music.getLyrics());
			pstmt.setInt(4, music.getEmotionNumber());
			result = pstmt.executeUpdate();

			if(result != 0) {
				success = true;
			}

		} catch (SQLException e) {

			System.out.println("음원 등록중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {

			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}

		return success;

	}

	//음원 삭제 Dao 메서드
	public boolean deleteMusic(int musicNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			String sql = "delete from music where musicNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1,musicNumber);
			result = pstmt.executeUpdate();

			if(result != 0) {
				success = true;
			}	

		} catch (SQLException e) {

			System.out.println("음원 삭제중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {

			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}		

		return success;

	}

	public Music selectOneMusic(int musicNumber) {

		Music music = new Music();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from music where musicNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, musicNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				music.setMusicNumber(rs.getInt("musicNumber"));
				music.setTitle(rs.getString("title"));
				music.setSinger(rs.getString("singer"));
				music.setEmotionNumber(rs.getInt("emotionNumber"));
				music.setPlayingCount(rs.getInt("playingCount"));
			}

		} catch (SQLException e) {

			System.out.println("음원 조회중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {

			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}		

		return music;

	}

	public ArrayList<Music> selectAllMusic() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Music> musicList = new ArrayList<Music>();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select * from music order by musicNumber";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				Music music = new Music();

				music.setMusicNumber(rs.getInt("musicNumber"));
				music.setTitle(rs.getString("title"));
				music.setSinger(rs.getString("singer"));
				music.setEmotionNumber(rs.getInt("emotionNumber"));
				music.setPlayingCount(rs.getInt("playingCount"));

				musicList.add(music);

			}						


		} catch (SQLException e) {

			System.out.println("음원 목록조회 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {

			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(stmt != null) {
				try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}

		return musicList;
	}

	//음원 수정 Dao 메서드
	public boolean updateMusic(Music music) {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			String sql = "update music set title = ?, singer = ?, lyrics = ?, emotionNumber = ? where musicNumber = ? ";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, music.getTitle());
			pstmt.setString(2, music.getSinger());
			pstmt.setString(3, music.getLyrics());
			pstmt.setInt(4, music.getEmotionNumber());
			pstmt.setInt(5, music.getMusicNumber());

			result = pstmt.executeUpdate();
			
			if(result != 0) {
				success = true;
			} 
			
		} catch (SQLException e) {

			System.out.println("음원 수정중 예외가 발생했습니다.");
			e.printStackTrace();

		} finally {

			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
			}

		}

		return success;
		
	}
	
}