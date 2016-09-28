package banana_admin.domain;

public class AdminDomain {
/*	create table admin(
			  
			  adminNumber int primary key,
			  adminID varchar2(20) unique,
			  adminPassword varchar2(20) check(length(userPassword)>=5),
			  adminName varchar2(20),
			  adminGrade int,
			  constraint admin_fk_g foreign key(adminGrade) references Grade(gradeNumber)
			);*/
	
	int adminNumber;
	String adminID;
	String adminPassword;
	String adminName;
	int adminGrade;
	
	public AdminDomain(String adminID, String adminPassword, String adminName) {
		this.adminID = adminID;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
	}
	
	

	public AdminDomain(int adminNumber, String adminID, String adminPassword, String adminName, int adminGrade) {
		this.adminNumber = adminNumber;
		this.adminID = adminID;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
		this.adminGrade = adminGrade;
	}



	public int getAdminNumber() {
		return adminNumber;
	}



	public int getAdminGrade() {
		return adminGrade;
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
	
	
	

}
