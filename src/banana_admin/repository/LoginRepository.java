package banana_admin.repository;
import banana_admin.domain.Login;

public class LoginRepository {
	
	private static Login login;

	public LoginRepository() {
		login = new Login();
	}

	public static Login getLogin() {
		return login;
	}

}