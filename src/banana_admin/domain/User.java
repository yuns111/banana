package banana_admin.domain;

public class User {

	private int userNumber;
	private String userId;
	private String userPassword;
	private String userName;
	private String userGender;
	private String userPhoneNumber; 
	
	public User() {
	
	}

	//회원 정보 보기 시 사용
	public User(int userNumber, String userId, String userPassword, String userName) {
		
		this.userNumber = userNumber;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		
	}
	//회원 정보 수정 시 사용
	public User(int userNumber,String userPassword, String userName,String userGender,String userPhoneNumber) {
		
		this.userNumber = userNumber;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender=userGender;
		this.userPhoneNumber=userPhoneNumber;
	}


	public int getUserNumber() {
		
		return userNumber;
		
	}

	public void setUserNumber(int userNumber) {
		
		this.userNumber = userNumber;
		
	}

	public String getUserId() {
		
		return userId;
		
	}

	public void setUserId(String userId) {
		
		this.userId = userId;
		
	}

	public String getUserPassword() {
		
		return userPassword;
		
	}

	public void setUserPassword(String userPassword) {
		
		this.userPassword = userPassword;
		
	}

	public String getUserName() {
		
		return userName;
		
	}

	public void setUserName(String userName) {
		
		this.userName = userName;
		
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	
	
}