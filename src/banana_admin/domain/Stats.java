package banana_admin.domain;

public class Stats {
	
	private String day;
	private String daySumPrice;
	private String emotionName;
	private int rank;
	private String gender;
	
	public Stats(String day, String daySumPrice) {
		this.day = day;
		this.daySumPrice = daySumPrice;
	}

	public Stats(String gender,String emotionName, int rank) {
		this.gender = gender;
		this.emotionName = emotionName;
		this.rank = rank;
	}

	public String getDay() {
		return day;
	}

	public String getDaySumPrice() {
		return daySumPrice;
	}

	public String getEmotionName() {
		return emotionName;
	}

	public int getRank() {
		return rank;
	}

	public String getGender() {
		return gender;
	}	
		
}
