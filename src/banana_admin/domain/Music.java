package banana_admin.domain;

public class Music {

	private int musicNumber;
	private String title;
	private String singer;
	private String lyrics;
	private int emotionNumber;
	private int playingCount;

	public Music() {

	}

	public Music(String title, String singer, String lyrics, int emotionNumber, int playingCount) {
		this.title = title;
		this.singer = singer;
		this.lyrics = lyrics;
		this.emotionNumber = emotionNumber;
		this.playingCount = playingCount;
	}

	//음원등록에 필요
	public Music(String title, String singer, String lyrics, int emotionNumber) {
		this.title = title;
		this.singer = singer;
		this.lyrics = lyrics;
		this.emotionNumber = emotionNumber;
	}

	//음원수정에 필요
	public Music(int musicNumber,String title, String singer, String lyrics, int emotionNumber) {
		this.musicNumber = musicNumber;
		this.title = title;
		this.singer = singer;
		this.lyrics = lyrics;
		this.emotionNumber = emotionNumber;
	}

	//음원조회에 필요
	public Music(int musicNumber, String title, String singer, int emotionNumber, int playingCount) {
		this.musicNumber = musicNumber;
		this.title = title;
		this.singer = singer;
		this.emotionNumber = emotionNumber;
		this.playingCount = playingCount;
	}

	public int getMusicNumber() {
		return musicNumber;
	}

	public void setMusicNumber(int musicNumber) {
		this.musicNumber = musicNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public int getEmotionNumber() {
		return emotionNumber;
	}

	public void setEmotionNumber(int emotionNumber) {
		this.emotionNumber = emotionNumber;
	}

	public int getPlayingCount() {
		return playingCount;
	}

	public void setPlayingCount(int playingCount) {
		this.playingCount = playingCount;
	}

}