package banana_admin.domain;

public class Admin {
	
	private int adminNumber;
	private String adminID;
	private String adminPassword;
	private String adminName;
	private int adminGrade;
	
	public Admin() {
		
	}

	public Admin(int adminNumber, String adminID, String adminPassword, String adminName, int adminGrade) {
		this.adminNumber = adminNumber;
		this.adminID = adminID;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
		this.adminGrade = adminGrade;
	}

	public int getAdminNumber() {
		return adminNumber;
	}

	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int getAdminGrade() {
		return adminGrade;
	}

	public void setAdminGrade(int adminGrade) {
		this.adminGrade = adminGrade;
	}

}
